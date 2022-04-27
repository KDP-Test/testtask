package tests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataProviders.ExcelDataProvider;
import pages.LoginPage;


public class TestLoginPage2 extends BaseTest {

	LoginPage loginPage;
	

	@Test(dataProvider ="excel-data",dataProviderClass=ExcelDataProvider.class)
	public void invalidUsernameAndPassword_LoginTest(String name , String pwd) 
	{


		// login with invalid data
		loginPage = new LoginPage(driver);
		loginPage.checkAndGoToLoginPage();
		loginPage.loginWikiPage(name,pwd);

		String actualerrror = loginPage.geterrormsg();
		System.out.println(actualerrror);
		String expectedErrorMsg ="Incorrect username or password entered. Please try again.";
		softassert.assertEquals(actualerrror, expectedErrorMsg);
		softassert.assertAll();

	}



}
