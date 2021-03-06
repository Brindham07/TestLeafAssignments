package com.leaftaps.tesng.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.ReadDeleteExcel;
import utility.ReadEditExcel;
import utility.ReadExcel;

public class ProjectSpecificMethod {
	
	public ChromeDriver driver;
	public String excelFileName;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void openApp(String url, String username, String password) 
	{

		System.out.println("Before Method is Initiated");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Before Method ended");
	}

	@AfterMethod
	public void closeApp() {
		System.out.println("After Method is Initiated");
		driver.close();
		System.out.println("After Method Ended");
	}

	@DataProvider(name = "ArrayData")
	public String[][] sendData() throws IOException {
		// Create a 2-D Array
		String[][] array = ReadExcel.readExcelData(excelFileName);
		return array;
		/*
		 * String[][] array= new String[2][3]; array[0][0]="Testleaf";
		 * array[0][1]="Brindha"; array[0][2]="Pranesh";
		 * 
		 * array[1][0]="Testleaf"; array[1][1]="Ashmietha"; array[1][2]="Pranesh";
		 * return array;
		 */
	}
}