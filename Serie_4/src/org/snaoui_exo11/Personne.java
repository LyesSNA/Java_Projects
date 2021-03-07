package org.snaoui_exo11;

import java.util.Comparator;

public class Personne {

	private String nom;
	private String prenom;
	private int age;
	
	public Personne (String n, String p, int a) {
		this.nom = n;
		this.age = a;
		this.prenom = p;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
}
