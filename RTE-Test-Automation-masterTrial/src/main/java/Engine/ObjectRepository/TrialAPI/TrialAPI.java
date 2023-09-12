package Engine.ObjectRepository.TrialAPI;
import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import Engine.config.LocalConfig;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.JMock1Matchers.equalTo;

import io.restassured.path.json.JsonPath;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;



/**
 * Created by Raj
 */
public class TrialAPI extends Page {
    public TrialAPI(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public WebDriverWait wait;
    Thread thread;
    private static final String APIEndPointURL = LocalConfig.INSTANCE.APIEndPointURL();
    private Engine.CommonForAll.CommonForAll CommonForAll;
    private static final Logger log = Logger.getLogger(BaseTest.class);

    //region Explicit Wait
    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion


    // region API Endpoints Test

    /**
     * Description: API URL Status Check
     */
    public void APIURLStatusCheck() throws InterruptedException {

        //Running the API URL

    }

    /**
     * Description: API Get
     */
    public void ApiGetAndVerify_Category_Title_And_Title_URL_By_Position(String APIUrl2, String TitleFromUI, String TitleURLFromUI, String HeadlinePosition) throws InterruptedException {

        //Running the API URL
        String response = given().log().all().when().get(APIUrl2).then().assertThat().statusCode(200).log().status().body("category", equalTo("news headlines")).log().status().extract().response().asString(); //Also verifying category
        JsonPath js = new JsonPath(response); //Parsing Json Can be kept in Common Method
        log.info("API Response and category verified: Success");

        int TotalDocumentsCount = js.get("total_document_count"); //getting total count of document
        log.info("Document count Retrieved: " + TotalDocumentsCount);

        //Retrieving Data From API Response
        String TitleFromAPI = js.get("documents["+ HeadlinePosition +"].title"); //Print Title of first News and url
        String TitleURLFromAPI = js.getString("documents[" +HeadlinePosition +"].url"); //Print Title of first News and url
        log.info("API Title is : " + TitleFromAPI);
        log.info("API URL is : https://www.rte.ie" + TitleURLFromAPI);

        //Asserting the response from UI and API
        Assert.assertEquals(TitleFromUI, TitleFromAPI);
        Assert.assertEquals(TitleURLFromUI, "https://www.rte.ie"+TitleURLFromAPI);
        log.info("Title & URL for a Headline successfully validated in UI and API");

    }

    //RestAssured.baseURI = "https://newsapi.org";
    //given().log().all().when().get("v2/everything?q=tesla&from=2023-04-11&sortBy=publishedAt&apiKey=42555b049ace45e0ba9e3ef2b33f6af2").then().assertThat().log().all().statusCode(200).extract().response().asString();
    //https://newsapi.org/v2/everything?q=tesla&from=2023-04-11&sortBy=publishedAt&apiKey=42555b049ace45e0ba9e3ef2b33f6af2
    //https://www.rte.ie/newsapi/list/?rows=39&category=news
    //give() - all input Details .queryparam().header().authorization().body()
    //when() - Submit the API -resource, http methods .when.post("Rest of URL") ,log().all()
    //then() - validate the response .then().assertThat().statuscode(200).body("scope",equalTo(APP)"").Headers().extract(Gets the boday into string).response.string
    /*Can validate, Response codes, Headers(Servers Website details), Parameters, update by capturing the id
     */
    //RestAssured.baseURI = APIUrl[0];

//endregion region API Endpoints
}





