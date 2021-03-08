package org.snaoui.exo12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class Usefunction {

	public static void main(String[] args) {
		

		List <String> nbrs = List.of("one", "two" , "three","foor","five","six","seven","eight","nine","ten", "eleven","twelve");

		List<String> nbrsSup4 = new ArrayList<> (nbrs); 
		
		nbrsSup4.forEach((String s) -> System.out.println(s));
		
		System.out.println("\n");

		nbrs.forEach((String s) -> nbrsSup4.removeIf((String a) -> a.length()>4));
		
		nbrsSup4.forEach(System.out::println);
		
		List<String> nbrsImpaires = new ArrayList<> (nbrs); 
		
		nbrs.forEach((String s) -> nbrsImpaires.removeIf((String a) -> a.length() % 2 ==0));
		
		System.out.println("\nQue les impaires :");
		
		nbrsImpaires.forEach((String s) -> System.out.println(s));
		
		List<String> nbrsMaj = new ArrayList<> ();
		
		nbrs.forEach((String s) -> nbrsMaj.add(s.toUpperCase()));
		
		System.out.println("\nMajuscule : ");
		
		nbrsMaj.forEach((String s) -> System.out.println(s));
		
		List<String> nbrsMajVowel = new ArrayList<> ();

		Predicate<String> maj = s -> "aeiou".contains(""+ s.charAt(0));
		
		UnaryOperator<String> majIfVowel = 
				s -> {
					if("aeiou".contains(""+ s.charAt(0)))
						return s.toUpperCase();
					else
						return s;
				};
		nbrs.forEach((String s) -> nbrsMajVowel.add(majIfVowel.apply(s)));
		
		
		nbrs.forEach((String s) -> nbrsMajVowel.add(s) );
				
		System.out.println("\nMajuscule si voyelle: \n");
		
		nbrsMajVowel.forEach((String s) -> System.out.println(s));
		
		Comparator<String> compLong = Comparator.comparing(String::length).thenComparing((s1,s2) -> s1.compareTo(s2));
		
		System.out.println("\nOrdered By Length: \n");
		
		List<String> orderByLength = new ArrayList<>(nbrs);
		orderByLength.sort(Comparator.comparing(s -> s.length()));
		orderByLength.forEach((String s) -> System.out.println(s));
		
		System.out.println("\nOrdered By Length Then Natural: \n");

		List<String> orderByLengthThenNatural = new ArrayList<>(nbrs);
		orderByLengthThenNatural.sort(Comparator.comparing(String::length).thenComparing((s1,s2) -> s1.compareTo(s2)));
		orderByLengthThenNatural.forEach((String s) -> System.out.println(s));
			

		
	}

}
