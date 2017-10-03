package rop.miu.modules.pages.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class CreateMenu {
	public CreateMenu (){
		
	}
	
	public static HashMap<String,String> generateMenu (File menuFile) {
		BufferedReader reader = null;
		String ligne = "";
		HashMap<String,String> menu = new HashMap<String,String>();
		try{
			reader = new BufferedReader(new FileReader(menuFile));
			while ((ligne = reader.readLine()) != null) {
				menu.put(ligne.substring(0, ligne.lastIndexOf(";")), ligne.substring(ligne.lastIndexOf(";")+1, ligne.length()));
			}
			reader.close();
		}catch (Exception e){
			
		}
		return menu;
	}
}
