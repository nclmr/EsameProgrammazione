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
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.ParseException;
import org.json.simple.*;

/**Classe utilizzata per effettuare il download del dataset leggendo dall'url assegnato il file JSON attraverso
 * le classi URLConnection, InputStream, InputStreamReader, BufferedReader. 
 * Il file JSON viene letto utilizzando le classi JSONObject e JSONArray, poi viene estratto l'url
 * del file .csv che viene utilizzato per effettuare il download.
 * @author MattiaSospetti
 * @author NicolaMori*/
public class Download {
	public static void Download() {
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=795ae7f4-421b-4ba2-9a8e-42bc28980dc7";	
		try {
			
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in = openConnection.getInputStream();
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inR = new InputStreamReader( in );
			   BufferedReader buf = new BufferedReader( inR );
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
				   System.out.println( line );
			   }
			 } finally {
			   in.close();
			 }
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));
			for(Object o: objA){
			    if ( o instanceof JSONObject ) { 
			        JSONObject o1 = (JSONObject)o;  
			        String format = (String)o1.get("format"); 
			        String urlD = (String)o1.get("url"); 
			        System.out.println(format + " | " + urlD);
			        if(format.equals("csv")) {
			        	download(urlD, "ds517_Infortuni_2004-2009.csv");
			        }
			    }
			}
		} catch (IOException | ParseException e ) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**Questo metodo viene utilizzato per scaricare il file .csv aprendo uno stream e con Files.copy() 
	 * viene copiato byte per byte e salvato in un path.
	 * @param url URL dove è contenuto il csv
	 * @param fileName Nome del file salvato
	 * @throws Exception*/
	public static void download(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName), REPLACE_EXISTING);
	    }
	}

}
