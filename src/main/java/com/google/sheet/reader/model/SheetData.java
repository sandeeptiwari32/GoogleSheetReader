package com.google.sheet.reader.model;

import java.util.ArrayList;
import java.util.List;

public class SheetData {
	List<String> header = new ArrayList<String>();
	List<List<String>> rows = new ArrayList<List<String>>();
	
	public List<String> getHeader() {
		return header;
	}
	public List<List<String>> getRows() {
		return rows;
	}
	
}
