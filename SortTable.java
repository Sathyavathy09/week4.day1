package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		List<String> nameList = new ArrayList<String>();
		List<String> sortNameList = new ArrayList<String>();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr"));
		int totalRow = rows.size();

		for (int i = 1; i <= totalRow; i++)

		{
			String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[" + i + "]/td[2]")).getText();
			nameList.add(text);
		}
		Collections.sort(nameList);
		
		driver.findElement(By.xpath("//th[@aria-label=\"Name: activate to sort column ascending\"]")).click();
		
	
		for (int i = 1; i <= totalRow; i++)

		{
			String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[" + i + "]/td[2]")).getText();
			sortNameList.add(text);
		}
		
		
		if (nameList.equals(sortNameList))
		{
			System.out.println("Validation Complete");
		}
	
	}

}
