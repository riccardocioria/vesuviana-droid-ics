package it.vesuviana.servizi.command.request;

import it.vesuviana.servizi.model.Solution;

public class RetrieveSolutionsRequest extends Request {

	public RetrieveSolutionsRequest(String url) {
		super(url);
	}
	
	public RetrieveSolutionsRequest(Solution toSearch) {	
		this("http://servizi.vesuviana.it/Orari/integrazione3/OrarioDinamico/www/FrontJS/jsonServer.asp?l=it&r=Soluzioni&v=JSONSoluzioni" 
				+ "&idStazionePartenza=" + toSearch.getPartenza()
				+ "&idStazioneArrivo=" + toSearch.getArrivo()
				+ "&dataPartenza=" + toSearch.getData()
				+ "&oraPartenza=" + toSearch.getOra()
				+ "&minPartenza=" + toSearch.getMinuti()
				);
	}
}
