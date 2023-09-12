package TestCases.Sample.Drools;

import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.Sample.Application.ApplicationANZ;
import Engine.ObjectRepository.Sample.Collateral.AssetANZ;
import Engine.ObjectRepository.Sample.Collateral.LEDANZ;
import Engine.ObjectRepository.Sample.Facility.FacilityANZ;
import Engine.ObjectRepository.Sample.GeneralInsurance.GeneralInsuranceANZ;
import Engine.ObjectRepository.Sample.HomePageANZ;
import Engine.ObjectRepository.Sample.LegalEntity.LegalEntityANZ;
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
public class DroolsANZTests extends BaseTest {

    private LoginPage loginPage;
    Thread thread = null;
    private static final String ANZUrl = LocalConfig.INSTANCE.ANZUrl();
    private Engine.CommonForAll.CommonForAll CommonForAll;
    private static final Logger log = Logger.getLogger(BaseTest.class);
    private HomePageANZ HomePageANZ;
    private LegalEntityANZ LegalEntityANZ;
    private FacilityANZ FacilityANZ;
    private LEDANZ LEDANZ;
    private AssetANZ AssetANZ;
    private GeneralInsuranceANZ GeneralInsuranceANZ;
    private ApplicationANZ ApplicationANZ;

    /**
     Juristic
     **/
    public static String LegalEntityJuristicID = null;
    public static String LegalEntityJuristicCID2 = null;
    public static String LegalEntityJuristicName = null;
    public static String LegalEntityJuristicName2 = null;


    //region Drools

    /**
     * Description: Legal Entity Juristic Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void LegalEntityJuristicDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();
//
        LegalEntityJuristicID = CommonForAll.getRandomNumber11Digits();
        LegalEntityJuristicCID2 = CommonForAll.getRandomNumber11Digits();
        LegalEntityJuristicName = CommonForAll.getRandomAlphabeticString();
        LegalEntityJuristicName2 = CommonForAll.getRandomAlphabeticString();

        log.info("Checking Legal Entity Juristic Drools");
        HomePageANZ.TopMenu("Legal Entity","Juristic","","");
        LegalEntityANZ.AddToFormClick();
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Legal Registered Name is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
        LegalEntityANZ.RemoveFromForm();
        //LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityJuristicID,LegalEntityJuristicCID2,LegalEntityJuristicName,LegalEntityJuristicName2,LegalEntityJuristicName2,"Active","ANZ","Partnership - Regulated","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.AddToFormWithIdentifiedBy("Juristic", "OCV ID","","","","","","");
        LegalEntityANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        LegalEntityANZ.SelectBank("");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
    }

    /**
     * Description: Add Legal Entity Personal Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void LegalEntityPersonalDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();
//

        log.info("Checking Legal Entity Personal Drools");
        HomePageANZ.TopMenu("Legal Entity","Personal","","");
        LegalEntityANZ.AddToFormClick();
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-First Name is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Legal Entity Sub-Type is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-KYC Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Surname is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Title is mandatory");
        LegalEntityANZ.RemoveFromForm();
        //LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityJuristicID,LegalEntityJuristicCID2,LegalEntityJuristicName,LegalEntityJuristicName2,LegalEntityJuristicName2,"Active","ANZ","Partnership - Regulated","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.AddToFormWithIdentifiedBy("Juristic", "OCV ID","","","","","","");
        LegalEntityANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        LegalEntityANZ.SelectBank("");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
    }

    /**
     * Description: Legal Entity Service Provider Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void LegalEntityServiceProviderDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();
//

        log.info("Checking Legal Entity Personal Drools");
        HomePageANZ.TopMenu("Legal Entity","Service Provider","","");
        LegalEntityANZ.AddToFormClick();
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Legal Registered Name is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
        LegalEntityANZ.RemoveFromForm();
        //LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityJuristicID,LegalEntityJuristicCID2,LegalEntityJuristicName,LegalEntityJuristicName2,LegalEntityJuristicName2,"Active","ANZ","Partnership - Regulated","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.AddToFormWithIdentifiedBy("Juristic", "ABN","","","","","","");
        LegalEntityANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        LegalEntityANZ.SelectBank("");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
    }


    /**
     * Description: Facility Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void FacilityDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("Checking Facility Drools");
        HomePageANZ.TopMenu("Facility","Generic Facility","","");
        FacilityANZ.AddToFormClick();
        FacilityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Facility Limit is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Origination LVR Calculation Date is Mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Origination LVR is Mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Facility Type is mandatory");

        CommonForAll.AssertIfPresentByText("");
        FacilityANZ.RemoveFromForm();
        FacilityANZ.AddToFormWithIdentifiedBy("Generic Facility","LEX Product ID","","","","","","");
        FacilityANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        FacilityANZ.RemoveCompareTo();
        CommonForAll.MouseMoveAndClick(250,250);
        LegalEntityANZ.SelectBank("");
        FacilityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Facility Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Compare To is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfNotPresentByText("RK02005-Facility Limit is mandatory","RK02005-Facility Limit is mandatory");

        driver.navigate().refresh();
        FacilityANZ.SelectFacilityStatus("Active","","","","","");
        FacilityANZ.SelectFacilityLimit("200","","","","");
        LegalEntityANZ.SelectBank("ANZx");
        FacilityANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Facility Type is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-Product Code is mandatory when Status is Active");
        CommonForAll.AssertIfPresentByText("RK02005-Start Date is mandatory when Status is Active");
        //CommonForAll.AssertIfPresentByText("RK02005-Sub-product Code is mandatory when Status is Active");
        CommonForAll.AssertIfPresentByText("RK02005-Facility Currency is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Maturity Date is mandatory when Status is Active");

    }



    /**
     * Description: Security Interest Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void SecurityInterestDroolsRegisteredMortgage() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LEDANZ = new LEDANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("Checking Security Interest Drools");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        LEDANZ.AddToFormClick();
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        LEDANZ.RemoveFromForm();
        LEDANZ.AddToFormWithIdentifiedBy("Registered Mortgage","Solicitor Reference","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        LEDANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        LEDANZ.SelectBank("");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        LEDANZ.SelectLEDStatus("Held","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Document Date is mandatory");

        LEDANZ.SelectLEDStatus("To Be Released","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Document Date is mandatory");

        LEDANZ.SelectLEDStatus("To Be Realised","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Document Date is mandatory");

        LEDANZ.SelectLEDStatus("Released","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Document Date is mandatory");

        LEDANZ.SelectLEDStatus("Realised","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Document Date is mandatory");

    }

    /**
     * Description: Asset Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetVesselDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Vessel Barge*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Barge");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Bulk Carrier*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Bulk Carrier");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Cargo Ship*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Cargo Ship");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Container Ship*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Container Ship");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Crude Tanker - Suesmax*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Crude Tanker - Suesmax");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Crude Tanker - VLCC*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Crude Tanker - VLCC");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Fishing Vessel*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Fishing Vessel");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Motor Ship*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Motor Ship");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Other*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Other");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Passenger Ferry*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Passenger Ferry");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Pleasure Boat*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Pleasure Boat");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Tanker*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Tanker");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Trawler*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Trawler");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        log.info("*********************Checking Asset Vessel Tug Boat*********************");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Tug Boat");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Barge","Serial Number","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250,250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");


    }

    /**
     * Description: Asset Real Estate Drools Standard Residential Property
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateStandardResidentialPropertyDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate Standard Residential Property*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Standard Residential Property");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectPropertyTenure("Crown Lease", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Residential Homes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Residential Units","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Residential Townhouses","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Rural Residential Housing up to 10 ha","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("ACT Leasehold","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Multiple Strata Titled Properties; Same Body Corp","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Vacant Land - Fully Serviced, < 2 ha","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Withdrawn", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Residential Homes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Residential Homes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");


    }

    /**
     * Description: Asset Real Estate Drools Luxury Residential
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateLuxuryResidentialDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate Luxury Residential*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Luxury Residential");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Multiple Strata Titled Properties; Same Body Corp","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Taken", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Multiple Strata Titled Properties; Same Body Corp","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory", "Drool Principal Place of Residence Indicator");

    }


    /**
     * Description: Asset Real Estate Drools Residential Construction - Standard
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateResidentialConstructionStandardDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Residential Construction - Standard");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Construction > 1 Dwelling","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Construction > 1 Dwelling","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Draft", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Construction > 1 Dwelling","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }

    /**
     * Description: Asset Residential Construction - Standard
     */
/*    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateResidentialConstructionStandardDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Residential Construction - Standard");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Construction > 1 Dwelling","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }

    */

    /**
     * Description: Asset Real Estate Drools Luxury Residential Construction
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateLuxuryResidentialConstructionDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Luxury Residential Construction");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Construction > 1 Dwelling","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");




    }

    /**
     * Description: Asset Real Estate Drools Residential < $4 Million, 40–50 SqM
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateResidential$4Million4050SqMDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Residential < $4 Million, 40-50 SqM");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");


        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Multiple Strata Titled Properties; Same Body Corp","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");


    }

    /**
     * Description: Asset Real Estate Drools Residential Property < 40 SqM
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateResidentialProperty40SqMDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Residential Property < 40 SqM");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");


        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Multiple Strata Titled Properties; Same Body Corp","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");


    }

    /**
     * Description: Asset Real Estate Drools Warehouse Units & Apartments
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateWarehouseUnitsApartmentsDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Warehouse Units  & Apartments");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }

    /**
     * Description: Asset Real Estate Drools Bedsitter / Studio Apartments
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateBedsitterStudioApartmentsDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Bedsitter / Studio Apartments");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
    }

    /**
     * Description: Asset Real Estate Drools Hotel / Motel Redevelopment - Residential Strata Title
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateHotelMotelRedevelopmentResidentialStrataTitleDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Hotel / Motel Redevelopment - Residential Strata Title");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");


    }

    /**
     * Description: Asset Real Estate Drools Multi-Dwellings on 1 Title
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateMultiDwellingson1TitleDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Multi-Dwellings On 1 Title");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }

    /**
     * Description: Asset Real Estate Drools Rural Non-Standard Residential Property
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateRuralNonStandardResidentialPropertyDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Rural Non-Standard Residential Property");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Rural Residential, > 10 ha & < 50 ha","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.RemoveAssetSubType();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Vacant Land-Fully Serviced, between 2 ha to 10 ha","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");

        AssetANZ.SelectAssetStatus("Withdrawn", "", "", "", "");
        AssetANZ.SelectRealEstateSubType("Vacant Land - Not Fully Serviced, up to 10 ha","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory","Drool RK02005-\"Principal Place of Residence Indicator\" is mandatory");
    }

    /**
     * Description: Asset Real Estate Drools Off-The-Plan; < 6 Months to Completion
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateOffThePlan6MonthstoCompletionDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Off-The-Plan; < 6 Months to Completion");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
    }


    /**
     * Description: Asset Real Estate Drools Student Accommodation / University Apartments
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateStudentAccommodationUniversityApartmentsDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Student Accommodation / University Apartments");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



//        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");
//
//        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }

    /**
     * Description: Asset Real Estate Drools Leasehold Property (Except ACT)
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateLeaseholdPropertyExceptACTDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Leasehold Property (Except ACT)");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");

        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");

        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }

    /**
     * Description: Asset Real Estate Drools Housing; Aged (Freehold Title)
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateHousingAgedFreeholdTitleDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Housing; Aged (Freehold Title)");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



//        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");
//
//        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
    }

    /**
     * Description: Asset Real Estate DroolsServiced Apartment - Retail Only
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetRealEstateServicedApartmentRetailOnly() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Real Estate Serviced Apartment - Retail Only*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Real Estate", "Serviced Apartment - Retail Only");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Standard Residential Property", "GNAF ID", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");

        AssetANZ.SelectAssetStatus("To Be Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("To Be Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Realised", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Tenure\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectPropertyTenure("Leasehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");


        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyTenure("Freehold", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"Leasehold Expiry Date\" is mandatory","Leasehold Expiry Date");
        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"Property Development Status\" is mandatory");



        log.info("Checking for **********RK02005-Building Floor Area Units is mandatory &&  RK02005-Land Area Units is mandatory*****************");
        AssetANZ.SelectBuildingFloorArea("120","","","","");
        AssetANZ.SelectLandArea("120","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Land Area Units is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Building Floor Area Units is mandatory");


        log.info("Checking for **********RK02005-\"First Home Buyer Flag\" is mandatory &&  RK02005-\"On Market Transaction\" is mandatory*****************");
        AssetANZ.SelectAssetStatus("Released", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-\"On Market Transaction\" is mandatory");

        AssetANZ.SelectAssetStatus("Held Pending Perfection", "", "", "", "");
        AssetANZ.SelectPropertyPurchaseIndicator("Yes","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-\"First Home Buyer Flag\" is mandatory", "Drool First Home Buyer Flag");



//        log.info("Checking for RK02005-\"Principal Place of Residence Indicator\" is mandatory*****************");
//
//        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
//        AssetANZ.Save1();
//        //CommonForAll.AssertIfPresentByText("RK02005-\"Principal Place of Residence Indicator\" is mandatory");

    }


//    /**
//     * Description: Asset Generic Asset Category Commodities
//     */
//    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
//    public void AssetGenericAssetCategoryCommodities() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//        driver.get(ANZUrl);
//        loginPage = new LoginPage(driver);
//        HomePageANZ = new HomePageANZ(driver);
//        LegalEntityANZ = new LegalEntityANZ(driver);
//        AssetANZ = new AssetANZ(driver);
//        FacilityANZ = new FacilityANZ(driver);
//        CommonForAll = new CommonForAll(driver);
//        loginPage.loginANZ();
//
//        log.info("*********************Checking Asset Commodities*********************");
//        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Commodities");
//        AssetANZ.AddToFormClick();
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
//
//        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Commodities", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
//
//        AssetANZ.RemoveStatus();
//        CommonForAll.MouseMoveAndClick(250, 250);
//        AssetANZ.SelectBank("");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
//
//        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfNotPresentByText("RK02005-Class / Type* is mandatory", "Class / Type* ");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Nationality* is mandatory","Nationality");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Field One is mandatory","Custom Field One");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Valuer Name is mandatory","Valuer Name"); //ERROR HERE
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Dropdown One is mandatory","Custom Dropdown One");
//
//    }

    /**
     * Description: Asset Generic Asset Category Company Charge - Audited
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryCompanyChargeAudited() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Category Company Charge - Audited*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Company Charge - Audited");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Company Charge - Audited", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-Class / Type* is mandatory", "Class / Type* ");
        CommonForAll.AssertIfNotPresentByText("RK02005-Nationality* is mandatory","Nationality");
        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Field One is mandatory","Custom Field One");
        CommonForAll.AssertIfNotPresentByText("RK02005-Valuer Name is mandatory","Valuer Name"); //ERROR HERE
        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Dropdown One is mandatory","Custom Dropdown One");

    }

    /**
     * Description: Asset Generic Asset Category Company Charge - Unaudited
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryCompanyChargeUnaudited() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Company Charge - Unaudited*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Company Charge - Unaudited");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Company Charge - Unaudited", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfNotPresentByText("RK02005-Class / Type* is mandatory", "Class / Type* ");
        CommonForAll.AssertIfNotPresentByText("RK02005-Nationality* is mandatory","Nationality");
        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Field One is mandatory","Custom Field One");
        CommonForAll.AssertIfNotPresentByText("RK02005-Valuer Name is mandatory","Valuer Name"); //ERROR HERE
        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Dropdown One is mandatory","Custom Dropdown One");

    }

//    /**
//     * Description: Asset Generic Asset Category Inventory
//     */
//    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
//    public void AssetGenericAssetCategoryInventory() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//        driver.get(ANZUrl);
//        loginPage = new LoginPage(driver);
//        HomePageANZ = new HomePageANZ(driver);
//        LegalEntityANZ = new LegalEntityANZ(driver);
//        AssetANZ = new AssetANZ(driver);
//        FacilityANZ = new FacilityANZ(driver);
//        CommonForAll = new CommonForAll(driver);
//        loginPage.loginANZ();
//
//        log.info("*********************Checking Asset Inventory*********************");
//        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Inventory");
//        AssetANZ.AddToFormClick();
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
//
//        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Inventory", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
//
//        AssetANZ.RemoveStatus();
//        CommonForAll.MouseMoveAndClick(250, 250);
//        AssetANZ.SelectBank("");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
//
//        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfNotPresentByText("RK02005-Class / Type* is mandatory", "Class / Type* ");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Nationality* is mandatory","Nationality");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Field One is mandatory","Custom Field One");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Valuer Name is mandatory","Valuer Name"); //ERROR HERE
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Dropdown One is mandatory","Custom Dropdown One");
//
//    }
//
//    /**
//     * Description: Asset Generic Asset Category Miscellaneous Security Item
//     */
//    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
//    public void AssetGenericAssetCategoryMiscellaneousSecurityItem() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//        driver.get(ANZUrl);
//        loginPage = new LoginPage(driver);
//        HomePageANZ = new HomePageANZ(driver);
//        LegalEntityANZ = new LegalEntityANZ(driver);
//        AssetANZ = new AssetANZ(driver);
//        FacilityANZ = new FacilityANZ(driver);
//        CommonForAll = new CommonForAll(driver);
//        loginPage.loginANZ();
//
//        log.info("*********************Checking Asset Miscellaneous Security Item*********************");
//        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Miscellaneous Security Item");
//        AssetANZ.AddToFormClick();
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
//
//        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Miscellaneous Security Item", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
//
//        AssetANZ.RemoveStatus();
//        CommonForAll.MouseMoveAndClick(250, 250);
//        AssetANZ.SelectBank("");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
//
//        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfNotPresentByText("RK02005-Class / Type* is mandatory", "Class / Type* ");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Nationality* is mandatory","Nationality");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Field One is mandatory","Custom Field One");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Valuer Name is mandatory","Valuer Name"); //ERROR HERE
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Dropdown One is mandatory","Custom Dropdown One");
//
//    }
//
//    /**
//     * Description: Asset Generic Asset Category Motor Vehicle
//     */
//    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
//    public void AssetGenericAssetCategoryMotorVehicle() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//        driver.get(ANZUrl);
//        loginPage = new LoginPage(driver);
//        HomePageANZ = new HomePageANZ(driver);
//        LegalEntityANZ = new LegalEntityANZ(driver);
//        AssetANZ = new AssetANZ(driver);
//        FacilityANZ = new FacilityANZ(driver);
//        CommonForAll = new CommonForAll(driver);
//        loginPage.loginANZ();
//
//        log.info("*********************Checking Asset Motor Vehicle*********************");
//        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Motor Vehicle");
//        AssetANZ.AddToFormClick();
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
//
//        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Motor Vehicle", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
//
//        AssetANZ.RemoveStatus();
//        CommonForAll.MouseMoveAndClick(250, 250);
//        AssetANZ.SelectBank("");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
//
//        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Class / Type* is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Nationality* is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Custom Field One is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Valuer Name is mandatory"); //ERROR HERE
//        CommonForAll.AssertIfPresentByText("RK02005-Custom Dropdown One is mandatory");
//
//    }
//
//    /**
//     * Description: Asset Generic Asset Category Receivables
//     */
//    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
//    public void AssetGenericAssetCategoryReceivables() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//        driver.get(ANZUrl);
//        loginPage = new LoginPage(driver);
//        HomePageANZ = new HomePageANZ(driver);
//        LegalEntityANZ = new LegalEntityANZ(driver);
//        AssetANZ = new AssetANZ(driver);
//        FacilityANZ = new FacilityANZ(driver);
//        CommonForAll = new CommonForAll(driver);
//        loginPage.loginANZ();
//
//        log.info("*********************Checking Asset Receivables*********************");
//        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Receivables");
//        AssetANZ.AddToFormClick();
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");
//
//        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Receivables", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");
//
//        AssetANZ.RemoveStatus();
//        CommonForAll.MouseMoveAndClick(250, 250);
//        AssetANZ.SelectBank("");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
//        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
//
//        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfNotPresentByText("RK02005-Class / Type* is mandatory", "Class / Type* ");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Nationality* is mandatory","Nationality");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Field One is mandatory","Custom Field One");
//        CommonForAll.AssertIfNotPresentByText("RK02005-Valuer Name is mandatory","Valuer Name"); //ERROR HERE
//        CommonForAll.AssertIfNotPresentByText("RK02005-Custom Dropdown One is mandatory","Custom Dropdown One");
//
//    }


    /**
     * Description: Asset Generic Asset Category Cotton - Retail Only
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryCottonRetailOnly() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Water Rights*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Cotton - Retail Only");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Cotton - Retail Only", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
    }

    /**
     * Description: Asset Generic Asset Category Cotton - Wholesale Only
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryCottonWholesaleOnly() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Water Rights*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Cotton - Wholesale Only");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Cotton - Wholesale Only", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
    }

    /**
     * Description: Asset Generic Asset Category Crops Other
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryWaterRights() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Crops Other*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Crops Other");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Crops Other", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Access Rights(Megalitres) is mandatory");

    }

    /**
     * Description: Asset Generic Asset Category Australian Beef Cattle
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryAustralianBeefCattle() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Australian Beef Cattle*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Australian Beef Cattle");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Australian Beef Cattle", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();

    }

    /**
     * Description: Asset Generic Asset Category Australian Dairy Herds
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryAustralianDairyHerds() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Australian Dairy Herds*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Australian Dairy Herds");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Australian Dairy Herds", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();

    }

    /**
     * Description: Asset Generic Asset Category Other Livestock
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetGenericAssetCategoryOtherLivestock() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Other Livestock*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Generic Asset Category", "Other Livestock");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Other Livestock", "Serial Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();

    }

    /**
     * Description: Asset Cash On Deposit External Cash Deposit
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetCashOnDepositExternalCashDeposit() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset External Cash Deposit*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Cash on Deposit", "Cash - Deposit with ANZ");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        //AssetANZ.AddToFormWithIdentifiedBy("External Cash Deposit", "Serial Number", "", "", "", "", "", "");
        //AssetANZ.Save1();
        //CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
    }

    /**
     * Description: Asset Cash On Deposit Internal Cash Deposit
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetCashOnDepositInternalCashDeposit() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Internal Cash Deposit*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Cash on Deposit", "Cash - Deposit with ANZ");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        //AssetANZ.AddToFormWithIdentifiedBy("Internal Cash Deposit", "Serial Number", "", "", "", "", "", "");
        //AssetANZ.Save1();
        //CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
    }



    /**
     * Description: Asset Life Insurance Life Policy
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetLifeInsuranceLifePolicy() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Life Policy*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Life Insurance", "Life Insurance Policy");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
        AssetANZ.AddToFormWithIdentifiedBy("Life Policy", "Policy  Number", "", "", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");

        AssetANZ.SelectAssetStatus("Active", "", "", "", "");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Policy Currency is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Sum Insured (First) is mandatory");
    }

    /**
     * Description: Asset Marketable Securities Portfolio Listed Ordinary Shares
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetMarketableSecuritiesPortfolioListedOrdinaryShares() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Listed Ordinary Shares*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Marketable Securities Portfolio", "Listed Ordinary Shares");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Listed Ordinary Shares", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Currency is mandatory");


    }

    /**
     * Description: Asset Marketable Securities Portfolio Listed Preference Shares
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetMarketableSecuritiesPortfolioListedPreferenceShares() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Listed Preference Shares*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Marketable Securities Portfolio", "Listed Preference Shares");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Listed Preference Shares", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Currency is mandatory");


    }


    /**
     * Description: Asset Marketable Securities Other
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetMarketableSecuritiesPortfolioOther() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Other*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Marketable Securities Portfolio", "Other");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Other", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Currency is mandatory");


    }


    /**
     * Description: Asset Marketable Securities Portfolio Portfolio
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetMarketableSecuritiesPortfolioPortfolio() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Portfolio*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Marketable Securities Portfolio", "Portfolio");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Portfolio", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Currency is mandatory");


    }


    /**
     * Description: Asset Marketable Securities Portfolio Unlisted Shares
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void AssetMarketableSecuritiesPortfolioUnlistedShares() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Asset Life Policy*********************");
        HomePageANZ.TopMenu("Collateral", "Asset", "Marketable Securities Portfolio", "Unlisted Shares");
        AssetANZ.AddToFormClick();
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        AssetANZ.RemoveFromForm();
//        AssetANZ.AddToFormWithIdentifiedBy("Unlisted Shares", "Serial Number", "", "", "", "", "", "");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        AssetANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        AssetANZ.SelectBank("");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Asset Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Currency is mandatory");


    }

    /**
     * Description: Application Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void ApplicationDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        ApplicationANZ = new ApplicationANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking Application Drools*********************");
        HomePageANZ.TopMenu("Application", "Application", "Generic Application", "");
        ApplicationANZ.AddToFormClick();
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        ApplicationANZ.RemoveFromForm();
        ApplicationANZ.AddToFormWithIdentifiedBy("Application", "LEX Application ID", "", "", "", "", "", "");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        ApplicationANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        ApplicationANZ.SelectBank("");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Application Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");
        CommonForAll.AssertIfNotPresentByText("RK02005-Letter of Offer Issued must be Yes when Data Filter is ANZx","-Letter of Offer Issued must be Yes when Data Filter is ANZx");


        ApplicationANZ.SelectApplicationStatus("Active", "", "", "", "");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Source System Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Application Currency is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Total Collateral Value is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Total Facility Limits is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Application Date is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Letter of Offer Issued must be Yes when Data Filter is ANZx");

        ApplicationANZ.SelectSourceSystemStatus("Document Verification","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Letter Of Offer Date\" must be entered when \"Source System Status\" is \"Document Verification\"");

        ApplicationANZ.SelectSourceSystemStatus("Complete","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-\"Letter Of Offer Execution Date\" must be entered when \"Source System Status\" is \"Complete\"");


    }

    /**
     * Description: General Insurance Drools
     */
    @Test(groups = { "Drools","DroolsANZ","ANZ","CLIENTAUTO-56" }, description = "Drools", priority=0)
    public void GeneralInsuranceDrools() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        GeneralInsuranceANZ = new GeneralInsuranceANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        ApplicationANZ = new ApplicationANZ(driver);
        AssetANZ = new AssetANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        log.info("*********************Checking General Insurance Drools*********************");
        HomePageANZ.TopMenu("General Insurance", "General Insurance", "General Insurance", "");
        GeneralInsuranceANZ.AddToFormClick();
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Identified By* is mandatory");

        GeneralInsuranceANZ.RemoveFromForm();
        GeneralInsuranceANZ.AddToFormWithIdentifiedBy("General Insurance", "Policy  Number", "", "", "", "", "", "");
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-ID is mandatory");

        GeneralInsuranceANZ.RemoveStatus();
        CommonForAll.MouseMoveAndClick(250, 250);
        GeneralInsuranceANZ.SelectBank("");
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Status is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Data Filters is mandatory");


        GeneralInsuranceANZ.SelectGeneralInsuranceStatus("Active", "", "", "", "");
        GeneralInsuranceANZ.SelectInsuranceRenewalExempt("Yes","","","","");
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("RK02005-Policy Type is mandatory");
        CommonForAll.AssertIfPresentByText("ANZ Interest Noted?* is mandatory when Status* is Active");
        CommonForAll.AssertIfPresentByText("Insurance Exemption Reason* must be Not required in terms of Credit Policy when Insurance Renewal Exempt is Yes");
        CommonForAll.AssertIfPresentByText("Expiry Date is mandatory when Status* is Active");
        CommonForAll.AssertIfPresentByText("RK02005-Policy Currency is mandatory");
        CommonForAll.AssertIfPresentByText("RK02005-Policy Amount is mandatory when \"Complete Replacement\" is not \"Yes\"");

        GeneralInsuranceANZ.SelectExpiryDate(CommonForAll.DateFromCurrentDate(-1),"","","","");
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("Expiry Date must be a future date and it cannot be greater than 18 months from today");
        GeneralInsuranceANZ.SelectExpiryDate(CommonForAll.DateFromCurrentDate(558),"","","","");
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("for field Expiry Date is invalid.");

        GeneralInsuranceANZ.ClearExpiryDateField();
        GeneralInsuranceANZ.SelectExpiryDate(CommonForAll.DateFromCurrentDate(558),"","","","");
        GeneralInsuranceANZ.Save1();
        CommonForAll.AssertIfPresentByText("Expiry Date must be a future date and it cannot be greater than 18 months from today");
    }




    //endregion Drools

}