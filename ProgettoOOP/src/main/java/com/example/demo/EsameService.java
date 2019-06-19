package com.example.demo;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;
@Service
public class EsameService {
	static CSVParsing csvparse=new CSVParsing();

	static {
		Download download=new Download();
		download.Download();
		System.out.println("download eseguito(test)");
		try{
			csvparse.Parsing();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
		}
	
	public JSONArray dati() {
		JSONArray array=new JSONArray();
		for(int i=0;i<csvparse.getDati().size();i++) {
			array.add(csvparse.getDati().get(i));
		}
		return array;
	}
	
	

}
