package it.vesuviana.servizi.command;

import it.vesuviana.servizi.command.request.Request;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public abstract class Command {
	public abstract Object execute(Request req) throws IOException;
	
	protected InputStream retrieveStream(Request getRequest) {
		DefaultHttpClient client = new DefaultHttpClient(); 

		try {
			HttpResponse getResponse = client.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK) { 
				Log.w(getClass().getSimpleName(), 
						"Error " + statusCode + " for URL " + getRequest.URL); 
				return null;
			}

			HttpEntity getResponseEntity = getResponse.getEntity();
			return getResponseEntity.getContent();

		} 
		catch (IOException e) {
			getRequest.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + getRequest.URL, e);
		}

		return null;

	}
	
	protected static String slurp(InputStream in) throws IOException {
		StringBuilder out = new StringBuilder();
		byte[] b = new byte[8192];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}
}
