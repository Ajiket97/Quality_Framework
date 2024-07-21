package com.qa.utilites;

public class Config {
	
	public String readProperty(String key) {
		
		String basedir = System.getProperty("user.dir");
	    String filePath=basedir+"/src/main/resources/config.properties";
	    PropUtil propUtil= new PropUtil(filePath);
	    String value=null;
	    value=propUtil.readPropertiesFile(filePath, key);
	    return value;

	}
	
	public String getBrowserName() {
		String browserName = System.getProperty("browserName");
        if (browserName != null) {
            return browserName;
        }
		return readProperty("browserName");

	}
	public String getUrl() {
		return readProperty("url");

	}
	public String getuserName() {
		return readProperty("userName");

	}
	public String getpassword() {
		return readProperty("password");

	}
	
	
	

}
