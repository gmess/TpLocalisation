package com.example.tplocalisation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AcceuilActivity extends Activity implements OnClickListener 
{
	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";
	
	final String EXTRA_NOM = "user_nom";
	final String EXTRA_PRENOM = "user_prenom";
	final String EXTRA_FORMATION = "user_fomation";
	
	
	private Button externe = null; 
	private Button interne = null; 
	private Button emploi = null;
	private Button webservice = null;
	private Button rencontre = null;
	private Button batterie = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acceuil);
		
		externe = (Button)findViewById(R.id.localisation);
		externe.setOnClickListener(this);
		
		interne = (Button)findViewById(R.id.interne);
		interne.setOnClickListener(this);
		
		emploi = (Button)findViewById(R.id.empl);
		emploi.setOnClickListener(this);
		
		webservice = (Button)findViewById(R.id.webservice);
		webservice.setOnClickListener(this);
		
		rencontre = (Button)findViewById(R.id.rencontre);
		rencontre.setOnClickListener(this);
		
		batterie = (Button)findViewById(R.id.batterie);
		batterie.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button b = (Button)v;
		Intent intent2 = getIntent();
		
	if(b==externe)
		{
			Intent intent = new Intent(AcceuilActivity.this, LocalisationActivity.class);
		     intent.putExtra(EXTRA_LOGIN, intent2.getStringExtra(EXTRA_LOGIN));
			 intent.putExtra(EXTRA_PASSWORD, intent2.getStringExtra(EXTRA_FORMATION)); 
			 intent.putExtra(EXTRA_NOM ,intent2.getStringExtra(EXTRA_NOM));
			 intent.putExtra(EXTRA_PRENOM , intent2.getStringExtra(EXTRA_PRENOM));
			 intent.putExtra(EXTRA_FORMATION , intent2.getStringExtra(EXTRA_FORMATION));
			
			startActivity(intent);
		} 
		else if (b== interne)
		{
			
			Intent intent = new Intent(AcceuilActivity.this, ScanActivity.class);
			   intent.putExtra(EXTRA_LOGIN, intent2.getStringExtra(EXTRA_LOGIN));
				 intent.putExtra(EXTRA_PASSWORD, intent2.getStringExtra(EXTRA_FORMATION)); 
				 intent.putExtra(EXTRA_NOM ,intent2.getStringExtra(EXTRA_NOM));
				 intent.putExtra(EXTRA_PRENOM , intent2.getStringExtra(EXTRA_PRENOM));
				 intent.putExtra(EXTRA_FORMATION , intent2.getStringExtra(EXTRA_FORMATION));
				
			startActivity(intent);
		}
		else if (b== emploi)
		{
			Intent intent = new Intent(AcceuilActivity.this, EmploiTempsActivity.class);
			   intent.putExtra(EXTRA_LOGIN, intent2.getStringExtra(EXTRA_LOGIN));
				 intent.putExtra(EXTRA_PASSWORD, intent2.getStringExtra(EXTRA_FORMATION)); 
				 intent.putExtra(EXTRA_NOM ,intent2.getStringExtra(EXTRA_NOM));
				 intent.putExtra(EXTRA_PRENOM , intent2.getStringExtra(EXTRA_PRENOM));
				 intent.putExtra(EXTRA_FORMATION , intent2.getStringExtra(EXTRA_FORMATION));
				
			startActivity(intent);	
		}
		else if (b== webservice)
		{
			Intent intent = new Intent(AcceuilActivity.this, WebServiceActivity.class);
			   intent.putExtra(EXTRA_LOGIN, intent2.getStringExtra(EXTRA_LOGIN));
				 intent.putExtra(EXTRA_PASSWORD, intent2.getStringExtra(EXTRA_FORMATION)); 
				 intent.putExtra(EXTRA_NOM ,intent2.getStringExtra(EXTRA_NOM));
				 intent.putExtra(EXTRA_PRENOM , intent2.getStringExtra(EXTRA_PRENOM));
				 intent.putExtra(EXTRA_FORMATION , intent2.getStringExtra(EXTRA_FORMATION));
				
			startActivity(intent);
		}
		else if (b== rencontre)
		{
			Intent intent = new Intent(AcceuilActivity.this, RencontreActivity.class);
			   intent.putExtra(EXTRA_LOGIN, intent2.getStringExtra(EXTRA_LOGIN));
				 intent.putExtra(EXTRA_PASSWORD, intent2.getStringExtra(EXTRA_FORMATION)); 
				 intent.putExtra(EXTRA_NOM ,intent2.getStringExtra(EXTRA_NOM));
				 intent.putExtra(EXTRA_PRENOM , intent2.getStringExtra(EXTRA_PRENOM));
				 intent.putExtra(EXTRA_FORMATION , intent2.getStringExtra(EXTRA_FORMATION));
				
			startActivity(intent);
		}
	
		else if (b== batterie)
		{
			Intent intent = new Intent(AcceuilActivity.this, BattryActivity.class);
			 
				
			startActivity(intent);
		}
	}



}
