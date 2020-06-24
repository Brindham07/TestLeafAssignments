package week2ssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
	
	public static void main(String[] args) throws Exception  {
		// TO Delete Lead
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("Demosalesmanager");
			
		WebElement elePasswrd = driver.findElementById("password");
		elePasswrd.sendKeys("crmsfa");
		
        WebElement btnSubmit = driver.findElementByClassName("decorativeSubmit");
		btnSubmit.click();

		WebElement eleLink = driver.findElementByLinkText("CRM/SFA");
	    eleLink.click();
	       
	    WebElement eleLeadtab = driver.findElementByLinkText("Leads");
	    eleLeadtab.click();
	    
	    WebElement eleFindLeads = driver.findElementByXPath("//a[text()='Find Leads']");
	    eleFindLeads.click();
	    
	    WebElement eleEmail = driver.findElementByXPath("//span[text()='Email']");
	    eleEmail.click();
	    
	    WebElement eleUserEmail = driver.findElementByXPath("//input[@name='emailAddress']");
	    eleUserEmail.sendKeys("brindhamb07@gmail.com");
	    
	    WebElement eleFind = driver.findElementByXPath("//button[text()='Find Leads']");
	    eleFind.click();
	   
	    Thread.sleep(3000);
	    WebElement eleLeadID = driver.findElementByXPath("//table[@class='x-grid3-row-table']//tr//div/a");
	    String LeadID = eleLeadID.getText();
	    if (LeadID== null) {
	    	 String error = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
	 	    System.err.println(error);
			
		}
	    System.out.println(LeadID);
	    eleLeadID.click();
	
	    Thread.sleep(3000);
	    WebElement eleDelete = driver.findElementByXPath("//a[@class='subMenuButtonDangerous']");
	    eleDelete.click();
	    Thread.sleep(3000);
   
	    driver.findElementByXPath("//a[text()='Find Leads']").click();
	    driver.findElementByXPath("//span[text()='Email']").click();
	    driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("brindhamb07@gmail.com");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(3000);
	    String error = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
	    System.err.println(error);
	}

}
