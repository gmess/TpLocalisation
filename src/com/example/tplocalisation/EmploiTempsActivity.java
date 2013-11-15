package com.example.tplocalisation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pojo.andro.Personne;
import com.example.sqlLite.andro.PersonneBDD;


public class EmploiTempsActivity extends Activity 
{

	
	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";
	final String EXTRA_NOM = "user_nom";
	final String EXTRA_PRENOM = "user_prenom";
	final String EXTRA_FORMATION = "user_fomation";
	
	public Button ok = null;
	public TextView user =null; 
	public TextView nom = null;
	public TextView prenom = null;
	public TextView formation = null;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.traitement);
		
		 Intent intent = getIntent();
	       user = (TextView) findViewById(R.id.user);
	       nom  = (TextView) findViewById(R.id.nom);
	       prenom  = (TextView) findViewById(R.id.prenom); 
	       formation  = (TextView) findViewById(R.id.formation);
	       if (intent != null)
	       {
	    	   user.setText("Nom Utilisateur : " +intent.getStringExtra(EXTRA_LOGIN));  
	    	   nom.setText("Nom : " +intent.getStringExtra(EXTRA_NOM));
	    	   prenom.setText("Prénom : "+intent.getStringExtra(EXTRA_PRENOM));
	    	   formation.setText("Formation : "+intent.getStringExtra(EXTRA_FORMATION));
	       }
	  
	}


	
}