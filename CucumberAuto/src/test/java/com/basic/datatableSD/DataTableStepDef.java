package com.basic.datatableSD;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTableStepDef {

WebDriver driver =null; 


 @Given("^User need to be on facebook login page$")
 public void User_need_to_be_on_facebook_login_page() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\CUCUMBER_SETUP\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//deze onthouden
		driver.findElement(By.xpath("//button[contains(text(),'Alle cookies toestaan')]")).click();
		Thread.sleep(3000);
		//deze onthouden
		driver.findElement(By.xpath("//a[contains(@class,'_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy')]")).click();	
		
		Thread.sleep(3000);
				
}


//de regex uit het hoofd leren
@When("^User enters user \"([^\"]*)\" firstname$")
public void User_enters_user_firstname(String username) throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(username);
	Thread.sleep(1000);
	System.out.println("user firstname is entered  |");

	Thread.sleep(3000);
}

@Then("^User checks user \"([^\"]*)\" firstname is present$")
public void user_checks_user_firstname_is_present(String userName) throws InterruptedException {
  String userNameActual =  driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value");
  Assert.assertEquals(userName, userNameActual);
	Thread.sleep(1000);
	System.out.println("user firstname is checked  |");

	Thread.sleep(3000);
}
  @And ("^User enters user \"([^\"]*)\" surname$")
  public void User_enters_user_surname(String surname) throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surname);
	  Thread.sleep(1000);
	  System.out.println("user firstname is entered  |");
	   
	  Thread.sleep(3000);
  }
  
  @Then ("^User Mobile Field should be blank")
  public void But_User_Mobile_Field_should_be_blank() throws InterruptedException {
	  String mobileActual =  driver.findElement(By.xpath("//input[@name='reg_email__']")).getAttribute("value");
	  Assert.assertEquals("", mobileActual);
	  Thread.sleep(1000);
	System.out.println("user mobile field was blank|");
	
  }
  
@Then ("^close browser") 
public void close_browser(){
	driver.quit();
	driver = null;

}	

@When ("^Enter following data")
public void When_Enter_following_data(DataTable table) {
	
	List<List<String>> data = table.raw();
	
	data.get(0).get(0);
	data.get(0).get(1);
	data.get(0).get(2);

	data.get(1).get(0);
	data.get(1).get(1);
	data.get(1).get(2);
	
}
}
  

