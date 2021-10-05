package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class TestBase {

	
	public static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	@BeforeTest
	public void doLogin()
	{
	LoginPage l= new LoginPage(driver);
	l.username().sendKeys(config.getProperty("msa"));
	l.nextBtn().click();
	l.password().sendKeys(config.getProperty("msapaswrd"));
	WebDriverWait wait= new WebDriverWait(driver, 100);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	l.submitBtn().click();
	try {
		l.submitBtn().click();
	}
	catch(Exception e) {
		System.out.println("No Pop up");
	}
		
	
	}
	
	@BeforeSuite
	public static void launchBrowser() throws MalformedURLException {
		
		
		if(driver==null) {
		 Date d = new Date();
			
		 System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator
		.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
		
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.debug("OR file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
		log.info("Chrome Browser Lauched");
		}
		else if(config.getProperty("browser").equalsIgnoreCase("edgebrowser")) {
			WebDriverManager.edgedriver().setup();
	          driver=new EdgeDriver();
		}
		driver.get(config.getProperty("onenoteurl"));
		System.out.println("Navigated to "+config.getProperty("onenoteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	}
	
	public void waitforElement(int duration, By by){
		
		wait = new WebDriverWait(driver, duration);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	public static  void click(String locator) {

		if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
	log.info("Clicking on an Element :"+locator);
	//ExtentListeners.testReport.get().log(Status.INFO, "Clicking on : "+locator);

	}
	public static String note() {
		int start = 97; // letter 'a'
		int end = 122; // letter 'z'
		int StringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(StringLength);
		for (int i = 0; i < StringLength; i++) {
			int randomLimitedInt = start + (int) (random.nextFloat() * (end - start + 1));
			buffer.append((char) randomLimitedInt);
		}
		String RandomString = buffer.toString();

		// System.out.println(generatedString);
		return RandomString;
	}
	
	public static void frame(int i) {
		driver.switchTo().frame(i);
	}
	
	  public WebElement webElement(By by) {
		 
		
		  return driver.findElement(by);
	
		 
			}
@AfterSuite	
public static void tearDown()
{
	try {
		Thread.sleep(1000);
		driver.quit();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	log.info("Test execution completed");
}

}
