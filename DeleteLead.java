package selenium_pgm;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws Exception {

		/* Week2_Day2:- Assignment No:2.2 */

		// Setup browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Enter the User-name & Password, Click Login
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Click on CRM/SFA
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// Click on Leads & then Find leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Click on Phone
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		WebElement phoneN = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
		phoneN.clear();
		// Enter Country code & phone number
		phoneN.sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7418529631");
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//Capture lead ID of First Resulting lead
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String capturedLeadID = ele.getText();
		//Click First Resulting lead
		ele.click();
		
		//Click Delete & Then click on Find Leads
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Enter captured lead ID  & Click find leads button
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(capturedLeadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(10000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("No records to display");
		} else {
			System.out.println("Record is not deleted successfully");
		}
	}

}
