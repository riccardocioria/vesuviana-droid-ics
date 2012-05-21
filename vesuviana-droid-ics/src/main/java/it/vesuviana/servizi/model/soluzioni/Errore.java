package it.vesuviana.servizi.model.soluzioni;

import com.google.gson.annotations.SerializedName;

public class Errore {
	@SerializedName("codice")
	private String codice;

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}
	
}
