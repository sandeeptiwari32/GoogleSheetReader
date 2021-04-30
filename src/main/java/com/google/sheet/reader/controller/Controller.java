package com.google.sheet.reader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.sheet.reader.service.GoogleSheetReader;

@RestController
@RequestMapping("v1")
public class Controller {
	
	@Autowired
	private GoogleSheetReader googleSheetReader;

	@GetMapping("metadata/{sheetid}")
	@ResponseBody
	public ResponseEntity<Object> getSheetMetaData(@PathVariable final String sheetid){
		try {
			return new ResponseEntity<Object>(googleSheetReader.getMetaData(sheetid), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@GetMapping("data/{sheetid}/{sheetname}")
	@ResponseBody
	public ResponseEntity<Object> getData(@PathVariable String sheetid, @PathVariable String sheetname){
		try {
			return new ResponseEntity<Object>(googleSheetReader.getdata(sheetid, sheetname), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}
