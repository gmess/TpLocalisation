package com.example.tplocalisation;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class WebServiceActivity extends Activity
{
	private final String NAMESPACE = "http://tempuri.org/";
	private final String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
	private final String SOAP_ACTION = "http://tempuri.org/CelsiusToFahrenheit";
	private final String METHOD_NAME = "CelsiusToFahrenheit";
	private String TAG = "PGGURU";
	private static String celcius;
	private static String fahren;
	
	public Button b;
	public TextView tv;
	public EditText et;
	
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.web_service);
	    
	    et = (EditText) findViewById(R.id.editText1);
	    tv = (TextView) findViewById(R.id.tv_result);
	    b = (Button) findViewById(R.id.button1);
	  
	   
	    b.setOnClickListener(new OnClickListener() 
	    {
	        public void onClick(View v) 
	        {
	            
	            if (et.getText().length() != 0 && et.getText().toString() != "") 
	            {
	                
	                celcius = et.getText().toString();
	                AsyncCallWS task = new AsyncCallWS();
	                task.execute();
	            
	            } else  tv.setText("Entrer le degres en Celsuis..");
	            
	        }
	    });
	    
	}//on create
/**---------------------- classe interne ------------------------------*/	    

/**----------------------------------------------------------------------------*/
	public void getFahrenheit(String celsius)
	{
	    //Create request
	    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	    //Property which holds input parameters
	    PropertyInfo celsiusPI = new PropertyInfo();
	    //Set Name
	    celsiusPI.setName("Celsius");
	    //Set Value
	    celsiusPI.setValue(celsius);
	    //Set dataType
	    celsiusPI.setType(double.class);
	    //Add the property to request object
	    request.addProperty(celsiusPI);
	    //Create envelope
	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    //Set output SOAP object
	    envelope.setOutputSoapObject(request);
	    //Create HTTP call object
	    HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	 
	    try {
	        //Invole web service
	        androidHttpTransport.call(SOAP_ACTION, envelope);
	        //Get the response
	        SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
	        //Assign it to fahren static variable
	        fahren = response.toString();
	 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}//fin get
	/**--------------------------------*/
	class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            getFahrenheit(celcius);
            return null;
        }
 
        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            tv.setText(fahren + "� F");
        }
 
        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            tv.setText("Calcule en Cours...");
        }
 
        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }
 
    }

}//fin classe
