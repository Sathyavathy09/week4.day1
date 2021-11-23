package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get("https://www.snapdeal.com/");
		

		WebElement menFashion = driver.findElement(By.cssSelector("div#leftNavMenuRevamp>div>div:nth-of-type(2)>ul>li:nth-of-type(7)>a>span"));
		
		
		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div#category6Data>div:nth-of-type(2)>div>div>p:nth-of-type(3)>a>span")).click();
		
		Thread.sleep(5000);
		WebElement firstElement =driver.findElement(By.xpath("//picture[@class='picture-elem']//img"));
		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(firstElement).perform();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();

	}

}
