package rop.miu.util.io;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;

import rop.miu.util.exceptions.MIUIOException;

public abstract class MIUFormParser {

	protected HttpServletRequest request;
	
	public MIUFormParser(HttpServletRequest request) throws MIUIOException{
		if(request == null)
			throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
		this.request = request;
	}
	
	public abstract String getString(String formEntry) throws MIUIOException;
	
	public abstract String getStringMatching(String formEntry, String pattern) throws MIUIOException;
	
	public abstract Integer getInteger(String formEntry) throws MIUIOException;
	
	public abstract Double getDouble(String formEntry) throws MIUIOException;
	
	public abstract Float getFloat(String formEntry) throws MIUIOException;
	
	public abstract Long getLong(String formEntry) throws MIUIOException;
	
	public abstract Date getDate(String formEntry) throws MIUIOException;
	
	public Date getDateFromMillis(String formEntry) throws MIUIOException{
		try{
			Long time = getLong(formEntry);
			if(time != null)
				return (new DateTime(time)).toDate();
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public abstract boolean fieldExists(String formEntry);
}
