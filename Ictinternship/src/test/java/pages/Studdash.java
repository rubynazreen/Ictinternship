package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Studdash extends Loginpage {
	 WebDriverWait wait;
	
public  Studdash(WebDriver driver) {
	super(driver);
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
}
 
//String email,index;
//public void projectsel() {
	//WebElement prjsl=driver.findElement(By.xpath("(//button[text()='Read more'])[1]"));
	//prjsl.click();
//}

/*public void projectsel(int index) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'card')]")));
String xpath = "(//button[text()='Read more'])[" + (index + 1) + "]";


WebElement readMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
readMoreButton.click();
System.out.println("Clicked on Read more button for project index: " + index); 
}*/
public void projectsel(int index,String email) throws InterruptedException {
	Thread.sleep(500);
	 List<WebElement> button = driver.findElements(By.xpath("//button[text()='Read more']"));
	 List<WebElement> titles = driver.findElements(By.xpath("//h5/u"));
	    int count = button.size();

	    System.out.println("User: " + email + " | Total Read more buttons: " + count);

	    if (count == 0) {
	        System.out.println("No projects found for user: " + email);
	        return;
	    } if (index >= count) {
	        System.out.println("Provided index " + index + " out of bounds for user: " + email + ", resetting to last button");
	        index = count - 1;
	    }String projectTitle = titles.get(index).getText();
	    WebElement btn = button.get(index);

	    wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
	    System.out.println("Clicked on project: '" + projectTitle + "' for user: " + email);

	    // Click on the "Read more" button
	    
	}
	    //Random rand = new Random();
	   // int index = rand.nextInt(count); // Select randomly based on count

	   // WebElement button = readMoreButtons.get(index);
	    //wait.until(ExpectedConditions.elementToBeClickable(button)).click();
	  //  System.out.println("Clicked on project index: " + index + " for user: " + email);
    
    



public void Checkbox() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement ckh=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='acceptTerms' and @type='checkbox']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ckh);
	
	Thread.sleep(500); // Give time to scroll
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ckh); 
}
public void proceedbutton() {
	
	WebElement pcdbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
	pcdbtn.click();
	//String actualTitle=driver.getTitle();
	//Assert.assertEquals(actualTitle,"ICTAK Internship");
}

public void Logoutpage() throws InterruptedException {
    try {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        Thread.sleep(500);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//nav//button[text()='Logout']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutBtn);
        System.out.println("Logout clicked.");

        wait.until(ExpectedConditions.urlContains("login"));
    } catch (Exception e) {
        System.out.println("Logout failed: " + e.getMessage());
    }

}}


   




