package tests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;


public class TestLoginPage extends BaseTest {

	LoginPage loginPage;

	@Test
	@Parameters({"username","password"})
	public void invalidUsernameAndPassword_LoginTest(String name , String pwd) 
	{


		// login with invalid data
		loginPage = new LoginPage(driver);
		loginPage.loginWikiPage(name,pwd);

		String actualerrror = loginPage.geterrormsg();
		System.out.println(actualerrror);
		String expectedErrorMsg ="Incorrect username or password entered. Please try again.";
		softassert.assertEquals(actualerrror, expectedErrorMsg);
		softassert.assertAll();

	}



}
