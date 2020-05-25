package com.colutti.restfulSpring.data.vo;

import java.io.Serializable;
import java.util.Date;

public class UploadFileResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String fileName;
	private Date fileDownloadUri;
	private Double fileType;
	private long size;
	
	
	public UploadFileResponseVO() {
		
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public Date getFileDownloadUri() {
		return fileDownloadUri;
	}


	public void setFileDownloadUri(Date fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}


	public Double getFileType() {
		return fileType;
	}


	public void setFileType(Double fileType) {
		this.fileType = fileType;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}

	
}
