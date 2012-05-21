package it.vesuviana.servizi.model;

import java.io.Serializable;

public class Solution implements Serializable {
	private static final long serialVersionUID = 1L;
	private String partenza;
	private String arrivo;
	private String ora;
	private String minuti;
	private String giorno;
	private String mese;
	private String anno;
	
	/**
	 * @param partenza the partenza to set
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	/**
	 * @return the partenza
	 */
	public String getPartenza() {
		return partenza;
	}

	/**
	 * @return the arrivo
	 */
	public String getArrivo() {
		return arrivo;
	}

	/**
	 * @param arrivo the arrivo to set
	 */
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}

	/**
	 * @return the ora
	 */
	public String getOra() {
		return ora;
	}

	/**
	 * @param ora the ora to set
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}

	/**
	 * @return the minuti
	 */
	public String getMinuti() {
		return minuti;
	}

	/**
	 * @param minuti the minuti to set
	 */
	public void setMinuti(String minuti) {
		this.minuti = minuti;
	}

	/**
	 * @return the giorno
	 */
	public String getGiorno() {
		return giorno;
	}

	/**
	 * @param giorno the giorno to set
	 */
	public void setGiorno(String giorno) {
		if(giorno.length()==1)
			giorno = "0" + giorno;
		this.giorno = giorno;
	}

	/**
	 * @return the mese
	 */
	public String getMese() {
		return mese;
	}

	/**
	 * @param mese the mese to set
	 */
	public void setMese(String mese) {
		if(mese.length()==1)
			mese = "0" + mese;
		this.mese = mese;
	}

	/**
	 * @return the anno
	 */
	public String getAnno() {
		return anno;
	}

	/**
	 * @param anno the anno to set
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	/**
	 * @return the date in format gg/mm/aaaa
	 */
	public String getData() {		
		return giorno + "/" + mese + "/" + anno;
	}
}
