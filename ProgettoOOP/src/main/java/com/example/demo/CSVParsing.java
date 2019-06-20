package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**Classe utilizzata per effettuare il parsing del csv inserendo i dati di volta in volta in oggetti Infortuni
 * che a loro volta vengono aggiunti in una ArrayList. Il titolo viene memorizzato in una stringa a parte.
 * @author MattiaSospetti
 * @author NicolaMori*/
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
		}
		/**Metodo per restituire il titolo.
		 * @return La stringa che contiene il titolo.*/
		public String[] getTitolo() {
			return titolo;
		}
		/**Metodo per restituire l'ArrayList che contiene tutti i dati presenti nel csv.
		 * @return ArrayList che contiene tutti dati. */
		public ArrayList<Infortuni> getDati() {
			return dati;
		}

}
