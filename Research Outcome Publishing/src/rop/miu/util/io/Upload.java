package rop.miu.util.io;

import java.io.File;
import java.util.Date;

public class Upload {

	private File uploadedFile = null;
	private String originalFileName = null;
	private Date uploadDate = null;
	
	public Upload(File uploadedFile, String originalFileName, Date uploadDate) {
		this.uploadedFile = uploadedFile;
		this.originalFileName = originalFileName;
		this.uploadDate = uploadDate;
	}

	public File getUploadedFile() {
		return uploadedFile;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}
	
	public String getNewName(){
		if(uploadedFile != null)
			return uploadedFile.getName();
		return null;
	}

	public Date getUploadDate() {
		return uploadDate;
	}
}
