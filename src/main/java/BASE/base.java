package BASE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;

import Utils.Reporter;

public class base {
	public static WebDriver driver;
	public ExtentReports report= Reporter.reportpage();
	public ExtentTest logger;
	@BeforeMethod
public void openBrowser() throws FileNotFoundException, IOException {
		logger = report.createTest("Opening URL");
		
	Properties prop = new Properties();
	prop.load(new FileInputStream("src/main/java/config/config.properties"));
	
	if(prop.getProperty("browserName").matches("edge")) {
	System.setProperty("webdriver.edge.driver", "C:\\Users\\manji\\AppData\\Local\\Temp\\edgedriver_win64\\msedgedriver.exe");
	driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
//	File fscr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	//taking failed screenshot 
//	String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
//	Files.copy(fscr, new File("C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\screenshot\\failscreenshot\\"+timeStamp+".jpg"));
	File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String timeStamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	Files.copy(SS, new File("./src/main/java/Resource/URLSS"));
}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
//	public static XSSFSheet excel() throws IOException {
//		//Locate The File
//		String filelocation = "C:\\Users\\2140752\\OneDrive - Cognizant\\Desktop\\automationproject\\src\\resource\\userdata.xlsx";
//		@SuppressWarnings("resource")
//		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);		
//		XSSFSheet sheet = wbook.getSheetAt(0);
//		return sheet;
//	}
}

