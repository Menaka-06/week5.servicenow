package week5day2.devproj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderingMobile extends CommonClassDevPojects {
	@BeforeTest
    public  void setup() 
	{
		excelSheet="Ordermob";
    }
@Test(dataProvider ="fetchExcel")
	public void runOrdering(String category,String phone) 
	{
	domone.findElementByXPath("//input[@id='filter']").sendKeys(category);
	domone.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
	domone.findElementByXPath("//span[text()='Service Catalog']").click();	
	WebElement framepage = domone.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(framepage);
	driver.findElement(By.xpath("((//div[contains(@id,'body_com.glideapp')])[8]//a)[2]")).click();
	driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
	driver.findElement(By.xpath("(//label[@class='radio-label'])[1]")).click();
	driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys(phone);
	driver.findElement(By.xpath("//option[text()='Unlimited [add $4.00]']")).click();
	driver.findElement(By.xpath("(//span[@class='input-group-radio'])[4]/label")).click();
	driver.findElement(By.xpath("(//span[@class='input-group-radio'])[9]/label")).click();
	driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
	String reqnum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
	System.out.println("the request number is "+reqnum);
	
	String textverify = driver.findElement(By.xpath("//span[contains(text(),'Thank you,')]")).getText();
	if(textverify.contains("Thank you,"))
	{
		System.out.println("the order got placed and the request number is "+reqnum);
	}
	else
	{
		System.out.println("the order not placed");
	}
	}


}
