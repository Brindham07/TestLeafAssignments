package week4.assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Acme {

	public static void main(String[] args) {
		// TO Load the WebPage
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Login 
		Actions builder = new Actions(driver);
		WebElement email = driver.findElement(By.id("email"));
		WebElement login = driver.findElement(By.id("buttonLogin"));
		builder.click(email).sendKeys("kumar.testleaf@gmail.com").sendKeys(Keys.TAB).sendKeys("leaf@12").perform();
		login.click();
		//Vendors
		WebElement vendor = driver.findElement(By.xpath("//button[text()=' Vendors']"));
		WebElement searchVendor = driver.findElement(By.xpath("//button[text()=' Vendors']/following-sibling::ul/li"));
		builder.moveToElement(vendor).click(searchVendor).perform();
		WebElement vendorName = driver.findElement(By.id("vendorName"));
		WebElement Search = driver.findElement(By.id("buttonSearch"));
		builder.click(vendorName).sendKeys("Blue Lagoon").click(Search).perform();
		//Get Country Name
		WebElement Country = driver.findElement(By.xpath("//table//tr/following-sibling::tr/td[5]"));
		String CountryName = Country.getText();
		System.out.println("The Country Name For Blue Lagoon Vendor is: " + CountryName);
		driver.quit();
	}
}
