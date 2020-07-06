package week5.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.tesng.base.ProjectSpecificMethod;

public class DuplicateLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setData()
	{
		excelFileName="DuplicateDeleteLead";
	}
	@Test(dataProvider="ArrayData")
	public  void runDuplicateLead_TC003(String phoneNo) throws InterruptedException {
		System.out.println("@Test Method Started");
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNo);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByName("submitButton").click();
		
}
}






