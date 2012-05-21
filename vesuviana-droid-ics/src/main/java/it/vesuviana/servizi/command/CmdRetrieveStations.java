package it.vesuviana.servizi.command;

import it.vesuviana.servizi.command.request.Request;
import it.vesuviana.servizi.model.Stazioni;
import it.vesuviana.servizi.model.Stazioni.Stazione;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import com.google.gson.Gson;

public class CmdRetrieveStations extends Command {
	
	public Object execute(Request req) throws IOException {
		InputStream source = retrieveStream(req);

		String json = slurp(source);
		json = json.substring(1, json.length()-1);

		List<Stazione> stazioni = null;

		Gson gson = new Gson();
		Reader reader = new StringReader(json);

		Stazioni response = gson.fromJson(reader, Stazioni.class);
		stazioni = response.getStazioni();

		return stazioni;
	}


}
