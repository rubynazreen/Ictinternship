package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Testbase {

	 public WebDriver driver;
	Properties prop;
;
	public void loadprop() throws IOException {
		FileInputStream propo=new FileInputStream("C:\\Projectworkspace\\Ictinternship\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(propo);
	}
	@BeforeTest
	public void SetConfig() throws IOException, InterruptedException {
		loadprop();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito"); // Add incognito mode
	    options.addArguments("--disable-save-password-bubble");
	    options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
	        put("credentials_enable_service", false);
	        put("profile.password_manager_enabled", false);
		}});

		String browser=prop.getProperty("browser").toLowerCase();

		if (browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver(options);
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
		else if(browser.equalsIgnoreCase("firefox")) {
	
	driver=new FirefoxDriver();
	driver.get(prop.getProperty("url"));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		}}}        
		   
		


		       
	    

