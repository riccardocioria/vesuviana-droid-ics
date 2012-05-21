package it.vesuviana.servizi.model.soluzioni;

import com.google.gson.annotations.SerializedName;

public class Tariffa {
	@SerializedName("prezzo")
	private double prezzo;
	
	@SerializedName("titoloviaggio")
	private String titoloViaggio;
	
	@SerializedName("desc_tariffa_compl")
	private String descTariffaCompl;
	
	@SerializedName("desc_tariffa_abb")
	private String descTariffaAbb;
	
	@SerializedName("tipotariffa")
	private String tipoTariffa;

	/**
	 * @return the prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the titoloViaggio
	 */
	public String getTitoloViaggio() {
		return titoloViaggio;
	}

	/**
	 * @param titoloViaggio the titoloViaggio to set
	 */
	public void setTitoloViaggio(String titoloViaggio) {
		this.titoloViaggio = titoloViaggio;
	}

	/**
	 * @return the descTariffaCompl
	 */
	public String getDescTariffaCompl() {
		return descTariffaCompl;
	}

	/**
	 * @param descTariffaCompl the descTariffaCompl to set
	 */
	public void setDescTariffaCompl(String descTariffaCompl) {
		this.descTariffaCompl = descTariffaCompl;
	}

	/**
	 * @return the descTariffaAbb
	 */
	public String getDescTariffaAbb() {
		return descTariffaAbb;
	}

	/**
	 * @param descTariffaAbb the descTariffaAbb to set
	 */
	public void setDescTariffaAbb(String descTariffaAbb) {
		this.descTariffaAbb = descTariffaAbb;
	}

	/**
	 * @return the tipoTariffa
	 */
	public String getTipoTariffa() {
		return tipoTariffa;
	}

	/**
	 * @param tipoTariffa the tipoTariffa to set
	 */
	public void setTipoTariffa(String tipoTariffa) {
		this.tipoTariffa = tipoTariffa;
	}
}
