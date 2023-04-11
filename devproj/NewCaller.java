package week5day2.devproj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewCaller extends CommonClassDevPojects {
	@BeforeTest
    public  void setup() 
	{
		excelSheet = "NewCaller";
    }
	@Test(dataProvider="fetchExcel")
	public  void runNewCaller(String callcategry,String fname,String lname,String title,String email,String bphone,String mobile)
{
		domone.findElementByXPath("//input[@id='filter']").sendKeys(callcategry);
		domone.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
		WebElement framepage = domone.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(framepage);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title);
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(bphone);
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys(mobile);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
	}

}
