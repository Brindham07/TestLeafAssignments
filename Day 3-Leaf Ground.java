package week2ssignment;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import  java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	private static WebElement Links;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		System.out.println("=======Interacting with Buttons===========");
		//Click on Home Page 
		driver.findElementById("home").click();
		driver.findElementByXPath("//img[@alt='Buttons']").click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Find the Position 
		System.out.println("The position of the button is: " +driver.findElementById("position").getLocation());
		//Find the Color
        System.out.println("The color of the button is "+driver.findElementById("color").getCssValue("background-color")); 
        //Find the size
        System.out.println("The Size of the textbox is: " +driver.findElementById("size").getSize());
        System.out.println("*************");
        System.out.println("========Interacting with Links========");
        driver.findElementById("home").click();
        driver.findElementByXPath("//img[@alt='Link']").click();
        //Clicking Home Page
        driver.findElementByXPath("(//a[text()='Go to Home Page'])[1]").click();
        System.out.println("Home Page has been Clicked");
        //Getting the Link
        driver.findElementByXPath("//img[@alt='Link']").click();
        System.out.println("The link is supposed to goto: " +driver.findElementByXPath("//a[contains(text(),'clicking me?')]").getAttribute("href"));
        //Verifying if the link is Broken
        String attribute = driver.findElementByXPath("//a[contains(text(),'Verify')]").getAttribute("href");
        if (attribute.contains("error.html")) {
        	System.err.println("It is Broken");
			
		}
        else 
        {
        	System.out.println("It is not Broken");
        }
        //No of Links in the Page
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The no of Links available in the page are: " +links.size());
		//Interacting with the Samelink
        driver.findElementByXPath("(//a[text()='Go to Home Page'])[2]").click();
        System.out.println("Interaction with the Same link has been done");
        System.out.println("**************************");
        System.out.println("=======Interacting with Radio Buttons===========");
		//Radio- Button Page
        driver.findElementByLinkText("Radio Button").click();
        driver.findElementByXPath("//label[@for='yes']").click();
        boolean flag = driver.findElementByXPath("//label[@for='Checked']").isEnabled();
        if(flag==true)
        {
        	System.out.println("Checked is the Default Radio Button");
        	
        }
        else
        {
        	System.out.println("Unchecked is the Default Radio Button");
        }
        driver.findElementByXPath("(//input[@value='1'])[3]").click();
        System.out.println("*************");
        System.out.println("=========Interacting with CheckBoxes==========");
        //Check Boxes
        driver.get("http://leafground.com/home.html");
        driver.findElementByXPath("//img[@alt='Checkbox']").click();
        //Select the languages that you know
        driver.findElementByXPath("(//input[@type='checkbox'])[1]").click();
        driver.findElementByXPath("(//input[@type='checkbox'])[4]").click();
        driver.findElementByXPath("(//input[@type='checkbox'])[5]").click();
        //Confirm selenium is Clicked
        boolean enabled = driver.findElementByXPath("(//div[@class='example'])[2]/div").isEnabled();
        if (enabled==true) {
        	System.out.println("Selenium is Checked");
		}
        else {
        	System.out.println("Selenium is not Checked");
        }
        //DeSelect only checked
        driver.findElementByXPath("(//div[@class='example'])[3]/div[2]/input").click();
        //Select all below checkboxes
        driver.findElementByXPath("(//div[@class='example'])[4]/div[1]/input").click();
        driver.findElementByXPath("(//div[@class='example'])[4]/div[2]/input").click();
        driver.findElementByXPath("(//div[@class='example'])[4]/div[3]/input").click();
        driver.findElementByXPath("(//div[@class='example'])[4]/div[4]/input").click();
        driver.findElementByXPath("(//div[@class='example'])[4]/div[5]/input").click();
        driver.quit();
       
	}

}
