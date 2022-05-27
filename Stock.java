package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stock {
	public static void main(String[] args) {
		// Setuping Browser property
		WebDriverManager.chromedriver().setup();

		// Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.chittorgarh.com/");

		// Maximize web page
		driver.manage().window().maximize();
		

		// click stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();

		// click NSE Bulk Deals
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		
		
				WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));

				List<WebElement> rows = table.findElements(By.tagName("tr"));
				
				Set<String> set = new HashSet<String>();
				
				List<String> list = new ArrayList<String>();

				// Iterating through each row
				for (int i = 1; i < rows.size(); i++) {

					List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

					System.out.println(cols.get(2).getText());

					
					set.add(cols.get(2).getText());

					
					list.add(cols.get(2).getText());

				}
				if (set.size() == list.size()) {

					System.out.println("Duplicate values not available in SecurityNames column");
				}

				// if both size are not same then print below statement

				else {

					System.out.println("Duplicate values available in SecurityNames column");
				}
	}
}
