package org.snaoui.exo13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class useMaps {

	public static void main(String[] args) {
		Map<Integer, String> map = Map.of(3,"one", 4, "foor", 5 , "three", 6, "eleven");
		
		map.forEach((key, value) -> System.out.println(key + " = " + value ));
		
		System.out.println("\n");
		
		Map<Integer , String> mutableMapMaj = new HashMap<>(map);
		
		mutableMapMaj.forEach((key, value) -> mutableMapMaj.replaceAll((Integer a,String b) -> b.toUpperCase()));
		
		mutableMapMaj.forEach((key, value) -> System.out.println(key + " = " + value ));
		
		System.out.println("\n");
		
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
		Map<Integer , String> mutableMapPuts = new HashMap<>(map);
		
		keys.forEach(i -> mutableMapPuts.putIfAbsent(i, ""));

		mutableMapPuts.forEach((key, value) -> System.out.println(key + " = " + value ));
		System.out.println("\n");

		Map<Integer, List<String>> mapLength = new HashMap<>();
		
		List<String> words = Arrays.asList("one", "two" , "three","foor","five","six","seven","eight","nine","ten", "eleven","twelve");
		
		for (String nbr : words) {
			
			mapLength.computeIfAbsent(nbr.length(), key -> new ArrayList<>()).add(nbr);
			
		}
		
		mapLength.forEach((key, value) -> System.out.println(key + " = " + value ));
		System.out.println("\n");

		
		Map<Integer, String> mapLengthMerged = new HashMap<>();
		
		for (String nbr : words) {
		
			mapLengthMerged.computeIfPresent(nbr.length(), (key, value) -> mapLengthMerged.merge(nbr.length(), nbr, (s1 , val) -> s1 + val) );
	
		}
		
		mapLength.forEach((key, value) -> System.out.println(key + " = " + value ));
		System.out.println("\n");
		
		
		
	}

}
