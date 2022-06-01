package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;
	@Given("^user navigates to orangehrm url$")
	public void user_navigates_to_orangehrm_url() throws Throwable {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("http://orangehrm.qedgetech.com");
	   Thread.sleep(3000);
	}

	@When("^user login in username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_login_in_username_as_and_password_as(String user, String pass) throws Throwable {
	driver.findElement(By.name("txtUsername")).sendKeys(user);
	driver.findElement(By.name("txtPassword")).sendKeys(pass);
		}

	@When("^user click login button$")
	public void user_click_login_button() throws Throwable {
driver.findElement(By.name("Submit")).click();
Thread.sleep(3000);
	}

	@When("^user click Admin$")
	public void user_click_Admin() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		Thread.sleep(3000);
	}

	@When("^user click Add button$")
	public void user_click_Add_button() throws Throwable {
		driver.findElement(By.name("btnAdd")).click();
		Thread.sleep(3000);
	}

	@When("^user enter employeename as  \"([^\"]*)\" and username as \"([^\"]*)\" and password as \"([^\"]*)\" and confirm possword as \"([^\"]*)\"$")
	public void user_enter_employeename_as_and_username_as_and_password_as_and_confirm_possword_as(String empname, String username, String password, String cpassword) throws Throwable {
	 driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys(empname);
	 driver.findElement(By.name("systemUser[userName]")).sendKeys(username);
	 driver.findElement(By.name("systemUser[password]")).sendKeys(password);
	 driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys(cpassword);
	}

	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
		 driver.findElement(By.name("btnSave")).click();
	}

	@Then("^user validate url$")
	public void user_validate_url() throws Throwable {
	  String expected = "viewSystemUsers";
	  String actual = driver.getCurrentUrl();
	  if(actual.contains(expected))
	  {
		  System.out.println("add user success::"+expected+"      "+actual);
	  }
	  else
	  {
		  System.out.println("add user fail");
	  }
	}

	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	   driver.close();
	}
}
