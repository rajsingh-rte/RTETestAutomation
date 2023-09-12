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


/**
 * Created by Raj
 */
public class RTEArchivesArticlePage extends Page {
    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public static CommonForAll CommonForAll = new CommonForAll(driver);
    public WebDriverWait wait;
    Thread thread;

    public RTEArchivesArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //endregion

    //region Xpath
    private static final By Headline = By.xpath("//*[contains(@class,'article_header')]/div/div/h1/span[2]");
    private final By SearchIconHomePage = By.xpath("//*[@id=\"mobile_search_nav_button\"]");
    private static final By SearchIconArticlePage = By.xpath("//*[@id=\"search_nav_button\"]");
    private static final By SearchBarTextField = By.xpath("//*[@id=\"searchterm\"]");
    private static final By GoButton = By.xpath("//*[@name=\"searchform\"]/button");
    //endregion

    //region RTE Radio Article Page

    /**
     *Description: Capture Headline RTE Archives article page
     *
     */
    public String CaptureHeadlineFromRTEArchivesArticlePage() throws InterruptedException {
        String HeadlineText = CommonForAll.GetTextByXpath(Headline);
        log.info("Headline from UI is : " + HeadlineText);
        return HeadlineText;
    }

    /**
     *Description: Get End partial url from News Article:
     *Example From "www.rte.ie/brainstorm/2023/0531/1386583-abortion-review-research-2023/" method returns  "1386583-abortion-review-research-2023/"
     */
    public String CaptureEndPartialHref() throws InterruptedException {
        String CompleteURL = CommonForAll.CapturePageURL();
        String[] PartialEndURL = CompleteURL.split("/");
        log.info("End Partial Href from UI is : " + PartialEndURL[PartialEndURL.length - 1]);
        return PartialEndURL[PartialEndURL.length - 1];
    }

    /**
     *Description: Search for something from RTE Archives Page
     */
    public void SearchFromRTEArchivesPage(String SearchBarInput) throws InterruptedException {
        CommonForAll.Click(SearchIconArticlePage);
        CommonForAll.Click(SearchBarTextField);
        CommonForAll.SendKeys(SearchBarTextField, SearchBarInput);
        CommonForAll.Click(GoButton);
    }

    //endregion RTE Radio Article Page




}


