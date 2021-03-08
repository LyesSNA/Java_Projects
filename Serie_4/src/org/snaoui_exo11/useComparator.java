package org.snaoui_exo11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class useComparator {

	public static void main(String[] args) {
		
		Comparator<String> compLong = (s1,s2) -> s1.length() - s2.length();
		
		List <String> nbrs = Arrays.asList("one", "two" ,"three" , "foor" );
		
		nbrs.sort(compLong);
		nbrs.forEach((String s) -> System.out.println(s));
		
		Comparator<Personne> compLname = (p1, p2) -> p1.getNom().compareTo(p2.getNom());
		
		List<Personne> list = Arrays.asList(
				
				new Personne("SNAOUI","Lyes", 24),
				new Personne("SNAOUI", "Aghiles", 26),
				new Personne("GAYA", "Farid", 38),
				new Personne("AREZKI", "Ghani", 26),
				new Personne("STARYOUS", "Slimane", 19));
		
		List<Personne> listWithNulls = Arrays.asList(
	
		new Personne("SNAOUI","Lyes", 24),
		new Personne("SNAOUI", "Aghiles", 26), null,
		new Personne("GAYA", "Farid", 38),
		new Personne("AREZKI", "Ghani", 26),null,
		new Personne("STARYOUS", "Slimane", 19),
		null, null);
		

		list.forEach((Personne p ) -> System.out.println(p));
		
		System.out.println("\n Unsorted");
		
		list.sort(compLname);
		list.forEach((Personne p ) -> System.out.println(p));

		Comparator<Personne> compLnFn = Comparator.comparing(Personne::getNom).thenComparing(Personne::getPrenom);
				
		list.sort(compLnFn);
		System.out.println("\nSorted List Lant name then First name");
		list.forEach((Personne p ) -> System.out.println(p));
		
		
		Comparator<Personne> compFnLn = (p1, p2) -> {
			if (p1.getPrenom().equals(p2.getPrenom()))
				return p1.getNom().compareTo(p2.getNom());
			else
				return p1.getPrenom().compareTo(p2.getPrenom());
		};
 
		Comparator<Personne> compLnFnWithNull = (p1, p2) -> {
			if (p1 == null) {
				return 1;
			}
			
			if (p2 == null) {
				return -1;
			}
			
			else {
			
			if (p1.getNom().equals(p2.getNom()))
				return p1.getPrenom().compareTo(p2.getPrenom());
			else
				return p1.getNom().compareTo(p2.getNom());}
		};
		
		
		
		list.sort(compLnFnWithNull);
		System.out.println("\nSorted List Lant name then First name with NULLS");
		list.forEach((Personne p ) -> System.out.println(p));
		
	}

}
