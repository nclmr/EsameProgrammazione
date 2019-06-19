package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;


public class Calcoli {
	public CSVParsing csvparse=new CSVParsing();{
	try {
		csvparse.Parsing();
	}
	catch(IOException e) {
		e.printStackTrace();}
	}
	
	/*Restituisce l'ArrayList nel caso in cui le variabili selezionate sono infortuni o infortunimortali.
	 * L'ArrayList viene riempita da tutti i valori degli attributi infortuni e infortuni mortali*/
	public ArrayList<Integer> restituzioneArray(int colonna){
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(int i=0;i<csvparse.getDati().size();i++) {
			if(colonna==2) array.add(Integer.parseInt(csvparse.getDati().get(i).getInfortuni()));
			if(colonna==3) array.add(Integer.parseInt(csvparse.getDati().get(i).getInfortunimortali()));
		}
		
		return array;
	}
	//Calcolo della media
	public int CalcoloMedia(ArrayList<Integer> array) {
		int i;
		int sum=0;
		for(i=0;i<array.size();i++) {
			sum=sum+array.get(i);
		}
		return sum/i;
	}
	//Ricerca del minimo
	public int TrovaMin(ArrayList<Integer> array) {
		int i;
		int min=array.get(0);
		if(array.size()==0) return 0;
		for(i=1;i<array.size();i++) {
			if(min>array.get(i)) {
				min=array.get(i);
			}	
			else min=array.get(0);
		}
		return min;
		}
	//Ricerca del massimo
	public int TrovaMax(ArrayList<Integer> array) {
		int i;
		int max=array.get(0);
		if(array.size()==0) return 0;
		for(i=0;i<array.size();i++) {
			if(max<array.get(i)) {
				max=i;
			}	
		}
		return max;
		}
	//Calcolo della somma
	public int Somma(ArrayList<Integer> array) {
		int i;
		int sum=0;
		if(array.size()==0) return 0;
		for(i=0;i<array.size();i++) {
			sum=sum+array.get(i);
		}
		return sum;
	}
	//Calcolo della Deviazione Standard
	public int calculateSD(ArrayList<Integer> array)
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length =array.size();

        for(double num : array) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: array) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        
        int res=(int) Math.sqrt(standardDeviation/length);
        return res;
    }
	
}