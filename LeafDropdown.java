package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement selenium = driver.findElement(By.xpath("//div[@class='example'][6]//option[text()='Selenium']"));
		WebElement load = driver.findElement(By.xpath("//div[@class='example'][6]//option[text()='Loadrunner']"));
		
		Actions builder= new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(selenium).click(load).keyUp(Keys.CONTROL).perform();
		
				

	}

}
