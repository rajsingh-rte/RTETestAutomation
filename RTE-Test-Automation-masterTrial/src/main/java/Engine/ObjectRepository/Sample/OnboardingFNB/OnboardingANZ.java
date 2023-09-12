package Engine.ObjectRepository.Sample.OnboardingFNB;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;


/**
 * Created by Raj
 */
public class OnboardingANZ extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //private Engine.ObjectRepository.AIB.CommonAIB.CommonAIB CommonAIB = new CommonAIB(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public OnboardingANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region Onboarding
    //Case or Collection Page
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By Save2 = By.xpath("(//input[@value=\"Save\"])[2]");
    private final By OnboardingTab = By.xpath("//*[@id='collection-onboarding']");
    private final By Role = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityCollection-roleCd-container\"]");
    private final By CustomerType = By.xpath("//*[@id=\"select2-typeahead-select-legalEntity-legalEntityTypeCd-container\"]");
    private final By CreateButton = By.xpath("//*[@id=\"legal-entity-capture-add-new-btn\"]");
    private final By FindCustomers = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By SelectARole = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityCollectionSearch-roleCd-legalEntitySearch-container\"]");
    private final By AddButton = By.xpath("//*[@id=\"link-selected-legal-entities\"]");
    private final By SearchButton = By.xpath("//button[contains(text(), 'Search')]");
    private final By NextButton2 = By.xpath("(//*[@value=\"Next\"])[2]");
    private final By NextButton1 = By.xpath("(//*[@value=\"Next\"])[1]");
    private final By SelectSourceType = By.xpath("(//*[@id=\"select2-typeahead-select-externalReferenceType-container\"])[2]");

    //Loan & Exposure Page
    private final By CreateLoanAndExposureButtonInOnboarding = By.xpath("//*[@id=\"facility-capture-add-btn\"]");
    private final By AddExposureInLoanPageOnboarding = By.xpath("//*[@id=\"facility-exposure-add-btn\"]");
    private final By FindBorrowersOnboardingPage= By.xpath("//*[@id=\"facility-add-form_unifiedSearchQuery\"]");
    private final By SearchButtonOnLoanAndExposure = By.xpath("//input[@class=\"btn btn-sm btn-primary\"]");
    private final By CreateButtonCommon = By.xpath("//*[@value=\"Create\"]");
    private final By FindLoanAndExposures = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By AddButtonCommon = By.xpath("//button[contains(text(), 'Add')]");
    private final By Confirm = By.xpath("//*[@id=\"facilityModalConfirm\"]");

    //Collateral Page
    private final By LEDType = By.xpath("//*[@id=\"select2-typeahead-select-collateralCaptureType-container\"]");
    private final By AddAssetButton = By.xpath("//*[@id=\"collateral-add-assets-btn\"]");
    private final By AssetType = By.xpath("//*[@id=\"select2-typeahead-select-assetCategory-container\"]");
    private final By AssetType2 = By.xpath("//*[@id=\"select2-typeahead-select-assetType-container\"]");
    private final By FindCollaterals = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By FindOwners = By.xpath("//*[@id=\"collateral-add-form_unifiedSearchQuery\"]");
    private final By SearchButtonForSearchingOwnersOnLEDPage = By.xpath("//*[@id=\"le-collateral-search-btn\"]/input[2]");
    private final By Rank = By.xpath("//*[@id=\"rank-id\"]");
    private final By Paripasu = By.xpath("//*[@id=\"dropdown-paripassuYn\"]");
    private final By OnboardingSearchAndLinkCollateral = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By Finish = By.xpath("//*[@value=\"Finish\"]");
    private final By SearchButtonLiensAndCollateral = By.xpath("//*[@id=\"collateral-search-btn\"]/button");
    private final By OkayButton = By.xpath("//*[@id=\"collection-capture-no-user-warning-okay\"]");
    private final By FindLEDs = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By SearchButtonLEDOnboarding = By.xpath("//*[@id=\"collateral-search-btn\"]/button");

    //Guarantees Page
    private final By GuaranteeType = By.xpath("//*[@id=\"select2-typeahead-select-guaranteeCapture-ledTypeCode-container\"]");
    private final By FindGuarantors = By.xpath("//*[@id=\"guarantee-add-form_unifiedSearchQuery\"]");
    private final By SelectARoleLEGuarantee = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityCollection-roleCd-suggestedLegalEntitySearch-container\"]");
    private final By SelectARoleLEGuarantee2 = By.xpath("//*[@id=\"select2-typeahead-select-legalEntityCollection-roleCd-legalEntitySearch-container\"]");

    //endregion


    //region Onboarding Pages
    //region Collateral and Assets

    /**
     *Description: Onboarding Search and Link Collateral
     */
    public void OnboardingSearchAndLinkCollateral(String OnboardingSearchAndLinkCollateralOption, String Position, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(OnboardingSearchAndLinkCollateral, OnboardingSearchAndLinkCollateralOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButtonLiensAndCollateral);
        CommonForAll.SelectSearchedBySearchTermWhileLinkingWhereSelectionItemsAreAtDifferentPlacesInTheTable(OnboardingSearchAndLinkCollateralOption,Position);
        CommonForAll.Click(AddButtonCommon);
        CommonForAll.turnOffImplicitWaits();
        try{
            CommonForAll.Click(Confirm);
        }
        catch(Exception e){

        }
        thread.sleep(500);
        CommonForAll.turnOnImplicitWaits();
    }


    /**
     *Description: Rank And Paripasu with Save Used wile searching and linking Asset to collateral on onboarding
     */
    public void RankAndParipasuWithSave(String RankOption, String SharedRankOption,  String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {
        CommonForAll.SendKeys(Rank, RankOption);
        CommonForAll.ClickAndSelectByAForYesAndNo(Paripasu, SharedRankOption, "1");
        CommonForAll.JavaScriptScrollToTop();
        CommonForAll.Click(Save1);
    }

    /**
     *Description: Search Asset On Onboarding and Select
     */
    public void SearchAssetOnOnboarding(String FindCollateralOption, String PositionOfSearchedItem, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {
        CommonForAll.SendKeys(FindCollaterals, FindCollateralOption);
        CommonForAll.Click(SearchButton);
        Thread.sleep(2500);
        CommonForAll.SelectSearchedBySearchTermWhileLinkingWhereSelectionItemsAreAtDifferentPlacesInTheTable(FindCollateralOption,PositionOfSearchedItem);

    }

    /**
     *Description: Select lien Type LED
     */
    public void SelectLEDTypeOnboarding(String LEDTypeOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(LEDType, LEDTypeOption);
    }

    /**
     *Description: Select Guarantees Type
     */
    public void SelectGuaranteeTypeOnboarding(String LEDTypeOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(GuaranteeType, LEDTypeOption);
    }

    /**
     *Description: Select Asset Type
     */
    public void SelectAssetTypeOnboarding(String AssetTypeOneOption, String AssetTypeTwoOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(AssetType, AssetTypeOneOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(AssetType2, AssetTypeTwoOption);
        CommonForAll.Click(AddButtonCommon);
    }

    /**
     *Description: Add Asset Button
     */
    public void AddAssetButton() throws InterruptedException, AWTException {
        CommonForAll.Click(AddAssetButton);
    }

    // endregion Collateral and Assets

    //region Case and Loan And Exposure Pages

    /**
     *Description: Onboarding Search and Link Facility and Exposure
     */
    public void OnboardingSearchAndLinkFacilityAndExposure(String FindFacilityAndExposuresOption, String Position, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(FindLoanAndExposures, FindFacilityAndExposuresOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButton);
        CommonForAll.SelectSearchedBySearchTermWhileLinkingWithPosition(FindFacilityAndExposuresOption, Position);
        CommonForAll.turnOnImplicitWaits();
        CommonForAll.Click(AddButtonCommon);
        CommonForAll.turnOffImplicitWaits();
        try{
            CommonForAll.turnOffImplicitWaits();
            CommonForAll.Click(Confirm);
        }
        catch(Exception e){

        }
        thread.sleep(500);
        CommonForAll.turnOnImplicitWaits();
    }

    /**
     *Description: Onboarding Search and Link LED
     */
    public void OnboardingSearchAndLinkLED(String FindLEDsOption, String Position, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(FindLEDs, FindLEDsOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButton);
        thread.sleep(2000);
        CommonForAll.SelectSearchedBySearchTermWhileLinkingWhereSelectionItemsAreAtDifferentPlacesInTheTable(FindLEDsOption, Position);
        CommonForAll.turnOnImplicitWaits();
        //CommonForAll.JavaScriptScrollToBottom();
        //CommonForAll.JavaScriptScrollToBottom();
        thread.sleep(3000);
        //CommonForAll.JavaScriptScrollToBottom();
        CommonForAll.JavaScriptScroll(AddButtonCommon);
        CommonForAll.Click(AddButtonCommon);
        CommonForAll.turnOffImplicitWaits();
        try{
            CommonForAll.turnOffImplicitWaits();
            CommonForAll.Click(Confirm);
        }
        catch(Exception e){

        }
        thread.sleep(500);
        CommonForAll.turnOnImplicitWaits();
    }


    /**
     *Description: Onboarding Search and Link Customers First Page
     */
    public void OnboardingSearchAndLinkCustomer(String FindCustomersOption, String SelectARoleOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(FindCustomers, FindCustomersOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButton);
        CommonForAll.SelectSearchedBySearchTermWhileLinking(FindCustomersOption);
        thread.sleep(500);
        //CommonForAll.KeysPressRobotClass(KeyEvent.VK_PAGE_DOWN);
        //CommonForAll.JavaScriptScroll(By.xpath("(//em[contains(text(), '"+ FindCustomersOption +"')])[last()]"));
        CommonForAll.ActionClassScrollTo(By.xpath("//*[@id=\"select2-typeahead-select-collection-statusCd-container\"]"));
        thread.sleep(500);
        CommonForAll.ClickAndSelectByLiWithoutScroll(SelectARole, SelectARoleOption);
        CommonForAll.Click(AddButton);
        thread.sleep(1000);

    }

    /**
     *Description: Onboarding Search and Link Customers(Guarantors) Guarantees Page
     */
    public void OnboardingSearchAndLinkCustomerGuarantorsToGuarantee(String FindGuarantorOrLEOption, String SelectARoleOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(FindGuarantors, FindGuarantorOrLEOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButton);
        CommonForAll.SelectSearchedBySearchTermWhileLinking(FindGuarantorOrLEOption);
        thread.sleep(500);
        //CommonForAll.KeysPressRobotClass(KeyEvent.VK_PAGE_DOWN);
        //CommonForAll.JavaScriptScroll(By.xpath("(//em[contains(text(), '"+ FindCustomersOption +"')])[last()]"));
        //CommonForAll.ActionClassScrollTo(By.xpath("//*[@id=\"select2-typeahead-select-collection-statusCd-container\"]"));
        thread.sleep(500);
        CommonForAll.ClickAndSelectByLiWithoutScroll(SelectARoleLEGuarantee2, SelectARoleOption);
        CommonForAll.JavaScriptScroll(AddButton);
        CommonForAll.Click(AddButton);
        thread.sleep(1000);

    }

    /**
     *Description: Select A Role Guarantees Legal Entity
     */
    public void SelectARoleBetweenGuaranteesAndLegalEntity(String SelectARoleOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.ClickAndSelectByLiWithoutScroll(SelectARoleLEGuarantee, SelectARoleOption);
        CommonForAll.Click(AddButton);
        thread.sleep(1000);

    }

    /**
     *Description: Select A Role Guarantees Legal Entity 2
     */
    public void SelectARoleBetweenGuaranteesAndLegalEntity2(String SelectARoleOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.ClickAndSelectByLiWithoutScroll(SelectARoleLEGuarantee2, SelectARoleOption);
        CommonForAll.Click(AddButton);
        thread.sleep(1000);

    }

    /**
     *Description: Onboarding Search and Link Customers to Loan And Exposure Onboarding
     */
    public void OnboardingSearchAndLinkCustomerToLoanAndExposure(String FindBorrowersOnboardingPageOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(FindBorrowersOnboardingPage, FindBorrowersOnboardingPageOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButtonOnLoanAndExposure);
        CommonForAll.SelectSearchedBySearchTermWhileLinking(FindBorrowersOnboardingPageOption);
        CommonForAll.ActionClassScrollTo(By.xpath("//*[@class=\"collapse-title facility-core-entity fac-top-spacer title-container\"]"));
        thread.sleep(500);
        CommonForAll.Click(AddButton);

    }

    /**
     *Description: Onboarding Search and Link Customers to LEDs
     */
    public void OnboardingSearchAndLinkCustomerToLEDs(String FindOwnersOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException, AWTException {

        CommonForAll.SendKeys(FindOwners, FindOwnersOption);
        thread.sleep(500);
        CommonForAll.Click(SearchButtonForSearchingOwnersOnLEDPage);
        CommonForAll.SelectSearchedBySearchTermWhileLinking(FindOwnersOption);
        CommonForAll.ActionClassScrollTo(By.xpath("//*[@id=\"collateral-add-form\"]/div[7]/div[1]/h4[1]"));
        thread.sleep(500);
        CommonForAll.Click(AddButton);

    }

    /**
     *Description: Select Customer Role and Customer Type on Onboarding Screen for creation
     */
    public void OnboardingCustomerRoleAndTypeSelect(String RoleOption, String CustomerTypeOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(Role, RoleOption);
        CommonForAll.ClickAndSelectByLiWithoutScroll(CustomerType, CustomerTypeOption);
        CommonForAll.Click(CreateButton);
    }

    /**
     *Description: Create Loan & Exposure Button Via Onboarding
     */
    public void CreateFacilityAndExposureButtonInOnboarding() throws InterruptedException {
        CommonForAll.Click(CreateLoanAndExposureButtonInOnboarding);
    }

    /**
     *Description: Add Exposure to Facility in Onboarding
     */
    public void AddExposureToFacilityInOnboarding() throws InterruptedException {
        CommonForAll.Click(AddExposureInLoanPageOnboarding);
    }

    /**
     *Description: Next Button 2
     */
    public void NextButton2() throws InterruptedException {
        thread.sleep(500);
        CommonForAll.JavaScriptScrollToBottom();
        CommonForAll.Click(NextButton2);
        thread.sleep(500);
    }

    /**
     *Description: Next Button 1
     */
    public void NextButton1() throws InterruptedException {
        thread.sleep(500);
        //CommonForAll.JavaScriptScrollToBottom();
        CommonForAll.Click(NextButton1);
        thread.sleep(500);
    }

    /**
     *Description: Create Button for adding customer in Loan and exposure
     */
    public void CreateButton() throws InterruptedException {
        thread.sleep(100);
        CommonForAll.Click(CreateButtonCommon);
        thread.sleep(100);
    }

    /**
     *Description:  Select Customer Type
     */
    public void SelectCustomerType(String CustomerTypeOption) throws InterruptedException {
        thread.sleep(100);
        CommonForAll.Click(By.xpath("(//a[contains(text(), '"+ CustomerTypeOption +"')])[2]"));
        thread.sleep(100);
    }

    /**
     *Description: Onboarding Yes or No Button
     */
    public void YesOrNoButtonOnboarding(String YesOrNo) throws InterruptedException {
        CommonForAll.Click(By.xpath("(//button[contains(text(), '"+ YesOrNo +"')])"));
    }

    /**
     *Description: Clicking Add Button
     */
    public void AddButtonClick() throws InterruptedException {
        thread.sleep(500);
        //CommonForAll.JavaScriptScroll(By.xpath("(//button[contains(text(), 'Add')])"));
        CommonForAll.Click(By.xpath("(//button[contains(text(), 'Add')])"));

    }

    /**
     *Description: Link LE's to Facility and Exposure from onboarding
     */
    public void LinkLEtoFacilityAndExposure(String Position) throws InterruptedException {
        CommonForAll.Click(By.xpath("(//*[@id=\"capture-legalEntity-link-details\"]//tr//td//input)["+ Position +"]"));
    }

    /**
     *Description: Link LE's to LED
     */
    public void LinkLEtoLED(String Position) throws InterruptedException {
        //CommonForAll.JavaScriptScroll(By.xpath("(//*[@id=\"capture-legalEntity-link-details\"]//tr//td//input)["+ Position +"]"));
        CommonForAll.Click(By.xpath("(//*[@id=\"capture-legalEntity-link-details\"]//tr//td//input)["+ Position +"]"));
    }

    /**
     *Description: Onboarding Tab
     */
    public void OnboardingTab() throws InterruptedException {
        CommonForAll.Click(OnboardingTab);
        thread.sleep(500);
    }

    /**
     *Description: SelectSourceType
     */
    public void SelectSourceType(String Option) throws InterruptedException {
        try {
            CommonForAll.turnOffImplicitWaits();
            CommonForAll.ClickWithLessWait(SelectSourceType);
            CommonForAll.ClickWithLessWait(By.xpath("(//li[contains(text(), '" + Option + "')])"));
            thread.sleep(500);
        }
        catch(NoSuchElementException  | TimeoutException e)
        {
            CommonForAll.turnOnImplicitWaits();
        }
    }

    /**
     *Description: Finish Button
     */
    public void FinishButton() throws InterruptedException {
        CommonForAll.Click(Finish);
        thread.sleep(500);
    }

    /**
     *Description: Select the Bank NEEDED
     */
    public void SelectBank(String Name) throws InterruptedException {
        if (Name == "CNB") {

        }else {

            }
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
     *Description: Okay
     * @return
     */
    public void Okay() throws InterruptedException {
        thread.sleep(1000);
        CommonForAll.Click(OkayButton);
    }


    //endregion Case & Loan And Exposure Page
    //endregion




    }



