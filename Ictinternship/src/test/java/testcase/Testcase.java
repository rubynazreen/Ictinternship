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
	String Expected_name="The Student Dashboard";
	
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
	 
		
@Test(priority=1)
public void PostTest() throws IOException, InterruptedException
{ int sheetIndex = 0;
String filepath = "C:\\Projectworkspace\\Ictinternship\\src\\test\\resources\\TestExcel.xlsx"; 
	for(int i=0;i<4;i++) {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		        System.out.println("Alert text: " + alert.getText());
		        alert.accept();
		        System.out.println("Alert accepted before starting login for user " + i);
		    } catch (TimeoutException e) {
		        System.out.println("No alert present before starting login for user " + i);
		    }
		
		logobj.login();
		
		String email = Utilitiesexcel.Excelread(filepath, sheetIndex, i, 0);
	 String password = Utilitiesexcel.Excelread(filepath, sheetIndex,i,1);
	 String projectName = Utilitiesexcel.Excelread(filepath, sheetIndex, i, 2);
	 System.out.println("Testing login with: "+ email +"/" +password);
	 
	logobj.SetEmail(email);
	
	logobj.SetPassword(password);
	
	logobj.btnClick();
	
String act_result=logobj.getproduct();
Assert.assertEquals(act_result,Expected_name);
System.out.println("Test Passed for User "+ email);
int projectcount=3;
Random random = new Random();
int projectIndex = random.nextInt(projectcount)+1; 

studdashtest(projectIndex,email);
	
}}	
@Test(priority=0)
public void registertest() throws InterruptedException {
	
	logobj.login();
	regobj.Register();
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
	    // Wait for alert and accept it
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());

	    Alert alert = driver.switchTo().alert();
	    alert.accept(); // click OK
	    System.out.println("Registration OK button clicked (alert accepted).");

	} catch (Exception e) {
	    System.out.println("No alert found.");
	}
	logobj.login();
	logobj.SetEmail("Naina12@gmail.com");
	logobj.SetPassword("123457");
	logobj.btnClick();
	logobj.getproduct();
	
	try {
	    //WebElement projectList = driver.findElement(By.xpath("//u[text()='Available Projects']")); 
		 WebDriverWait waitForProjectList = new WebDriverWait(driver, Duration.ofSeconds(15));
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
 readMoreButton.refmet();
 readMoreButton.getref();
 readMoreButton.weeksub();
 readMoreButton.discussforum();
 readMoreButton.mygrade();
 readMoreButton.clickFinalProjectTab();
 readMoreButton.vivavoice();
 logobj.Logout();
}



}
   


