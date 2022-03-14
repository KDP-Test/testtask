package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;

	//Constructor
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait =new WebDriverWait(driver, Duration.ofSeconds(25));

	}





}
