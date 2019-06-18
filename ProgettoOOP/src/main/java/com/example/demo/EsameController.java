package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	/*@GetMapping("/stats/{scelta}")
	public JSONArray stats(@PathVariable String scelta) {
		int colonna;
		if(scelta.equals("anno")) colonna=0;
		if(scelta.equals("Caratteristiche infortunato") || scelta.equals("Carattersitiche infortunato")) colonna=1;
		if(scelta.equals("infortuni")) colonna=2;
		if(scelta.equals("infortunimortali")) colonna=3;
		JSONArray array=new JSONArray();
		int avg=
		
		
	}*/
}
