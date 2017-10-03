package rop.miu.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ndadji Maxime
 */
public class IncludeManager {
    HttpServletRequest request;
    
	public IncludeManager(HttpServletRequest request) {
		this.request = request;
		if(request.getAttribute("includeList") == null)
			resetIncludeList();
		if(request.getAttribute("statusList") == null)
			resetStatusList();
		if(request.getAttribute("sideMenus") == null)
			resetSideMenus();
		if(request.getAttribute("leftSidePanels") == null)
			resetLeftSidePanels();
		if(request.getAttribute("rightSidePanels") == null)
			resetRightSidePanels();
	}
    
	@SuppressWarnings("unchecked")
	public ArrayList<String> getJSPList(){
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("includeList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("includeList", list);
		}
		return list;
    }
	
	public void addJSP(String url){
		getJSPList().add(url);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<String> getCSSList(){
    	ArrayList<String> list = (ArrayList<String>) request.getAttribute("cssList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("cssList", list);
		}
		return list;
    }
    
	public void addCSS(String url){
    	getCSSList().add(url);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<String> getJSList(){
    	ArrayList<String> list = (ArrayList<String>) request.getAttribute("jsList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("jsList", list);
		}
		return list;
    }
    
	public void addJS(String url){
		getJSList().add(url);
    }
	
	public void setTitle(String title){
		request.setAttribute("title", title);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getKeywordList(){
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("keywordList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("keywordList", list);
		}
		return list;
    }
	
	public void addKeyword(String keyword){
		getKeywordList().add(keyword);
    }
	
	public void resetIncludeList(){
		request.setAttribute("includeList", new ArrayList<String>());
		request.setAttribute("cssList", new ArrayList<String>());
		request.setAttribute("jsList", new ArrayList<String>());
		request.setAttribute("keywordList", new ArrayList<String>());
	}
	
	public void resetStatusList(){
		request.setAttribute("statusList", new ArrayList<GuiStatus>());
	}
	
	public void resetSideMenus(){
		request.setAttribute("sideMenus", new ArrayList<GuiMenu>());
	}
	
	public void resetLeftSidePanels(){
		request.setAttribute("leftSidePanels", new ArrayList<GuiSidePanel>());
	}
	
	public void resetRightSidePanels(){
		request.setAttribute("rightSidePanels", new ArrayList<GuiSidePanel>());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiStatus> getStatusList(){
		ArrayList<GuiStatus> list = (ArrayList<GuiStatus>) request.getAttribute("statusList");
		if(list == null){
			list = new ArrayList<GuiStatus>();
			request.setAttribute("statusList", list);
		}
		return list;
    }
	
	public int createSuccessStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.SUCCESS, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createErrorStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.ERROR, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createDefaultStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.DEFAULT, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createWarningStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.WARNING, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createDangerStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.DANGER, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createInfoStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.INFO, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createQuestionStatus(String statusText){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.QUESTION, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createStatus(String statusType, String...textAndIcon){
		ArrayList<GuiStatus> list = getStatusList();
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, statusType, textAndIcon);
		list.add(guiStatus);
		return id;
    }
	
	public GuiStatus getStatus(int statusId){
		return getStatusList().get(statusId);
	}
	
	public int addStatusAction(int statusId, String statusActionType, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(statusActionType, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusQuestionAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.QUESTION, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusInfoAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.INFO, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusSuccessAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.SUCCESS, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusErrorAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.ERROR, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusDefaultAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.DEFAULT, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusDangerAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.DANGER, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusWarningAction(int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(statusId).addStatusAction(GuiStatus.WARNING, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiMenu> getSideMenus(){
		ArrayList<GuiMenu> list = (ArrayList<GuiMenu>) request.getAttribute("sideMenus");
		if(list == null){
			list = new ArrayList<GuiMenu>();
			request.setAttribute("sideMenus", list);
		}
		return list;
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiSidePanel> getLeftSidePanels(){
		ArrayList<GuiSidePanel> list = (ArrayList<GuiSidePanel>) request.getAttribute("leftSidePanels");
		if(list == null){
			list = new ArrayList<GuiSidePanel>();
			request.setAttribute("leftSidePanels", list);
		}
		return list;
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiSidePanel> getRightSidePanels(){
		ArrayList<GuiSidePanel> list = (ArrayList<GuiSidePanel>) request.getAttribute("rightSidePanels");
		if(list == null){
			list = new ArrayList<GuiSidePanel>();
			request.setAttribute("rightSidePanels", list);
		}
		return list;
    }
	
	public int createSideMenu(String menuTitle, String...iconAndBadge){
		ArrayList<GuiMenu> list = getSideMenus();
		int id = list.size();
		GuiMenu guiMenu = new GuiMenu(id, menuTitle, iconAndBadge);
		list.add(guiMenu);
		return id;
	}
	
	public int createLeftSidePanel(String panelTitle, String...iconAndBadge){
		ArrayList<GuiSidePanel> list = getLeftSidePanels();
		int id = list.size();
		GuiSidePanel panel = new GuiSidePanel(id, panelTitle, iconAndBadge);
		list.add(panel);
		return id;
	}
	
	public int createRightSidePanel(String panelTitle, String...iconAndBadge){
		ArrayList<GuiSidePanel> list = getRightSidePanels();
		int id = list.size();
		GuiSidePanel panel = new GuiSidePanel(id, panelTitle, iconAndBadge);
		list.add(panel);
		return id;
	}
	
	public GuiMenu getSideMenu(int menuId){
		return getSideMenus().get(menuId);
	}
	
	public GuiSidePanel getLeftSidePanel(int panelId){
		return getLeftSidePanels().get(panelId);
	}
	
	public GuiSidePanel getRightSidePanel(int panelId){
		return getRightSidePanels().get(panelId);
	}
	
	public int addMenuItem(int menuId, String menuItemName, String menuItemLink, String...iconAndBadge){
		return getSideMenu(menuId).addMenuItem(menuItemName, menuItemLink, iconAndBadge);
	}
	
	public int addLeftSidePanelContent(int panelId, String spContentValue, boolean spContentLink){
		return getLeftSidePanel(panelId).addSidePanelContent(spContentValue, spContentLink);
	}
	
	public int addRightSidePanelContent(int panelId, String spContentValue, boolean spContentLink){
		return getRightSidePanel(panelId).addSidePanelContent(spContentValue, spContentLink);
	}
	
	public GuiMenuItem getMenuItem(int menuId, int menuItemId){
		return getSideMenu(menuId).getMenuItems().get(menuItemId);
	}
	
	public int addMenuSubItem(int menuId, int menuItemId, String menuItemName, String menuItemLink, String...iconAndBadge){
		return getMenuItem(menuId, menuItemId).addMenuSubItem(menuItemName, menuItemLink, iconAndBadge);
	}
}
