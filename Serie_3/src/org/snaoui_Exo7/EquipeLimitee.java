package org.snaoui_Exo7;

import java.util.SortedSet;
import java.util.TreeSet;

public class EquipeLimitee {
	private SortedSet<Joueur>  equipe;
	private String nom;
	private int limite;
	
	public EquipeLimitee (String nom, int limite) {
		equipe = new TreeSet<>();
		this.nom=nom;
		this.limite = limite;
	}
	
	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	
	public boolean addJoueur(Joueur j) {
		if(equipe.size()<this.getLimite()) {
			equipe.add(j);
			return false;
		}
		else
			return true;
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

	
	public void addAllEquipe(EquipeLimitee o) {
		
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
	
	public float getMoyenneAge (EquipeLimitee o) {
		float sum = 0;
		for (Joueur j : o.equipe) {
			sum = sum + j.getAge();
			}
		return sum/equipe.size();
	}
}
