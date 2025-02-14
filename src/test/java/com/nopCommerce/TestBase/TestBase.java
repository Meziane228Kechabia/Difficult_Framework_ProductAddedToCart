package com.nopCommerce.TestBase; 

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public Properties prop;
	public FileInputStream ip;
	public WebDriver driver;
	public ChromeOptions options; 
		
		public TestBase () throws Exception {			
			 prop = new Properties();
			 ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Config.properties");
			 prop.load(ip);
		}
		public WebDriver openingApplicationWithAnyBrowser(String browserName) {
			if(browserName.equals("chrome")) {
				options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);	
				options.addArguments("--start-maximized");
				options.addArguments("--incognito");
				options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
				driver = new ChromeDriver(options);	
			}else if(browserName.equals("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();		
			}else if(browserName.equals("Edge")) {
				driver = new EdgeDriver();
				driver.manage().window().maximize();	
			}
			
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGELOAD_TIME_WAIT));
			//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME_WAIT));
			driver.get(prop.getProperty("url"));
			return driver;
		}

	}



