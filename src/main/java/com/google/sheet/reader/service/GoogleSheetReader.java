package com.google.sheet.reader.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.google.api.services.sheets.v4.Sheets.Spreadsheets;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.sheet.reader.model.SheetData;
import com.google.sheet.reader.model.SheetMetaData;

@Component
public class GoogleSheetReader {
	
	@Autowired
	Spreadsheets googleSheetConfiguration;
	
	public SheetMetaData getMetaData(String sheetid) throws IOException {
		Spreadsheet sp = googleSheetConfiguration.get(sheetid).execute();
		List<Sheet> sheets = sp.getSheets();
		SheetMetaData metaData = new SheetMetaData();
		metaData.setSheetID(sheetid);
		for(Sheet s: sheets) {
			metaData.getSheetNames().add(s.getProperties().getTitle());
		}
		return metaData;
	}

	public SheetData getdata(String sheetid, String sheetname) throws IOException {
		ValueRange values = googleSheetConfiguration.values().get(sheetid, sheetname).execute();
		SheetData data = new SheetData();
		
		List<String> headers = new ArrayList<String>();
		for(int j = 0;j<values.getValues().get(0).size();j++) {
			headers.add(String.valueOf(values.getValues().get(0).get(j)));
		}
		data.getHeader().addAll(headers);
		
		for(int i = 1;i<values.getValues().size();i++) {
			List<String> row = new ArrayList<String>();
			for(int j = 0;j<values.getValues().get(i).size();j++) {
				row.add(String.valueOf(values.getValues().get(i).get(j)));
			}
			data.getRows().add(row);
		}
		
		return data;
	}
}
