package Engine.common;

import Engine.config.LocalConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriver driver;
    public final String browser = LocalConfig.INSTANCE.getBrowser();

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() throws AWTException {
        log.info("Setting up Web driver");
        initialize(browser);
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.body.style.zoom='0%'");
    }

    public WebDriver getWebdriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            log.info("Launching Firefox !!");
        } else if (browser.equalsIgnoreCase("chrome")) {
            log.info("Launching Chrome !!");
            //driver = new ChromeDriver(chromeOptions);
            ChromeOptions chromeOptions = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriverAugust2023.exe");

            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("--no-sandbox");

            chromeOptions.addArguments("chrome.switches", "--disable-extensions");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("window-size=800, 400");
            driver = new ChromeDriver(chromeOptions);
            chromeOptions.addArguments("start-maximized");
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("document.body.style.zoom='80%'");
//            driver.manage().window().setSize(new Dimension(1920, 1080));

        } else if (browser.equalsIgnoreCase("ie")) {
            log.info("Launching Internet Explorer !!");
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer-32Bit.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
            driver = new InternetExplorerDriver(options);
        }
        return driver;
    }

    public void initialize(String browser) {
        driver = getWebdriver(browser);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Quitting Driver");
        log.info("===============================================");
        //driver.quit();
    }

}
