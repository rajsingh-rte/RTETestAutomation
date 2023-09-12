package Engine.common;

import Engine.CommonForAll.CommonForAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class LoginPage extends Page {
    public CommonForAll CommonForAll = new CommonForAll(driver);;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By username = By.id("username");
    By password = By.id("password");
    By logon = By.id("logon-submit-btn");



    public void loginANZ() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        CommonForAll CommonForAll = new CommonForAll(driver);
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));
//        driver.findElement(By.xpath("//*[@id=\"logon-submit-btn\"]")).click();
//        driver.findElement(By.xpath("//*[@data-provider=\"windows\"]//div")).click();
//        driver.findElement(By.xpath("//*[@name=\"loginfmt\"]")).sendKeys("rajsagarraj.singh@broadridge.com");
//        Thread.sleep(300);
//        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
//        Thread.sleep(4000);

        //CommonForAll.SendingIDAndPasswordInAlertBoxAndSignIn("Singhrajs", "BroadPass$12");

        driver.findElement(username).sendKeys("ADMIN");
        driver.findElement(password).sendKeys("ADMIN");
        driver.findElement(logon).click();


        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        Thread.sleep(1000);
        WebElement html = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
        driver.navigate().refresh();

    }
}
