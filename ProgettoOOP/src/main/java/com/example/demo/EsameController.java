package com.example.demo;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EsameController {
	@Autowired
	private EsameService a;
	
	@GetMapping("/metadati")
	public JSONArray metadati() {
		/*JSONArray array=new JSONArray();
		for(int i=0;i<4;i++) {
			array.add(a.jsonparse.getTitolo()[i]);
		}
		System.out.println(array);
		JSONObject obj=new JSONObject();
		obj.put("Metadati ", array);
		System.out.println(obj);
		return obj;*/
		JSONArray array=new JSONArray();
		//JSONObject obj= new JSONObject();
		for(int i=0;i<4;i++) {
			JSONObject obj= new JSONObject();
			obj.put("descrizione", a.csvparse.getTitolo()[i]);
			array.add(obj);
		}
		return array;
	}
	
	@GetMapping("/dati")
	public JSONArray dati() {
		return a.dati();
	}
	
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
		/*array.add(obj2);
		array.add(obj3);
		array.add(obj4);
		array.add(obj5);*/
		
		return array;
	}
}
