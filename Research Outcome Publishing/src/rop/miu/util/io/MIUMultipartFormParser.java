package rop.miu.util.io;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;

import rop.miu.util.exceptions.MIUIOException;

public class MIUMultipartFormParser extends MIUFormParser{

	private List<FileItem> items = null;
	
	public MIUMultipartFormParser(HttpServletRequest request) throws MIUIOException{
		super(request);
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			MIUIOUtilMethod instance = new MIUIOUtilMethod();
			URL tmpFolder = instance.getTmpFolder();
			File repository = new File(tmpFolder.getFile().replace("%20", " "));
			factory.setRepository(repository);
			ServletFileUpload uploadServlet = new ServletFileUpload(factory);
			items = uploadServlet.parseRequest(request);
		}
		catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public String getString(String formEntry)
			throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String value = (item != null) ? item.getString() : null;
			return value;
		}
		catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	@Override
	public String getStringMatching(String formEntry, String pattern)
			throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String value = (item != null) ? item.getString() : null;
			if(value != null && !value.matches(pattern))
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			return value;
		}
		catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	@Override
	public Integer getInteger(String formEntry) throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String st = (item != null) ? item.getString() : null;
			if(st != null)
				return Integer.parseInt(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	@Override
	public Double getDouble(String formEntry) throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String st = (item != null) ? item.getString() : null;
			if(st != null)
				return Double.parseDouble(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	@Override
	public Float getFloat(String formEntry) throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String st = (item != null) ? item.getString() : null;
			if(st != null)
				return Float.parseFloat(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	@Override
	public Long getLong(String formEntry) throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String st = (item != null) ? item.getString() : null;
			if(st != null)
				return Long.parseLong(st);
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	@Override
	public Date getDate(String formEntry) throws MIUIOException {
		try{
			FileItem item = getItem(formEntry);
			String st = (item != null) ? item.getString() : null;
			if(st != null)
				return DateTime.parse(st).toDate();
			return null;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	@Override
	public boolean fieldExists(String formEntry) {
		FileItem item = getItem(formEntry);
		return (item != null);
	}
	
	public Upload uploadFileTo(String formEntry, String destFolder, UploadCondition condition) throws MIUIOException {
		try{
			if(condition == null)
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			File dest = new File(destFolder);
			if(!dest.exists() || !dest.isDirectory())
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			Upload upload = null;
			FileItem item = getItem(formEntry);
			if(item != null && !item.isFormField() && item.getFieldName().equals(formEntry)){
				String fileName = item.getName().substring(0, item.getName().lastIndexOf("."));
			    String  fileExtension = FilenameUtils.getExtension(item.getName());
			    if(condition.validateUpload(fileExtension, fileName, item.getSize())){
			    	Date date = new Date();
			    	String newFileName = fileName+"-"+date.getTime();
			    	File uploadedFile = new File(dest, newFileName +"."+ fileExtension);
			    	item.write(uploadedFile);
			    	//dest.notifyAll();
			    	upload = new Upload(new File(uploadedFile.getAbsolutePath().replace("%20", " ")), item.getName(), date);
			    }else
			    	throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			}
			return upload;
		}
		catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}

	public Upload uploadFile(String formEntry, UploadCondition condition) throws MIUIOException {
		try{
			if(condition == null)
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			MIUIOUtilMethod instance = new MIUIOUtilMethod();
			URL tmpFolder = instance.getTmpFolder();
			File repository = new File(tmpFolder.getFile().replace("%20", " "));
			Upload upload = null;
			FileItem item = getItem(formEntry);
			if(item != null && !item.isFormField() && item.getFieldName().equals(formEntry)){
				String fileName = item.getName().substring(0, item.getName().lastIndexOf("."));
			    String  fileExtension = FilenameUtils.getExtension(item.getName());
			    if(condition.validateUpload(fileExtension, fileName, item.getSize())){
			    	if(MIUIOUtilMethod.getFolderLength(tmpFolder.getFile().replace("%20", " ")) + item.getSize() > condition.getTmpMemoryMaxSize())
			    		throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			    	Date date = new Date();
			    	String newFileName = fileName+"-"+date.getTime();
			    	File uploadedFile = new File(repository, newFileName +"."+ fileExtension);
			    	item.write(uploadedFile);
			    	//repository.notifyAll();
			    	upload = new Upload(new File(uploadedFile.getAbsolutePath().replace("%20", " ")), item.getName(), date);
			    }else
			    	throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			}
			return upload;
		}
		catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public HashMap<String, Object> collectData(HashMap<String, UploadCondition> conditions) throws MIUIOException{
		HashMap<String, Object> result = new HashMap<String, Object>();
		ArrayList<Upload> rollBack = new ArrayList<Upload>();
		try{
			if(conditions == null)
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			MIUIOUtilMethod instance = new MIUIOUtilMethod();
			URL tmpFolder = instance.getTmpFolder();
			File repository = new File(tmpFolder.getFile().replace("%20", " "));
			Upload upload = null;
			UploadCondition condition = null;
			String fileName;
			String  fileExtension;
			long size = 0;
			for(FileItem item : items){
				if(item.isFormField())
					result.put(item.getFieldName(), item.getString());
				else{
					condition = conditions.get(item.getFieldName());
					if(condition == null)
						throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
					fileName = item.getName().substring(0, item.getName().lastIndexOf("."));
				    fileExtension = FilenameUtils.getExtension(item.getName());
				    if(condition.validateUpload(fileExtension, fileName, item.getSize())){
				    	if(MIUIOUtilMethod.getFolderLength(tmpFolder.getFile().replace("%20", " ")) + item.getSize() > condition.getTmpMemoryMaxSize())
				    		throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
				    	size += item.getSize();
				    }else
				    	throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
				}
			}
			if(MIUIOUtilMethod.getFolderLength(tmpFolder.getFile().replace("%20", " ")) + size > condition.getTmpMemoryMaxSize())
	    		throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			for(FileItem item : items){
				if(!item.isFormField()){
					upload = null;
					fileName = item.getName().substring(0, item.getName().lastIndexOf("."));
				    fileExtension = FilenameUtils.getExtension(item.getName());
				    Date date = new Date();
			    	String newFileName = fileName+"-"+date.getTime();
			    	File uploadedFile = new File(repository, newFileName +"."+ fileExtension);
			    	item.write(uploadedFile);
			    	upload = new Upload(new File(uploadedFile.getAbsolutePath().replace("%20", " ")), item.getName(), date);
			    	result.put(item.getFieldName(), upload);
			    	rollBack.add(upload);
				}
			}
			//if(!rollBack.isEmpty())
				//repository.notifyAll();
			return result;
		}
		catch(Exception e){
			for(Upload up : rollBack)
				up.getUploadedFile().delete();
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public HashMap<String, Object> collectDataTo(String destFolder, HashMap<String, UploadCondition> conditions) throws MIUIOException{
		HashMap<String, Object> result = new HashMap<String, Object>();
		ArrayList<Upload> rollBack = new ArrayList<Upload>();
		try{
			if(conditions == null)
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			File dest = new File(destFolder);
			if(!dest.exists() || !dest.isDirectory())
				throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
			Upload upload = null;
			UploadCondition condition = null;
			String fileName;
			String  fileExtension;
			for(FileItem item : items){
				if(item.isFormField())
					result.put(item.getFieldName(), item.getString());
				else{
					condition = conditions.get(item.getFieldName());
					if(condition == null)
						throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
					fileName = item.getName().substring(0, item.getName().lastIndexOf("."));
				    fileExtension = FilenameUtils.getExtension(item.getName());
				    if(!condition.validateUpload(fileExtension, fileName, item.getSize()))
				    	throw new MIUIOException("Document invalide : absence du noeud miu-extension ");
				}
			}
			for(FileItem item : items){
				if(!item.isFormField()){
					upload = null;
					fileName = item.getName().substring(0, item.getName().lastIndexOf("."));
				    fileExtension = FilenameUtils.getExtension(item.getName());
				    Date date = new Date();
			    	String newFileName = fileName+"-"+date.getTime();
			    	File uploadedFile = new File(dest, newFileName +"."+ fileExtension);
			    	item.write(uploadedFile);
			    	upload = new Upload(new File(uploadedFile.getAbsolutePath().replace("%20", " ")), item.getName(), date);
			    	result.put(item.getFieldName(), upload);
			    	rollBack.add(upload);
				}
			}
			//if(!rollBack.isEmpty())
				//dest.notifyAll();
			return result;
		}
		catch(Exception e){
			for(Upload up : rollBack)
				up.getUploadedFile().delete();
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	private FileItem getItem(String formEntry) {
		for(FileItem item : items)
			if(item.getFieldName().equals(formEntry))
				return item;
		return null;
	}
}
