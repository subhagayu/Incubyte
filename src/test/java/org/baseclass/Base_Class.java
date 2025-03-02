package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.PageObjectManager.PageObjectManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;
	static PageObjectManager pom = new PageObjectManager();

	// 1
	
	public static void browserlaunch(String url) {
//	System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\DELL\\Downloads\\chromedriver-win64 new\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();	
	driver = new ChromeDriver();
		driver.get(url);
	driver.manage().window().maximize();
	
	}

	// 2
	public static WebElement findElementId(String Id) {
		WebElement elementId = driver.findElement(By.id(Id));
		return elementId;
	}

	// 3
	public static WebElement findElementname(String name) {
		WebElement elementname = driver.findElement(By.name(name));
		return elementname;
	}

	// 4
	public static WebElement findElementxpath(String xpath) {
		WebElement elementxpath = driver.findElement(By.xpath(xpath));
		return elementxpath;
	}

	// 5
	public static void findElementsendvalue(String Value, WebElement element) {
		element.sendKeys(Value);
	}

	// 6
	public void findElementclick(WebElement element) {
		element.click();
	}

	// 7
	public String readExcel(String pathName, String sheetName, int rowNo) throws IOException {
		String data = null;
		
		File file = new File(pathName);
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		Row row2 = sheet.getRow(rowNo);
		short lastCellNum = row2.getLastCellNum();
		for (int i = 1; i <=lastRowNum; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell2 = row.getCell(j);
				DataFormatter format = new DataFormatter();
				String formatCellValue = format.formatCellValue(cell2);
				System.out.println(formatCellValue);
			}
			
		}
		return data;

	}

	// 8
	public String moveToElement(WebElement target) {
		String Drag = null;
		Actions a = new Actions(driver);
		Actions moveToElement = a.moveToElement(target);
		moveToElement.perform();

		return Drag;
	}

	// 9
	public String dragandDrop(WebElement source, WebElement target) {
		String Drop = null;
		Actions a = new Actions(driver);
		Actions dragAndDrop = a.dragAndDrop(source, target);
		dragAndDrop.perform();
		return Drop;
	}

	// 10
	public void Select(WebElement reference, int index) {
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(reference);
		s.selectByIndex(index);

	}

	// 11
	public void Select1(WebElement reference, String value) {
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(reference);
		s.selectByValue(value);

	}

	// 12
	public void Select2(WebElement reference, String text) {
		org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(reference);
		s.selectByVisibleText(text);

	}

	// 13
	public void toWriteExcel(String pathname, String sheetname, int row, int cell, String text) throws IOException {
		File File = new File(pathname);
		FileOutputStream output = new FileOutputStream(File);
		Workbook book = new XSSFWorkbook();
		Sheet Sheet = book.createSheet();
		Row Row = Sheet.createRow(row);
		Cell Cell = Row.createCell(cell);
		Cell.setCellValue(text);
		book.write(output);

	}

	// 14
	public Object executeScript(String script, Object user) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].setAttribute('value','ram')", user);

		return null;
	}

	// 15
	public Object executeScript1(Object pageDown) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", pageDown);

		return null;
	}

	// 16
	public Object executeScript2(Object pageUp) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", pageUp);

		return null;
	}

	

//17
	
	public WebElement navigation() {
		driver.navigate().back();
		return null;
		
	}
//18
	public WebElement navigation1() {
		driver.navigate().forward();
		return null;

//19
	}
	public WebElement navigation2() {
		driver.navigate().refresh();
		return null;
		
	}

//20
	public void alert() {
		driver.switchTo().alert();
		

	}

//21
	public static String[][] getExceldata(String pathName, String sheetname, int rowNo, int cellNo) throws IOException {
		File file = new File(pathName);
		FileInputStream input = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(input);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		short lastCellNum = row.getLastCellNum();
		int lastRowNum = sheet.getLastRowNum();
		String [] [] data = new String[lastRowNum] [lastCellNum];
		for (int i = 1; i <lastRowNum; i++) {
			Row row2 = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell2 = row.getCell(j);
				DataFormatter format = new DataFormatter();
				String formatCellValue = format.formatCellValue(cell2);
//				System.out.println(formatCellValue);
				data[i-1][j]=formatCellValue;
			}
		
			
		}
		return data;


	}
	
	//22
	public static void waitForElementVisibility(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//		wait.until(
//				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//23
	public static void wait_clickable_element(WebElement b, int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.elementToBeClickable(b));

	}
	//24
	public static void btnClick(WebElement element) throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	//24
	public static void sendvalue(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	//25
	public static void firstName(String FirstName) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.createAccount_elements().getFirst_name(), 5);
	    wait_clickable_element(pom.createAccount_elements().getFirst_name(), 5);
	    btnClick(pom.createAccount_elements().getFirst_name());
	    sendvalue(pom.createAccount_elements().getFirst_name(), FirstName);
		
	}
	//26
	public static void lastName(String LastName) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.createAccount_elements().getLast_name(), 5);
	    wait_clickable_element(pom.createAccount_elements().getLast_name(), 5);
	    btnClick(pom.createAccount_elements().getLast_name());
	    sendvalue(pom.createAccount_elements().getLast_name(), LastName);
		
	}
	//27
	public static void e_Mail(String Email) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.createAccount_elements().getEmail_address(), 5);
	    wait_clickable_element(pom.createAccount_elements().getEmail_address(), 5);
	    btnClick(pom.createAccount_elements().getEmail_address());
	    sendvalue(pom.createAccount_elements().getEmail_address(), Email);
		
	}
	//28
	public static void pass_word(String password) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.createAccount_elements().getPass_word(), 5);
	    wait_clickable_element(pom.createAccount_elements().getPass_word(), 5);
	    btnClick(pom.createAccount_elements().getPass_word());
	    sendvalue(pom.createAccount_elements().getPass_word(), password);
		
	}
	//29
	public static void confirmpass_word(String confirmpassword) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.createAccount_elements().getConfirm_password(), 5);
	    wait_clickable_element(pom.createAccount_elements().getConfirm_password(), 5);
	    btnClick(pom.createAccount_elements().getConfirm_password());
	    sendvalue(pom.createAccount_elements().getConfirm_password(), confirmpassword);
		
	}
	
	public static void email_signin(String Email) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.sign_In_elements().getEmail(), 5);
	    wait_clickable_element(pom.sign_In_elements().getEmail(), 5);
	    btnClick(pom.sign_In_elements().getEmail());
	    sendvalue(pom.sign_In_elements().getEmail(), Email);
		
	}
	
	public static void password_signin(String password) throws Exception {
		Thread.sleep(2000);
	    waitForElementVisibility(pom.sign_In_elements().getPassword(), 5);
	    wait_clickable_element(pom.sign_In_elements().getPassword(), 5);
	    btnClick(pom.sign_In_elements().getPassword());
	    sendvalue(pom.sign_In_elements().getPassword(), password);
		
	}
	
	
	public static String captureScreenshot(String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "target/screenshots/" + screenshotName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
}
