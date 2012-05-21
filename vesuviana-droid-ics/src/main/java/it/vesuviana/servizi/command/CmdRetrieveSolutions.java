package it.vesuviana.servizi.command;

import it.vesuviana.servizi.command.request.Request;
import it.vesuviana.servizi.model.soluzioni.JSONSoluzioni;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import com.google.gson.Gson;

public class CmdRetrieveSolutions extends Command {

	@Override
	public Object execute(Request req) throws IOException {
		InputStream source = retrieveStream(req);
		
		String json = slurp(source);
		json = json.substring(1, json.length()-1);
		
		Gson gson = new Gson();
		Reader reader = new StringReader(json);

		JSONSoluzioni response = gson.fromJson(reader, JSONSoluzioni.class);

		return response;
	}

}
