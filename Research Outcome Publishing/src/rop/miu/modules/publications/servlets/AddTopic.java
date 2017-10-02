package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rop.miu.beans.BaoTopic;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;
import rop.miu.util.exceptions.ROPDaoException;



public class AddTopic extends ServletModel {
	private static final long serialVersionUID = 1L;
       
   
    public AddTopic() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
				
		ROPPublicationsDao dao = new ROPPublicationsDao();
		List<BaoTopic> topicList = dao.getAllTopics();
		request.setAttribute("Attr_topicList", topicList);
		
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_insert_topic", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		
		returnRequest(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String topicDesc = request.getParameter("topicDesc");
		String topicName = request.getParameter("topicName");
		String parentTopic = request.getParameter("parentTopic");
		short topicState=0;
		
		
		BaoTopic topic = new BaoTopic();
		
		if (!parentTopic.isEmpty()) {
			//récupérer le topic parent en session et le mettre dans l'objet topic
			HttpSession session = request.getSession();
			BaoTopic topicP = (BaoTopic)session.getAttribute("parentTopic");
			topic.setTopicIdParent(topicP);
	}
		
		topic.setTopicName(topicName);
		topic.setTopicDesc(topicDesc);
		topic.setTopicState(topicState);
		
		ROPPublicationsDao dao = new ROPPublicationsDao();
		try {
			dao.saveTopic(topic);
		} catch (ROPDaoException e) {
			e.printStackTrace();
		}
		
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_succes_insert_topic", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		
		returnRequest(request, response);
	}

}
