package org.PageObjectManager;

import org.baseclass.Base_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class siginAccountElements extends Base_Class{
	public siginAccountElements() {
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="(//div/ul/li[@class='authorization-link']//a)[1]")
	private WebElement sign_In;

	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	
	@FindBy(xpath="(//*[@id=\"send2\"]/span)[1]")
	private WebElement sign_In_button;		
	
	
	@FindBy(xpath="(//span[@class='logged-in'])[1]")
	private WebElement welcomeUser;


	public WebElement getSign_In() {
		return sign_In;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getSign_In_button() {
		return sign_In_button;
	}


	public WebElement getWelcomeUser() {
		return welcomeUser;
	}	
}
