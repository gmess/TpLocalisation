package com.example.webService.amis;

import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Xml;

public class AmisSOAFetcher {
 
    //Call Web service
    private static final String SOAP_ACTION = "http://serviceweb.service.web.com/ListeAmis";    
    private static final String METHOD_NAME = "ListeAmis";    
    private static final String NAMESPACE = "http://serviceweb.service.web.com";  
    private static final String URL = "http://10.1.121.234:8985/zzz/services/ListeAmis?wsdl";  
 
    private final SoapSerializationEnvelope envelope;
 
    public AmisSOAFetcher() 
    {
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        
        request.addProperty("user", "messa");
        request.addProperty("psw", "123");
        
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = false;
    }
 
    public List<Amis> Fetch()
    {
        HttpTransportSE httpRequest = new HttpTransportSE(URL);
        AmisSOAHandler amisParser = new AmisSOAHandler();
        
        try {
            httpRequest.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            Xml.parse(response.toString(), amisParser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amisParser.getAmiss();
    }
}