package locators.cssselectors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCssSelectors {

	public static void main(String[] args) {
		String textVerify="You are successfully logged in.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // Open a new chrome browser
		driver.manage().window().maximize(); // Maximize the opened chrome browser window
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // Loads the URL in the opened browser
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	//	WebDriverWait wait = new WebDriverWait(driver,30);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(((By.xpath("//h1[text()[contains(.,'Academy')]]/following::p[text()='"+textVerify+"']")))));
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Karthi"); //id values are followed by #
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("rahulshettyacademy");//attribute values can be given as tagname[attibute='value']
		driver.findElement(By.cssSelector("div.forgot-pwd-conainer,button.submit.signInBtn")).click(); // tagname is followed by the comma and represents the following functionality in CSS Selectors
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(((By.cssSelector("div.login-container>p")))));
	//	List<WebElement> list = driver.findElements(By.xpath("//h1[text()[contains(.,'Academy')]]/following::p[text()='"+textVerify+"']"));
		
		String getTextValue = driver.findElement(By.cssSelector("div.login-container>p")).getText(); //value followed by > represents the child tag name
		System.out.println(getTextValue);
		if(textVerify.equals(getTextValue))
		{
			System.out.println("Text is verified and equal");
		}
		else
		{
			System.out.println("Text is not equal");
		}
		
		driver.findElement(By.cssSelector("button.logout-btn")).click();

		driver.close();
		driver.quit();
	}
		
}



//https://www.w3schools.com/cssref/css_selectors.asp