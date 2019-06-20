package com.example.demo;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

/**Classe Service di Spring dove creo le istanze della classe Download e utilizzo il metodo Download per
 * scaricare il file. Creo un'istanza della classe CSVParsing per effettuare il parsing del .csv.
 * @author MattiaSospetti
 * @author NicolaMori*/
@Service
public class EsameService {
	/*Creo l'istanza della classe CSVParsing*/
	static CSVParsing csvparse=new CSVParsing();

	static {
		/*Effettuo il download del file creando un'istanza della classe Download e
		 * utilizzando il metodo Download di tale classe*/
		Download download=new Download();
		download.Download();
		System.out.println("download eseguito(test)");
		try{
			csvparse.Parsing(); /*Parsing del csv*/
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
		}
	/**Metodo per aggiungere elementi in un JSONArray e restituire quest'ultimo. Il JSONArray viene 
	 * "riempito" dagli oggetti contenuti nell'ArrayList che sono della classe Infortuni.
	 * @param
	 * @return Viene restituito il JSONArray creato all'interno del metodo.*/
	public JSONArray dati() {
		JSONArray array=new JSONArray();
		for(int i=0;i<csvparse.getDati().size();i++) {
			array.add(csvparse.getDati().get(i)); 
		}
		return array;
	}
	
	

}
