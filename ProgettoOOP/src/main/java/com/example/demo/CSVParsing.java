package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParsing {
	 String line="";
	    private String[] titolo;
	    private ArrayList<Infortuni> dati;
		String Split=";";
		String csvFile="ds517_Infortuni_2004-2009.csv";
		public void Parsing() throws IOException {
			BufferedReader br=new BufferedReader(new FileReader(csvFile));
			int i=0;
			line=br.readLine();
			titolo=line.split(Split);
			dati=new ArrayList<Infortuni>();
			
			while((line=br.readLine())!=null) {
			String[] a=new String[4];
			a=line.split(Split);
			Infortuni temp=new Infortuni(a[0], a[1], a[2], a[3]);
			dati.add(temp);
			i++;
			}
			/*int k=0;
			while(k<dati.size()) {
				System.out.println(dati.get(k));
				k++;
			}*/
		}
		public String[] getTitolo() {
			return titolo;
		}
		public ArrayList<Infortuni> getDati() {
			return dati;
		}

}
