package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {
public static WebDriver driver;


public LoginPage(WebDriver driver) 

{
	LoginPage.driver=driver;
}
	private static By username=By.xpath("//input[@type='email']");
	private static By  nextbtn=By.xpath("//input[@value='Next']");
	private static By  pasword=By.xpath("//input[@type='password']");
	private static By  submit=By.xpath("//input[@type='submit']");

	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	public WebElement nextBtn()
	{
		return driver.findElement(nextbtn);
	}
	public WebElement password()
	{
		return driver.findElement(pasword);
	}
	public WebElement submitBtn()
	{
		return driver.findElement(submit);
	}
}
