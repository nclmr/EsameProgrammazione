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
			/*Apro lo stream di Lettura con un BufferedReader del file scaricato*/
			BufferedReader br=new BufferedReader(new FileReader(csvFile));
			int i=0;
			line=br.readLine(); //inizializzo line con la prima riga del file
			titolo=line.split(Split); //salvo il titolo eliminando ";" che sono gli split del file csv 
			dati=new ArrayList<Infortuni>();
			/*nel ciclo while memorizzo ogni riga inizializzando le variabili di infortuni ed alla fine
			 * ogni oggetto Infortuni vieni inserito nell'Arraylist*/
			while((line=br.readLine())!=null) {
			String[] a=new String[4];
			a=line.split(Split);
			Infortuni temp=new Infortuni(a[0], a[1], a[2], a[3]);
			dati.add(temp);
			i++;
			}
		}
		public String[] getTitolo() {
			return titolo;
		}
		public ArrayList<Infortuni> getDati() {
			return dati;
		}

}
