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
		
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("publication_insert_topic", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_insert_topic", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		
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
		
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("publication_succes_insert_topic", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_succes_insert_topic", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		
		returnRequest(request, response);
	}

}
