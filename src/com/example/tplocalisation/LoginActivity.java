package com.example.tplocalisation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pojo.andro.Personne;
import com.example.sqlLite.andro.PersonneBDD;

public class LoginActivity extends Activity implements OnClickListener 
{

	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";
	
	final String EXTRA_NOM = "user_nom";
	final String EXTRA_PRENOM = "user_prenom";
	final String EXTRA_FORMATION = "user_fomation";
	private EditText user= null;
	private EditText psw = null;
	
	public Button ok = null;
	public String erreur="";
	
	PersonneBDD perBdd;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		 
	
	    perBdd = new PersonneBDD(this);
	    
		initDataBase();
		   
		
	    user = (EditText)findViewById(R.id.user_email);
	    psw = (EditText)findViewById(R.id.user_password);
	    
	    ok = (Button)findViewById(R.id.ok);
	    ok.setOnClickListener(this);
		
	  
	}
/**---------------------------------------------------------------------------*/
	public void initDataBase()
	{
		  PersonneBDD personneBdd = new PersonneBDD(this);
		  
			Personne personne4 = new Personne("Messaouda1", "GUEDDOUN2", "messa1", "123", "Master2-TNSI","emploiP1");
			Personne personne2 = new Personne("Graine", "Sabrina", "bina", "123", "Master1-RSD","emploiP2");
			Personne personne3 = new Personne("hassen", "GUEdooun", "usetP3", "pswP3", "fomrationP3","emploiP3");
			
			personneBdd.open();
		   //   On insère le livre que l'on vient de créer
		    personneBdd.insertPersonne(personne4);
		    Log.v("suivi main : ","personne");
		    personneBdd.insertPersonne(personne2);
		    Log.v("suivi main : ","personne2");
		    personneBdd.insertPersonne(personne3);
		    Log.v("suivi main : ","personne3");
	
		
		    Log.v("suivi main : ","----------------");
		    
		   /* Personne pp = personneBdd.getPersonneWithUserPsw("messa", "123");
		    if(pp!= null)
		    {  Log.v("suivi main : ","OKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKk");
		    }else { Log.v("suivi main : ","nnnnnnnnnnnnnnnnnnnnnnnnn");}*/
	 
	        personneBdd.close();
	}
/**------------------------------------------------------------------------------------------*/
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Button b = (Button)v;
	
		if (b==ok)
		{
			String uuser = user.getText().toString();
			String ppswr = psw.getText().toString();
			Log.v("-------", uuser);

			 try {
				 //perBdd.getPersonneWithUserPsw(uuser, ppswr);
				 PersonneBDD personneBdd = new PersonneBDD(this);
				 personneBdd.open();
				 Personne pp= personneBdd.getPersonneWithUserPsw(uuser, ppswr);
				 
				 Log.v("----onClick----", "je m'execute");
				 Intent intent = new Intent(LoginActivity.this, AcceuilActivity.class);
			     intent.putExtra(EXTRA_LOGIN, uuser);
				 intent.putExtra(EXTRA_PASSWORD, ppswr); 
				 intent.putExtra(EXTRA_NOM ,pp.getNom());
				 intent.putExtra(EXTRA_PRENOM , pp.getPrenom());
				 intent.putExtra(EXTRA_FORMATION , pp.getFormation());
				 personneBdd.close();
				 startActivity(intent);
			} catch (java.lang.NullPointerException e){
	
				 Log.v("-------", "je m'execute");
				 
				 
				 psw.getText().clear();
			      user.getText().clear();
			    Toast.makeText(this, "Erreur Authentification", Toast.LENGTH_LONG).show(); 
			}
		 }//ok
			
		
		
	}
}
