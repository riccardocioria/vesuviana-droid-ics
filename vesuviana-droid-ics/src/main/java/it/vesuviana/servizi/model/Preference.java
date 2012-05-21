package it.vesuviana.servizi.model;

import com.j256.ormlite.field.DatabaseField;

public class Preference {
	@DatabaseField(id = true, columnName = "name", canBeNull = false)
	public String name;
	
	@DatabaseField(columnName = "value", canBeNull = false)
	public String value;
	
	public Preference() {
		// need by ormlite
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name=").append(name);
		sb.append(", ").append("value=").append(value);
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!o.getClass().equals(getClass())) return false;
		Preference p = (Preference)o;
		if (!name.equals(p.name)) return false;
		if (!value.equalsIgnoreCase(p.value)) return false;
		return true;
	}
}
