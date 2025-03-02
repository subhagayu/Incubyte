package org.runner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src\\test\\resources\\FeatureFile",
glue = {"org.stepdef","org.hooks"},
plugin = {
		"pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
tags="@001CreateAccout",
monochrome= true,  dryRun= false)

public class execute extends AbstractTestNGCucumberTests {

	private static ByteArrayOutputStream consoleOutput;
	private static PrintStream originalOut;
	// This method will run before all scenarios
	@BeforeClass
	public static void setUp() {
	    consoleOutput = new ByteArrayOutputStream();
	    originalOut = System.out; // Save the original System.out
	    System.setOut(new PrintStream(consoleOutput)); // Redirect System.out to capture output
	    System.out.println("=== Test Execution Started ===");
	}

	    @AfterClass
	    public static void tearDown1() {
	        System.setOut(originalOut); // Restore the original System.out
	        System.out.println("=== Test Execution Finished ===");
	        // Print captured output for debugging or further processing
	        System.out.println("Captured Console Output:\n"+ getCapturedConsoleOutput());
	    }
	    // Method to retrieve captured output
	    public static String getCapturedConsoleOutput() {
	    	 return consoleOutput.toString();
	    }
	    
	    
 }
