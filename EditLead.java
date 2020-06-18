package week2ssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditLead {

	public static void main(String[] args) {
		// TO Automate Edit lead tab
		
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
		    
		    WebElement eleFirstName= driver.findElementByXPath("(//input[@name='firstName'])[3]");
		    eleFirstName.sendKeys("Brindha");
		    
		    WebElement eleCompName= driver.findElementByXPath("(//input[@name='companyName'])[2]");
		    eleCompName.sendKeys("TestLeaf");
		    
		    WebElement eleFind = driver.findElementByXPath("//button[text()='Find Leads']");
		    eleFind.click();
		    
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='x-grid3-row-table']//tr//div/a")));
		    
		    WebElement eleLeadID = driver.findElementByXPath("//table[@class='x-grid3-row-table']//tr//div/a");
		    eleLeadID.click();
				
		    WebElement eleEdit = driver.findElementByXPath("//a[text()='Edit']");
		    eleEdit.click();
		    
		    WebElement eleUCompName = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
		    
		    String CurrentCN = eleUCompName.getText();
		    System.out.println(CurrentCN);
		    eleUCompName.clear();
		    eleUCompName.sendKeys("Test Leaf Updated");
		   
		    WebElement eleUpdate = driver.findElementByXPath("//input[@value='Update']");
		    eleUpdate.click();
		   
		    WebElement eleUpdatedCompName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		    String UpdatedCN = eleUpdatedCompName.getText();
		    System.out.println(UpdatedCN);
		  
		    driver.quit();

	}

}
