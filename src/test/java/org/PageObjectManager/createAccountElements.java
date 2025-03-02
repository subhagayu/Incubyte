package org.PageObjectManager;

import org.baseclass.Base_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createAccountElements extends Base_Class{
	
public createAccountElements() {
	PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//div[@id=\"store.links\"]/..//a[text()='Create an Account']")
 private WebElement create_account;
@FindBy(xpath="//input[@id='firstname']")
private WebElement first_name;
@FindBy(xpath="//input[@id='lastname']")
private WebElement last_name;
@FindBy(xpath="//input[@id='email_address']")
private WebElement email_address;
@FindBy(xpath="//input[@id='password']")
private WebElement pass_word;

@FindBy(xpath="//input[@id='password-confirmation']")
private WebElement confirm_password;

@FindBy(xpath="//div[@class='primary']/..//button[@title='Create an Account']")
private WebElement createaccount_button;


@FindBy(xpath="//div[@id=\"store.links\"]/..//span/button/span")
private WebElement down_arrow;

@FindBy(xpath="(//div/ul/li[@class='authorization-link']//a)[1]")
private WebElement sign_out;

@FindBy(xpath="(//div/ul/li[@class='authorization-link']//a)[1]")
private WebElement sign_In;

public WebElement getCreate_account() {
	return create_account;
}

public WebElement getFirst_name() {
	return first_name;
}

public WebElement getLast_name() {
	return last_name;
}

public WebElement getEmail_address() {
	return email_address;
}

public WebElement getPass_word() {
	return pass_word;
}

public WebElement getConfirm_password() {
	return confirm_password;
}

public WebElement getCreateaccount_button() {
	return createaccount_button;
}

public WebElement getDown_arrow() {
	return down_arrow;
}

public WebElement getSign_out() {
	return sign_out;
}

public WebElement getSign_In() {
	return sign_In;
}


}
