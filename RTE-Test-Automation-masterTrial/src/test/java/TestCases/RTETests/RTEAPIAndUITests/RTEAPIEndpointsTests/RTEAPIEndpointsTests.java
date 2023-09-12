package TestCases.RTETests.RTEAPIAndUITests.RTEAPIEndpointsTests;
import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.RTEIE.API.APIEndpoints;
import Engine.ObjectRepository.RTEIE.RTEPages.RTEArchivesArticlePage;
import Engine.ObjectRepository.RTEIE.RTEPages.RTEHomePage;
import Engine.ObjectRepository.RTEIE.RTEPages.RTENewsArticlePage;
import Engine.ObjectRepository.RTEIE.RTEPages.RTERadioArticlePage;
import Engine.ObjectRepository.TrialAPI.RTEPage;
import Engine.ObjectRepository.TrialAPI.TrialAPI;
import Engine.common.BaseTest;
import Engine.common.LoginPage;
import Engine.config.APIURLs;
import Engine.config.LocalConfig;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

/**
 * Created by Raj.
 */
public class RTEAPIEndpointsTests extends BaseTest {

    private LoginPage loginPage;
    Thread thread = null;
    public TrialAPI TrialAPI;
    public APIEndpoints APIEndpoints;
    public RTEHomePage RTEHomePage;
    public RTEArchivesArticlePage RTEArchivesArticlePage;
    public RTERadioArticlePage RTERadioArticlePage;
    public CommonForAll CommonForAll;
    public RTENewsArticlePage RTENewsArticlePage;
    private RTEPage RTEPage;
    private static final String[] APIUrlHeadlines = LocalConfig.INSTANCE.APIUrlHeadlines();
    private static final String APIEndPointURL = LocalConfig.INSTANCE.APIEndPointURL();
    private static final String RTEURL = LocalConfig.INSTANCE.RTEURL();
    private static final String RTEURLProd = LocalConfig.INSTANCE.RTEURLProd();
    private static final String RTESampleUrl = LocalConfig.INSTANCE.RTESampleUrl();
    private static final String EPICURL = LocalConfig.INSTANCE.EPICURL();
    private static final Logger log = Logger.getLogger(BaseTest.class);

    //region API Endpoints

    /**
     * Description: RTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsAuthor_BinderId_Binders() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************1) Verifying for Author_BinderId_Binders : " + APIURLs.INSTANCE.Author_BinderId_Binders() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Author_BinderId_Binders(),"200");
        String PartialHrefFromAPI = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Author_BinderId_Binders(), "","[0]","[0]");
        String HeadlineFromAPI = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Author_BinderId_Binders(), "", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI);
        String HeadlineFromUI = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI,HeadlineFromAPI);
        CommonForAll.SimpleAssert(PartialHrefFromUI, PartialHrefFromAPI);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsAuthor_BinderIds() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************2) Verifying for Author_BinderIds : " + APIURLs.INSTANCE.Author_BinderIds() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Author_BinderIds(),"200");
        String PartialHrefFromAPI2 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Author_BinderIds(),"","[0]","[0]");
        String HeadlineFromAPI2 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Author_BinderIds(),"", "[0]");
        String PartialHrefFromAPI2_1 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Author_BinderIds(),"","[1]","[1]");
        String HeadlineFromAPI2_1 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Author_BinderIds(),"", "[1]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI2);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI2);
        String HeadlineFromUI2 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI2 = RTENewsArticlePage.CaptureEndPartialHref();
        RTEHomePage.SearchArticlePage(PartialHrefFromAPI2_1);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI2_1);
        String HeadlineFromUI2_1 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI2_1 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI2,HeadlineFromAPI2);
        CommonForAll.SimpleAssert(HeadlineFromUI2_1,HeadlineFromAPI2_1);
        CommonForAll.SimpleAssert(PartialHrefFromUI2, PartialHrefFromAPI2);
        CommonForAll.SimpleAssert(PartialHrefFromUI2_1, PartialHrefFromAPI2_1);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsSource_BinderId_Binders() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************3) Verifying for Source_BinderId_Binders() : " + APIURLs.INSTANCE.Source_BinderId_Binders() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Source_BinderId_Binders(),"200");
        String PartialHrefFromAPI3 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Source_BinderId_Binders(), "","[0]","[0]");
        String HeadlineFromAPI3 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Source_BinderId_Binders(), "", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI3);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI3);
        String HeadlineFromUI3 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI3 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI3,HeadlineFromAPI3);
        CommonForAll.SimpleAssert(PartialHrefFromUI3, PartialHrefFromAPI3);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsSource_BinderIds() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************4) Verifying for  : " + APIURLs.INSTANCE.Source_BinderIds() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Source_BinderIds(),"200");
        String PartialHrefFromAPI4 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Source_BinderIds(),"","[0]","[0]");
        String HeadlineFromAPI4 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Source_BinderIds(),"", "[0]");
        String PartialHrefFromAPI4_1 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Source_BinderIds(),"","[1]","[1]");
        String HeadlineFromAPI4_1 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Source_BinderIds(),"", "[1]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI4);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI4);
        String HeadlineFromUI4 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI4 = RTENewsArticlePage.CaptureEndPartialHref();
        RTEHomePage.SearchArticlePage(PartialHrefFromAPI4_1);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI4_1);
        String HeadlineFromUI4_1 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI4_1 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI4,HeadlineFromAPI4);
        CommonForAll.SimpleAssert(HeadlineFromUI4_1,HeadlineFromAPI4_1);
        CommonForAll.SimpleAssert(PartialHrefFromUI4, PartialHrefFromAPI4);
        CommonForAll.SimpleAssert(PartialHrefFromUI4_1, PartialHrefFromAPI4_1);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsWire_BinderId_Binders() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************5) Verifying for Wire_BinderId_Binders : " + APIURLs.INSTANCE.Wire_BinderId_Binders() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Wire_BinderId_Binders(),"200");
        String PartialHrefFromAPI5 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Wire_BinderId_Binders(), "","[0]","[0]");
        String HeadlineFromAPI5 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Wire_BinderId_Binders(), "", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI5);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI5);
        String HeadlineFromUI5 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI5 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI5,HeadlineFromAPI5);
        CommonForAll.SimpleAssert(PartialHrefFromUI5, PartialHrefFromAPI5);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsWire_BinderIds() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************6) Verifying for  : " + APIURLs.INSTANCE.Wire_BinderIds() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Wire_BinderIds(),"200");
        String PartialHrefFromAPI6 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Wire_BinderIds(),"","[0]","[0]");
        String HeadlineFromAPI6 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Wire_BinderIds(),"", "[0]");
        String PartialHrefFromAPI6_1 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Wire_BinderIds(),"","[1]","[1]");
        String HeadlineFromAPI6_1 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Wire_BinderIds(),"", "[1]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI6);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI6);
        String HeadlineFromUI6 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI6 = RTENewsArticlePage.CaptureEndPartialHref();
        RTEHomePage.SearchArticlePage(PartialHrefFromAPI6_1);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI6_1);
        String HeadlineFromUI6_1 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI6_1 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI6,HeadlineFromAPI6);
        CommonForAll.SimpleAssert(HeadlineFromUI6_1,HeadlineFromAPI6_1);
        CommonForAll.SimpleAssert(PartialHrefFromUI6, PartialHrefFromAPI6);
        CommonForAll.SimpleAssert(PartialHrefFromUI6_1, PartialHrefFromAPI6_1);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsBinder_Filename_Filename_Date() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************7) Verifying for  : " + APIURLs.INSTANCE.Binder_Filename_Filename_Date() + "******************************");
        //NotUsed
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Binder_Filename_Filename_Date(),"200");
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsBinder_Filename_Filename() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************8) Verifying for  : " + APIURLs.INSTANCE.Binder_Filename_Filename() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Binder_Filename_Filename(),"200");
        String PartialHrefFromAPI8 = APIEndpoints.GetEndPartialHrefFromAPI(APIURLs.INSTANCE.Binder_Filename_Filename(), "","");
        String HeadlineFromAPI8 = APIEndpoints.GetHeadlineFromAPI(APIURLs.INSTANCE.Binder_Filename_Filename(), "");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI8);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI8);
        String HeadlineFromUI8 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI8 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI8,HeadlineFromAPI8);
        CommonForAll.SimpleAssert(PartialHrefFromUI8, PartialHrefFromAPI8);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsBinder_BinderIds() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************9) Verifying for  : " + APIURLs.INSTANCE.Binder_BinderIds() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Binder_BinderIds(),"200");
        String PartialHrefFromAPI9 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Binder_BinderIds(),"","[0]","[0]");
        String HeadlineFromAPI9 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Binder_BinderIds(),"", "[0]");
        String PartialHrefFromAPI9_1 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Binder_BinderIds(),"","[1]","[1]");
        String HeadlineFromAPI9_1 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Binder_BinderIds(),"", "[1]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI9);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI9);
        String HeadlineFromUI9 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI9 = RTENewsArticlePage.CaptureEndPartialHref();
        RTEHomePage.SearchArticlePage(PartialHrefFromAPI9_1);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI9_1);
        String HeadlineFromUI9_1 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI9_1 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI9,HeadlineFromAPI9);
        CommonForAll.SimpleAssert(HeadlineFromUI9_1,HeadlineFromAPI9_1);
        CommonForAll.SimpleAssert(PartialHrefFromUI9, PartialHrefFromAPI9);
        CommonForAll.SimpleAssert(PartialHrefFromUI9_1, PartialHrefFromAPI9_1);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsBinder_Related_Document_RDId() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************10) Verifying for  : " + APIURLs.INSTANCE.Binder_Related_Document_RDId() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Binder_Related_Document_RDId(),"200");
        String PartialHrefFromAPI10 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Binder_Related_Document_RDId(),"","[0]","[0]");
        String HeadlineFromAPI10 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Binder_Related_Document_RDId(),"", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI10);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI10);
        String HeadlineFromUI10 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI10 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI10,HeadlineFromAPI10);
        CommonForAll.SimpleAssert(PartialHrefFromUI10, PartialHrefFromAPI10);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsBinder_Pia_PiaId() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************11) Verifying for  : " + APIURLs.INSTANCE.Binder_Pia_PiaId() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Binder_Pia_PiaId(),"200");
        String PartialHrefFromAPI11 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Binder_Pia_PiaId(),"","[0]","[0]");
        String HeadlineFromAPI11 = APIEndpoints.GetKeyValueFromAPIWithBinders(APIURLs.INSTANCE.Binder_Pia_PiaId(),"[0]", "title");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI11);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI11);
        String HeadlineFromUI11 = RTERadioArticlePage.CaptureTitleFromRadioArticlePage();
        String PartialHrefFromUI11 = RTERadioArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI11,HeadlineFromAPI11);
        CommonForAll.SimpleAssert(PartialHrefFromUI11, PartialHrefFromAPI11);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsRelated_Asset_RaId() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************12) Verifying for  : " + APIURLs.INSTANCE.Related_Asset_RaId() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Related_Asset_RaId(),"200");
        String PartialHrefFromAPI12 = APIEndpoints.GetEndPartialHrefFromAPI(APIURLs.INSTANCE.Related_Asset_RaId(),"","");
        String HeadlineFromAPI12 = APIEndpoints.GetHeadlineFromAPI(APIURLs.INSTANCE.Related_Asset_RaId(),"");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI12);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI12);
        String HeadlineFromUI12 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI12 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI12,HeadlineFromAPI12);
        CommonForAll.SimpleAssert(PartialHrefFromUI12, PartialHrefFromAPI12);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_IndexIds_Binders() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************13) Verifying for  : " + APIURLs.INSTANCE.Index_IndexIds_Binders() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_IndexIds_Binders(),"200");
        String PartialHrefFromAPI13 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Index_IndexIds_Binders(),"[0]","","");
        String HeadlineFromAPI13 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Index_IndexIds_Binders(),"[0]","");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI13);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI13);
        String HeadlineFromUI13 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI13 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI13,HeadlineFromAPI13);
        CommonForAll.SimpleAssert(PartialHrefFromUI13, PartialHrefFromAPI13);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_IndexIds_Binders2() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************13.1) Verifying for  : " + APIURLs.INSTANCE.Index_IndexIds_Binders2() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_IndexIds_Binders2(),"200");
        String PartialHrefFromAPI13_1 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Index_IndexIds_Binders(),"[0]","","");
        String HeadlineFromAPI13_1 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Index_IndexIds_Binders(),"[0]","");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI13_1);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI13_1);
        String HeadlineFromUI13_1 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI13_1 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI13_1,HeadlineFromAPI13_1);
        CommonForAll.SimpleAssert(PartialHrefFromUI13_1, PartialHrefFromAPI13_1);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_IndexId_Extras() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************14) Verifying for  : " + APIURLs.INSTANCE.Index_IndexId_Extras() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_IndexId_Extras(),"200");
        String UrlFromAPI = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_IndexId_Extras(),"navigation","url[0]");
        String[] PartialURLFromAPI = UrlFromAPI.split("/");
        String TitleFromAPI = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_IndexId_Extras(),"navigation","title[0]");
        log.info("URL & Title Captured From API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(TitleFromAPI);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI14 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromUI14,PartialURLFromAPI[PartialURLFromAPI.length - 1]);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_IndexId() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************15) Verifying for  : " + APIURLs.INSTANCE.Index_IndexId() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_IndexId(),"200");
        String PartialHrefFromAPI15 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_IndexId(), "url","");
        String PartialHrefFromAPI15RemovingSlashes = PartialHrefFromAPI15.substring(1,PartialHrefFromAPI15.length()-1);
        log.info("End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI15);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI15 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromAPI15RemovingSlashes, PartialHrefFromUI15);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Name_IndexName_Pillar_Pillar() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************16) Verifying for  : " + APIURLs.INSTANCE.Index_Name_IndexName_Pillar_Pillar() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Name_IndexName_Pillar_Pillar(),"200");
        String PartialHrefFromAPI16 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Name_IndexName_Pillar_Pillar(), "url","");
        String PartialHrefFromAPI16RemovingSlashes = PartialHrefFromAPI16.substring(1,PartialHrefFromAPI16.length()-1);
        log.info("End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI16);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI16 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromAPI16RemovingSlashes, PartialHrefFromUI16);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Name_IndexName_Binders() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************17) Verifying for  : " + APIURLs.INSTANCE.Index_Name_IndexName_Binders() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Name_IndexName_Binders(),"200");
        String PartialHrefFromAPI17 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Index_Name_IndexName_Binders(),"","[0]","[0]");
        String HeadlineFromAPI17 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Index_Name_IndexName_Binders(),"", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI17);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI17);
        String HeadlineFromUI17 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI17 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI17,HeadlineFromAPI17);
        CommonForAll.SimpleAssert(PartialHrefFromUI17, PartialHrefFromAPI17);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Name_IndexName_Extras() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************18) Verifying for  : " + APIURLs.INSTANCE.Index_Name_IndexName_Extras() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Name_IndexName_Extras(),"200");
        String GetTitleFromAPI = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Name_IndexName_Extras(),"navigation","title[0]");
        String UrlFromAPI18 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Name_IndexName_Extras(), "navigation","url[0]");
        String[] PartialHrefFromAPI18 = UrlFromAPI18.split("/");
        log.info("Title & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(GetTitleFromAPI);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI18 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromUI18,PartialHrefFromAPI18[PartialHrefFromAPI18.length - 1]);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Name_IndexName() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************19) Verifying for  : " + APIURLs.INSTANCE.Index_Name_IndexName() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Name_IndexName(),"200");
        String PartialURLFromAPI19 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Name_IndexName(), "url","");
        String PartialHrefFromAPI19RemovingSlashes = PartialURLFromAPI19.substring(1,PartialURLFromAPI19.length()-1);
        log.info("End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialURLFromAPI19);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI19 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromAPI19RemovingSlashes, PartialHrefFromUI19);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Url_IndexUrl_Binders() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************20) Verifying for  : " + APIURLs.INSTANCE.Index_Url_IndexUrl_Binders() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Url_IndexUrl_Binders(),"200");
        String PartialHrefFromAPI20 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Index_Url_IndexUrl_Binders(), "","[0]","[0]");
        String HeadlineFromAPI20 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Index_Url_IndexUrl_Binders(), "", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI20);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI20);
        String HeadlineFromUI20 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI20 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI20,HeadlineFromAPI20);
        CommonForAll.SimpleAssert(PartialHrefFromUI20, PartialHrefFromAPI20);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Url_IndexUrl_Extras() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************21) Verifying for  : " + APIURLs.INSTANCE.Index_Url_IndexUrl_Extras() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Url_IndexUrl_Extras(),"200");
        String GetTitleFromAPI21 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Url_IndexUrl_Extras(),"navigation","title[0]");
        String UrlFromAPI21 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Url_IndexUrl_Extras(), "navigation","url[0]");
        String[] PartialHrefFromAPI21 = UrlFromAPI21.split("/");
        log.info("Title & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(GetTitleFromAPI21);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI21 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromUI21,PartialHrefFromAPI21[PartialHrefFromAPI21.length - 1]);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsIndex_Url_IndexUrl() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************22) Verifying for  : " + APIURLs.INSTANCE.Index_Url_IndexUrl() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Index_Url_IndexUrl(),"200");
        String PartialURLFromAPI22 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Index_Url_IndexUrl(), "url","");
        String PartialHrefFromAPI22RemovingSlashes = PartialURLFromAPI22.substring(1,PartialURLFromAPI22.length()-1);
        log.info("End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialURLFromAPI22);
        RTEHomePage.OpenSearchResultByArticlePosition("1");
        String PartialHrefFromUI22 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromAPI22RemovingSlashes, PartialHrefFromUI22);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsCategory_Categories() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************23) Verifying for  : " + APIURLs.INSTANCE.Category_Categories() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Category_Categories(),"200");
        String PartialHrefFromAPI23 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Category_Categories(), "","[0]","[0]");
        String HeadlineFromAPI23 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Category_Categories(), "", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI23);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI23);
        String HeadlineFromUI23 = RTEArchivesArticlePage.CaptureHeadlineFromRTEArchivesArticlePage();
        String PartialHrefFromUI23 = RTEArchivesArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI23,HeadlineFromAPI23);
        CommonForAll.SimpleAssert(PartialHrefFromUI23, PartialHrefFromAPI23);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsPillar_Pillar_Category_Categories() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************24) Verifying for  : " + APIURLs.INSTANCE.Pillar_Pillar_Category_Categories() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Category_Categories(),"200");
        String PartialHrefFromAPI24 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Pillar_Pillar_Category_Categories(), "","[0]","[0]");
        String HeadlineFromAPI24 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Pillar_Pillar_Category_Categories(), "", "[1]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI24);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI24);
        String HeadlineFromUI24 = RTEArchivesArticlePage.CaptureHeadlineFromRTEArchivesArticlePage();
        String PartialHrefFromUI24 = RTEArchivesArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI24,HeadlineFromAPI24);
        CommonForAll.SimpleAssert(PartialHrefFromUI24, PartialHrefFromAPI24);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsTopic_Slug() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************25) Verifying for  : " + APIURLs.INSTANCE.Topic_Slug() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Topic_Slug(),"200");
        String NameFromAPI = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Topic_Slug(), "name","");
        CommonForAll.SimpleAssert(NameFromAPI, "Mental Health");
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsSport_Tournament_TournamentId_Name_TournamentName() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************26) Verifying for  : " + APIURLs.INSTANCE.Sport_Tournament_TournamentId_Name_TournamentName() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Sport_Tournament_TournamentId_Name_TournamentName(),"200");
        String ResultBinderIDFromAPI = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Sport_Tournament_TournamentId_Name_TournamentName(), "results_binder_id","");
        CommonForAll.SimpleAssert(ResultBinderIDFromAPI, "374462");
        log.info("ID Captured & Verified from API...");
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsSearch_Binder_Title_TitleKeywords() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************27) Verifying for  : " + APIURLs.INSTANCE.Search_Binder_Title_TitleKeywords() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Search_Binder_Title_TitleKeywords(),"200");
        String PartialHrefFromAPI27 = APIEndpoints.GetEndPartialHrefFromAPIWithBinders(APIURLs.INSTANCE.Search_Binder_Title_TitleKeywords(), "","[0]","[0]");
        String HeadlineFromAPI27 = APIEndpoints.GetHeadlineFromAPIWithBinders(APIURLs.INSTANCE.Search_Binder_Title_TitleKeywords(), "", "[0]");
        log.info("Headline & End Partial Href Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(PartialHrefFromAPI27);
        RTEHomePage.ClickAndOpenSearchResults(PartialHrefFromAPI27);
        String HeadlineFromUI27 = RTENewsArticlePage.CaptureHeadlineFromNewsArticlePage();
        String PartialHrefFromUI27 = RTENewsArticlePage.CaptureEndPartialHref();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(HeadlineFromUI27,HeadlineFromAPI27);
        CommonForAll.SimpleAssert(PartialHrefFromUI27, PartialHrefFromAPI27);
    }

    /**
     * Description: ARTE API EndPoints Validation
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPIEndpoints","OAT-1"}, description = "RTE API EndPoints Validation")
    public void RTEAPIEndPointsValidationsAv_Clip_Clip() throws InterruptedException, AWTException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APIEndPointURL;
        log.info("************************************************************************************************************************");
        log.info("******************************28) Verifying for  : " + APIURLs.INSTANCE.Av_Clip_Clip() + "******************************");
        //API Section
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.Av_Clip_Clip(),"200");
        String TitleFromAPI28 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Av_Clip_Clip(), "title","");
        String ThumbnailUrlFromAPI28 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Av_Clip_Clip(), "thumbnail_url","");
        String[] ThumbnailURLFromAPIEdited28 = ThumbnailUrlFromAPI28.split("-");
        String IDFromAPI28 = APIEndpoints.GetRandomKeyValueFromAPI(APIURLs.INSTANCE.Av_Clip_Clip(), "id","");
        log.info("Title. Thumbnail URL & ID Captured from API...");
        //UI Section
        log.info("Moving to UI Section...");
        RTEHomePage.AcceptCookies();
        RTEHomePage.SearchHomePage(TitleFromAPI28);
        RTEHomePage.ClickAndOpenSearchResults(IDFromAPI28);
        String PartialHrefFromUI28 = RTERadioArticlePage.CaptureEndPartialHref();
        String TitleFromUI = RTERadioArticlePage.CaptureTitleFromRadioArticlePage();
        log.info("Headline & End Partial Href Captured from UI...");
        CommonForAll.SimpleAssert(PartialHrefFromUI28,IDFromAPI28);
        CommonForAll.SimpleAssert(TitleFromUI, TitleFromAPI28);
        RTERadioArticlePage.VerifyingIfURLPresentOnScreen(ThumbnailURLFromAPIEdited28[0], ThumbnailURLFromAPIEdited28[0]);
    }

    //endregion API Endpoints

}







