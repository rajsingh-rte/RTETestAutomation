package Engine.ObjectRepository.TrialAPI;

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
public class RTEPage extends Page {
    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public WebDriverWait wait;
    Thread thread;

    public RTEPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //endregion

    //region Xpath
    private final By Cookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    //endregion



    /**
     *Description: Accept Cookies
     * @return
     */
    public void AcceptCookies() throws InterruptedException {
        CommonForAll.Click(Cookies);
    }

    /**
     * Description: Capture Headline URL By Position
     */
    public String CaptureTitleURLByPosition(String HeadlineNumber, String AttributeName ) throws InterruptedException {
        String HeadlineURLByPosition = CommonForAll.GetAttributeByXpath(By.xpath("//*[@id=\"main_inner\"]/div["+HeadlineNumber+"]/article/div/div/a"), AttributeName);
        return HeadlineURLByPosition;
    }

    /**
     * Description: Capture Headline by Position
     */
    public String CaptureTitleByPosition(String HeadlineNumber, String Option2 ) throws InterruptedException {
        String HeadlineByPosition = CommonForAll.GetTextByXpath(By.xpath("(//*[@id=\"main_inner\"]/div["+ HeadlineNumber +"]/article/div/div/a/h3/span)"));
        return HeadlineByPosition;
    }


    //endregion




}


