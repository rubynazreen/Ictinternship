package testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Loginpage;

import pages.Registrationpage;
import pages.Studdash;
import utilities.Utilitiesexcel;

public class Testcase  extends Testbase{
	String Expected_log="Login";
	String Expected_name="The Student Dashboard";
	String Expected_reg="Student Signup";
	String Expected_proj="PROJECT DASHBOARD";
	
	 public Loginpage logobj;
	 public Registrationpage regobj;
	 public Studdash readMoreButton;
	
	@BeforeClass
	public void objinit()
	
	{
		logobj=new Loginpage(driver);
		regobj=new Registrationpage(driver);
		readMoreButton=new  Studdash(driver);
		}
	 
		
@Test(priority=0)
public void PostTest() throws IOException, InterruptedException
{ int sheetIndex = 0;
String filepath = "C:\\Projectworkspace\\Ictinternship\\src\\test\\resources\\TestExcel.xlsx"; 
	int totalUsers=Utilitiesexcel.getRowCount(filepath, sheetIndex);
 
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		        System.out.println("Alert text: " + alert.getText());
		        alert.accept();
		        System.out.println("Alert accepted before starting login for user " + 0);
		    } catch (TimeoutException e) {
		        System.out.println("No alert present before starting login for user " + 0);
		    
		
		logobj.login();
		
		String email = Utilitiesexcel.Excelread(filepath, sheetIndex, 0, 0);
	 String password = Utilitiesexcel.Excelread(filepath, sheetIndex,0,1);
	 String projectName = Utilitiesexcel.Excelread(filepath, sheetIndex, 0, 2);
	 System.out.println("Testing login with: "+ email +"/" +password);
	 
	logobj.SetEmail(email);
	
	logobj.SetPassword(password);
	
	logobj.btnClick();
	logobj.login();
	
String act_result=logobj.getproduct();
Assert.assertEquals(act_result,Expected_name);
System.out.println("Test Passed for User "+ email);
int projectcount=3;
Random random = new Random();
int projectIndex = random.nextInt(projectcount)+1; 

studdashtest(projectIndex,email);
	
}}	
@Test(priority=1)
public void registertest() throws InterruptedException {
	
	logobj.login();
	regobj.Register();
	String act_result=regobj.getproductreg();
	Assert.assertEquals(act_result, Expected_reg);
	regobj.Name("Naina");
	regobj.Email("Naina12@gmail.com");
	regobj.Password("123457");
	regobj.Phoneneumber("9446117323");
	regobj.Batchname("Nov 2024");
	regobj.Checkbox();
	regobj.Continue();
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("document.querySelector('button').click();");
	try {
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();
	    alert.accept(); 
	    System.out.println("Registration OK button clicked");
	    String act_result1=logobj.getproductlogin();
	    Assert.assertEquals(act_result1, Expected_log);
	} catch (Exception e) {
	    System.out.println("No alert found.");
	}
	logobj.login();
	logobj.SetEmail("Naina12@gmail.com");
	logobj.SetPassword("123457");
	logobj.btnClick();
	logobj.getproduct();
	
	try {
	     
		 WebDriverWait waitForProjectList = new WebDriverWait(driver, Duration.ofSeconds(8));
	        WebElement projectList = waitForProjectList.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='card-title']")));
	    if (projectList.isDisplayed()) {
	        System.out.println(" Student dashboard are displayed after login.");
	    } else {
	        System.out.println("Student dashboard are not displayed after login.");
	   }}
catch (TimeoutException e) {
    System.out.println("No project assigned-user didnt secure passmark in exit exam");
}
	logobj.Logout();
}	


public void studdashtest(int index, String email) throws InterruptedException {
	if (index >= 3) 
        index = 2;
	readMoreButton.projectsel(index, email);
	System.out.println("project selected for user:"+email);
	readMoreButton.Checkbox();
	readMoreButton.proceedbutton();
	String act_result3=readMoreButton.getproductprojectd();
    Assert.assertEquals(act_result3, Expected_proj);
 readMoreButton.refmet();
 readMoreButton.getref();
 readMoreButton.weeksub();
 readMoreButton.weekselection();
 readMoreButton.weekoption();
 readMoreButton.weeklink();
 readMoreButton.weekupload();
 readMoreButton.weekcomment();
 readMoreButton.weeksub1();
 readMoreButton.discussforum();
 readMoreButton.mygrade();
 readMoreButton.clickFinalProjectTab();
 readMoreButton.projectlink();
 readMoreButton.projectupload();
 readMoreButton.projcomment();
 readMoreButton.submitproj();
 readMoreButton.vivavoice();
 readMoreButton.vivasubmit();
 readMoreButton.vivacomment();
 readMoreButton.vivafile();
 readMoreButton.vivasubmit2();
 logobj.Logout();
}
@Test(priority=3)
public void Negtest1() {
	logobj.login();
	logobj.SetEmail("invalid@gmail.com");
	logobj.SetPassword("123456");
	logobj.btnClick();
System.out.println("Invalid  login credential:please enter valid email");
}
@Test(priority=4)
public void Negtest2()	{
	logobj.SetEmail("princy@gmail.com");
	logobj.SetPassword("000000");
	logobj.btnClick();
	System.out.println(" invalid login credential:please enter valid password");
}
@Test(priority=5)
public void Negtest3() {
	logobj.SetEmail(" ");
	logobj.SetPassword(" ");
	logobj.btnClick();
	System.out.println("Invalid login  credential: all fields required");
}
@Test(priority=6) 
public void Negtest4() throws InterruptedException {
	logobj.login();
	regobj.Register();
	regobj.Name(" ");
	regobj.Email(" ");
	regobj.Password(" ");
	regobj.Phoneneumber(" ");
	regobj.Batchname(" ");
	regobj.Checkbox();
	regobj.Continue();
System.out.println("All fields required for registration");	
}
@Test(priority=7)
public void Negtest5() throws InterruptedException {
	logobj.login();
	regobj.Register();
	regobj.Name(" ");
	regobj.Email("Naina12@gmail.com");
	regobj.Password("123457");
	regobj.Phoneneumber("9446117323");
	regobj.Batchname("Nov 2024");
	regobj.Checkbox();
	regobj.Continue();
	System.out.println("Invalid credential:name must provide for completing registration");
}
	
@AfterTest
public void close() {
	if(driver!=null)
		driver.close();
}
	}


   


