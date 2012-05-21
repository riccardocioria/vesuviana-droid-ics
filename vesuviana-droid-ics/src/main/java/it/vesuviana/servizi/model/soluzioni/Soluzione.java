package it.vesuviana.servizi.model.soluzioni;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Soluzione {
	@SerializedName("id")
	private Integer id;

	@SerializedName("idsessione")
	private String idSessione;

	@SerializedName("codpartenza")
	private Integer codPartenza;

	@SerializedName("codarrivo")
	private Integer codarrivo;

	@SerializedName("stazpartenza")
	private String stazPartenza;

	@SerializedName("stazarrivo")
	private String stazArrivo;

	@SerializedName("stazcambio1")
	private String stazCambio1;

	@SerializedName("stazcambio2")
	private String stazCambio2;

	@SerializedName("orapartenza")
	private String oraPartenza;

	@SerializedName("oraarrivo")
	private String oraArrivo;

	@SerializedName("oraarrivocambio1")
	private String oraArrivoCambio1;

	@SerializedName("oraarrivocambio2")
	private String oraArrivoCambio2;

	@SerializedName("durataviaggio")
	private String durataViaggio;

	@SerializedName("mezzo1")
	private String mezzo1;

	@SerializedName("mezzo2")
	private String mezzo2;

	@SerializedName("mezzo3")
	private String mezzo3;

	@SerializedName("nummezzo1")
	private Integer numMezzo1;

	@SerializedName("nummezzo2")
	private Integer numMezzo2;

	@SerializedName("nummezzo3")
	private Integer numMezzo3;

	@SerializedName("note")
	private String note;

	@SerializedName("partenza")
	private Integer partenza;

	@SerializedName("fasciaoraria")
	private String fasciaOraria;

	@SerializedName("durataviaggiominuti")
	private Integer durataViaggioMinuti;

	@SerializedName("tratta1")
	private String tratta1;

	@SerializedName("tratta2")
	private String tratta2;

	@SerializedName("tratta3")
	private String tratta3;

	@SerializedName("nometratta1")
	private String nomeTratta1;

	@SerializedName("nometratta2")
	private String nomeTratta2;

	@SerializedName("nometratta3")
	private String nomeTratta3;

	@SerializedName("cod_tratta1")
	private Integer codTratta1;

	@SerializedName("cod_tratta2")
	private Integer codTratta2;

	@SerializedName("cod_tratta3")
	private Integer codTratta3;

	@SerializedName("tipotratta1")
	private String tipoTratta1;

	@SerializedName("tipotratta2")
	private String tipoTratta2;

	@SerializedName("tipotratta3")
	private String tipoTratta3;

	@SerializedName("num_cambi")
	private Integer numCambi;

	@SerializedName("data_prima_rich")
	private String dataPrimaRich;

	@SerializedName("data_ultima_rich")
	private String dataUltimaRich;

	@SerializedName("num_richieste")
	private Integer numRichieste;

	@SerializedName("codstazcambio1")
	private Integer codStazCambio1;

	@SerializedName("codstazcambio2")
	private Integer codStazCambio2;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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

	/**
	 * @return the codPartenza
	 */
	public Integer getCodPartenza() {
		return codPartenza;
	}

	/**
	 * @param codPartenza the codPartenza to set
	 */
	public void setCodPartenza(Integer codPartenza) {
		this.codPartenza = codPartenza;
	}

	/**
	 * @return the codarrivo
	 */
	public Integer getCodarrivo() {
		return codarrivo;
	}

	/**
	 * @param codarrivo the codarrivo to set
	 */
	public void setCodarrivo(Integer codarrivo) {
		this.codarrivo = codarrivo;
	}

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
	 * @return the stazCambio1
	 */
	public String getStazCambio1() {
		return stazCambio1;
	}

	/**
	 * @param stazCambio1 the stazCambio1 to set
	 */
	public void setStazCambio1(String stazCambio1) {
		this.stazCambio1 = stazCambio1;
	}

	/**
	 * @return the stazCambio2
	 */
	public String getStazCambio2() {
		return stazCambio2;
	}

	/**
	 * @param stazCambio2 the stazCambio2 to set
	 */
	public void setStazCambio2(String stazCambio2) {
		this.stazCambio2 = stazCambio2;
	}

	/**
	 * @return the oraPartenza
	 */
	public String getOraPartenza() {
		return oraPartenza;
	}

	/**
	 * @param oraPartenza the oraPartenza to set
	 */
	public void setOraPartenza(String oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	/**
	 * @return the oraArrivo
	 */
	public String getOraArrivo() {
		return oraArrivo;
	}

	/**
	 * @param oraArrivo the oraArrivo to set
	 */
	public void setOraArrivo(String oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	/**
	 * @return the oraArrivoCambio1
	 */
	public String getOraArrivoCambio1() {
		return oraArrivoCambio1;
	}

	/**
	 * @param oraArrivoCambio1 the oraArrivoCambio1 to set
	 */
	public void setOraArrivoCambio1(String oraArrivoCambio1) {
		this.oraArrivoCambio1 = oraArrivoCambio1;
	}

	/**
	 * @return the oraArrivoCambio2
	 */
	public String getOraArrivoCambio2() {
		return oraArrivoCambio2;
	}

	/**
	 * @param oraArrivoCambio2 the oraArrivoCambio2 to set
	 */
	public void setOraArrivoCambio2(String oraArrivoCambio2) {
		this.oraArrivoCambio2 = oraArrivoCambio2;
	}

	/**
	 * @return the durataViaggio
	 */
	public String getDurataViaggio() {
		return durataViaggio;
	}

	/**
	 * @param durataViaggio the durataViaggio to set
	 */
	public void setDurataViaggio(String durataViaggio) {
		this.durataViaggio = durataViaggio;
	}

	/**
	 * @return the mezzo1
	 */
	public String getMezzo1() {
		return mezzo1;
	}

	/**
	 * @param mezzo1 the mezzo1 to set
	 */
	public void setMezzo1(String mezzo1) {
		this.mezzo1 = mezzo1;
	}

	/**
	 * @return the mezzo2
	 */
	public String getMezzo2() {
		return mezzo2;
	}

	/**
	 * @param mezzo2 the mezzo2 to set
	 */
	public void setMezzo2(String mezzo2) {
		this.mezzo2 = mezzo2;
	}

	/**
	 * @return the mezzo3
	 */
	public String getMezzo3() {
		return mezzo3;
	}

	/**
	 * @param mezzo3 the mezzo3 to set
	 */
	public void setMezzo3(String mezzo3) {
		this.mezzo3 = mezzo3;
	}

	/**
	 * @return the numMezzo1
	 */
	public Integer getNumMezzo1() {
		return numMezzo1;
	}

	/**
	 * @param numMezzo1 the numMezzo1 to set
	 */
	public void setNumMezzo1(Integer numMezzo1) {
		this.numMezzo1 = numMezzo1;
	}

	/**
	 * @return the numMezzo2
	 */
	public Integer getNumMezzo2() {
		return numMezzo2;
	}

	/**
	 * @param numMezzo2 the numMezzo2 to set
	 */
	public void setNumMezzo2(Integer numMezzo2) {
		this.numMezzo2 = numMezzo2;
	}

	/**
	 * @return the numMezzo3
	 */
	public Integer getNumMezzo3() {
		return numMezzo3;
	}

	/**
	 * @param numMezzo3 the numMezzo3 to set
	 */
	public void setNumMezzo3(Integer numMezzo3) {
		this.numMezzo3 = numMezzo3;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the partenza
	 */
	public Integer getPartenza() {
		return partenza;
	}

	/**
	 * @param partenza the partenza to set
	 */
	public void setPartenza(Integer partenza) {
		this.partenza = partenza;
	}

	/**
	 * @return the fasciaOraria
	 */
	public String getFasciaOraria() {
		return fasciaOraria;
	}

	/**
	 * @param fasciaOraria the fasciaOraria to set
	 */
	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	/**
	 * @return the durataViaggioMinuti
	 */
	public Integer getDurataViaggioMinuti() {
		return durataViaggioMinuti;
	}

	/**
	 * @param durataViaggioMinuti the durataViaggioMinuti to set
	 */
	public void setDurataViaggioMinuti(Integer durataViaggioMinuti) {
		this.durataViaggioMinuti = durataViaggioMinuti;
	}

	/**
	 * @return the tratta1
	 */
	public String getTratta1() {
		return tratta1;
	}

	/**
	 * @param tratta1 the tratta1 to set
	 */
	public void setTratta1(String tratta1) {
		this.tratta1 = tratta1;
	}

	/**
	 * @return the tratta2
	 */
	public String getTratta2() {
		return tratta2;
	}

	/**
	 * @param tratta2 the tratta2 to set
	 */
	public void setTratta2(String tratta2) {
		this.tratta2 = tratta2;
	}

	/**
	 * @return the tratta3
	 */
	public String getTratta3() {
		return tratta3;
	}

	/**
	 * @param tratta3 the tratta3 to set
	 */
	public void setTratta3(String tratta3) {
		this.tratta3 = tratta3;
	}

	/**
	 * @return the nomeTratta1
	 */
	public String getNomeTratta1() {
		return nomeTratta1;
	}

	/**
	 * @param nomeTratta1 the nomeTratta1 to set
	 */
	public void setNomeTratta1(String nomeTratta1) {
		this.nomeTratta1 = nomeTratta1;
	}

	/**
	 * @return the nomeTratta2
	 */
	public String getNomeTratta2() {
		return nomeTratta2;
	}

	/**
	 * @param nomeTratta2 the nomeTratta2 to set
	 */
	public void setNomeTratta2(String nomeTratta2) {
		this.nomeTratta2 = nomeTratta2;
	}

	/**
	 * @return the nomeTratta3
	 */
	public String getNomeTratta3() {
		return nomeTratta3;
	}

	/**
	 * @param nomeTratta3 the nomeTratta3 to set
	 */
	public void setNomeTratta3(String nomeTratta3) {
		this.nomeTratta3 = nomeTratta3;
	}

	/**
	 * @return the codTratta1
	 */
	public Integer getCodTratta1() {
		return codTratta1;
	}

	/**
	 * @param codTratta1 the codTratta1 to set
	 */
	public void setCodTratta1(Integer codTratta1) {
		this.codTratta1 = codTratta1;
	}

	/**
	 * @return the codTratta2
	 */
	public Integer getCodTratta2() {
		return codTratta2;
	}

	/**
	 * @param codTratta2 the codTratta2 to set
	 */
	public void setCodTratta2(Integer codTratta2) {
		this.codTratta2 = codTratta2;
	}

	/**
	 * @return the codTratta3
	 */
	public Integer getCodTratta3() {
		return codTratta3;
	}

	/**
	 * @param codTratta3 the codTratta3 to set
	 */
	public void setCodTratta3(Integer codTratta3) {
		this.codTratta3 = codTratta3;
	}

	/**
	 * @return the tipoTratta1
	 */
	public String getTipoTratta1() {
		return tipoTratta1;
	}

	/**
	 * @param tipoTratta1 the tipoTratta1 to set
	 */
	public void setTipoTratta1(String tipoTratta1) {
		this.tipoTratta1 = tipoTratta1;
	}

	/**
	 * @return the tipoTratta2
	 */
	public String getTipoTratta2() {
		return tipoTratta2;
	}

	/**
	 * @param tipoTratta2 the tipoTratta2 to set
	 */
	public void setTipoTratta2(String tipoTratta2) {
		this.tipoTratta2 = tipoTratta2;
	}

	/**
	 * @return the tipoTratta3
	 */
	public String getTipoTratta3() {
		return tipoTratta3;
	}

	/**
	 * @param tipoTratta3 the tipoTratta3 to set
	 */
	public void setTipoTratta3(String tipoTratta3) {
		this.tipoTratta3 = tipoTratta3;
	}

	/**
	 * @return the numCambi
	 */
	public Integer getNumCambi() {
		return numCambi;
	}

	/**
	 * @param numCambi the numCambi to set
	 */
	public void setNumCambi(Integer numCambi) {
		this.numCambi = numCambi;
	}

	/**
	 * @return the dataPrimaRich
	 */
	public String getDataPrimaRich() {
		return dataPrimaRich;
	}

	/**
	 * @param dataPrimaRich the dataPrimaRich to set
	 */
	public void setDataPrimaRich(String dataPrimaRich) {
		this.dataPrimaRich = dataPrimaRich;
	}

	/**
	 * @return the dataUltimaRich
	 */
	public String getDataUltimaRich() {
		return dataUltimaRich;
	}

	/**
	 * @param dataUltimaRich the dataUltimaRich to set
	 */
	public void setDataUltimaRich(String dataUltimaRich) {
		this.dataUltimaRich = dataUltimaRich;
	}

	/**
	 * @return the numRichieste
	 */
	public Integer getNumRichieste() {
		return numRichieste;
	}

	/**
	 * @param numRichieste the numRichieste to set
	 */
	public void setNumRichieste(Integer numRichieste) {
		this.numRichieste = numRichieste;
	}

	/**
	 * @return the codStazCambio1
	 */
	public Integer getCodStazCambio1() {
		return codStazCambio1;
	}

	/**
	 * @param codStazCambio1 the codStazCambio1 to set
	 */
	public void setCodStazCambio1(Integer codStazCambio1) {
		this.codStazCambio1 = codStazCambio1;
	}

	/**
	 * @return the codStazCambio2
	 */
	public Integer getCodStazCambio2() {
		return codStazCambio2;
	}

	/**
	 * @param codStazCambio2 the codStazCambio2 to set
	 */
	public void setCodStazCambio2(Integer codStazCambio2) {
		this.codStazCambio2 = codStazCambio2;
	}
	
	
	// MAPPING PER LA ListActivity
	public static final String ORARIO_PARTENZA = "ORARIO_PARTENZA";
	public static final String ORARIO_ARRIVO = "ORARIO_ARRIVO";
	public static final String DATA = "DATA";
	
	protected Map<String, String> getMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(ORARIO_PARTENZA, oraPartenza);
		map.put(ORARIO_ARRIVO, oraArrivo);
		map.put(DATA, dataUltimaRich);
		return map;
	}
}


