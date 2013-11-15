package com.example.sqlLite.andro;

import com.example.pojo.andro.Personne;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

 
public class PersonneBDD {
 
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "localisation2.db";
 
	private static final String TABLE_PERSONNE = "table_personne";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	
	private static final String COL_NOM = "nom";
	private static final int NUM_COL_NOM = 1;
	
	private static final String COL_PRENOM = "prenom";
	private static final int NUM_COL_PRENOM = 2;
	
	private static final String COL_USER = "user";
	private static final int NUM_COL_USER = 3;
	
	private static final String COL_PSW = "psw";
	private static final int NUM_COL_PSW = 4;

	
	private static final String COL_FORMATION = "formation";
	private static final int NUM_COL_FORMATION = 5;
	
	private static final String COL_EMP_TEMPS= "emp_temps";
	private static final int NUM_COL_EMP_TEMPS = 6;
	
	private BasePersonneSqLite baseSql;
	private SQLiteDatabase bdd;
	
	private static final String[] COLUMNS = {COL_ID, COL_NOM, COL_PRENOM, COL_USER, COL_PSW,COL_EMP_TEMPS};
	
	public PersonneBDD(Context context)
	{
		//On créer la BDD et sa table
		baseSql = new BasePersonneSqLite(context, NOM_BDD, null, VERSION_BDD);
	}//fin personne

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
	
	public long insertPersonne(Personne personne)
	{
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_NOM, personne.getNom());
		Log.v("suivi 1: ", personne.getNom());
		
		values.put(COL_PRENOM, personne.getPrenom());
		Log.v("suivi 1: ", personne.getPrenom());
		
		values.put(COL_USER, personne.getUser());
		Log.v("suivi 1: ", personne.getUser());
		
		values.put(COL_PSW, personne.getPsw());	
		Log.v("suivi 1: ", personne.getPsw());
		
		values.put(COL_FORMATION ,personne.getFormation());
		Log.v("suivi 1: ", personne.getFormation());
		
		values.put(COL_EMP_TEMPS,personne.getEmp_temps());
		Log.v("suivi : ", personne.getEmp_temps());
		//on insère l'objet dans la BDD via le ContentValues
		
	
		
		return bdd.insert(TABLE_PERSONNE, null, values);
	}
 /**------------------------------------------------------------------------------*/
	public int updatePersonne(int id,Personne personne)
	{
		ContentValues values = new ContentValues();
		values.put(COL_NOM, personne.getNom());
	
		values.put(COL_PRENOM, personne.getPrenom());
		values.put(COL_USER, personne.getUser());
		values.put(COL_PSW, personne.getPsw());
		
		values.put(COL_FORMATION ,personne.getFormation());
		values.put(COL_EMP_TEMPS,personne.getEmp_temps());
		return bdd.update(TABLE_PERSONNE, values, COL_ID + " = " +id, null);
	}
	
/**---------------------------------- suppression------------------------------*/
	public int removePersonneWithID(int id){
		//Suppression d'un livre de la BDD grâce à l'ID
		return bdd.delete(TABLE_PERSONNE, COL_ID + " = " +id, null);
	}
 
	public Personne getPersonneWithNom(String nom){
		//Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_PERSONNE, new String[] {COL_ID, COL_NOM, COL_PRENOM, COL_USER,  COL_PSW,COL_FORMATION,COL_EMP_TEMPS}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
		return cursorToPersonne(c);
	}
/**--------------------------------------------------------------------------------------------*/
	public Personne getPersonneWithUserPsw(String user, String psw){
		Log.v("-------> psw", psw);

		Cursor c = bdd.query(TABLE_PERSONNE, new String[] {COL_ID, COL_NOM, COL_PRENOM, COL_USER,  COL_PSW,COL_FORMATION,COL_EMP_TEMPS}, COL_USER + " LIKE \"" + user +"\"" +" AND "+ COL_PSW + " LIKE \"" + psw +"\"", null, null, null, null);
	    return cursorToPersonne(c);
	}
 /**------------Convertire un curseur en une personne-------------------------------------------------------------*/
	
		private Personne cursorToPersonne(Cursor c)
		{
			//si aucun élément n'a été retourné dans la requête, on renvoie null
			if (c.getCount() == 0)
				return null;
	 
			//Sinon on se place sur le premier élément
			c.moveToFirst();
			
			Personne personne = new Personne();
			
			//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
			 personne.setId(c.getInt(NUM_COL_ID));
			 personne.setNom(c.getString(NUM_COL_NOM));
			 personne.setPrenom(c.getString(NUM_COL_PRENOM));
			 personne.setUser(c.getString(NUM_COL_USER ));
			 personne.setPsw(c.getString(NUM_COL_PSW));
			 personne.setFormation(c.getString(NUM_COL_FORMATION ));
			 personne.setEmp_temps(c.getString(NUM_COL_EMP_TEMPS));
		
			//On ferme le cursor
			c.close();
	 
			//On retourne le livre
			return personne;
		}
	/**---------------------------------------- Récuperer votre emploi du temps----------------------------*/
		
	/*	String LoadImage() {
			
			
		    String query = "select emp_temps from Table;"; 
		    Cursor c = bdd.query(TABLE_PERSONNE, new String[] {COL_ID, COL_NOM, COL_PRENOM, COL_USER, COL_PSW}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
			
		    String conString = @" Data Source = \Program Files\Users.s3db ";   
		    
		    SQLiteConnection con = new SQLiteConnection(conString); 
		    SQLiteCommand cmd = new SQLiteCommand(query, con);
		    string base64EncodedImage = null;
		    con.Open(); 
		    try {
		        IDataReader reader = cmd.ExecuteReader();
		        reader.Read(); // advance the data reader to the first row
		        base64EncodedImage = (string) reader["Photo"];
		        reader.Close();
		    }
		    catch (Exception ex) {
		        MessageBox.Show(ex.Message);
		    }
		    con.Close();
		    return base64EncodedImage;
		}*/
 
}