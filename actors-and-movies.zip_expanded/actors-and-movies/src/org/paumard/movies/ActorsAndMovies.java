package org.paumard.movies;

import org.paumard.movies.model.Actor;
import org.paumard.movies.model.Movie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;


public class ActorsAndMovies {

    public static void main(String[] args) {

        ActorsAndMovies actorsAndMovies = new ActorsAndMovies();
        Set<Movie> movies = actorsAndMovies.readMovies();
        
        //Question 1 
        System.out.println("movies.size()) = " + movies.size());

        //Question 2
        long nbrOfActors =
        movies.stream()
        		.flatMap(movie ->movie.actors().stream())
        		.distinct()
        		.count();
        System.out.println("nolbre d'acteurs : " + nbrOfActors);
        
        //Question 3
        
        long nbrYears = 
        movies.stream()
        	.map(movie -> movie.releaseYear())
        	.distinct()
        	.count();
        
        System.out.println("nuber of years = "  + nbrYears);
        
        // Question 4 
        long oldestMovieYear =
        movies.stream()
        	.map(movie -> movie.releaseYear())
        	.min(Comparator.naturalOrder()).orElseThrow();
        
        System.out.println("oldest movie year : " + oldestMovieYear );
        
        long earlistMovieYear =
        movies.stream()	
   		   	  .map(movie -> movie.releaseYear())
          	  .max(Comparator.naturalOrder()).orElseThrow();
		                
        System.out.println("earliest movie year : " + earlistMovieYear );
        
        //Question 5
        
       Integer max = movies.stream()
        	  .collect(Collectors.groupingBy(
        			  movie -> movie.releaseYear(),
        			  Collectors.mapping(movie -> movie.title(), Collectors.counting())))
        	  .entrySet()
        	  .stream().max(Comparator.comparing(entry -> entry.getValue())).orElseThrow().getKey();
        
        System.out.println(max);
        
        //Question 6
        
       Movie max2 = movies.stream()
       		 .max(Comparator.comparing(movie -> movie.actors().size())).orElseThrow();
        
        System.out.println(max2.title());
        
        
        //Question 7
         
        Actor actor = 
        movies.stream()
        	  .flatMap(movie -> movie.actors().stream())
											  .collect(
													  Collectors.groupingBy(
															  Function.identity(),
															  Collectors.counting())
													  ).entrySet().stream()
																  .max(Comparator.comparing(e -> e.getValue()))
																  .orElseThrow().getKey();
        
        System.out.println("mostPlayedMovies  :" + actor);
        
        
    }

    public Set<Movie> readMovies() {

        Function<String, Stream<Movie>> toMovie =
                line -> {
                    String[] elements = line.split("/");
                    String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
                    String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));
                    if (releaseYear.contains(",")) {
                        // Movies with a coma in their title are discarded
                    	int indexOfComa = releaseYear.indexOf(",");
                    	releaseYear = releaseYear.substring(0, indexOfComa);
//                        return Stream.empty();
                    }
                    Movie movie = new Movie(title, Integer.valueOf(releaseYear));


                    for (int i = 1; i < elements.length; i++) {
                        String[] name = elements[i].split(", ");
                        String lastName = name[0].trim();
                        String firstName = "";
                        if (name.length > 1) {
                            firstName = name[1].trim();
                        }

                        Actor actor = new Actor(lastName, firstName);
                        movie.addActor(actor);
                    }
                    return Stream.of(movie);
                };

        try (FileInputStream fis = new FileInputStream("actors-and-movies/files/movies-mpaa.txt.gz");
             GZIPInputStream gzis = new GZIPInputStream(fis);
             InputStreamReader reader = new InputStreamReader(gzis);
             BufferedReader bufferedReader = new BufferedReader(reader);
             Stream<String> lines = bufferedReader.lines();
        ) {

            return lines.flatMap(toMovie).collect(Collectors.toSet());

        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        return Set.of();
    }
}
