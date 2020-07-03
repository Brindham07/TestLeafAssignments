package week4.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeafGroundWait {

	public static void main(String[] args) {

		/* Wait for Text Change */

		// Load the URl
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		WebElement button = driver.findElementById("btn");
		wait.until(ExpectedConditions.textToBe((By.id("btn")), "Click ME!"));
		button.click();
		System.out.println("****** Wait for Text Change*******");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		/* Wait for Alert */

		// Load the URl
		driver.get("http://www.leafground.com/pages/alertappear.html");
		driver.manage().window().maximize();
		WebElement alertBtn = driver.findElementById("alert");
		alertBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("---- Wait for Alert------");
		System.out.println("Alert is Present");
		driver.switchTo().alert().accept();

		/* Wait for Elements to Appear */

		// Load the URl
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		List<WebElement> text = driver.findElementsByXPath("//div[@class='flex']/button");
		wait.until(ExpectedConditions.visibilityOfAllElements(text));
		System.out.println("****** Wait for Elements to Appear*******");
		for (WebElement eachText : text) {
			System.out.println(eachText.getText());
		}
		
		/*Wait for Element Disappearance*/ 

		// Load the URl
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		WebElement disappear = driver.findElement(By.tagName("strong"));
		wait.until(ExpectedConditions.visibilityOf(disappear));
		System.out.println("--------Wait for Element Disappearance-------");
		System.out.println(disappear.getText());
		driver.close();
	}
}
