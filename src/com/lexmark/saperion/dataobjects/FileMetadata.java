/**
 * 
 */
package com.lexmark.saperion.dataobjects;

/**
 * @author Aditya.Molugu
 *
 */
public class FileMetadata {
	
	String fileName;
	String base64FileContent;
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the base64FileContent
	 */
	public String getBase64FileContent() {
		return base64FileContent;
	}
	/**
	 * @param base64FileContent the base64FileContent to set
	 */
	public void setBase64FileContent(String base64FileContent) {
		this.base64FileContent = base64FileContent;
	}
	
	

}
