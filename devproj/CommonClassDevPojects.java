package week5day2.devproj;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class CommonClassDevPojects {
	public  RemoteWebDriver driver;
	//public ChromeOptions option;
	public String excelSheet;
	public Shadow domone;
	@Parameters({"browser","url","uname","pwd"})
	@BeforeMethod

	public void runDevProjects(String browser,String url,String uname,String pwd) 
		{
			switch(browser) {
			case "chrome":
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				option.addArguments("--disable-notifications");
				driver = new ChromeDriver(option);
				break;
			}
			case "Edge":
			{
				driver=new EdgeDriver();
				break;
			}
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(uname);
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
			Shadow domone=new Shadow(driver);
			domone.setImplicitWait(30);
			domone.findElementByXPath("//div[contains(@class,'sn-polaris-navigation polaris')]").click();
			
	}
	@AfterMethod
	public void postCondition() 
	{
		driver.close();
	}
	@DataProvider(name="fetchExcel")
	public String[][] fetchExcel() throws IOException
	{
		String[][] inputData =ExcelSheetInput.inputData(excelSheet);
		return inputData;
	}
	}

