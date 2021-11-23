package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement men = driver.findElement(By.xpath("//a[@href='/shop/men']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();

		String number = text.replaceAll("[^0-9]", "");
		System.out.println(number);

		int count = Integer.valueOf(number);

		List<String> jacket = new ArrayList<String>();

		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='categories-num']"));

		for (WebElement eachElement : elements) {
			String txt = eachElement.getText();
			txt = txt.replaceAll("[^0-9]", "");
			jacket.add(txt);
		}

		System.out.println(jacket);

		int total = 0;
		for (int i = 0; i <= jacket.size() - 1; i++) {
			total = total + Integer.valueOf(jacket.get(i));
		}
		System.out.println(total);

		if (count == total) {
			System.out.println("Sum of categories count matches with the Total");
		} else
			System.out.println("Not Matching");

		driver.findElement(By.xpath("//span[@class='categories-num']/following-sibling::div")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div")).click();
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span")).click();

		Thread.sleep(5000);

		List<WebElement> productInfo = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
		Set<String> brandName = new HashSet<String>();
		for (WebElement webElement : productInfo) {
			brandName.add(webElement.getText());

		}
		System.out.println(brandName);

		if (brandName.size() == 1) {
			System.out.println("All Coats are of brand" + brandName);
		}

		WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions act = new Actions(driver);
		act.moveToElement(sortBy).perform();

		WebElement discount = driver.findElement(By.xpath("(//label[@class='sort-label '])[3]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(discount).doubleClick().perform();

		Thread.sleep(5000);

		String price = driver.findElement(By.xpath("//div[@class='product-price']//span/span")).getText();
		System.out.println("The price of the first jacket " + price);

		driver.findElement(By.xpath("//div[@class='product-imageSliderContainer']//img")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>();
		handlesList.addAll(handles);
		driver.switchTo().window(handlesList.get(1));
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
	}

}
