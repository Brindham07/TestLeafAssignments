package week4.assignment;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {

		// TO Load the WebPage
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// Click on the Start your wonderful journey link
		WebElement Title = driver.findElementByLinkText("Start your wonderful journey");
		Title.click();
		// Click on any pick up point under POPULAR PICK-UP
		WebElement pickUpPoint = driver.findElementByXPath("//div[@class='component-popular-locations']//div[3]");
		pickUpPoint.click();
		// Click on the Next button
		WebElement Next = driver.findElementByXPath("//button[@class='proceed']");
		Next.click();
		// Specify the Start Date as tomorrow Date
		WebElement Date = driver.findElementByXPath("//div[@class='days']/div[2]");
		Date.click();
		// Click on the Next Button
		Next.click();
		// Confirm the Next day of Start Date and Click on the Done button
		WebElement DropDate = driver.findElementByXPath("//div[@class='days']/div[2]");
		DropDate.click();
		WebElement Done = driver.findElementByXPath("//button[text()='Done']");
		Done.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		// capture the number of results displayed
		List<WebElement> CarName = driver.findElementsByTagName("h3");
		int Results = CarName.size();
		System.out.println("The no of Results Displayed are: " + Results);
		// Find the highest priced car ride using Map Interface.
		List<WebElement> Price = driver.findElementsByXPath("//div[@class='price']");
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		// Pass the values inside a map
		for (int j = 0; j < Results; j++) {
			String textPrice = Price.get(j).getText().trim();
			String Carname = CarName.get(j).getText();
			map.put(Carname, (Integer.parseInt(textPrice.replaceAll("[^\\d]", ""))));
		}
		// Find maximum price
		int maxKey = Collections.max(map.values());
		// Click on the Book Now button for maximum price
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() == maxKey) {
				System.out.println(
						"The Carname of the max price car is: " + eachEntry.getKey() + "----->" + eachEntry.getValue());
				driver.findElementByXPath("//h3[contains(text(),'" + eachEntry.getKey()
						+ "')]/parent::div/following-sibling::div//div//button").click();
			}
		}

	}

}
