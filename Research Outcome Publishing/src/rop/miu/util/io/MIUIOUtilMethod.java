package rop.miu.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;

import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.MIUIOException;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class MIUIOUtilMethod {
	public static void unzip(String zip, String destPath) throws MIUIOException{
		try {
			ZipFile zipFile = new ZipFile(zip);
			Enumeration<?> entries = zipFile.entries();
			ZipEntry entry = null;
			File file = null;
			File dir = null;
			BufferedOutputStream out;
			BufferedInputStream in;
			while (entries.hasMoreElements()) {
				entry = (ZipEntry) entries.nextElement();
				if (!entry.isDirectory()) {
					
					file = new File(destPath + File.separatorChar + entry.getName());
					dir = file.getParentFile();
					if (dir != null) {
						if (!dir.exists()) {
							dir.mkdirs();
						}
					}
					out = new BufferedOutputStream(new FileOutputStream(file));
					in = new BufferedInputStream(zipFile.getInputStream(entry));
					copyFileWithStreams(out, in);
				}
			}
			zipFile.close();
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public static void zip(String zipFile, String comment, ArrayList<String> files) throws MIUIOException{
		try {
			ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile));
			zip.setMethod(ZipOutputStream.DEFLATED);
			zip.setLevel(Deflater.BEST_COMPRESSION | Deflater.BEST_SPEED);
			zip.setComment(comment);
			
			File file;
			FileInputStream fis;
			int i = 0;
			byte[] bytes;
			while(i < files.size()){
				file = new File(files.get(i));
				if(file.isDirectory()){
					for(File f : file.listFiles())
						files.add(f.getAbsolutePath());
				}
				else{
					fis = new FileInputStream(file);
					bytes = new byte[fis.available()];
					fis.read(bytes);
					
					ZipEntry entry = new ZipEntry(files.get(i));
					entry.setTime(file.lastModified());
					zip.putNextEntry(entry);
					zip.write(bytes);
					
					zip.closeEntry();
					fis.close();
				}
				i++;
			}
			zip.close();
		}catch (Exception e) {
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public static void copyFolder(File folder, String destFolder) throws MIUIOException{
		File f = new File(destFolder);
		try {
			if(!f.exists())
				f.mkdirs();
			for(File file : folder.listFiles()){
				if(file.isDirectory())
					copyFolder(file, destFolder + "/" + file.getName());
				else{
					f = new File(destFolder + "/" + file.getName());
					copyFile(file, f);
				}
			}
		} catch (Exception e) {
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public static void copyFile(File file, File dest) throws MIUIOException{
		try {
			byte[] bytes = new byte[1024];
		    BufferedOutputStream out;
		    BufferedInputStream in;
		    
			out = new BufferedOutputStream(new FileOutputStream(dest));
			in = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = in.read(bytes)) != -1){
                out.write(bytes,0,i);
            }
            out.flush();
            out.close();
            in.close();  
		} catch (Exception e) {
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public static void copyFileWithStreams(BufferedOutputStream out, BufferedInputStream in) throws MIUIOException{
		try {
			byte[] bytes = new byte[1024];
		    
            int i = 0;
            while ((i = in.read(bytes)) != -1){
                out.write(bytes,0,i);
            }
            out.flush();
            out.close();
            in.close();  
		} catch (Exception e) {
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public static void deleteFolder(String destFolder) throws MIUIOException {
		File folder = new File(destFolder);
		try{
			if(folder.exists() && folder.isDirectory()){
				for(File file : folder.listFiles()){
					if(file.isDirectory())
						deleteFolder(file.getAbsolutePath().replace("%20", " "));
					else
						file.delete();
				}
				folder.delete();
			}
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public URL getTmpFolder(){
		return getClass().getResource("/../.." + ROPConstants.TMP_FOLDER);
	}
	
	public static long getFolderLength(String folderPath) throws MIUIOException {
		long size = 0;
		File folder = new File(folderPath);
		try{
			if(folder.exists() && folder.isDirectory()){
				for(File file : folder.listFiles()){
					if(file.isDirectory())
						size += getFolderLength(file.getAbsolutePath().replace("%20", " "));
					else
						size += file.length();
				}
			}
			return size;
		}catch(Exception e){
			throw new MIUIOException("Document invalide : absence du noeud miu-extension "+e.getMessage());
		}
	}
	
	public static void saveXMLFile(String file, org.dom4j.Document document) throws MIUIOException{
		try{
        	org.dom4j.io.OutputFormat format = org.dom4j.io.OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(document); 
            writer.flush();
        }catch(Exception ex){
            throw new MIUIOException("Erreur lors de la sauvegarde du fichier : "+file);
        }
    }
	
	public static void saveXMLFile(String file, org.w3c.dom.Document document) throws MIUIOException{
        try{
            XMLSerializer ser = new XMLSerializer(
                new FileOutputStream(file), new com.sun.org.apache.xml.internal.serialize.OutputFormat("xml", "UTF-8", true));
            ser.serialize(document);
        }catch(Exception ex){
        	throw new MIUIOException("Erreur lors de la sauvegarde du fichier : "+file);
        }
    }
	
	public static void saveStringAsXML(String filePath, String content) throws MIUIOException{
		try{
			saveXMLFile(filePath, getXMLDocumentFromString(content));
        }catch(Exception ex){
            throw new MIUIOException("Erreur lors du chargement du fichier " +
            		"de configuration. ");
        }
	}
	
	public static org.dom4j.Document getXMLDocumentFromString(String content) throws MIUIOException{
		try{
			SAXReader xmlReader = new SAXReader();
			org.dom4j.Document document = xmlReader.read(new InputSource(new StringReader(content)));
			return document;
        }catch(Exception ex){
        	ex.printStackTrace();
            throw new MIUIOException("Erreur lors du chargement du fichier " +
            		"de configuration. ");
        }
	}
	
	public URL createFolder(String folderPath) throws MIUIOException{
		try{
			URL url = getClass().getResource("/../..");
			String realPath = url.getFile().replace("%20", " ");
			realPath = realPath.endsWith("/") ? realPath.substring(0, realPath.length() - 1) : realPath;
			realPath += folderPath.startsWith("/") ? folderPath : "/" + folderPath;
			realPath = realPath.replace("%20", " ");
			realPath = realPath.endsWith("/") ? realPath.substring(0, realPath.length() - 1) : realPath;
			File file = new File(realPath);
			file.mkdirs();
			return file.toURI().toURL();
		}catch(Exception e){
			throw new MIUIOException("Erreur lors du chargement du fichier " +
            		"de configuration. ");
		}
	}
	
	public URL getFolderURL(String folderPath) throws MIUIOException{
		try{
			URL url = getClass().getResource("/../..");
			String realPath = url.getFile().replace("%20", " ");
			realPath = realPath.endsWith("/") ? realPath.substring(0, realPath.length() - 1) : realPath;
			realPath += folderPath.startsWith("/") ? folderPath : "/" + folderPath;
			realPath = realPath.replace("%20", " ");
			realPath = realPath.endsWith("/") ? realPath.substring(0, realPath.length() - 1) : realPath;
			File file = new File(realPath);
			return file.toURI().toURL();
		}catch(Exception e){
			throw new MIUIOException("Erreur lors du chargement du fichier " +
            		"de configuration. ");
		}
	}
	
	public static void rename(File file, String newName) throws MIUIOException{
		try{
			String newPath = file.getParentFile().getAbsolutePath().replace("%20", " ");
			newPath = newPath.endsWith("/") ? newPath.substring(0, newPath.length() - 1) : newPath;
			newPath += newName.startsWith("/") ? newName : "/" + newName;
			newPath = newPath.endsWith("/") ? newPath.substring(0, newPath.length() - 1) : newPath;
			newPath += "." + ((file.getName().split("[.]"))[1]);
			newPath = newPath.replace("%20", " ");
			newPath = newPath.endsWith("/") ? newPath.substring(0, newPath.length() - 1) : newPath;
			File newFile = new File(newPath);
			file.renameTo(newFile);
		}catch(Exception e){
			throw new MIUIOException("Erreur lors du chargement du fichier " +
            		"de configuration. ");
		}
	}
}
