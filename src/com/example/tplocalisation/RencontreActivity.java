package com.example.tplocalisation;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ListView;

import com.example.webService.amis.Amis;
import com.example.webService.amis.AmisSOAFetcher;

public class RencontreActivity extends Activity {

	private ListView listView1;
	private List <Amis> amis;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rencontre);
		
		amis = new ArrayList<Amis>();
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
				new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		  AmisSOAFetcher sqf = new AmisSOAFetcher();
	       amis = sqf.Fetch();
		
		
		AmisAdapter adapter = new AmisAdapter(this, R.layout.listview_item_row, amis);
		 listView1 = (ListView)findViewById(R.id.listView1);
		 Log.e("------------------","je m'execute");
	        
	       // View header = (View)getLayoutInflater().inflate(R.layout.list_view_header, null);
	      //  listView1.addHeaderView(header);
	       
	        listView1.setAdapter(adapter);
	}



}
