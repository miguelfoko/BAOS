package rop.miu.util;

<<<<<<< HEAD
import java.util.ArrayList;

public class GuiMenu {
=======
import java.io.Serializable;
import java.util.ArrayList;

public class GuiMenu implements Serializable{
	private static final long serialVersionUID = 1L;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	private int menuId;
	private String menuTitle;
	private String menuTitleIcon;
	private String menuTitleBadge;
	private ArrayList<GuiMenuItem> guiMenuItems;
	
	public GuiMenu(int menuId) {
		this.menuId = menuId;
		menuTitle = "";
		menuTitleIcon = null;
		menuTitleBadge = null;
		guiMenuItems = new ArrayList<GuiMenuItem>();
	}
	
	public GuiMenu(int menuId, String menuTitle, String...iconAndBadge) {
		this.menuId = menuId;
		this.menuTitle = menuTitle;
		menuTitleIcon = null;
		menuTitleBadge = null;
		if(iconAndBadge != null){
			if(iconAndBadge.length >= 1)
				setMenuTitleIcon(iconAndBadge[0]);
			if(iconAndBadge.length >= 2)
				setMenuTitleBadge(iconAndBadge[1]);
		}
		guiMenuItems = new ArrayList<GuiMenuItem>();
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public ArrayList<GuiMenuItem> getMenuItems() {
		return guiMenuItems;
	}

	public void setMenuItems(ArrayList<GuiMenuItem> guiMenuItems) {
		this.guiMenuItems = guiMenuItems;
	}
	
	public String getMenuTitleIcon() {
		return menuTitleIcon;
	}

	public void setMenuTitleIcon(String menuTitleIcon) {
		this.menuTitleIcon = menuTitleIcon;
	}

	public String getMenuTitleBadge() {
		return menuTitleBadge;
	}

	public void setMenuTitleBadge(String menuTitleBadge) {
		this.menuTitleBadge = menuTitleBadge;
	}

	public int addMenuItem(String menuItemName, String menuItemLink, String...iconAndBadge){
		int id = guiMenuItems.size();
		GuiMenuItem item = new GuiMenuItem(id, menuItemName, menuItemLink, iconAndBadge);
		guiMenuItems.add(item);
		return id;
	}
}