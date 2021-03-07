package org.snaoui.exo12;

import java.util.List;
import java.util.function.Function;

public class Usefunction {

	public static void main(String[] args) {

		List <String> nbrs = List.of("one", "two" , "three","foor","five","six","seven","eight","nine","ten", "eleven","twelve");

		nbrs.forEach((String s) -> System.out.println(s));
		
		nbrs.forEach((String s) -> nbrs.removeIf((String a) -> a.length()>4));
		
		nbrs.forEach((String s) -> System.out.println(s));
		
	}

}
