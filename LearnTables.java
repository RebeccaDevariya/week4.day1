package week4.day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTables {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://erail.in/");

		// Maximize web page
		driver.manage().window().maximize();
	
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MDU");
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("TPJ");
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement elementTable =driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		 
	    List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
	            
	      // Iterate the rows to get the data
	          
		  for (int i = 0; i < rows.size(); i++) {
		             
		   List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		   System.out.println(cols.get(0).getText());
			System.out.println(cols.get(1).getText());
	
	      }
	
		}		
		 
	}
	