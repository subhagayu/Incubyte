package org.stepdef;

import org.PageObjectManager.PageObjectManager;
import org.baseclass.Base_Class;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends Base_Class{
	PageObjectManager pom = new PageObjectManager();
	public static String e_mail,pass_word,create_Accout_Name;
	


	@Given("User has to launch the browser and click on the create account button {string}")
	public void user_has_to_launch_the_browser_and_click_on_the_create_account_button(String url) throws Exception {
		browserlaunch(url);
		
	    System.out.println("user has launched the browser successfully");
	    Thread.sleep(2000);
	 // waitForElementVisibility(pom.createAccount_elements().getCreate_account(), 5);
	 // wait_clickable_element(pom.createAccount_elements().getCreate_account(), 5);
	    btnClick(pom.createAccount_elements().getCreate_account());
	    
	}
	
	@Then("User has to enter the required fields like {string} {string} {string} {string} {string}")
	public void user_has_to_enter_the_required_fields_like(String FirstName, String LastName, String Email, String password, String confirmpassword) throws Throwable {
	    System.out.println("user has to enter the all the required fields");
	    e_mail = Email;
	    pass_word=password;
	    firstName(FirstName);
	    lastName(LastName);
	    e_Mail(e_mail);
	    pass_word(pass_word);
	    confirmpass_word(confirmpassword);
	    btnClick(pom.createAccount_elements().getCreateaccount_button());
	    waitForElementVisibility(pom.sign_In_elements().getWelcomeUser(), 5);
	    String creatAccount_welcomeText = pom.sign_In_elements().getWelcomeUser().getText();
	    System.out.println("user creataccount name:"+creatAccount_welcomeText);
	    create_Accout_Name=creatAccount_welcomeText;
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
	    
	    }
	
	@And("User has to click on the profile down arrown and click on the SignOut button")
	public void user_has_to_click_on_the_profile_down_arrown_and_click_on_the_sign_out_button() throws Exception {
	   System.out.println("user has to sign out successfully");
	   btnClick(pom.createAccount_elements().getDown_arrow());
	// waitForElementVisibility(pom.createAccount_elements().getSign_out(), 5);
	   btnClick(pom.createAccount_elements().getSign_out());
	   System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
	   
	}
	@And("User has to click on the signIn button")
	public void user_has_to_click_on_the_sign_in_button() throws Exception {
		
		System.out.println("user has to click on the sign_in button");
		btnClick(pom.sign_In_elements().getSign_In());
		
		}
	@And("User has to enter the {string} {string} and user has to click on the SignIn button")
	public void user_has_to_enter_the_and_user_has_to_click_on_the_sign_in_button(String Email, String password) throws Exception {
	    email_signin(e_mail);
	    password_signin(pass_word);
	    Thread.sleep(2000);
	    btnClick(pom.sign_In_elements().getSign_In_button());
	    Thread.sleep(2000);
	    waitForElementVisibility(pom.sign_In_elements().getWelcomeUser(), 5);
	    String welcomeText = pom.sign_In_elements().getWelcomeUser().getText();
	    System.out.println("user signIn name:"+welcomeText);
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
	    Assert.assertEquals(create_Accout_Name, welcomeText);
	    System.out.println("user has successsfully created account and using the same deatils signned in");
	    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
	    
	    
	}

}
