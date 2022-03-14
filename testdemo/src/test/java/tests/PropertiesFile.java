package tests;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {


	public static Properties prop= new Properties();
	public static void main(String[] args) {
		getProperties();

	}

		public static void getProperties(){		

			try {			

				String projectpath = System.getProperty("user.dir");
				InputStream input= new FileInputStream(projectpath+"/src/test/resources/config/config.properties");
				prop.load(input);
				String browser = prop.getProperty("browser");
				String url =prop.getProperty("url");
				BaseTest.browserName=browser;
				BaseTest.url=url;

			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
