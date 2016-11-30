package com.learn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GitHubLogin 
{
	
	public static void main(String[] args) {
		new GitHubLogin().login("skramath", "loving1234");
	}
	
	/*void waitForLoad(WebDriver driver) {
	    new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}*/
	
	public void waitForPageToBeReady() 
	{
	    JavascriptExecutor js = (JavascriptExecutor)driver;

	    //This loop will rotate for 100 times to check If page Is ready after every 1 second.
	    //You can replace your if you wants to Increase or decrease wait time.
	    for (int i=0; i<400; i++)
	    { 
	        try 
	        {
	            Thread.sleep(1000);
	        }catch (InterruptedException e) {} 
	        //To check page ready state.

	        if (js.executeScript("return document.readyState").toString().equals("complete"))
	        { 
	            break; 
	        }   
	      }
	 }
	
	WebDriver driver = null;
    public boolean login(String userName,String password)  
    {
    	System.out.println(System.getProperty("webdriver.gecko.driver"));
    	
       //System.setProperty("webdriver.gecko.driver","C:\\Temp\\geckodriver\\geckodriver.exe");	
       //System.setProperty("webdriver.gecko.driver","");
	   try{
	  		 driver = new FirefoxDriver();
	        driver.get( "https://github.com/login" ); // keep it in properties file if required
	        WebElement formEmail = driver.findElement(By.name("login")); 
	        formEmail.sendKeys(userName);
	        WebElement formPassword = driver.findElement(By.name("password"));
	        formPassword.sendKeys(password);
	        
	        formPassword.submit();
	        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	       // waitForLoad(driver);
	       	  waitForPageToBeReady();      
	        //System.out.println(driver.getTitle());
	        System.out.println("Current URL :"+driver.getCurrentUrl());
	        System.out.println("Current URL :"+driver.getCurrentUrl().contains("login"));
	        if ( driver.getCurrentUrl().contains("login") ||  driver.getCurrentUrl().contains("session"))
	        {
	        	System.out.println("Login Failed, UserName or PAssword is not Valid");
	            return false;
	        }else{
	        	System.out.println("Login Success, UserName or PAssword is  Valid");
	        	return true; 	
	        }
  		}catch(Exception exe){  			
  			System.out.println(" Exception :"+exe.getLocalizedMessage());  			
  		}
        return true;
    }
}
