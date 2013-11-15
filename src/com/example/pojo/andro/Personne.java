package com.example.pojo.andro;

public class Personne {
	
	
	public int id;
	public String prenom;
	public String nom;
	public String user;
	public String psw;
	
	public String formation;
	public String emp_temps;
	


public Personne( String prenom, String nom, String user, String psw,
			String formation, String emp_temps) {
		super();
		
		this.prenom = prenom;
		this.nom = nom;
		this.user = user;
		this.psw = psw;
		this.formation = formation;
		this.emp_temps = emp_temps;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmp_temps() {
		return emp_temps;
	}
	public void setEmp_temps(String emp_temps) {
		this.emp_temps = emp_temps;
	}
	
	



}
