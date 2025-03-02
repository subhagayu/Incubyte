package org.hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.baseclass.Base_Class;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.PageObjectManager.PageObjectManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;

public class hooks extends Base_Class{
	
	
	
	@After
	public void tearDown(Scenario scenario) {
        
		
        String screenshotPath = Base_Class.captureScreenshot(scenario.getName().replace(" ", "_"));
        try {
            
            byte[] screenshotBytes = FileUtils.readFileToByteArray(new File(screenshotPath));
            
            
            scenario.attach(screenshotBytes, "image/png", "Screenshot for " + scenario.getStatus());
            System.out.println("captures screenshoots");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
