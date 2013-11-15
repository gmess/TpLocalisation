package com.example.webService.amis;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AmisSOAHandler extends DefaultHandler { 
	
	
	private ArrayList<Amis> amiss = new ArrayList<Amis>();   
	private Amis currentAmis = new Amis();   
	private String currentNodeText; 


	private final String AMIS = "ax21:Amis";   
	private final String ID = "ax21:id";
	private final String NOM = "ax21:nom";    
	private final String PRENOM = "ax21:prenom"; 
	private final String PSW = "ax21:psw"; 
	private final String STATUT = "ax21:statut";
	private final String USER = "ax21:user";
	
	@Override    
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {  
		// Create a new Agency for every corresponding
		// <Stock> node in the XML document
		if (localName.equalsIgnoreCase(AMIS)) {
			currentAmis = new Amis();        
			}    
		}    
	@Override   
	public void characters(char[] ch, int start, int length)  throws SAXException { 
		// Retrieve the text content of the current node        
		// that is being processed        
		currentNodeText = new String(ch, start, length);   
		}    
	@Override    
	public void endElement(String uri, String localName, String qName)  throws SAXException {

		if(localName.equalsIgnoreCase(ID))
		{            
			currentAmis.setId(Integer.valueOf(currentNodeText));        
			
		}else if(localName.equalsIgnoreCase(NOM)){            
				currentAmis.setNom(currentNodeText);        
			}else if(localName.equalsIgnoreCase(PRENOM)){            
				currentAmis.setPrenom(String.valueOf(currentNodeText));        
			}else if(localName.equalsIgnoreCase(PSW)){            
			currentAmis.setPsw(String.valueOf(currentNodeText));        
			}else if(localName.equalsIgnoreCase(STATUT)){ 
				currentAmis.setStatut(currentNodeText);
			}else if(localName.equalsIgnoreCase(USER)){ 
				currentAmis.setUser(currentNodeText);
		
			}else if(localName.equalsIgnoreCase(AMIS)){ 
					
					amiss.add(currentAmis);       
					}    
		}         
	public ArrayList<Amis> getAmiss() {        
		return amiss;   
		}
}