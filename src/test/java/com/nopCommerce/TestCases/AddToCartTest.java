package com.nopCommerce.TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerce.Pages.HomePage;
import com.nopCommerce.TestBase.TestBase;

public class AddToCartTest extends TestBase {
	public WebDriver driver;
	public HomePage homePage;
	
	
	public AddToCartTest() throws Exception{ 
		  super();
	}		  
 @BeforeMethod
 public void checkoutSetup() {
		  	driver = openingApplicationWithAnyBrowser(prop.getProperty("browser"));
		  	homePage = new HomePage(driver);
		  	homePage.clickOnBooksHomePageIcon();
		    //Note: I dont need to initialize driver because im working on the same instance: 
		  	//homePage = new HomePage(driver);		  	
}
 
@Test(priority=1)
public void verifyProductAddedToShoppingCart() {
	homePage.clickOnPrideAndPrejudiceBook();
	//homePage = new HomePage(driver);
	homePage.clickOnPrideAndPrejudiceBookAddToCartButton();
	//homePage = new HomePage(driver);
	homePage.clickOnShoppingCartButton();
	//homePage = new HomePage(driver);
	String expectedMessage = ("Pride and Prejudice");
	String actualMessage = driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a")).getText();
	// I can Also use equals instead of contains as follow: assertTrue(expectedMessage.equals(actualMessage));    
	assertTrue(actualMessage.contains(expectedMessage));
	
}
@AfterMethod
public void tearDown() {	
	driver.quit();
	}
}