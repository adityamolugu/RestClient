package com.lexmark.saperion.dataobjects;

public class FileDetails {

	private String id;
	private String fileName;
	private String fileContent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" Id : ").append(this.id)
				.append(" FileName : ").append(this.fileName).toString();
	}
}
