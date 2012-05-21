package it.vesuviana.servizi.model.soluzioni;

import com.google.gson.annotations.SerializedName;

public class Intestazione {
	@SerializedName("staz_partenza")
	private String stazPartenza;
	
	@SerializedName("staz_arrivo")
	private String stazArrivo;
	
	@SerializedName("dataviaggio")
	private String dataViaggio;
	
	@SerializedName("oraviaggio")
	private String oraViaggio;
	
	@SerializedName("minutiviaggio")
	private String minutiViaggio;
	
	@SerializedName("idsessione")
	private String idSessione;

	/**
	 * @return the stazPartenza
	 */
	public String getStazPartenza() {
		return stazPartenza;
	}

	/**
	 * @param stazPartenza the stazPartenza to set
	 */
	public void setStazPartenza(String stazPartenza) {
		this.stazPartenza = stazPartenza;
	}

	/**
	 * @return the stazArrivo
	 */
	public String getStazArrivo() {
		return stazArrivo;
	}

	/**
	 * @param stazArrivo the stazArrivo to set
	 */
	public void setStazArrivo(String stazArrivo) {
		this.stazArrivo = stazArrivo;
	}

	/**
	 * @return the dataViaggio
	 */
	public String getDataViaggio() {
		return dataViaggio;
	}

	/**
	 * @param dataViaggio the dataViaggio to set
	 */
	public void setDataViaggio(String dataViaggio) {
		this.dataViaggio = dataViaggio;
	}

	/**
	 * @return the oraViaggio
	 */
	public String getOraViaggio() {
		return oraViaggio;
	}

	/**
	 * @param oraViaggio the oraViaggio to set
	 */
	public void setOraViaggio(String oraViaggio) {
		this.oraViaggio = oraViaggio;
	}

	/**
	 * @return the minutiViaggio
	 */
	public String getMinutiViaggio() {
		return minutiViaggio;
	}

	/**
	 * @param minutiViaggio the minutiViaggio to set
	 */
	public void setMinutiViaggio(String minutiViaggio) {
		this.minutiViaggio = minutiViaggio;
	}

	/**
	 * @return the idSessione
	 */
	public String getIdSessione() {
		return idSessione;
	}

	/**
	 * @param idSessione the idSessione to set
	 */
	public void setIdSessione(String idSessione) {
		this.idSessione = idSessione;
	}
	
}
