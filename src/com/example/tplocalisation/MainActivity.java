package com.example.tplocalisation;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener 
{
	
	private Button aide = null; 
 
	private Button login = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		login = (Button)findViewById(R.id.premiere_aut2);
		login.setOnClickListener(this);
		
		aide = (Button)findViewById(R.id.premiere_aide);
		aide.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Button b = (Button)v;
		
     if (b== login)
		{
			Intent intent = new Intent(MainActivity.this, LoginActivity.class);
			startActivity(intent);	
		}
     
	
	}



}
