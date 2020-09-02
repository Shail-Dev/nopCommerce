package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;

	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		
		try{
			FileInputStream fs = new FileInputStream(src);
			pro = new Properties();
			pro.load(fs);
			
		}catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
			
		}
			
	}
	
	public String getApplicationUrl() {
		
		return pro.getProperty("baseURL");
		
	}
	
	public String getChromePath() {
		return pro.getProperty("chromepath");
	}
	
	public String getFireFoxPath() {
		return pro.getProperty("firefoxpath");
	}
	
	public String getIEPath() {
		return pro.getProperty("iepath");
	}
	
	public String getUserEmail() {
		return pro.getProperty("useremail");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}


}
