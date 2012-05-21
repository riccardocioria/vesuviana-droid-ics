package it.vesuviana.servizi.model;

import java.util.Comparator;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;

import com.google.gson.annotations.SerializedName;

public class Stazioni {
	private List<Stazione> stazioni;

	public static class Stazione {
		@SerializedName("cod_stazione")
		@DatabaseField(id = true, columnName = "cod_stazione", canBeNull = false)
		public String codStazione;

		@SerializedName("nome_staz")
		@DatabaseField(columnName = "nome_staz", canBeNull = false)
		public String nomeStaz;

		@SerializedName("descrizionebreve")
		@DatabaseField(columnName = "descrizionebreve", canBeNull = false)
		public String descrizioneBreve;

		public Stazione() {
			// needed by ormlite
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("cod_stazione=").append(codStazione);
			sb.append(", ").append("nome_staz=").append(nomeStaz);
			sb.append(", ").append("descrizionebreve=").append(descrizioneBreve);
			return sb.toString();
		}

		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (!o.getClass().equals(getClass())) return false;
			Stazione s = (Stazione)o;
			if (!codStazione.equals(s.codStazione)) return false;
			if (!descrizioneBreve.equalsIgnoreCase(s.descrizioneBreve)) return false;
			if (!nomeStaz.equalsIgnoreCase(s.nomeStaz)) return false;
			return true;
		}
	}

	public void setStazioni(List<Stazione> stazioni) {
		this.stazioni = stazioni;
	}

	public List<Stazione> getStazioni() {
		return stazioni;
	}

	public static Comparator<Stazione> NOME_STAZIONE_COMPARATOR = new Comparator<Stazione>() {

		public int compare(Stazione s1, Stazione s2) {
			return String.CASE_INSENSITIVE_ORDER.compare(s1.nomeStaz, s2.nomeStaz);
		}

	};
}
