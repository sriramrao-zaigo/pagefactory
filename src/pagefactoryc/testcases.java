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
        	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        	
        	//driver = new ChromeDriver();
    		
    	    PageFactory.initElements(driver, testobj.class);

    		driver.get("http://demo.zaigoshop.com/login");

    		driver.manage().window().maximize();
    		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }

	    @Test(priority=1)

	    public void invalid_userid_password()
	    
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
	    
	    @Test(priority=2)

	    public void invaliduserid_validpassword()
	    {
	    	//check with invalid user id and valid password
	    	
	    	 testobj.userName.sendKeys("na@nh.in");
	           
		     testobj.password.sendKeys("LAra_1104");
		    
		     testobj.login.click();
		     
		  String err_msg=   testobj.email_err.getText();
		     
		     if(err_msg.equals("These credentials do not match our records."))
		     {
		    	 System.out.println("pass");
		     }
		     else
		     {
		    	 System.out.println("fail");
		     }
	    	
	   
	    
	 	    }
	    
	    @Test(priority=3)

	    public void test_three()
	    {
	    	//check with valid user id and invalid password
	    	
	   
	    	 testobj.userName.sendKeys("nishanth.k@zaigoinfotech.com");
	           
		     testobj.password.sendKeys("asdf");
		    
		     testobj.login.click();
		     
		  String err_msg=   testobj.email_err.getText();
		     
		     if(err_msg.equals("These credentials do not match our records."))
		     {
		    	 System.out.println("pass");
		     }
		     else
		     {
		    	 System.out.println("fail");
		     }
	    		    	
	   
	    
	 	    }
	    
	    @Test(priority=4)

	    public void nulluserid_nullpassword()
	    {
	    	//check with null user id and null password
	    
	    	
	    	 testobj.userName.sendKeys("");
	    	 
		     testobj.password.sendKeys("");
		    
		     testobj.login.click();
		     
		  String err_msg=   testobj.userName.getAttribute("validationMessage");
		     
		     if(err_msg.equals("Please fill out this field."))
		     {
		    	 System.out.println("pass");
		     }
		     else
		     {
		    	 System.out.println("fail");
		     }
	    		    
	    
	    	
	   
	    
	 	    }
	    
	    
	    @Test(priority=5)

	    public void nulluserid_validpassword()
	    {
	    	//check with null user id and valid password
	    	
	    	 testobj.userName.sendKeys("");
	           
		     testobj.password.sendKeys("LAra_1104");
		    
		     testobj.login.click();
		     
		     String err_msg=   testobj.userName.getAttribute("validationMessage");
		     
		     if(err_msg.equals("lease fill out this field."))
		     {
		    	 System.out.println("pass");
		     }
		     else
		     {
		    	 System.out.println("fail");
		     }
	    		    
	   
	    
	 	    }
	    
	    
	    @Test(priority=6)

	    public void validuserid_nullpassword()
	    {
	    	//check with valid user id and null password
	    	
	    	testobj.userName.sendKeys("nishanth.k@zaigoinfotech.com");
	           
		     testobj.password.sendKeys("");
		    
		     testobj.login.click();
		     
		  String err_msg=   testobj.password.getAttribute("validationMessage");
		     
		     if(err_msg.equals("lease fill out this field."))
		     {
		    	 System.out.println("pass");
		     }
		     else
		     {
		    	 System.out.println("fail");
		     }
	    		    
	    	
	   
	    
	 	    }
	    
	    @Test(priority=7)

	    public void invalidemailformat()
	    {
	    	//check with invalid email format and valid password
	    	
	    	testobj.userName.sendKeys("zaigoinfotechcom");
	           
		     testobj.password.sendKeys("LAra_1104");
		    
		    testobj.login.click();
		     
		  String err_msg=   testobj.userName.getAttribute("validationMessage");
		  
		 // System.out.println(err_msg);
		     
		     if(err_msg.equals("Please include an '@' in the email address. 'zaigoinfotechcom' is missing an '@'."))
		     {
		    	 System.out.println("pass");
		     }
		     else
		     {
		    	 System.out.println("fail");
		     }
	    		 
	    	
	   
	    
	 	    }
	    
	    @Test(priority=7)

	    public void useridpresent()
	    {
	    	//check with user id field is present
	    	
	    	
	    	String uid_pre=testobj.userName.getTagName();
	    	
	    	
	    	if(uid_pre.equals("input"))
	    	 
	    	 {
	    		 
	    		 System.out.println("pass");
	    		 
	    		}
	    		else{
	    			
	    			 System.out.println("fail");
	    		 
	    		}
	 
	  
	    
	 	    }
	    
	    
	    @Test(priority=8)
         
	    
	    public void passwordfield_present()
	    {
	    	//check with password id field is present
	    	
	    	String pswd_pre=testobj.password.getTagName();
	    	
	    	
	          if(pswd_pre.equals("input")){
	    		 
	    		 System.out.println("pass");
	    		 
	    		}
	    		else{
	    			
	    			 System.out.println("fail");
	    		 
	    		}

	   
	    
	 	    }
	    
	    @Test(priority=9)

	    public void submitbtn_present()
	    {
	    	//check with submit button is present
	    	
	    	String l_btn=testobj.login.getTagName();
	    	
	    	
	    	
	    	 
	    	 if(l_btn.equals("button")){
	    		 
	    		 System.out.println("pass");
	    		 
	    		}
	    		else{
	    			
	    			 System.out.println("fail");
	    		 
	    		}

	   
	    
	 	    }
	   
	    
	 	    
	    
	    @Test(priority=10)

	    public void emailplaceholder()
	    {
	    	//check with user id fiedl placeholder
	    	
	     String uid_placeholder=testobj.userName.getAttribute("placeholder");
	     String ep="Email...";
	     
	     if(ep.equals(uid_placeholder))
	     {
   		  System.out.println("pass");
   	  }
   	  else
   	  {
   		  
   		  System.out.println("fail");
   		  
   	  }
	    	
	   
	    
	 	    }
	    
	    @Test(priority=11)

	    public void passwordplaceholder()
	    {
	    	//check with password field placeholder
	    	
	    	String pswd_placeholder=testobj
	    			
	    			.password.getAttribute("placeholder");
		     String pp="Password..";
		     
		     if(pp.equals(pswd_placeholder))
		     {
	   		  System.out.println("pass");
	   	  }
	   	  else
	   	  {
	   		  
	   		  System.out.println("fail");
	   		  
	   	  }
		    	
		   
	    	
	   
	   }
	    
	   
	    
	    
	    @Test(priority=12)

	    public void loginbtn_text()
	    {
	    	//login buttontext
	    	
	 String btn_value=   testobj.login.getText();
	 
	
	 
	 if(btn_value.equals("LOGIN"))
	 {
		 System.out.println("pass");
	 }
	 else
	 {
		 System.out.println("fail");
		
	 }
	   
	   }
	    
	    @AfterMethod
	    public void tearDown()
	    {
	        driver.close();
	    }
	    
	    
	}
	    
	    
	    
 

