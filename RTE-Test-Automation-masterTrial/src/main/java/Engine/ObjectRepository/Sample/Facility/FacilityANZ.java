package Engine.ObjectRepository.Sample.Facility;

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
public class FacilityANZ extends Page {

    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //public CommonForAll CommonForAll = new CommonForAll(driver);;
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public FacilityANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region Facility Create
    //Generic Facility
    private final By AddToForm = By.id("compext-add");
    private final By RemoveFromForm = By.id("compext-remove");
    private final By RemoveStatus = By.xpath("//*[@id=\"select2-typeahead-select-exposure-statusCd-container\"]/span");
    private final By RemoveCompareTo = By.xpath("//*[@id=\"select2-typeahead-select-exposure-compareTo-container\"]/span");
    private final By SourceType = By.id("select2-typeahead-select-externalSourceCd-container");
    private final By ID = By.xpath("//*[@id=\"externalReference_externalIdFields_0__value\"]");
    private final By ID2 = By.xpath("//*[@id=\"externalReference_externalIdFields_1__value\"]");
    private final By ID3 = By.xpath("//*[@id=\"externalReference_externalIdFields_2__value\"]");
    private final By ID4 = By.xpath("//*[@id=\"externalReference_externalIdFields_3__value\"]");
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By Save2 = By.xpath("(//input[@value=\"Save\"])[2]");
    private final By FacilityStatus = By.xpath("//*[@id=\"select2-typeahead-select-exposure-statusCd-container\"]");
    private final By FacilityType= By.xpath("//*[@id=\"select2-typeahead-select-exposure-facTypeCd-container\"]");
    private final By ProductCode= By.xpath("//*[@id=\"select2-typeahead-select-exposure-creditRiskCd-container\"]");
    private final By SubProductCode= By.xpath("//*[@id=\"select2-typeahead-select-exposure-businessCd-container\"]");
    private final By FacilityCurrency= By.xpath("//*[@id=\"select2-typeahead-select-exposure-ccyCd-container\"]");
    private final By FacilityLimit= By.xpath("//*[@id=\"exposure-facilityAmt-id\"]");
    private final By CompareTo= By.xpath("//*[@id=\"select2-typeahead-select-exposure-compareTo-container\"]");
    private final By StartDate= By.xpath("//*[@id=\"exposure-startDate-id\"]");
    private final By MaturityDate= By.xpath("//*[@id=\"exposure-maturityDate-id\"]");
    private final By GenericDropdown = By.xpath("//*[@id=\"select2-typeahead-select-exposure-csdListExpCd-container\"]");
    private final By KeyAdditionalInformation= By.xpath("//*[@id=\"exposure-exposureDetails-id\"]");
    private final By LoanPurposeCode= By.xpath("//*[@id=\"exposure-loanPurposeCode-id\"]");
    private final By CustomerCreditRating= By.xpath("//*[@id=\"exposure-customerCreditRating-id\"]");
    private final By OriginationLVR = By.xpath("//*[@id=\"exposure-originationLVR-id\"]");
    private final By OriginationLVRDate = By.xpath("//*[@id=\"exposure-originationLVRCalcDate-id\"]");
    //endregion Facility Create

    //region Facility Linking
    private final By LinkToExisting = By.xpath("//*[@id=\"search.option\"]");
    private final By NextButton = By.xpath("//*[@value=\"Next\"]");
    private final By Details= By.xpath("//button[contains(text(),'Details')]");
    private final By Edit = By.xpath("//*[@value=\"Edit\"]");
    private final By LEDTabInFacility = By.xpath("//*[@id=\"led-exposure-tab-href\"]");
    private final By AttachLEDButtonInFacility = By.xpath("//a[contains(text(),'Attach LED')]");
    private final By NextButton2 = By.xpath("(//*[@value=\"Next\"])[2]");
    private final By FindEntitiesWith = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By FacilityAndExposureLienSearchButton = By.xpath("//*[@id=\"exposureLedElasticSearch\"]");
    private final By Finish = By.xpath("//*[@value=\"Finish\"]");
    private final By StatusFacilityLien = By.xpath("//*[@id=\"select2-typeahead-select-ledExposure-statusCd-container\"]");
    private final By AbundanceOfCaution = By.xpath("//*[@id=\"dropdown-ledExposure-abundanceOfCautionYn\"]");
    private final By Rank= By.xpath("//*[@id=\"ledExposure-internalRank-id\"]");
    private final By AdvanceRate = By.xpath("//*[@id=\"ledExposure-advanceRate-id\"]");
    private final By CollateralTabInFacility = By.xpath("//*[@id=\"exposure-collateral-tab-href\"]");
    private final By AttachCollateralButtonInFacility = By.xpath("//a[contains(text(),'Attach LED')]");
    private final By ApplicationTabInFacility = By.xpath("//*[@id=\"collection-exposure-tab-href\"]");
    private final By AttachApplicationButtonInFacility = By.xpath("//a[contains(text(),'Attach Application')]");
    private final By StatusFacilityLinkApplication = By.xpath("//*[@id=\"select2-typeahead-select-collectionExposure-statusCd-container\"]");
    private final By FacilityApplicationSearchButton = By.xpath("//*[@id=\"exposureCollectionElasticSearch\"]");
    //endregion Facility


    //region Facility Create

    /**
     *Description: Add To Form And Select Identified By
     * @return
     */
    public void AddToFormWithIdentifiedBy(String TypeOfFacility, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
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
     *Description: Select Stats
     * @return
     */
    public void SelectFacilityStatus(String FacilityStatusOption, String SourceTypeOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
       CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityStatus, FacilityStatusOption);

    }

    /**
     *Description: Select Facility Limit
     * @return
     */
    public void SelectFacilityLimit(String FacilityLimitOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.SendKeys(FacilityLimit, FacilityLimitOption);

    }

    /**
     *Description: Details Button
     * @return
     */
    public void DetailsButton() throws InterruptedException {
        CommonForAll.Click(Details);

    }

    /**
     *Description: Edit Button
     * @return
     */
    public void EditButton() throws InterruptedException {
        CommonForAll.Click(Edit);

    }

    /**
     *Description: Status Select
     *
     */
    public void StatusSelect(String StatusOption) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityStatus,StatusOption);

    }


    /**
     *Description: Facility Creation
     * @return
     */
    public void GenericFacilityCreate(String TypeOfFacility, String SourceTypeOption, String IDString, String ID2String, String AccountName, String FacilityStatusOption, String FacilityTypeOption, String ProductCodeOption, String SubProductCodeOption, String FacilityCurrencyOption, String FacilityLimitOption, String CompareToOption, String StartDateOption, String MaturityDateOption, String Bank, String GenericDropdownOption, String KeyAdditionalInformationOption, String LoanPurposeCodeOption, String CustomerCreditRatingOption, String OriginationLVROption, String OriginationLVRDateOption, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17, String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
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
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else if(SourceTypeOption == "Account Details")
            {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
                CommonForAll.SendKeys(ID3, AccountName);
                CommonForAll.SendKeys(ID4, ID2String);
            }
            else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityStatus, FacilityStatusOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityType, FacilityTypeOption);
        //CommonForAll.ClickAndSelectByLiWithoutScroll(ProductCode, ProductCodeOption);
        //CommonForAll.ClickAndSelectByLiWithoutScroll(SubProductCode, SubProductCodeOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityCurrency, FacilityCurrencyOption);
        CommonForAll.SendKeys(FacilityLimit, FacilityLimitOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(CompareTo, CompareToOption);
        CommonForAll.SendKeys(StartDate, StartDateOption);
        CommonForAll.SendKeys(MaturityDate, MaturityDateOption);
        SelectBank(Bank);
        CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown, GenericDropdownOption);
        CommonForAll.SendKeys(KeyAdditionalInformation, KeyAdditionalInformationOption);
        CommonForAll.SendKeys(LoanPurposeCode, LoanPurposeCodeOption);
        //CommonForAll.SendKeys(CustomerCreditRating, CustomerCreditRatingOption);
        CommonForAll.SendKeys(OriginationLVR, OriginationLVROption);
        CommonForAll.SendKeys(OriginationLVRDate, OriginationLVRDateOption);
        CommonForAll.MouseMoveAndClick(250,250);
    }




    /**
     *Description: Facility Creation Onboarding
     * @return
     */
    public void GenericFacilityCreateOnboarding(String TypeOfFacility, String SourceTypeOption, String IDString, String ID2String, String AccountName, String FacilityStatusOption, String FacilityTypeOption, String ProductCodeOption, String SubProductCodeOption, String FacilityCurrencyOption, String FacilityLimitOption, String CompareToOption, String StartDateOption, String MaturityDateOption, String Bank, String GenericDropdownOption, String KeyAdditionalInformationOption, String LoanPurposeCodeOption, String CustomerCreditRatingOption, String OriginationLVROption, String OriginationLVRDateOption, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17, String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        if(SourceTypeOption == ""){
            ;
        }else {
            isElementLoaded(SourceType);
            driver.findElement(SourceType).click();
            isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
            driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
            if (SourceTypeOption == "") {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
            } else if(SourceTypeOption == "Account Details")
            {
                CommonForAll.SendKeys(ID, IDString);
                CommonForAll.SendKeys(ID2, ID2String);
                CommonForAll.SendKeys(ID3, AccountName);
                CommonForAll.SendKeys(ID4, ID2String);
            }
            else {
                CommonForAll.SendKeys(ID, IDString);
            }
        }

        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityStatus, FacilityStatusOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityType, FacilityTypeOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(ProductCode, ProductCodeOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(SubProductCode, SubProductCodeOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(FacilityCurrency, FacilityCurrencyOption);
        CommonForAll.SendKeys(FacilityLimit, FacilityLimitOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(CompareTo, CompareToOption);
        CommonForAll.SendKeys(StartDate, StartDateOption);
        CommonForAll.SendKeys(MaturityDate, MaturityDateOption);
        SelectBank(Bank);
        CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown, GenericDropdownOption);
        CommonForAll.SendKeys(KeyAdditionalInformation, KeyAdditionalInformationOption);
        CommonForAll.SendKeys(LoanPurposeCode, LoanPurposeCodeOption);
        //CommonForAll.SendKeys(CustomerCreditRating, CustomerCreditRatingOption);
        CommonForAll.SendKeys(OriginationLVR, OriginationLVROption);
        CommonForAll.SendKeys(OriginationLVRDate, OriginationLVRDateOption);
        CommonForAll.MouseMoveAndClick(250,250);
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
     *Description: Save 2
     * @return
     */
    public void Save2() throws InterruptedException {
        CommonForAll.JavaScriptScrollToBottom();
        thread.sleep(300);
        CommonForAll.Click(Save2);
        thread.sleep(300);
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
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'Home Lending')]//parent::li//a")).click();
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'Business Bank')]//parent::li//a")).click();

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

    //endregion Facility Creation

    //region Facility Link

    /**
     *Description: Facility to LED
     * @return
     */
    public void FacilityLinkToLED(String CreateOrLink, String SearchLEDID, String StatusOption, String AbundanceOfCautionOption, String RankOption, String AdvanceRateOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.Click(Details);
        CommonForAll.Click(LEDTabInFacility);
        CommonForAll.Click(AttachLEDButtonInFacility);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchLEDID);
            CommonForAll.Click(FacilityAndExposureLienSearchButton);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchLEDID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusFacilityLien, StatusOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(AbundanceOfCaution, AbundanceOfCautionOption, "1");
            CommonForAll.SendKeys(Rank, RankOption);
            CommonForAll.SendKeys(AdvanceRate, AdvanceRateOption);
            CommonForAll.Click(Finish);
        } else {

        }
    }

        /**
         *Description: Facility to Collateral
         * @return
         */
        public void FacilityLinkToCollateral(String CreateOrLink, String SearchLEDID, String StatusOption, String AbundanceOfCautionOption, String RankOption, String AdvanceRateOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
            CommonForAll.Click(Details);
            CommonForAll.Click(CollateralTabInFacility);
            CommonForAll.Click(AttachCollateralButtonInFacility);
            if (CreateOrLink == "Link") {

                CommonForAll.Click(LinkToExisting);
                CommonForAll.Click(NextButton);
                CommonForAll.SendKeys(FindEntitiesWith, SearchLEDID);
                CommonForAll.Click(FacilityAndExposureLienSearchButton);
                CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchLEDID);
                CommonForAll.Click(NextButton2);
                CommonForAll.ClickAndSelectByLiWithoutScroll(StatusFacilityLien, StatusOption);
                CommonForAll.ClickAndSelectByAForYesAndNo(AbundanceOfCaution, AbundanceOfCautionOption, "1");
                CommonForAll.SendKeys(Rank, RankOption);
                CommonForAll.SendKeys(AdvanceRate, AdvanceRateOption);
                CommonForAll.Click(Finish);
            } else {

            }

    }

    /**
     *Description: Facility to Application
     * @return
     */
    public void FacilityLinkToApplication(String CreateOrLink, String SearchLEDID, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.Click(Details);
        CommonForAll.Click(ApplicationTabInFacility);
        CommonForAll.Click(AttachApplicationButtonInFacility);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchLEDID);
            CommonForAll.Click(FacilityApplicationSearchButton);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchLEDID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusFacilityLinkApplication, StatusOption);
            CommonForAll.Click(Finish);
        } else {

        }

    }


    //endregion Facility Link

}



