package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {

	@FindBy(id="pt-login")
	WebElement loginPageLink;

	@FindBy(id="ooui-php-1")
	WebElement searchBox;

	
	@FindBy(xpath="//body/div[@id='content']/div[@id='bodyContent']/div[@id='mw-content-text']/div[2]/form[1]/div[4]/div[1]/span[1]/a[1]/span[3]")
	WebElement advanceSearch;


	@FindBy(id="advancedSearchField-intitle")
	WebElement searchByTitle;


	public MainPage(WebDriver driver){

		super(driver);

	}   


	//Mthd to check loginlink is clickable and click on the Login link 
	public void clickLoginLink(){

		wait.until(ExpectedConditions.elementToBeClickable(loginPageLink));
		loginPageLink .click();


	}  

	public void searchText(String text){
		searchBox.sendKeys(text);		
		searchBox.sendKeys(Keys.RETURN);

	}   


	public void advance_search(){
		advanceSearch.click();

	}


	public void advanceSearch_by_pageTitile(){
		wait.until(ExpectedConditions.elementToBeClickable(searchByTitle));
		searchByTitle.clear();

	}

	/*  Methods to be executed in test classes    */
	public void checkAndGoToLoginPage(){
		this.clickLoginLink();	
	}

	public void enterTextandclicksearch(String text){

		this.searchText(text);

	}


	public void advance_search_by_pageTitile_contains(){
		this.advance_search();
		this.advanceSearch_by_pageTitile();
	}




}
