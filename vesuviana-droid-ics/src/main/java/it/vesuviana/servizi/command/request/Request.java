package it.vesuviana.servizi.command.request;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;

public abstract class Request extends HttpGet {
	private Map<String, Object> attributes;
	public String URL;
	
	public Request(String url) {
		super(url);
		attributes = new HashMap<String, Object>();
		URL = url;
	}
	
	public Object getAttribute(String key) {
		return attributes.get(key);
	}
	
	public void setAttribute(String key, Object value) {
		attributes.put(key, value);
	}
}
