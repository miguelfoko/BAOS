
package rop.miu.util;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ndadji Maxime
 */
public class IncludeManager {
    HttpServletRequest request;
    
    @SuppressWarnings("unchecked")
	public IncludeManager(HttpServletRequest request) {
		this.request = request;
		ArrayList<String> liste = (ArrayList<String>) request.getAttribute("listeInclude");
		if(liste == null){
			request.setAttribute("listeInclude", new ArrayList<String>());
			request.setAttribute("listeCss", new ArrayList<String>());
			request.setAttribute("listeJs", new ArrayList<String>());
			request.setAttribute("keywords", new ArrayList<String>());
		}
	}
    
	@SuppressWarnings("unchecked")
	public ArrayList<String> getJSPList(){
    	return (ArrayList<String>) request.getAttribute("listeInclude");
    }
	
	public void addJSP(String url){
		getJSPList().add(url);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<String> getCSSList(){
    	return (ArrayList<String>) request.getAttribute("listeCss");
    }
    
	public void addCSS(String url){
    	getCSSList().add(url);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<String> getJSList(){
    	return (ArrayList<String>) request.getAttribute("listeJs");
    }
    
	public void addJS(String url){
		getJSList().add(url);
    }
	
	public void setTitle(String title){
		request.setAttribute("title", title);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getKeywordList(){
    	return (ArrayList<String>) request.getAttribute("keywords");
    }
	
	public void addKeyword(String keyword){
		getKeywordList().add(keyword);
    }
}
