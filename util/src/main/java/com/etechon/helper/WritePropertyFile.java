package com.etechon.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertyFile {
	public static void main(String args[]) {
		Properties prop = new Properties();
		try {
			// set the properties value
			prop.setProperty("fileName", "employee.txt");
			prop.setProperty("filePath", "F:\\Techm_Code\\Excel dependency");
			// save properties to project root folder
			prop.store(new FileOutputStream("application.properties"), null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
}
}
