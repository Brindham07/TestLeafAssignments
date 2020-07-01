package week4.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesLeafGround {

	public static void main(String[] args) throws InterruptedException {
		// Load the Url
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// WebElement eleFrame = driver.findElementByLinkText("default.html");
		// Switch to 1st Frame and Click the Button
		driver.switchTo().frame(0);
		driver.findElementByXPath("//button[@id='Click']").click();
		driver.switchTo().defaultContent();
		// Switch to the Nested Frame and Click the Button
		driver.switchTo().frame(1);
		WebElement eleFrame = driver.findElementById("frame2");
		driver.switchTo().frame(eleFrame);
		driver.findElementByXPath("//button[@id='Click1']").click();
		driver.switchTo().defaultContent();
		// Get the no of Outer Frames in the Page
		List<WebElement> Frames = driver.findElementsByTagName("iframe");
		int OuterFrameSize = Frames.size();
		System.out.println("The No of Outer Frames Present in the Page are:" + OuterFrameSize);
		int size = Frames.size();
		// Get the Inner Frames in the Page
		for (int i = 0; i <= OuterFrameSize - 1; i++) {
			driver.switchTo().frame(i);
			List<WebElement> NestedFrames = driver.findElementsByTagName("iframe");
			int size1 = NestedFrames.size();
			if (size1 != 0) {
				size = size1 + size;
			}
			driver.switchTo().defaultContent();
		}
		// Print the Total No of Frames in the Page
		System.out.println("The Total No of Frames Present in the Page are:" + size);
		driver.quit();
	}
}
