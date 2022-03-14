package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.MainPage;



public class TestMainPage extends BaseTest {
	MainPage mainPage;

	@Test
	@Parameters({"searchtext"})
	public void verifyTitle_and_user_able_to_navigate_to_loginLink(String text){

		mainPage = new MainPage(driver);

		//Verify search text 
		mainPage.enterTextandclicksearch(text);
			
		
		if(driver.getPageSource().contains(text)){
			System.out.println(" search content is found" );

		}
		else{
			
			System.out.println(" search content not found" );

		}


		// verify if it is navigated to correct page on on clicking Login	
		mainPage.checkAndGoToLoginPage();
		String expectedloginPageTitle ="Log in - Wikipedia";
		String actualloginPageTitle = driver.getTitle();
		softassert.assertEquals(actualloginPageTitle, expectedloginPageTitle);
		softassert.assertAll();


	}






}
