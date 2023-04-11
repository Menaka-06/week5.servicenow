package week5day2.devproj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateKnowledge extends CommonClassDevPojects{
	@BeforeTest
    public  void setup() 
	{
		excelSheet = "NewKnowledge";
    }
	@Test(dataProvider="fetchExcel")
	public void runCreateKnowledge(String knowledge,String base,String category,String shortdesc) {
		domone.findElementByXPath("//input[@id='filter']").sendKeys(knowledge);
		domone.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
		WebElement framepage = domone.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(framepage);
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		driver.findElement(By.xpath("(//input[contains(@id,'sys_display.kb_knowledge.')])[1]")).sendKeys(base);
		driver.findElement(By.xpath("(//input[contains(@id,'knowledge.kb_category')])[4]")).sendKeys(category);
		driver.findElement(By.xpath("(//input[contains(@id,'kb_knowledge.short_description')])[2]")).sendKeys(shortdesc);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	
	}

}
