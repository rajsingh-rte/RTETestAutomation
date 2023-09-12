package TestCases.TrialAPI;

import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.TrialAPI.RTEPage;
import Engine.ObjectRepository.TrialAPI.TrialAPI;
import Engine.common.BaseTest;
import Engine.common.LoginPage;
import Engine.config.LocalConfig;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.awt.*;

import static io.restassured.RestAssured.given;

/**
 * Created by Raj.
 */
public class TrialAPIAndUIAutomation extends BaseTest {

    private LoginPage loginPage;
    Thread thread = null;
    private TrialAPI TrialAPI;
    private static final String[] APISampleUrl = LocalConfig.INSTANCE.APIUrlHeadlines();
    private static final String RTESampleUrl = LocalConfig.INSTANCE.RTESampleUrl();
    private static final String EPICUrl = LocalConfig.INSTANCE.EPICURL();
    private static final Logger log = Logger.getLogger(BaseTest.class);
    private Engine.CommonForAll.CommonForAll CommonForAll;
    private RTEPage RTEPage;


    //region Data

    /**
     * Random Data
     **/
    public static String String1 = null;
    public static String String2 = null;
    public static String String3 = null;
    public static String String4 = null;
    //endregion

    //region API GET

    /**
     * Description: Verifying Title And URL from API and UI and category and Request Status from API
     */
    @Test(groups = {"APIGet", "Smoke"}, description = "Get API for Rte By Category", priority = 0)
    public void SampleValidationsValidations() throws InterruptedException, AWTException {
        TrialAPI = new TrialAPI(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEPage RTEPage = new RTEPage(driver);
        driver.get(RTESampleUrl);

        //UI SECTION
        RTEPage.AcceptCookies();
        String TitleFromUI = RTEPage.CaptureTitleByPosition("1", "");
        String URLFromUI = RTEPage.CaptureTitleURLByPosition("1", "href");
        System.out.println(TitleFromUI);
        System.out.println(URLFromUI);
        log.info("UI Title is : " + TitleFromUI); //Commented
        log.info("UI URL is : " + URLFromUI);     //Commented

        //API SECTION
        RestAssured.baseURI = APISampleUrl[0];
        TrialAPI.ApiGetAndVerify_Category_Title_And_Title_URL_By_Position(APISampleUrl[1], TitleFromUI, URLFromUI, "0");

    }

    /**
     * Description: Accessing EPIC
     */
    @Test(groups = {"APIGet", "Smoke"}, description = "Get API for Rte By Category", priority = 0)
    public void AccessingEPIC() throws InterruptedException, AWTException {
        TrialAPI = new TrialAPI(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEPage RTEPage = new RTEPage(driver);
        driver.get(EPICUrl);

        thread.sleep(3000);

        System.out.println(Engine.CommonForAll.CommonForAll.getTwoFactorCode());;
    }
}


//endregion





