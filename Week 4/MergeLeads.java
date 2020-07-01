package week4.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLeads {

	public static void main(String[] args) {
		// Load the URl
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Login Details
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("Demosalesmanager");

		WebElement elePasswrd = driver.findElementById("password");
		elePasswrd.sendKeys("crmsfa");

		WebElement btnSubmit = driver.findElementByClassName("decorativeSubmit");
		btnSubmit.click();

		WebElement eleLink = driver.findElementByLinkText("CRM/SFA");
		eleLink.click();

		// Click on contacts Button
		WebElement eleContact = driver.findElementByXPath("//a[text()='Contacts']");
		eleContact.click();

		// Click on Merge Contacts using Xpath Locator
		WebElement eleMergeContact = driver.findElementByXPath("//ul[@class='shortcuts']//li[4]/a");
		eleMergeContact.click();

		// Click on Widget of From Contact
		WebElement eleFromContact = driver
				.findElementByXPath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a");
		eleFromContact.click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String currentWindow = list.get(0);
		String desrireWindow = list.get(1);
		driver.switchTo().window(desrireWindow);
		System.out.println(driver.getTitle());

		// Click on First Resulting Contact
		WebElement fromContactID = driver.findElementByXPath("//table[@class='x-grid3-row-table']//tr//div/a");
		fromContactID.click();
		driver.switchTo().window(currentWindow);

		// Click on Widget of To Contact
		WebElement eleToContact = driver.findElementByXPath("//table[@name='ComboBox_partyIdTo']/following-sibling::a");
		eleToContact.click();

		Set<String> toWindowHandles = driver.getWindowHandles();
		List<String> toList = new ArrayList<String>(toWindowHandles);
		String toCurrentWindow = toList.get(0);
		String toDesrireWindow = toList.get(1);
		driver.switchTo().window(toDesrireWindow);
		System.out.println(driver.getTitle());

		// Click on Second Resulting Contact
		WebElement toContactID = driver
				.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		toContactID.click();
		driver.switchTo().window(toCurrentWindow);

		// Click on Merge button using Xpath Locator
		WebElement eleMerge = driver.findElementByXPath("//a[text()='Merge']");
		eleMerge.click();

		// Accept the Alert
		driver.switchTo().alert().accept();

		// Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);

	}

}
