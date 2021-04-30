package com.google.sheet.reader.model;

import java.util.ArrayList;
import java.util.List;

public class SheetMetaData {
	String sheetID;
	List<String> sheetNames = new ArrayList<String>();
	long lastModifiedTime;
	
	public String getSheetID() {
		return sheetID;
	}
	public void setSheetID(String sheetID) {
		this.sheetID = sheetID;
	}
	public List<String> getSheetNames() {
		return sheetNames;
	}
	public void setSheetNames(List<String> sheetNames) {
		this.sheetNames = sheetNames;
	}
	public long getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
