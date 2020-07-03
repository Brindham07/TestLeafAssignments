package week4.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeafGroundAlert {

public static void main(String[] args) {
// TO Load the WebPage
System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.get("http://www.leafground.com/pages/Alert.html");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
WebDriverWait wait = new WebDriverWait(driver, 15);
driver.manage().window().maximize();
driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
driver.switchTo().alert().accept();
System.out.println("Alert Box is Clicked");
driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
driver.switchTo().alert().accept();
System.out.println("Confirm Box Alert is Clicked");
driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
driver.switchTo().alert().sendKeys("T Leaf");
driver.switchTo().alert().accept();
System.out.println("Prompt Alert Box is Clicked");
driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
driver.switchTo().alert().accept();
System.out.println(" Line Breaks Alert Box is Clicked");
driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
WebElement okBtn = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
//driver.switchTo().alert().accept();
wait.until(ExpectedConditions.visibilityOf(okBtn));
okBtn.click();
System.out.println("Sweet Alert is Clicked");
}
}