package Engine.ObjectRepository.Sample;

import Engine.CommonForAll.CommonForAll;
import Engine.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Created by Raj
 */
public class HomePageANZ extends Page {
    public HomePageANZ(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public WebDriverWait wait;
    public CommonForAll CommonForAll = new CommonForAll(driver);;
    Thread thread;

    //region Explicit Wait

    public void isElementLoaded(By elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLoaded));
    }
    //endregion


    //region Xpaths
    //Legal Entity
    private final By LegalEntity = By.id("legal-entity-menu-id");
    private final By AddButtonLegalEntity = By.id("add-legal-entity-tab-id");
    private final By LegalEntitySearchTab = By.xpath("//*[@id=\"elasticsearch-legal-entity-tab-id\"]");
    private final By SelectSourceType = By.xpath("//*[@id=\"select2-typeahead-select-externalReferenceType-container\"]");
    private final By FindEntitiesWithLE = By.xpath("//*[@id=\"elasticSegit_archTest_LE_unifiedSearchQuery\"]");
    private final By SearchButtonLE = By.xpath("//*[@id=\"legal-entity-elastic-search-elasticMenu-id\"]");

    //Generic Facility
    private final By Facility = By.xpath("//*[@id=\"exposure-menu-id\"]");
    private final By GenericFacility = By.xpath("//*[@id=\"exposure-show-add-href\"]");
    private final By FacilitySearchTab= By.xpath("//*[@id=\"elasticsearch-exposure-tab-id\"]");
    private final By FindEntitiesWithFacility = By.xpath("//*[@id=\"elasticSegit_archTest_Exposure_unifiedSearchQuery\"]");
    private final By SearchButtonFacility = By.xpath("//*[@id=\"exposure-elastic-search-elasticMenu-id\"]");

    //Collateral
    private final By CollateralTab= By.xpath("//*[@id=\"collateral-menu-id\"]");
    private final By LEDTab = By.xpath("//*[@id=\"ledNav\"]/a");
    private final By AddLEDButton = By.id("add-led-tab-id");
    private final By AddAssetButton = By.id("add-asset-tab-id");
    private final By SearchTabLED = By.xpath("//*[@id=\"elasticsearch-led-tab-id\"]");
    private final By FindEntitiesWithLED = By.xpath("//*[@id=\"elasticSegit_archTest_LED_unifiedSearchQuery\"]");
    private final By SearchLEDButton = By.xpath("//*[@id=\"led-elastic-search-elasticMenu-id\"]");

    //Asset
    private final By AssetTab = By.xpath("//*[@id=\"assetNav\"]/a");
    private final By SearchAssetButton = By.xpath("//*[@id=\"elasticsearch-asset-tab-id\"]");
    private final By FindEntitiesWithAsset = By.xpath("//*[@id=\"elasticSegit_archTest_Asset_unifiedSearchQuery\"]");
    private final By SearchButtonAsset = By.xpath("//*[@id=\"asset-elastic-search-elasticMenu-id\"]");

    //Application
    private final By ApplicationTab = By.xpath("//*[@id=\"collection-menu-id\"]");

    //General Insurance
    private final By GeneralInsuranceTab = By.xpath("//*[@id=\"generalInsurance-menu-id\"]");

    //endregion


    // region Top Menu
    /**
     * Description: TOP MENU
     */
    public void TopMenu(String option, String option1, String option2, String option3) throws InterruptedException {
        if(option=="Legal Entity")
        {
            isElementLoaded(LegalEntity);
            CommonForAll.Click(LegalEntity);
            CommonForAll.Click(AddButtonLegalEntity);
            driver.findElement(By.xpath("//a[contains(text(), '" + option1 + "')]")).click();

        }
        else if(option == "Facility")
        {
            CommonForAll.Click(Facility);
            Thread.sleep(300);
            CommonForAll.Click(By.xpath("//a[contains(text(), '" + option1 + "')]"));

        }
        else if(option == "Application")
        {
            driver.findElement(ApplicationTab).click();
            Thread.sleep(300);
            driver.findElement(By.xpath("(//a[contains(text(), '" + option1 + "')])[2]")).click();
            driver.findElement(By.xpath("(//a[contains(text(), '" + option2 + "')])")).click();
        }
        else if (option == "Maintenance")
        {


        }
        else if(option == "General Insurance")
        {
            driver.findElement(GeneralInsuranceTab).click();
            Thread.sleep(300);
            driver.findElement(By.xpath("(//a[contains(text(), '" + option1 + "')])[2]")).click();
            driver.findElement(By.xpath("(//a[contains(text(), '" + option2 + "')])[3]")).click();
        }

        else if(option=="Collateral")
        {
            driver.findElement(CollateralTab).click();
            if(option1 == "LED")
            {

                    driver.findElement(By.xpath("(//a[contains(text(), '" + option1 + "')])")).click();
                    CommonForAll.Click(AddLEDButton);
                    CommonForAll.Click(By.xpath("(//a[contains(text(), '" + option2 + "')])"));
                    thread.sleep(1000);
                    CommonForAll.Click(By.xpath("//a[text()= '" + option3 + "']"));
                    //driver.findElement(By.xpath("//a[text()= '" + option3 + "']")).click();
            }
            else if(option1 == "Asset")
            {
                driver.findElement(By.xpath("(//a[contains(text(), '" + option1 + "')])")).click();
                driver.findElement(AddAssetButton).click();
                driver.findElement(By.xpath("(//a[contains(text(), '" + option2 + "')])")).click();
                thread.sleep(1000);
                CommonForAll.Click(By.xpath("//a[text()= '" + option3 + "']"));
                //driver.findElement(By.xpath("//a[text()= '" + option3 + "']")).click();
            }

        }


    }



    /**
     * Description: Search Menu
     */
    public void SearchMenu(String option, String ToSearchValue, String SourceType, String option3, String option4, String option5) throws InterruptedException {

        if (option == "Legal Entity") {

            CommonForAll.Click(LegalEntity);
            CommonForAll.Click(LegalEntitySearchTab);
            CommonForAll.ClickAndSelectByLiWithoutScroll(SelectSourceType, SourceType);
            CommonForAll.SendKeys(FindEntitiesWithLE, ToSearchValue);
            CommonForAll.Click(SearchButtonLE);
        } else if (option == "Facility") {
            CommonForAll.Click(Facility);
            CommonForAll.Click(FacilitySearchTab);
            CommonForAll.SendKeys(FindEntitiesWithFacility, ToSearchValue);
            CommonForAll.Click(SearchButtonFacility);
        } else if (option == "LED") {
            CommonForAll.Click(CollateralTab);
            CommonForAll.Click(LEDTab);
            CommonForAll.Click(SearchTabLED);
            CommonForAll.SendKeys(FindEntitiesWithLED, ToSearchValue);
            CommonForAll.Click(SearchLEDButton);

        } else if (option == "Asset") {
            CommonForAll.Click(CollateralTab);
            CommonForAll.Click(AssetTab);
            CommonForAll.Click(SearchAssetButton);
            CommonForAll.SendKeys(FindEntitiesWithAsset, ToSearchValue);
            CommonForAll.Click(SearchButtonAsset);
        }
    }

//endregion
}



