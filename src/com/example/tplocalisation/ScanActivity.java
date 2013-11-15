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
import android.widget.Toast;

import com.example.pojo.andro.InfoSalle;
import com.example.sqlLite.andro.InfosSallesBDD;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends Activity implements OnClickListener  
{
	
	
	private TextView content = null, direction=null ;
	public Button scan=null;;
	
	private EditText salleEdit =null;

    InfosSallesBDD salleBdd=null;
	
	protected void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.scan);
	    
	    salleBdd = new InfosSallesBDD(this);
	    initDataBaseSalle();
	 
	    content = (TextView)findViewById(R.id.scan_content);
	    direction = (TextView)findViewById(R.id.scan_direction); 
	    scan = (Button)findViewById(R.id.scan_button);
	    
	    salleEdit = (EditText)findViewById(R.id.salleN);
	  
	    
	    
	    
	    scan.setOnClickListener(this);
	    
	 
	    
	    
	}//fin on create

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		Button b = (Button)v;
		if (b==scan)
		{
				IntentIntegrator scanIntegrator = new IntentIntegrator(this);
				scanIntegrator.initiateScan();
		}
		
	}//fin on clock listenr
/**-------------------------------------------------------------------------------------------*/
	public void onActivityResult(int requestCode, int resultCode, Intent intent) 
	{
		
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) 
		{
			String code = scanningResult.getContents();
			String scanFormat = scanningResult.getFormatName();
			
			InfosSallesBDD salleBdd = new InfosSallesBDD(this);
			salleBdd.open();
			
			InfoSalle salle = salleBdd.getSalleWithCode(code.toString());
			
			
			Log.v("salle.getConbtent -code barre : ", code.toString());
			Log.v("taille salle -code barre : ", salle.getNom_salle());
			
			if (salle!= null)
			{
				Log.e("Exection : ", "je m'execute");
				Log.v("infos scan1", scanFormat.toString());
				content.setText("Vous etes actuelement dans la batiment  : " + salle.getBatiment()+" au " +
						" : "+salle.getEtage()+ " en face de la salle : "+salle.getNom_salle());
				
				String nomSalle =salleEdit.getText().toString();
				InfoSalle salle2 = salleBdd.getSalleWithName(nomSalle);
				if (salle2 != null)
				{
					//Log.v("Nom de la salle  ", nomSalle);
					//Log.v("recup base de donnes salle 2", salle2.getBatiment());
				if (salle2.getBatiment().equals(salle.getBatiment()))
				{
					direction.setText("Pour trouver la salle :"+ nomSalle + "aller au " +salle2.getEtage()+" de l'"+salle2.getBatiment());
					Log.v("infos scan2", code.toString());
			    }else direction.setText("Pour trouver la salle, sorter de "+salle.getBatiment()+"et derrigez-vous vers "+ salle2.getBatiment() +"aller au " +salle2.getEtage()+" de l'"+salle2.getBatiment());
					
			        
				}//fin salle2 !=null
				else direction.setText("la salle n'existe pas dans les differents batiments");
			}//fin if salle =null
		}else{
		    Toast toast = Toast.makeText(getApplicationContext(),
		        "No scan data received!", Toast.LENGTH_SHORT);
		    toast.show();
		}
	}//fin on activity
	
/**----initialier la base de donnes-------------------------------------------------------------------------------*/
	public void initDataBaseSalle()
	{
		InfosSallesBDD salleBdd = new InfosSallesBDD(this);
		  
		   InfoSalle salle1 = new InfoSalle("123456789012","e007","1er etage", "istv2");
		   InfoSalle salle2 = new InfoSalle("012345678905","e201","2er etage", "istv2");

		salleBdd.open();
		   //   On insère le livre que l'on vient de créer
		    salleBdd.insertSalle(salle1);
		   // Log.v("suivi main -apres inser salle1: ","salle1");
		    
		    salleBdd.insertSalle(salle2);
		   // Log.v("suivi main apres insert salle2: ","salle2");

		  //  Log.v("suivi main : ","----------------");

	        salleBdd.close();
	}//fin initailaiqation data base

}//fin classe
