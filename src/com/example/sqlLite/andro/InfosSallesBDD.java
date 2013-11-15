package com.example.sqlLite.andro;

import com.example.pojo.andro.InfoSalle;
import com.example.pojo.andro.Personne;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class InfosSallesBDD {
	
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "localisationSalle.db"; //localisationSalle.db
	
	private static final String TABLE_SALLE = "salle";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	
	private static final String COL_NOM_SALLE = "nom_salle";
	private static final int NUM_COL_NOM_SALLE = 1;
	
	private static final String COL_ID_BARRE = "id_barre";
	private static final int NUM_COL_ID_BARRE = 2;
	
	private static final String COL_ETAGE = "etage";
	private static final int NUM_COL_ETAGE = 3;
	
	private static final String COL_BATIMENT = "batiment";
	private static final int NUM_COL_BATIMENT = 4;
	
	private BaseSalleInfosSqLite baseSql;
	private SQLiteDatabase bdd;
	
	public InfosSallesBDD(Context context)
	{
		//On créer la BDD et sa table
		baseSql = new BaseSalleInfosSqLite(context, NOM_BDD, null, VERSION_BDD);
	}//fin salle

/**----------------- ouverture et fermeture--------------------------*/
	public void open(){
		//on ouvre la BDD en écriture
		bdd = baseSql.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'accès à la BDD
		bdd.close();
	}
	
	public SQLiteDatabase getBDD(){
		return bdd;
	}
	

/**------------------- mise a jour et ajout------------------------*/
	public long insertSalle(InfoSalle salle)
	{
		//Log.v("suivi isert salle: ", salle.getBatiment());
		
		ContentValues values = new ContentValues();
		
		
		//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NOM_SALLE, salle.getNom_salle());
		Log.v("suivi 1: ", salle.getNom_salle());
		
		values.put(COL_ID_BARRE, salle.getId_barre());
		Log.v("suivi 1: ", salle.getId_barre());
		
		values.put(COL_ETAGE,salle.getEtage());	
		Log.v("suivi 1: ", salle.getEtage());
		
		values.put(COL_BATIMENT, salle.getBatiment());
		Log.v("suivi 1: ", salle.getBatiment());
		
		
		

		return bdd.insert(TABLE_SALLE, null, values);
	}
 /**------------------------------------------------------------------------------*/
	public InfoSalle getSalleWithCode(String code_barre){
		

		Cursor c = bdd.query(TABLE_SALLE, new String[] {COL_ID, COL_NOM_SALLE, COL_ID_BARRE, COL_ETAGE,  COL_BATIMENT}, COL_ID_BARRE + " LIKE \"" + code_barre +"\"", null, null, null, null);
	    return cursorToInfoSalle(c);
	}
/**----------------------------------------------------------------------------------------------*/
	public InfoSalle getSalleWithName(String name){
		

		Cursor c = bdd.query(TABLE_SALLE, new String[] {COL_ID, COL_NOM_SALLE, COL_ID_BARRE, COL_ETAGE,  COL_BATIMENT}, COL_NOM_SALLE + " LIKE \"" + name +"\"", null, null, null, null);
	    return cursorToInfoSalle(c);
	}
 /**------------Convertire un curseur en une personne-------------------------------------------------------------*/
	
		private InfoSalle cursorToInfoSalle(Cursor c)
		{
			//si aucun élément n'a été retourné dans la requête, on renvoie null
			if (c.getCount() == 0)
				return null;
	 
			//Sinon on se place sur le premier élément
			c.moveToFirst();
			
			InfoSalle salle = new InfoSalle();
			
			//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
			 salle.setId(c.getInt(NUM_COL_ID));
			 salle.setNom_salle(c.getString(NUM_COL_NOM_SALLE));
			 salle.setId_barre(c.getString(NUM_COL_ID_BARRE));
			 salle.setEtage(c.getString(NUM_COL_ETAGE ));
			 salle.setBatiment(c.getString(NUM_COL_BATIMENT));
			//On ferme le cursor
			c.close();
	 
			//On retourne le livre
			return salle;
		}

}//fin classe
