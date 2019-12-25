package com.etechon.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.etechon.helper.WriteLoggerProperties;




/***
 * This code help you to read Excel  file upper than 2013 version
 * @author Gagan.Tyagi
 *
 */
public class ReadXMLfile {
	 static Logger logger = Logger.getLogger(ReadXMLfile.class);

	public static void main(String[] args) throws IOException, InvalidFormatException {
	
		init();
		File fileName = getfileName();
		XSSFWorkbook wb = new XSSFWorkbook(fileName); // Create a Object of worksheet
		XSSFSheet sheet = wb.getSheet("defects"); // read excel sheet name
		for (Row row : sheet) {
			 Cell firstCell = row.getCell(1);   // To read column 1 and column 2 
			 Cell firstCell1 = row.getCell(2);
			 System.out.print( firstCell);
			 try {
			 System.out.print((int)firstCell1.getNumericCellValue());
			 } catch (Exception e) {
				 System.out.print( firstCell1);
			}
			 System.out.println("");
		}
	}

	private static File getfileName() throws FileNotFoundException, IOException {
		Properties prop = initializePropeties();
		File file = new File(prop.getProperty("filePath")+"\\"+ prop.getProperty("fileName")); // creating a new file instance
	    logger.info("filePath :" +file);
	    return file;
	}

	private static void init() throws FileNotFoundException, IOException {
		initilizeLogger();	
	}

	private static Properties initializePropeties() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("application.properties"));
		return prop;
		
	}

	private static void initilizeLogger() {
		String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
		
	}

}
