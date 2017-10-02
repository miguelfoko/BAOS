package rop.miu;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class ConfigManager {

	private Document document = null;
	private DOMParser parser = null;
	
	public ConfigManager() {
		String filePath = getClass().getResource("/rop/miu/config/xml/config.xml").getFile().replace("%20", " ");
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
	
	public ArrayList<String> getModules(){
		ArrayList<String> list = new ArrayList<String>();
		NodeList nodeList = document.getElementsByTagName("module");
		int length = nodeList.getLength();
		for(int i=0; i<length; i++)
			list.add(nodeList.item(i).getTextContent());
		return list;
	}
	
	public ArrayList<String> getAdminModules(){
		ArrayList<String> list = new ArrayList<String>();
		NodeList nodeList = document.getElementsByTagName("adminmodule");
		int length = nodeList.getLength();
		for(int i=0; i<length; i++)
			list.add(nodeList.item(i).getTextContent());
		return list;
	}
	
	public boolean moduleExist(String moduleName){
		NodeList nodeList = document.getElementsByTagName("module");
		int length = nodeList.getLength();
		for(int i=0; i<length; i++){
			if(nodeList.item(i).getTextContent().equals(moduleName))
				return true;
		}
		return false;
	}
	
	public boolean adminModuleExist(String moduleName){
		NodeList nodeList = document.getElementsByTagName("adminmodule");
		int length = nodeList.getLength();
		for(int i=0; i<length; i++){
			if(nodeList.item(i).getTextContent().equals(moduleName))
				return true;
		}
		return false;
	}
	
	public String getDefaultModule(){
		NodeList nodeList = document.getElementsByTagName("default");
		if(nodeList != null && nodeList.getLength() != 0){
			String str = nodeList.item(0).getTextContent();
			if(moduleExist(str))
				return str;
		}
		return null;
	}
	
	public String getDefaultAdminModule(){
		NodeList nodeList = document.getElementsByTagName("admindefault");
		if(nodeList != null && nodeList.getLength() != 0){
			String str = nodeList.item(0).getTextContent();
			if(adminModuleExist(str))
				return str;
		}
		return null;
	}
	
	public static String setFirstUppercase(String prefix){
		if(prefix == null || prefix.length() == 0)
			return prefix;
		if(prefix.length() == 1)
			return prefix.toUpperCase();
		return ((prefix.charAt(0) + "").toUpperCase() + prefix.substring(1));
	}
	
	public static String setFirstUppercaseAndRestLowercase(String prefix){
		if(prefix == null || prefix.length() == 0)
			return prefix;
		if(prefix.length() == 1)
			return prefix.toUpperCase();
		return ((prefix.charAt(0) + "").toUpperCase() + prefix.substring(1).toLowerCase());
	}

	public String getDefaultTemplate() {
		NodeList nodeList = document.getElementsByTagName("defaulttemplate");
		if(nodeList != null && nodeList.getLength() != 0){
			String str = nodeList.item(0).getTextContent();
			if(templateExist(str))
				return str;
		}
		return null;
	}
	
	public String getDefaultAdminTemplate() {
		NodeList nodeList = document.getElementsByTagName("defaultadmintemplate");
		if(nodeList != null && nodeList.getLength() != 0){
			String str = nodeList.item(0).getTextContent();
			if(adminTemplateExist(str))
				return str;
		}
		return null;
	}
	
	public boolean templateExist(String templateName){
		NodeList nodeList = document.getElementsByTagName("template");
		int length = nodeList.getLength();
		for(int i=0; i<length; i++){
			if(nodeList.item(i).getTextContent().equals(templateName))
				return true;
		}
		return false;
	}
	
	public boolean adminTemplateExist(String templateName){
		NodeList nodeList = document.getElementsByTagName("admintemplate");
		int length = nodeList.getLength();
		for(int i=0; i<length; i++){
			if(nodeList.item(i).getTextContent().equals(templateName))
				return true;
		}
		return false;
	}
	
	public ArrayList<String> getLangTags(){
		NodeList nodeList = document.getElementsByTagName("tag");
		ArrayList<String> tags = new ArrayList<String>();
		int length = nodeList.getLength();
		for(int i=0; i<length; i++)
			tags.add(nodeList.item(i).getTextContent());
		return tags;
	}
	
	public ArrayList<String> getLangNames(){
		NodeList nodeList = document.getElementsByTagName("name");
		ArrayList<String> names = new ArrayList<String>();
		int length = nodeList.getLength();
		for(int i=0; i<length; i++)
			names.add(nodeList.item(i).getTextContent());
		return names;
	}

	public long getMaxUploadFileSize() {
		return 909600000;
	}

	public long getTmpMemoryMaxSize() {
		return 909600000;
	}
	
	public String getCurrentYear(){
		return DateTime.now().getYear()+"";
	}
	
	public String getPlatformTitle(){
		return "BAOS Publishing";
	}
}
