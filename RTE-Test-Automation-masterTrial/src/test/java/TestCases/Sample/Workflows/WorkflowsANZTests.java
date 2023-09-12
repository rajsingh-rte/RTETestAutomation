package TestCases.Sample.Workflows;

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
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by Raj.
 */
public class WorkflowsANZTests extends BaseTest {


    private LoginPage loginPage;
    Thread thread = null;
    private static final String ANZUrl = LocalConfig.INSTANCE.ANZUrl();
    private Engine.CommonForAll.CommonForAll CommonForAll;
    private static final Logger log = Logger.getLogger(BaseTest.class);
    private LEDANZ LEDANZ;
    private OnboardingANZ OnboardingANZ;
    private LegalEntityANZ LegalEntityANZ;
    private ApplicationANZ ApplicationANZ;
    private FacilityANZ FacilityANZ;
    private AssetANZ AssetANZ;
    private HomePageANZ HomePageANZ;
    private GeneralInsuranceANZ GeneralInsuranceANZ;



    //public static String LegalEntitySPID = null;

    /**
     LED Registered Mortgage
     **/
    public static String LEDID = null;
    public static String LEDID2 = null;
    public static String LEDName = null;

    /**
     Asset Barge ID's
     **/
    public static String BargeID = null;
    public static String BargeID2 = null;
    public static String BargeName = null;

    /**
     Facility Generic Facility
     **/
    public static String GenericFacilityID = null;
    public static String GenericFacilityID2 = null;
    public static String GenericFacilityText = null;

    /**
     Juristic
     **/
    public static String LegalEntityJuristicID = null;
    public static String LegalEntityJuristicCID2 = null;
    public static String LegalEntityJuristicName = null;
    public static String LegalEntityJuristicName2 = null;

    /**
     Add General Insurance
     **/
    public static String GeneralInsuranceID = null;
    public static String GeneralInsuranceID2 = null;
    public static String GeneralInsuranceName = null;


    /**
     * Description: Workflow Full Release, Task Type Full Release
     */
    @Test(groups = { "Workflow","WorkflowANZ","ANZ","CLIENTAUTO-57","CLIENTAUTO-59" }, description = "Onboarding End To End Scenario", priority=1)
    public void WorkFlowReleasedFull() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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


        LEDID = CommonForAll.getRandomNumber11Digits();
        LEDID2 = CommonForAll.getRandomNumber11Digits();
        LEDName = CommonForAll.getRandomAlphabeticString();

        BargeID = CommonForAll.getRandomNumber11Digits();
        BargeID2 = CommonForAll.getRandomNumber11Digits();
        BargeName = CommonForAll.getRandomAlphabeticString();

        GenericFacilityID = CommonForAll.getRandomNumber11Digits();
        GenericFacilityID2 = CommonForAll.getRandomNumber11Digits();
        GenericFacilityText = CommonForAll.getRandomAlphabeticString();

        LegalEntityJuristicID = CommonForAll.getRandomNumber11Digits();
        LegalEntityJuristicCID2 = CommonForAll.getRandomNumber11Digits();
        LegalEntityJuristicName = CommonForAll.getRandomAlphabeticString();
        LegalEntityJuristicName2 = CommonForAll.getRandomAlphabeticString();

        GeneralInsuranceID = CommonForAll.getRandomNumber11Digits();
        GeneralInsuranceID2 = CommonForAll.getRandomNumber11Digits();
        GeneralInsuranceName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating LED");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        LEDANZ.LEDCreation("Registered Mortgage","Registration Number",LEDID,LEDID2,"Held","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",LEDName,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Asset Barge");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Barge");
        AssetANZ.VesselCreation("Barge","IMO code",BargeID,BargeID2,"Active","3545435","345345","435345","34234234","43543454","Yes","Yes","ANZ","ANZx","Australia", "ANZ","Australia","45345345","5345345","9232","Australia","34234","3432423","Australia","Australia","453454","5345354","4353454","Australia","4534","fdfggf","43534","Australia","4353454","43543454","34543454","53454345","53454","454354","342","3424","16-February-2022","234234","324234","dsfsdf","232","32434","324234","234","324","234","2344","324","342","4324","3423","Nice","324","324","324","234","324","324","423","324","234","234","324","234","432","324324","","RUSA","12","45","33","","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Generic Facility");
        HomePageANZ.TopMenu("Facility","Generic Facility","","");
        FacilityANZ.GenericFacilityCreate("Generic Facility","Account Number",GenericFacilityID,GenericFacilityID,GenericFacilityText,"Active","DDA - Overdraft","ILS","XL1","AUD - Australian Dollar","323213","Facility Amount",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100), "ANZ","",GenericFacilityText,"4323","9232","122",CommonForAll.DateFromCurrentDate(-20),"","","","","","","","","","","","","","","","","", "");
        FacilityANZ.Save2();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");

        log.info("Creating Juristic Legal Entity");
        HomePageANZ.TopMenu("Legal Entity","Juristic","","");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","OCV ID",LegalEntityJuristicID,LegalEntityJuristicCID2,LegalEntityJuristicName,LegalEntityJuristicName2,LegalEntityJuristicName2,"Active","ANZ","Partnership","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");

        log.info("Add General Insurance");
        HomePageANZ.TopMenu("General Insurance","General Insurance","General Insurance","");
        GeneralInsuranceANZ.GeneralInsuranceCreate("General Insurance","Policy  Number",GeneralInsuranceID,GeneralInsuranceID,"Active",GeneralInsuranceID,"Industrial Special Risk","Not required in terms of Credit Policy","Yes","ANZx","Yes",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(30),"500","AUD - Australian Dollar", "4534","Yes","546546","sf@d.com","Yes","Yes","","","","","","","","","","","","","","","","","","","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");

        log.info("Link Facility to LED");
        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", GenericFacilityID, "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure(GenericFacilityID);
        log.info("Search and Link LED");
        FacilityANZ.FacilityLinkToLED("Link", LEDID, "Active", "Yes", "1", "3", "", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach LED");

        log.info("Link LED to LE");
        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", LegalEntityJuristicID, "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LegalEntityJuristicID);
        log.info("Search and Link LED");
        LegalEntityANZ.LegalEntityLinkToLED("Link", LEDID, "Borrower", "Active", "", "", "", "", "","","","","");
        CommonForAll.AssertIfPresentByText("Attach LED");

        log.info("Link LED to Asset");
        log.info("Search LED" + LEDID);
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);
        log.info("Search and Link Asset");
        LEDANZ.LEDLinkToAsset("Link", BargeID, "Active", "Yes", "1", "3", "", "","","");
        thread.sleep(1000);
        CommonForAll.AssertIfPresentByText("Attach Asset");

        log.info("Link General Insurance to Asset");
        log.info("Search Asset" + BargeID);
        HomePageANZ.SearchMenu("Asset", BargeID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(BargeID);
        log.info("Search and Link Application");
        AssetANZ.AssetLinkToGeneralInsurance("Link", GeneralInsuranceID, "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");

        log.info("Create Task on LED");
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);

        log.info("*****Creating a Task*****");
        LEDANZ.TaskTabCreation("To Be Released Full","To Be Released Full","Medium","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxLastClick();
        //LEDANZ.ActionCheckBoxAfterFirstClick("2");
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset*****");
        LEDANZ.DetailsTabClick();
        log.info("*****Checking LED status: Should be to be released*****");
        LEDANZ.LEDIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "To Be Released");
        LEDANZ.AssetTabClick();
        LEDANZ.OpenAssetInLED(1);
        log.info("*****Checking Asset Status: Should be To be Released*****");
        AssetANZ.AssetIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "To Be Released");
        AssetANZ.LEDTabInAsset();
        AssetANZ.OpenLEDinAsset(1);

        log.info("*****Creating 2nd Task*****");
        LEDANZ.TaskTabCreation("Released Full","Released Full","Medium","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxAfterFirstClick("2");
        LEDANZ.ActionCheckBoxAfterFirstClick("3");
        LEDANZ.ActionCheckBoxAfterFirstClick("4");
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Opening the Created Task*****");
        //CommonForAll.OpeningATaskByTypeAndPosition("QA Released Full", "1");
        CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-task-taskPriority\"]"), "Medium");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"task-startDate-ro-id\"]"), CommonForAll.DateFromCurrentDate(0));
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"task-startDate-ro-id\"]"), CommonForAll.DateFromCurrentDate(0));
        CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-task-group-id\"]"), "ANZx Support Coach");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxAfterFirstClick("2");
        LEDANZ.ActionCheckBoxAfterFirstClick("3");
        LEDANZ.ActionCheckBoxAfterFirstClick("4");
        LEDANZ.ActionCheckBoxAfterFirstClick("5");
        Thread.sleep(3000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset after Qa Released full*****");
        LEDANZ.DetailsTabClick();
        log.info("Checking LED status - Should be Released -");
        LEDANZ.LEDIndividualStatusVerify("Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "Released");

        log.info("*****Checking LED - Facility Link status - Should be Inactive*****");
        LEDANZ.FacilityTabClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Facility", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"led-exposure-table\"]//tbody//tr//td[4]//span[1]"), "Inactive");

        log.info("*****Checking LED - Legal Entity Link status - Should be Inactive*****");
        LEDANZ.LegalEntityClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Legal Entity", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"ledLinkLegalEntity\"]//tbody//tr//td[3]//span[1]"), "Inactive");

        log.info("*****Checking LED - Asset Link status - Should be Inactive*****");
        LEDANZ.AssetTabClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Asset", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"led-asset-table\"]//tbody//tr//td[4]//span[1]"), "Inactive");

        log.info("*****Checking Asset Status - Should be Released*****");
        LEDANZ.OpenAssetInLED(1);
        AssetANZ.AssetIndividualStatusVerify("Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "Released");

        log.info("*****Checking Asset General Insurance Link - Should be Inactive*****");
        AssetANZ.GeneralInsuranceTabInAssetClick();
        AssetANZ.AssetToXXXLinkStatusVerification("General Insurance", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"asset-general-insurance-table\"]//tbody//tr//td[3]//span[1]"), "Inactive");

        AssetANZ.LEDTabInAsset();
        AssetANZ.OpenLEDinAsset(1);

    }

    /**
     * Description: Workflow Rollback of Full Release, Task Type Rollback of Full Release
     */
    @Test(groups = { "Workflow","WorkflowANZ","ANZ","CLIENTAUTO-57","CLIENTAUTO-61" }, description = "Onboarding End To End Scenario", priority=1)
    public void WorkFlowRollbackOfFullRelease() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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


        LEDID = CommonForAll.getRandomNumber11Digits();
        LEDID2 = CommonForAll.getRandomNumber11Digits();
        LEDName = CommonForAll.getRandomAlphabeticString();

        BargeID = CommonForAll.getRandomNumber11Digits();
        BargeID2 = CommonForAll.getRandomNumber11Digits();
        BargeName = CommonForAll.getRandomAlphabeticString();

        GenericFacilityID = CommonForAll.getRandomNumber11Digits();
        GenericFacilityID2 = CommonForAll.getRandomNumber11Digits();
        GenericFacilityText = CommonForAll.getRandomAlphabeticString();

        LegalEntityJuristicID = CommonForAll.getRandomNumber11Digits();
        LegalEntityJuristicCID2 = CommonForAll.getRandomNumber11Digits();
        LegalEntityJuristicName = CommonForAll.getRandomAlphabeticString();
        LegalEntityJuristicName2 = CommonForAll.getRandomAlphabeticString();

        GeneralInsuranceID = CommonForAll.getRandomNumber11Digits();
        GeneralInsuranceID2 = CommonForAll.getRandomNumber11Digits();
        GeneralInsuranceName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating LED");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        LEDANZ.LEDCreation("Registered Mortgage","Registration Number",LEDID,LEDID2,"Held","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",LEDName,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Asset Barge");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Barge");
        AssetANZ.VesselCreation("Barge","IMO code",BargeID,BargeID2,"Active","3545435","345345","435345","34234234","43543454","Yes","Yes","ANZ","ANZx","Australia", "ANZ","Australia","45345345","5345345","9232","Australia","34234","3432423","Australia","Australia","453454","5345354","4353454","Australia","4534","fdfggf","43534","Australia","4353454","43543454","34543454","53454345","53454","454354","342","3424","16-February-2022","234234","324234","dsfsdf","232","32434","324234","234","324","234","2344","324","342","4324","3423","Nice","324","324","324","234","324","324","423","324","234","234","324","234","432","324324","","RUSA","12","45","33","","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Generic Facility");
        HomePageANZ.TopMenu("Facility","Generic Facility","","");
        FacilityANZ.GenericFacilityCreate("Generic Facility","Account Number",GenericFacilityID,GenericFacilityID,GenericFacilityText,"Active","DDA - Overdraft","ILS","XL1","AUD - Australian Dollar","323213","Facility Amount",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100), "ANZ","",GenericFacilityText,"4323","9232","122",CommonForAll.DateFromCurrentDate(-20),"","","","","","","","","","","","","","","","","", "");
        FacilityANZ.Save2();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");

        log.info("Creating Juristic Legal Entity");
        HomePageANZ.TopMenu("Legal Entity","Juristic","","");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","OCV ID",LegalEntityJuristicID,LegalEntityJuristicCID2,LegalEntityJuristicName,LegalEntityJuristicName2,LegalEntityJuristicName2,"Active","ANZ","Partnership","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");

        log.info("Add General Insurance");
        HomePageANZ.TopMenu("General Insurance","General Insurance","General Insurance","");
        GeneralInsuranceANZ.GeneralInsuranceCreate("General Insurance","Policy  Number",GeneralInsuranceID,GeneralInsuranceID,"Active",GeneralInsuranceID,"Industrial Special Risk","Not required in terms of Credit Policy","Yes","ANZx","Yes",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(30),"500","AUD - Australian Dollar", "4534","Yes","546546","sf@d.com","Yes","Yes","","","","","","","","","","","","","","","","","","","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");

        log.info("Link Facility to LED");
        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", GenericFacilityID, "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure(GenericFacilityID);
        log.info("Search and Link LED");
        FacilityANZ.FacilityLinkToLED("Link", LEDID, "Active", "Yes", "1", "3", "", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach LED");

        log.info("Link LED to LE");
        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", LegalEntityJuristicID, "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LegalEntityJuristicID);
        log.info("Search and Link LED");
        LegalEntityANZ.LegalEntityLinkToLED("Link", LEDID, "Borrower", "Active", "", "", "", "", "","","","","");
        CommonForAll.AssertIfPresentByText("Attach LED");

        log.info("Link LED to Asset");
        log.info("Search LED" + LEDID);
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);
        log.info("Search and Link Asset");
        LEDANZ.LEDLinkToAsset("Link", BargeID, "Active", "Yes", "1", "3", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach Asset");

        log.info("Link General Insurance to Asset");
        log.info("Search Asset" + BargeID);
        HomePageANZ.SearchMenu("Asset", BargeID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(BargeID);
        log.info("Search and Link Application");
        AssetANZ.AssetLinkToGeneralInsurance("Link", GeneralInsuranceID, "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");

        log.info("Create Task on LED");
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);

        log.info("*****Creating a Task*****");
        LEDANZ.TaskTabCreation("To Be Released Full","To Be Released Full","Medium","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxLastClick();
        //LEDANZ.ActionCheckBoxAfterFirstClick("2");
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset*****");
        LEDANZ.DetailsTabClick();
        log.info("*****Checking LED status: Should be to be released*****");
        LEDANZ.LEDIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "To Be Released");
        LEDANZ.AssetTabClick();
        LEDANZ.OpenAssetInLED(1);
        log.info("*****Checking Asset Status: Should be To be Released*****");
        AssetANZ.AssetIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "To Be Released");
        AssetANZ.LEDTabInAsset();
        AssetANZ.OpenLEDinAsset(1);

        log.info("*****Creating 2nd Task*****");
        LEDANZ.TaskTabCreation("Released Full","Released Full","Medium","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxAfterFirstClick("2");
        LEDANZ.ActionCheckBoxAfterFirstClick("3");
        LEDANZ.ActionCheckBoxAfterFirstClick("4");
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Opening the Created Task*****");
        //CommonForAll.OpeningATaskByTypeAndPosition("QA Released Full", "1");
        CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-task-taskPriority\"]"), "Medium");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"task-startDate-ro-id\"]"), CommonForAll.DateFromCurrentDate(0));
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"task-startDate-ro-id\"]"), CommonForAll.DateFromCurrentDate(0));
        CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-task-group-id\"]"), "ANZx Support Coach");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxAfterFirstClick("2");
        LEDANZ.ActionCheckBoxAfterFirstClick("3");
        LEDANZ.ActionCheckBoxAfterFirstClick("4");
        LEDANZ.ActionCheckBoxAfterFirstClick("5");
        Thread.sleep(3000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset after Qa Released full*****");
        LEDANZ.DetailsTabClick();
        log.info("Checking LED status - Should be Released -");
        LEDANZ.LEDIndividualStatusVerify("Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "Released");

        log.info("*****Checking LED - Facility Link status - Should be Inactive*****");
        LEDANZ.FacilityTabClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Facility", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"led-exposure-table\"]//tbody//tr//td[4]//span[1]"), "Inactive");

        log.info("*****Checking LED - Legal Entity Link status - Should be Inactive*****");
        LEDANZ.LegalEntityClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Legal Entity", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"ledLinkLegalEntity\"]//tbody//tr//td[3]//span[1]"), "Inactive");

        log.info("*****Checking LED - Asset Link status - Should be Inactive*****");
        LEDANZ.AssetTabClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Asset", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"led-asset-table\"]//tbody//tr//td[4]//span[1]"), "Inactive");

        log.info("*****Checking Asset Status - Should be Released*****");
        LEDANZ.OpenAssetInLED(1);
        AssetANZ.AssetIndividualStatusVerify("Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "Released");

        log.info("*****Checking Asset General Insurance Link - Should be Inactive*****");
        AssetANZ.GeneralInsuranceTabInAssetClick();
        AssetANZ.AssetToXXXLinkStatusVerification("General Insurance", "Inactive");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"asset-general-insurance-table\"]//tbody//tr//td[3]//span[1]"), "Inactive");

        AssetANZ.LEDTabInAsset();
        AssetANZ.OpenLEDinAsset(1);

        log.info("*****Creating Rollback of Full Release Task*****");
        LEDANZ.TaskTabCreation("Rollback of Full Release Error","Rollback of Full Release Error","High","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxAfterFirstClick("2");
        LEDANZ.ActionCheckBoxAfterFirstClick("3");
        LEDANZ.ActionCheckBoxLastClick();
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset after Rollback of Full release task*****");
        LEDANZ.DetailsTabClick();
        log.info("*****Checking LED status - Should be To Be Released*****");
        LEDANZ.LEDIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "Released");

        log.info("*****Checking LED - Facility Link status - Should be Active*****");
        LEDANZ.FacilityTabClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Facility", "Active");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"led-exposure-table\"]//tbody//tr//td[4]//span[1]"), "Inactive");

        log.info("*****Checking LED - Legal Entity Link status - Should be Active*****");
        LEDANZ.LegalEntityClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Legal Entity", "Active");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"ledLinkLegalEntity\"]//tbody//tr//td[3]//span[1]"), "Inactive");

        log.info("*****Checking LED - Asset Link status - Should be Active*****");
        LEDANZ.AssetTabClick();
        LEDANZ.LEDToXXXLinkStatusVerification("Asset", "Active");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"led-asset-table\"]//tbody//tr//td[4]//span[1]"), "Inactive");

        log.info("*****Checking Asset Status - Should be To Be Released*****");
        LEDANZ.OpenAssetInLED(1);
        AssetANZ.AssetIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "Released");

        log.info("*****Checking Asset General Insurance Link - Should be Active*****");
        AssetANZ.GeneralInsuranceTabInAssetClick();
        AssetANZ.AssetToXXXLinkStatusVerification("General Insurance", "Active");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//table[@id=\"asset-general-insurance-table\"]//tbody//tr//td[3]//span[1]"), "Inactive");

        AssetANZ.LEDTabInAsset();
        AssetANZ.OpenLEDinAsset(1);



    }

    /**
     * Description: Workflow Withdraw, Task Type Withdraw
     */
    @Test(groups = { "Workflow","WorkflowANZ","ANZ","CLIENTAUTO-57", "CLIENTAUTO-60" }, description = "Onboarding End To End Scenario", priority=1)
    public void WorkFlowWithdraw() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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


        LEDID = CommonForAll.getRandomNumber11Digits();
        LEDID2 = CommonForAll.getRandomNumber11Digits();
        LEDName = CommonForAll.getRandomAlphabeticString();

        BargeID = CommonForAll.getRandomNumber11Digits();
        BargeID2 = CommonForAll.getRandomNumber11Digits();
        BargeName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating LED");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        LEDANZ.LEDCreation("Registered Mortgage","Registration Number",LEDID,LEDID2,"Held","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",LEDName,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Creating Asset Barge");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Barge");
        AssetANZ.VesselCreation("Barge","IMO code",BargeID,BargeID2,"Active","3545435","345345","435345","34234234","43543454","Yes","Yes","ANZ","ANZx","Australia", "ANZ","Australia","45345345","5345345","9232","Australia","34234","3432423","Australia","Australia","453454","5345354","4353454","Australia","4534","fdfggf","43534","Australia","4353454","43543454","34543454","53454345","53454","454354","342","3424","16-February-2022","234234","324234","dsfsdf","232","32434","324234","234","324","234","2344","324","342","4324","3423","Nice","324","324","324","234","324","324","423","324","234","234","324","234","432","324324","","RUSA","12","45","33","","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");

        log.info("Link LED to Asset");
        log.info("Search LED" + LEDID);
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);
        log.info("Search and Link Asset");
        LEDANZ.LEDLinkToAsset("Link", BargeID, "Active", "Yes", "1", "3", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach Asset");

        log.info("Create Task on LED");
        HomePageANZ.SearchMenu("LED", LEDID, "", "","","");
        CommonForAll.SearchedSelectBySearchTerm(LEDID);

        log.info("*****Creating a Task*****");
        LEDANZ.TaskTabCreation("To Be Released Full","To Be Released Full","Medium","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxLastClick();
        //LEDANZ.ActionCheckBoxAfterFirstClick("2");
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset*****");
        LEDANZ.DetailsTabClick();
        log.info("*****Checking LED status: Should be to be released*****");
        LEDANZ.LEDIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "To Be Released");
        LEDANZ.AssetTabClick();
        LEDANZ.OpenAssetInLED(1);
        log.info("*****Checking Asset Status: Should be To be Released*****");
        AssetANZ.AssetIndividualStatusVerify("To Be Released");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "To Be Released");
        AssetANZ.LEDTabInAsset();
        AssetANZ.OpenLEDinAsset(1);

        log.info("*****Creating WITHDRAW Task*****");
        LEDANZ.TaskTabCreation("Withdraw","Withdraw","High","Not started",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(2),"ANZx Support Coach","");
        LEDANZ.ActionCheckBoxFirstClick();
        LEDANZ.ActionCheckBoxAfterFirstClick("2");
        LEDANZ.ActionCheckBoxLastClick();
        Thread.sleep(5000);
        LEDANZ.BackButton();

        log.info("*****Checking statuses for LED and Asset after Withdraw Task*****");
        LEDANZ.DetailsTabClick();
        log.info("Checking LED status - Should be Held -");
        LEDANZ.LEDIndividualStatusVerify("Held");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-legalEnforceableDocument-statusCd\"]"), "Released");

        log.info("*****Checking Asset Status - Should be Active*****");
        LEDANZ.AssetTabClick();
        LEDANZ.OpenAssetInLED(1);
        AssetANZ.AssetIndividualStatusVerify("Active");
        //CommonForAll.AssertIfTextPresentOnPageByLocator(By.xpath("//*[@id=\"dd-selected-asset-statusCd\"]"), "Released");


    }


    //endregion Linking Test Cases

}