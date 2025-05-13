package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registrationpage extends Loginpage {



public Registrationpage(WebDriver driver) {
	super (driver);
}
public void Register() throws InterruptedException
{
	WebElement rgst ;
	 rgst=driver.findElement(By.linkText("New User? Register"));
	rgst.click();
	}

public void Name(String name)
{
	WebElement nme=driver.findElement(By.xpath("//input[@placeholder='Name']"));
	nme.sendKeys(name);
}
public void Email(String email) {
	WebElement eml=driver.findElement(By.xpath("//input[@placeholder='Email']"));
	eml.sendKeys(email);
}
public void Password(String password) {
	WebElement pwd=driver.findElement(By.xpath("//input[@placeholder='Password']"));
	pwd.sendKeys(password);
}
public void Phoneneumber(String phnumber) {
	WebElement pnm=driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
	pnm.sendKeys(phnumber);
}
public void Batchname(String batch) {
	WebElement bth=driver.findElement(By.xpath("//input[@placeholder='Batch Name']"));
	bth.sendKeys(batch);
}
public void Checkbox() {
	WebElement ckb=driver.findElement(By.xpath("//input[@type='checkbox']"));
	ckb.click();
}
public void Continue() {
	WebElement cnt=driver.findElement(By.xpath("//button[@type='submit']"));
	cnt.click();
	
}
public String getproductreg()
{
	WebElement productreg=driver.findElement(By.xpath("//h2[text()='Student Signup']"));
	String prd=productreg.getText();
	System.out.println("Reached RegistrationPage");
return prd;
}

}
