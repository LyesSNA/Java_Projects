package org.snaoui.exo8;

public class Joueur {
	int anneeDeNaissance;
	String nom;
	
	public Joueur (String nom, int anneeDeNaissance) {
		this.anneeDeNaissance = anneeDeNaissance;
		this.nom = nom;
	}

	public int getAnneeDeNaissance() {
		return anneeDeNaissance;
	}

	public void setAnneeDeNaissance(int anneeDeNaissance) {
		this.anneeDeNaissance = anneeDeNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeDeNaissance - anneeDeNaissance % 10;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (anneeDeNaissance != other.anneeDeNaissance)
			return false;
		return true;
	}
	
	
	
}
