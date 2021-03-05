package Exo9;

import java.util.function.Predicate;

public class PredicatesMain {

	public static void main(String[] args) {

		Predicate<String> pLength4 = (String s) -> s.length() > 4;
		
		String chaine = "Jungle";
		
		System.out.println("length of " + chaine + " > 4 ?   " + pLength4.test(chaine));
		
		Predicate<String> pNull = (String s) -> s == null;
		
		System.out.println( chaine + " is null ?   " + pLength4.test(chaine));
		
		Predicate<String> pStartJ = (String s) -> s.charAt(0) == 'J';

		System.out.println( chaine + " start with J ?   " + pStartJ.test(chaine));

		Predicate<String> pLength5 = (String s) -> s.length() == 5;		
	
		System.out.println( chaine + " is of length 5 ?   " + pLength5.test(chaine));

		Predicate<String> pL5StarJ = (String s) ->  pStartJ.test(s) == true ;
	
		System.out.println( chaine + " is of length 5 and starts with J ?   " + pLength5.test(chaine));

	}

}
