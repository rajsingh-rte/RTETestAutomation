package TestCases.Sample.Onboarding;

import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.Sample.Application.ApplicationANZ;
import Engine.ObjectRepository.Sample.Collateral.AssetANZ;
import Engine.ObjectRepository.Sample.Collateral.LEDANZ;
import Engine.ObjectRepository.Sample.Facility.FacilityANZ;
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
public class OnboardingANZTests extends BaseTest {


    private LoginPage loginPage;
    Thread thread = null;
    private static final String ANZUrl = LocalConfig.INSTANCE.ANZUrl();
    private Engine.CommonForAll.CommonForAll CommonForAll;
    private Engine.ObjectRepository.Sample.HomePageANZ HomePageANZ;

    private static final Logger log = Logger.getLogger(BaseTest.class);
    private LEDANZ LEDANZ;
    private OnboardingANZ OnboardingANZ;
    private LegalEntityANZ LegalEntityANZ;
    private ApplicationANZ ApplicationANZ;
    private FacilityANZ FacilityANZ;
    private AssetANZ AssetANZ;


    //public static String LegalEntitySPID = null;


    /**
     * Description: Onboarding End To End Scenario, Search hand Link, Create and link
     */
    @Test(groups = { "Onboarding","OnboardingANZ","ANZ","CLIENTAUTO-58" }, description = "Onboarding End To End Scenario", priority=1)
    public void OnboardingSimpleScenario() throws InterruptedException, AWTException, IOException, UnsupportedFlavorException {
        driver.get(ANZUrl);
        loginPage = new LoginPage(driver);
        HomePageANZ = new HomePageANZ(driver);
        OnboardingANZ = new OnboardingANZ(driver);
        ApplicationANZ = new ApplicationANZ(driver);
        LEDANZ = new LEDANZ(driver);
        FacilityANZ = new FacilityANZ(driver);
        LegalEntityANZ = new LegalEntityANZ(driver);
        AssetANZ = new AssetANZ(driver);
        CommonForAll = new CommonForAll(driver);

        String LegalEntityNonPersonalID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityNonPersonalCIS = CommonForAll.getRandomNumber11Digits();
        String LegalEntityNonPersonalName = CommonForAll.getRandomAlphabeticString();
        String LegalEntityNonPersonalDBA = CommonForAll.getRandomAlphabeticString();
        String DealID = CommonForAll.getRandomNumber11Digits();
        String DealID2 = CommonForAll.getRandomNumber11Digits();
        String DealID3 = CommonForAll.getRandomAlphabeticString();
        String LoanAndExposureID = CommonForAll.getRandomNumber11Digits();
        String LoanAndExposureID2 = CommonForAll.getRandomNumber11Digits();
        String LoanAndExposureName = CommonForAll.getRandomAlphabeticString();
        String ExposureID = CommonForAll.getRandomNumber11Digits();
        String ExposureID2 = CommonForAll.getRandomNumber11Digits();
        String ExposureName = CommonForAll.getRandomAlphabeticString();
        String LienID = CommonForAll.getRandomNumber11Digits();
        String LienID2 = CommonForAll.getRandomNumber11Digits();
        String LienName = CommonForAll.getRandomAlphabeticString();
        String AssetID = CommonForAll.getRandomNumber11Digits();
        String AssetID2 = CommonForAll.getRandomNumber11Digits();
        String BargeID = CommonForAll.getRandomAlphabeticString();
        String BargeID2 = CommonForAll.getRandomAlphabeticString();
        String GuaranteesID = CommonForAll.getRandomNumber11Digits();
        String GuaranteesID2 = CommonForAll.getRandomNumber11Digits();
        String LegalEntityJuristicID = CommonForAll.getRandomNumber11Digits();
        String LegalEntityJuristicCID2 = CommonForAll.getRandomNumber11Digits();
        String LegalEntityJuristicName = CommonForAll.getRandomAlphabeticString();
        String LegalEntityJuristicName2 = CommonForAll.getRandomAlphabeticString();
        String RegisteredMortgageID = CommonForAll.getRandomNumber11Digits();
        String RegisteredMortgageID2 = CommonForAll.getRandomNumber11Digits();
        String RegisteredMortgageName = CommonForAll.getRandomAlphabeticString();

        loginPage.loginANZ();

        log.info("Creating LED Registered Mortgage");
        HomePageANZ.TopMenu("Collateral","LED","Security Interest - Generic","Registered Mortgage");
        LEDANZ.LEDCreation("Registered Mortgage","Registration Number",RegisteredMortgageID,RegisteredMortgageID2,"Draft","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",RegisteredMortgageID,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");

        log.info("Creating Juristic Legal Entity");
        HomePageANZ.TopMenu("Legal Entity","Juristic","","");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","OCV ID",LegalEntityJuristicID,LegalEntityJuristicCID2,LegalEntityJuristicName,LegalEntityJuristicName2,LegalEntityJuristicName2,"Active","ANZ","Sole Trader","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save1();
        CommonForAll.AssertIfPresentByText("Details");
        //CommonForAll.HomePage();

        log.info("Going to Onboarding Page");
        OnboardingANZ.OnboardingTab();
        OnboardingANZ.SelectSourceType("COLLATE");
        OnboardingANZ.OnboardingSearchAndLinkCustomer(LegalEntityJuristicID,"Provider","","","","","");
        CommonForAll.JavaScriptScrollToTop();
        OnboardingANZ.OnboardingCustomerRoleAndTypeSelect("Borrower","Juristic","","","","","");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityNonPersonalID,LegalEntityNonPersonalCIS,LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,"Active","ANZ","Sole Trader","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save2();
        ApplicationANZ.ApplicationCreationOnboarding("Generic Application","LEX Application ID",DealID,DealID2,"Active","New To ","Document Verification","AUD - Australian Dollar","ANZx","15","455",CommonForAll.DateFromCurrentDate(-15),CommonForAll.DateFromCurrentDate(15),CommonForAll.DateFromCurrentDate(30),"345", "4534","Yes","","","","","","","","","","","","","","","","","","","","");
        OnboardingANZ.NextButton2();

        log.info("Moving to Facility & Exposure Page and Creating Facility & Exposure");
        OnboardingANZ.CreateFacilityAndExposureButtonInOnboarding();
        FacilityANZ.GenericFacilityCreateOnboarding("Generic Facility","Account Number",LoanAndExposureID,LoanAndExposureID2,LoanAndExposureName,"Approved","DDA - Overdraft","","","AUD - Australian Dollar","323213","Facility Amount",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100), "ANZ","","dfsdfsdfsdf","4323","9232","122",CommonForAll.DateFromCurrentDate(-20),"","","","","","","","","","","","","","","","","", "");
        //OnboardingANZ.AddExposureToFacilityInOnboarding();
        //FacilityAndExposureFNB.ExposureCreation("Add Exposure", "FACT – Credit Application Number", ExposureID, ExposureID2, "Active", "USD - US Dollar", "23234234","34646456","56546","4234","32423", "324234","FNB","Commitment-Legacy","4354","No","","","","","","","","","","","");
        //FacilityAndExposureFNB.Save1();
        //OnboardingANZ.YesOrNoButtonOnboarding("Yes");
        OnboardingANZ.LinkLEtoFacilityAndExposure("1");
        OnboardingANZ.LinkLEtoFacilityAndExposure("2");
        OnboardingANZ.AddButtonClick();
        OnboardingANZ.OnboardingSearchAndLinkCustomerToLoanAndExposure("CLT","","","","","");
        CommonForAll.JavaScriptScrollToTop();
        OnboardingANZ.CreateButton();
        OnboardingANZ.SelectCustomerType("Juristic");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityNonPersonalID,LegalEntityNonPersonalCIS,LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,"Active","ANZ","Sole Trader","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        //LegalEntityFNB.Save2();
        OnboardingANZ.Save1();
        OnboardingANZ.OnboardingSearchAndLinkFacilityAndExposure("CLT","last()","","","","");
        CommonForAll.JavaScriptScrollByPixels(400);
        thread.sleep(2000);
        OnboardingANZ.LinkLEtoFacilityAndExposure("last()");
        //OnboardingCNB.LinkLEtoLoanAndExposure("5");
        CommonForAll.JavaScriptScrollByPixels(150);
        OnboardingANZ.AddButtonClick();
        OnboardingANZ.Save1();
        //OnboardingANZ.Okay();


        OnboardingANZ.NextButton1();
        log.info("Moving to Collateral Page and adding collateral and assets");
        OnboardingANZ.CreateButton();
        OnboardingANZ.SelectLEDTypeOnboarding("Registered Mortgage","","","","","");
        LEDANZ.LEDCreationOnboarding("Registered Mortgage","Registration Number",LienID,LienID2,"Draft","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",LienID,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        OnboardingANZ.AddAssetButton();
        OnboardingANZ.SelectAssetTypeOnboarding("Real Estate","Standard Residential Property","","","","","");
        AssetANZ.RealEstateCreationOnboarding("Standard Residential Property","GNAF ID",AssetID,AssetID2,"Draft","1","Yes","Office","3","34534545","Freehold","Yes",CommonForAll.DateFromCurrentDate(150),"ANZ","43","Hectare","34234", "Hectare","","RUSA","23","67","22","Vacant Land","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        OnboardingANZ.NextButton2();
        OnboardingANZ.LinkLEtoLED("1");
        OnboardingANZ.LinkLEtoLED("2");
        OnboardingANZ.AddButtonClick();
        OnboardingANZ.OnboardingSearchAndLinkCustomerToLEDs("CLT","","","","","");
        CommonForAll.JavaScriptScrollToTop();
        OnboardingANZ.CreateButton();
        OnboardingANZ.SelectCustomerType("Juristic");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityNonPersonalID + "35534",LegalEntityNonPersonalCIS + "5345354",LegalEntityNonPersonalDBA + "sdfsdf",LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,"Active","ANZ","Sole Trader","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        //LegalEntityCNB.Save2();
        //OnboardingCNB.Save1();

        log.info("Searching and Adding Asset To Collateral");
        OnboardingANZ.CreateButton();
        OnboardingANZ.SelectLEDTypeOnboarding("Registered Mortgage","","","","","");
        LEDANZ.LEDCreationOnboarding("Registered Mortgage","Registration Number",LienID+"334545",LienID2+"3423451","Draft","","AUD - Australian Dollar","324243",CommonForAll.DateFromCurrentDate(0),CommonForAll.DateFromCurrentDate(100),"Yes",LienID,"ANZ","ANZx","34234234", "ANZ","24234","GenericFacilityText","4323","9232","","","","","","","","","","","","","","","","","","");
        OnboardingANZ.AddAssetButton();
        OnboardingANZ.SearchAssetOnOnboarding("CLT","1","","","","","");
        OnboardingANZ.RankAndParipasuWithSave("5", "Yes", "","","","","");
        OnboardingANZ.LinkLEtoLED("1");
        CommonForAll.JavaScriptScrollByPixels(150);
        OnboardingANZ.AddButtonClick();
        OnboardingANZ.Save1();

        log.info("Searching and Adding LED....");
        OnboardingANZ.OnboardingSearchAndLinkLED(RegisteredMortgageID,"1","","","","");

        log.info("Moving to Guarantees Page....");
        CommonForAll.JavaScriptScrollToTop();
        OnboardingANZ.NextButton1();
        log.info("Creating and adding a guarantee");
        OnboardingANZ.CreateButton();
        OnboardingANZ.SelectGuaranteeTypeOnboarding("Corporate Guarantee and Indemnity","","","","","");
        LEDANZ.LEDGuaranteesCreationOnboarding("Corporate Guarantee and Indemnity","CAP LED Identifier",GuaranteesID,GuaranteesID2,"Draft","","","","546546","ANZx","AUD - Australian Dollar","3423423","","","", "","","","","","","","","","","","","","","","","","","","","","","","","");
        LEDANZ.Save1();
        OnboardingANZ.AddAssetButton();
        OnboardingANZ.SelectAssetTypeOnboarding("Vessel","Barge","","","","","");
        AssetANZ.VesselCreationOnboarding("Barge","IMO code",BargeID,BargeID2,"Active","1","3545435","345345","435345","34234234","43543454","Yes","Yes","ANZ","ANZx","Australia", "ANZ","Australia","45345345","5345345","9232","Australia","34234","3432423","Australia","Australia","453454","5345354","4353454","Australia","4534","fdfggf","43534","Australia","4353454","43543454","34543454","53454345","53454","454354","342","3424","16-February-2022","234234","324234","dsfsdf","232","32434","324234","234","324","234","2344","324","342","4324","3423","Nice","324","324","324","234","324","324","423","324","234","234","324","234","432","324324","","RUSA","12","45","33","","","","","","","","","","","","","","","","","","","");
        AssetANZ.Save1();
        log.info("Adding existing Legal entities to Guarantee");
        OnboardingANZ.LinkLEtoLED("1");
        OnboardingANZ.LinkLEtoLED("2");
        OnboardingANZ.SelectARoleBetweenGuaranteesAndLegalEntity("Guarantor","","","","","");
        OnboardingANZ.AddButtonClick();
        log.info("Searching and Adding Legal entities to Guarantee");
        OnboardingANZ.OnboardingSearchAndLinkCustomerGuarantorsToGuarantee("CLT","Guarantor","","","","","");
        log.info("Creating and Linking a New Legal Entity to Guarantee");
        OnboardingANZ.OnboardingCustomerRoleAndTypeSelect("Borrower","Juristic","","","","","");
        LegalEntityANZ.LegalEntityJuristicCreate("Juristic","",LegalEntityNonPersonalID+"5353",LegalEntityNonPersonalCIS+"6546",LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,LegalEntityNonPersonalDBA,"Active","ANZ","Sole Trader","Active","","abc@abc.com","Email","5646457456","001 - Albany","","","","","","","","","","","","","","","");
        LegalEntityANZ.Save2();
        OnboardingANZ.Save1();
        log.info("Searching and Adding Guarantee....");
        OnboardingANZ.OnboardingSearchAndLinkLED("CLT","1","","","","");
        OnboardingANZ.FinishButton();

    }


    //endregion Linking Test Cases

}