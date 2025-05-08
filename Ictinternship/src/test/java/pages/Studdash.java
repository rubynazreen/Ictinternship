package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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
}
	  
public void Checkbox() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement ckh=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='acceptTerms' and @type='checkbox']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", ckh);
	
	Thread.sleep(500); 
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", ckh); 
}
public void proceedbutton() {
	
	WebElement pcdbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[2]")));
	pcdbtn.click();
	//String actualTitle=driver.getTitle();
	//Assert.assertEquals(actualTitle,"ICTAK Internship");
}
public void refmet() {
    By locator = By.xpath("//*[@id='v-pills-reference-tab']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Locate and scroll
    WebElement refnav = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", refnav);

    // Re-locate and click
    refnav = wait.until(ExpectedConditions.elementToBeClickable(locator));
    refnav.click();
}

public void getref() {
	WebElement getref=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Get Reference']")));
	 ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", getref);

		    // Click it after ensuring it’s clickable
		    wait.until(ExpectedConditions.elementToBeClickable(getref)).click();
}
		
public void weeksub()
{
	WebElement weekn=driver.findElement(By.xpath("//*[@id=\"v-pills-weekly-tab\"]"));
	weekn.click();

}
public void  discussforum() {
	WebElement discfor=driver.findElement(By.xpath("//*[@id=\"v-pills-discussion-tab\"]"));
	discfor.click();
}
public void mygrade() {
	WebElement myg=driver.findElement(By.xpath("//*[@id=\"v-pills-grades-tab\"]"));
	myg.click();
}
public void clickFinalProjectTab() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By xpath = By.xpath("//button[@id='v-pills-final-tab']");

    for (int attempt = 0; attempt < 2; attempt++) {
        try {
            WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", tab);
            tab = wait.until(ExpectedConditions.elementToBeClickable(xpath));
            tab.click();
            break;
        } catch (StaleElementReferenceException e) {
            System.out.println("Retrying due to stale element...");
        }
    }
}
public void vivavoice() {
	WebElement viv=driver.findElement(By.xpath("//*[@id=\"v-pills-viva-tab\"]"));
	viv.click();
}//*[@id="v-pills-viva-tab"]


}
   




