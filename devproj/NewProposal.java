package week5day2.devproj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewProposal extends CommonClassDevPojects{
	@BeforeTest
    public  void setup() 
	{
		excelSheet="Proposal";
    }
@Test(dataProvider ="fetchExcel")
	public  void runNewProposal(String categry,String tempdesc) {
		domone.findElementByXPath("//input[@id='filter']").sendKeys(categry);
		domone.findElementByXPath("//input[@id='filter']").sendKeys(Keys.ENTER);
		WebElement framepage = domone.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(framepage);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys(tempdesc);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		String text1 = driver.findElement(By.xpath("//td[@class='vt list_edit_cursor_cell']")).getText();
		System.out.println("the new proposal created "+text1);
		
		if(text1.contains("system admin"))
		{
			System.out.println("hi!!! the new proposal is created");
		}
	}

}
