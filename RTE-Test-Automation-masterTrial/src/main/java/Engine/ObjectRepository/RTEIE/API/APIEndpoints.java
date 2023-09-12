package Engine.ObjectRepository.RTEIE.API;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import Engine.config.LocalConfig;
import Engine.config.APIURLs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by Raj
 */
public class APIEndpoints extends Page {
    public APIEndpoints(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriverWait wait;
    Thread thread;
    public CommonForAll CommonForAll = new CommonForAll(driver);
    private static final String APIEndPointURL = LocalConfig.INSTANCE.APIEndPointURL();
    private static final String Author_BinderId_Binder = APIURLs.INSTANCE.Author_BinderId_Binders();
    //public Engine.CommonForAll.CommonForAll CommonForAll;
    private static final Logger log = Logger.getLogger(BaseTest.class);

    //region Explicit Wait
    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion

    //region API Endpoints Test

    /**
     * Description: Get xyz.xyz from API, Example -- Binders.title[1]
     * Example: Method returns anything from a key value pair, Binders.title[1]. Here input will be Binders & title[1]
     * @return
     */
    public String GetRandomKeyValueFromAPI(String SecondaryURL,String Key1, String Key2) throws InterruptedException {
        //API Section
        if(Objects.equals(Key2, "")) {
            JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
            String Value = js.getString(Key1).replace("[", "").replace("]", "");
            log.info(Key1 + " from API is : " + Value);
            return Value;
        }
        else {
            JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
            String Value = js.getString(Key1 + "." + Key2).replace("[", "").replace("]", "");
            log.info(Key1 + "." + Key2 + " from API is : " + Value);
            return Value;
        }
    }

    /**
     * Description: Get Binders.xyz from API, Example -- Binders.title[1]
     * Example: Method returns anything that is present after the dot, Binders.title[1] will return Title in API, here input is  "title[1]"
     * @return
     */
    public String GetKeyValueFromAPIWithBinders(String SecondaryURL,String BindersPositionWithSquareBrackets, String KeyNameAndPosition) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        String Value = js.getString("binders"+ BindersPositionWithSquareBrackets + "." + KeyNameAndPosition).replace("[","").replace("]","");;
        log.info( KeyNameAndPosition +" from API is : " + Value);
        return Value;
    }

    /**
     * Description: Get Headline from API with binders.headline with secondary URL input -- Binders.headline
     * Example: Method returns Headline: "The abortion review 5 years on: what the research found"
     * @return
     */
    public String GetHeadlineFromAPIWithBinders(String SecondaryURL,String BindersPositionWithSquareBrackets, String HeadlinePositionWithBrackets) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        Thread.sleep(200);
        String Headline = js.getString("binders"+ BindersPositionWithSquareBrackets +".headline"+ HeadlinePositionWithBrackets).replace("[","").replace("]","");;
        log.info("Headline from API is : " + Headline);
        return Headline;
    }

    /**
     * Description: API - Create End Partial Href from API with Binders.xyz using ID and filename, --binders.id & binders.filename
     * example ID: 1386583 & Filename: abortion-review-research-2023, the method returns "1386583-abortion-review-research-2023"
     * @return
     */
    public String GetEndPartialHrefFromAPIWithBinders(String SecondaryURL,String BindersPositionWithSquareBrackets,String FileNamePositionWithBrackets,String IDPositionWithBrackets) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        Thread.sleep(500);
        String Filename = js.getString("binders"+BindersPositionWithSquareBrackets+".filename"+ FileNamePositionWithBrackets).replace("[","").replace("]","");;
        String Id = js.getString("binders"+BindersPositionWithSquareBrackets+".id"+ IDPositionWithBrackets +"").replace("[","").replace("]","");
        String EndURL = String.join("-",Id,Filename);
        log.info("End Partial Href from API Response is : " + EndURL);
        return EndURL;
    }
    /**
     * Description: Get Headline from API with secondary URL input (no Binders.xyz)
     * Example: Method returns Headline: "The abortion review 5 years on: what the research found"
     * @return
     */
    public String GetHeadlineFromAPI(String SecondaryURL, String HeadlinePositionWithSquareBrackets) throws InterruptedException {
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        String Headline = js.getString("headline"+ HeadlinePositionWithSquareBrackets +"").replace("[","").replace("]","");;
        log.info("Headline from API is : " + Headline);
        return Headline;
    }

    /**
     * Description: API - Create End Partial Href from API using ID and filename, (No Binders.xyz)
     * example ID: 1386583 & Filename: abortion-review-research-2023, the method returns "1386583-abortion-review-research-2023"
     * @return
     */
    public String GetEndPartialHrefFromAPI(String SecondaryURL,String FileNamePositionWithSquareBrackets,String IDPositionWithSquareBrackets) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        Thread.sleep(500);
        String Filename = js.getString("filename"+ FileNamePositionWithSquareBrackets +"").replace("[","").replace("]","");;
        String Id = js.getString("id"+ IDPositionWithSquareBrackets +"").replace("[","").replace("]","");
        String EndURL = String.join("-",Id,Filename);
        log.info("End Partial Href from API Response is : " + EndURL);
        return EndURL;
    }

    /**
     * Description: API Get Sample
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
        String TitleURLFromAPI = js.get("documents[" +HeadlinePosition +"].url"); //Print Title of first News and url
        log.info("API Title is : " + TitleFromAPI);
        log.info("API URL is : https://www.rte.ie" + TitleURLFromAPI);
        //Asserting the response from UI and API
        Assert.assertEquals(TitleFromUI, TitleFromAPI);
        Assert.assertEquals(TitleURLFromUI, "https://www.rte.ie"+TitleURLFromAPI);
        log.info("Title & URL for a Headline successfully validated in UI and API");

    }

    //endregion API Endpoints Test
}





