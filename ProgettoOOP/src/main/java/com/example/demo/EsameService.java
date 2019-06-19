package com.example.demo;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;
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
	/*Metodo per inizializzare un JSONArray con tutti gli attributi che vengono memorizzati 
	 * nell'ArrayList restituiti dai metodi getDati().get(i) per ogni ciclo*/
	public JSONArray dati() {
		JSONArray array=new JSONArray();
		for(int i=0;i<csvparse.getDati().size();i++) {
			array.add(csvparse.getDati().get(i)); 
		}
		return array;
	}
	
	

}
