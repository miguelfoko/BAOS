package rop.miu.util.mail;

import java.util.ArrayList;

public class Mail {
	public final static String 
			HTML_UTF8 = "text/html; charset=UTF-8",
			HTML_ISO = "text/html; charset=ISO-8859-1",
			TEXT_PLAIN = "text/plain";
	
	protected String subject;
	protected String content;
	protected String contentType;
	protected ArrayList<String> toReceiver;
	protected ArrayList<String> bccReceiver;
	protected ArrayList<String> ccReceiver;
	protected ArrayList<String> attachment;
	
	public Mail() {
		toReceiver = new ArrayList<String>();
		bccReceiver = new ArrayList<String>();
		ccReceiver = new ArrayList<String>();
		attachment = new ArrayList<String>();
		contentType = HTML_UTF8;
		content = "";
		subject = "";
	}

	public Mail(String subject, String content, ArrayList<String> toReceiver) {
		super();
		this.subject = subject;
		this.content = content;
		this.toReceiver = toReceiver;
	}

	public Mail(String subject, String content, ArrayList<String> toReceiver,
			ArrayList<String> attachment) {
		super();
		this.subject = subject;
		this.content = content;
		this.toReceiver = toReceiver;
		this.attachment = attachment;
	}
	
	public void addToReceiver(String receiver){
		toReceiver.add(receiver);
	}
	
	public void removeToReceiver(String receiver){
		toReceiver.remove(receiver);
	}
	
	public void addBccReceiver(String receiver){
		bccReceiver.add(receiver);
	}
	
	public void removeBccReceiver(String receiver){
		bccReceiver.remove(receiver);
	}
	
	public void addCcReceiver(String receiver){
		ccReceiver.add(receiver);
	}
	
	public void removeCcReceiver(String receiver){
		ccReceiver.remove(receiver);
	}
	
	public void addAttachment(String attach){
		attachment.add(attach);
	}
	
	public void removeAttachment(String attach){
		attachment.remove(attach);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public ArrayList<String> getToReceiver() {
		return toReceiver;
	}

	public void setToReceiver(ArrayList<String> toReceiver) {
		this.toReceiver = toReceiver;
	}

	public ArrayList<String> getBccReceiver() {
		return bccReceiver;
	}

	public void setBccReceiver(ArrayList<String> bccReceiver) {
		this.bccReceiver = bccReceiver;
	}

	public ArrayList<String> getCcReceiver() {
		return ccReceiver;
	}

	public void setCcReceiver(ArrayList<String> ccReceiver) {
		this.ccReceiver = ccReceiver;
	}

	public ArrayList<String> getAttachment() {
		return attachment;
	}

	public void setAttachment(ArrayList<String> attachment) {
		this.attachment = attachment;
	}
}
