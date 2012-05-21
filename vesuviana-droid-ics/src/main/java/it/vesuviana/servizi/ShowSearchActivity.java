package it.vesuviana.servizi;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.vesuviana.servizi.command.CmdRetrieveSolutions;
import it.vesuviana.servizi.command.request.RetrieveSolutionsRequest;
import it.vesuviana.servizi.model.Solution;
import it.vesuviana.servizi.model.soluzioni.JSONSoluzioni;
import it.vesuviana.servizi.model.soluzioni.Soluzione;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class ShowSearchActivity extends ListActivity {
	static final int DIALOG_DETAIL = 0;
	protected Soluzione[] soluzioni;
	ProgressDialog dialog;
	SearchThread thread;
	protected Object mActionMode;
	protected int selectedPosition=0;
	
	final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
        	showSearched();
        	dialog.dismiss();
        }
    };
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar ab = getActionBar();
		ab.setHomeButtonEnabled(true);
		ab.setDisplayHomeAsUpEnabled(true);
		
		dialog = ProgressDialog.show(ShowSearchActivity.this, "", 
                getString(R.string.caricamento), true);
		thread = new SearchThread(handler);
		thread.start();
	}
	
	private void showSearched() {
		getListView().setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Context mContext = parent.getContext();
				Log.i("ShowSearchActivity", "Creating dialog...");
				Dialog dialog = new Dialog(mContext);
				
				dialog.setContentView(R.layout.detail_dialog);
				dialog.setTitle("Dettagli viaggio");
				dialog.setCancelable(true);
				
				populateDetailDialog(dialog, position);
				dialog.setOwnerActivity(ShowSearchActivity.this);
				dialog.show();
				//TODO show Dialog
			}
		});
		
		getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View v,
					int position, long id) {
				if (mActionMode != null) {
					return false;
				}
				
				// Start the CAB using the ActionMode.Callback defined above
				mActionMode = ShowSearchActivity.this
						.startActionMode(mActionModeCallback);
				v.setSelected(true);
				
				selectedPosition = position;
				return true;
			}
		});
		setListAdapter(new MyAdapter());
	}
	
	private void populateDetailDialog(Dialog dialog, int position) {
		TextView orarioPartenza = (TextView) dialog.findViewById(R.id.dialogOrarioPartenza);
		TextView orarioArrivo = (TextView) dialog.findViewById(R.id.dialogOrarioArrivo);
		TextView numCambi = (TextView) dialog.findViewById(R.id.dialogNumCambi);
		TextView numMezzo1 = (TextView) dialog.findViewById(R.id.dialogNumMezzo1);
		
		orarioPartenza.setText(soluzioni[position].getOraPartenza());
		orarioArrivo.setText(soluzioni[position].getOraArrivo());
		numCambi.setText(soluzioni[position].getNumCambi().toString());
		numMezzo1.setText(soluzioni[position].getNumMezzo1().toString());
	}
	
	private final class SearchThread extends Thread {
		Handler mHandler;
		
		public SearchThread(Handler h) {
			mHandler = h;
		}
		@Override 
		public void run() {
			Solution toSearch = (Solution) getIntent().getSerializableExtra("toSearch");
			try {
				JSONSoluzioni response = (JSONSoluzioni)new CmdRetrieveSolutions().execute(new RetrieveSolutionsRequest(toSearch));
				soluzioni = response.getJSONSoluzioni()[0].getSoluzioni();
				mHandler.sendEmptyMessage(RESULT_OK);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	private final class MyAdapter extends BaseAdapter
	{
		
		public View getView(int position, View convertView, ViewGroup parent)
		{
			RowWrapper wrapper;
			if (convertView == null)
			{
				convertView = getLayoutInflater().inflate(
						R.layout.solutions_row, null);
				wrapper = new RowWrapper(convertView);
				convertView.setTag(wrapper);
				
			}
			else
			{
				wrapper = (RowWrapper) convertView.getTag();
			}
			Soluzione soluzione = (Soluzione) getItem(position);
			wrapper.poulate(soluzione);
			return convertView;
		}

		public long getItemId(int position)
		{
			return position;
		}

		public Object getItem(int position)
		{
			return soluzioni[position];
		}

		public int getCount()
		{
			return soluzioni.length;
		}
	}
	
	private static class RowWrapper
	{
		private TextView partenzaTestView;
		private TextView dataTextView;
		private TextView arrivoTextView;
	 
		public RowWrapper(View convertView)
		{
			partenzaTestView = (TextView) 
				convertView.findViewById(R.id.listOrarioPartenza);
			dataTextView = (TextView) 
				convertView.findViewById(R.id.listData);
			arrivoTextView = (TextView) 
				convertView.findViewById(R.id.listOrarioArrivo);
		}
	 
		public void poulate(Soluzione soluzione)
		{
			dataTextView.setText(soluzione.getDataPrimaRich());
			partenzaTestView.setText(soluzione.getOraPartenza());
			arrivoTextView.setText(soluzione.getOraArrivo());
		}
	}
	
	
	/************ MENU/ACTION BAR ***************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.search_activity, menu);
	   
	    return true;
	}
	
	private Intent createShareIntent() {
		Intent mShareIntent = new Intent();
		mShareIntent.setType("image/*");
		return mShareIntent;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, MainActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            
	            intent.putExtra("toSearch", getIntent().getSerializableExtra("toSearch"));
	            startActivity(intent);
	            overridePendingTransition(R.anim.back_translation, R.anim.back_translation2);
	            return true;
	      
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	
	private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

		// Called when the action mode is created; startActionMode() was called
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// Inflate a menu resource providing context menu items
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.contextual, menu);
			return true;
		}

		// Called each time the action mode is shown. Always called after
		// onCreateActionMode, but
		// may be called multiple times if the mode is invalidated.
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false; // Return false if nothing is done
		}

		// Called when the user selects a contextual menu item
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			try{
				switch (item.getItemId()) {
				case R.id.message:
					Intent sendIntent = new Intent(Intent.ACTION_SEND);
					sendIntent.setType("text/plain");

					String mess = getString(R.string.messageToSend);
					mess = mess.replaceAll("<PARTENZA>", soluzioni[selectedPosition].getOraPartenza());
					mess = mess.replaceAll("<STAZIONE>", soluzioni[selectedPosition].getStazPartenza());

					sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, mess);
					// createChooser is a convenience method to create
					// an Chooser Intent with a Title
					startActivity(Intent.createChooser(sendIntent,getString(R.string.sendMessage)));
					//				Toast.makeText(ShowSearchActivity.this, "Selected menu",
					//						Toast.LENGTH_LONG).show();
					mode.finish(); // Action picked, so close the CAB
					return true;
				case R.id.event:
					Intent intent = new Intent(Intent.ACTION_EDIT);
					intent.setType("vnd.android.cursor.item/event");
					intent.putExtra("title", "Vesuviana");

					String desc = getString(R.string.messageToSend);
					desc = desc.replaceAll("<PARTENZA>", soluzioni[selectedPosition].getOraPartenza());
					desc = desc.replaceAll("<STAZIONE>", soluzioni[selectedPosition].getStazPartenza());

					String dataPartenza = soluzioni[selectedPosition].getDataPrimaRich();
					SimpleDateFormat sdf = new SimpleDateFormat();
					sdf.applyPattern("dd/MM/yyyy HH:mm");
					Date dp = sdf.parse(soluzioni[selectedPosition].getDataPrimaRich() + " " + soluzioni[selectedPosition].getOraPartenza());
					Date da = sdf.parse(soluzioni[selectedPosition].getDataPrimaRich() + " " + soluzioni[selectedPosition].getOraArrivo());

					intent.putExtra("description", desc);
					intent.putExtra("beginTime", dp.getTime());
					intent.putExtra("endTime", da.getTime());
					startActivity(intent);
				default:
					return false;
				}
			}
			catch(Exception e) {
				Log.e("Parse", "Error in date parsing for event", e);
				return false;
			}
		}

		// Called when the user exits the action mode
		public void onDestroyActionMode(ActionMode mode) {
			mActionMode = null;
		}
	};
}
