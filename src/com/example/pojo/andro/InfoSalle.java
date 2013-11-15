package com.example.pojo.andro;

public class InfoSalle {
	
	public int id;
	public String id_barre;
	public String nom_salle;
	public String etage;
	public String batiment;
	
	
	
	public InfoSalle() {
		super();
		// TODO Auto-generated constructor stub
	}



	public InfoSalle( String id_barre, String nom_salle, String etage,
			String batiment) {
		super();
		
		this.id_barre = id_barre;
		this.nom_salle = nom_salle;
		this.etage = etage;
		this.batiment = batiment;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getId_barre() {
		return id_barre;
	}



	public void setId_barre(String id_barre) {
		this.id_barre = id_barre;
	}



	public String getNom_salle() {
		return nom_salle;
	}



	public void setNom_salle(String nom_salle) {
		this.nom_salle = nom_salle;
	}



	public String getEtage() {
		return etage;
	}



	public void setEtage(String etage) {
		this.etage = etage;
	}



	public String getBatiment() {
		return batiment;
	}



	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}
	

}
