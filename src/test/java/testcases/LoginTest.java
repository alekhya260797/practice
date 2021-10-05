package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.NotebooksPage;
import pages.SectionPage;

@SuppressWarnings("unused")
public class LoginTest extends TestBase {

	
	@Test(priority=1)
	public void doLogin()
	{
	LoginPage l= new LoginPage(driver);
	l.username().sendKeys(config.getProperty("msa"));
	l.nextBtn().click();
	l.password().sendKeys(config.getProperty("msapaswrd"));
	WebDriverWait wait= new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	l.submitBtn().click();
	try {
		l.submitBtn().click();
	}
	catch(Exception e) {
		System.out.println("No Pop up");
	}
	
	
	
	
	
	}
	
	@Test(priority=2)
	public void notebookcreationTest()
	{
		//h_signiniframe
System.out.println(driver.findElements(By.tagName("iframe")).size());
		//driver.switchTo().frame(frame);

	//
	NotebooksPage n= new NotebooksPage(driver);
	n.notebookCreationBtn().click();
	String notebookName = note();
	String text = "//android.widget.TextView[@text='"+notebookName+"']";
	
	
	n.txtboxBtn().sendKeys(notebookName);
	n.createBtn().click();
	 //WebElement notebook= webElement(By.xpath(text));
		//Assert.assertTrue(notebook.isDisplayed());
	
	}
	/*@Test(priority=3)
	public void canvasTest() throws InterruptedException {
		
	//driver.switchTo().defaultContent();
	//SectionPage p=new SectionPage(driver);
	//p.adddPageBtn();
	//	for(int i=0;i<1;i++)
	
	WebElement f=driver.findElement(By.id("WebApplicationFrame"));
	driver.switchTo().frame(f);
		
		//WebElement f1=driver.findElement(By.name("SharedAuthFrame"));
		//System.out.println(  driver.switchTo().frame(f1));
	Thread.sleep(1000);
	//driver.switchTo().frame(1);
	////button[@aria-label='Italic']
	//*[@id="PageContentContainer"]/div[1]/div[1]/div/div/div/p
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='AddPage']")));
	driver.findElement(By.xpath("//div[@id='AddPage']")).click();
//	driver.switchTo().defaultContent();
	System.out.println(  driver.findElements(By.tagName("iframe")).size());
	for(int i=0;i<2;i++)
	System.out.println(  driver.findElements(By.tagName("iframe")).get(i).getAttribute("name"));
	driver.switchTo().frame(0);
	//wait.until(ExpectedConditions.elementToBeClickable(By.id("WACViewPanel")));
	driver.findElement(By.id("WACViewPanel")).click();
	driver.findElement(By.id("WACViewPanel")).sendKeys("anna");
	
	
	}*/
	
}
