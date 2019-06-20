package com.example.demo;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**Controller del progetto Spring
 * @author MattiaSospetti
 * @author NicolaMori*/
@RestController
public class EsameController {
	@Autowired //Esprimo la dipendenza della classe EsameService
	private EsameService a;
	/**Creo il root per la restituzione dei metadati e il relativo metodo che li restituisce in un JSONArray.
	 * @return JSONArray che contiene i metadati*/
	@GetMapping("/metadati") 
	public JSONArray metadati() {
		JSONArray array=new JSONArray(); 
		for(int i=0;i<4;i++) {
			JSONObject obj= new JSONObject();
			obj.put("descrizione", a.csvparse.getTitolo()[i]); 
			array.add(obj);
		}
		return array;
	}
	/**Creo il root per la restituzione dei dati. Nel metodo utilizzodo il metodo dati() presente in EsameService
	 * per la restituzione del JSONArray contenente tutti i dati in formato JSON
	 * @return JSONArray contenente tutti i dati*/
	@GetMapping("/dati")
	public JSONArray dati() {
		return a.dati();
	}
	/**Creo il root per la restituzione delle stats. Nel metodo utilizzo @PathVariable che recupera 
	 * i valori dell'URL,{scelta} consente di recuperare il valore presente nell'URL 
	 * e confrontarlo. Successivamente creo un'istanza della classe calcoli del eseguo 
	 * con i metodi di questa classe la media, ricerca min/max.. li inserisco in un JSONObject, 
	 * quest'ultimo invece lo inserisco in un JSONArray e restituisco l'Array
	 * @return Ritorna il JSONArray contenente tutte le stats calcolate*/ 
	@GetMapping("/stats/{scelta}")
	public JSONArray stats(@PathVariable String scelta) {
		int colonna=0;
		if(scelta.equals("anno")) colonna=0;
		if(scelta.equals("Caratteristiche infortunato") || scelta.equals("Carattersitiche infortunato")) colonna=1;
		if(scelta.equals("infortuni")) colonna=2;
		if(scelta.equals("infortunimortali")) colonna=3;
		Calcoli a=new Calcoli();
		ArrayList<Integer> vector=new ArrayList<Integer>();
		vector=a.restituzioneArray(colonna);
		JSONObject obj1=new JSONObject();
		JSONArray array=new JSONArray();
		obj1.put("avg", a.CalcoloMedia(vector));
		obj1.put("min", a.TrovaMin(vector));
		obj1.put("max", a.TrovaMax(vector));
		obj1.put("std", a.calculateSD(vector));
		obj1.put("sum", a.Somma(vector));
		array.add(obj1);
		
		return array;
	}
}
