package rop.miu.util.io;

import java.util.ArrayList;

import rop.miu.ConfigManager;

public class UploadCondition {
	private ConfigManager miuConfigManager = null;
	private long maxFileSize;
	private ArrayList<String> extensions = new ArrayList<String>();
	private String fileName = null;
	private boolean sizeExceed = false;
	private boolean badName = false;
	private boolean badFileType = false;
	
	public UploadCondition(ConfigManager manager) {
		this.miuConfigManager = manager;
		maxFileSize = this.miuConfigManager.getMaxUploadFileSize();
	}

	public boolean validateUpload(String fileExtension, String fileName, long size) {
		if(maxFileSize < size)
			sizeExceed  = true;
		if(this.fileName != null && !this.fileName.equals(fileName))
			badName  = true;
		if(!extensions.isEmpty() && !extensions.contains(fileExtension))
			badFileType  = true;
		
		return !(sizeExceed || badName || badFileType);
	}

	public long getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(long maxFileSize) {
		if(maxFileSize < this.maxFileSize)
			this.maxFileSize = maxFileSize;
	}

	public ArrayList<String> getExtensions() {
		return extensions;
	}

	public void setExtensions(ArrayList<String> extensions) {
		if(extensions != null)
			this.extensions = extensions;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public long getTmpMemoryMaxSize(){
		return miuConfigManager.getTmpMemoryMaxSize();
	}
	
	public void addExtension(String...extension){
		for(String st : extension)
			this.extensions.add(st);
	}

	public boolean isSizeExceed() {
		return sizeExceed;
	}

	public boolean isBadName() {
		return badName;
	}

	public boolean isBadFileType() {
		return badFileType;
	}
}
