package week4.day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERail {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		Thread.sleep(5000);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		List<WebElement>rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int totalRow = rows.size();
		
		System.out.println(totalRow);
		Set<String> outputSet = new HashSet<String>();
		
		for (int i = 1; i<=totalRow; i++)
		{
		
		String output = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
		outputSet.add(output);	

	}
		int count = outputSet.size();
		
		if(totalRow==count)
		{
			System.out.println("No Duplicates");

		}
		System.out.println("Duplicates");
}
}
