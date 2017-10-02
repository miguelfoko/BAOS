package rop.miu.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ndadji Maxime
 */
public class IncludeManager {
    
	public IncludeManager(HttpServletRequest request) {
		if(request.getAttribute("includeList") == null)
			resetIncludeList(request);
		if(request.getAttribute("statusList") == null)
			resetStatusList(request);
		if(request.getAttribute("sideMenus") == null)
			resetSideMenus(request);
		if(request.getAttribute("leftSidePanels") == null)
			resetLeftSidePanels(request);
		if(request.getAttribute("rightSidePanels") == null)
			resetRightSidePanels(request);
	}
    
	@SuppressWarnings("unchecked")
	public ArrayList<String> getJSPList(HttpServletRequest request){
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("includeList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("includeList", list);
		}
		return list;
    }
	
	public void addJSP(HttpServletRequest request, String url){
		getJSPList(request).add(url);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<String> getCSSList(HttpServletRequest request){
    	ArrayList<String> list = (ArrayList<String>) request.getAttribute("cssList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("cssList", list);
		}
		return list;
    }
    
	public void addCSS(HttpServletRequest request, String url){
    	getCSSList(request).add(url);
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<String> getJSList(HttpServletRequest request){
    	ArrayList<String> list = (ArrayList<String>) request.getAttribute("jsList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("jsList", list);
		}
		return list;
    }
    
	public void addJS(HttpServletRequest request, String url){
		getJSList(request).add(url);
    }
	
	public void setTitle(HttpServletRequest request, String title){
		request.setAttribute("title", title);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getKeywordList(HttpServletRequest request){
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("keywordList");
		if(list == null){
			list = new ArrayList<String>();
			request.setAttribute("keywordList", list);
		}
		return list;
    }
	
	public void addKeyword(HttpServletRequest request, String keyword){
		getKeywordList(request).add(keyword);
    }
	
	public void resetIncludeList(HttpServletRequest request){
		request.setAttribute("includeList", new ArrayList<String>());
		request.setAttribute("cssList", new ArrayList<String>());
		request.setAttribute("jsList", new ArrayList<String>());
		request.setAttribute("keywordList", new ArrayList<String>());
	}
	
	public void resetStatusList(HttpServletRequest request){
		request.setAttribute("statusList", new ArrayList<GuiStatus>());
	}
	
	public void resetSideMenus(HttpServletRequest request){
		request.setAttribute("sideMenus", new ArrayList<GuiMenu>());
	}
	
	public void resetLeftSidePanels(HttpServletRequest request){
		request.setAttribute("leftSidePanels", new ArrayList<GuiSidePanel>());
	}
	
	public void resetRightSidePanels(HttpServletRequest request){
		request.setAttribute("rightSidePanels", new ArrayList<GuiSidePanel>());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiStatus> getStatusList(HttpServletRequest request){
		ArrayList<GuiStatus> list = (ArrayList<GuiStatus>) request.getAttribute("statusList");
		if(list == null){
			list = new ArrayList<GuiStatus>();
			request.setAttribute("statusList", list);
		}
		return list;
    }
	
	public int createSuccessStatus(HttpServletRequest request, String statusText){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.SUCCESS, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createErrorStatus(HttpServletRequest request, String statusText){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.ERROR, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createDefaultStatus(HttpServletRequest request, String statusText){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.DEFAULT, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createWarningStatus(HttpServletRequest request, String statusText){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.WARNING, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createDangerStatus(String statusText, HttpServletRequest request){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.DANGER, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createInfoStatus(String statusText, HttpServletRequest request){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.INFO, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createQuestionStatus(String statusText, HttpServletRequest request){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, GuiStatus.QUESTION, statusText);
		list.add(guiStatus);
		return id;
    }
	
	public int createStatus(HttpServletRequest request, String statusType, String...textAndIcon){
		ArrayList<GuiStatus> list = getStatusList(request);
		int id = list.size();
		GuiStatus guiStatus = new GuiStatus(id, statusType, textAndIcon);
		list.add(guiStatus);
		return id;
    }
	
	public GuiStatus getStatus(HttpServletRequest request, int statusId){
		return getStatusList(request).get(statusId);
	}
	
	public int addStatusAction(HttpServletRequest request, int statusId, String statusActionType, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(statusActionType, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusQuestionAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.QUESTION, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusInfoAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.INFO, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusSuccessAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.SUCCESS, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusErrorAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.ERROR, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusDefaultAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.DEFAULT, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusDangerAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.DANGER, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	public int addStatusWarningAction(HttpServletRequest request, int statusId, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		return getStatus(request, statusId).addStatusAction(GuiStatus.WARNING, statusActionLinkType, statusActionValue, textAndIcon);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiMenu> getSideMenus(HttpServletRequest request){
		ArrayList<GuiMenu> list = (ArrayList<GuiMenu>) request.getAttribute("sideMenus");
		if(list == null){
			list = new ArrayList<GuiMenu>();
			request.setAttribute("sideMenus", list);
		}
		return list;
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiSidePanel> getLeftSidePanels(HttpServletRequest request){
		ArrayList<GuiSidePanel> list = (ArrayList<GuiSidePanel>) request.getAttribute("leftSidePanels");
		if(list == null){
			list = new ArrayList<GuiSidePanel>();
			request.setAttribute("leftSidePanels", list);
		}
		return list;
    }
	
	@SuppressWarnings("unchecked")
	public ArrayList<GuiSidePanel> getRightSidePanels(HttpServletRequest request){
		ArrayList<GuiSidePanel> list = (ArrayList<GuiSidePanel>) request.getAttribute("rightSidePanels");
		if(list == null){
			list = new ArrayList<GuiSidePanel>();
			request.setAttribute("rightSidePanels", list);
		}
		return list;
    }
	
	public int createSideMenu(HttpServletRequest request, String menuTitle, String...iconAndBadge){
		ArrayList<GuiMenu> list = getSideMenus(request);
		int id = list.size();
		GuiMenu guiMenu = new GuiMenu(id, menuTitle, iconAndBadge);
		list.add(guiMenu);
		return id;
	}
	
	public int createLeftSidePanel(HttpServletRequest request, String panelTitle, String...iconAndBadge){
		ArrayList<GuiSidePanel> list = getLeftSidePanels(request);
		int id = list.size();
		GuiSidePanel panel = new GuiSidePanel(id, panelTitle, iconAndBadge);
		list.add(panel);
		return id;
	}
	
	public int createRightSidePanel(HttpServletRequest request, String panelTitle, String...iconAndBadge){
		ArrayList<GuiSidePanel> list = getRightSidePanels(request);
		int id = list.size();
		GuiSidePanel panel = new GuiSidePanel(id, panelTitle, iconAndBadge);
		list.add(panel);
		return id;
	}
	
	public GuiMenu getSideMenu(HttpServletRequest request, int menuId){
		return getSideMenus(request).get(menuId);
	}
	
	public GuiSidePanel getLeftSidePanel(int panelId, HttpServletRequest request){
		return getLeftSidePanels(request).get(panelId);
	}
	
	public GuiSidePanel getRightSidePanel(HttpServletRequest request, int panelId){
		return getRightSidePanels(request).get(panelId);
	}
	
	public int addMenuItem(HttpServletRequest request, int menuId, String menuItemName, String menuItemLink, String...iconAndBadge){
		return getSideMenu(request, menuId).addMenuItem(menuItemName, menuItemLink, iconAndBadge);
	}
	
	public int addLeftSidePanelContent(HttpServletRequest request, int panelId, String spContentValue, boolean spContentLink){
		return getLeftSidePanel(panelId, request).addSidePanelContent(spContentValue, spContentLink);
	}
	
	public int addRightSidePanelContent(HttpServletRequest request, int panelId, String spContentValue, boolean spContentLink){
		return getRightSidePanel(request, panelId).addSidePanelContent(spContentValue, spContentLink);
	}
	
	public GuiMenuItem getMenuItem(HttpServletRequest request, int menuId, int menuItemId){
		return getSideMenu(request, menuId).getMenuItems().get(menuItemId);
	}
	
	public int addMenuSubItem(HttpServletRequest request, int menuId, int menuItemId, String menuItemName, String menuItemLink, String...iconAndBadge){
		return getMenuItem(request, menuId, menuItemId).addMenuSubItem(menuItemName, menuItemLink, iconAndBadge);
	}
}
