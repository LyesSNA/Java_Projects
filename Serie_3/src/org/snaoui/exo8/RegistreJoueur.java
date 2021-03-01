package org.snaoui.exo8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class RegistreJoueur {

	public Map<Integer , List<Joueur>> registre;
	private List<Joueur> liste = new ArrayList<>();
	
	public RegistreJoueur() {
		registre = new HashMap<>();
	}
	
	
	public void addJoueur(Joueur j) {
		if(registre.get(j.hashCode()) == null) {
			List <Joueur> joueurs = new ArrayList<>();
			joueurs.add(j);
			registre.put(j.hashCode(), joueurs);
		}
		else {
			List<Joueur> joueurs = registre.get(j.hashCode());
			joueurs.add(j);
		}
			
	}
	
	public List get(int i) {
		for(List<Joueur> joueurs : registre.values()) {
			for(Joueur j : joueurs) {
				if (j.getAnneeDeNaissance() - j.getAnneeDeNaissance() % 10 == i)
					return get(j.hashCode());
			}
		}
		System.out.println("no one born this decade");
		return null;
	}
	
	public int count(int i) {
		return get(i).size();
	}
	
	public int count() {
		int count = 0;
		for(List<Joueur> joueurs : registre.values()) {
			count+=joueurs.size();
		}
		return count;
	}


	@Override
	public String toString() {
		String a ="";
		Set<Entry<Integer , List<Joueur>>> entrySet = registre.entrySet();
		for (Entry<Integer , List<Joueur>> entry : entrySet) {
			a= a + "entry : " + entry.getKey() + "  " + entry.getValue() + "\n";
		}
		return a;
	}
	
	
}