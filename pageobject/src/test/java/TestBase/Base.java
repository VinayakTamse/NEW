package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	String configPath = System.getProperty("user.dir") + "\\src\\test\\java\\configurations\\config.properties";
	
	public static FileInputStream fin;
	public static Properties props;
	public static WebDriver driver;
	
	public Base()		{
		try {
			fin = new FileInputStream(configPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		props = new Properties();
		try {
			props.load(fin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialisation()	{
		String browser = props.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome"))		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox"))	{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(props.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

}
