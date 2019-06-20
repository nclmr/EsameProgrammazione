package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
/**Classe utilizzata per effettuare i calcoli che poi verranno restituiti in formato JSON, sono presenti
 * tutti i metodi che effettuano i calcoli richiesti.
 * @author MattiaSospetti
 * @author NicolaMori*/

public class Calcoli {
	public CSVParsing csvparse=new CSVParsing();{
	try {
		csvparse.Parsing();
	}
	catch(IOException e) {
		e.printStackTrace();}
	}
	
	/**Metodo che crea un oggetto ArrayList di interi, e nel caso in cui il parametro che gli passo
	 * è uguale a 2 o 3, aggiunge all'ArrayList i numeri corrispondenti restituiti dai metodi getInfortuni
	 * e getInfortunimortali.
	 * @param colonna Specificare con quale campo riempire l'ArrayList.
	 * @return array Ritorna l'ArrayList riempita di tutti i valori scelti.*/
	public ArrayList<Integer> restituzioneArray(int colonna){
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(int i=0;i<csvparse.getDati().size();i++) {
			if(colonna==2) array.add(Integer.parseInt(csvparse.getDati().get(i).getInfortuni()));
			if(colonna==3) array.add(Integer.parseInt(csvparse.getDati().get(i).getInfortunimortali()));
		}
		
		return array;
	}
	/**Metodo per il calcolo della media, con un ciclo for sommo tutti gli elementi contenuti nell'ArrayList
	 * e divido per il numero degli elementi contenuti nell'ArrayList.
	 * @param array ArrayList dove sono contenuti tutti gli elementi su cui calcolare la media.
	 * @return la media dei valori dell'ArrayList. */
	public int CalcoloMedia(ArrayList<Integer> array) {
		int i;
		int sum=0;
		for(i=0;i<array.size();i++) {
			sum=sum+array.get(i);
		}
		return sum/i;
	}
	/**Metodo per la ricerca del minimo, suppongo che il minimo sia il primo elemento, controllo se l'ArrayList
	 * è vuota, con un ciclo for verifico che i restanti elementi dell'ArrayList siano maggiori del primo, se così non fosse il
	 * minimo diventa l'elemento per cui non si verifica tale condizione.
	 * @param array ArrayList dove sono contenuti tutti gli elementi su cui calcolare la media.
	 * @return l'intero minimo presente nell'ArrayList.*/
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
	/**Metodo la ricerca del massimo, suppongo che il massimo sia il primo elemento, controllo che l'ArrayList non sia
	 * vuota, con un ciclo for verifico che tutti gli elementi restanti dell'ArrayList siano minori del primo, se così
	 * non fosse il massimo diventa l'elemento per cui non si verifica tale condizione.
	 * @param array ArrayList dove sono contenuti tutti gli elementi su cui calcolare la media.
	 * @return l'intero massimo presente nell'ArrayList.*/
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
	/**Metodo per calcolare la somma degli elementi presenti nell'ArrayList, controllo che l'ArrayList non
	 * sia vuota, sommo tutti gli elementi dell'ArrayList con un ciclo for estraendoli con il metodo get().
	 * @param array L'ArrayList che contiene tutti gli elementi da sommare.
	 * @return l'intero che risulta essere la somma di tutti gli elementi dell'ArrayList. */
	public int Somma(ArrayList<Integer> array) {
		int i;
		int sum=0;
		if(array.size()==0) return 0;
		for(i=0;i<array.size();i++) {
			sum=sum+array.get(i);
		}
		return sum;
	}
	/** Metodo per il calcolo della Deviazione Standard.
	 * @param array L'ArrayList che contiene gli elementi su cui effettuare il calcolo della Deviazione Standard.
	 * @return l'int su cui viene calcolata la deviazione standard.*/
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