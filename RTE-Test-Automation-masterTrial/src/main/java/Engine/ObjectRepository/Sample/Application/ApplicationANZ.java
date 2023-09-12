package Engine.ObjectRepository.Sample.Application;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


/**
 * Created by Raj
 */
public class ApplicationANZ extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //private Engine.ObjectRepository.AIB.CommonAIB.CommonAIB CommonAIB = new CommonAIB(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public ApplicationANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region Application
    private final By AddToForm = By.id("compext-add");
    private final By RemoveFromForm = By.xpath("//*[@id=\"compext-remove\"]");
    private final By RemoveStatus = By.xpath("//*[@id=\"select2-typeahead-select-collection-statusCd-container\"]/span");
    private final By SourceType = By.id("select2-typeahead-select-externalSourceCd-container");
    private final By ID = By.xpath("//*[@id=\"externalReference_externalIdFields_0__value\"]");
    private final By ID2 = By.xpath("//*[@id=\"externalReference_externalIdFields_1__value\"]");
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By Save2 = By.xpath("(//input[@value=\"Save\"])[2]");
    private final By Status = By.xpath("//*[@id=\"select2-typeahead-select-collection-statusCd-container\"]");
    private final By NatureOfApplication = By.xpath("//*[@id=\"select2-typeahead-select-collection-collectionType-container\"]");
    private final By SourceSystemStatus = By.xpath("//*[@id=\"select2-typeahead-select-collection-csdListCollCd-container\"]");
    private final By ApplicationCurrency = By.xpath("//*[@id=\"select2-typeahead-select-collection-collectionCcy-container\"]");
    private final By TotalCollateralValue = By.xpath("//*[@id=\"collection-nominalCollateralValue-id\"]");
    private final By TotalFacilityLimits = By.xpath("//*[@id=\"collection-nominalExposureValue-id\"]");
    private final By ApplicationDate = By.xpath("//*[@id=\"collection-proposalDate-id\"]");
    private final By LetterOfOfferDate  = By.xpath("//*[@id=\"collection-acceptanceReviewDate-id\"]");
    private final By LetterOfOfferExecutionDate = By.xpath("//*[@id=\"collection-acceptedDate-id\"]");
    private final By RelationshipManagerSetCPIDPrimary = By.xpath("//*[@id=\"collection-reportingCd1-id\"]");
    private final By RelationshipManagerSetCPIDOther = By.xpath("//*[@id=\"collection-reportingCd2-id\"]");
    private final By BusinessSegment = By.xpath("//*[@id=\"collection-reportingCd3-id\"]");
    private final By LetterOfOfferIssued = By.xpath("//*[@id=\"dropdown-collection-letterOfferIssued-udf\"]");

    //endregion Application


    //region Application Creation

    /**
     *Description: Application Creation
     * @return
     */
    public void ApplicationCreation(String ApplicationType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String NatureOfApplicationOption, String SourceSystemStatusOption,
                                    String ApplicationCurrencyOption, String BankOption, String TotalCollateralValueOption, String TotalFacilityLimitsOption, String ApplicationDateOption,
                                    String LetterOfOfferDateOption, String LetterOfOfferExecutionDateOption, String RelationshipManagerSetCPIDOtherOption, String BusinessSegmentOption,
                                    String LetterOfOfferIssuedOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        try {
            CommonForAll.turnOffImplicitWaits();
            thread.sleep(1000);
            driver.findElement(AddToForm).click();
        }
        catch (NoSuchElementException e)
        {

        }
        CommonForAll.turnOnImplicitWaits();
        if(SourceTypeOption == "") {

        }else if(SourceTypeOption.equals("XXX")){
            CommonForAll.Click(SourceType);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            CommonForAll.SendKeys(ID, IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
                CommonForAll.Click(SourceType);
                isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
                driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
                isElementLoaded(ID);
                driver.findElement(ID).sendKeys(IDString);
        }
        if(ApplicationType == "Generic Application") {
            CommonForAll.ClickAndSelectByLiWithoutScrollContains(Status, StatusOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(NatureOfApplication, NatureOfApplicationOption);
            SelectBank(BankOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(SourceSystemStatus, SourceSystemStatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(ApplicationCurrency, ApplicationCurrencyOption);
            CommonForAll.SendKeys(TotalCollateralValue, TotalCollateralValueOption);
            CommonForAll.SendKeys(TotalFacilityLimits, TotalFacilityLimitsOption);
            CommonForAll.SendKeys(ApplicationDate, ApplicationDateOption);
            CommonForAll.SendKeys(LetterOfOfferDate, LetterOfOfferDateOption);
            CommonForAll.SendKeys(LetterOfOfferExecutionDate, LetterOfOfferExecutionDateOption);
            CommonForAll.SendKeys(RelationshipManagerSetCPIDPrimary, RelationshipManagerSetCPIDOtherOption);
            CommonForAll.SendKeys(RelationshipManagerSetCPIDOther, RelationshipManagerSetCPIDOtherOption);
            CommonForAll.SendKeys(BusinessSegment, BusinessSegmentOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(LetterOfOfferIssued, LetterOfOfferIssuedOption, "1");
        }

    }

    /**
     *Description: Application Creation in Onboarding
     * @return
     */
    public void ApplicationCreationOnboarding(String ApplicationType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String NatureOfApplicationOption, String SourceSystemStatusOption,
                                    String ApplicationCurrencyOption, String BankOption, String TotalCollateralValueOption, String TotalFacilityLimitsOption, String ApplicationDateOption,
                                    String LetterOfOfferDateOption, String LetterOfOfferExecutionDateOption, String RelationshipManagerSetCPIDOtherOption, String BusinessSegmentOption,
                                    String LetterOfOfferIssuedOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {

        SelectBank(BankOption);
        CommonForAll.turnOnImplicitWaits();
        if(SourceTypeOption == "") {

        }else if(SourceTypeOption.equals("XXX")){
            CommonForAll.ClickAndSelectByLiWithoutScrollContains(Status, StatusOption);
            CommonForAll.Click(SourceType);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            CommonForAll.SendKeys(ID, IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
            CommonForAll.ClickAndSelectByLiWithoutScrollContains(Status, StatusOption);
            CommonForAll.JavaScriptScrollByPixels(100);
            CommonForAll.Click(SourceType);
            thread.sleep(300);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            thread.sleep(300);
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            CommonForAll.SendKeys(ID, IDString);
        }
        if(ApplicationType == "Generic Application") {

            //CommonForAll.ClickAndSelectByLiWithoutScrollContains(NatureOfApplication, NatureOfApplicationOption);
            CommonForAll.JavaScriptScrollToBottom();
            CommonForAll.ClickAndSelectByLiWithoutScroll(SourceSystemStatus, SourceSystemStatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(ApplicationCurrency, ApplicationCurrencyOption);
            CommonForAll.SendKeys(TotalCollateralValue, TotalCollateralValueOption);
            CommonForAll.SendKeys(TotalFacilityLimits, TotalFacilityLimitsOption);
            CommonForAll.SendKeys(ApplicationDate, ApplicationDateOption);
            CommonForAll.SendKeys(LetterOfOfferDate, LetterOfOfferDateOption);
            CommonForAll.SendKeys(LetterOfOfferExecutionDate, LetterOfOfferExecutionDateOption);
            CommonForAll.SendKeys(RelationshipManagerSetCPIDPrimary, RelationshipManagerSetCPIDOtherOption);
            CommonForAll.SendKeys(RelationshipManagerSetCPIDOther, RelationshipManagerSetCPIDOtherOption);
            CommonForAll.SendKeys(BusinessSegment, BusinessSegmentOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(LetterOfOfferIssued, LetterOfOfferIssuedOption, "1");
        }

    }

    /**
     *Description: Select Source System Status
     * @return
     */
    public void SelectSourceSystemStatus(String SourceSystemStatusOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(SourceSystemStatus, SourceSystemStatusOption);

    }

    /**
     *Description: Add To Form And Select Identified By
     * @return
     */
    public void AddToFormWithIdentifiedBy(String TypeOfApplication, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        if(SourceTypeOption == ""){
            ;
        }else {
            isElementLoaded(AddToForm);
            driver.findElement(AddToForm).click();
            isElementLoaded(SourceType);
            driver.findElement(SourceType).click();
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            if(SourceTypeOption == "") {

                CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
                CommonForAll.Click(RemoveFromForm);

            }else if(SourceTypeOption == "ABC"){
                isElementLoaded(ID);
                driver.findElement(ID).sendKeys(IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            }
            else{
                isElementLoaded(ID);
                driver.findElement(ID).sendKeys(IDString);
            }

        }

    }

    /**
     *Description: Select Status
     * @return
     */
    public void SelectApplicationStatus(String StatusOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);

    }

    /**
     *Description: Add To Form Click
     * @return
     */
    public void AddToFormClick() throws InterruptedException
    {
        thread.sleep(500);
        CommonForAll.Click(AddToForm);
    }

    /**
     *Description: Remove from Form
     * @return
     */
    public void RemoveFromForm() throws InterruptedException
    {
        CommonForAll.Click(RemoveFromForm);
    }

    /**
     *Description: Remove Status
     * @return
     */
    public void RemoveStatus() throws InterruptedException
    {
        CommonForAll.Click(RemoveStatus);
    }


    /**
     *Description: Select the Bank NEEDED
     */
    public void SelectBank(String Name) throws InterruptedException {
        if (Name == "ANZx") {
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a")).click();
            thread.sleep(1000);
//            isElementLoaded(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a"));
//            driver.findElement(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a")).click();
//            thread.sleep(1000);
//            isElementLoaded(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a"));
//            driver.findElement(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a")).click();

        }else if(Name == "") {
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a")).click();
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a")).click();
            thread.sleep(1000);
//            isElementLoaded(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a"));
//            driver.findElement(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a")).click();
//            thread.sleep(1000);
//            isElementLoaded(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a"));
//            driver.findElement(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a")).click();

        }
        thread.sleep(500);
    }

    /**
     *Description: Save
     * @return
     */
    public void Save1() throws InterruptedException {
        CommonForAll.JavaScriptScrollToTop();
        CommonForAll.Click(Save1);
    }

    /**
     *Description: Save 2
     * @return
     */
    public void Save2() throws InterruptedException {
        CommonForAll.JavaScriptScrollToBottom();
        thread.sleep(300);
        CommonForAll.Click(Save2);
    }

    //endregion Deal Creation




    }



