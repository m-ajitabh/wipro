package com.aj.wipro.global;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomProperties {

	private static String value;

	public CustomProperties() {
	}



	private static String ReadFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./TestConfiguration.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

	/* get the data from properties file */
	public static String getConfigProperty(String key) {

		try {
			value = ReadFile(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;

	}

}
