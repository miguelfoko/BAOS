package rop.miu.util.io;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;

import rop.miu.util.exceptions.MIUIOException;

public class MIUClassicFormParser extends MIUFormParser {
	public MIUClassicFormParser(HttpServletRequest request) throws MIUIOException{
		super(request);
	}
	
	@Override
	public String getString(String formEntry) throws MIUIOException{
		try{
			String value = request.getParameter(formEntry);
			return value;
		}
		catch(Exception e){
			throw new MIUIOException("Impossible de récupérer le paramètre "+formEntry+" comme une chaine.", e);
		}
	}

	@Override
	public String getStringMatching(String formEntry, String pattern) throws MIUIOException{
		try{
			String value = request.getParameter(formEntry);
			if(value != null && !value.matches(pattern))
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			return value;
		}
		catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public Integer getInteger(String formEntry) throws MIUIOException{
		try{
			String st = request.getParameter(formEntry);
			if(st != null)
				return Integer.parseInt(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public Double getDouble(String formEntry) throws MIUIOException{
		try{
			String st = request.getParameter(formEntry);
			if(st != null)
				return Double.parseDouble(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public Float getFloat(String formEntry) throws MIUIOException{
		try{
			String st = request.getParameter(formEntry);
			if(st != null)
				return Float.parseFloat(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public Long getLong(String formEntry) throws MIUIOException{
		try{
			String st = request.getParameter(formEntry);
			if(st != null)
				return Long.parseLong(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public Date getDate(String formEntry) throws MIUIOException{
		try{
			String st = request.getParameter(formEntry);
			if(st != null)
				return DateTime.parse(st).toDate();
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
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

	@Override
	public boolean fieldExists(String formEntry) {
		String st = request.getParameter(formEntry);
		return (st != null);
	}
}
