package com.stefsdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyStefsDefs {
	WebDriver driver;
	@Given("user should on login page")
	public void user_should_on_login_page() {

		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ishine.apmosys.com/#/login");
	    
	}
	@When("user enter uname and passord")
	public void user_enter_uname_and_passord() {
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nidhi.chaure@apmosys.com");
	    driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("Apmosys@123");
	    
	}
	@And("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
	}
	@Then("user will on home page")
	public void user_will_on_home_page() {
	String dash=	driver.findElement(By.xpath("//*[text()='Confirm']")).getText();
	System.out.println(dash);
	   
	}



}
