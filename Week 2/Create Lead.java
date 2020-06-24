package week2ssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Create Lead
		
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
			
	    WebElement eleCreatelead = driver.findElementByLinkText("Create Lead");
		eleCreatelead.click();
		
		WebElement eleCmpnyName = driver.findElementByXPath("//input[@id='createLeadForm_companyName']");
		eleCmpnyName.sendKeys("TestLeaf");
		
		WebElement eleFirstName = driver.findElementByXPath("//input[@id='createLeadForm_firstName']");
		eleFirstName.sendKeys("Brindha");
			
	    WebElement eleLastName = driver.findElementByXPath("(//input[@name='lastName'])[3]");
		eleLastName.sendKeys("Pranesh");

		Select eDDSource = new Select(driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']"));
		eDDSource.selectByValue("LEAD_EMPLOYEE");
			
		WebElement eleAnnualRevenue = driver.findElementByXPath("//input[@id='createLeadForm_annualRevenue']");
		eleAnnualRevenue.sendKeys("1000000");
		
		Select eDDIndustry = new Select(driver.findElementByXPath("//select[@id='createLeadForm_industryEnumId']"));
		eDDIndustry.selectByValue("IND_SOFTWARE");
		
		Select eDDOwnership = new Select(driver.findElementByXPath("//select[@id='createLeadForm_ownershipEnumId']"));
		eDDOwnership.selectByVisibleText("S-Corporation");
		
		WebElement eleDescription = driver.findElementByXPath("//textarea[@id='createLeadForm_description']");
		eleDescription.sendKeys("Selenium Automation Tester");
		
		Select eDDMarketingCampaign = new Select(driver.findElement(By.id("createLeadForm_marketingCampaignId")));
		eDDMarketingCampaign.selectByIndex(6);
		
		Select eDDStateProvince = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		eDDStateProvince.selectByValue("TX");
		
		WebElement eleprimaryEmail = driver.findElementByXPath("//input [@id='createLeadForm_primaryEmail']");
		eleprimaryEmail.sendKeys("brindhamb07@gmail.com");
		
		WebElement eleprimaryPhoneNumber = driver.findElementByXPath("//input [@id='createLeadForm_primaryPhoneNumber']");
		eleprimaryPhoneNumber.sendKeys("8754135157");
		
		/*WebElement eleAccountName = driver.findElementByXPath("//input[@name='accountName']");
		eleAccountName.sendKeys("Brindha");
		
		WebElement eleCountryCode = driver.findElementByXPath("(//div[@class='x-plain-bwrap'])[3]//input");
		eleCountryCode.sendKeys("+1");
		
		WebElement eleAreaCode = driver.findElementByXPath("(//div[@class='x-plain-bwrap'])[4]//input");
		eleAreaCode.sendKeys("409");
		
		WebElement elePhNo = driver.findElementByXPath("(//div[@class='x-plain-bwrap'])[5]//input");
		elePhNo.sendKeys("1477");
		
		WebElement eleEmail = driver.findElementByXPath("(//input[@name='primaryEmail'])[1]");
		eleEmail.sendKeys("brindhamb07@gmail.com");
		
		WebElement eleAccount = driver.findElementByXPath("//button[text()='Create Account']");
		eleAccount.click();
		*/
		/*String Alert = driver.switchTo().alert().getText();
		System.out.println(Alert);
		driver.switchTo().alert().dismiss();
		*/
		WebElement btnCreateLead = driver.findElementByXPath("//input[@class='smallSubmit']");
		btnCreateLead.click();	
		driver.quit();
	}
	
}
