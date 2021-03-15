package org.snaoui.exo14;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class use_streams {

	public static void main(String[] args) {
		
		List <String> nbrs = List.of("one", "two" , "one", "three","foor","five","six","seven","eight","nine","ten", "eleven","twelve");

		Stream <String> strMap = nbrs.stream().map(string -> string);

		strMap.forEach(s ->System.out.println(s));
		
		
		List <String> maj = nbrs.stream()
			.map(str -> str.toUpperCase())
			.collect(Collectors.toList());
		
		System.out.println("\n nbrs in maj  " + maj);
		
		
		//V1
		NavigableSet <String> majFirstLetter = nbrs.stream()
				.map(str -> str.substring(0, 1).toUpperCase().concat(str.substring(1,str.length())))
				.collect(Collectors.toCollection(()-> new TreeSet<>()));
		
		
		System.out.println("\n nbrs Maj firsst letter  " + majFirstLetter);
	
		//V2
		String majFL = 
			nbrs.stream()
				.map(str -> str.substring(0, 1).toUpperCase().concat(str.substring(1,str.length())))
				.distinct()
				.collect(Collectors.joining(", ", "[", "]"));
		
		System.out.println("\n nbrs Maj firsst letter  " + majFL);

		String lengths = 
				nbrs.stream()
					.map(str -> (String) String.valueOf(str.length()))
					.distinct()
					.collect(Collectors.joining(", ", "[", "]"));
					
		System.out.println("\n nbrs lengths " + lengths);
		
		long nbrOfElements = 
				nbrs.stream()
					.count();

		System.out.println("\n nbrs of elements  " + nbrOfElements);
		
		long pairLengthList = 
				nbrs.stream()
					.filter(str -> str.length() % 2 == 0 )
					.count();
//					.distinct()
//					.collect(Collectors.joining(", ", "[", "]"));

		System.out.println("\n pair length elements  " + pairLengthList);

		Optional<Integer> longest = 
				nbrs.stream()
					.map(str -> str.length())
					.max(Comparator.naturalOrder());
					
		System.out.println("\n paLongest element length  " + longest);
	
		
		List<String> impairLengthMaj =
				nbrs.stream()
					.filter(str -> str.length() % 2 == 1)
					.map(str -> str.toUpperCase())
					.collect(Collectors.toList());
		
		System.out.println("\n Impaire length in Maj  " + impairLengthMaj);
		
		String fiveLengthConcat =
				nbrs.stream()
					.filter(str -> str.length() <= 5)
					.sorted(Comparator.naturalOrder())
					.collect(Collectors.joining(",", "{", "}"));
		
		System.out.println("\nfive Length ordered " + fiveLengthConcat);
		
		Map<Integer, List<String>> nbrsByLength = 
				nbrs.stream()
					.collect(Collectors.groupingBy(String::length));
		
		System.out.println("\nmap (length, words)  " + nbrsByLength);
		
		
		Map<Character, List<String>> nbrsByFirstLetter = nbrs.stream()
					.collect(Collectors.groupingBy(str -> str.charAt(0)));
		
		System.out.println("\nmap (length, words)  " + nbrsByFirstLetter);

	}

}
