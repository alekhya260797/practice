package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SectionPage {
	private static WebDriver driver;

	public SectionPage(WebDriver driver) 
	{
	

		this.driver=driver;
	}
	//h_signiniframe
private static By addpagebtn=By.xpath("//div[@id='AddPage']");

private static By textboxbtn=By.xpath("//input[@id='textBox']");
private static By createbtn=By.xpath("//a[@id='CreateButton']");

private static By frame= By.id("WebApplicationFrame");


public WebElement adddPageBtn()
{
	
	return driver.findElement(addpagebtn);
}
public WebElement txtboxBtn()
{
	return driver.findElement(textboxbtn);
}
public WebElement createBtn()
{
	return driver.findElement(createbtn);
}

}
