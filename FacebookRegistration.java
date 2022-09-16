package selenium_pgm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookRegistration {

	public static void main(String[] args) {

		/* Week2_Day2:- Assignment No: 1 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Click on Create New Account
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		// Enter the FirstName,LastName,Phone No/E-mail & Password
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rani");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shree");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9638527410");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Qwerty@1234");

		// Handle all the DropDown
		WebElement ele = driver.findElement(By.xpath("//select[@id='day']"));
		Select s = new Select(ele);
		s.selectByValue("11");
		WebElement ele1 = driver.findElement(By.xpath("//select[@id='month']"));
		Select s1 = new Select(ele1);
		s1.selectByVisibleText("Aug");
		WebElement ele2 = driver.findElement(By.xpath("//select[@id='year']"));
		Select s2 = new Select(ele2);
		s2.selectByVisibleText("2000");

		// Select the radio button "Female"
		driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).click();
	}
}
