package Engine.ObjectRepository.Sample.GeneralInsurance;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;


/**
 * Created by Raj
 */
public class GeneralInsuranceANZ extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //private Engine.ObjectRepository.AIB.CommonAIB.CommonAIB CommonAIB = new CommonAIB(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public GeneralInsuranceANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region General Insurance
    private final By AddToForm = By.id("compext-add");
    private final By RemoveFromForm = By.xpath("//*[@id=\"compext-remove\"]");
    private final By RemoveStatus = By.xpath("//*[@id=\"select2-typeahead-select-generalInsurance-statusCd-container\"]/span");
    private final By SourceType = By.id("select2-typeahead-select-externalSourceCd-container");
    private final By ID = By.xpath("//*[@id=\"externalReference_externalIdFields_0__value\"]");
    private final By ID2 = By.xpath("//*[@id=\"externalReference_externalIdFields_1__value\"]");
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By Save2 = By.xpath("(//input[@value=\"Save\"])[2]");
    private final By Status = By.xpath("//*[@id=\"select2-typeahead-select-generalInsurance-statusCd-container\"]");
    private final By PolicyReferenceNumber = By.xpath("//*[@id=\"generalInsurance-policyNum-id\"]");
    private final By PolicyType = By.xpath("//*[@id=\"select2-typeahead-select-generalInsurance-insuranceTypeCd-container\"]");
    private final By InsuranceRenewalExemptionReason = By.xpath("//*[@id=\"select2-typeahead-select-generalInsurance-coverageTypCd-container\"]");
    private final By ANZInterestNoted = By.xpath("//*[@id=\"dropdown-generalInsurance-escrowedYn\"]");
    private final By InsuranceRenewalExempt = By.xpath("//*[@id=\"dropdown-generalInsurance-forcePlacedPolicyYn\"]");
    private final By StartDate = By.xpath("//*[@id=\"generalInsurance-inceptionDate-id\"]");
    private final By ExpiryDate = By.xpath("//*[@id=\"generalInsurance-expiryDate-id\"]");
    private final By PolicyCurrency = By.xpath("//*[@id=\"select2-typeahead-select-generalInsurance-policyCcyCd-container\"]");
    private final By PolicyAmount= By.xpath("//*[@id=\"generalInsurance-amtInsured-id\"]");
    private final By KeyAdditionalInformation = By.xpath("//*[@id=\"generalInsurance-policyDetails-id\"]");
    private final By BrokerName = By.xpath("//*[@id=\"generalInsurance-brokerName-id\"]");
    private final By BrokerPhoneNumber = By.xpath("//*[@id=\"generalInsurance-brokerPhoneNumber-id\"]");
    private final By BrokerEmail = By.xpath("//*[@id=\"generalInsurance-brokerEmail-id\"]");
    private final By DisasterCoverageType = By.xpath("//*[@id=\"generalInsurance-disasterCoverageType-id\"]");
    private final By CompleteReplacementValue = By.xpath("//*[@id=\"dropdown-generalInsurance-CompleteReplacementValue-udf\"]");
    private final By GenericDropdown = By.xpath("//*[@id=\"select2-typeahead-select-generalInsurance-csdListGenInsCd-container\"]");
    //endregion


    //region General Insurance Creation

    /**
     *Description: General Insurance Creation
     * @return
     */
    public void GeneralInsuranceCreate(String GeneralInsuranceType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String PolicyReferenceNumberOption,
                                       String PolicyTypeOption, String InsuranceRenewalExemptionReasonOption, String ANZInterestNotedOption, String BankOption, String InsuranceRenewalExemptOption,
                                       String StartDateOption, String ExpiryDateOption, String PolicyAmountOption, String PolicyCurrencyOption, String KeyAdditionalInformationOption,
                                       String BrokerNameOption, String BrokerPhoneNumberOption, String BrokerEmailOption, String DisasterCoverageTypeOption, String CompleteReplacementValueOption,
                                       String GenericDropdownOption,String PremiumFrequencyOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17, String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        if(SourceTypeOption == "") {

        }else if(SourceTypeOption.equals("XXX")){
            CommonForAll.Click(AddToForm);
            CommonForAll.Click(SourceType);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            CommonForAll.SendKeys(ID, IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
            CommonForAll.Click(AddToForm);
            CommonForAll.Click(SourceType);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
        }
        if(GeneralInsuranceType == "General Insurance")
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.SendKeys(PolicyReferenceNumber, PolicyReferenceNumberOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PolicyType, PolicyTypeOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(InsuranceRenewalExemptionReason,InsuranceRenewalExemptionReasonOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(ANZInterestNoted, ANZInterestNotedOption, "1");
            CommonForAll.ClickAndSelectByAForYesAndNo(InsuranceRenewalExempt, InsuranceRenewalExemptOption, "2");
            SelectBank(BankOption);
            CommonForAll.SendKeys(StartDate, StartDateOption);
            CommonForAll.SendKeys(ExpiryDate, ExpiryDateOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PolicyCurrency, PolicyCurrencyOption);
            CommonForAll.SendKeys(PolicyAmount, PolicyAmountOption);
            CommonForAll.SendKeys(KeyAdditionalInformation, KeyAdditionalInformationOption);
            CommonForAll.SendKeys(BrokerName, BrokerNameOption);
            CommonForAll.SendKeys(BrokerPhoneNumber, BrokerPhoneNumberOption);
            CommonForAll.SendKeys(BrokerEmail, BrokerEmailOption);
            CommonForAll.SendKeys(DisasterCoverageType, DisasterCoverageTypeOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(CompleteReplacementValue, CompleteReplacementValueOption,"3");
            if(GenericDropdownOption == "")
            {

            }
            else {
                CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown, GenericDropdownOption);
            }
    }


    /**
     *Description: Add To Form And Select Identified By
     * @return
     */
    public void AddToFormWithIdentifiedBy(String TypeOfApplication, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        if(SourceTypeOption == "") {

        }else if(SourceTypeOption.equals("XXX")){
            CommonForAll.Click(AddToForm);
            CommonForAll.Click(SourceType);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            CommonForAll.SendKeys(ID, IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
            CommonForAll.Click(AddToForm);
            CommonForAll.Click(SourceType);
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
        }

    }

    /**
     *Description: Select Status
     * @return
     */
    public void SelectGeneralInsuranceStatus(String StatusOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);

    }

    /**
     *Description: Insurance Renewal Exempt
     * @return
     */
    public void SelectInsuranceRenewalExempt(String InsuranceRenewalExemptOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByAForYesAndNo(InsuranceRenewalExempt, InsuranceRenewalExemptOption,"2");

    }

    /**
     *Description: Expiry Date
     * @return
     */
    public void SelectExpiryDate(String ExpiryDateOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.SendKeys(ExpiryDate, ExpiryDateOption);

    }

    /**
     *Description: Clear Expiry Date Field
     * @return
     */
    public void ClearExpiryDateField() throws InterruptedException {
        CommonForAll.ClearField(ExpiryDate);

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

    //endregion




    }



