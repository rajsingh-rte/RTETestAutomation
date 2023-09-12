package TestCases.Sample.CreateAndLink;

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
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by Raj.
 */
public class CreateAndLinkANZTests extends BaseTest {

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

    /**
     Personal
     **/
    public static String LegalEntityPersonalID = null;
    public static String LegalEntityPersonalID2 = null;
    public static String LegalEntityPersonalName = null;
    public static String LegalEntityPersonalName2 = null;

    /**
     Service Provider
     **/
    public static String LegalEntityServiceProviderID = null;
    public static String LegalEntityServiceProviderID2 = null;
    public static String LegalEntityServiceProviderName = null;
    public static String LegalEntityServiceProviderName2 = null;

    /**
     Facility Generic Facility
     **/
    public static String GenericFacilityID = null;
    public static String GenericFacilityID2 = null;
    public static String GenericFacilityText = null;

    /**
     LED Registered Mortgage
     **/
    public static String RegisteredMortgageID = null;
    public static String RegisteredMortgageID2 = null;
    public static String RegisteredMortgageName = null;

    /**
     LED Guarantees
     **/
    public static String GuaranteesID = null;
    public static String GuaranteesID2 = null;
    public static String GuaranteesName = null;

    /**
     Asset Barge ID's
     **/
    public static String BargeID = null;
    public static String BargeID2 = null;
    public static String BargeName = null;

    /**
     Asset Agriculture ID's
     **/
    public static String AgricultureID = null;
    public static String AgricultureID2 = null;
    public static String AgricultureName = null;

    /**
     Asset Generic Asset Category Aircraft ID's
     **/
    public static String AircraftID = null;
    public static String AircraftID2 = null;
    public static String AircraftName = null;

    /**
     Asset Cash On Deposit External Cash Deposit
     **/
    public static String ExternalCashDepositID = null;
    public static String ExternalCashDepositID2 = null;
    public static String ExternalCashDepositName = null;

    /**
     Add Life Insurance Life Policy
     **/
    public static String LifePolicyID = null;
    public static String LifePolicyID2 = null;
    public static String LifePolicyName = null;

    /**
     Add Listed Ordinary Shares
     **/
    public static String ListedOrdinarySharesID = null;
    public static String ListedOrdinarySharesID2 = null;
    public static String ListedOrdinarySharesName = null;

    /**
     Add Application
     **/
    public static String ApplicationID = null;
    public static String ApplicationID2 = null;
    public static String ApplicationName = null;

    /**
     Add General Insurance
     **/
    public static String GeneralInsuranceID = null;
    public static String GeneralInsuranceID2 = null;
    public static String GeneralInsuranceName = null;


    /**
     *Description:XXXXX
     */
    @Test(groups={"Create","CreateFNB","FNB","CLIENTAUTO-54"},description="1-AddLegalEntityJuristic",priority=0)
    public void Trial() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage=new LoginPage(driver);

        CommonForAll=new CommonForAll(driver);
        //loginPage.loginANZ();

        int abc[][] = {{1,32,3},{6,8,0},{9,15,3}};
        int max = abc[0][0];

        for(int i = 0; i<3 ; i++)
        {

            for(int j = 0; j<3 ; j++)
            {
                if(abc[i][j]>max)
                {

                    max=abc[i][j];

                }

            }
        }

        System.out.println(max);
    }

    /**
     *Description:XXXXX
     */
    @Test(groups={"Create","CreateFNB","FNB","CLIENTAUTO-54"},description="1-AddLegalEntityJuristic",priority=0)
    public void XXX() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage=new LoginPage(driver);

        CommonForAll=new CommonForAll(driver);
        //loginPage.loginANZ();

        for(int i=0;i<60;i++)
        {System.out.println("TickTick");
            thread.sleep(60000);
            CommonForAll.MouseMoveAndClick(150,150);
            CommonForAll.MouseMoveAndClick(50,50);
            CommonForAll.KeysPressRobotClass(KeyEvent.VK_NUMPAD6);
            CommonForAll.KeysPressRobotClass(KeyEvent.VK_E);


            System.out.println(i+"MinDone");
        }

    }

    //region Create
    //Legal Entity Creation
    /**
     * Description: Add Legal Entity Juristic
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "1 - Add Legal Entity Juristic", priority=0)
    public void AddLegalEntityJuristic() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Creating Juristic Legal Entity");
        HomePageANZ.TopMenu("Legal Entity","Juristic","","");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityJuristicID,LegalEntityJuristicCID2,"Raj","Raj","Raj","Active","ANZ","Partnership","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
    }



    /**
     * Description: Add Legal Entity Personal
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "1 - Add Legal Entity Personal", priority=0)
    public void AddLegalEntityPersonal() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        LegalEntityPersonalID = CommonForAll.getRandomNumber11Digits();
        LegalEntityPersonalID2 = CommonForAll.getRandomNumber11Digits();
        LegalEntityPersonalName = CommonForAll.getRandomAlphabeticString();
        LegalEntityPersonalName2 = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Personal Legal Entity");
        HomePageANZ.TopMenu("Legal Entity","Personal","","");
        LegalEntityANZ.LegalEntityPersonalCreate("Juristic","OCV ID",LegalEntityPersonalID,LegalEntityPersonalID2,"Mr.",LegalEntityPersonalName,LegalEntityPersonalName2,LegalEntityPersonalName2,"Active","ANZ","Individual","Yes","Active","abc@abc.com","34534534","5646457456","Active", CommonForAll.DateFromCurrentDate(30),"","","","","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Legal Entity Service Provider
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "1 - Add Legal Entity Service Provider", priority=0)
    public void AddLegalEntityServiceProvider() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        LegalEntityServiceProviderID = CommonForAll.getRandomNumber11Digits();
        LegalEntityServiceProviderID2 = CommonForAll.getRandomNumber11Digits();
        LegalEntityServiceProviderName = CommonForAll.getRandomAlphabeticString();
        LegalEntityServiceProviderName2 = CommonForAll.getRandomAlphabeticString();

        log.info("Creating SP Legal Entity");
        HomePageANZ.TopMenu("Legal Entity","Service Provider","","");
        LegalEntityANZ.LegalEntityServiceProviderCreate("Service Provider","ABN",LegalEntityServiceProviderID,LegalEntityServiceProviderID2,LegalEntityServiceProviderName,LegalEntityServiceProviderName2,LegalEntityServiceProviderName2,"Active","ANZ","Solicitor","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
    }

    //Generic Facility
    /**
     * Description: Add Facility Generic Facility
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "1 - Add Facility Generic Facility", priority=0)
    public void AddFacilityGenericFacility() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        GenericFacilityID = CommonForAll.getRandomNumber11Digits();
        GenericFacilityID2 = CommonForAll.getRandomNumber11Digits();
        GenericFacilityText = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Generic Facility");
        HomePageANZ.TopMenu("Facility","Generic Facility","","");
        FacilityANZ.GenericFacilityCreate("Generic Facility","CAP Account Number",GenericFacilityID,GenericFacilityID,GenericFacilityText,"Approved","DDA - Overdraft","","","AUD - Australian Dollar","323213","Facility Amount",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100), "ANZ","",GenericFacilityText,"4323","9232","122",CommonForAll.DateFromCurrentDate(-20),"","","","","","","","","","","","","","","","","", "");
        FacilityANZ.Save2();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

    //Collateral LED
    /**
     * Description: Add Collateral LED Security Interest Registered Mortgage
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "1 - Add Collateral LED Security Interest Registered Mortgage", priority=0)
    public void AddCollateralLEDSecurityInterestRegisteredMortgage() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        RegisteredMortgageID = CommonForAll.getRandomNumber11Digits();
        RegisteredMortgageID2 = CommonForAll.getRandomNumber11Digits();
        RegisteredMortgageName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating LED Registered Mortgage");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        LEDANZ.LEDCreation("Registered Mortgage","Registration Number",RegisteredMortgageID,RegisteredMortgageID2,"Draft","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",RegisteredMortgageID,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Collateral LED Security Interest Registered Mortgage
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51", "CLIENTAUTO-64" }, description = "1 - Add Collateral LED Security Interest Registered Mortgage", priority=0)
    public void AddCollateralLEDGuarantee() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        loginPage.loginANZ();

        GuaranteesID = CommonForAll.getRandomNumber11Digits();
        GuaranteesID2 = CommonForAll.getRandomNumber11Digits();
        GuaranteesName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating LED Guarantees Corporate Guarantee and Indemnity");
        HomePageANZ.TopMenu("Collateral","LED","Guarantee","Corporate Guarantee and Indemnity");
        LEDANZ.LEDGuaranteesCreation("Corporate Guarantee and Indemnity","Solicitor Reference",GuaranteesID,GuaranteesID2,"Draft","","","","4324234","ANZ","AUD - Australian Dollar","34234","","","", "","","","","","","","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
    }

    //Assets

    /**
     * Description: Add Asset Vessel Barge
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = " Add Asset Vessel Barge", priority=0)
    public void AddAssetVesselBarge() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        BargeID = CommonForAll.getRandomNumber11Digits();
        BargeID2 = CommonForAll.getRandomNumber11Digits();
        BargeName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Asset Barge");
        HomePageANZ.TopMenu("Collateral","Asset","Vessel","Barge");
        AssetANZ.VesselCreation("Barge","IMO code",BargeID,BargeID2,"Active","3545435","345345","435345","34234234","43543454","Yes","Yes","ANZ","ANZ","Australia", "ANZ","Australia","45345345","5345345","9232","Australia","34234","3432423","Australia","Australia","453454","5345354","4353454","Australia","4534","fdfggf","43534","Australia","4353454","43543454","34543454","53454345","53454","454354","342","3424","16-February-2022","234234","324234","dsfsdf","232","32434","324234","234","324","234","2344","324","342","4324","3423","Nice","324","324","324","234","324","324","423","324","234","234","324","234","432","324324","","RUSA","12","45","33","","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Asset Real Estate Bedsitter / Studio Apartments
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = " Add Asset Real Estate Bedsitter / Studio Apartments", priority=0)
    public void AddAssetRealEstateBedsitterStudioApartments() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        AgricultureID = CommonForAll.getRandomNumber11Digits();
        AgricultureID2 = CommonForAll.getRandomNumber11Digits();
        AgricultureName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Asset Real Estate Agriculture");
        HomePageANZ.TopMenu("Collateral","Asset","Real Estate","Bedsitter / Studio Apartments");
        AssetANZ.RealEstateCreation("Bedsitter / Studio Apartments","GNAF ID",AgricultureID,AgricultureID2,"Active","Office","3","34534545","Freehold","Yes",CommonForAll.DateFromCurrentDate(150),"ANZ","43","Hectare","34234", "Hectare","","RUSA","23","67","22","Vacant Land","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

//    /**
//     * Description: Add Asset Generic Asset Category Aircraft
//     */
//    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = " Add AssetGeneric Asset Category Aircraft", priority=0)
//    public void AddAssetGenericAssetCategoryAircraft() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
//        driver.get(ANZUrl);
//        loginPage = new LoginPage(driver);
//        HomePageANZ = new HomePageANZ(driver);
//        LegalEntityANZ = new LegalEntityANZ(driver);
//        FacilityANZ = new FacilityANZ(driver);
//        LEDANZ = new LEDANZ(driver);
//        CommonForAll = new CommonForAll(driver);
//        AssetANZ = new AssetANZ(driver);
//        loginPage.loginANZ();
//
//        AircraftID = CommonForAll.getRandomNumber11Digits();
//        AircraftID2 = CommonForAll.getRandomNumber11Digits();
//        AircraftName = CommonForAll.getRandomAlphabeticString();
//
//        log.info("Creating Asset Generic Asset Category Aircraft");
//        HomePageANZ.TopMenu("Collateral","Asset","Generic Asset Category","Aircraft");
//        AssetANZ.GenericAssetCategoryCreation("Aircraft","Serial Number",AircraftID,AircraftID2,"Active","Engine","3","34534545",CommonForAll.DateFromCurrentDate(-30),CommonForAll.DateFromCurrentDate(30),"Yes","ANZ","Airbus","Hectare","2019", "435345","","60","23","67","22","","","","","","","","","","","","","","","","","","");
//        AssetANZ.Save1();
//        CommonForAll.AssertIfPresentByText("Details");
//        log.info("Entity is Created!");
//    }

    /**
     * Description: Add Asset Generic Asset Category Water Rights - Australia
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = " Add AssetGeneric Asset Category Aircraft", priority=0)
    public void AddAssetGenericAssetCategoryWaterRights() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        AircraftID = CommonForAll.getRandomNumber11Digits();
        AircraftID2 = CommonForAll.getRandomNumber11Digits();
        AircraftName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Asset Generic Asset Category Water Rights - Australia");
        HomePageANZ.TopMenu("Collateral","Asset","Generic Asset Category","Water Rights - Australia");
        AssetANZ.GenericAssetCategoryCreation("Water Rights","Serial Number",AircraftID,AircraftID2,"Active","Engine","3","34534545",CommonForAll.DateFromCurrentDate(-30),CommonForAll.DateFromCurrentDate(30),"Yes","ANZ","Airbus","Hectare","2019", "435345","","60","23","67","22","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Cash on Deposit Cash - Deposit with ANZ
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = " Add AssetGeneric Asset Category Aircraft", priority=0)
    public void AddAssetCashOnDepositExternalCashDeposit() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        ExternalCashDepositID = CommonForAll.getRandomNumber11Digits();
        ExternalCashDepositID2 = CommonForAll.getRandomNumber11Digits();
        ExternalCashDepositName = CommonForAll.getRandomAlphabeticString();

        log.info("Creating Cash on Deposit Cash - Deposit with ANZ");
        HomePageANZ.TopMenu("Collateral","Asset","Cash on Deposit","Cash - Deposit with ANZ");
        AssetANZ.CashOnDepositCreation("Cash - Deposit with ANZ","",ExternalCashDepositID,ExternalCashDepositID2,"Active","","dfsfsdf","5345345345","534534543454","Yes","AUD - Australian Dollar","ANZ","324234","Hectare",CommonForAll.DateFromCurrentDate(30), "35","20","10","","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Life Insurance Life Policy
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "Add Life Insurance Life Policy", priority=0)
    public void AddAssetLifeInsuranceLifePolicy() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        LifePolicyID = CommonForAll.getRandomNumber11Digits();
        LifePolicyID2 = CommonForAll.getRandomNumber11Digits();
        LifePolicyName = CommonForAll.getRandomAlphabeticString();

        log.info("Add Life Insurance Life Policy");
        HomePageANZ.TopMenu("Collateral","Asset","Life Insurance","Life Insurance Policy");
        AssetANZ.LifeInsuranceCreation("Life Policy","Policy  Number",LifePolicyID,LifePolicyID2,"Active",LifePolicyID2,"Farm Insurance","Personal","Original",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(5),"ANZ",CommonForAll.DateFromCurrentDate(60),"AUD - Australian Dollar","40", "35","20","Monthly","45","90",LifePolicyName,"30","15","8","","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Marketable Securities Portfolio Listed Ordinary Shares
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "Add Marketable Securities Portfolio Listed Ordinary Shares", priority=0)
    public void AddAssetMarketableSecuritiesPortfolioListedOrdinaryShares() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        ListedOrdinarySharesID = CommonForAll.getRandomNumber11Digits();
        ListedOrdinarySharesID2 = CommonForAll.getRandomNumber11Digits();
        ListedOrdinarySharesName = CommonForAll.getRandomAlphabeticString();

        log.info("Add Marketable Securities Portfolio Listed Ordinary Shares");
        HomePageANZ.TopMenu("Collateral","Asset","Marketable Securities Portfolio","Listed Ordinary Shares");
        AssetANZ.MarketableSecuritiesPortfolio("Listed Ordinary Shares","",LifePolicyID,LifePolicyID2,"Active",CommonForAll.DateFromCurrentDate(-15),"AUD - Australian Dollar","ANZ","30","15","CommonForAll.DateFromCurrentDate(5)","","","","", "","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add Application
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "Add APplication", priority=0)
    public void AddApplication() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        ApplicationANZ = new ApplicationANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LEDANZ = new LEDANZ(driver);
        CommonForAll = new CommonForAll(driver);
        AssetANZ = new AssetANZ(driver);
        loginPage.loginANZ();

        ApplicationID = CommonForAll.getRandomNumber11Digits();
        ApplicationID2 = CommonForAll.getRandomNumber11Digits();
        ApplicationName = CommonForAll.getRandomAlphabeticString();

        log.info("Add Application");
        HomePageANZ.TopMenu("Application","Application","Generic Application","");
        ApplicationANZ.ApplicationCreation("Generic Application","LEX Application ID",ApplicationID,ApplicationID2,"Active","New To Bank Lending","Document Verification","AUD - Australian Dollar","ANZ","15","455",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(15),CommonForAll.DateFromCurrentDate(30),"345", "4534","Yes","","","","","","","","","","","","","","","","","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

    /**
     * Description: Add General Insurance
     */
    @Test(groups = { "Create","CreateANZ","ANZ","CLIENTAUTO-51" }, description = "Add General Insurance ", priority=0)
    public void AddGeneralInsurance () throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        GeneralInsuranceID = CommonForAll.getRandomNumber11Digits();
        GeneralInsuranceID2 = CommonForAll.getRandomNumber11Digits();
        GeneralInsuranceName = CommonForAll.getRandomAlphabeticString();

        log.info("Add General Insurance");
        HomePageANZ.TopMenu("General Insurance","General Insurance","General Insurance","");
        GeneralInsuranceANZ.GeneralInsuranceCreate("General Insurance","Policy  Number",GeneralInsuranceID,GeneralInsuranceID,"Active",GeneralInsuranceID,"Industrial Special Risk","Not required in terms of Credit Policy","Yes","ANZ","Yes",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(30),"500","AUD - Australian Dollar", "4534","Yes","546546","sf@d.com","Yes","Yes","","","","","","","","","","","","","","","","","","","","","","");
        ApplicationANZ.Save1();
        CommonForAll.AssertIfPresentByText("Open Audit History");
        log.info("Entity is Created!");
    }

    //endregion Creation

    //region Linking Test Cases

    /**
     * Description: Link Legal Entity Juristic To Application
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to Application", priority = 1)
    public void LinkLegalEntityToApplication() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", "CLT", "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link Application");
        LegalEntityANZ.LegalEntityLinkToApplication("Link", "CLT", "Borrower", "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach Application");
    }

    /**
     * Description: Link Legal Entity Juristic To Asset
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to Asset", priority = 1)
    public void LinkLegalEntityToAsset() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", "CLT", "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link Asset");
        LegalEntityANZ.LegalEntityLinkToAsset("Link", "CLT", "Borrower", "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach Asset");
    }

    /**
     * Description: Link Legal Entity  To Facility
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to Facility", priority = 1)
    public void LinkLegalEntityToFacility() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", "CLT", "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link Facility");
        LegalEntityANZ.LegalEntityLinkToFacility("Link", "CLT", "No", "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach Facility");
    }

    /**
     * Description: Link Legal Entity To LED
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to LED", priority = 1)
    public void LinkLegalEntityToLED() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", "CLT", "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link LED");
        LegalEntityANZ.LegalEntityLinkToLED("Link", "CLT", "Borrower", "Active", "", "", "", "", "","","","","");
        CommonForAll.AssertIfPresentByText("Attach LED");
    }

    /**
     * Description: Link Legal Entity To General Insurance
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to General Insurance", priority = 1)
    public void LinkLegalEntityToGeneralInsurance() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Legal Entity" + LegalEntityJuristicID);
        HomePageANZ.SearchMenu("Legal Entity", "CLT", "COLLATE", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link General Insurance");
        LegalEntityANZ.LegalEntityLinkToGeneralInsurance("Link", GeneralInsuranceID, "Insurer", "Active", "", "", "", "", "","","","","");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");
    }

    /**
     * Description: Link Facility To LED
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to LED", priority = 1)
    public void LinkFacilityToLED() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", "CLT", "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure("CLT");
        log.info("Search and Link LED");
        FacilityANZ.FacilityLinkToLED("Link", "CLT", "Active", "Yes", "1", "3", "", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach LED");
    }

    /**
     * Description: Link Facility To LED
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to LED", priority = 1)
    public void LinkFacilityToCollateral() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", "CLT", "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure("CLT");
        log.info("Search and Link Collateral");
        FacilityANZ.FacilityLinkToCollateral("Link", "CLT", "Active", "Yes", "1", "3", "", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach LED");
    }

    /**
     * Description: Link Facility To Applications
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Legal entity Juristic to Application", priority = 1)
    public void LinkFacilityToApplication() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Facility" + GenericFacilityID);
        HomePageANZ.SearchMenu("Facility", "CLT", "", "","","");
        CommonForAll.SearchedSelectBySearchTermForLoanAndExposure("CLT");
        log.info("Search and Link Application");
        FacilityANZ.FacilityLinkToApplication("Link", "CLT", "Active", "Yes", "1", "3", "", "");
        CommonForAll.AssertIfPresentByText("Attach Application");
    }

    /**
     * Description: Link Asset to LED
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Asset to LED", priority = 1)
    public void LinkLEDToAsset() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search LED" + RegisteredMortgageID);
        HomePageANZ.SearchMenu("LED", "Registered Mortgage", "", "","","");
        CommonForAll.SearchedSelectBySearchTerm("Registered");
        log.info("Search and Link Asset");
        LEDANZ.LEDLinkToAsset("Link", "CLT", "Active", "Yes", "1", "3", "", "","","");
        CommonForAll.AssertIfPresentByText("Attach Asset");
    }

    /**
     * Description: Link Application to LED
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Application to LED", priority = 1)
    public void LinkLEDToApplication() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search LED" + RegisteredMortgageID);
        HomePageANZ.SearchMenu("LED", "CLT", "", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link Application");
        LEDANZ.LinkLEDToApplication("Link", "CLT", "Active", "Yes", "1", "3", "", "");
        CommonForAll.AssertIfPresentByText("Attach Application");
    }

    /**
     * Description: Link Application to Asset
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link Application to LED", priority = 1)
    public void LinkAssetToApplication() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Asset" + RegisteredMortgageID);
        HomePageANZ.SearchMenu("Asset", "CLT", "", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link Application");
        AssetANZ.AssetLinkToApplication("Link", "CLT", "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach Application");
    }

    /**
     * Description: Search Asset and Link General Insurance
     */
    @Test(groups = {"Link", "LinkANZ", "ANZ", "CLIENTAUTO-51"}, description = "Link General Insurance to Asset", priority = 1)
    public void LinkAssetToGeneralInsurance() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
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

        log.info("Search Asset" + AgricultureID);
        HomePageANZ.SearchMenu("Asset", "CLT", "", "","","");
        CommonForAll.SearchedSelectBySearchTerm("CLT");
        log.info("Search and Link GI");
        AssetANZ.AssetLinkToGeneralInsurance("Link", GeneralInsuranceID, "Active", "", "", "", "", "");
        CommonForAll.AssertIfPresentByText("Attach General Insurance");
    }

    //endregion Linking Test Cases

}