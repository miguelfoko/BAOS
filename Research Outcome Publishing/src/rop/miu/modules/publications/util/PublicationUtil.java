package rop.miu.modules.publications.util;

import java.io.FileOutputStream;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import rop.miu.util.exceptions.ROPApplException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class PublicationUtil {
	
	private Document document = null;
	private DOMParser parser = null;
	private String configFile = "/rop/miu/modules/publications/xml/configPublication.xml";
	
	public PublicationUtil(){
		String filePath = getClass().getResource(configFile).getFile().replace("%20", " ");
		chargeConfig(filePath);
	}
	
	public boolean chargeConfig(String filePath){
		try{
			parser = new DOMParser();
			parser.parse(filePath);
			document = parser.getDocument();
		}catch(Exception ex){
			return false;
		}
		return true;
	}
	
	 public final String getPaperFolderUrl(){
	        return document.getElementsByTagName("work-url").item(0).getTextContent();
	    }

	  public final void setSetPaperFolderUrl(String url) throws ROPApplException{
	        NodeList nodeList = document.getElementsByTagName("work-url");
	        nodeList.item(0).setTextContent(url);
	        
	        save();
	    }
	 
	 
	 private void save() throws ROPApplException {
	        try{
	            XMLSerializer ser = new XMLSerializer(
	                new FileOutputStream(configFile), new OutputFormat("xml", "UTF-8", true));
	            ser.serialize(document);
	        }catch(Exception ex){
	            throw new ROPApplException("");
	        }
	    }
}
