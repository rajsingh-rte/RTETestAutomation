package TestCases.Sample.Eligibility;

import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.Sample.Application.ApplicationANZ;
import Engine.ObjectRepository.Sample.Collateral.AssetANZ;
import Engine.ObjectRepository.Sample.Collateral.LEDANZ;
import Engine.ObjectRepository.Sample.Facility.FacilityANZ;
import Engine.ObjectRepository.Sample.GeneralInsurance.GeneralInsuranceANZ;
import Engine.ObjectRepository.Sample.HomePageANZ;
import Engine.ObjectRepository.Sample.LegalEntity.LegalEntityANZ;
import Engine.ObjectRepository.Sample.OnboardingFNB.OnboardingANZ;
import Engine.common.BaseTest;
import Engine.common.LoginPage;
import Engine.config.LocalConfig;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by Raj.
 */
public class EligibilityANZTests extends BaseTest {


    private LoginPage loginPage;
    Thread thread = null;
    private static final String ANZUrl = LocalConfig.INSTANCE.ANZUrl();
    private Engine.CommonForAll.CommonForAll CommonForAll;
    private static final Logger log = Logger.getLogger(BaseTest.class);
    private LEDANZ LEDANZ;
    private OnboardingANZ OnboardingANZ;
    private HomePageANZ HomePageANZ;
    private GeneralInsuranceANZ GeneralInsuranceANZ;
    private LegalEntityANZ LegalEntityANZ;
    private ApplicationANZ ApplicationANZ;
    private FacilityANZ FacilityANZ;
    private AssetANZ AssetANZ;


    //public static String LegalEntitySPID = null;


    /**
     * Description: LED Eligibility Scenario
     */
    @Test(groups = { "Eligibility","EligibilityANZ","ANZ","CLIENTAUTO-58" }, description = "LED Eligibility", priority=1)
    public void LEDEligibility() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        ApplicationANZ = new ApplicationANZ(driver);
        GeneralInsuranceANZ = new GeneralInsuranceANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        String GeneralInsuranceID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityServiceProviderID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityServiceProviderID2 = CommonForAll.getRandomNumber11Digits();
        String LegalEntityServiceProviderName = CommonForAll.getRandomAlphabeticString();
        String LegalEntityServiceProviderName2 = CommonForAll.getRandomAlphabeticString();
        String LegalEntityPersonalID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityPersonalID2 = CommonForAll.getRandomNumber11Digits();
        String LegalEntityPersonalName = CommonForAll.getRandomAlphabeticString();
        String LegalEntityPersonalName2 = CommonForAll.getRandomAlphabeticString();
        String AssetID = CommonForAll.getRandomNumber11Digits();
        String GenericFacilityID = CommonForAll.getRandomNumber11Digits();
        String GenericFacilityID2 = CommonForAll.getRandomNumber11Digits();
        String GenericFacilityText = CommonForAll.getRandomAlphabeticString();
        String RegisteredMortgageID = CommonForAll.getRandomNumber11Digits();
        String RegisteredMortgageID2 = CommonForAll.getRandomNumber11Digits();
        String RegisteredMortgageName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Active Personal Legal Entity For Later");
        HomePageANZ.TopMenu("Legal Entity","Personal","","");
        LegalEntityANZ.LegalEntityPersonalCreate("Juristic","OCV ID",LegalEntityPersonalID,LegalEntityPersonalID2,"Mr.",LegalEntityPersonalName,LegalEntityPersonalName2,LegalEntityPersonalName2,"Active","ANZ","Individual","Yes","Active","abc@abc.com","34534534","5646457456","Active", CommonForAll.DateFromCurrentDate(30),"","","","","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Generic Facility For Later");
        HomePageANZ.TopMenu("Facility","Generic Facility","","");
        FacilityANZ.GenericFacilityCreate("Generic Facility","CAP Account Number",GenericFacilityID,GenericFacilityID,GenericFacilityText,"Active","DDA - Overdraft","ILS","XL1","AUD - Australian Dollar","323213","Facility Amount",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100), "ANZ","",GenericFacilityText,"4323","9232","122",CommonForAll.DateFromCurrentDate(-20),"","","","","","","","","","","","","","","","","", "");
        FacilityANZ.Save2();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
//
//        log.info("Add Active General Insurance For Later");
//        HomePageANZ.TopMenu("General Insurance","General Insurance","General Insurance","");
//        GeneralInsuranceANZ.GeneralInsuranceCreate("General Insurance","Policy  Number",GeneralInsuranceID,GeneralInsuranceID,"Active",GeneralInsuranceID,"Industrial Special Risk","Not required in terms of Credit Policy","Yes","ANZx","Yes",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(30),"500","AUD - Australian Dollar", "4534","Yes","546546","sf@d.com","Yes","Yes","","","","","","","","","","","","","","","","","","","","","","");
//        ApplicationANZ.Save1();
//        CommonForAll.AssertIfPresentByText("Open Audit History");
//
//        log.info("Creating Active Insurer Service Provider Legal Entity For Later");
//        HomePageANZ.TopMenu("Legal Entity","Service Provider","","");
//        LegalEntityANZ.LegalEntityServiceProviderCreate("Service Provider","ABN",LegalEntityServiceProviderID,LegalEntityServiceProviderID2,LegalEntityServiceProviderName,LegalEntityServiceProviderName2,LegalEntityServiceProviderName2,"Active","ANZ","Insurer","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
//        LegalEntityANZ.Save1();
//        CommonForAll.AssertIfPresentByText("Details");
//        log.info("Entity is Created!");


        log.info("Creating LED Registered Mortgage");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        driver.navigate().refresh();
        LEDANZ.SelectBank("ANZ");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
        String LEDID = CommonForAll.GetTextAndSaveIt("CLT").substring(27,32);
        System.out.println(LEDID);
        LEDANZ.IneligibleClick();
        thread.sleep(2000);

        log.info("Checking if All the Ineligible reasons are present and all Rules are failing");
        CommonForAll.AssertIfPresentByText("LED Status must be \"Held Pending Perfection\" or \"Held\". When LED is \"Held\" it must have a \"Registered Mortgage\" Document");
        LEDANZ.GetAttributePassFailForANZxLEDHeldPendingPerfectionHeldRule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("LED Data Filter must = \"ANZx\".");
        LEDANZ.GetAttributePassFailForANZxLEDDataFilterrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("LED must be linked to a Facility. Facility Status must be \"Approved\" or \"Active\". Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxLEDFacilityrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Facility must be linked to an Application. Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxLEDFacilityApplicationrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Facility must be linked to a Legal Entity. Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxFacilityLegalEntityrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("LED must be linked to an Asset with Status \"Held Pending Perfection\" or \"Active\". Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxLEDAssetHeldPendingPerfectionruleANZxLEDAssetHeldrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Asset must be linked to \"Active\" Legal Entity with \"Active\" link Status. Role must = Provider.");
        LEDANZ.GetAttributePassFailForANZxAssetLegalEntityrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Asset must have an Address");
        LEDANZ.GetAttributePassFailForANZxAssetmusthaveanaddress("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Asset must have a Valuation.");
        LEDANZ.GetAttributePassFailForANZxAssetmusthaveavaluation("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("LED must be linked to an \"Active\" Application. Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxLEDApplicationrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Application must have a Document of type \"Letter of Offer\".");
        LEDANZ.GetAttributePassFailForANZxApplicationLetterofOfferrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Application must be linked to a Legal Entity. Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxApplicationLegalEntityrule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Application must be linked to an Asset. Link Status must be \"Active\".");
        LEDANZ.GetAttributePassFailForANZxApplicationAssetrule("fa fa-times iconCls failCls");
        LEDANZ.EligibilityClose();

        log.info("**********TESTING FOR RULE 1A | 1B ANZx LED Held Pending Perfection / Held rule**********");

        log.info("Changing Status to Held Pending Perfection for Rule No 1.A...");
        LEDANZ.EditClick();
        LEDANZ.StatusSelect("Held Pending Perfection");
        LEDANZ.Save1();
        LEDANZ.IneligibleClick();
        log.info("Checking if Rule No 1A is passed?");
        LEDANZ.GetAttributePassFailForANZxLEDHeldPendingPerfectionHeldRule("fa fa-check iconCls passCls");
        LEDANZ.EligibilityClose();

        log.info("Changing Status to Held Rule No 1.B...");
        LEDANZ.EditClick();
        LEDANZ.StatusSelect("Held");
        LEDANZ.DocumentDate(CommonForAll.DateFromCurrentDate(0));
        LEDANZ.Save1();
        log.info("Checking if Rule No 1B is Failed? as it need a Document : Registered Mortgage");
        LEDANZ.IneligibleClick();
        LEDANZ.GetAttributePassFailForANZxLEDHeldPendingPerfectionHeldRule("fa fa-times iconCls failCls");
        LEDANZ.EligibilityClose();
        log.info("Adding a document Registered Mortgage so that Rule 1b is passed");
        LEDANZ.AddDocumentSetToLED("Mortgage Documents","ABCD","","","","","");
        //LEDANZ.BackButton2();
        LEDANZ.DetailsTabClick();
        LEDANZ.IneligibleClick();
        log.info("Checking if Rule No 1B is passed?");
        LEDANZ.GetAttributePassFailForANZxLEDHeldPendingPerfectionHeldRule("fa fa-check iconCls passCls");
        LEDANZ.EligibilityClose();


        log.info("**********TESTING FOR RULE 2 ANZx LED Data Filter rule.**********");
        log.info("Adding ANZx bank in data filters");
        LEDANZ.EditClick();
        LEDANZ.StatusSelect("Held Pending Perfection");
        LEDANZ.AddSpecificBank("ANZx");
        LEDANZ.Save1();
        LEDANZ.IneligibleClick();
        log.info("Checking if Rule No 1B is passed?");
        LEDANZ.GetAttributePassFailForANZxLEDDataFilterrule("fa fa-check iconCls passCls");
        LEDANZ.EligibilityClose();

        log.info("**********TESTING FOR RULE 3 ANZx LED Facility rule.**********");
        log.info("Liking Active Facility with Active link to LED");
        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", GenericFacilityID, "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure(GenericFacilityID);
        log.info("Search and Link Collateral");
        FacilityANZ.FacilityLinkToCollateral("Link", LEDID, "Active", "Yes", "1", "3", "", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach LED");
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);
        LEDANZ.EditClick();
        LEDANZ.StatusSelect("Held");
        LEDANZ.Save1();
        LEDANZ.IneligibleClick();
        log.info("Checking if Rule No 3 is passed?");
        LEDANZ.GetAttributePassFailForANZxLEDFacilityrule("fa fa-check iconCls passCls");
        LEDANZ.EligibilityClose();

       //****************************************COMMENTS: CHANGING THE FACILITY STATUS FROM ACTIVE TO APPROVED MAKES THE ELIGIBILITY RULE FAIL**********************************************
//        log.info("Changing the Facility Status to Approved and Checking again if Rule No 3 is passed?");
//        HomePageANZ.SearchMenu("Facility", GenericFacilityID, "", "","","");
//        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure(GenericFacilityID);
//        FacilityANZ.DetailsButton();
//        FacilityANZ.EditButton();
//        FacilityANZ.StatusSelect("Approved");
//        FacilityANZ.Save1();

        log.info("**********TESTING FOR RULE 4|5 ANZx LED Facility / Application rule./ Legal Entity rule.**********");
        log.info("Liking Active Facility with Active Application");
        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", GenericFacilityID, "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure(GenericFacilityID);
        log.info("Search and Link Application");
        FacilityANZ.FacilityLinkToApplication("Link","CLT", "Active", "Yes", "1", "3", "", "");
        CommonForAll.AssertIfPresentByText("Attach Application");

        log.info("Linking Active Legal Entity to Active Facility");
        log.info("Search Legal Entity" + LegalEntityPersonalID);
        HomePageANZ.SearchMenu("Legal Entity", LegalEntityPersonalID, "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LegalEntityPersonalID);
        log.info("Search and Link Facility");
        LegalEntityANZ.LegalEntityLinkToFacility("Link", GenericFacilityID, "Yes", "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach Facility");

        log.info("Opening LED and Checking if Rule 4 and 5 are passed");
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);
        LEDANZ.EditClick();
        LEDANZ.ExpiryDate("08-April-2025");
        LEDANZ.Save1();
        LEDANZ.IneligibleClick();
        LEDANZ.GetAttributePassFailForANZxLEDFacilityApplicationrule("fa fa-check iconCls passCls");
        LEDANZ.GetAttributePassFailForANZxFacilityLegalEntityrule("fa fa-check iconCls passCls");
        LEDANZ.EligibilityClose();










    }

    /**
     * Description: Asset Eligibility Scenario
     */
    @Test(groups = { "Eligibility","EligibilityANZ","ANZ","CLIENTAUTO-58" }, description = "Onboarding End To End Scenario", priority=1)
    public void AssetEligibility() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        ApplicationANZ = new ApplicationANZ(driver);
        GeneralInsuranceANZ = new GeneralInsuranceANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        String GeneralInsuranceID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityServiceProviderID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityServiceProviderID2 = CommonForAll.getRandomNumber11Digits();
        String LegalEntityServiceProviderName = CommonForAll.getRandomAlphabeticString();
        String LegalEntityServiceProviderName2 = CommonForAll.getRandomAlphabeticString();
        String LegalEntityPersonalID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityPersonalID2 = CommonForAll.getRandomNumber11Digits();
        String LegalEntityPersonalName = CommonForAll.getRandomAlphabeticString();
        String LegalEntityPersonalName2 = CommonForAll.getRandomAlphabeticString();
        String AssetID = CommonForAll.getRandomNumber11Digits();

        log.info("Creating Active Personal Legal Entity For Later");
        HomePageANZ.TopMenu("Legal Entity","Personal","","");
        LegalEntityANZ.LegalEntityPersonalCreate("Juristic","OCV ID",LegalEntityPersonalID,LegalEntityPersonalID2,"Mr.",LegalEntityPersonalName,LegalEntityPersonalName2,LegalEntityPersonalName2,"Active","ANZ","Individual","Yes","Active","abc@abc.com","34534534","5646457456","Active", CommonForAll.DateFromCurrentDate(30),"","","","","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Add Active General Insurance For Later");
        HomePageANZ.TopMenu("General Insurance","General Insurance","General Insurance","");
        GeneralInsuranceANZ.GeneralInsuranceCreate("General Insurance","Policy  Number",GeneralInsuranceID,GeneralInsuranceID,"Active",GeneralInsuranceID,"Industrial Special Risk","Not required in terms of Credit Policy","Yes","ANZx","Yes",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(30),"500","AUD - Australian Dollar", "4534","Yes","546546","sf@d.com","Yes","Yes","","","","","","","","","","","","","","","","","","","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");

        log.info("Creating Active Insurer Service Provider Legal Entity For Later");
        HomePageANZ.TopMenu("Legal Entity","Service Provider","","");
        LegalEntityANZ.LegalEntityServiceProviderCreate("Service Provider","ABN",LegalEntityServiceProviderID,LegalEntityServiceProviderID2,LegalEntityServiceProviderName,LegalEntityServiceProviderName2,LegalEntityServiceProviderName2,"Active","ANZ","Insurer","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Asset Real Estate Standard Residential Property");
        HomePageANZ.TopMenu("Collateral","Asset","Real Estate","Standard Residential Property");
        AssetANZ.SelectBank("ANZ");
        AssetANZ.Save1();
        AssetANZ.IneligibleClick();
        log.info("Checking if All the Ineligible reasons are present and all Rules are failing");
        CommonForAll.AssertIfPresentByText("Asset status must be \"Active\".");
        AssetANZ.GetAttributePassFailForANZxActiveAssetRule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Asset Data Filter must = \"ANZx\".");
        AssetANZ.GetAttributePassFailForANZxAssetDataFilterRule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Asset must have an Active Certificate of Title Reference.");
        AssetANZ.GetAttributePassFailForANZxAssetCertificateOfTitleReferenceRule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("Asset must be linked to an \"Active\" General Insurance. Link Status must be \"Active\".");
        AssetANZ.GetAttributePassFailForANZxAssetInsuranceRule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("General Insurance must be linked to \"Active\" Legal Entity with \"Active\" link. Role of Insurance Comp. must be \"Insurer\".");
        AssetANZ.GetAttributePassFailForANZxAssetInsuranceLegalEntityInsurerRule("fa fa-times iconCls failCls");
        CommonForAll.AssertIfPresentByText("General Insurance must be linked to \"Active\" Legal Entity with \"Active\" link. Role of Customer must be \"Policy Holder\".");
        AssetANZ.GetAttributePassFailForANZxAssetInsuranceLegalEntityPolicyHolderRule("fa fa-times iconCls failCls");
        AssetANZ.EligibilityClose();
        AssetANZ.EditClick();

        log.info("Changing Status to Active for Rule No.1...");
        AssetANZ.StatusSelect("Active");
        AssetANZ.AddSpecificBank("ANZx");
        AssetANZ.SelectPropertyTenure("Freehold","","","","");
        AssetANZ.SelectPlaceOfResidenceIndicator("Yes","","","","");
        AssetANZ.SelectPropertyDevelopmentStatus("Vacant Land","","","","");
        log.info("Adding ANZx for Rule No.2...");
        AssetANZ.Save1();

        log.info("Checking Rule no. 1 and Rule No. 2 is Passed?");
        AssetANZ.IneligibleClick();
        AssetANZ.GetAttributePassFailForANZxActiveAssetRule("fa fa-check iconCls passCls");
        AssetANZ.GetAttributePassFailForANZxAssetDataFilterRule("fa fa-check iconCls passCls");
        AssetANZ.EligibilityClose();

        log.info("Adding Active Certificate of Title Reference For Rule No. 3 ...");
        AssetANZ.LinkIDToAsset("Active","Yes","ACT Certificate of Title",AssetID,"","","","","");
        AssetANZ.PropertyDetailsTab();
        log.info("Checking Rule no. 3 is Passed?");
        AssetANZ.IneligibleClick();
        AssetANZ.GetAttributePassFailForANZxAssetCertificateOfTitleReferenceRule("fa fa-check iconCls passCls");
        AssetANZ.EligibilityClose();

        log.info("Link Asset To Active General Insurance with Active Link Status for Rule No. 4");
        AssetANZ.AssetLinkToGeneralInsurance("Link", GeneralInsuranceID, "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");
        AssetANZ.PropertyDetailsTab();
        log.info("Checking Rule no. 4 is Passed?");
        AssetANZ.IneligibleClick();
        AssetANZ.GetAttributePassFailForANZxAssetInsuranceRule("fa fa-check iconCls passCls");
        AssetANZ.EligibilityClose();

        log.info("Link General Insurance with Active Insurer LE Service Provider with Active Link for Rule No. 5");
        log.info("Search Legal Entity" + LegalEntityServiceProviderID);
        HomePageANZ.SearchMenu("Legal Entity", LegalEntityServiceProviderID, "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LegalEntityServiceProviderID);
        log.info("Search and Link General Insurance");
        LegalEntityANZ.LegalEntityLinkToGeneralInsurance("Link", GeneralInsuranceID, "Insurer", "Active", "", "", "", "", "","","","","");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");

        log.info("Link General Insurance with Active Personal LE with Active Link and Role of Policy Holder for Rule No. 6");
        log.info("Search Legal Entity" + LegalEntityPersonalID);
        HomePageANZ.SearchMenu("Legal Entity", LegalEntityPersonalID, "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LegalEntityPersonalID);
        log.info("Search and Link General Insurance");
        LegalEntityANZ.LegalEntityLinkToGeneralInsurance("Link", GeneralInsuranceID, "Policy Holder", "Active", "", "", "", "", "","","","","");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");

        log.info("Opening the Asset Again");
        HomePageANZ.SearchMenu("Asset", AssetID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(AssetID);
        AssetANZ.EditClick();
        AssetANZ.LegalDescriptionOfProperty("ABC");
        AssetANZ.Save1();

        log.info("Checking Rule no. 5 and Rule No. 6 is Passed?");
        
        AssetANZ.EligibleClick();
        AssetANZ.GetAttributePassFailForANZxAssetInsuranceLegalEntityInsurerRule("fa fa-check iconCls passCls");
        AssetANZ.GetAttributePassFailForANZxAssetInsuranceLegalEntityPolicyHolderRule("fa fa-check iconCls passCls");
        AssetANZ.EligibilityClose();



    }


    //endregion Linking Test Cases

}