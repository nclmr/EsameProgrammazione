package com.example.demo;
/**Classe dove definisco gli attributi utilizzati per il parsing del file CSV, per ogni attributo definisco
 * metodi get e set. Anche un metodo toString() per stampare tutti gli attributi.
 * 
 * @author MattiaSospetti
 * @author NicolaMori*/
public class Infortuni {
	private String anno;
	private String caratteristica;
	private String infortuni;
	private String infortunimortali;

	
	public Infortuni (String anno, String caratteristica, String infortuni, String infortunimortali) {
		this.anno=anno;
		this.caratteristica=caratteristica;
		this.infortuni=infortuni;
		this.infortunimortali=infortunimortali;
		
	}
	
	public String toString() {
		return(this.anno+", "+this.caratteristica+", "+this.infortuni+", "+this.infortunimortali);
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getCaratteristica() {
		return caratteristica;
	}

	public void setCaratteristica(String caratteristica) {
		this.caratteristica = caratteristica;
	}

	public String getInfortuni() {
		return infortuni;
	}

	public void setInfortuni(String infortuni) {
		this.infortuni = infortuni;
	}

	public String getInfortunimortali() {
		return infortunimortali;
	}

	public void setInfortunimortali(String infortunimortali) {
		this.infortunimortali = infortunimortali;
	}


}
