package Engine.ObjectRepository.Sample.Collateral;

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
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;


/**
 * Created by Raj
 */
public class AssetANZ extends Page {


    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public WebDriverWait wait;
    Thread thread;
    //private Engine.ObjectRepository.AIB.CommonAIB.CommonAIB CommonAIB = new CommonAIB(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll = new CommonForAll(driver);
    //private Engine.CommonForAll.CommonForAll CommonForAll;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public AssetANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region Asset Xpaths
    //Vessel
    private final By AddToForm = By.id("compext-add");
    private final By RemoveFromForm = By.xpath("//*[@id=\"compext-remove\"]");
    private final By EditButton = By.xpath("//*[@id=\"re-standard-show-edit-btn\"]");
    private final By RemoveStatus = By.xpath("//*[@id=\"select2-typeahead-select-asset-statusCd-container\"]/span");
    private final By RemoveAssetSubType =By.xpath("//*[@id=\"select2-typeahead-select-assetReStandard-reAssetSubTypeCd-container\"]/span");
    private final By RemoveCompareTo = By.xpath("//*[@id=\"select2-typeahead-select-exposure-compareTo-container\"]/span");
    private final By DataFilters = By.xpath("//*[@id=\"dataBarriers_chosen\"]/ul");
    private final By SourceType = By.id("select2-typeahead-select-externalSourceCd-container");
    private final By ID = By.xpath("//*[@id=\"externalReference_externalIdFields_0__value\"]");
    private final By ID2 = By.xpath("//*[@id=\"externalReference_externalIdFields_1__value\"]");
    private final By Save1 = By.xpath("(//input[@value=\"Save\"])[1]");
    private final By Status = By.xpath("//*[@id=\"select2-typeahead-select-asset-statusCd-container\"]");
    private final By LRIMOShip= By.xpath("//*[@id=\"assetVessel-imoRegNo-id\"]");
    private final By Hull= By.xpath("//*[@id=\"assetVessel-hullNo-id\"]");
    private final By CallSign= By.xpath("//*[@id=\"assetVessel-callSign-id\"]");
    private final By ClassificationSociety= By.xpath("//*[@id=\"assetVessel-classificationSociety-id\"]");
    private final By Fishing= By.xpath("//*[@id=\"assetVessel-fishingNumber-id\"]");
    private final By ISPSCode= By.xpath("//*[@id=\"assetVessel-ispsCode-id\"]");
    private final By IMSCodeCompliant= By.xpath("//*[@id=\"dropdown-assetVessel-ismCodeYn\"]");
    private final By VesselName= By.xpath("//*[@id=\"assetVessel-vesselName-id\"]");
    private final By FlagCountry= By.xpath("//*[@id=\"select2-typeahead-select-assetVessel-flagName-container\"]");
    private final By DOCCompany= By.xpath("//*[@id=\"assetVessel-docCompany-id\"]");
    private final By DOCCompanyCountryOfDomicile= By.xpath("//*[@id=\"select2-typeahead-select-assetVessel-docCoCountryDomicileCd-container\"]");
    private final By DOCCompanyCode= By.xpath("//*[@id=\"assetVessel-docCompany-id\"]");
    private final By PortOfRegistration= By.xpath("//*[@id=\"assetVessel-portOfRegistration-id\"]");
    private final By GroupBeneficialOwner= By.xpath("//*[@id=\"assetVessel-groupBeneficialOwner-id\"]");
    private final By GroupBeneficialOwnerCountryOfDomicile= By.xpath("//*[@id=\"select2-typeahead-select-assetVessel-grpBenOwnerCtryOfDomicile-container\"]");
    private final By GroupBeneficialOwnerCompanyCode= By.xpath("//*[@id=\"assetVessel-grpBenOwnerCompanyCd-id\"]");
    private final By IHSRegisteredOwner= By.xpath("//*[@id=\"assetVessel-registeredOwner-id\"]");
    private final By IHSRegisteredOwnerCode= By.xpath("//*[@id=\"assetVessel-registeredOwnerCode-id\"]");
    private final By IHSRegisteredOwnerCountryOfDomicile= By.xpath("//*[@id=\"select2-typeahead-select-assetVessel-regOwnerCtryDomicileCd-container\"]");
    private final By Official= By.xpath("//*[@id=\"assetVessel-officialNumber-id\"]");
    private final By Operator= By.xpath("//*[@id=\"assetVessel-operator-id\"]");
    private final By OperatorCompanyCode = By.xpath("//*[@id=\"assetVessel-operatorCompanyCode-id\"]");
    private final By OperatorCountryOfDomicileName = By.xpath("//*[@id=\"select2-typeahead-select-assetVessel-operatorCtryOfDomicileCd-container\"]");
    private final By SATCommID = By.xpath("//*[@id=\"assetVessel-satCommId-id\"]");
    private final By ShipManager= By.xpath("//*[@id=\"assetVessel-shipManager-id\"]");
    private final By ShipManagerCompanyCode= By.xpath("//*[@id=\"assetVessel-shipManagerCompanyCode-id\"]");
    private final By ShipManagerCountryOfDomicile = By.xpath("//*[@id=\"select2-typeahead-select-assetVessel-shipManagerCtryDomicileCd-container\"]");
    private final By GrossTonnage= By.xpath("//*[@id=\"assetVessel-grossTonnage-id\"]");
    private final By NetTonnage= By.xpath("//*[@id=\"assetVessel-netTonnage-id\"]");
    private final By DeadWeightDWT= By.xpath("//*[@id=\"assetVessel-deadweight-id\"]");
    private final By DisplacementMT= By.xpath("//*[@id=\"assetVessel-displacement-id\"]");
    private final By LightDisplacementTonnage = By.xpath("//*[@id=\"assetVessel-lightDisplacementTonnage-id\"]");
    private final By SegregatedBallastCapacityM3= By.xpath("//*[@id=\"assetVessel-segregatedBallastCapacity-id\"]");
    private final By TEU= By.xpath("//*[@id=\"assetVessel-teu-id\"]");
    private final By TEUCapacity14tHomogenous = By.xpath("//*[@id=\"assetVessel-teuCapacity14THomogenous-id\"]");
    private final By DateOfBuild = By.xpath("//*[@id=\"assetVessel-dateOfBuild-id\"]");
    private final By Shipbuilder= By.xpath("//*[@id=\"assetVessel-shipbuilder-id\"]");
    private final By ShipbuilderCompanyCode = By.xpath("//*[@id=\"assetVessel-shipbuilderCompanyCode-id\"]");
    private final By ShipbuilderFullName = By.xpath("//*[@id=\"assetVessel-shipbuilderFullStyle-id\"]");
    private final By YardNumber= By.xpath("//*[@id=\"assetVessel-yardNumber-id\"]");
    private final By LengthRegistered= By.xpath("//*[@id=\"assetVessel-lengthRegistered-id\"]");
    private final By LengthOverall = By.xpath("//*[@id=\"assetVessel-lengthOverallLoa-id\"]");
    private final By LengthBetweenPerpendiculars= By.xpath("//*[@id=\"assetVessel-lengthBetweenPerpendiculars-id\"]");
    private final By BreadthExtreme= By.xpath("//*[@id=\"assetVessel-breadthExtreme-id\"]");
    private final By BreadthMoulded= By.xpath("//*[@id=\"assetVessel-breadthMoulded-id\"]");
    private final By Draught = By.xpath("//*[@id=\"assetVessel-draught-id\"]");
    private final By Depth = By.xpath("//*[@id=\"assetVessel-depth-id\"]");
    private final By BowToCentreManifold= By.xpath("//*[@id=\"assetVessel-bowToCentreManifold-id\"]");
    private final By KeelToMastHeight = By.xpath("//*[@id=\"assetVessel-keelToMastHeight-id\"]");
    private final By LeadShipInSeriesByIMO= By.xpath("//*[@id=\"assetVessel-leadShipInSeriesByImoNo-id\"]");
    private final By ShipStatus= By.xpath("//*[@id=\"assetVessel-shipStatus-id\"]");
    private final By StandardShipDesign = By.xpath("//*[@id=\"assetVessel-standardShipDesign-id\"]");
    private final By ShipTypeLevel2= By.xpath("//*[@id=\"assetVessel-shiptypeLevel2-id\"]");
    private final By ShipTypeLevel3= By.xpath("//*[@id=\"assetVessel-shiptypeLevel3-id\"]");
    private final By ShipTypeLevel4= By.xpath("//*[@id=\"assetVessel-shiptypeLevel4-id\"]");
    private final By ShipTypeLevel5= By.xpath("//*[@id=\"assetVessel-shiptypeLevel5-id\"]");
    private final By HullType = By.xpath("//*[@id=\"assetVessel-hullType-id\"]");
    private final By PassengerCapacity= By.xpath("//*[@id=\"assetVessel-passengerCapacity-id\"]");
    private final By BaleCapacity= By.xpath("//*[@id=\"assetVessel-baleCapacity-id\"]");
    private final By GrainCapacity= By.xpath("//*[@id=\"assetVessel-grainCapacity-id\"]");
    private final By GasCapacity = By.xpath("//*[@id=\"assetVessel-gasCapacity-id\"]");
    private final By InsulatedCapacity= By.xpath("//*[@id=\"assetVessel-insulatedCapacity-id\"]");
    private final By LiquidCapacity= By.xpath("//*[@id=\"assetVessel-liquidCapacity-id\"]");
    private final By Power= By.xpath("//*[@id=\"assetVessel-power-id\"]");
    private final By Speed = By.xpath("//*[@id=\"assetVessel-speed-id\"]");
    private final By GenericDropdown= By.xpath("//*[@id=\"select2-typeahead-select-asset-csdListAssetCd-container\"]");
    private final By PropertyDescriptionCode= By.xpath("//*[@id=\"select2-reportingCd5-container\"]");
    private final By OverrideExtensionValue= By.xpath("//*[@id=\"EXTV-id\"]");
    private final By OverrideAmberThreshold= By.xpath("//*[@id=\"-amber-id\"]");
    private final By OverrideRedThreshold= By.xpath("//*[@id=\"-red-id\"]");

    //Real Estate
    private final By AssetSubType= By.xpath("//*[@id=\"select2-typeahead-select-assetReStandard-reAssetSubTypeCd-container\"]");
    private final By NoOfBedrooms= By.xpath("//*[@id=\"assetReStandard-numberOfBedrooms-id\"]");
    private final By LegalDescriptionOfProperty= By.xpath("//*[@id=\"assetReStandard-propertyDescription-id\"]");
    private final By PropertyTenure= By.xpath("//*[@id=\"select2-typeahead-select-assetReStandard-ownershipTypeCd-container\"]");
    private final By PlaceOfResidenceIndicator= By.xpath("//*[@id=\"dropdown-assetReStandard-rentalYn\"]");
    private final By PropertyPurchaseIndicator = By.xpath("//*[@id=\"dropdown-assetReDetails-detailsBoolean2\"]");
    private final By LeaseholdExpiryDate= By.xpath("//*[@id=\"assetReStandard-leaseholdExpDate-id\"]");
    private final By PropertyDevelopmentStatus = By.xpath("//*[@id=\"select2-typeahead-select-assetReDetails-devStatus-container\"]");
    private final By BuildingFloorArea= By.xpath("//*[@name=\"assetReStandard.assetReCharacteristics.buildingFloorAreaValue\"]");
    private final By BuildingFloorAreaUnits= By.xpath("//*[@id=\"select2-typeahead-select-assetReStandard-buildingFloorAreaCd-container\"]");
    private final By LandArea= By.xpath("//*[@name=\"assetReStandard.assetReCharacteristics.landAreaValue\"]");
    private final By LandAreaUnits= By.xpath("//*[@id=\"select2-typeahead-select-assetReStandard-landAreaCd-container\"]");
    private final By Rank = By.xpath("//*[@id=\"rank-id\"]");
    private final By PariPasu = By.xpath("//*[@id=\"dropdown-paripassuYn\"]");
    private final By LEDTabInAssetPath = By.xpath("//*[@id=\"asset-tab-href\"]");
    private final By PropertyDetailsTab = By.xpath("//*[@id=\"pe-residential-tabs\"]/li[1]/a");


    //Aircraft
    private final By ClassType = By.xpath("//*[@id=\"select2-typeahead-select-assetMisc-subType-container\"]");
    private final By Description = By.xpath("//*[@id=\"assetMisc-details-id\"]");
    private final By Nationality = By.xpath("//*[@id=\"assetMisc-locationRef-id\"]");
    private final By StartDate = By.xpath("//*[@id=\"assetMisc-startDate-id\"]");
    private final By ExpirationRenewalDate = By.xpath("//*[@id=\"assetMisc-expireDate-id\"]");
    private final By Tangible = By.xpath("//*[@id=\"dropdown-assetMisc-tangibleYn\"]");
    private final By Make = By.xpath("//*[@id=\"select2-typeahead-select-assetMisc-customDropdownOne-container\"]");
    private final By Model= By.xpath("//*[@id=\"assetMisc-customFieldOne-id\"]");
    private final By YearManufactured= By.xpath("//*[@id=\"select2-typeahead-select-assetMisc-customDropdownTwo-container\"]");
    private final By IdentifyingMarkRegistrationNumber= By.xpath("//*[@id=\"assetMisc-customFieldTwo-id\"]");

    //Cash on Deposit
    private final By AssetSubTypeCashOnDeposit= By.xpath("//*[@id=\"select2-typeahead-select-assetCash-subType-container\"]/span");
    private final By AccountHolder = By.xpath("//*[@id=\"assetCash-accountName-id\"]");
    private final By AccountNumber = By.xpath("//*[@id=\"assetCash-bic-id\"]");
    private final By AccountDescription = By.xpath("//*[@id=\"assetCash-accountDescription-id\"]");
    private final By Hold = By.xpath("//*[@id=\"dropdown-assetCash-holdYn\"]");
    private final By AmountRequiredCurrency = By.xpath("//*[@id=\"select2-typeahead-select-assetCash-amountRequiredCcyCd-container\"]");
    private final By AmountRequired = By.xpath("//*[@id=\"assetCash-amountRequired-id\"]");
    private final By FinancialInstitution = By.xpath("//*[@id=\"AssetCashExternalDep-FinancialInstitution-id\"]");
    private final By ExpiryDate = By.xpath("//*[@id=\"AssetCashExternalDep-expiryDate-id\"]");
    private final By OverrideExtensionRate = By.xpath("//*[@id=\"EXTV-id\"]");

    //Life Insurance
    private final By PolicyReferenceNumber = By.xpath("//*[@id='assetLifeInsurance-policyNum-id']");
    private final By PolicyType = By.xpath("//*[@id=\"select2-typeahead-select-assetLifeInsurance-policyTypeCd-container\"]");
    private final By CoverageType = By.xpath("//*[@id=\"select2-typeahead-select-assetLifeInsurance-coverageTypeCd-container\"]");
    private final By PolicyDocumentation = By.xpath("//*[@id=\"select2-typeahead-select-assetLifeInsurance-policyDocTypeCd-container\"]");
    private final By PolicyStartDate = By.xpath("//*[@id=\"assetLifeInsurance-startDate-id\"]");
    private final By ExclusionPeriodEndDate  = By.xpath("//*[@id=\"assetLifeInsurance-exclsPeriodEndDate-id\"]");
    private final By MaturityDate = By.xpath("//*[@id=\"assetLifeInsurance-maturityDate-id\"]");
    private final By PolicyCurrency = By.xpath("//*[@id=\"select2-typeahead-select-assetLifeInsurance-policyCcyCd-container\"]");
    private final By PolicyAmount = By.xpath("//*[@id=\"assetLifeInsurance-firstAmtInsured-id\"]");
    private final By SumInsuredFirst = By.xpath("//*[@id=\"assetLifeInsurance-firstAmtInsured-id\"]");
    private final By SumInsuredSecond = By.xpath("//*[@id=\"assetLifeInsurance-secondAmtInsured-id\"]");
    private final By Premium = By.xpath("//*[@id=\"assetLifeInsurance-premium-id\"]");
    private final By Frequency = By.xpath("//*[@id=\"select2-typeahead-select-assetLifeInsurance-payFreqCd-container\"]");
    private final By FaceValue = By.xpath("//*[@id=\"assetLifeInsurance-faceValue-id\"]");
    private final By SurrenderValue = By.xpath("//*[@id=\"assetLifeInsurance-surrenderValue-id\"]");
    private final By DescriptionLifePolicy = By.xpath("//*[@id=\"assetLifeInsurance-addtnInfo-id\"]");

    //Marketable Securities Portfolio
    private final By HolderAcknowledgeDate  = By.xpath("//*[@id=\"marketableSecurityPortfolio-holderAckDate-id\"]");
    private final By Currency = By.xpath("//*[@id=\"select2-typeahead-select-marketableSecurityPortfolio-currency-container\"]");

    //Link Application
    private final By ApplicationTabInAsset = By.xpath("//*[@id=\"asset-collection-tab-href\"]");
    private final By AttachApplication = By.xpath("//a[contains(text(),'Attach Application')]");
    private final By SearchButtonAssetApplication = By.xpath("//*[@id=\"assetCollectionElasticSearch\"]");
    private final By StatusAssetApplication = By.xpath("//*[@id=\"select2-typeahead-select-collectionAsset-statusCd-container\"]");
    private final By LinkToExisting = By.xpath("//*[@id=\"search.option\"]");
    private final By NextButton = By.xpath("//*[@value=\"Next\"]");
    private final By NextButton2 = By.xpath("(//*[@value=\"Next\"])[2]");
    private final By FindEntitiesWith = By.xpath("//*[@id=\"unifiedSearchQuery-id\"]");
    private final By Finish = By.xpath("//*[@value=\"Finish\"]");

    //Link General Insurance
    private final By GeneralInsuranceTabInAsset = By.xpath("//*[@id=\"asset-general-insurance-tab-href\"]");
    private final By AttachGeneralInsurance = By.xpath("//a[contains(text(),'Attach General Insurance')]");
    private final By SearchButtonAssetGeneralInsurance = By.xpath("//*[@id=\"assetGeneralInsuranceElasticSearch\"]");
    private final By StatusAssetGeneralInsurance= By.xpath("//*[@id=\"select2-typeahead-select-generalInsuranceAsset-statusCd-container\"]");

    //Link ID
    private final By IDTab = By.xpath("//*[@id=\"external-reference-tab-href\"]");
    private final By AddID = By.xpath("//a[contains(text(),'Add ID')]");
    private final By IDStatus = By.xpath("//*[@id=\"select2-typeahead-select-externalReference-statusCd-container\"]");
    private final By IsPrimary = By.xpath("//*[@id=\"dropdown-externalReference-primary\"]");

    //Eligibility
    private final By ANZxActiveAssetRule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Active Asset rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetDataFilterrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset Data Filter rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetCertificateofTitleReferencerule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset Certificate of Title Reference rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetInsurancerule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset Insurance rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetInsuranceLegalEntityInsurerrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset Insurance / Legal Entity Insurer rule.')]//parent::tr//td[4]//i");
    private final By ANZxAssetInsuranceLegalEntityPolicyHolderrule = By.xpath("//*[contains(normalize-space(text()), 'ANZx Asset Insurance / Legal Entity Policy Holder rule.')]//parent::tr//td[4]//i");
    private final By EligibilityClose = By.xpath("//div[@class='jconfirm-closeIcon']");
    private final By Ineligible = By.xpath("//*[@id=\"ineligible-btn\"]/span");
    private final By Eligible = By.xpath("//*[@id=\"eligible-btn\"]/span");



    //endregion Asset Xpath

    //region Create Assets

    //region Marketable Securities Portfolio

    /**
     *Description: Marketable Securities Portfolio
     * @return
     */
    public void MarketableSecuritiesPortfolio(String MarketableSecuritiesPortfolioType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String  HolderAcknowledgeDateOption,
                                      String  CurrencyOption, String Bank, String OverrideAmberThresholdOption, String OverrideRedThresholdOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20, String ExtraOption21, String ExtraOption22, String ExtraOption23, String ExtraOption24, String ExtraOption25) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(AddToForm);
        driver.findElement(AddToForm).click();
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if(SourceTypeOption == "") {

            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            CommonForAll.MouseMoveAndClick(150,150);
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

        if(MarketableSecuritiesPortfolioType == "Listed Ordinary Shares")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.SendKeys(HolderAcknowledgeDate, HolderAcknowledgeDateOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(Currency, CurrencyOption);
            SelectBank(Bank);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);



        }

    }
    //endregion Life Insurance

    //region Life Insurance
    /**
     *Description: Life Insurance
     * @return
     */
    public void LifeInsuranceCreation(String LifeInsuranceType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String  PolicyReferenceNumberOption,
                                      String  PolicyTypeOption,String CoverageTypeOption,String PolicyDocumentationOption,String PolicyStartDateOtpion,String ExclusionPeriodEndDateOption,String Bank, String MaturityDateOption, String PolicyCurrencyOption ,String SumInsuredFirstOption ,String SumInsuredSecondOption,String PremiumOption,String FrequencyOption,String FaceValueOption, String SurrenderValueOption, String DescriptionLifePolicyOption, String OverrideExtensionValueOption, String OverrideAmberThresholdOption, String OverrideRedThresholdOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
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

        if(LifeInsuranceType == "Life Policy")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.SendKeys(PolicyReferenceNumber, PolicyReferenceNumberOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PolicyType, PolicyTypeOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(CoverageType, CoverageTypeOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PolicyDocumentation,PolicyDocumentationOption);
            SelectBank(Bank);
            CommonForAll.SendKeys(PolicyStartDate,PolicyStartDateOtpion);
            //CommonForAll.SendKeys(ExclusionPeriodEndDate, ExclusionPeriodEndDateOption);
            CommonForAll.SendKeys(MaturityDate,MaturityDateOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PolicyCurrency, PolicyCurrencyOption);
            CommonForAll.SendKeys(PolicyAmount, SumInsuredFirstOption);
//            CommonForAll.SendKeys(SumInsuredFirst, SumInsuredFirstOption);
//            CommonForAll.SendKeys(SumInsuredSecond, SumInsuredSecondOption);
//            CommonForAll.SendKeys(Premium, PremiumOption);
//            CommonForAll.ClickAndSelectByLiWithoutScroll(Frequency, FrequencyOption);
//            CommonForAll.SendKeys(FaceValue, FaceValueOption);
//            CommonForAll.SendKeys(SurrenderValue, SurrenderValueOption);
            CommonForAll.SendKeys(DescriptionLifePolicy, DescriptionLifePolicyOption);
            CommonForAll.SendKeys(OverrideExtensionValue, OverrideExtensionValueOption);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);



        }

    }
    //endregion Life Insurance

    //region Generic Asset Category
    /**
     *Description: Generic Asset Category
     * @return
     */
    public void GenericAssetCategoryCreation(String GenericAssetType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String  ClassTypeOption,String  DescriptionOption,String NationalityOption,String StartDateOption,String ExpirationRenewalDateOption,String TangibleOption,String Bank, String MakeOption, String ModelOption ,String YearManufacturedOption ,String  IdentifyingMarkRegistrationNumberOption,String OverrideExtensionValueOption,String OverrideAmberThresholdOption,String OverrideRedThresholdOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
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

        if(GenericAssetType == "Aircraft")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(ClassType, ClassTypeOption);
            CommonForAll.SendKeys(Description, DescriptionOption);
            CommonForAll.SendKeys(Nationality, NationalityOption);
            CommonForAll.SendKeys(StartDate, StartDateOption);
            CommonForAll.SendKeys(ExpirationRenewalDate, ExpirationRenewalDateOption);
            CommonForAll.MouseMoveAndClick(250,250);
            CommonForAll.ClickAndSelectByAForYesAndNo(Tangible, TangibleOption, "1");
            SelectBank(Bank);
            CommonForAll.ClickAndSelectByLiWithoutScroll(Make,MakeOption);
            CommonForAll.SendKeys(Model, ModelOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(YearManufactured, YearManufacturedOption);
            CommonForAll.SendKeys(IdentifyingMarkRegistrationNumber, IdentifyingMarkRegistrationNumberOption);
            CommonForAll.SendKeys(OverrideExtensionValue, OverrideExtensionValueOption);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);
        }

    }
    //endregion Generic Asset Category

    //region Cash On Deposit

    /**
     *Description: Cash On Deposit All Fields
     * @return
     */
    public void CashOnDepositCreation(String CashOnDepositType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String  AssetSubTypeOption,String  AccountHolderOption,String AccountNumberOption,String AccountDescriptionOption,String HoldOption,String AmountRequiredCurrencyOption,String Bank, String AmountRequiredOption, String FinancialInstitutionOption ,String ExpiryDateOption , String OverrideExtensionRateOption, String OverrideAmberThresholdOption,String OverrideRedThresholdOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(AddToForm);
        driver.findElement(AddToForm).click();
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if(SourceTypeOption == "") {
            CommonForAll.MouseMoveAndClick(150,150);
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

        if(CashOnDepositType == "External Cash Deposit")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(AssetSubType, AssetSubTypeOption);
            CommonForAll.SendKeys(AccountHolder, AccountHolderOption);
            CommonForAll.SendKeys(AccountNumber, AccountNumberOption);
            CommonForAll.SendKeys(AccountDescription, AccountDescriptionOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(Hold, HoldOption, "1");
            SelectBank(Bank);
            CommonForAll.ClickAndSelectByLiWithoutScroll(AmountRequiredCurrency, AmountRequiredCurrencyOption);
            CommonForAll.SendKeys(AmountRequired, AmountRequiredOption);
            CommonForAll.SendKeys(FinancialInstitution, FinancialInstitutionOption);
            CommonForAll.SendKeys(ExpiryDate, ExpiryDateOption);
            CommonForAll.SendKeys(OverrideExtensionRate, OverrideExtensionRateOption);
            CommonForAll.SendKeys(OverrideAmberThreshold, OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);

        }

    }

    //endregion Cash on Deposit

    //region Real Estate

    /**
     *Description:Real Estate Creation
     * @return
     */
    public void RealEstateCreation(String RealEstateType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String  RealEstateSubTypeOption,String  NoOfBedroomsOption,String LegalDescriptionOfPropertyOption,String PropertyTenureOption,String PlaceOfResidenceIndicatorOption,String  LeaseholdExpiryDateOption,String  Bank, String BuildingFloorAreaOption, String BuildingFloorAreaUnitsOption ,String LandAreaOption ,String  LandAreaUnitsOption,String  GenericDropdownOptions,String PropertyDescriptionCodeOption,String OverrideExtensionValueOption,String OverrideAmberThresholdOption,String OverrideRedThresholdOption, String PropertyDevelopmentStatusOption, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(AddToForm);
        driver.findElement(AddToForm).click();
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if(SourceTypeOption == "") {

            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            CommonForAll.Click(RemoveFromForm);

        }else if(SourceTypeOption == "Source System Asset ID" || SourceTypeOption == "Valuation System ID" || SourceTypeOption == "Certificate of Title Reference"){
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
            isElementLoaded(ID);
            CommonForAll.SendKeys(ID, IDString);
        }

        if(RealEstateType == "Bedsitter / Studio Apartments")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(AssetSubType, RealEstateSubTypeOption);
            //CommonForAll.SendKeys(NoOfBedrooms, NoOfBedroomsOption);
            CommonForAll.SendKeys(LegalDescriptionOfProperty, LegalDescriptionOfPropertyOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyTenure,PropertyTenureOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(PlaceOfResidenceIndicator, PlaceOfResidenceIndicatorOption, "1");
            CommonForAll.SendKeys(LeaseholdExpiryDate, LeaseholdExpiryDateOption);
            SelectBank(Bank);
            CommonForAll.MouseMoveAndClick(250,250);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDevelopmentStatus, PropertyDevelopmentStatusOption);
            //CommonForAll.SendKeys(BuildingFloorArea, BuildingFloorAreaOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(BuildingFloorAreaUnits, BuildingFloorAreaUnitsOption);
            //CommonForAll.SendKeys(LandArea, LandAreaOption);
//            CommonForAll.ClickAndSelectByLiWithoutScroll(LandAreaUnits, LandAreaUnitsOption);
//            CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown, GenericDropdownOptions);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDescriptionCode, PropertyDescriptionCodeOption);
            CommonForAll.SendKeys(OverrideExtensionValue, OverrideExtensionValueOption);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);
        }

    }



    /**
     *Description:Real Estate Creation Onboarding
     * @return
     */
    public void RealEstateCreationOnboarding(String RealEstateType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String RankOption, String PariPasuOption, String  RealEstateSubTypeOption,String  NoOfBedroomsOption,String LegalDescriptionOfPropertyOption,String PropertyTenureOption,String PlaceOfResidenceIndicatorOption,String  LeaseholdExpiryDateOption,String  Bank, String BuildingFloorAreaOption, String BuildingFloorAreaUnitsOption ,String LandAreaOption ,String  LandAreaUnitsOption,String  GenericDropdownOptions,String PropertyDescriptionCodeOption,String OverrideExtensionValueOption,String OverrideAmberThresholdOption,String OverrideRedThresholdOption, String PropertyDevelopmentStatusOption, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if(SourceTypeOption == "") {

            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);
            CommonForAll.Click(RemoveFromForm);

        }else if(SourceTypeOption == "Source System Asset ID" || SourceTypeOption == "Valuation System ID" || SourceTypeOption == "Certificate of Title Reference"){
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
            isElementLoaded(ID);
            CommonForAll.SendKeys(ID, IDString);
        }

        if(RealEstateType == "Bedsitter / Studio Apartments")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.SendKeys(Rank, RankOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(PariPasu, PariPasuOption, "1");
            //CommonForAll.ClickAndSelectByLiWithoutScroll(AssetSubType, RealEstateSubTypeOption);
            //CommonForAll.SendKeys(NoOfBedrooms, NoOfBedroomsOption);
            CommonForAll.SendKeys(LegalDescriptionOfProperty, LegalDescriptionOfPropertyOption);
            CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyTenure,PropertyTenureOption);
            CommonForAll.JavaScriptScrollByPixels(100);
            CommonForAll.ClickAndSelectByAForYesAndNo(PlaceOfResidenceIndicator, PlaceOfResidenceIndicatorOption, "2");
            CommonForAll.SendKeys(LeaseholdExpiryDate, LeaseholdExpiryDateOption);
            SelectBank(Bank);
            CommonForAll.MouseMoveAndClick(250,250);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDevelopmentStatus, PropertyDevelopmentStatusOption);
            //CommonForAll.SendKeys(BuildingFloorArea, BuildingFloorAreaOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(BuildingFloorAreaUnits, BuildingFloorAreaUnitsOption);
            //CommonForAll.SendKeys(LandArea, LandAreaOption);
//            CommonForAll.ClickAndSelectByLiWithoutScroll(LandAreaUnits, LandAreaUnitsOption);
//            CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown, GenericDropdownOptions);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDescriptionCode, PropertyDescriptionCodeOption);
            CommonForAll.SendKeys(OverrideExtensionValue, OverrideExtensionValueOption);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);
        }
        else if (RealEstateType == "Standard Residential Property")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);
            CommonForAll.SendKeys(Rank, RankOption);
            CommonForAll.ClickAndSelectByAForYesAndNo(PariPasu, PariPasuOption, "1");

        }


    }

    //endregion Real Estate

    //region Vessel
    /**
     *Description: Vessel Creation
     * @return
     */
    public void VesselCreation(String VesselType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String  LRIMOShipOption,String  HullOption,String CallSignOption,String ClassificationSocietyOption,String FishingOption,String  ISPSCodeOption,String  IMSCodeCompliantOption, String Bank, String VesselNameOption ,String FlagCountryOption ,String  DOCCompanyOption,String  DOCCompanyCountryOfDomicileOption,String DOCCompanyCodeOption ,String  PortOfRegistrationOption,String GroupBeneficialOwnerOption ,String  GroupBeneficialOwnerCountryOfDomicileOption,String  GroupBeneficialOwnerCompanyCodeOption,String  IHSRegisteredOwnerOption,String  IHSRegisteredOwnerCodeOption,String  IHSRegisteredOwnerCountryOfDomicileOption,String OfficialOption ,String  OperatorOption,String OperatorCompanyCodeOption,String OperatorCountryOfDomicileNameOption ,String  SATCommIDOption,String ShipManagerOption ,String ShipManagerCompanyCodeOption,String ShipManagerCountryOfDomicileOption ,String GrossTonnageOption ,String NetTonnageOption ,String DeadWeightDWTOption ,String DisplacementMTOption ,String LightDisplacementTonnageOption ,String SegregatedBallastCapacityM3Option ,String TEUOption, String TEUCapacity14tHomogenousOption, String DateOfBuildOption, String ShipbuilderOption,String ShipbuilderCompanyCodeOption,String ShipbuilderFullNameOption,String YardNumberOption,String LengthRegisteredOption,String LengthOverallOption,String LengthBetweenPerpendicularsOption,String BreadthExtremeOption,String BreadthMouldedOption,String DraughtOption,String DepthOption,String BowToCentreManifoldOption,String KeelToMastHeightOption,String LeadShipInSeriesByIMOOption,String ShipStatusOption,String StandardShipDesignOption,String ShipTypeLevel2Option,String ShipTypeLevel3Option,String ShipTypeLevel4Option,String ShipTypeLevel5Option,String HullTypeOption,String PassengerCapacityOption, String BaleCapacityOption, String GrainCapacityOption,String GasCapacityOption,String InsulatedCapacityOption,String LiquidCapacityOption,String PowerOption,String SpeedOption,String GenericDropdownOption,String PropertyDescriptionCodeOption,String OverrideExtensionValueOption,String OverrideAmberThresholdOption,String OverrideRedThresholdOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        CommonForAll CommonForALl = new CommonForAll(driver);
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
            CommonForALl.SendKeys(ID2, ID2String);
        }
        else{
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
        }

        if(VesselType == "Barge")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status,StatusOption); ;
            CommonForAll.SendKeys(LRIMOShip, LRIMOShipOption);
            CommonForAll.SendKeys(Hull, HullOption); ;
            CommonForAll.SendKeys(CallSign, CallSignOption); ;
            CommonForAll.SendKeys(ClassificationSociety, ClassificationSocietyOption); ;
            CommonForAll.SendKeys(Fishing, FishingOption); ;
            CommonForAll.SendKeys(ISPSCode, ISPSCodeOption); ;
            CommonForAll.ClickAndSelectByAForYesAndNo(IMSCodeCompliant, IMSCodeCompliantOption, "1");
            SelectBank(Bank);
            CommonForAll.SendKeys(VesselName, VesselNameOption); ;
            //CommonForAll.ClickAndSelectByLiWithoutScroll(FlagCountry,FlagCountryOption); ;
            CommonForAll.SendKeys(DOCCompany, DOCCompanyOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(DOCCompanyCountryOfDomicile, DOCCompanyCountryOfDomicileOption); ;
            CommonForAll.SendKeys(DOCCompanyCode, DOCCompanyCodeOption);
            CommonForAll.SendKeys(PortOfRegistration, PortOfRegistrationOption); ;
            CommonForAll.SendKeys(GroupBeneficialOwner, GroupBeneficialOwnerOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(GroupBeneficialOwnerCountryOfDomicile, GroupBeneficialOwnerCountryOfDomicileOption); ;
            CommonForAll.SendKeys(GroupBeneficialOwnerCompanyCode, GroupBeneficialOwnerCompanyCodeOption); ;
            CommonForAll.SendKeys(IHSRegisteredOwner,IHSRegisteredOwnerOption); ;
            CommonForAll.SendKeys(IHSRegisteredOwnerCode,IHSRegisteredOwnerCodeOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(IHSRegisteredOwnerCountryOfDomicile, IHSRegisteredOwnerCountryOfDomicileOption); ;
            CommonForAll.SendKeys(Official, OfficialOption); ;
            CommonForAll.SendKeys(Operator, OperatorOption); ;
            CommonForAll.SendKeys(OperatorCompanyCode, OperatorCompanyCodeOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(OperatorCountryOfDomicileName, OperatorCountryOfDomicileNameOption); ;
            CommonForAll.SendKeys(SATCommID, SATCommIDOption); ;
            CommonForAll.SendKeys(ShipManager, ShipManagerOption); ;
            CommonForAll.SendKeys(ShipManagerCompanyCode, ShipManagerCompanyCodeOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(ShipManagerCountryOfDomicile, ShipManagerCountryOfDomicileOption); ;
            CommonForAll.SendKeys(GrossTonnage, GrossTonnageOption); ;
            CommonForAll.SendKeys(NetTonnage, NetTonnageOption) ;
            CommonForAll.SendKeys(DeadWeightDWT, DeadWeightDWTOption) ;
            CommonForAll.SendKeys(DisplacementMT,DisplacementMTOption) ;
            CommonForAll.SendKeys(LightDisplacementTonnage, LightDisplacementTonnageOption) ;
            CommonForAll.SendKeys(SegregatedBallastCapacityM3, SegregatedBallastCapacityM3Option) ;
            CommonForAll.SendKeys(TEU, TEUOption) ;
            CommonForAll.SendKeys(TEUCapacity14tHomogenous, TEUCapacity14tHomogenousOption) ;
            CommonForAll.SendKeys(DateOfBuild, DateOfBuildOption) ;
            CommonForAll.SendKeys(Shipbuilder, ShipbuilderOption) ;
            CommonForAll.SendKeys(ShipbuilderCompanyCode, ShipbuilderCompanyCodeOption) ;
            CommonForAll.SendKeys(ShipbuilderFullName, ShipbuilderFullNameOption) ;
            CommonForAll.SendKeys(YardNumber, YardNumberOption) ;
            CommonForAll.SendKeys(LengthRegistered, LengthRegisteredOption) ;
            CommonForAll.SendKeys(LengthOverall, LengthOverallOption) ;
            CommonForAll.SendKeys(LengthBetweenPerpendiculars, LengthBetweenPerpendicularsOption) ;
            CommonForAll.SendKeys(BreadthExtreme, BreadthExtremeOption) ;
            CommonForAll.SendKeys(BreadthMoulded, BreadthMouldedOption) ;
            CommonForAll.SendKeys(Draught, DraughtOption) ;
            CommonForAll.SendKeys(Depth, DepthOption) ;
            CommonForAll.SendKeys(BowToCentreManifold, BowToCentreManifoldOption) ;
            CommonForAll.SendKeys(KeelToMastHeight,KeelToMastHeightOption) ;
            CommonForAll.SendKeys(LeadShipInSeriesByIMO, LeadShipInSeriesByIMOOption) ;
            CommonForAll.SendKeys(ShipStatus, ShipStatusOption) ;
            CommonForAll.SendKeys(StandardShipDesign, StandardShipDesignOption) ;
            CommonForAll.SendKeys(ShipTypeLevel2,ShipTypeLevel2Option) ;
            CommonForAll.SendKeys(ShipTypeLevel3,ShipTypeLevel3Option) ;
            CommonForAll.SendKeys(ShipTypeLevel4,ShipTypeLevel4Option) ;
            CommonForAll.SendKeys(ShipTypeLevel5,ShipTypeLevel5Option) ;
            CommonForAll.SendKeys(HullType,HullTypeOption) ;
            CommonForAll.SendKeys(PassengerCapacity,PassengerCapacityOption) ;
            CommonForAll.SendKeys(BaleCapacity,BaleCapacityOption) ;
            CommonForAll.SendKeys(GrainCapacity,GrainCapacityOption) ;
            CommonForAll.SendKeys(GasCapacity,GasCapacityOption) ;
            CommonForAll.SendKeys(InsulatedCapacity,InsulatedCapacityOption) ;
            CommonForAll.SendKeys(LiquidCapacity,LiquidCapacityOption) ;
            CommonForAll.SendKeys(Power,PowerOption) ;
            CommonForAll.SendKeys(Speed,SpeedOption) ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown,GenericDropdownOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDescriptionCode, PropertyDescriptionCodeOption);
            CommonForAll.SendKeys(OverrideExtensionValue, OverrideExtensionValueOption);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);
        }

    }

    /**
     *Description: Vessel Creation Onboarding
     * @return
     */
    public void VesselCreationOnboarding(String VesselType, String SourceTypeOption, String IDString, String ID2String, String StatusOption, String RankOption, String  LRIMOShipOption,String  HullOption,String CallSignOption,String ClassificationSocietyOption,String FishingOption,String  ISPSCodeOption,String  IMSCodeCompliantOption, String Bank, String VesselNameOption ,String FlagCountryOption ,String  DOCCompanyOption,String  DOCCompanyCountryOfDomicileOption,String DOCCompanyCodeOption ,String  PortOfRegistrationOption,String GroupBeneficialOwnerOption ,String  GroupBeneficialOwnerCountryOfDomicileOption,String  GroupBeneficialOwnerCompanyCodeOption,String  IHSRegisteredOwnerOption,String  IHSRegisteredOwnerCodeOption,String  IHSRegisteredOwnerCountryOfDomicileOption,String OfficialOption ,String  OperatorOption,String OperatorCompanyCodeOption,String OperatorCountryOfDomicileNameOption ,String  SATCommIDOption,String ShipManagerOption ,String ShipManagerCompanyCodeOption,String ShipManagerCountryOfDomicileOption ,String GrossTonnageOption ,String NetTonnageOption ,String DeadWeightDWTOption ,String DisplacementMTOption ,String LightDisplacementTonnageOption ,String SegregatedBallastCapacityM3Option ,String TEUOption, String TEUCapacity14tHomogenousOption, String DateOfBuildOption, String ShipbuilderOption,String ShipbuilderCompanyCodeOption,String ShipbuilderFullNameOption,String YardNumberOption,String LengthRegisteredOption,String LengthOverallOption,String LengthBetweenPerpendicularsOption,String BreadthExtremeOption,String BreadthMouldedOption,String DraughtOption,String DepthOption,String BowToCentreManifoldOption,String KeelToMastHeightOption,String LeadShipInSeriesByIMOOption,String ShipStatusOption,String StandardShipDesignOption,String ShipTypeLevel2Option,String ShipTypeLevel3Option,String ShipTypeLevel4Option,String ShipTypeLevel5Option,String HullTypeOption,String PassengerCapacityOption, String BaleCapacityOption, String GrainCapacityOption,String GasCapacityOption,String InsulatedCapacityOption,String LiquidCapacityOption,String PowerOption,String SpeedOption,String GenericDropdownOption,String PropertyDescriptionCodeOption,String OverrideExtensionValueOption,String OverrideAmberThresholdOption,String OverrideRedThresholdOption,  String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5, String ExtraOption6, String ExtraOption7, String ExtraOption8, String ExtraOption9, String ExtraOption10, String ExtraOption11, String ExtraOption12, String ExtraOption13, String ExtraOption14, String ExtraOption15, String ExtraOption16, String ExtraOption17 , String ExtraOption18, String ExtraOption19, String ExtraOption20) throws InterruptedException, AWTException {
        //CommonForAll CommonForALl = new CommonForAll(driver);
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

        if(VesselType == "Barge")
        {
            CommonForAll.ClickAndSelectByLiWithoutScroll(Status,StatusOption); ;
            SelectBank(Bank);
            CommonForAll.SendKeys(Rank, RankOption);
            CommonForAll.SendKeys(LRIMOShip, LRIMOShipOption);
            CommonForAll.SendKeys(Hull, HullOption); ;
            CommonForAll.SendKeys(CallSign, CallSignOption); ;
            CommonForAll.SendKeys(ClassificationSociety, ClassificationSocietyOption); ;
            CommonForAll.SendKeys(Fishing, FishingOption); ;
            CommonForAll.SendKeys(ISPSCode, ISPSCodeOption); ;
            CommonForAll.ClickAndSelectByAForYesAndNo(IMSCodeCompliant, IMSCodeCompliantOption, "1");

            CommonForAll.SendKeys(VesselName, VesselNameOption); ;
            //CommonForAll.ClickAndSelectByLiWithoutScroll(FlagCountry,FlagCountryOption); ;
            CommonForAll.SendKeys(DOCCompany, DOCCompanyOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(DOCCompanyCountryOfDomicile, DOCCompanyCountryOfDomicileOption); ;
            CommonForAll.SendKeys(DOCCompanyCode, DOCCompanyCodeOption);
            CommonForAll.SendKeys(PortOfRegistration, PortOfRegistrationOption); ;
            CommonForAll.SendKeys(GroupBeneficialOwner, GroupBeneficialOwnerOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(GroupBeneficialOwnerCountryOfDomicile, GroupBeneficialOwnerCountryOfDomicileOption); ;
            CommonForAll.SendKeys(GroupBeneficialOwnerCompanyCode, GroupBeneficialOwnerCompanyCodeOption); ;
            CommonForAll.SendKeys(IHSRegisteredOwner,IHSRegisteredOwnerOption); ;
            CommonForAll.SendKeys(IHSRegisteredOwnerCode,IHSRegisteredOwnerCodeOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(IHSRegisteredOwnerCountryOfDomicile, IHSRegisteredOwnerCountryOfDomicileOption); ;
            CommonForAll.SendKeys(Official, OfficialOption); ;
            CommonForAll.SendKeys(Operator, OperatorOption); ;
            CommonForAll.SendKeys(OperatorCompanyCode, OperatorCompanyCodeOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(OperatorCountryOfDomicileName, OperatorCountryOfDomicileNameOption); ;
            CommonForAll.SendKeys(SATCommID, SATCommIDOption); ;
            CommonForAll.SendKeys(ShipManager, ShipManagerOption); ;
            CommonForAll.SendKeys(ShipManagerCompanyCode, ShipManagerCompanyCodeOption); ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(ShipManagerCountryOfDomicile, ShipManagerCountryOfDomicileOption); ;
            CommonForAll.SendKeys(GrossTonnage, GrossTonnageOption); ;
            CommonForAll.SendKeys(NetTonnage, NetTonnageOption) ;
            CommonForAll.SendKeys(DeadWeightDWT, DeadWeightDWTOption) ;
            CommonForAll.SendKeys(DisplacementMT,DisplacementMTOption) ;
            CommonForAll.SendKeys(LightDisplacementTonnage, LightDisplacementTonnageOption) ;
            CommonForAll.SendKeys(SegregatedBallastCapacityM3, SegregatedBallastCapacityM3Option) ;
            CommonForAll.SendKeys(TEU, TEUOption) ;
            CommonForAll.SendKeys(TEUCapacity14tHomogenous, TEUCapacity14tHomogenousOption) ;
            CommonForAll.SendKeys(DateOfBuild, DateOfBuildOption) ;
            CommonForAll.SendKeys(Shipbuilder, ShipbuilderOption) ;
            CommonForAll.SendKeys(ShipbuilderCompanyCode, ShipbuilderCompanyCodeOption) ;
            CommonForAll.SendKeys(ShipbuilderFullName, ShipbuilderFullNameOption) ;
            CommonForAll.SendKeys(YardNumber, YardNumberOption) ;
            CommonForAll.SendKeys(LengthRegistered, LengthRegisteredOption) ;
            CommonForAll.SendKeys(LengthOverall, LengthOverallOption) ;
            CommonForAll.SendKeys(LengthBetweenPerpendiculars, LengthBetweenPerpendicularsOption) ;
            CommonForAll.SendKeys(BreadthExtreme, BreadthExtremeOption) ;
            CommonForAll.SendKeys(BreadthMoulded, BreadthMouldedOption) ;
            CommonForAll.SendKeys(Draught, DraughtOption) ;
            CommonForAll.SendKeys(Depth, DepthOption) ;
            CommonForAll.SendKeys(BowToCentreManifold, BowToCentreManifoldOption) ;
            CommonForAll.SendKeys(KeelToMastHeight,KeelToMastHeightOption) ;
            CommonForAll.SendKeys(LeadShipInSeriesByIMO, LeadShipInSeriesByIMOOption) ;
            CommonForAll.SendKeys(ShipStatus, ShipStatusOption) ;
            CommonForAll.SendKeys(StandardShipDesign, StandardShipDesignOption) ;
            CommonForAll.SendKeys(ShipTypeLevel2,ShipTypeLevel2Option) ;
            CommonForAll.SendKeys(ShipTypeLevel3,ShipTypeLevel3Option) ;
            CommonForAll.SendKeys(ShipTypeLevel4,ShipTypeLevel4Option) ;
            CommonForAll.SendKeys(ShipTypeLevel5,ShipTypeLevel5Option) ;
            CommonForAll.SendKeys(HullType,HullTypeOption) ;
            CommonForAll.SendKeys(PassengerCapacity,PassengerCapacityOption) ;
            CommonForAll.SendKeys(BaleCapacity,BaleCapacityOption) ;
            CommonForAll.SendKeys(GrainCapacity,GrainCapacityOption) ;
            CommonForAll.SendKeys(GasCapacity,GasCapacityOption) ;
            CommonForAll.SendKeys(InsulatedCapacity,InsulatedCapacityOption) ;
            CommonForAll.SendKeys(LiquidCapacity,LiquidCapacityOption) ;
            CommonForAll.SendKeys(Power,PowerOption) ;
            CommonForAll.SendKeys(Speed,SpeedOption) ;
            CommonForAll.ClickAndSelectByLiWithoutScroll(GenericDropdown,GenericDropdownOption);
            //CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDescriptionCode, PropertyDescriptionCodeOption);
            CommonForAll.SendKeys(OverrideExtensionValue, OverrideExtensionValueOption);
            CommonForAll.SendKeys(OverrideAmberThreshold,OverrideAmberThresholdOption);
            CommonForAll.SendKeys(OverrideRedThreshold, OverrideRedThresholdOption);
        }

    }


    //endregion

    /**
     *Description: Add To Form And Select Identified By
     * @return
     */
    public void AddToFormWithIdentifiedBy(String TypeOfAsset, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException, AWTException {
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
     *Description: Select Stats
     * @return
     */
    public void SelectAssetStatus(String StatusOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(Status, StatusOption);

    }

    /**
     *Description: Select Property Tenure
     * @return
     */
    public void SelectPropertyTenure(String PropertyTenureOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyTenure, PropertyTenureOption);

    }


    /**
     *Description: Select Real Estate Sub Type
     * @return
     */
    public void SelectRealEstateSubType(String AssetSubTypeOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByLiWithoutScroll(AssetSubType, AssetSubTypeOption);

    }

    /**
     *Description: Select Building Floor Area
     * @return
     */
    public void SelectBuildingFloorArea(String BuildingFloorAreaOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.SendKeys(BuildingFloorArea, BuildingFloorAreaOption);

    }

    /**
     *Description: Select Land Area
     * @return
     */
    public void SelectLandArea(String LandAreaOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.SendKeys(LandArea, LandAreaOption);

    }

    /**
     *Description: Select Property Purchase Indicator
     * @return
     */
    public void SelectPropertyPurchaseIndicator(String PropertyPurchaseIndicatorOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByAForYesAndNo(PropertyPurchaseIndicator, PropertyPurchaseIndicatorOption,"3");

    }

    /**
     *Description: Property Development Status
     * @return
     */
    public void SelectPropertyDevelopmentStatus(String SelectPropertyDevelopmentStatusOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {

        CommonForAll.ClickAndSelectByLiWithoutScroll(PropertyDevelopmentStatus, SelectPropertyDevelopmentStatusOption);

    }



    /**
     *Description: Place of Residence Indicator
     * @return
     */
    public void SelectPlaceOfResidenceIndicator(String PlaceOfResidenceIndicatorOption, String Option1, String Option2, String Option3, String Option4) throws InterruptedException {
        CommonForAll.ClickAndSelectByAForYesAndNo(PlaceOfResidenceIndicator, PlaceOfResidenceIndicatorOption,"1");

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
     *Description: Remove Asset Sub Type
     * @return
     */
    public void RemoveAssetSubType() throws InterruptedException
    {
        CommonForAll.Click(RemoveAssetSubType);
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
        else if(Name == "ANZ") {
            thread.sleep(1000);
            isElementLoaded(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a"));
            driver.findElement(By.xpath("//span[contains(text(), 'ANZx')]//parent::li//a")).click();
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
     *Description: Add ANZx Bank Specifically in Data Filters
     */
    public void AddSpecificBank(String DataFiltersOption) throws InterruptedException, AWTException {
        CommonForAll.Click(DataFilters);
        CommonForAll.Click(AssetSubType);
        CommonForAll.Click(DataFilters);
        CommonForAll.Click(DataFilters);
        thread.sleep(1000);
        //driver.findElement(By.xpath("//*[contains(text(), '"+ DataFiltersOption +"')]//parent::li//a")).click();
        CommonForAll.Click(By.xpath("//*[@data-option-array-index=\"7\"]"));
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
     *Description: Legal Description
     */
    public void LegalDescriptionOfProperty(String Text) throws InterruptedException {
        CommonForAll.SendKeys(LegalDescriptionOfProperty,Text);
    }

    //endregion

    //endregion Create Assets

    //region Link Asset



    /**
     *Description: Asset - xxx Link Verification , Check if the link status is what that is given in Status needed parameter(Only is one link is present)
     */
    public void AssetToXXXLinkStatusVerification(String AssetLinkTo, String StatusNeeded) throws InterruptedException {
        if(AssetLinkTo == "General Insurance")
        {
            thread.sleep(1000);
            CommonForAll.isElementLoaded(By.xpath("//table[@id=\"asset-general-insurance-table\"]//tbody//tr//td[3]//span[1]"));
            CommonForAll.AssertIfTextPresentOnPageByLocatorGetAttribute(By.xpath("//table[@id=\"asset-general-insurance-table\"]//tbody//tr//td[3]//span[1]"), StatusNeeded);

        }
        else if(AssetLinkTo == "Legal Entity")
        {

        }
        else if(AssetLinkTo == "Asset")
        {

        }
        else if(AssetLinkTo == "")
        {}
        else if(AssetLinkTo == "")
        {}
    }

    /**
     *Description: Asset Individual Status Verify from details page
     */
    public void AssetIndividualStatusVerify(String StatusNeeded) throws InterruptedException {
        thread.sleep(1000);
        CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), StatusNeeded);
    }

    /**
     *Description: Open LED in Asset
     * @return
     */
    public void OpenLEDinAsset(int TotalNumberOfColumns) throws InterruptedException {

        try {
            CommonForAll.Click(By.xpath("((//h4[normalize-space(text())='Linked LEDs']//parent::div//parent::div)//div[4]//div//div//table//tbody//tr//td[2]//a)[" + TotalNumberOfColumns + "]"));
        }
        catch (NoSuchElementException e){ }
    }

    /**
     *Description: General Insurance Tab in Asset
     */
    public void GeneralInsuranceTabInAssetClick() throws InterruptedException {
        CommonForAll.Click(GeneralInsuranceTabInAsset);
    }

    /**
     *Description: LED Tab in Asset
     */
    public void LEDTabInAsset() throws InterruptedException {
        CommonForAll.Click(LEDTabInAssetPath);
    }

    /**
     *Description: Property Details Tab in Asset
     */
    public void PropertyDetailsTab() throws InterruptedException {
        CommonForAll.Click(PropertyDetailsTab);
    }

    /**
     *Description: Adding an Id via Id Tab in Asset
     */
    public void LinkIDToAsset(String IDStatusOption, String IsPrimaryOption, String SourceTypeOption, String IDString, String ID2String, String Option1, String Option2, String Option3, String Option4) throws InterruptedException, AWTException {
        CommonForAll.Click(IDTab);
        CommonForAll.Click(AddID);
        CommonForAll.ClickAndSelectByLiWithoutScroll(IDStatus, IDStatusOption);
        CommonForAll.ClickAndSelectByAForYesAndNo(IsPrimary, IsPrimaryOption, "1");
        isElementLoaded(SourceType);
        driver.findElement(SourceType).click();
        isElementLoaded(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]"));
        driver.findElement(By.xpath("//li[contains(text(), '" + SourceTypeOption + "')]")).click();
        if(SourceTypeOption == "") {

            CommonForAll.KeysPressRobotClass(KeyEvent.VK_ESCAPE);

        }else if(SourceTypeOption == "ABC"){
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
            CommonForAll.SendKeys(ID2, ID2String);
        }
        else{
            isElementLoaded(ID);
            driver.findElement(ID).sendKeys(IDString);
        }

        CommonForAll.Click(Save1);
    }

    /**
     *Description: Search Asset and link to Application
     * @return
     */
    public void AssetLinkToApplication(String CreateOrLink, String SearchDealID, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.Click(ApplicationTabInAsset);
        CommonForAll.Click(AttachApplication);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchDealID);
            CommonForAll.Click(SearchButtonAssetApplication);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchDealID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusAssetApplication, StatusOption);
            CommonForAll.Click(Finish);
        } else {

        }

    }

    /**
     *Description: Search Asset and link to General Insurance
     * @return
     */
    public void AssetLinkToGeneralInsurance(String CreateOrLink, String SearchGEID, String StatusOption, String ExtraOption1, String ExtraOption2, String ExtraOption3, String ExtraOption4, String ExtraOption5) throws InterruptedException {
        CommonForAll.Click(GeneralInsuranceTabInAsset);
        CommonForAll.Click(AttachGeneralInsurance);
        if (CreateOrLink == "Link") {

            CommonForAll.Click(LinkToExisting);
            CommonForAll.Click(NextButton);
            CommonForAll.SendKeys(FindEntitiesWith, SearchGEID);
            CommonForAll.Click(SearchButtonAssetGeneralInsurance);
            CommonForAll.SelectSearchedBySearchTermWhileLinking(SearchGEID);
            CommonForAll.Click(NextButton2);
            CommonForAll.ClickAndSelectByLiWithoutScroll(StatusAssetGeneralInsurance, StatusOption);
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

    //endregion  Link Asset

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
     *Description: Get Attribute for ANZx Active Asset Rule
     */
    public void GetAttributePassFailForANZxActiveAssetRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxActiveAssetRule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute for ANZx Asset Data Filter rule
     */
    public void GetAttributePassFailForANZxAssetDataFilterRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetDataFilterrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute for 	ANZx Asset Certificate of Title Reference rule.
     */
    public void GetAttributePassFailForANZxAssetCertificateOfTitleReferenceRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetCertificateofTitleReferencerule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute for ANZx Asset Insurance rule.
     */
    public void GetAttributePassFailForANZxAssetInsuranceRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetInsurancerule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute for ANZx Asset Insurance / Legal Entity Insurer rule.
     */
    public void GetAttributePassFailForANZxAssetInsuranceLegalEntityInsurerRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetInsuranceLegalEntityInsurerrule,"class",TextToCheck);
    }

    /**
     *Description: Get Attribute for ANZx Asset Insurance / Legal Entity Policy Holder rule.
     */
    public void GetAttributePassFailForANZxAssetInsuranceLegalEntityPolicyHolderRule(String TextToCheck) throws InterruptedException {
        CommonForAll.GetAttributeAndPresentOnScreen(ANZxAssetInsuranceLegalEntityPolicyHolderrule,"class",TextToCheck);
    }



    //endregion Eligibility

}



