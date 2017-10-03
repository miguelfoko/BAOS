package rop.miu.util;

<<<<<<< HEAD
import java.util.ArrayList;

public class GuiSidePanel {
=======
import java.io.Serializable;
import java.util.ArrayList;

public class GuiSidePanel implements Serializable{
	private static final long serialVersionUID = 1L;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	private int sidePanelId;
	private String sidePanelTitle;
	private String sidePanelTitleIcon;
	private String sidePanelTitleBadge;
	private ArrayList<SidePanelContent> sidePanelContent;
	
	public GuiSidePanel(int sidePanelId) {
		this.sidePanelId = sidePanelId;
		sidePanelTitle = "";
		sidePanelTitleIcon = null;
		sidePanelTitleBadge = null;
		sidePanelContent = new ArrayList<SidePanelContent>();
	}

	public GuiSidePanel(int sidePanelId, String sidePanelTitle, String...iconAndBadge) {
		this.sidePanelId = sidePanelId;
		this.sidePanelTitle = sidePanelTitle;
		sidePanelTitleIcon = null;
		sidePanelTitleBadge = null;
		if(iconAndBadge != null){
			if(iconAndBadge.length >= 1)
				setSidePanelTitleIcon(iconAndBadge[0]);
			if(iconAndBadge.length >= 2)
				setSidePanelTitleBadge(iconAndBadge[1]);
		}
		sidePanelContent = new ArrayList<SidePanelContent>();
	}

	public int getSidePanelId() {
		return sidePanelId;
	}

	public void setSidePanelId(int sidePanelId) {
		this.sidePanelId = sidePanelId;
	}

	public String getSidePanelTitle() {
		return sidePanelTitle;
	}

	public void setSidePanelTitle(String sidePanelTitle) {
		this.sidePanelTitle = sidePanelTitle;
	}

	public ArrayList<SidePanelContent> getSidePanelContent() {
		return sidePanelContent;
	}

	public void setSidePanelContent(ArrayList<SidePanelContent> sidePanelContent) {
		this.sidePanelContent = sidePanelContent;
	}

	public String getSidePanelTitleIcon() {
		return sidePanelTitleIcon;
	}

	public void setSidePanelTitleIcon(String sidePanelTitleIcon) {
		this.sidePanelTitleIcon = sidePanelTitleIcon;
	}

	public String getSidePanelTitleBadge() {
		return sidePanelTitleBadge;
	}

	public void setSidePanelTitleBadge(String sidePanelTitleBadge) {
		this.sidePanelTitleBadge = sidePanelTitleBadge;
	}
	
	public int addSidePanelContent(String spContentValue, boolean spContentLink){
		int id = sidePanelContent.size();
		SidePanelContent content = new SidePanelContent(id, spContentValue, spContentLink);
		sidePanelContent.add(content);
		return id;
	}

	public class SidePanelContent{
		private int spContentId;
		private boolean spContentLink;
		private String spContentValue;
		
		public SidePanelContent(int spContentId) {
			this.spContentId = spContentId;
			spContentLink = false;
			spContentValue = "";
		}

		public SidePanelContent(int spContentId, String spContentValue, boolean spContentLink) {
			this.spContentId = spContentId;
			this.spContentLink = spContentLink;
			this.spContentValue = spContentValue;
		}

		public int getSpContentId() {
			return spContentId;
		}

		public void setSpContentId(int spContentId) {
			this.spContentId = spContentId;
		}

		public boolean isSpContentLink() {
			return spContentLink;
		}

		public void setSpContentLink(boolean spContentLink) {
			this.spContentLink = spContentLink;
		}

		public String getSpContentValue() {
			return spContentValue;
		}

		public void setSpContentValue(String spContentValue) {
			this.spContentValue = spContentValue;
		}
	}
}
