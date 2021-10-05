package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.NotebooksPage;

@SuppressWarnings("unused")
public class NotebookCreationTest extends TestBase{

	@Test
	public void notebookcreationTest()
	{
	NotebooksPage n= new NotebooksPage(driver);
	n.notebookCreationBtn().click();
	String notebookName =note();
	String text = "//android.widget.TextView[@text='"+notebookName+"']";
	
	 WebElement notebook= webElement(By.xpath(text));
	Assert.assertTrue(notebook.isDisplayed());
	n.txtboxBtn().sendKeys(text);
	n.createBtn().click();
	
	Assert.assertTrue(false);
	}
}
