package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {
	   
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {
		
		driver.get(url);
		
		driver.manage().window().maximize();
	   
	}


	@When("user enters text {string} using xpath {string}")
	public void user_enters_text_using_xpath(String text, String xpath) {
	    
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {
	    
		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user verify the title to be {string}")
	public void user_verify_the_title_to_be(String expTitle) {
	   
		Assert.assertEquals(expTitle, driver.getTitle());
		
		
	}




}
