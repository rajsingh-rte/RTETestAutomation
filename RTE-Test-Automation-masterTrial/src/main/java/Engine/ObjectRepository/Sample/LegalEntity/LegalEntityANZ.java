package Engine.ObjectRepository.Sample.LegalEntity;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Created by Raj
 */
public class LegalEntityANZ extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //public CommonForAll CommonForAll = new CommonForAll(driver);;
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public LegalEntityANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region Legal Entity Creation
    //Legal entity Juristic
    private final By AddToForm = By.id("compext-add");
    private final By RemoveFromForm = By.id("compext-remove");
    private final By RemoveStatus = By.xpath("//*[@id=\"select2-typeahead-select-legalEntity-statusCd-container\"]/span");
    private final By SourceType = By.id("select2-typeahead-select-externalSourceCd-container");
    private final By ID = By.xpath("//*[@id=\"externalReference_externalIdFields_0__value\"]");
    private final By ID2 = By.xpath("//*[@id=\"externalReference_externalIdFields_1__value\"]");
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By IDTabPath = By.xpath("//*[@id=\"external-reference-tab-href\"]");
    private final By Save2 = By.xpath("(//input[@value=\"Save\"])[2]");
    private final By OrganisationDesc = By.xpath("//*[@id='legalEntity-organisationDesc-id']");
    private final By LegalRegisteredName = By.xpath("//*[@id=\"legalEntity-legalName-id\"]");
    private final By TradingAs = By.xpath("//*[@id='legalEntity-tradingAs-id']");
    private final By Status = By.xpath("//*[@id=\"select2-typeahead-select-legalEntity-statusCd-container\"]");
    private final By LegalEntitySubType= By.xpath("//*[@id=\"select2-typeahead-select-legalEntity-legalEntitySubtypeCd-container\"]");
    private final By SourceSystemStatus= By.xpath("//*[@id='select2-typeahead-select-legalEntity-csdListLeCd-container']");
    //Linking Legal Entity to Application
    private final By Details= By.xpath("//button[contains(text(),'Details')]");
    private final By ApplicationTabInLE = By.xpath("//*[@id=\"legal-entity-collection-tab-href\"]");
    private final By AttachApplicationButton = By.xpath("//a[contains(text(),'Attach Application')]");
    private final By LinkToExisting = By.xpath("//*[@id=\"search.option\"]");
    private final By NextButton = By.xpath("//*[@value=\"Next\"]");
    private final By NextButton2 = By.xpath("(//*[@value=\"Next\"])[2]");
    private final By FindEntitiesWith = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By SearchButtonWhileLinking = By.xpath("//*[@id=\"unified-search-panel-panel-id\"]//div//div[2]");
    private final By SearchButtonWhileLinkingByLastElement = By.xpath("(//*[@id=\"unified-search-panel-panel-id\"]//div//div)[last()]");
    private final By RoleLegalEntityApplicationLink = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityCollection-roleCd-container\"]");
    private final By StatusLegalEntityApplicationLink = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityCollection-statusCd-container\"]");
    private final By Finish = By.xpath("//*[@value=\"Finish\"]");
    //Link Legal Entity to Asset
    private final By AssetTabInLE = By.xpath("//*[@id=\"legal-entity-asset-tab-href\"]");
    private final By AttachAssetButton = By.xpath("//a[contains(text(),'Attach Asset')]");
    private final By RoleLegalEntityAssetLink = By.xpath("//*[@id=\"select2-typeahead-select-assetLegalEntity-roleCd-container\"]");
    private final By StatusLegalEntityAssetLink = By.xpath("//*[@id=\"select2-typeahead-select-assetLegalEntity-statusCd-container\"]");
    //Link Legal Entity to Facility
    private final By FacilityTabInLE = By.xpath("//*[@id=\"legal-entity-tab-href\"]");
    private final By AttachFacilityButton = By.xpath("//a[contains(text(),'Attach Facility')]");
    private final By PrimaryBorrowerLegalEntityFacilityAndExposure = By.xpath("//*[@id=\"dropdown-legalEntityExposure-isPrimary\"]");
    private final By StatusLegalEntityFacilityAndExposure = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityExposure-statusCd-container\"]");
    //Link Legal Entity to LED
    private final By LEDTabInLE = By.xpath("//*[@id=\"legal-entity-led-tab-href\"]");
    private final By AttachLEDButton = By.xpath("//a[contains(text(),'Attach LED')]");
    private final By RoleLegalEntityLED = By.xpath("//*[@id=\"select2-typeahead-select-ledLegalEntity-roleCd-container\"]");
    private final By StatusLegalEntityLED = By.xpath("//*[@id=\"select2-typeahead-select-ledLegalEntity-statusCd-container\"]");
    private final By ExternalCode1 = By.xpath("//*[@id=\"ledLegalEntity-externalCd1-id\"]");
    private final By ExternalCode2 = By.xpath("//*[@id=\"ledLegalEntity-externalCd2-id\"]");
    private final By ExternalCode3 = By.xpath("//*[@id=\"ledLegalEntity-externalCd3-id\"]");
    private final By ExternalCode4 = By.xpath("//*[@id=\"ledLegalEntity-externalCd4-id\"]");

    //Link Legal Entity to General Insurance
    private final By GeneralInsuranceTabInLE = By.xpath("//*[@id=\"legal-entity-general-insurance-tab-href\"]");
    private final By AttachGeneralInsuranceButton = By.xpath("//a[contains(text(),'Attach General Insurance')]");
    private final By RoleLegalEntityGI = By.xpath("//*[@id=\"select2-typeahead-select-generalInsuranceLegalEntity-roleCd-container\"]");
    private final By StatusLegalEntityGI = By.xpath("//*[@id=\"select2-typeahead-select-generalInsuranceLegalEntity-statusCd-container\"]");


    //Legal Entity Personal
    private final By Title = By.xpath("//*[@id=\"select2-typeahead-select-legalEntity-title-container\"]");
    private final By FirstName = By.xpath("//*[@id=\"legalEntity-firstName-id\"]");
    private final By MiddleName= By.xpath("//*[@id=\"legalEntity-firstName2-id\"]");
    private final By Surname = By.xpath("//*[@id=\"legalEntity-surname-id\"]");
    private final By ExternalCreditCheck = By.xpath("//*[@id=\"dropdown-legalEntityP-ExtCreditCheck-udf\"]");
    private final By KYCStatus= By.xpath("//*[@id=\"legalEntityP-kycStatus-id\"]");
    private final By KYCVerificationLevel= By.xpath("//*[@id=\"legalEntityP-kycVerLevel-id\"]");
    private final By ANZSICCode= By.xpath("//*[@id=\"legalEntityP-anzsicCode-id\"]");
    private final By CustomerCreditRating= By.xpath("//*[@id=\"legalEntityP-custCreditRating-id\"]");
    private final By DeceasedDate = By.xpath("//*[@id=\"legalEntityP-deceasedDate-id\"]");
    private final By ClickCustom = By.xpath("//*[@id=\"legalEntityP-deceasedDate-id\"]");
    //Legal Entity Service Provider




    //region Legal Entity Creation

    /**
     *Description: Legal Entity Service Provider All Fields
     * @return
     */
    public void LegalEntityServiceProviderCreate(String LEType, String SourceTypeOption, String IDString, String ID2String, String OrganisationDescInput, String LegalRegisteredNameInput, String TradingAsInout, String StatusOption, String Bank, String LegalEntitySubTypeOption, String SourceSystemStatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17, String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException {
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
            if (SourceTypeOption == "CIS Number") {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

        //CommonForAll.SendKeys(OrganisationDesc, OrganisationDescInput);
        CommonForAll.SendKeys(LegalRegisteredName, LegalRegisteredNameInput);
        CommonForAll.SendKeys(TradingAs, TradingAsInout);
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
        SelectBank(Bank);
        CommonForAll.ClickAndSelectByLiWithoutScroll(LegalEntitySubType, LegalEntitySubTypeOption);
        //CommonForAll.ClickAndSelectByLiWithoutScroll(SourceSystemStatus, SourceSystemStatusOption);
    }

    /**
     *Description: Legal Personal All Fields
     * @return
     */
    public void LegalEntityPersonalCreate(String LEType, String SourceTypeOption, String IDString, String ID2String, String TitleInput, String FirstNameInput, String MiddleNameInput, String SurnameInput, String StatusOption, String Bank, String LegalEntitySubTypeOption, String ExternalCreditCheckOption, String KYCStatusInput, String KYCVerificationLevelOption, String ANZSICCodeOption, String CustomerCreditRatingOption, String SourceSystemStatusOption, String DeceasedDateOption, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17, String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException {
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
            if (SourceTypeOption == "CIS Number") {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

        CommonForAll.ClickAndSelectByLiWithoutScroll(Title, TitleInput);
        CommonForAll.SendKeys(FirstName, FirstNameInput);
        CommonForAll.SendKeys(MiddleName, MiddleNameInput);
        CommonForAll.SendKeys(Surname, SurnameInput);
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
        SelectBank(Bank);
        CommonForAll.ClickAndSelectByLiWithoutScroll(LegalEntitySubType, LegalEntitySubTypeOption);
        //CommonForAll.ClickAndSelectByAForYesAndNo(ExternalCreditCheck, ExternalCreditCheckOption, "1");
        CommonForAll.SendKeys(KYCStatus, KYCStatusInput);
        //CommonForAll.SendKeys(KYCVerificationLevel, KYCVerificationLevelOption);
        //CommonForAll.SendKeys(ANZSICCode, ANZSICCodeOption);
        //CommonForAll.SendKeys(CustomerCreditRating, CustomerCreditRatingOption);
        CommonForAll.SendKeys(DeceasedDate, DeceasedDateOption);

        //CommonForAll.ClickAndSelectByLiWithoutScroll(SourceSystemStatus, SourceSystemStatusOption);
    }

    /**
     *Description: Legal Juristic All Fields
     * @return
     */
    public void LegalEntityJuristicCreate(String LEType, String SourceTypeOption, String IDString, String ID2String, String OrganisationDescInput, String LegalRegisteredNameInput, String TradingAsInout, String StatusOption, String Bank, String LegalEntitySubTypeOption, String SourceSystemStatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17, String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException {
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
            if (SourceTypeOption == "CIS Number") {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

        //CommonForAll.SendKeys(OrganisationDesc, OrganisationDescInput);
        CommonForAll.SendKeys(LegalRegisteredName, LegalRegisteredNameInput);
        CommonForAll.SendKeys(TradingAs, TradingAsInout);
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
        SelectBank(Bank);
        CommonForAll.ClickAndSelectByLiWithoutScroll(LegalEntitySubType, LegalEntitySubTypeOption);
        //CommonForAll.ClickAndSelectByLiWithoutScroll(SourceSystemStatus, SourceSystemStatusOption);



    }

    /**
     *Description: Add To Form And Select Identified By
     * @return
     */
    public void AddToFormWithIdentifiedBy(String LEType, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
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
            if (SourceTypeOption == "CIS Number") {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

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
     *Description: Select the Bank NEEDED
     */
    public void SelectBank(String Name) throws InterruptedException {
        if (Name == "ANZx") {
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a")).click();
            thread.sleep(1000);


        }else if(Name == "") {
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a")).click();
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZ')]//parent::li//a")).click();
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a")).click();
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a")).click();

            }
        thread.sleep(500);
    }

    /**
     *Description: Save
     * @return
     */
    public void Save1() throws InterruptedException {
        CommonForAll.JavaScriptScrollToTop();
        thread.sleep(300);
        CommonForAll.Click(Save1);
    }

    /**
     *Description: ID Tab
     * @return
     */
    public void IDTab() throws InterruptedException {
        thread.sleep(300);
        CommonForAll.Click(IDTabPath);
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

    //endregion Legal Entity Creation

    //region Legal Entity Linking

    /**
     *Description: Legal Entity Juristic Link to Application
     * @return
     */
    public void LegalEntityLinkToApplication(String CreateOrLink, String SearchDealID, String RoleOption, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {

        CommonForAll.Click(Details);
        CommonForAll.Click(ApplicationTabInLE);
        CommonForAll.Click(AttachApplicationButton);
        if(CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchDealID);
            CommonForAll.Click(SearchButtonWhileLinking);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchDealID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(RoleLegalEntityApplicationLink,RoleOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLegalEntityApplicationLink, StatusOption);
            CommonForAll.Click(Finish);
        }
        else
        {

        }

    }

    /**
     *Description: Legal Entity Juristic Link to Asset
     * @return
     */
    public void LegalEntityLinkToAsset(String CreateOrLink, String SearchDealID, String RoleOption, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {

        CommonForAll.Click(Details);
        CommonForAll.Click(AssetTabInLE);
        CommonForAll.Click(AttachAssetButton);
        if(CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchDealID);
            CommonForAll.Click(SearchButtonWhileLinkingByLastElement);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchDealID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(RoleLegalEntityAssetLink,RoleOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLegalEntityAssetLink, StatusOption);
            CommonForAll.Click(Finish);
        }
        else
        {

        }

    }

    /**
     *Description: Legal Entity Juristic Link to Facility
     * @return
     */
    public void LegalEntityLinkToFacility(String CreateOrLink, String SearchDealID, String PrimaryBorrowerOption, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {

        CommonForAll.Click(Details);
        CommonForAll.Click(FacilityTabInLE);
        CommonForAll.Click(AttachFacilityButton);
        if(CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchDealID);
            CommonForAll.Click(SearchButtonWhileLinkingByLastElement);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchDealID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByAForYesAndNo(PrimaryBorrowerLegalEntityFacilityAndExposure, PrimaryBorrowerOption,"1");
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLegalEntityFacilityAndExposure, StatusOption);
            CommonForAll.Click(Finish);
        }
        else
        {

        }

    }

    /**
     *Description: Legal Entity Juristic Link to LED
     * @return
     */
    public void LegalEntityLinkToLED(String CreateOrLink, String SearchDealID, String RoleOption, String StatusOption, String ExternalCode1Option, String ExternalCode2Option, String ExternalCode3Option, String ExternalCode4Option, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {

        CommonForAll.Click(Details);
        CommonForAll.Click(LEDTabInLE);
        CommonForAll.Click(AttachLEDButton);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchDealID);
            CommonForAll.Click(SearchButtonWhileLinkingByLastElement);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchDealID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(RoleLegalEntityLED, RoleOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLegalEntityLED, StatusOption);
            CommonForAll.SendKeys(ExternalCode1, ExternalCode1Option);
            CommonForAll.SendKeys(ExternalCode2, ExternalCode2Option);
            CommonForAll.SendKeys(ExternalCode3, ExternalCode3Option);
            CommonForAll.SendKeys(ExternalCode4, ExternalCode4Option);
            CommonForAll.Click(Finish);
        } else {

        }
    }

        /**
         *Description: Legal Entity Juristic Link to General Insurance
         * @return
         */
        public void LegalEntityLinkToGeneralInsurance(String CreateOrLink, String SearchGIID, String RoleOption, String StatusOption, String ExternalCode1Option, String ExternalCode2Option, String ExternalCode3Option, String ExternalCode4Option, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {

            CommonForAll.Click(Details);
            CommonForAll.Click(GeneralInsuranceTabInLE);
            CommonForAll.Click(AttachGeneralInsuranceButton);
            if(CreateOrLink == "Link") {

                CommonForAll.Click(LinkToExisting);
                CommonForAll.Click(NextButton);
                CommonForAll.SendKeys(FindEntitiesWith, SearchGIID);
                CommonForAll.Click(SearchButtonWhileLinkingByLastElement);
                CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchGIID);
                CommonForAll.Click(NextButton2);
                CommonForAll.ClickAndSelectByLiWithoutScroll(RoleLegalEntityGI, RoleOption);
                CommonForAll.ClickAndSelectByLiWithoutScroll(StatusLegalEntityGI, StatusOption);

                CommonForAll.Click(Finish);
            }
            else
            {

            }

    }

    //endregion Legal Entity Linking

}



