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
public class RTERadioArticlePage extends Page {
    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public WebDriverWait wait;
    Thread thread;

    public RTERadioArticlePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //endregion

    //region Xpath
    private final By Title = By.xpath("//*[@id=\"player-title\"]");
    //endregion

    //region RTE Radio Article Page

    /**
     *Description: Verifying if partial URl/ImageURL is present on the screen or not
     *
     */
    public void VerifyingIfURLPresentOnScreen(String URLToBeChecked, String FieldName) throws InterruptedException {
        CommonForAll.AssertIfPresent(By.xpath("//*[contains(normalize-space(@src),'"+ URLToBeChecked +"')]"),FieldName);
    }

    /**
     *Description: Capture Title from Radio Article Page
     *
     */
    public String CaptureTitleFromRadioArticlePage() throws InterruptedException {
        String HeadlineText = CommonForAll.GetTextByXpath(Title);
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



    //endregion RTE Radio Article Page




}


