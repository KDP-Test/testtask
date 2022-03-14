package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {


	@FindBy(id="wpName1")
	WebElement wikiUserName; 


	@FindBy(id="wpPassword1")
	WebElement wikiPassword; 

	@FindBy(id="wpLoginAttempt")
	WebElement wikiLoginButton;


	@FindBy(xpath="//*[@class='errorbox']")
	WebElement textInErrorBox;




	public LoginPage(WebDriver driver){
		super(driver);

	}   


	//enter username in textbox

	public void setUserName(String strUserName){
		wikiUserName.sendKeys(strUserName);
	}

	//enter pwd in textbox
	public void setPassword(String strPassword){
		wikiPassword.sendKeys(strPassword);

	}

	//Click on login button
	public void clickLogin(){

		wikiLoginButton.click();

	}  

	//Get error on invalid data entry to login page
	public String geterrormsg(){
		String actualerrorMsg=textInErrorBox.getText();
		return actualerrorMsg;


	}




	/*  Methods to be executed in test classes    */

	public void loginWikiPage(String strUserName,String strPassword){

		//Enter user name

		this.setUserName(strUserName);

		//Enter password

		this.setPassword(strPassword);

		//Click Login button

		this.clickLogin();           

	}






}
