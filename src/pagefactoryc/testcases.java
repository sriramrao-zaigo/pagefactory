package pagefactoryc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



public class testcases

{
	
	 
   
	
 public  WebDriver driver;
  
	  
        @BeforeMethod
	    public void setup(){

        	System.out.println(System.getProperty("os.name"));
    		
    		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

    		ChromeOptions options = new ChromeOptions();
    	  options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
    	    
    	   // System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\Testjenkins-master\\chromedriver\\chromedriver.exe");

    		driver = new ChromeDriver(options);
    		
    	    PageFactory.initElements(driver, testobj.class);

    		driver.get("http://demo.zaigoshop.com/login");

    		driver.manage().window().maximize();
    		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }

	    @Test(priority=1)

	    public void test_one()
	    
	    //check with invalid user id and invalid password
	    {
	     testobj.userName.sendKeys("name@nn.in");
           
	     testobj.password.sendKeys("pass");
	    
	     testobj.login.click();
	     
	  String email_err=   testobj.email_err.getText();
	     
	     if(email_err.equals("These credentials do not match our records."))
	     {
	    	 System.out.println("pass");
	     }
	     else
	     {
	    	 System.out.println("fail");
	     }
	    
	 	    }
	    
}
