package tests;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

	public static WebDriver driver ;
	SoftAssert softassert = new SoftAssert(); 
	String projectpath = System.getProperty("user.dir");
	public static String browserName;
	Properties prop= new Properties();
	public static String url;
	public static WebDriverWait wait;

	@BeforeTest
	public void setup(){

		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")){		

			System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/utilities/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectpath+"/src/test/resources/utilities/chromedriver.exe");
			driver = new FirefoxDriver();

		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		

	}


	@AfterTest
	public void teardown(){

		driver.close();
		driver.quit();


	}

	
	
}
