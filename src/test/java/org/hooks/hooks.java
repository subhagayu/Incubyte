package org.hooks;

import java.io.File;
import java.io.IOException;

import org.PageObjectManager.PageObjectManager;
import org.apache.commons.io.FileUtils;
import org.baseclass.Base_Class;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class hooks extends Base_Class{
	File screenshotDirectory = new File(System.getProperty("C:\\Users\\DELL\\eclipse-workspace\\Incubyte_Sigin\\target\\screenshots"));

	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
	scenario.attach(fileContent, "image/png", "screenshot");

}
	
//	@After
//	public void tearDown(Scenario scenario) {
//        
//		
//        String screenshotPath = Base_Class.captureScreenshot(scenario.getName().replace(" ", "_"));
//        try {
//            
//            byte[] screenshotBytes = FileUtils.readFileToByteArray(new File(screenshotPath));
//            
//            
//            scenario.attach(screenshotBytes, "image/png", "Screenshot for " + scenario.getStatus());
//            System.out.println("captures screenshoots");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


}
