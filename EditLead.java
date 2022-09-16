package selenium_pgm;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws Exception {

		/* Week2_Day2:- Assignment No:2.1 */

		// Setup browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		// maximize the browser window
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Enter the User-name & Password
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
		// Click on Login button
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Click on CRM/SFA
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// Click on Leads
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Enter first name
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Kalpana");
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(7000);
		
		 // Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		//Verify title of the page
		if (driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Verified Title of the page successfully");
		} else {
			System.out.println("Title of the page is not matching");
		}

		//Click Edit & Change the company name 
		String text1="Amazon";
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement ele = driver.findElement(By.id("updateLeadForm_companyName"));
		ele.clear();
		ele.sendKeys(text1);
		// Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		 //Confirm the changed name appears
		// We are getting value (10788) appended to company name. need to check ( Doubt)
		String text = driver.findElement(By.xpath("//span[contains(text(),'Amazon')]")).getText();
		if (text.contains(text1)) {
			System.out.println("This is to confirm that Company name has been updated Successfully");
		} else {
			System.out.println("The Company name is not updated as per the inputed value");
		}
		driver.close();
	}
}
