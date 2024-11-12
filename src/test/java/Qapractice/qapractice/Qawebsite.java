package Qapractice.qapractice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class Qawebsite {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	void test() {
		driver=new ChromeDriver();
		driver.get("https://qa-practice.netlify.app/auth_ecommerce");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@admin.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@id='submitLoginBtn']")).click();
		driver.findElement(By.xpath("//div[@class='shop-item' and .//span[text()='Huawei Mate 20 Lite, 64GB, Black']]//button")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='street']")).sendKeys("magic street");
		driver.findElement(By.xpath("//input[@placeholder='London']")).sendKeys("california");
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele= driver.findElement(By.id("countries_dropdown_menu"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		//WebElement ele= driver.findElement(By.id("countries_dropdown_menu"));
		Select sel=new Select(ele);
		sel.selectByVisibleText("India");
		driver.findElement(By.id("submitOrderBtn")).click();
		WebElement text= driver.findElement(By.id("message"));
		System.out.println(text.getText());
		driver.close();
		
	}

}
