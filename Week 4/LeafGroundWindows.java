package week4.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeafGroundWindows {

	public static void main(String[] args) {
		// Load the URl
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,15);
		driver.manage().window().maximize();
		String currentwindow = driver.getWindowHandle();
		driver.findElementByXPath("//button[text()='Open Home Page']").click();
		driver.switchTo().window(currentwindow);
		driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("The No of Window's Opened Now are: " +list.size());
		driver.switchTo().window(currentwindow);
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		List<String> list1 = new ArrayList<String>(driver.getWindowHandles());
		for (String eachWindow : list1) {
			driver.switchTo().window(eachWindow);
			if (driver.getTitle().contains("Windows")==false) {
				driver.close();			
				}
		}
		System.out.println("All the Windows except current page is Closed !");
		driver.switchTo().window(currentwindow);
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		List<String> list2 = new ArrayList<String>(driver.getWindowHandles());
		for (String eachWindow : list2) {
			driver.switchTo().window(eachWindow);
			System.out.println(driver.getTitle());
			driver.close();
		}
	}
}
