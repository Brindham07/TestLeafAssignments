package week5.testNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.tesng.base.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod {
	@BeforeTest
	public void setData()
	{
		excelFileName="CreateLead";
	}
	@Test(dataProvider="ArrayData")
	//@Test(dataProvider="sendData")  Different method to pass the dataProvider
	public  void runCreateLead_TC001(String cName,String fName,String lName) {
		System.out.println("@Test Method Started");
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
		driver.findElementByName("submitButton").click();
		System.out.println("@Test Method Ended");
}
}






