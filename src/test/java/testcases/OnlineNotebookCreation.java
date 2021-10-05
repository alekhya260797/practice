package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.NotebooksPage;


public class OnlineNotebookCreation extends TestBase {

	@Test
	public void notebookcreationTest() throws InterruptedException
	{
	NotebooksPage n= new NotebooksPage(driver);
	n.notebookCreationBtn().click();
	String notebookName = OnlineNote.note();
	
	n.txtboxBtn().sendKeys(notebookName);
	n.createBtn().click();
	Thread.sleep(3000);
	n.createSec().click();
	String sectionName=OnlineNote.note();
	n.SecTextbox().sendKeys(sectionName);
	click("sectionOk_XPATH");
	
	
	}
}
