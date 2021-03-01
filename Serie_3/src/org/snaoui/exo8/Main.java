package org.snaoui.exo8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Joueur j1 = new Joueur("Drogba" , 1980);
		Joueur j2 = new Joueur("Eto" , 1978);
		Joueur j3 = new Joueur("Pele" , 1962);
		Joueur j4 = new Joueur("Maradona" , 1970);
		Joueur j5 = new Joueur("alain" , 1970);

		RegistreJoueur rj = new RegistreJoueur();
		

		rj.addJoueur(j1);
		rj.addJoueur(j2);
		rj.addJoueur(j3);
		rj.addJoueur(j4);
		rj.addJoueur(j5);
		
		System.out.println(rj);
		
	}

}
