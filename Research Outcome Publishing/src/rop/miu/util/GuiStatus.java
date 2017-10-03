package rop.miu.util;

<<<<<<< HEAD
import java.util.ArrayList;

public class GuiStatus {
=======
import java.io.Serializable;
import java.util.ArrayList;

public class GuiStatus implements Serializable{
	private static final long serialVersionUID = 1L;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	public static final int 
			STANDARD_LINK = 0,
			JAVASCRIPT_FUNCTION = 1;
	public static final String
			WARNING = "warning",
			QUESTION = "question",
			SUCCESS = "success",
			INFO = "info",
			ERROR = "error",
			DANGER = "danger",
			DEFAULT = "primary";
			
	private int statusId;
	private String statusType;
	private String statusText;
	private String statusIcon;
	private ArrayList<StatusAction> statusActions;
	
	public GuiStatus(int statusId) {
		this.statusId = statusId;
		setStatusType(DEFAULT);
		statusText = "";
		statusActions = new ArrayList<StatusAction>();
	}

	public GuiStatus(int statusId, String statusType, String...textAndIcon) {
		super();
		this.statusId = statusId;
		setStatusType(statusType);
		this.statusText = "";
		if(textAndIcon != null){
			if(textAndIcon.length >= 1)
				setStatusText(textAndIcon[0]);
			if(textAndIcon.length >= 2)
				setStatusIcon(textAndIcon[1]);
		}
		statusActions = new ArrayList<StatusAction>();
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
		switch(statusType){
			case INFO : statusIcon = "info-sign"; break;
			case WARNING : statusIcon = "exclamation-sign"; break;
			case DANGER : statusIcon = "remove-circle"; break;
			case SUCCESS : statusIcon = "ok"; break;
			case QUESTION : this.statusType = "info"; statusIcon = "question-sign"; break;
			case DEFAULT : this.statusType = "primary"; statusIcon = "flag"; break;
			case ERROR : this.statusType = "danger"; statusIcon = "remove"; break;
			default: break;
		}
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getStatusIcon() {
		return statusIcon;
	}

	public void setStatusIcon(String statusIcon) {
		this.statusIcon = statusIcon;
	}

	public ArrayList<StatusAction> getStatusActions() {
		return statusActions;
	}

	public void setStatusActions(ArrayList<StatusAction> statusActions) {
		this.statusActions = statusActions;
	}
	
	public int addStatusAction(String statusActionType, int statusActionLinkType, String statusActionValue, String...textAndIcon){
		int id = statusActions.size();
		StatusAction action = new StatusAction(id, statusActionType, statusActionLinkType, statusActionValue, textAndIcon);
		statusActions.add(action);
		return id;
	}

	public class StatusAction{
		private int statusActionId;
		private String statusActionButtonText;
		private String statusActionButtonIcon;
		private int statusActionLinkType;
		private String statusActionValue;
		private String statusActionType;
		
		public StatusAction(int statusActionId) {
			this.statusActionId = statusActionId;
			statusActionButtonText = "";
			setStatusActionType(DEFAULT);
			statusActionLinkType = STANDARD_LINK;
			statusActionValue = "";
		}

		public StatusAction(int statusActionId, String statusActionType, int statusActionLinkType, String statusActionValue, String...textAndIcon) {
			this.statusActionId = statusActionId;
			setStatusActionType(statusActionType);
			this.statusActionLinkType = statusActionLinkType;
			this.statusActionValue = statusActionValue;
			statusActionButtonText = "";
			if(textAndIcon != null){
				if(textAndIcon.length >= 1)
					setStatusActionButtonText(textAndIcon[0]);
				if(textAndIcon.length >= 2)
					setStatusActionButtonIcon(textAndIcon[1]);
			}
		}

		public int getStatusActionId() {
			return statusActionId;
		}

		public void setStatusActionId(int statusActionId) {
			this.statusActionId = statusActionId;
		}

		public String getStatusActionType() {
			return statusActionType;
		}

		public void setStatusActionType(String statusActionType) {
			this.statusActionType = statusActionType;
			switch(statusActionType){
				case INFO : statusActionButtonIcon = "info-sign"; break;
				case WARNING : statusActionButtonIcon = "exclamation-sign"; break;
				case DANGER : statusActionButtonIcon = "remove-circle"; break;
				case SUCCESS : statusActionButtonIcon = "ok"; break;
				case QUESTION : this.statusActionType = "info"; statusActionButtonIcon = "question-sign"; break;
				case DEFAULT : this.statusActionType = "primary"; statusActionButtonIcon = "flag"; break;
				case ERROR : this.statusActionType = "danger"; statusActionButtonIcon = "remove"; break;
				default: break;
			}
		}

		public String getStatusActionButtonText() {
			return statusActionButtonText;
		}

		public void setStatusActionButtonText(String statusActionButtonText) {
			this.statusActionButtonText = statusActionButtonText;
		}

		public String getStatusActionButtonIcon() {
			return statusActionButtonIcon;
		}

		public void setStatusActionButtonIcon(String statusActionButtonIcon) {
			this.statusActionButtonIcon = statusActionButtonIcon;
		}

		public int getStatusActionLinkType() {
			return statusActionLinkType;
		}

		public void setStatusActionLinkType(int statusActionType) {
			this.statusActionLinkType = statusActionType;
		}

		public String getStatusActionValue() {
			return statusActionValue;
		}

		public void setStatusActionValue(String statusActionValue) {
			this.statusActionValue = statusActionValue;
		}
	}
}
