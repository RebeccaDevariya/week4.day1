package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectValue {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Maximize web page
		driver.manage().window().maximize();

		// input userid
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		// input pwd
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// login
		driver.findElement(By.className("decorativeSubmit")).click();

		// click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		
		 WebElement industryDropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		 
		   Select select1 = new Select(industryDropdown);
		   List<WebElement> options = select1.getOptions();
		   
		   select1.selectByIndex(options.size()-1);
		   for (WebElement eachOption : options) 
		   {
		           
		   System.out.println(eachOption.getText());

		       } 
		 WebElement ownershipDropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		 
		   Select select2 = new Select(ownershipDropdown);
		   List<WebElement> options1 = select2.getOptions();
		   
		   select1.selectByIndex(options1.size()-1);
		      
		    
		 
	}
}
