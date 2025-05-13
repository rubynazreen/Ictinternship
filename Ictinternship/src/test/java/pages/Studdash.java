package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
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
	 Actions actions= new Actions(driver);
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
	}

public void refmet() {
    By locator = By.xpath("//*[@id='v-pills-reference-tab']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //  for Location and scroll
    WebElement refnav = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", refnav);

    //  to Re-locate and click
    refnav = wait.until(ExpectedConditions.elementToBeClickable(locator));
    refnav.click();
}

public void getref() {
	WebElement getref=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Get Reference']")));
	 ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", getref);

		   
		    wait.until(ExpectedConditions.elementToBeClickable(getref)).click();
}
		
public void weeksub()
{
	WebElement weekn=driver.findElement(By.xpath("//*[@id=\"v-pills-weekly-tab\"]"));
	weekn.click();
}
public void weekselection() {
WebElement weeksel=driver.findElement(By.xpath("//select[@class='form-select']"));
weeksel.click();
}
public void weekoption() {
WebElement drop1=driver.findElement(By.xpath("//select[@class='form-select']/option[@value='1']"));
drop1.click();
}
public void weeklink() {
WebElement linksub=driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
linksub.sendKeys("https://drive.google.com/file/d/1WaRirPEwux61C1QaEICgmkUwcGB79a7d/view?usp=sharing");
}
public void weekupload(){
	WebElement pp=driver.findElement(By.xpath("(//input[@type='file'])[1]"));
	pp.sendKeys("C:\\githubrepo\\Ictinternship\\Ictinternship\\KKEM FSD March 2024 SRS Document.pdf");
}
public void weekcomment() {
	WebElement comm=driver.findElement(By.xpath("(//textarea[@class='form-control'])[2]"));
	comm.sendKeys("this week's submission");
}
public void weeksub1() {
	WebElement submit=driver.findElement(By.xpath("(//button[text()='Add Submission'])[1]"));
	submit.click();
	try {
	    WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
	    Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());
	    System.out.println("Alert Text: " + alert.getText());
	    alert.accept(); // Clicks OK on the alert
	    System.out.println("Alert accepted.");
	} catch (Exception e) {
	    System.out.println("No alert appeared.");}
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
        }}
    }
    public void projectlink() {
   
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    By xpath = By.xpath("(//textarea[@class='form-control'])[3]");
  WebElement upload=wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
 upload.sendKeys("https://drive.google.com/file/d/1WaRirPEwux61C1QaEICgmkUwcGB79a7d/view?usp=sharing");
}
    public void projectupload() {
    	
    	WebElement pp=driver.findElement(By.xpath("(//input[@type='file'])[2]"));
    	pp.sendKeys("C:\\githubrepo\\Ictinternship\\Ictinternship\\KKEM FSD March 2024 SRS Document.pdf");
    }
    public void  projcomment() {
    	WebElement comm=driver.findElement(By.xpath("(//textarea[@class='form-control'])[4]"));
    	comm.sendKeys("my final project submission");
    }
    public void submitproj() {
    WebElement submit=driver.findElement(By.xpath("(//button[text()='Add Submission'])[2]"));
	submit.click();
	try {
	    WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
	    Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());
	    System.out.println("Alert Text: " + alert.getText());
	    alert.accept(); // Clicks OK on the alert
	    System.out.println("Alert accepted.");
	} catch (Exception e) {
	    System.out.println("No alert appeared.");
	}
	System.out.println("Project submitted successfully....");
    }
    
public void vivavoice() {
	WebElement viv=driver.findElement(By.xpath("//*[@id=\"v-pills-viva-tab\"]"));
	viv.click();
}
public void vivasubmit() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    By xpath = By.xpath("//button[text()='Submit']");
	  WebElement vs=wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
	 vs.click();}
public void vivacomment() {
	WebElement vc=driver.findElement(By.xpath("//textarea[@id='comments']"));
	vc.sendKeys("viva voce completed");	
}
public void vivafile() {
	
	WebElement vf=driver.findElement(By.xpath("(//input[@type='file'])[3]"));
	vf.sendKeys("C:\\githubrepo\\Ictinternship\\Ictinternship\\KKEM FSD March 2024 SRS Document.pdf");
}
public void vivasubmit2() {
 WebElement vse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[3]")));
 JavascriptExecutor js = (JavascriptExecutor) driver;
 js.executeScript("arguments[0].scrollIntoView(true);", vse);
 js.executeScript("arguments[0].click();", vse);

 try {
	    WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(5));
	    Alert alert = waitAlert.until(ExpectedConditions.alertIsPresent());
	    System.out.println("Alert text: " + alert.getText());
	    alert.accept();  
	    System.out.println("Alert accepted.");
	} catch (Exception e) {
	    System.out.println("No alert appeared.");
	}  
	   
	    System.out.println("viva voce submitted successfully..");
}

public String getproductprojectd()

{
	WebElement productpjd=driver.findElement(By.xpath("//u[text()='PROJECT DASHBOARD']"));
	String prdp=productpjd.getText();
	System.out.println("Reached Projectdashboardpage");
return prdp;
}

}
   




