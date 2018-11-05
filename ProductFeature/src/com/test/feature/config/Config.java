package com.test.feature.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static Config config;
	
	final static Properties prop = new Properties();
	
	private Config(){
		
	}

	public static Config getInstance(){
		if(config == null){
			try {
				config = new Config();
				InputStream input = config.getClass().getClassLoader().getResourceAsStream("config.properties"); 

				//InputStream input = new FileInputStream("com.testconfig.properties");
		
				// load a properties file
				prop.load(input);
			}catch(IOException e){
				e.printStackTrace();
			}			
		}
		
		return config;
	}
	
	public String getPropertyValue(String property){
		return prop.getProperty(property);
	}
}