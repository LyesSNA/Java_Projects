package org.snaoui_exo11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class useComparator {

	public static void main(String[] args) {
		
		Comparator<String> compLong = (s1,s2) -> s1.length() - s2.length();
		
		List <String> nbrs = Arrays.asList("one", "two" ,"three" , "foor" );
		
		nbrs.sort(compLong);
		nbrs.forEach((String s) -> System.out.println(s));
		
 
	}

}
