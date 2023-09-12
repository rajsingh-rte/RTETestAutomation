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
public class RTENewsArticlePage extends Page {
    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public WebDriverWait wait;
    Thread thread;

    public RTENewsArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //endregion

    //region Xpath
    private final By Headline = By.xpath("//*[@class=\"headline\"]");
    //endregion

    //region RTE News Article Page

    /**
     *Description: RTE Capture Headline from a News Article
     */
    public String CaptureHeadlineFromNewsArticlePage() throws InterruptedException {
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

    //endregion RTE News Article Page




}


