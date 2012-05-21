package it.vesuviana.servizi.command.request;

public class RetrieveStationsRequest extends Request {
	public RetrieveStationsRequest(String url) {
		super(url);
	}
	
	public RetrieveStationsRequest() {
		this("http://servizi.vesuviana.it/Orari/integrazione3/OrarioDinamico/www/FrontJS/jsonServer.asp?l=it&v=stazioni&r=listaStazioni");
	}

}
