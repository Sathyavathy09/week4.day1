package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int totalRow = rows.size();

		System.out.println("Total Number of Rows " + totalRow);

		List<WebElement> colums = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td"));
		int totalCol = colums.size();

		System.out.println("Total Number of Columns " + totalCol);

		String value = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
		System.out.println("Progress value of 'Learn to Interact with elements' " + value);

		List<String> progress = new ArrayList<String>();

		for (int i = 2; i <= totalRow; i++)

		{
			String progressValue = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]"))
					.getText();
			String newValue = progressValue.replaceAll("[%]", "");

			progress.add(newValue);
		}

		List<Integer> newList = new ArrayList<Integer>(progress.size());
		for (String myInt : progress) {
			newList.add(Integer.valueOf(myInt));
		}

		Collections.sort(newList);
		System.out.println(newList);

		// Check the vital task for the least completed progress

		int input = newList.get(0);
		driver.findElement(By.xpath("//td[contains(text(),'" + input + "')]/following::input")).click();
	}

}
