package Engine.CommonForAll;

import Engine.common.BaseTest;
import Engine.common.Page;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.*;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import static io.restassured.RestAssured.given;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;



/**
 * Created by Raj
 */
public class CommonForAll extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public CommonForAll(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public WebDriverWait wait;
    static Thread thread;
    //endregion Initialization


    //region Explicit Wait
    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }

    public void isElementLoadedLessWait(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion



    //region JavaScript & Action Classes

    /**
     *Description: Java Script Scroll And Click
     */
    public void JavaScriptScrollAndClick(By Path) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement ele = driver.findElement(Path);
        jse.executeScript("arguments[0].scrollIntoView()", ele);
        thread.sleep(100);
        jse.executeScript("arguments[0].click()", ele);
    }


    /**
     *Description: Java Script Scroll
     */
    public void JavaScriptScroll(By Path) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement ele = driver.findElement(Path);
        jse.executeScript("arguments[0].scrollIntoView()", ele);
        thread.sleep(100);
    }

    /**
     *Description: Java Script Scroll by pixels
     */
    public void JavaScriptScrollByPixels(int PixelsToScroll) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        int Pixel = PixelsToScroll;
        thread.sleep(200);
        jse.executeScript("window.scrollBy(0,"+ PixelsToScroll +")");
        thread.sleep(100);
    }

    /**
     *Description: Java Script Scroll
     */
    public void JavaScriptScrollToTop() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        thread.sleep(100);
    }

    /**
     *Description: Java Script Scroll
     */
    public void JavaScriptScrollToBottom() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight)");
        thread.sleep(100);
    }

    //endregion JavaScript & Action Classes

    //region Basic Operation

    /**
     *Description: Capture and return Page URL
     */
    public String CapturePageURL() throws InterruptedException {
        return driver.getCurrentUrl();
    }

    /**
     *Description: Click
     */
    public void Click(By Path) throws InterruptedException {
        Thread.sleep(250);
        isElementLoaded(Path);
        driver.findElement(Path).click();
    }

    /**
     *Description: Click Less Wait
     */
    public void ClickWithLessWait(By Path) throws InterruptedException {
        thread.sleep(250);
        isElementLoadedLessWait(Path);
        driver.findElement(Path).click();
    }

    /**
     *Description: Send Keys
     */
    public void SendKeys(By Path, String SendKeys) throws InterruptedException {
        Thread.sleep(190);
        if(SendKeys=="") {

        }
        else {
            isElementLoaded(Path);
            driver.findElement(Path).sendKeys(SendKeys);
        }
    }

    /**
     *Description: Clear Field
     */
    public void ClearField(By Path) throws InterruptedException {
        thread.sleep(190);
        isElementLoaded(Path);
        driver.findElement(Path).clear();
    }

    /**
     * Description: Get Text, copied from a field, by providing some part of the Field, Ex. to copy text Registered Mortgage [CLT - 8042], just provide "CLT"
     * @return
     */
    public String GetTextAndSaveIt(String SomeTextInTheField) {
        String TextCopied = driver.findElement(By.xpath("//*[contains(normalize-space(text()), '" + SomeTextInTheField + "')]")).getText().trim();
        return TextCopied;
    }

    /**
     *Description : Get Text by Xpath
     */
    public String GetTextByXpath(By Xpath)
    {
        String TextCopied = driver.findElement(Xpath).getText().trim();
        return TextCopied;
    }

    /**
     *Description : Get Attribute value from Xpath
     */
    public String GetAttributeByXpath(By Xpath, String AttributeName)
    {
        String AttributeValue = driver.findElement(Xpath).getAttribute(AttributeName).trim();
        return AttributeValue;
    }

    /**
     *Description: Click and Select by Li Contains Text, with Fixed TypeIn box with scroll
     */
    public void ClickAndSelectByLi(By Path, String OptionWithLi) throws InterruptedException {
        if(OptionWithLi == "")
        {
            ;
        }
        else {
            thread.sleep(1000);
            driver.findElement(Path).click();
            JavaScriptScroll(By.xpath("//li[normalize-space(text())='" + OptionWithLi + "']"));
            thread.sleep(1000);
            driver.findElement(By.xpath("//*[@class=\"select2-search__field\"]")).sendKeys(OptionWithLi);
            driver.findElement(By.xpath("//li[normalize-space(text())='" + OptionWithLi + "']")).click();
        }
    }

    /**
     *Description: Click & Select with Li with Variable typein path
     */
    public void ClickAndSelectWithLiMain(By Path, By TypeInPath, String ToSelectWithLi) throws InterruptedException {
        thread.sleep(400);
        isElementLoaded(Path);
        driver.findElement(Path).click();
        thread.sleep(400);
        isElementLoaded(TypeInPath);
        driver.findElement(TypeInPath).sendKeys(ToSelectWithLi);
        isElementLoaded(By.xpath("//li[normalize-space(text())='"+ ToSelectWithLi +"']"));
        driver.findElement(By.xpath("//li[normalize-space(text())='"+ ToSelectWithLi +"']")).click();
    }

    /**
     *Description: Click and Select Contains Text by Li, With Fixed typein box path
     */
    public void ClickAndSelectByLiWithoutScroll(By Path, String OptionWithLi) throws InterruptedException {

        thread.sleep(600);
        if(OptionWithLi == "")
        {
            ;
        }
        else {
            turnOffImplicitWaits();
            try {
                Click(Path);
            } catch (Exception e) {
                Thread.sleep(500);
                JavaScriptScrollByPixels(260);
                Click(Path);
            }
            turnOnImplicitWaits();
            //driver.findElement(Path).click();
            Thread.sleep(200);
            isElementLoaded(By.xpath("//*[@class=\"select2-search__field\"]"));
            driver.findElement(By.xpath("//*[@class=\"select2-search__field\"]")).sendKeys(OptionWithLi);
            Thread.sleep(300);
            isElementLoaded(By.xpath("//li[normalize-space(text())='" + OptionWithLi + "']"));
            driver.findElement(By.xpath("//li[normalize-space(text())='" + OptionWithLi + "']")).click();
        }

        ////*[contains(normalize-space(text()), '" + Field + "')]
    }

    /**
     *Description: Click and Select Contains Text by Li, With Fixed typein box path Contains
     */
    public void ClickAndSelectByLiWithoutScrollContains(By Path, String OptionWithLiContains) throws InterruptedException {

        driver.findElement(Path).click();
        thread.sleep(200);
        isElementLoaded(By.xpath("//*[@class=\"select2-search__field\"]"));
        driver.findElement(By.xpath("//*[@class=\"select2-search__field\"]")).sendKeys(OptionWithLiContains);
        thread.sleep(300);
        isElementLoaded(By.xpath("//li[contains(normalize-space(text()),'"+ OptionWithLiContains +"')]"));
        driver.findElement(By.xpath("//li[contains(normalize-space(text()),'"+ OptionWithLiContains +"')]")).click();
        ////*[contains(normalize-space(text()), '" + Field + "')]
    }

    /**
     *Description: Click and Select Contains Text by a, For Yes & NO
     */
    public void ClickAndSelectByAForYesAndNo(By Path, String OptionWithLi, String PositionOfYesAndNo) throws InterruptedException {
        thread.sleep(500);
        isElementLoaded(Path);
        Click(Path);
        thread.sleep(500);
        isElementLoaded(By.xpath("(//a[normalize-space(text())='"+ OptionWithLi +"'])["+PositionOfYesAndNo+"]"));
        driver.findElement(By.xpath("(//a[normalize-space(text())='"+ OptionWithLi +"'])["+PositionOfYesAndNo+"]")).click();
    }

    //endregion

    //region Asserts & Xpath Operations

    /**
     * Description: Simple Assert
     */
    public void SimpleAssert(String InputA, String InputB) {

        try {
            Assert.assertEquals(InputA, InputB);
            log.info(InputA + " & " + InputB + " match : Validation Successful: Passed!!!!!!!!!!!!!!!");
        }catch(Exception | AssertionError e)
        {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.error(InputA + " & " + InputB + " Doesn't Match ###############Failed###############");
        }
    }

    /**
     * Description: Simple Assert with Assert True & condition
     */
    public void SimpleAssertTrue(Boolean TrueOrFalse) {

        try {
            Assert.assertTrue(TrueOrFalse);
            log.info("Validation Successful: Passed!!!!!!!!!!!!!!!");
        }catch(Exception | AssertionError e)
        {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.error(TrueOrFalse + " : Got False instead of True ###############Failed###############");
        }
    }

    /**
     * Description: Assert if a Text is not Present in the Page by Text contains
     */
    public void AssertIfNotPresentByText(String Field, String NameOfField) {

        try {
            Assert.assertTrue(driver.findElements(By.xpath("//*[contains(normalize-space(text()), '" + Field + "')]")).isEmpty());
            log.info(NameOfField + " Text is not Present on the Screen: Passed");
        }catch(Exception | AssertionError e)
        {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.error(NameOfField + " Text is Present On the Screen, Should be Hidden: ###############Failed###############");
        }
    }

    /**
     * Description: Assert if a Text is not Present in the Page by Text
     */
    public void AssertIfNotPresentByActualText(String Field, String NameOfField) {

        try {
            Assert.assertTrue(driver.findElements(By.xpath("//*[normalize-space(text())='"+ Field +"']")).isEmpty());
            log.info(NameOfField + " Text is not Present on the Screen: Passed");
        }catch(Exception | AssertionError e)
        {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.error(NameOfField + " Text is Present On the Screen, Should be Hidden: ###############Failed###############");
        }
    }


    /**
     * Description: Assert if a Label is not Present in the Page by Text
     */
    public void AssertIfNotPresentByTextLabel(String Field, String NameOfField) {

        try {
            Assert.assertTrue(driver.findElements(By.xpath("//label[contains(normalize-space(text()), '" + Field + "')]")).isEmpty());
            log.info(NameOfField + " Text is not Present on the Screen: Passed");
        }catch(Exception | AssertionError e)
        {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.error(NameOfField + " Text is Present On the Screen, Should be Hidden: *###############Failed###############");
        }
    }

    /**
     * Description: Assert if xpath or id is not present on the Page
     */
    public void AssertIfNotPresentByXpath(By Field, String NameOfField) {
        try {
            boolean TrueOrFalse = driver.findElement(Field).isDisplayed();
            if (TrueOrFalse == false) {
                log.info(NameOfField + " xpath or ID is Not present on the screen: Passed");
            } else {
                log.error(NameOfField + " is Present on the Screen, Should Be Not Present: ###############Failed###############");
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            }
        }
        catch (Exception e)
        {
            log.info(NameOfField + " is Not Present on the Screen, Should Be Present: Passed");

        }
    }

    /**
     * Description: Assert if a Text is Present on the Page by Text
     */
    public void AssertIfPresentByText(String Field) {
        try {
            thread.sleep(1000);
            boolean TrueOrFalse = driver.findElement(By.xpath("//*[contains(normalize-space(text()), '" + Field + "')]")).isDisplayed();
            if (TrueOrFalse) {
                log.info(Field + " is present on the screen: Passed");
            } else {
                log.error(Field + " is Not Present on the Screen, Should Be Present: ###############Failed###############");
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            }
        }
        catch (Exception e)
        {
            log.error(Field + " is Not Present on the Screen, Should Be Present: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            //Assert.fail(Field + " Text is NOT Present on the Screen Should Be Present: ************Failed************");
        }
    }

    /**
     * Description: Assert if xpath or id is present on the Page
     */
    public void AssertIfPresent(By Field, String NameOfField) {
        try {

            boolean TrueOrFalse = driver.findElement(Field).isDisplayed();
            if (TrueOrFalse) {
                log.info(NameOfField + " xpath or ID is present on the screen: Passed");
            } else {
                log.error(NameOfField + " is Not Present on the Screen, Should Be Present: ###############Failed###############");
            }
        }
        catch (Exception e)
        {
            log.error(NameOfField + " is Not Present on the Screen, Should Be Present: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            //Assert.fail(NameOfField + " Text is NOT Present on the Screen Should Be Present: ************Failed************");

        }
    }


    /**
     * Description: Assert if Text is present on Page by Xpath
     */
    public void AssertIfTextPresentOnPageByLocator(By Field, String TextToCheck) {

        try {
            turnOffImplicitWaits();
            String textActual = driver.findElement(Field).getText().trim();
            //System.out.println(textActual + " is present on the screen");
            Assert.assertEquals(textActual, TextToCheck);
            log.info(TextToCheck + " Text is Present on the Screen: .....PASSED.....");
            turnOnImplicitWaits();
        }catch(NoSuchElementException |AssertionError e)
        {
            log.error(TextToCheck + " Text is NOT Present on the Screen Should Be Present: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            //Assert.fail(TextToCheck + " Text is NOT Present on the Screen Should Be Present: ************Failed************");
        }
    }

    /**
     * Description: Assert if a Text is Present in the Page by Text
     */
    public void AssertIfPresentOnPageByText(String TextToCheck) {

        try {
            String textActual = driver.findElement(By.xpath("//*[contains(normalize-space(text()), '" + TextToCheck + "')]")).getText().trim();
            System.out.println(textActual);
            Assert.assertEquals(textActual, TextToCheck);
            //log.info(" Text is Present on the Screen: Passed");
        }catch(NoSuchElementException | AssertionError e  )
        {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.error(TextToCheck + " Text is NOT Present on the Screen Should Be Present: ###############Failed###############");
        }
    }

    /**
     * Description: Assert if Text is present on Page by Xpath By getting Attribute
     */
    public void AssertIfTextPresentOnPageByLocatorGetAttribute(By GetAttribute, String TextToCheck) {
        String textActual = driver.findElement(GetAttribute).getAttribute("innerHTML").trim();
        try {
            Assert.assertEquals(textActual, TextToCheck);
            log.info(TextToCheck + " is Present on the Screen: .....PASSED.....");
        }catch(AssertionError e)
        {

            log.info(TextToCheck + " is NOT Present on the Screen Should be Present: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }

    /**
     *Description: Assert Lists
     * @return
     */
    public void AssertList(List<String> StatusActual, List<String> StatusExpected) throws InterruptedException {

        try {
            Assert.assertEquals(StatusActual, StatusExpected);
            log.info("Status Updated Properly");
        } catch (AssertionError e) {
            log.error("Status Not Updated Properly: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }

    /**
     * Description: Get Attribute and check if its present on the screen.
     */
    public void GetAttributeAndPresentOnScreen(By GetXPATH, String AttributeName, String TextToCheck) {
        String textActual = driver.findElement(GetXPATH).getAttribute(AttributeName);
        try {
            System.out.println("Actual Text on Screen is: " + textActual);
            Assert.assertEquals(textActual, TextToCheck);
            log.info(TextToCheck + " is Present on the Screen: Passed");
        }catch(AssertionError e)
        {

            log.info(TextToCheck + " is NOT Present on the Screen Should be Present: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }

    /**
     *Description: Copy Text From a field and Assert if its Correct
     */
    public void AssertByCopyingTextFromAField(By Path, String TextToCheck) throws InterruptedException, IOException, UnsupportedFlavorException {
        String copy = Keys.chord(Keys.CONTROL,Keys.chord("c"));
        driver.findElement(Path).sendKeys(Keys.CONTROL+"a");
        driver.findElement(Path).sendKeys(copy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
        //System.out.println(x);
        try {
            thread.sleep(200);
            Assert.assertEquals(x, TextToCheck);
        }
        catch (AssertionError e)
        {
            log.error("Correct Value is Not Present: ###############Failed###############");
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
        }
    }

    /**
     *Description: Clipboard Copy
     */
    public void ClipBoardCopy(String ItemToBeCopied) throws InterruptedException, IOException, UnsupportedFlavorException {
        String ItemToBeCopiedA = ItemToBeCopied;
        StringSelection stringSelection = new StringSelection(ItemToBeCopiedA);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }


    //endregion Asserts & Xpath Operations

    //region Random Generator

    /**
     * Description: RandomNumber Upto 9 digits
     */
    public String getRandomNumberUpto9digits(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }

    /**
     * Description: RandomNumber 11 digits
     *
     */
    public String getRandomNumber11Digits() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return String.valueOf(random.nextLong(10_000_000_000L, 100_000_000_000L));
    }

    /**
     * Description: Get Random Alphabetic String 10 digits Ex: erhfdsearb
     */
    public String getRandomAlphabeticString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    //endregion Random Generator

    //region Waits

    /**
     * Description: Turn Off Implicit Wait & Turn On Implicit wait
     *
     */
    public void turnOffImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
    }

    public void turnOnImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //endregion Waits

    //region Date

    /**
     * Description: Date format Converter  2023-02-08 to 8 February 2023
     * d MMMM yyyy - 4 February 2023
     * yyyy-MM-dd - 2022-12-30
     * @return
     */

    public String DateFormatConverter(String Date, String DateFormatNeeded) throws ParseException {
        String pattern = "d MMMM YYYY";
        SimpleDateFormat sdfP = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatNeeded);
        Date convertedCurrentDate = sdfP.parse(Date);
        String date=sdf.format(convertedCurrentDate );
        return date;
    }

    /**
     * Description: Get Date in format dd-mm-yyyy
     *
     * @return
     */

    public String DateFromCurrentDateindMMMMYYYYFormat(int DaysFormToday) {
        String pattern = "d MMMM YYYY";
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, DaysFormToday);
        Date d = c.getTime();
        String DateAsString = df.format(d);
        return DateAsString;
    }

    /**
     * Description: Get Date in format dd-mm-yyyy
     *
     * @return
     */

    public String DateFromCurrentDate(int DaysFormToday) {
        String pattern = "dd-MMMM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, DaysFormToday);
        Date d = c.getTime();
        String DateAsString = df.format(d);
        return DateAsString;
    }

    /**
     * Description: Get Date in format dd-mm-yyyy
     *
     * @return
     */

    public String DateFromCurrentDateFormatMMDDYYYY(int DaysFormToday) {
        String pattern = "MMMM-dd-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, DaysFormToday);
        Date d = c.getTime();
        String DateAsString = df.format(d);
        return DateAsString;
    }
    //endregion Date

    //region Actions and Key Operations

    /**
     *Description: Action Class Scroll
     */
    public void ActionClassScrollTo(By Path) throws InterruptedException {
        WebElement element = driver.findElement(Path);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    /**
     *Description: Action Move Mouse and CLick
     */
    public void MouseMoveAndClick(int x, int y) throws InterruptedException, AWTException {
        thread.sleep(1000);
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
        robot.mouseMove(x, y);
        actions.click().build().perform();
        thread.sleep(1500);
    }

    /**
     * Description: Press Keys on Keyboard Action
     *
     */
    public void KeysPressActionClass(Keys Key) throws AWTException, InterruptedException {
        thread.sleep(600);
        Actions action = new Actions(driver);
        action.sendKeys(Key);
    }

    /**
     * Description: Press Keys on Keyboard Robot Class KeyEvent.VK_ESCAPE
     *
     */
    public void KeysPressRobotClass(int KeyCode) throws AWTException, InterruptedException {
        thread.sleep(600);
        Robot robot = new Robot();
        robot.keyPress(KeyCode);
        thread.sleep(300);
        //robot.keyPress(KeyEvent.VK_ESCAPE);
    }

    /**
     * Description: Release Keys on Keyboard Robot Class KeyEvent.VK_ESCAPE
     *
     */
    public void KeysReleaseRobotClass(int KeyCode) throws AWTException, InterruptedException {
        thread.sleep(600);
        Robot robot = new Robot();
        robot.keyRelease(KeyCode);
        thread.sleep(300);
        //robot.keyPress(KeyEvent.VK_ESCAPE);
    }

    /**
     * Description: Sending ID and Password in Alert Box and Signin
     *
     */
    public void SendingIDAndPasswordInAlertBoxAndSignIn(String ID, String Password) throws AWTException, InterruptedException, IOException, UnsupportedFlavorException {

        ClipBoardCopy(ID);
        KeysPressRobotClass(KeyEvent.VK_CONTROL);
        KeysPressRobotClass(KeyEvent.VK_V);
        KeysReleaseRobotClass(KeyEvent.VK_V);
        KeysReleaseRobotClass(KeyEvent.VK_CONTROL);
        KeysPressRobotClass(KeyEvent.VK_TAB);
        KeysReleaseRobotClass(KeyEvent.VK_TAB);
        ClipBoardCopy(Password);
        KeysPressRobotClass(KeyEvent.VK_CONTROL);
        KeysPressRobotClass(KeyEvent.VK_V);
        KeysReleaseRobotClass(KeyEvent.VK_V);
        KeysReleaseRobotClass(KeyEvent.VK_CONTROL);
        thread.sleep(500);
        KeysPressRobotClass(KeyEvent.VK_TAB);
        KeysReleaseRobotClass(KeyEvent.VK_TAB);
        thread.sleep(500);
        KeysPressRobotClass(KeyEvent.VK_ENTER);
        KeysReleaseRobotClass(KeyEvent.VK_ENTER);
    }

    //endregion Actions and Key Operations

    //region Select the Searched term
    /**
     *Description: Select the searched option in Tab By SearchTerm After the Search Legal Entity
     */
    public void SearchedSelectBySearchTerm(String SearchKeywordBySearchTerm) throws InterruptedException {
        thread.sleep(500);
        isElementLoaded(By.xpath("(//em[text()='" + SearchKeywordBySearchTerm + "']/parent::div/parent::div/parent::td/parent::tr)/td[1]/a/div"));
        driver.findElement(By.xpath("(//em[text()='" + SearchKeywordBySearchTerm + "']/parent::div/parent::div/parent::td/parent::tr)/td[1]/a/div")).click();
    }

    /**
     *Description: Select the searched option in MAIN Tab By SearchTerm After the Search for Loan & Exposure
     */
    public void SearchedSelectBySearchTermForLoanAndExposure(String SearchKeywordBySearchTerm) throws InterruptedException {
        thread.sleep(500);
        isElementLoaded(By.xpath("(//em[text()='" + SearchKeywordBySearchTerm + "']/parent::div/parent::div/parent::td/parent::tr)/td[1]/div/a"));
        driver.findElement(By.xpath("(//em[text()='" + SearchKeywordBySearchTerm + "']/parent::div/parent::div/parent::td/parent::tr)/td[1]/div/a")).click();
    }

    /**
     *Description: Select the searched option in ANY Tab By ID After the Search Legal Entity
     */
    public void SearchedSelectByID(String ID) throws InterruptedException {
        thread.sleep(500);
        driver.findElement(By.xpath("//*[contains(text(), '"+ ID +"')]")).click();
    }

    /**
     *Description: Select Searched By ID for Searching Asset/LEDs in onboarding page for linking where Selection items are not present in every row in the Table
     */
    public void SelectSearchedBySearchTermWhileLinkingWhereSelectionItemsAreAtDifferentPlacesInTheTable (String SelectSearchBySearchTerm, String Position) throws InterruptedException {
        thread.sleep(500);
        Click(By.xpath("(//*[contains(text(), '" + SelectSearchBySearchTerm + "')]//parent::div//parent::div//parent::div//parent::td//parent::tr//td//input)["+ Position +"]"));
        //driver.findElement(By.xpath("(//*[contains(text(), '" + SelectSearchBySearchTerm + "')]//parent::div//parent::div//parent::div//parent::td//parent::tr//td//input)["+ Position +"]")).click();
    }

    /**
     *Description: Select Searched By Search Term in Link after Search while Linking or Attaching
     */
    public void SelectSearchedBySearchTermWhileLinking (String SelectSearchBySearchTerm) throws InterruptedException {
        thread.sleep(500);
        Click(By.xpath("(//*[contains(text(), '" + SelectSearchBySearchTerm + "')]/parent::div/parent::div/parent::td/parent::tr)/td/input"));
        //driver.findElement(By.xpath("(//*[contains(text(), '" + SelectSearchBySearchTerm + "')]/parent::div/parent::div/parent::td/parent::tr)/td/input")).click();
    }

    /**
     *Description: Select Searched By Search Term in Link after Search while Linking or Attaching with Position
     */
    public void SelectSearchedBySearchTermWhileLinkingWithPosition (String SelectSearchBySearchTerm, String Position) throws InterruptedException {
        thread.sleep(500);
        Click(By.xpath("((//*[contains(text(), '" + SelectSearchBySearchTerm + "')]/parent::div/parent::div/parent::td/parent::tr)/td/input)["+ Position +"]"));
        //driver.findElement(By.xpath("((//*[contains(text(), '" + SelectSearchBySearchTerm + "')]/parent::div/parent::div/parent::td/parent::tr)/td/input)["+ Position +"]")).click();
    }

    /**
     *Description: Onboarding Search and Link When First Option is disabled
     */
    public void OnboardingSearchAndLinkWhenFirstItemIsDisabled(String FindOption, String i, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        thread.sleep(1000);
        turnOffImplicitWaits();
        try {
            thread.sleep(300);
            String HiddenOrNot = driver.findElement(By.xpath("(//*[contains(text(), '" + FindOption + "')]/parent::div/parent::div/parent::td/parent::tr)/td/input")).getAttribute("style");
            System.out.println(HiddenOrNot);
            if(HiddenOrNot.equalsIgnoreCase("visibility: hidden;"))
            {
                driver.findElement(By.xpath("((//*[contains(text(), '" + FindOption + "')]/parent::div/parent::div/parent::td/parent::tr)/td/input)[2]")).click();
            }
            else{
                SelectSearchedBySearchTermWhileLinking(FindOption);
            }
        }
        catch(TimeoutException | NoSuchElementException e)
        {
           SelectSearchedBySearchTermWhileLinking(FindOption);
        }
        turnOnImplicitWaits();
        thread.sleep(500);

    }
    //endregion Select the Searched term

    //region 2FA

    /**
     *Description: 2FA Bypass Code
     */
    public static String getTwoFactorCode(){
        Totp totp = new Totp("l7nqsgk6mtnns2yg");
        String twoFactorCode = totp.now();
        return twoFactorCode;
    }

    //endregion 2FA

    //region API

    /**
     * Description: API URL Status Code Check with actual and expected.
     */
    public static void APIURLStatusCodeCheck(String SecondaryURL, String ExpectedStatusCode) {
        Response response = null;
        try {
            Thread.sleep(200);
            response = given().log().all().when().get(SecondaryURL).then().log().status().extract().response();
            Assert.assertEquals(String.valueOf(response.getStatusCode()), ExpectedStatusCode);
            log.info("Getting " + response.getStatusCode() + " response from " + SecondaryURL + " PASSED!!!!!!!!!!!!!!!");

        } catch (Exception | NoSuchMethodError | AssertionError e) {
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            assert response != null;
            log.info("Getting " + response.getStatusCode() + " response from " + SecondaryURL + " should be " +  ExpectedStatusCode + "###############Failed###############");
        }

    }

    /**
     * Description: API URL Status Code Check with actual and expected.
     *
     * @return
     */
    @org.jetbrains.annotations.NotNull
    public JsonPath ParsingJSON(String SecondaryURL) {
        //driver.manage().window().minimize();
        String response = given().when().get(SecondaryURL).then().assertThat().statusCode(200).extract().response().asString(); //Also verifying category
        JsonPath js = new JsonPath(response);
        return js;
    }
    //endregion API
}



