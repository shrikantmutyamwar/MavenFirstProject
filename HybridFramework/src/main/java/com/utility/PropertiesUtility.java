package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtility extends BaseClass{

	public static FileInputStream fis = null;

	public static String readproperty(String key) {
		log.info("reading proprty file for a key :-"+key); // we can use log anywhere as we extended base class
		Properties prop = new Properties();  // creating object of properties
		try {
			//creating object of fileInputStream
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties"); 
			prop.load(fis);  // connected properties file and fis using load method from proprties class
		} catch (Exception e) {
			log.info("value not found in config file");
			e.printStackTrace();
		}
		log.info("value assign to the key is found as "+prop.getProperty(key));
		return prop.getProperty(key);

	}

	
}
