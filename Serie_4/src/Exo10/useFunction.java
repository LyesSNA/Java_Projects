package Exo10;

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
		
		String a = "null";
		
		String b = copy.apply(a);
		
		int c =longueur.apply(a);

		System.out.println(c);
		
	}

}
