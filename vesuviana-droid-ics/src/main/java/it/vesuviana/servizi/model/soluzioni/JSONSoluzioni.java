package it.vesuviana.servizi.model.soluzioni;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class JSONSoluzioni {

	@SerializedName("JSONSoluzioni")
	private Soluzioni[] JSONSoluzioni;

	public static class Soluzioni {
		@SerializedName("errore")
		private Errore errore;

		@SerializedName("intestazione")
		private Intestazione intestazione;

		@SerializedName("tariffa")
		private Tariffa tariffa;

		@SerializedName("soluzioni")
		private Soluzione[] soluzioni;

		/**
		 * @return the errore
		 */
		public Errore getErrore() {
			return errore;
		}

		/**
		 * @param errore the errore to set
		 */
		public void setErrore(Errore errore) {
			this.errore = errore;
		}

		/**
		 * @return the intestazione
		 */
		public Intestazione getIntestazione() {
			return intestazione;
		}

		/**
		 * @param intestazione the intestazione to set
		 */
		public void setIntestazione(Intestazione intestazione) {
			this.intestazione = intestazione;
		}

		/**
		 * @return the tariffa
		 */
		public Tariffa getTariffa() {
			return tariffa;
		}

		/**
		 * @param tariffa the tariffa to set
		 */
		public void setTariffa(Tariffa tariffa) {
			this.tariffa = tariffa;
		}

		/**
		 * @return the soluzioni
		 */
		public Soluzione[] getSoluzioni() {
			return soluzioni;
		}

		/**
		 * @param soluzioni the soluzioni to set
		 */
		public void setSoluzioni(Soluzione[] soluzioni) {
			this.soluzioni = soluzioni;
		}
	}

	/**
	 * @param jSONSoluzioni the jSONSoluzioni to set
	 */
	public void setJSONSoluzioni(Soluzioni[] jSONSoluzioni) {
		JSONSoluzioni = jSONSoluzioni;
	}

	/**
	 * @return the jSONSoluzioni
	 */
	public Soluzioni[] getJSONSoluzioni() {
		return JSONSoluzioni;
	}

	// MAPPING PER LA ListActivity
	public List<Map<String, String>> getSoluzioni()
	{
		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
		for(int i = 0; i < JSONSoluzioni.length; i++)
			for (Soluzione soluzione : JSONSoluzioni[i].getSoluzioni())
			{
				ret.add(soluzione.getMap());
			}
		return ret;
	}
}
