package PAGES;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BASE.base;

public class ProductPage extends base {

public void searchPage() {
	driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Drone");
	driver.findElement(By.xpath("//input[@class='Pke_EE']")).submit();
	String ProductName= driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]")).getText();
	System.out.println(ProductName);
	
}
public void buyPage() throws InterruptedException {
	driver.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]")).click();
	List<String> tabs = new ArrayList<String>(driver.getWindowHandles()) ;
	driver.switchTo().window(tabs.get(1));
	String productName1= driver.findElement(By.className("VU-ZEz")).getText();
	System.out.println(productName1);
	if (productName1.equals(productName1))
	{
		System.out.println("good");
		WebElement buy = driver.findElement(By.xpath("(//button[contains(@class,'QqFHMw vslbG+')])[2]"));
		String BUY= buy.getText();
		System.out.println("Good1");
		Assert.assertEquals("BUY NOW", BUY, "TEXT FOUND CORRECTLY");
		System.out.println("Good2");
		// Scroll until the element is in view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", buy);
        Thread.sleep(1000);
		buy.click();
		System.out.println("Good3");
		
		
	
	}
	else {
		System.out.println("bad");
	}}
}
