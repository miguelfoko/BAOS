package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoTopic;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;


public class GetAllTopics extends ServletModel {
	private static final long serialVersionUID = 1L;
       

    public GetAllTopics() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		ROPPublicationsDao dao = new ROPPublicationsDao();
		List<BaoTopic> topicList = dao.getAllTopics();
		
		request.setAttribute("Attr_topicList", topicList);
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_insert_topic", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		
		returnRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
