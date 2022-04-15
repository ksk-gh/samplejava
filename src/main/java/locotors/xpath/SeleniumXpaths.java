package locotors.xpath;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumXpaths {
	public static void main(String[] args) {
		String textVerify="You are successfully logged in.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // Open a new chrome browser
		driver.manage().window().maximize(); // Maximize the opened chrome browser window
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // Loads the URL in the opened browser
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		

		driver.findElement(By.xpath("//h1[text()='Sign in']/following-sibling::input[1]")).sendKeys("karthi");
		driver.findElement(By.xpath("//div[@class='checkbox-container']/preceding-sibling::input[1]")).sendKeys("rahulshettyacademy");	
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120,1));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(((By.xpath("//h1[text()[contains(.,'Academy')]]/following::p[text()='"+textVerify+"']")))));
		List<WebElement> list = driver.findElements(By.xpath("//h1[text()[contains(.,'Academy')]]/following::p[text()='"+textVerify+"']"));
		
		if(list.size()>0)
		{
			System.out.println("Text is "+textVerify+"is present");
		}
		else {
			System.out.println(textVerify+" text is not present");
		}
		
		driver.findElement(By.xpath("//button[contains(@class,'logout')]")).click();
		driver.close();


}
}

