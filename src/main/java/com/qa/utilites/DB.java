package com.qa.utilites;

public class DB {
	
	public void readDB() {
		String basedir = System.getProperty("user.dir");
	    String filePath=basedir+"/src/main/resources/db.properties";
	    PropUtil propUtil= new PropUtil(filePath);
	}

}
