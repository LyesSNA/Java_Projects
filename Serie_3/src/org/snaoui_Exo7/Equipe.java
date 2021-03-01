package org.snaoui_Exo7;

import java.util.SortedSet;
import java.util.TreeSet;

public class Equipe {
	private SortedSet<Joueur>  equipe;
	String nom;
	
	public Equipe (String nom) {
		equipe = new TreeSet<>();
		this.nom=nom;
	}
	
	public void addJoueur(Joueur j) {
		equipe.add(j);
	}
	
	
	
//	Cannot invoke "java.util.SortedSet.iterator()" because "this.equipe" is null !!!!
	
//	Iterator<Joueur> it = equipe.iterator();
//	
	@Override
	public String toString() {
		String a = "";
        for(Joueur element : equipe) {
            a = a + element.toString() + "\n";
        }
	
		return "Equipe de "+ nom + "  " + equipe.size() + "\n" + a ;
	}

	
	public boolean removeJoueur(Joueur j) {
		boolean b = equipe.remove(j);
		return b;
	}
	
	public boolean isJoueurPresent(Joueur j) {
		
		boolean b = equipe.contains(j);
		return b;
	}

	
	public void addAllEquipe(Equipe o) {
		
		for (Joueur j : o.equipe) {
			this.addJoueur(j);
		}
		
	}
	
	public void clear() {
		this.clear();
	}
	
	public int getNbrJoueurs() {
		return equipe.size();
	}
	
	public float getMoyenneAge (Equipe o) {
		float sum = 0;
		for (Joueur j : o.equipe) {
			sum = sum + j.getAge();
			}
		return sum/equipe.size();
	}
}
