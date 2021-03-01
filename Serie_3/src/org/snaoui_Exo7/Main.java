package org.snaoui_Exo7;


public class Main {

	public static void main(String[] args) {
		
		EquipeLimitee e1 = new EquipeLimitee("France",3);
		Equipe e2 = new Equipe("Belgique");
		Joueur j1 = new Joueur("Benzema", 76);
		Joueur j3 = new Joueur("Bartez", 34);
		Joueur j2 = new Joueur("Zidane", 40);
		Joueur j4 = new Joueur("Didier", 26);
		
		e1.addJoueur(j4);
		e1.addJoueur(j3);
		e1.addJoueur(j2);
		e1.addJoueur(j1);
		
		//e2.addAllEquipe(e1);
		
		System.out.println(e1);
		
	}

}
