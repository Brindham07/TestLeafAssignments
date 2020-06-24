package week3.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.findElementById("chkSelectDateOnly").click();
		WebElement fromStation = driver.findElementById("txtStationFrom");
		fromStation.clear();
		fromStation.sendKeys("MAS", Keys.ENTER);
		WebElement toStation = driver.findElementById("txtStationTo");
		toStation.clear();
		toStation.sendKeys("SBC", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]").getText();
		List<WebElement> trainNames = driver
				.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]");
		int trainNo = trainNames.size();
		System.out.println("Total No of Trains available are: " + trainNo);
		Set<String> setOfTrainNames = new HashSet<String>();
		for (int j = 0; j <= trainNo - 1; j++) {

			WebElement name = trainNames.get(j);
			String tN = name.getText();
			setOfTrainNames.add(tN);
			System.out.println(tN);
		}
		System.out.println("******Compare the Size of list and Set to verify the names are unique********");
		int SetSize = setOfTrainNames.size();
		if (trainNo == SetSize) {
			System.out.println("The Names are Unique");
		} else {
			System.out.println("There are Duplicate vales Present");
		}
	}
}
