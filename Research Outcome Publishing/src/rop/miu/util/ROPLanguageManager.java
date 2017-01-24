package rop.miu.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import rop.miu.util.exceptions.ROPElementNotFoundException;


public class ROPLanguageManager {

	/**
	 * Map contenant les différents fichiers de langue (de base, de module et de composants).
	 */
	private HashMap<String, Properties> languageFiles;
	
	/**
	 * Constructeur à un argument.
	 * 
	 * @param languageTags
	 * La liste des tags de langues installées sur le site.
	 * @throws ROPElementNotFoundException
	 */
	public ROPLanguageManager(ArrayList<String> languageTags) throws ROPElementNotFoundException{
		this.initLanguageFiles(languageTags);
	}

	/**
	 * Initialisation des fichiers de langue de base.
	 * 
	 * @param languageTags
	 * La liste des tags de langues installées sur le site.
	 * @throws ROPElementNotFoundException
	 */
	private void initLanguageFiles(ArrayList<String> languageTags) throws ROPElementNotFoundException{
		languageFiles = new HashMap<String, Properties>();
		Properties languageFile;
    	InputStream propertiesFile;
    	for(String languageTag : languageTags){
    		languageFile = new Properties();
    		propertiesFile = null;
        	try {
				propertiesFile = getClass().getResource("/rop/miu/config/lang/language-"+ languageTag + ".properties").openStream();
	        
		        if (propertiesFile == null)
		        	throw new ROPElementNotFoundException("Le fichier de langue language-"+languageTag + ".properties est introuvable.");
		        
	            languageFile.load(propertiesFile);
	            languageFiles.put(languageTag, languageFile);
        	}catch (FileNotFoundException e){
        		throw new ROPElementNotFoundException("Le fichier de langue language-"+languageTag + ".properties est introuvable.");
			}catch (IOException e){
				throw new ROPElementNotFoundException("Le fichier de langue language-"+languageTag + ".properties est introuvable.");
			}
    	}
	}

	/**
	 * Cette méthode permet de récupérer un élément de langue dans les fichiers de langue de base.
	 * Les fichiers de langue de base peuvent être consultés directement sur la plateforme.<br />
	 * Si la clé n'a aucune valeur associée alors la chaine vide est retournée.
	 * 
	 * @param languageKey
	 * La clé de l'élément de langue.
	 * @param languageTag
	 * Le tag de la langue pour laquelle vous voulez l'élément de langue.
	 * @return
	 * L'élément de langue correspondant à la clé et à la langue que vous avez spécifié.
	 */
	public String getLanguageValue(String languageKey, String languageTag) {
		try{
			return this.languageFiles.get(languageTag).getProperty(languageKey, "");
		}catch(Exception e){
			return "";
		}
	}
}
