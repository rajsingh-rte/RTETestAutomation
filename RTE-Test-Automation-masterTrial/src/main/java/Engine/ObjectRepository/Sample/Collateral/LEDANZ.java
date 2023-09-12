package Engine.ObjectRepository.Sample.Collateral;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Created by Raj
 */
public class LEDANZ extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //private Engine.ObjectRepository.AIB.CommonAIB.CommonAIB CommonAIB = new CommonAIB(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public LEDANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region LED
    //Lien Creation
    private final By DetailsTab = By.xpath("//*[@id=\"ledDetailsTab\"]");
    private final By AddToForm = By.id("compext-add");
    private final By RemoveFromForm = By.id("compext-remove");
    private final By RemoveStatus = By.xpath("//*[@id=\"select2-typeahead-select-legalEnforceableDocument-statusCd-container\"]/span");
    private final By RemoveCompareTo = By.xpath("//*[@id=\"select2-typeahead-select-exposure-compareTo-container\"]/span");
    private final By SourceType = By.id("select2-typeahead-select-externalSourceCd-container");
    private final By ID = By.xpath("//*[@id=\"externalReference_externalIdFields_0__value\"]");
    private final By ID2 = By.xpath("//*[@id=\"externalReference_externalIdFields_1__value\"]");
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By Status = By.xpath("//*[@id=\"select2-typeahead-select-legalEnforceableDocument-statusCd-container\"]");
    //private final By SubType= By.xpath("//*[@id=\"select2-typeahead-select-legalEnforceableDocument-subType-container\"]");
    private final By SubType= By.xpath("//*[@class=\"select2 select2-container select2-container--default select2-container--below select2-container--focus\"]");
    private final By Currency= By.xpath("//*[@id=\"select2-typeahead-select-legalEnforceableDocument-ccyCd-container\"]");
    private final By Amount= By.xpath("//*[@id=\"legalEnforceableDocument-amount-id\"]");
    private final By DocumentDate= By.xpath("//*[@id=\"legalEnforceableDocument-startDate-id\"]");
    private final By ExpiryDate= By.xpath("//*[@id=\"legalEnforceableDocument-endDate-id\"]");
    private final By RegistrationRequired= By.xpath("//*[@id=\"dropdown-legalEnforceableDocument-registrnReqdYn\"]");
    private final By RegistrationNumber= By.xpath("//*[@id=\"legalEnforceableDocument-registrationId-id\"]");
    private final By BusinessSegment= By.xpath("//*[@id=\"select2-typeahead-select-legalEnforceableDocument-csdListLedCd-container\"]");
    private final By RelationshipManagerSetPrimary= By.xpath("//*[@id=\"legalEnforceableDocument-reportingCd1-id\"]");
    private final By RelationshipManagerSetOther= By.xpath("//*[@id=\"legalEnforceableDocument-reportingCd2-id\"]");
    private final By ReportingCodeThree= By.xpath("//*[@id=\"legalEnforceableDocument-reportingCd3-id\"]");
    private final By ReportingCodeFour= By.xpath("//*[@id=\"legalEnforceableDocument-reportingCd4-id\"]");
    private final By Save2 = By.xpath("(//input[@value='Save'])[2]");
    private final By LegalEntityTab = By.xpath("//*[@id=\"led-legal-entity-tab-href\"]");
    private final By DataFilters = By.xpath("//*[@id=\"dataBarriers_chosen\"]/ul");

    //Task
    private final By TaskTab = By.id("task-tab-href");
    private final By NewTask = By.id("task-show-add-0.0-id");
    private final By DescriptionTaskTab = By.id("task-description-id");
    private final By TypeTaskTab = By.id("select2-typeahead-select-task-taskType-container");
    private final By PriorityTaskTab = By.id("select2-typeahead-select-task-taskPriority-container");
    private final By StatusTaskTab = By.id("select2-typeahead-select-task-taskStatus-container");
    private final By StartDate = By.id("task-startDate-id");
    private final By DueDateTaskTab = By.id("task-dueDate-id");
    private final By GroupTaskTab = By.id("select2-typeahead-select-task-group-id-container");
    private final By AssigneeTaskTab = By.xpath("(//*[@class=\"select2-selection select2-selection--single\"])[5]");
    private final By AssigneeTypeahead = By.xpath("(//*[@id=\"typeahead-search\"])");
    private final By ActionCompleteCheckBox = By.xpath("//input[@class='taskResolutionCheckbox']");
    private final By YesPrompt = By.id("modal-complete-prompt-yes");
    private final By BackButtonTask = By.xpath("(//input[@value='Back'])[1]");
    private final By EditButton = By.xpath("//*[@value=\"Edit\"]");

    //LED Link TO Asset
    private final By AssetTabInLED = By.xpath("//*[@id=\"led-asset-tab-href\"]");
    private final By FacilityTabInLED = By.xpath("//*[@id=\"led-exposure-tab-href\"]");
    private final By AttachAsset = By.xpath("//a[contains(text(),'Attach Asset')]");
    private final By LinkToExisting = By.xpath("//*[@id=\"search.option\"]");
    private final By NextButton = By.xpath("//*[@value=\"Next\"]");
    private final By NextButton2 = By.xpath("(//*[@value=\"Next\"])[2]");
    private final By FindEntitiesWith = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By SearchButtonLEDAsset = By.xpath("//*[@id=\"ledAssetElasticSearch\"]");
    private final By StatusLEDAssetLink = By.xpath("//*[@id=\"select2-typeahead-select-ledAsset-statusCd-container\"]");
    private final By PariPassuLEDAsset = By.xpath("//*[@id=\"dropdown-ledAsset-paripassuYn\"]");
    private final By RankLEDAsset = By.xpath("//*[@id=\"ledAsset-rank-id\"]");
    private final By Finish = By.xpath("//*[@value=\"Finish\"]");

    //LED Link To Application
    private final By ApplicationTabInLED = By.xpath("//*[@id=\"led-collection-tab-href\"]");
    private final By AttachApplication = By.xpath("//a[contains(text(),'Attach Application')]");
    private final By SearchButtonLEDApplication = By.xpath("//*[@id=\"ledCollectionElasticSearch\"]");
    private final By StatusLEDApplication = By.xpath("//*[@id=\"select2-typeahead-select-ledCollection-statusCd-container\"]");

    //Eligibility
    private final By Ineligible = By.xpath("//*[@id=\"ineligible-btn\"]/span");
    private final By Eligible = By.xpath("//*[@id=\"eligible-btn\"]/span");
    private final By EligibilityClose = By.xpath("//div[@class='jconfirm-closeIcon']");
    private final By ANZxLEDHeldPendingPerfectionHeldrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx LED Held Pending Perfection / Held rule.')]//parent::tr//td[4]//i");
    private final By ANZxLEDDataFilterrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx LED Data Filter rule.')]//parent::tr//td[4]//i");
    private final By ANZxLEDFacilityrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx LED Facility rule.')]//parent::tr//td[4]//i");
    private final By ANZxLEDFacilityApplicationrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx LED Facility / Application rule.')]//parent::tr//td[4]//i");
    private final By ANZxFacilityLegalEntityrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Facility / Legal Entity rule.')]//parent::tr//td[4]//i");
    private final By ANZxLEDAssetHeldPendingPerfectionruleANZxLEDAssetHeldrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx LED Asset \"Held Pending Perfection\" rule / ANZx LED Asset \"Held\" rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetLegalEntityrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset / Legal Entity rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetmusthaveanaddress = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset must have an address.')]//parent::tr//td[4]//i");
    private final By ANZxAssetmusthaveavaluation = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset must have a valuation.')]//parent::tr//td[4]//i");
    private final By ANZxLEDApplicationrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx LED Application rule.')]//parent::tr//td[4]//i");
    private final By ANZxApplicationLetterofOfferrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Application Letter of Offer rule.')]//parent::tr//td[4]//i");
    private final By ANZxApplicationLegalEntityrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Application / Legal Entity rule.')]//parent::tr//td[4]//i");
    private final By ANZxApplicationAssetrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Application / Asset rule.')]//parent::tr//td[4]//i");

    //Link Document to LED
    private final By DocumentSetTab = By.xpath("//*[@id=\"folder-tab-href\"]");
    private final By AddDocumentSetTabButton = By.xpath("//*[@id=\"folder-type-search-add-folder-id-id\"]");
    private final By DescriptionInDocs = By.xpath("//*[@id=\"folder-folderDesc-id\"]");

    //endregion LED

    //region Guarantees Xpath
    private final By LimitType = By.xpath("//*[@id=\"select2-typeahead-select-ledGuarantee-guaranteeLimitCd-container\"]");
    private final By LimitedTo = By.xpath("//*[@id=\"select2-typeahead-select-ledGuarantee-guaranteeRecourseCd-container\"]");
    private final By AmountGuarantee = By.xpath("//*[@id=\"ledGuarantee-maxAmt-id\"]");
    private final By PercentageOf = By.xpath("//*[@id=\"select2-typeahead-select-ledGuarantee-percentOfCd-container\"]");
    private final By Percentage = By.xpath("//*[@id=\"ledGuarantee-percentage-id\"]");
    private final By ReleaseDate = By.xpath("//*[@id=\"ledGuarantee-releaseDate-id\"]");
    private final By DurationType = By.xpath("//*[@id=\"select2-typeahead-select-ledGuarantee-durationTypeCd-container\"]");
    private final By ExpiryDateGuarantee = By.xpath("//*[@id=\"ledGuarantee-expiryDate-id\"]");
    private final By DetailsTabGuarantee = By.xpath("//*[@id=\"ledGuarantee-addtnInfo-id\"]");
    //endregion Guarantees Xpath


    //region Guarantees Creation

    /**
     *Description: LED Guarantees Creation
     * @return
     */
    public void LEDGuaranteesCreation(String GuaranteeType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String SubTypeOption, String LimitTypeOption, String LimitedToOption,
                            String RegistrationNumberOption, String Bank,
                            String CurrencyOption, String AmountOption, String PercentageOfOption, String PercentageOption, String DocumentDateOption, String ReleaseDateOption, String DurationTypeOption,
                            String ExpiryDateOption, String DetailsTabOption, String ReportingCodeFourOption, String ExtraOption1, String ExtraOption2, String ExtraOption3,
                            String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11,
                            String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18,
                            String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {

        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(AddToForm);
        driver.findElement(AddToForm).click();
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if (SourceTypeOption == "") {
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        } else {
            CommonForAll.SendKeys(ID, IDString);
        }

       if(GuaranteeType == "Corporate Guarantee and Indemnity")
        {



            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(SubType, SubTypeOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(LimitType, LimitTypeOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(LimitedTo, LimitedToOption);
            CommonForAll.SendKeys(RegistrationNumber, RegistrationNumberOption);
            SelectBank(Bank);
            CommonForAll.ClickAndSelectByLiWithoutScroll(Currency, CurrencyOption);
            CommonForAll.SendKeys(AmountGuarantee, AmountOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PercentageOf, PercentageOfOption);
            CommonForAll.SendKeys(Percentage, PercentageOption);
            CommonForAll.SendKeys(DocumentDate, DocumentDateOption);
            CommonForAll.SendKeys(ReleaseDate, ReleaseDateOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(DurationType, DurationTypeOption);
            CommonForAll.SendKeys(ExpiryDateGuarantee, ExpiryDateOption);
            CommonForAll.SendKeys(DetailsTabGuarantee, DetailsTabOption);
        }

    }

    /**
     *Description: LED Guarantees Creation Onboarding
     * @return
     */
    public void LEDGuaranteesCreationOnboarding(String GuaranteeType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String SubTypeOption, String LimitTypeOption, String LimitedToOption,
                                      String RegistrationNumberOption, String Bank,
                                      String CurrencyOption, String AmountOption, String PercentageOfOption, String PercentageOption, String DocumentDateOption, String ReleaseDateOption, String DurationTypeOption,
                                      String ExpiryDateOption, String DetailsTabOption, String ReportingCodeFourOption, String ExtraOption1, String ExtraOption2, String ExtraOption3,
                                      String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11,
                                      String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18,
                                      String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {

        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if (SourceTypeOption == "") {
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        } else {
            CommonForAll.SendKeys(ID, IDString);
        }

        if(GuaranteeType == "Corporate Guarantee and Indemnity")
        {

            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            if(SubTypeOption == "") {

            }
            else {
                CommonForAll.ClickAndSelectByLiWithoutScroll(SubType, SubTypeOption);
            }
            CommonForAll.ClickAndSelectByLiWithoutScroll(LimitType, LimitTypeOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(LimitedTo, LimitedToOption);
            CommonForAll.SendKeys(RegistrationNumber, RegistrationNumberOption);
            SelectBank(Bank);
            CommonForAll.ClickAndSelectByLiWithoutScroll(Currency, CurrencyOption);
            CommonForAll.SendKeys(AmountGuarantee, AmountOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PercentageOf, PercentageOfOption);
            CommonForAll.SendKeys(Percentage, PercentageOption);
            CommonForAll.SendKeys(DocumentDate, DocumentDateOption);
            CommonForAll.SendKeys(ReleaseDate, ReleaseDateOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(DurationType, DurationTypeOption);
            CommonForAll.SendKeys(ExpiryDateGuarantee, ExpiryDateOption);
            CommonForAll.SendKeys(DetailsTabGuarantee, DetailsTabOption);
        }

    }

    //endregion Guarantees Creation

    //region LED Creation

    /**
     *Description: LED Creation
     * @return
     */
    public void LEDCreation(String LEDType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String SubTypeOption, String CurrencyOption, String AmountOption, String DocumentDateOption, String ExpiryDateOption, String RegistrationRequiredOption, String RegistrationNumberOption, String Bank, String BusinessSegmentOption, String RelationshipManagerSetPrimaryOption, String RelationshipManagerSetOtherOption, String ReportingCodeThreeOption, String ReportingCodeFourOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(AddToForm);
        driver.findElement(AddToForm).click();
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if (SourceTypeOption == "") {
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        } else {
            CommonForAll.SendKeys(ID, IDString);
        }

        if (LEDType == "Registered Mortgage")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(SubType, SubTypeOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(Currency, CurrencyOption);
            CommonForAll.SendKeys(Amount, AmountOption);
            CommonForAll.Click(DocumentDate);
            CommonForAll.SendKeys(DocumentDate, DocumentDateOption);
            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            CommonForAll.Click(ExpiryDate);
            CommonForAll.SendKeys(ExpiryDate, ExpiryDateOption);
            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            thread.sleep(2000);
            CommonForAll.ClickAndSelectByAForYesAndNo(RegistrationRequired,RegistrationRequiredOption, "1");
            //CommonForAll.SendKeys(RegistrationNumber, RegistrationNumberOption);
            SelectBank(Bank);
            CommonForAll.ClickAndSelectByLiWithoutScroll(BusinessSegment, BusinessSegmentOption);
            CommonForAll.SendKeys(RelationshipManagerSetPrimary, RelationshipManagerSetPrimaryOption);
            CommonForAll.SendKeys(RelationshipManagerSetOther, RelationshipManagerSetOtherOption);
            //CommonForAll.SendKeys(ReportingCodeThree, ReportingCodeThreeOption);
            //CommonForAll.SendKeys(ReportingCodeFour, ReportingCodeFourOption);

        }


    }

    /**
     *Description: LED Creation Onboarding
     * @return
     */
    public void LEDCreationOnboarding(String LEDType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String SubTypeOption, String CurrencyOption, String AmountOption, String DocumentDateOption, String ExpiryDateOption, String RegistrationRequiredOption, String RegistrationNumberOption, String Bank, String BusinessSegmentOption, String RelationshipManagerSetPrimaryOption, String RelationshipManagerSetOtherOption, String ReportingCodeThreeOption, String ReportingCodeFourOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if (SourceTypeOption == "") {
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        } else {
            CommonForAll.SendKeys(ID, IDString);
        }

        if (LEDType == "Registered Mortgage")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(SubType, SubTypeOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(Currency, CurrencyOption);
            CommonForAll.SendKeys(Amount, AmountOption);
            CommonForAll.JavaScriptScrollByPixels(150);
            CommonForAll.Click(DocumentDate);
            CommonForAll.SendKeys(DocumentDate, DocumentDateOption);
            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            CommonForAll.Click(ExpiryDate);
            CommonForAll.SendKeys(ExpiryDate, ExpiryDateOption);
            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            CommonForAll.MouseMoveAndClick(150,150);
            thread.sleep(1000);
            CommonForAll.JavaScriptScrollToBottom();
            CommonForAll.ClickAndSelectByAForYesAndNo(RegistrationRequired,RegistrationRequiredOption, "1");
            //CommonForAll.SendKeys(RegistrationNumber, RegistrationNumberOption);
            CommonForAll.JavaScriptScrollToTop();
            SelectBank(Bank);
            CommonForAll.JavaScriptScrollToBottom();
            CommonForAll.ClickAndSelectByLiWithoutScroll(BusinessSegment, BusinessSegmentOption);
            CommonForAll.SendKeys(RelationshipManagerSetPrimary, RelationshipManagerSetPrimaryOption);
            CommonForAll.SendKeys(RelationshipManagerSetOther, RelationshipManagerSetOtherOption);
            //CommonForAll.SendKeys(ReportingCodeThree, ReportingCodeThreeOption);
            //CommonForAll.SendKeys(ReportingCodeFour, ReportingCodeFourOption);

        }

    }

    /**
     *Description: Add To Form And Select Identified By
     * @return
     */
    public void AddToFormWithIdentifiedBy(String TypeOfLED, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
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
            if (SourceTypeOption == "") {
                isElementLoaded(ID);
                driver.findElement(ID).sendKeys(IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

    }

    /**
     *Description: Select Stats
     * @return
     */
    public void SelectLEDStatus(String StatusOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);

    }


    /**
     *Description: Add To Form Click
     * @return
     */
    public void AddToFormClick() throws InterruptedException
    {
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
     *Description: Remove Compare To
     * @return
     */
    public void RemoveCompareTo() throws InterruptedException
    {
        CommonForAll.Click(RemoveCompareTo);
    }



    /**
     *Description: Select the Bank NEEDED
     */
    public void SelectBank(String Name) throws InterruptedException {
        if (Name == "ANZx") {
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a")).click();
//            thread.sleep(1000);
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
//            thread.sleep(1000);
//            isElementLoaded(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a"));
//            driver.findElement(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a")).click();
//            thread.sleep(1000);
//            isElementLoaded(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a"));
//            driver.findElement(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a")).click();

        }else if (Name == "ANZ") {
            thread.sleep(2000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a")).click();
//            thread.sleep(1000);
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
     *Description: Legal Entity Status Select
     */
    public void StatusSelect(String Option) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status,Option);
    }

    /**
     *Description: Document Date Select
     */
    public void DocumentDate(String Option) throws InterruptedException {
        CommonForAll.SendKeys(DocumentDate,Option);
    }


    /**
     *Description: Add Document Set to LED
     * @return
     */
    public void AddDocumentSetToLED(String DocumentSetDescription, String DescriptionInput, String option1, String option2, String option3, String option4, String option5) throws InterruptedException {
        CommonForAll.Click(DocumentSetTab);
        CommonForAll.Click(AddDocumentSetTabButton);
        driver.findElement(By.xpath("//*[contains(text(),'"+ DocumentSetDescription +"')]")).click();
        CommonForAll.SendKeys(DescriptionInDocs, DescriptionInput);
        Save1();
    }

    /**
     *Description: Add ANZx or other Bank Specifically in Data Filters
     */
    public void AddSpecificBank(String DataFiltersOption) throws InterruptedException, AWTException {
        CommonForAll.Click(DataFilters);
        CommonForAll.Click(Amount);
        CommonForAll.Click(DataFilters);
        CommonForAll.Click(DataFilters);
        thread.sleep(1000);
        //driver.findElement(By.xpath("//*[contains(text(), '"+ DataFiltersOption +"')]//parent::li//a")).click();
        CommonForAll.Click(By.xpath("//*[@data-option-array-index=\"7\"]"));
    }

    //endregion LED Creation

    //region LED Linking

    /**
     *Description: LED Individual Status Verify from details page
     */
    public void LEDIndividualStatusVerify(String StatusNeeded) throws InterruptedException {
        CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), StatusNeeded);
    }


    /**
     *Description: LED - xxx Link Verification , Check if the link status is what that is given in Status needed parameter
     */
    public void LEDToXXXLinkStatusVerification(String LEDLinkTo, String StatusNeeded) throws InterruptedException {
        if(LEDLinkTo == "Facility")
        {
            thread.sleep(500);
            CommonForAll.isElementLoaded(By.xpath("//table[@id=\"led-exposure-table\"]//tbody//tr//td[4]//span[1]"));
            CommonForAll.AssertIfTextPresentOnPageByLocatorGetAttribute(By.xpath("//table[@id=\"led-exposure-table\"]//tbody//tr//td[4]//span[1]"), StatusNeeded);
//            String Status = driver.findElement(By.xpath("//table[@id=\"led-exposure-table\"]//tbody//tr//td[4]//span[1]")).getText().trim();
//            Assert.assertEquals(Status, StatusNeeded);
        }
        else if(LEDLinkTo == "Legal Entity")
        {
            thread.sleep(500);
            CommonForAll.isElementLoaded(By.xpath("//table[@id=\"ledLinkLegalEntity\"]//tbody//tr//td[3]//span[1]"));
            CommonForAll.AssertIfTextPresentOnPageByLocatorGetAttribute(By.xpath("//table[@id=\"ledLinkLegalEntity\"]//tbody//tr//td[3]//span[1]"), StatusNeeded);

        }
        else if(LEDLinkTo == "Asset")
        {
            thread.sleep(500);
            CommonForAll.isElementLoaded(By.xpath("//table[@id=\"led-asset-table\"]//tbody//tr//td[4]//span[1]"));
            CommonForAll.AssertIfTextPresentOnPageByLocatorGetAttribute(By.xpath("//table[@id=\"led-asset-table\"]//tbody//tr//td[4]//span[1]"), StatusNeeded);
        }
        else if(LEDLinkTo == "")
        {}
        else if(LEDLinkTo == "")
        {}
    }

    /**
     *Description: Legal Entity Tab in LED
     */
    public void LegalEntityClick() throws InterruptedException {
        CommonForAll.Click(LegalEntityTab);
    }

    /**
     *Description: Details Tab
     */
    public void DetailsTabClick() throws InterruptedException {
        CommonForAll.Click(DetailsTab);
    }

    /**
     *Description: Asset Tab in LED
     */
    public void AssetTabClick() throws InterruptedException {
        CommonForAll.Click(AssetTabInLED);
    }

    /**
     *Description: Facility Tab in LED
     */
    public void FacilityTabClick() throws InterruptedException {
        CommonForAll.Click(FacilityTabInLED);
    }

    /**
     *Description: LED-Asset Status Capture
     * @return
     */
    public java.util.List<String> CollateralAssetStatusCapture(int TotalNumberOfColumns) throws InterruptedException {
        List<String> CollateralAssetStatus = new ArrayList<>();
        CommonForAll.turnOffImplicitWaits();

        for (int i = 1; i <= TotalNumberOfColumns; i++)
        {
            thread.sleep(400);
            try
            {
                String Status = driver.findElement(By.xpath("(//table[@id=\"led-asset-table\"]//tbody//tr//td[4]//span)[" + i + "]")).getText().trim();
                CollateralAssetStatus.add("Collateral-Asset");
                CollateralAssetStatus.add(Status);
            }
            catch(NoSuchElementException e){}

        }
        CommonForAll.turnOnImplicitWaits();
        return CollateralAssetStatus;
    }

    /**
     *Description: Open Asset in Collateral
     * @return
     */
    public void OpenAssetInLED(int TotalNumberOfColumns) throws InterruptedException {

        try {
            thread.sleep(500);
            CommonForAll.Click(By.xpath("((//h4[normalize-space(text())='Linked Assets']//parent::div//parent::div)//div[5]//div//div//table//tbody//tr//td[2]//a)[" + TotalNumberOfColumns + "]"));
        }
        catch (NoSuchElementException e){ }
    }

    /**
     *Description: LED link to Asset
     * @return
     */
    public void LEDLinkToAsset(String CreateOrLink, String SearchAssetID, String StatusOption, String PariPassuLEDAssetOption, String RankLEDAssetOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.Click(AssetTabInLED);
        CommonForAll.Click(AttachAsset);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchAssetID);
            CommonForAll.Click(SearchButtonLEDAsset);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchAssetID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLEDAssetLink, StatusOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(PariPassuLEDAsset, PariPassuLEDAssetOption, "1");
            CommonForAll.SendKeys(RankLEDAsset, RankLEDAssetOption);
            CommonForAll.Click(Finish);
        } else {

        }

    }

    /**
     *Description: LED link to Application
     * @return
     */
    public void LinkLEDToApplication(String CreateOrLink, String SearchAssetID, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.Click(ApplicationTabInLED);
        CommonForAll.Click(AttachApplication);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchAssetID);
            CommonForAll.Click(SearchButtonLEDApplication);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchAssetID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLEDApplication, StatusOption);
            CommonForAll.Click(Finish);
        } else {

        }

    }

    /**
     *Description:Edit Click
     */
    public void EditClick() throws InterruptedException {
        CommonForAll.Click(EditButton);
    }

    /**
     *Description:Expiry Date
     */
    public void ExpiryDate(String ExpiryDateOption) throws InterruptedException {
        CommonForAll.SendKeys(ExpiryDate,ExpiryDateOption);
    }

    //endregion LED Linking

    //region Task Creation

    /**
     *Description: Task Tab: Task  Creation
     */
    public void TaskTabCreation(String Description, String TypeInput, String PriorityInput, String StatusInput, String StartDateInput, String DueDateInput, String GroupInput, String AssigneeInput) throws InterruptedException, AWTException {

        CommonForAll.Click(TaskTab);
        CommonForAll.Click(NewTask);
        CommonForAll.SendKeys(DescriptionTaskTab, Description);
        CommonForAll.ClickAndSelectByLiWithoutScroll(TypeTaskTab, TypeInput);
        CommonForAll.ClickAndSelectByLiWithoutScroll(PriorityTaskTab, PriorityInput);
        CommonForAll.ClickAndSelectByLiWithoutScroll(StatusTaskTab, StatusInput);
        CommonForAll.SendKeys(StartDate, StartDateInput);
        CommonForAll.SendKeys(DueDateTaskTab, DueDateInput);
        CommonForAll.MouseMoveAndClick(250, 250);
        thread.sleep(300);
        CommonForAll.ClickAndSelectByLiWithoutScroll(GroupTaskTab, GroupInput);
        driver.findElement(AssigneeTaskTab).click();
        thread.sleep(100);
        driver.findElement(AssigneeTypeahead).sendKeys(AssigneeInput);
        thread.sleep(100);
        if(AssigneeInput.equalsIgnoreCase(""))
        {

        }
        else
        {
            CommonForAll.turnOffImplicitWaits();
            thread.sleep(1000);
            CommonForAll.Click(By.xpath("//li[contains(text(), '"+ AssigneeInput +"')])"));
        }
        CommonForAll.turnOnImplicitWaits();
        driver.findElement(Save2).click();
        thread.sleep(300);
    }

    /**
     *Description: Action Check Box First Click
     */
    public void ActionCheckBoxFirstClick() throws InterruptedException {
        thread.sleep(1000);
        CommonForAll.JavaScriptScrollAndClick(ActionCompleteCheckBox);
        //driver.findElement(ActionCompleteCheckBox).click();
        Thread.sleep(3000);
        CommonForAll.JavaScriptScrollAndClick(YesPrompt);
    }

    /**
     *Description: Action Check Box After First Click
     */
    public void ActionCheckBoxAfterFirstClick(String CheckboxPosition) throws InterruptedException {
        thread.sleep(1000);
        CommonForAll.Click(By.xpath("(//input[@name='taskResolution'])["+ CheckboxPosition +"]"));
    }

    /**
     *Description: Action Check Box Last Click
     */
    public void ActionCheckBoxLastClick() throws InterruptedException {
        thread.sleep(1000);
        CommonForAll.JavaScriptScrollAndClick(By.xpath("(//input[@name='taskResolution'])[last()]"));
        //driver.findElement(ActionCompleteCheckBox).click();
        Thread.sleep(3000);
        CommonForAll.turnOffImplicitWaits();
        try {
            CommonForAll.turnOffImplicitWaits();
            isElementLoaded(YesPrompt);
            CommonForAll.JavaScriptScrollAndClick(YesPrompt);
        }
        catch(NoSuchElementException | TimeoutException e)
        {
            CommonForAll.turnOnImplicitWaits();
        }
    }


    /**
     *Description: BackButton
     */
    public void BackButton() throws InterruptedException {
        CommonForAll.JavaScriptScroll(By.id("tasks-tab-background"));
        CommonForAll.JavaScriptScrollAndClick(BackButtonTask);
    }

    /**
     *Description: BackButton 2
     */
    public void BackButton2() throws InterruptedException {
        CommonForAll.JavaScriptScrollAndClick(BackButtonTask);
    }

    //endregion Task Creation


    //region Eligibility

    /**
     *Description: Ineligible Click
     */
    public void IneligibleClick() throws InterruptedException {
        thread.sleep(400);
        CommonForAll.Click(Ineligible);

        //CommonSBSA.GetAttributeAndPresentOnScreen("","","");
    }

    /**
     *Description: Eligible Click
     */
    public void EligibleClick() throws InterruptedException {
        thread.sleep(400);
        CommonForAll.Click(Eligible);

        //CommonSBSA.GetAttributeAndPresentOnScreen("","","");
    }

    /**
     *Description: Eligibility Close
     */
    public void EligibilityClose() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(EligibilityClose).click();
        Thread.sleep(500);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx LED Held Pending Perfection / Held rule.
     */
    public void GetAttributePassFailForANZxLEDHeldPendingPerfectionHeldRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxLEDHeldPendingPerfectionHeldrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx LED Data Filter rule
     */
    public void GetAttributePassFailForANZxLEDDataFilterrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxLEDDataFilterrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx LED Facility rule.
     */
    public void GetAttributePassFailForANZxLEDFacilityrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxLEDFacilityrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx LED Facility / Application rule.
     */
    public void GetAttributePassFailForANZxLEDFacilityApplicationrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxLEDFacilityApplicationrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Facility / Legal Entity rule.
     */
    public void GetAttributePassFailForANZxFacilityLegalEntityrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxFacilityLegalEntityrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx LED Asset "Held Pending Perfection" rule / ANZx LED Asset "Held" rule.
     */
    public void GetAttributePassFailForANZxLEDAssetHeldPendingPerfectionruleANZxLEDAssetHeldrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxLEDAssetHeldPendingPerfectionruleANZxLEDAssetHeldrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Asset / Legal Entity rule.
     */
    public void GetAttributePassFailForANZxAssetLegalEntityrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetLegalEntityrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Asset must have an address.
     */
    public void GetAttributePassFailForANZxAssetmusthaveanaddress(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetmusthaveanaddress,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Asset must have a valuation.
     */
    public void GetAttributePassFailForANZxAssetmusthaveavaluation(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetmusthaveavaluation,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx LED Application rule.
     */
    public void GetAttributePassFailForANZxLEDApplicationrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxLEDApplicationrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Application Letter of Offer rule.
     */
    public void GetAttributePassFailForANZxApplicationLetterofOfferrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxApplicationLetterofOfferrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Application / Legal Entity rule.
     */
    public void GetAttributePassFailForANZxApplicationLegalEntityrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxApplicationLegalEntityrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute Pass/FAIL for ANZx Application / Asset rule.
     */
    public void GetAttributePassFailForANZxApplicationAssetrule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxApplicationAssetrule,"class",TextToCheck);
    }

    //endregion Eligibility


}



