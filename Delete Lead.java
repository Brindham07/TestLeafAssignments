package week2ssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DeleteLead {
	
	public static void main(String[] args) {
		// TO Delete Lead
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		 
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
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='x-grid3-row-table']//tr//div/a")));
	    WebElement eleLeadID = driver.findElementByXPath("//table[@class='x-grid3-row-table']//tr//div/a");
	    String LeadID = eleLeadID.getText();
	    System.out.println(LeadID);
	    eleLeadID.click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	 /*   WebElement eleDelete = driver.findElementByXPath("//a[@class='subMenuButtonDangerous']");
	    eleDelete.click();*/
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Leads")));
	      eleLeadtab.click();
	    
	    WebElement eleHome = driver.findElementByLinkText("My Home");
	    eleHome.click();
	    
	   // eleLeadtab.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Leads']"))).click();
	    
	    
	    eleFindLeads.click();
	    eleEmail.click();
	    eleUserEmail.sendKeys("brindhamb07@gmail.com");
	    eleFind.click();
	    WebElement error = driver.findElementByXPath("//div[@class='x-paging-info']");
	    System.err.println(error);
	  
	 
	}

}
