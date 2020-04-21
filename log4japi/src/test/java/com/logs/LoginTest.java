package com.logs;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest
{    
	WebDriver driver;
	Logger log=Logger.getLogger(LoginTest.class);
	@BeforeMethod
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
    driver=new ChromeDriver();
	log.info("launching chrome browser");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com");
	log.info("entering application url");
	log.warn("may this is warning");
	log.fatal("may this is just fatal error  message");
	log.debug("this is debug message");
	log.trace("this is trace");
	log.error("this is error");
	}
	//types of logs
	//1.info
	//2.warn
	//3.error
	//4.fatal
	//how to generate log4j by using apachi api log4j and log4j.properties file
	//where to create create inside resource folder
	//go to project right clic create source folder src/main/resources
	//in log4j.properties if we kept apped=true means preavious running also added false means
	//only current present
	@Test(priority = 1)
	public void FBTitleTest1()
	{  
		log.info("******************start test case************");
		String title=driver.getTitle();
		System.out.println("title of the page is"+title);
		log.info("login page title is---->"+title);
		Assert.assertEquals(title,"Facebook – log in or sign up");
		log.info("******************end test case************");
	}
	@Test(priority = 2)
	public void FBDisplayTest2()
	{
		log.info("******************start test case************");
		boolean b=driver.findElement(By.xpath("//button[@name=\"websubmit\"]")).isDisplayed();
		Assert.assertTrue(b);
		log.info("******************end test case************");
	}
	@AfterMethod
	public void tearDown()
	{
		log.info("******************browser close************");
		driver.quit();
	}

}
