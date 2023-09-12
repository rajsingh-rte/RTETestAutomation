package Engine.ObjectRepository.RTEIE.RTEPages;
import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;


/**
 * Created by Raj
 */
public class RTEHomePage extends Page {
    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public static CommonForAll CommonForAll = new CommonForAll(driver);
    public WebDriverWait wait;
    static Thread thread;

    public RTEHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //endregion

    //region Xpath
    private final By Cookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    private final By SearchIconHomePage = By.xpath("//*[@id=\"mobile_search_nav_button\"]");
    private final By SearchIconArticlePage = By.xpath("//*[@id=\"search_nav_button\"]");
    private final By SearchBarTextField = By.xpath("//*[@id=\"searchterm\"]");
    public final By SeeAllResults = By.xpath("//*[@id=\"QsearchBtn\"]/span");
    //top menu
    private final By Sport = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");

    //endregion

    //region RTE Home Page

    /**
     * Description: TOP MENU
     */
    public void TopMenu(String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8, String optipn9) throws InterruptedException {
        Thread.sleep(500);
        AcceptCookies();

        if (Objects.equals(option1, "NEWS")) {
            CommonForAll.Click(By.xpath("(//*[@class=\"primary-nav-container\"]//nav//ul//li)[1]"));

        } else if (Objects.equals(option1, "SPORT")) {
            Thread.sleep(500);
            CommonForAll.Click(By.xpath("(//*[@class=\"primary-nav-container\"]//nav//ul//li)[2]"));

            if (Objects.equals(option2, "Fixtures/Results"))
            {
                Thread.sleep(1000);
                CommonForAll.Click(By.xpath("//*[text()[normalize-space() = '" + option2 + "']]"));
                thread.sleep(1000);
                CommonForAll.Click(By.xpath("//*[text()[normalize-space() = '" + option3 + "']]"));
                thread.sleep(1000);
            }

        }
    }

    /**
     *Description: Open Search Result By Position
     */
    public void OpenSearchResultByArticlePosition(String ArticlePosition) throws InterruptedException {
        CommonForAll.Click(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/article["+ ArticlePosition +"]"));
    }

    /**
     *Description: Click and Open search results on RTE home page by partial href input.
     */
    public void ClickAndOpenSearchResults(String PartialHrefInputToBeClicked) throws InterruptedException {
        Thread.sleep(200);
        CommonForAll.Click(By.xpath("//a[contains(normalize-space(@href),'"+ PartialHrefInputToBeClicked +"')]"));
    }


    /**
     *Description: Search for something in RTE Article Page Search Tab.
     */
    public void SearchHomePage(String SearchBarInput) throws InterruptedException {
        CommonForAll.Click(SearchIconHomePage);
        CommonForAll.Click(SearchBarTextField);
        CommonForAll.SendKeys(SearchBarTextField, SearchBarInput);
        CommonForAll.Click(SeeAllResults);
    }

    /**
     *Description: Search for something in RTE Home Page Search Tab.
     */
    public void SearchArticlePage(String SearchBarInput) throws InterruptedException {
        CommonForAll.Click(SearchIconArticlePage);
        CommonForAll.Click(SearchBarTextField);
        CommonForAll.SendKeys(SearchBarTextField, SearchBarInput);
        CommonForAll.Click(SeeAllResults);
    }

    /**
     *Description: Accept Cookies
     */
    public void AcceptCookies() throws InterruptedException {
        Thread.sleep(250);
        CommonForAll.Click(Cookies);
    }

    /**
     * Description: Capture Headline URL By Position & attribute Name
     */
    public String CaptureHeadlineURLByPosition(String HeadlineNumber, String AttributeName ) throws InterruptedException {
        String HeadlineURLByPosition = CommonForAll.GetAttributeByXpath(By.xpath("//*[@id=\"main_inner\"]/div["+HeadlineNumber+"]/article/div/div/a"), AttributeName);
        return HeadlineURLByPosition;
    }

    /**
     * Description: Capture Headline by Position from series of continious headlines
     */
    public String CaptureTitleByPosition(String HeadlineNumber, String Option2 ) throws InterruptedException {
        String HeadlineByPosition = CommonForAll.GetTextByXpath(By.xpath("(//*[@id=\"main_inner\"]/div["+ HeadlineNumber +"]/article/div/div/a/h3/span)"));
        return HeadlineByPosition;
    }

    //endregion RTE Home Page




}


