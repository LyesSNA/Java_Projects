package org.snaoui_exo10;

import java.util.function.BiFunction;
import java.util.function.Function;

public class useFunction {

	public static void main(String[] args) {

		Function<String , String> toUp = s -> s.toUpperCase();
		
		Function<String , String > copy = s -> s;
		
		Function<String , Integer> longueur = s -> {
			if(s != null) 
				return s.length();
			else 
				{return 0;}
			};
		
		Function<String , String > entrePar = s ->
		{
			if(s != null) 
				return "("+s+")";
			else 
				{return "()";}
			};
			
		
		BiFunction<String , String, Integer> pos1 = (mot,chaine) -> mot.indexOf(chaine)   ;
		
		Function<String , Integer> pos2 = mot -> "abcdefghi".indexOf(mot)   ;
			
		String a = null;
		
		String b = copy.apply(a);
		
		int c =longueur.apply(a);

		System.out.println(entrePar.apply(a));
		
		System.out.println(pos2.apply("efg"));
		
	}

}
