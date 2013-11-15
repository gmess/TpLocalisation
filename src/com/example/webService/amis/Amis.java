package com.example.webService.amis;


public class Amis {
	

	
	public long id;
	public String nom = null;
	public String prenom;
	public String user = null;
	public String psw;
	public String statut = null;

	
	public Amis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amis( String nom, String prenom, String user, String psw,
			String statut) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.psw = psw;
		this.statut = statut;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	


}
