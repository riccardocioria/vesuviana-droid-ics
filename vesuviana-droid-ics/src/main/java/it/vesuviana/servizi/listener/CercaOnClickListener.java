package it.vesuviana.servizi.listener;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;

import it.vesuviana.servizi.command.CmdRetrieveSolutions;
import it.vesuviana.servizi.command.request.RetrieveSolutionsRequest;
import it.vesuviana.servizi.db.OfflineDbOpenHelper;
import it.vesuviana.servizi.model.Solution;
import it.vesuviana.servizi.model.Stazioni.Stazione;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

public class CercaOnClickListener implements OnClickListener {
	private Solution toSearch;
	private View partenza, arrivo, orario, data;
	OfflineDbOpenHelper dbHelper;
	public void onClick(View v) {
		// recupero delle stazioni
		try {
			init();
			Dao<Stazione, String> simpleDao = dbHelper.getStazioneDao();
			Stazione partenza = simpleDao.queryForEq("nome_staz", toSearch.getPartenza()).get(0);
			Stazione arrivo = simpleDao.queryForEq("nome_staz", toSearch.getArrivo()).get(0);
			toSearch.setPartenza(partenza.codStazione);
			toSearch.setArrivo(arrivo.codStazione);
			Object response = new CmdRetrieveSolutions().execute(new RetrieveSolutionsRequest(toSearch));
			// TODO continuare con la ricezione del file JSON
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public CercaOnClickListener() {
		super();
		toSearch = new Solution();
	}

	public CercaOnClickListener(View partenza, View arrivo,
			View orario, View data, OfflineDbOpenHelper dbHelper) {
		this();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.orario = orario;
		this.data = data;
		this.dbHelper = dbHelper;
	}

	private void init(AutoCompleteTextView partenza, AutoCompleteTextView arrivo, TimePicker orario, DatePicker data) {
		toSearch.setPartenza(partenza.getText().toString());
		toSearch.setArrivo(arrivo.getText().toString());
		toSearch.setOra(orario.getCurrentHour().toString());
		toSearch.setMinuti(orario.getCurrentMinute().toString());
		toSearch.setGiorno("" + data.getDayOfMonth());
		toSearch.setMese("" + data.getMonth());
		toSearch.setAnno("" + data.getYear());
	}

	private void init(Spinner partenza, Spinner arrivo, TimePicker orario, DatePicker data) {
		toSearch.setPartenza(partenza.getSelectedItem().toString());
		toSearch.setArrivo(arrivo.getSelectedItem().toString());
		toSearch.setOra(orario.getCurrentHour().toString());
		toSearch.setMinuti(orario.getCurrentMinute().toString());
		toSearch.setGiorno("" + data.getDayOfMonth());
		toSearch.setMese("" + data.getMonth());
		toSearch.setAnno("" + data.getYear());
	}

	public void init() { 
		if(partenza instanceof AutoCompleteTextView && arrivo instanceof AutoCompleteTextView) {
			init((AutoCompleteTextView)partenza, (AutoCompleteTextView)arrivo, (TimePicker)orario, (DatePicker)data);
		}
		else if(partenza instanceof Spinner && arrivo instanceof Spinner) {
			init((Spinner)partenza, (Spinner)arrivo, (TimePicker)orario, (DatePicker)data);
		}
	}

	/**
	 * @return the toSearch
	 */
	public Solution getToSearch() {
		return toSearch;
	}

	/**
	 * @param toSearch the toSearch to set
	 */
	public void setToSearch(Solution toSearch) {
		this.toSearch = toSearch;
	}

	/**
	 * @return the partenza
	 */
	public View getPartenza() {
		return partenza;
	}

	/**
	 * @param partenza the partenza to set
	 */
	public void setPartenza(View partenza) {
		this.partenza = partenza;
	}

	/**
	 * @return the arrivo
	 */
	public View getArrivo() {
		return arrivo;
	}

	/**
	 * @param arrivo the arrivo to set
	 */
	public void setArrivo(View arrivo) {
		this.arrivo = arrivo;
	}

	/**
	 * @return the data
	 */
	public View getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(View data) {
		this.data = data;
	}

	/**
	 * @param orario the orario to set
	 */
	public void setOrario(View orario) {
		this.orario = orario;
	}

	/**
	 * @return the orario
	 */
	public View getOrario() {
		return orario;
	}

	
}
