package it.vesuviana.servizi;

import it.vesuviana.servizi.command.CmdRetrieveStations;
import it.vesuviana.servizi.command.request.RetrieveStationsRequest;
import it.vesuviana.servizi.db.OfflineDbOpenHelper;
import it.vesuviana.servizi.model.Preference;
import it.vesuviana.servizi.model.Solution;
import it.vesuviana.servizi.model.Stazioni;
import it.vesuviana.servizi.model.Stazioni.Stazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * @author riccardo
 *
 */
public class MainActivity extends OrmLiteBaseActivity<OfflineDbOpenHelper>  {
	private final String LOG_TAG = getClass().getSimpleName();
	private final int DEFAULT_LAYOUT = R.layout.main;
	private Solution toSearch;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try {
			//set layout
			setContentView(DEFAULT_LAYOUT);
			
			// inizializzazione componenti
			TimePicker orario = (TimePicker)findViewById(R.id.orario);
			orario.setIs24HourView(true);
			
//			Button cerca = (Button)findViewById(R.id.cerca);
//			cerca.setOnClickListener(new CercaOnClickListener(
//					findViewById(R.id.partenza),
//					findViewById(R.id.arrivo),
//					findViewById(R.id.orario),
//					findViewById(R.id.data),
//					getHelper()
//			));
			// riempimento delle stazioni in base al layout impostato
			fillStations(findViewById(R.id.partenza));
			fillStations(findViewById(R.id.arrivo));
			
			// riempimento dati
			Solution toSearh = (Solution) getIntent().getSerializableExtra("toSearch");
			if(toSearh != null) {
				AutoCompleteTextView partAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.partenza);
				AutoCompleteTextView arrAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.arrivo);
				
				partAutoCompleteTextView.setText(toSearh.getPartenza());
				arrAutoCompleteTextView.setText(toSearh.getArrivo());
			}
		} catch (SQLException e) {
			Log.e(LOG_TAG, "Database exception", e);
			Toast.makeText(this, "Database exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
			return;
		} catch (IOException e) {
			Log.e(LOG_TAG, "Database exception", e);
			Toast.makeText(this, "IO exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
			return;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity, menu);
	    
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.update:
			try {
				updateStations();
			} catch (SQLException e) {
				Log.e(LOG_TAG, "Database exception", e);
				Toast.makeText(this, "Database exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
				return false;
			} catch (IOException e) {
				Log.e(LOG_TAG, "IO exception", e);
				Toast.makeText(this, "IO exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
				return false;
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		super.onCreateOptionsMenu(menu);
//		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.menu, menu);
//		return true;
//	}	
	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle item selection
//		switch (item.getItemId()) {
//		case R.id.update:
//			try {
//				updateStations();
//			} catch (SQLException e) {
//				Log.e(LOG_TAG, "Database exception", e);
//				Toast.makeText(this, "Database exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
//				return false;
//			} catch (IOException e) {
//				Log.e(LOG_TAG, "IO exception", e);
//				Toast.makeText(this, "IO exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
//				return false;
//			}
//			return true;
//		// selezione del tipo di layout
//		case R.id.spinnerLayout:
//			try {
//				setContentView(R.layout.main);
//				setPreferredLayout(R.layout.main);
//				fillStations(findViewById(R.id.partenza));
//				fillStations(findViewById(R.id.arrivo));
//			} catch (SQLException e) {
//				Log.e(LOG_TAG, "Database exception", e);
//				Toast.makeText(this, "Database exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
//				return false;
//			} catch (IOException e) {
//				Log.e(LOG_TAG, "IO exception", e);
//				Toast.makeText(this, "IO exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
//				return false;
//			}
//			return true;
//		case R.id.autoCompleteLayout:
//			try {
//				setContentView(R.layout.main_ac);
//				setPreferredLayout(R.layout.main_ac);
//				fillStations(findViewById(R.id.partenza));
//				fillStations(findViewById(R.id.arrivo));
//			} catch (SQLException e) {
//				Log.e(LOG_TAG, "Database exception", e);
//				Toast.makeText(this, "Database exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
//				return false;
//			} catch (IOException e) {
//				Log.e(LOG_TAG, "IO exception", e);
//				Toast.makeText(this, "IO exeption: " + e.getMessage(), Toast.LENGTH_LONG).show();
//				return false;
//			}
//		default:
//			return super.onOptionsItemSelected(item);
//		}
//	}
	
	/**
	 * Fill the {@link Spinner} or {@link AutoCompleteTextView} with the stations value. It read the values on database
	 * and fill the {@link View} component.
	 * 
	 * @param view the element to fill
	 * @throws IOException if there is not Internet connection or if the retrieving fail
	 * @throws SQLException if there is error on database interaction
	 */
	private void fillStations(View view) throws IOException, SQLException {
		// get our dao
		Dao<Stazione, String> simpleDao = getHelper().getStazioneDao();
		// query for all of the data objects in the database
		List<Stazione> stazioni = simpleDao.queryForAll();
		
		if(stazioni.size() < 1)
			stazioni = updateStations();
		
		if(view instanceof AutoCompleteTextView) {
			// settaggio del numero di caratteri entro cui avviare l'autocompletamento a 1
			((AutoCompleteTextView)view).setThreshold(1);
			// creazione degli eventi da associare alle textbox di autocompletamento 
			// nel caso di click si cancella il contenuto quando è quello di partena
			((AutoCompleteTextView)view).setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					AutoCompleteTextView textBox = (AutoCompleteTextView)v;
					if (textBox.getText().toString().equals(getString(R.string.stazionePartenza))
							|| textBox.getText().toString().equals(getString(R.string.stazioneArrivo))) {
						textBox.setText("");
					}
				}
			});
			// nel caso di click lungo si cancella il contenuto anche se non è quello di partenza
			((AutoCompleteTextView)view).setOnLongClickListener(new OnLongClickListener() {
				public boolean onLongClick(View v) {
					AutoCompleteTextView textBox = (AutoCompleteTextView)v;
					textBox.setText("");
					return true;
				}
			});
			fillAutoCompleteTextBox((AutoCompleteTextView)view, stazioni);
		}
		if(view instanceof Spinner) {
			fillSpinner((Spinner)view, stazioni);
		}
	}

	/**
	 * Fill {@link AutoCompleteTextView} element with stations
	 * 
	 * @param textBox the AutoCompleteTextView to fill
	 * @param stazioni the list of the stations
	 */
	private void fillAutoCompleteTextBox(AutoCompleteTextView textBox, List<Stazione> stazioni) {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
		if(stazioni != null && stazioni.size() >0)
			for (Stazione s : stazioni)
				adapter.add(s.nomeStaz);
		textBox.setAdapter(adapter);
	}
	
	/**
	 * Fill {@link Spinner} element with stations
	 * 
	 * @param spinner the Spinner to fill
	 * @param stazioni the list of the stations
	 */
	private void fillSpinner(Spinner spinner, List<Stazione> stazioni) {
		ArrayAdapter<CharSequence> m_adapterForSpinner = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
		m_adapterForSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);        
		spinner.setAdapter(m_adapterForSpinner);

		if(stazioni != null && stazioni.size() >0)
			for (Stazione s : stazioni)
				m_adapterForSpinner.add(s.nomeStaz);
	}


	/**
	 * Check if the system has Internet access
	 * 
	 * @return <b>true</b> if is connected to Internet or <b>false</b> otherwise
	 */
	private boolean isConnected() {
		ConnectivityManager connec =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connec.getNetworkInfo(0).isConnectedOrConnecting() || connec.getNetworkInfo(1).isConnectedOrConnecting()) {
			return true;
		}
		else {
			return false;           
		}
	}

	/**
	 * This method read stations from the server and put them on the database 
	 * 
	 * @return the updated {@link List} of the stations
	 * @throws IOException if there is not Internet connection or if the retrieving fail
	 * @throws SQLException if there is error on database interaction
	 */
	private List<Stazione> updateStations() throws IOException, SQLException {
		if (isConnected()) {
			// recupero delle stazioni
			Object response = new CmdRetrieveStations().execute(new RetrieveStationsRequest());

			@SuppressWarnings("unchecked")
			List<Stazione> stazioni = (List<Stazione>) response;

			Collections.sort(stazioni, Stazioni.NOME_STAZIONE_COMPARATOR);

			// inserimento delle stazioni nel db
			Dao<Stazione, String> simpleDao = getHelper().getStazioneDao();

			getHelper().clearTableStazione();

			int i = 0;
			for(Stazione s : stazioni)
				i += simpleDao.create(s);

			Toast.makeText(this, "Record creati: " + i, Toast.LENGTH_LONG).show();
			return stazioni;
		}
		else {
			throw new IOException("Attenzione! Non è presente alcuna connessione, i dati potrebbero essere non aggiornati.");
		}
	}
	
	/**
	 * The method <b>getPreferredLayout</b> read the value of the preferred layout if it is
	 * present on the database or return the default layout id
	 * 
	 * @return the id of the preferred layout (AutoComplete or Spinner)
	 * @throws SQLException
	 */
	private int getPreferredLayout() throws SQLException {
		Dao<Preference, String> preferencesDao = getHelper().getPreferencesDao();
		Preference layout = preferencesDao.queryForId("layout");
		if(layout != null) {
			int preferredLayout = Integer.parseInt(layout.value);
			return preferredLayout;
		}
		return DEFAULT_LAYOUT;
	}
	
	/**
	 * The method <b>setPreferredLayout</b> set the preferred layout id on the database
	 * 
	 * @param preferredLayout the id of the layout to set preferred
	 * @return the number of record updated or created
	 * @throws SQLException
	 */
	private int setPreferredLayout(Integer preferredLayout) throws SQLException {
		Dao<Preference, String> preferencesDao = getHelper().getPreferencesDao();
		Preference layout = preferencesDao.queryForId("layout");
		if(layout != null) {
			layout.value = preferredLayout.toString();
			return preferencesDao.update(layout);
		}
		else {
			layout = new Preference();
			layout.name = "layout";
			layout.value = preferredLayout.toString();
			return preferencesDao.create(layout);
		}
	}
	
	public void cerca(View view) {
		init(findViewById(R.id.partenza),
				findViewById(R.id.arrivo),
				findViewById(R.id.orario),
				findViewById(R.id.data)
		);
		Dao<Stazione, String> simpleDao;
		try {
			simpleDao = getHelper().getStazioneDao();
			Stazione partenza = simpleDao.queryForEq("nome_staz", toSearch.getPartenza()).get(0);
			Stazione arrivo = simpleDao.queryForEq("nome_staz", toSearch.getArrivo()).get(0);
			toSearch.setPartenza(partenza.codStazione);
			toSearch.setArrivo(arrivo.codStazione);
			
			Intent intent = new Intent(this, ShowSearchActivity.class);
			intent.putExtra("toSearch", toSearch);
			
			startActivity(intent);
			
			overridePendingTransition(R.anim.trnaslation2, R.anim.translation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void init(View partenza, View arrivo, View orario, View data) { 
		toSearch = new Solution();
		if(partenza instanceof AutoCompleteTextView && arrivo instanceof AutoCompleteTextView) {
			init((AutoCompleteTextView)partenza, (AutoCompleteTextView)arrivo, (TimePicker)orario, (DatePicker)data);
		}
		else if(partenza instanceof Spinner && arrivo instanceof Spinner) {
			init((Spinner)partenza, (Spinner)arrivo, (TimePicker)orario, (DatePicker)data);
		}
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
}