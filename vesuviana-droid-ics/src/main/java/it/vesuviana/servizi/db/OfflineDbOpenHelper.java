package it.vesuviana.servizi.db;

import it.vesuviana.servizi.model.Preference;
import it.vesuviana.servizi.model.Stazioni.Stazione;

import java.sql.SQLException;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class OfflineDbOpenHelper extends OrmLiteSqliteOpenHelper {
	private static final String DATABASE_NAME = "JPA_vesuviana.db";
	private static final int DATABASE_VERSION = 8;
	private static final String STAZIONI_TABLE_NAME = "stazione";
	private static final String PREFERENCES_TABLE_NAME = "preference";
	
	// the DAO objects we use to access the SimpleData table
	private Dao<Stazione, String> stazioneDAO = null;
	private Dao<Preference, String> preferencesDAO = null;


	public OfflineDbOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

//	public static String getDatabaseName() {
//		return DATABASE_NAME;
//	}

	/**
	 * @return the stazioniTableName
	 */
	public static String getStazioniTableName() {
		return STAZIONI_TABLE_NAME;
	}

	/**
	 * @return the preferencesTableName
	 */
	public static String getPreferencesTableName() {
		return PREFERENCES_TABLE_NAME;
	}

	/* (non-Javadoc)
	 * @see com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase, com.j256.ormlite.support.ConnectionSource)
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(OfflineDbOpenHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, Stazione.class);
			TableUtils.createTable(connectionSource, Preference.class);

			long millis = System.currentTimeMillis();
			
			Log.i(OfflineDbOpenHelper.class.getName(), "Fine onCreate: " + millis);
		} catch (SQLException e) {
			Log.e(OfflineDbOpenHelper.class.getName(), "Problemi nella creazione del db", e);
			throw new RuntimeException(e);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, com.j256.ormlite.support.ConnectionSource, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(OfflineDbOpenHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, Stazione.class, true);
			TableUtils.dropTable(connectionSource, Preference.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(OfflineDbOpenHelper.class.getName(), "Problemi nel drop del db", e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Returns the Database Access Object (DAO) for our Stazione class. It will create it or just give the cached
	 * value.
	 */
	public Dao<Stazione, String> getStazioneDao() throws SQLException {
		if (stazioneDAO == null) {
			stazioneDAO = getDao(Stazione.class);
		}
		return stazioneDAO;
	}
	
	/**
	 * Returns the Database Access Object (DAO) for our Preferences class. It will create it or just give the cached
	 * value.
	 */
	public Dao<Preference, String> getPreferencesDao() throws SQLException {
		if (preferencesDAO == null) {
			preferencesDAO = getDao(Preference.class);
		}
		return preferencesDAO;
	}
	
	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		stazioneDAO = null;
		preferencesDAO = null;
	}
	
	/**
	 * Clear stazione table
	 * @throws SQLException 
	 */
	public void clearTableStazione() throws SQLException {
		TableUtils.clearTable(getConnectionSource(), Stazione.class);
	}
	
	/**
	 * Clear preferences table
	 * @throws SQLException 
	 */
	public void clearTablePreferences() throws SQLException {
		TableUtils.clearTable(getConnectionSource(), Preference.class);
	}

}
