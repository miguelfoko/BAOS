package rop.miu.util;

import java.io.Serializable;
import java.util.ArrayList;

public class GuiMenuItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private int menuItemId;
	private String menuItemName;
	private String menuItemLink;
	private String menuItemTarget;
	private String menuItemTitle;
	private String menuItemIcon;
	private String menuItemBadge;
	private ArrayList<GuiMenuItem> subItems;
	
	public GuiMenuItem(int menuItemId){
		this.menuItemId = menuItemId;
		menuItemName = "No Name";
		menuItemLink = "#";
		menuItemTarget = "_self";
		menuItemIcon = null;
		menuItemBadge = null;
		subItems = new ArrayList<GuiMenuItem>();
	}
	
	public GuiMenuItem(int menuItemId, String menuItemName, String menuItemLink, String...iconAndBadge){
		this.menuItemId = menuItemId;
		this.menuItemName = menuItemName;
		this.menuItemLink = menuItemLink;
		menuItemTarget = "_self";
		menuItemIcon = null;
		menuItemBadge = null;
		if(iconAndBadge != null){
			if(iconAndBadge.length >= 1)
				setMenuItemIcon(iconAndBadge[0]);
			if(iconAndBadge.length >= 2)
				setMenuItemBadge(iconAndBadge[1]);
		}
		subItems = new ArrayList<GuiMenuItem>();
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuName) {
		this.menuItemName = menuName;
	}

	public String getMenuItemLink() {
		return menuItemLink;
	}

	public void setMenuItemLink(String menuLink) {
		this.menuItemLink = menuLink;
	}

	public String getMenuItemTarget() {
		return menuItemTarget;
	}

	public void setMenuItemTarget(String menuTarget) {
		this.menuItemTarget = menuTarget;
	}

	public String getMenuItemTitle() {
		return menuItemTitle;
	}

	public void setMenuItemTitle(String menuTitle) {
		this.menuItemTitle = menuTitle;
	}

	public ArrayList<GuiMenuItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(ArrayList<GuiMenuItem> subItems) {
		this.subItems = subItems;
	}

	public String getMenuItemIcon() {
		return menuItemIcon;
	}

	public void setMenuItemIcon(String menuItemIcon) {
		this.menuItemIcon = menuItemIcon;
	}

	public String getMenuItemBadge() {
		return menuItemBadge;
	}

	public void setMenuItemBadge(String menuItemBadge) {
		this.menuItemBadge = menuItemBadge;
	}
	
	public int addMenuSubItem(String menuItemName, String menuItemLink, String...iconAndBadge){
		int id = subItems.size();
		GuiMenuItem item = new GuiMenuItem(id, menuItemName, menuItemLink);
		if(iconAndBadge != null){
			if(iconAndBadge.length >= 1)
				item.setMenuItemIcon(iconAndBadge[0]);
			if(iconAndBadge.length >= 2)
				item.setMenuItemBadge(iconAndBadge[1]);
		}
		subItems.add(item);
		return id;
	}
}
