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
	/**Creo la richiesta per la restituzione dei metadati e il relativo metodo che li restituisce in un JSONArray.
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
	/**Creo la rechiesta per la restituzione dei dati. Nel metodo utilizzodo il metodo dati() presente in EsameService
	 * per la restituzione del JSONArray contenente tutti i dati in formato JSON
	 * @return JSONArray contenente tutti i dati*/
	@GetMapping("/dati")
	public JSONArray dati() {
		return a.dati();
	}
	/**Creo la richiesta per la restituzione delle stats. Nel metodo utilizzo @PathVariable, che recupera 
	 * il valore di {scelta} dall'URL, e lo assegna a tale variabile. Successivamente creo un'istanza della classe Calcoli ed eseguo 
	 * con i metodi di tale classe la media, ricerca min/max, ecc... e li inserisco in un JSONObject, 
	 * inserito in un JSONArray che verrà restituito
	 * @return Ritorna il JSONArray contenente tutte le stats calcolate*/ 
	@GetMapping("/stats/{scelta}")
	public JSONArray stats(@PathVariable String scelta) {
		int colonna=0;
		JSONArray array=new JSONArray();
		JSONObject obj1=new JSONObject();
		if(scelta.equals("anno") || scelta.equals("Caratteristiche infortunato") || scelta.equals("Carattersitiche infortunato") ) {
			String a="Non esistono statistiche per questa scelta!";
			obj1.put("Errore", a);
			array.add(obj1);
			return array;
		}
		if(scelta.equals("infortuni")) colonna=2;
		if(scelta.equals("infortunimortali")) colonna=3;
		Calcoli a=new Calcoli();
		ArrayList<Integer> vector=new ArrayList<Integer>();
		vector=a.restituzioneArray(colonna);
		obj1.put("avg", a.CalcoloMedia(vector));
		obj1.put("min", a.TrovaMin(vector));
		obj1.put("max", a.TrovaMax(vector));
		obj1.put("std", a.calculateSD(vector));
		obj1.put("sum", a.Somma(vector));
		array.add(obj1);
		
		return array;
	}

	
	@GetMapping("/dare")
	public JSONArray filtri () {
		JSONArray array= new JSONArray();
		FilterUtils prova=new FilterUtils();
		for(int i=0; i<a.csvparse.getDati().size(); i++) {
			if (prova.checkConditional(Integer.parseInt(a.csvparse.getDati().get(i).getInfortuni()), "$gt",10000)) {
				JSONObject obj=new JSONObject();
				obj.put("filtro", a.csvparse.getDati().get(i));
				array.add(obj);
			}
				
		}
		return array;
	}

}
