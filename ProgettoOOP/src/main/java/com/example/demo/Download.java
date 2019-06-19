package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import org.json.simple.*;
public class Download {
	public static void Download() {
//inizializzo la stringa url con il link del dataset corrispondente
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=795ae7f4-421b-4ba2-9a8e-42bc28980dc7";
/*scarico il file con l'utilizzo del url utilizzando la classe URLConnection la quale è una classe
 * che permette di comunicare con URL attraverso la rete HTTP, permette di leggere e scrivere con la
 * connessione; quindi creo un'istanza della classe per leggere ciò che è presente al suo interno.Gestisco
 * il tutto con un try catch nel caso si verifichino eccezioni di qualsiasi genere in lettura.*/	
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			/*apro lo stream di input dell'istanza openConnection la quale comunica con il data-set 
			 * con la classe InputStream */
			InputStream in = openConnection.getInputStream();
			 String data = ""; //stringa vuota che verrà riempita dall'intero file json presente nell'url
			 String line = ""; // stringa vuota di appoggio che ci serve per riempire riga per riga la stringa data in relazione al contenuto dell'URL
			 try {
			/*creo un BufferedReader per ottimizzare lo stream in input, gli passo al costruttore un'istanza
			 * di InputStreamReader alla quale ho passato a sua volta l'istanza di InputStream */
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			 /*ciclo per riempire lo data con tutto il file JSON presente nell'URL*/ 
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
				   System.out.println( line );
			   }
			 } finally {
			   in.close(); //chiudo lo stream
			 }
			 /*Eseguo il parsing del JSON in un JSONObject, accedo al JSON object "result", e all'array "resources" presenti
			 presenti nel formato*/
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));
			/*Scorro tutto l'array "resources" in cui sono presenti JSONObject */
			for(Object o: objA){
			    if ( o instanceof JSONObject ) { 
			        JSONObject o1 = (JSONObject)o;  //accedo al json object
			        String format = (String)o1.get("format"); //accedo alla variabile "format" e la salvo su una variabile Stringa
			        String urlD = (String)o1.get("url"); //accedo alla variabile "url" e salvo su una variabile stringa
			        System.out.println(format + " | " + urlD);
			        if(format.equals("csv")) {
			        	//se il formato è csv eseguo il download del file csv presente nel link del campo url
			        	download(urlD, "ds517_Infortuni_2004-2009.csv");
			        }
			    }
			}
			System.out.println( "OK" );
		} catch (IOException | ParseException e ) { //controllo se si verificano eccezioni di input o di parsing
			e.printStackTrace();
		} catch (Exception e) { //controllo se si verificano eccezioni di qualsiasi genere
			e.printStackTrace();
		}
	}
	
	public static void download(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName)); //scarico il file da uno stream di input e lo inserisco in un Path
	    }
	}

}
