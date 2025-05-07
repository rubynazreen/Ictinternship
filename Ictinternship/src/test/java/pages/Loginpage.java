package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {


WebDriver driver;

public Loginpage(WebDriver driver)
{
	this.driver=driver;
}


public void login() {
	WebElement lgn=driver.findElement(By.xpath("(//button[text()='Login'])[1]"));
	lgn.click();
}
public void SetEmail(String Email) {
	
//	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));	
WebElement eml=driver.findElement(By.xpath("//input[@type='email']"));
eml.clear();
eml.sendKeys(Email);
}
public void SetPassword(String Password) {
	
	//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
	WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
	pass.clear();
pass.sendKeys(Password);
}
public void btnClick() {
	WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
	btn.click();}

public String getproduct()

{
	WebElement dashboard=driver.findElement(By.xpath("//*[text()='The Student Dashboard']"));
	String prdt= dashboard.getText();
	System.out.println("Login is successful: Project is visible");
return prdt;
}


public void Logout()
{
	WebElement lgt=driver.findElement(By.xpath("//button[text()='Logout']"));
	lgt.click();

}

}
