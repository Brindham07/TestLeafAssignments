package week5.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.tesng.base.ProjectSpecificMethod;

public class DeleteLead extends ProjectSpecificMethod{
	@BeforeTest
	public void setData()
	{
		excelFileName="DuplicateDeleteLead";
	}
	@Test(dataProvider="ArrayData")
	public  void runDeleteLead_TC002(String phoneNo) throws InterruptedException {
		
		System.out.println("@Test Method Started");
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNo);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
	    if (leadID == null) {
	    	 String error = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
	 	    System.err.println(error);
			
		}
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Delete").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElementByClassName("x-paging-info").getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		
}
}






