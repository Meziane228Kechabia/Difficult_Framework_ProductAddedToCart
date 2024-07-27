package com.nopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;

@FindBy(linkText ="Books")
private WebElement booksHomePageLink;

@FindBy(xpath ="//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a")
private WebElement prideAndPrejudiceBook;

@FindBy(xpath = "//button[@id='add-to-cart-button-39']")
private WebElement prideAndPrejudiceBookAddToCartButton;

@FindBy(linkText = "Shopping cart")
private WebElement shoppingCartButton;

public HomePage (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

		
public HomePage clickOnBooksHomePageIcon() {
		booksHomePageLink.click();
		return new HomePage(driver);
}

public HomePage clickOnPrideAndPrejudiceBook() {
	prideAndPrejudiceBook.click();
	return new HomePage(driver);
}

public HomePage clickOnPrideAndPrejudiceBookAddToCartButton() {
	prideAndPrejudiceBookAddToCartButton.click();
    return new HomePage(driver);
	}

public HomePage clickOnShoppingCartButton() {
	shoppingCartButton.click();
	return new HomePage(driver);
}

}


