package Engine.ObjectRepository.RTEIE.RTEPages;
import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.RTEIE.API.APISportsPages;
import Engine.common.BaseTest;
import Engine.common.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Created by Raj
 */
public class RTESportsPages extends Page {
    //region Initialization
    private static final Logger log = Logger.getLogger(BaseTest.class);
    public CommonForAll CommonForAll = new CommonForAll(driver);
    public APISportsPages APISportsPages = new APISportsPages(driver);
    public WebDriverWait wait;
    Thread thread;

    public RTESportsPages(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //endregion

    //region Xpath
    private final By Schedule = By.xpath("//a[contains(normalize-space(text()), 'Schedule')]");
    private final By Results = By.xpath("//a[contains(normalize-space(text()), 'Results')]");
    private final By BackToAllTournaments = By.xpath("//*[normalize-space(@class)=\"results-link\"]");
    private final By Calendar = By.xpath("//a[contains(normalize-space(text()), 'Calendar')]");
    private final By Standings = By.xpath("(//*[@class=\" results-sub-nav\"]//ul//li)[3]");
    //endregion

    //region RTE Sport Pages Golf & Tennis

    /**
     *Description: Verifying In UI Sports Person Name & Winner or looser from result_code as captured from API Event Results  //IDForEventResults is from method ReturnIdForEventFixtures()
     * //Verifying Result Code for : Tennis
     * Compares Between 2 participant has won or lost in API and UI
     */
    public void VerifyingResultsCodeForASport(String SecondaryURL, String IDForEventResults, String ResultCodeNameNeededFromAPIEventsResults) throws InterruptedException, ParseException {
        ArrayList<String> ListOfTournamentPlayersNameAndScore = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, ResultCodeNameNeededFromAPIEventsResults);
        if (ListOfTournamentPlayersNameAndScore.size() == 0) {
            log.info(ResultCodeNameNeededFromAPIEventsResults + " : is Empty in the UI and API...");
        }
        String WinOrLost = null;
        int SportsPersonsScoreInUI2 = 0 ;
        for (int i = 0; i < ListOfTournamentPlayersNameAndScore.size(); i += 2) {
            int SportsPersonsScoreInUI = Integer.parseInt(driver.findElement(By.xpath("(//div[@id='" + IDForEventResults + "']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"sets\"]")).getText());
            if (i==0) {
                SportsPersonsScoreInUI2 = Integer.parseInt(driver.findElement(By.xpath("(//div[@id='" + IDForEventResults + "']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i + 2) + "')]//parent::div)//div[@class=\"sets\"]")).getText());
            }
            else if(i==2) {
                SportsPersonsScoreInUI2 = Integer.parseInt(driver.findElement(By.xpath("(//div[@id='" + IDForEventResults + "']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i - 2) + "')]//parent::div)//div[@class=\"sets\"]")).getText());
            }

            if (SportsPersonsScoreInUI<SportsPersonsScoreInUI2) {
                WinOrLost = "lost";
            }
            else {
                WinOrLost = "won";
            }
            CommonForAll.SimpleAssert(WinOrLost, ListOfTournamentPlayersNameAndScore.get(i + 1));
            log.info(ListOfTournamentPlayersNameAndScore.get(i) + " has " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
            log.info("..............");
        }
    }

    /**
     *Description: Verifying In UI Sports Person Name & Rank as captured from API Event Results  //IDForEventResults is from method ReturnIdForEventFixtures()
     * //ResultsneededforFromAPI : Rank and Assert Rank in UI and API
     */
    public void VerifyingInResultsUISportsPersonsNamesAndRankAsCapturedFromAPI(String SecondaryURL, String IDForEventResults, String ResultCodeNameNeededFromAPIEventsResults, String SportsName) throws InterruptedException, ParseException {
        ArrayList<String> ListOfTournamentPlayersNameAndScore = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, ResultCodeNameNeededFromAPIEventsResults);
        if (ListOfTournamentPlayersNameAndScore.size() == 0) {
            log.info(ResultCodeNameNeededFromAPIEventsResults + " : is Empty in the UI and API...");
        }
        for (int i = 0; i < ListOfTournamentPlayersNameAndScore.size(); i += 2) {
            if (SportsName.equalsIgnoreCase("Formula 1")) {
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::div/span[1]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " rank of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }
        }
    }

    /**
     *Description: Verifying In UI Sports Person Name & Scores as captured from API Event Results  //IDForEventResults is from method ReturnIdForEventFixtures()
     * //ResultsneededforFromAPI : par, rank, strokes_r1, strokes_r2, strokes_r3, strokes_r4
     */
    public void VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(String SecondaryURL, String IDForEventResults, String ResultCodeNameNeededFromAPIEventsResults) throws InterruptedException, ParseException {
        ArrayList<String> ListOfTournamentPlayersNameAndScore = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, ResultCodeNameNeededFromAPIEventsResults);
        if (ListOfTournamentPlayersNameAndScore.size() == 0)
        {
            log.info(ResultCodeNameNeededFromAPIEventsResults + " : is Empty in the UI and API...");
        }
        for (int i = 0; i < ListOfTournamentPlayersNameAndScore.size(); i += 2) {
            if(ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("par")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::td/following-sibling::td[1]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("E", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("strokes_r1")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::td/following-sibling::td[3]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("E", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("strokes_r2")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::td/following-sibling::td[4]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("E", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("strokes_r3")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::td/following-sibling::td[5]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("E", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("strokes_r4")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::td/following-sibling::td[6]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("E", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("runningscore")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"sets\"]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("set1")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"set\"][1]")).getText();
                if (SportsPersonsScoreInUI.length() >= 2)
                {   ArrayList<String> tiebreak1 = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, "tiebreak1");
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)));
                }
                else{
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("set2")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"set\"][2]")).getText();
                if (SportsPersonsScoreInUI.length() >= 2)
                {   ArrayList<String> tiebreak1 = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, "tiebreak2");
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");

                }
                else{
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("set3")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"set\"][3]")).getText();
                if (SportsPersonsScoreInUI.length() >= 2) {
                    ArrayList<String> tiebreak1 = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, "tiebreak3");
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                else{
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("set4")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"set\"][4]")).getText();
                if (SportsPersonsScoreInUI.length() >= 2) {
                    ArrayList<String> tiebreak1 = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, "tiebreak4");
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                else{
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("set5")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"set\"][5]")).getText();
                if (SportsPersonsScoreInUI.length() >= 2) {
                    ArrayList<String> tiebreak1 = APISportsPages.ListOfAllSportsPersonsAndScoresInEventResultsAPI(SecondaryURL, IDForEventResults, "tiebreak5");
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1).concat(tiebreak1.get(i+1)) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                else{
                    CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                    log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                }
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("setswon")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("(//div[@id='"+ IDForEventResults +"']//div[contains(text(),'" + ListOfTournamentPlayersNameAndScore.get(i) + "')]//parent::div)//div[@class=\"sets\"]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " score of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("pitstops")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::div/following-sibling::div[2]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("E", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " pitstop of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("Laps")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::div/following-sibling::div[1]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " lap of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("duration")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::div/following-sibling::div[3]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " duration of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

            else if (ResultCodeNameNeededFromAPIEventsResults.equalsIgnoreCase("points")){
                String SportsPersonsScoreInUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayersNameAndScore.get(i) + "']/parent::div/following-sibling::div[4]")).getText();
                CommonForAll.SimpleAssert(SportsPersonsScoreInUI.replace("-", "0"), ListOfTournamentPlayersNameAndScore.get(i + 1));
                log.info(ListOfTournamentPlayersNameAndScore.get(i) + " points of " + ListOfTournamentPlayersNameAndScore.get(i + 1) + " is present in the API and UI...Passed!!!!!!!!!!!!!!!!!!!");
                log.info("..............");
            }

        }

    }

    /**
     *Description: Verifying In UI Sports Person Name as captured from API Event Results  //IDForEventResults is from method ReturnIdForEventFixtures()
     */
    public void VerifyingInResultsUISportsPersonsNamesAsCapturedFromAPI(String SecondaryURL, String IDForEventResults) throws InterruptedException, ParseException {
        APISportsPages APISportsPages = new APISportsPages(driver);
        ArrayList<String> ListOfTournamentPlayerNames = APISportsPages.ListOfAllSportsPersonsNamesInEventResults(SecondaryURL, IDForEventResults);
        //ArrayList<String> ListOfTournamentStagesDates = APISportsPages.ReturnAllTournamentStagesStartDate(SecondaryURL);
        for (int i = 0; i < ListOfTournamentPlayerNames.size(); i++)
        {
            try {
                String NameOfSportsPersonFromUI = driver.findElement(By.xpath("//*[normalize-space(text())='" + ListOfTournamentPlayerNames.get(i) + "']")).getText();
                CommonForAll.SimpleAssert(NameOfSportsPersonFromUI, ListOfTournamentPlayerNames.get(i));
                log.info(ListOfTournamentPlayerNames.get(i) + " is present in the API and UI...: Passed!!!!!!!!!!!!!!!!!!!");
            }
            catch(AssertionError | NoSuchElementException e)
            {
                log.info(ListOfTournamentPlayerNames.get(i) + " with id : " + ListOfTournamentPlayerNames.get(i) + " and date : " + ListOfTournamentPlayerNames + " are not on the screen ######################################Failed######################################");
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            }

        }

    }

    /**
     *Description: Capture Value text for Metadata. Example if Game Type is passed it will return Stroke Play in Results page
     * !!!!!!!!!!GOLF!!!!!!!!!!!
     */
    public String CaptureTextForMetadata(String MetadataName) throws InterruptedException {
        thread.sleep(250);
        String ValueforMetadata = driver.findElement(By.xpath("//*[@class=\"stage-meta\"]/text()[contains(.,'"+ MetadataName +"')]/following-sibling::span[1]")).getText().trim();
        log.info("Value for the "+MetadataName+" in UI is : "+ValueforMetadata+"...");
        return ValueforMetadata;
    }

    /**
     *Description: Capture Tournament Header Text in UI
     *  !!!!!!!!!!Golf , Tennis!!!!!!!!!!!
     */
    public String CaptureTextForTournamentHeader() throws InterruptedException {
        thread.sleep(250);
        String ValueForHeader = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[1]/h1")).getText().trim();
        log.info("Value for the header in UI is : "+ValueForHeader+"...");
        return ValueForHeader;
    }

    /**
     *Description: Verify Total No. of Rounds Capture in Golf
     */
    public String VerifyTotalNumberOfRoundsInGolf(String TotalNoOfRounds) throws InterruptedException {
        thread.sleep(250);
        String ValueforMetadata = null;
        try {
            ValueforMetadata = driver.findElement(By.xpath("//*[@class=\"results-data-header\"]/*[text()='" + TotalNoOfRounds + "'] ")).getText().trim();
            return ValueforMetadata;
        }
        catch(NoSuchElementException | AssertionError e){
            Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            log.info("Total No of Rounds is not "+ TotalNoOfRounds +"###############Failed###############");
        }

        return ValueforMetadata;
    }

    /**
     *Description: Click on Results
     */
    public void ClickOnResults() throws InterruptedException {
        log.info("Moving to Results page...");
        thread.sleep(500);
        CommonForAll.Click(Results);
        thread.sleep(500);
    }

    /**
     *Description: Click on Back to all tournaments
     */
    public void ClickOnBackToAllTournaments() throws InterruptedException {
        log.info("Moving to Results page...");
        Thread.sleep(500);
        CommonForAll.Click(BackToAllTournaments);
        thread.sleep(500);
    }

    /**
     *Description: Click on Schedule
     */
    public void ClickOnSchedule() throws InterruptedException {
        log.info("Moving to Schedule page...");
        thread.sleep(500);
        CommonForAll.Click(Schedule);
        thread.sleep(500);
    }

    /**
     * Description: Capture Event ID or Tournament Stages ID From HREF (Golf)
     * Ex: href="/sport/results/golf/european-tour-1/18283/made-in-himmerland-881937" will capture 881937
     * here position is multiples of 2 like 2,4,6,8
     *
     * @return
     */
    public String CaptureEventIDFromHrefByPosition(int Position) throws InterruptedException {

        thread.sleep(500);
        String FullHref = driver.findElement(By.xpath("//*[@class=\"results-container\"]/div/div/div/a["+ Position +"]")).getAttribute("href");
        String EventId = FullHref.substring(FullHref.length()-7).replace("-","").replace(" ","").replace("/","");
        log.info("Tournament Stages id or Event Id from " + Position/2 + " position is "+ EventId + "...");
        return EventId;
    }

    /**
     * Description: Capture Event ID or Tournament Stages ID From HREF (Tennis)
     * Ex: data-matchid="885691" will capture 885691
     *
     * @return
     */
    public String CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition2(int Position) throws InterruptedException {

        thread.sleep(500);
        String DataMatchID = driver.findElement(By.xpath("//*[@class=\"results-container\"]/div/div[2]/div/ul[last()]/li["+ Position +"]/a")).getAttribute("data-matchid");
        String EventId = DataMatchID.trim();
        log.info("Tournament Stages id or Event Id from " + Position + " position is "+ EventId + "...");
        return EventId;
    }

    /**
     * Description: Capture Event ID or Tournament Stages ID From HREF (Tennis)
     * Ex: data-matchid="885691" will capture 885691
     *
     * @return
     */
    public String CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition3(int Position) throws InterruptedException {

        thread.sleep(500);
        String DataMatchID = driver.findElement(By.xpath("//*[@class=\"results-container\"]/div/div[2]/div/ul/li["+ Position +"]/a")).getAttribute("data-matchid");
        String EventId = DataMatchID.trim();
        log.info("Tournament Stages id or Event Id from " + Position + " position is "+ EventId + "...");
        return EventId;
    }

    /**
     * Description: Capture Event ID or Tournament Stages ID From HREF (Formula 1)
     * Ex: data-matchid="885691" will capture 885691
     *
     * @return
     */
    public String CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition4(int Position) throws InterruptedException {

        thread.sleep(500);
        String DataMatchID = driver.findElement(By.xpath("//*[@class=\"results-container\"]/div/div/div/ul/li["+ Position +"]/a")).getAttribute("data-matchid");
        String EventId = DataMatchID.trim();
        log.info("Tournament Stages id or Event Id from " + Position + " position is "+ EventId + "...");
        return EventId;
    }

    /**
     *Description: Verifying In UI : Name, ID, And Start Date As Captured from API For Tournament Stages. !!!!!!!!!!!!!!!!!(GOLF)!!!!!!!!!!!!!!!!!!!
     * Sports Used : GOlf
     * Name: Handles when name Doesn't have comma / Example : European Masters
     */
    public void VerifyingInUINameWithoutCommaIDAndStartDateAsCapturedFromAPI(String SecondaryURL) throws InterruptedException, ParseException {
        ArrayList<String> ListOfTournamentStagesNames = APISportsPages.ReturnAllTournamentStagesNamesWithoutComma(SecondaryURL);
        ArrayList<String> ListOfTournamentStagesIds = APISportsPages.ReturnAllTournamentStagesIds(SecondaryURL);
        ArrayList<String> ListOfTournamentStagesDates = APISportsPages.ReturnAllTournamentStagesStartDate(SecondaryURL,"d MMMM YYYY");
        for (int i = 0; i < ListOfTournamentStagesIds.size(); i++)
        {
            try {
                CommonForAll.turnOffImplicitWaits();
                List<WebElement> ListSize = driver.findElements(By.xpath("//*[normalize-space(text())=\"" + ListOfTournamentStagesNames.get(i) + "\"]"));
                CommonForAll.turnOnImplicitWaits();
                if (ListSize.isEmpty()) {
                    CommonForAll.Click(Results);
                    Thread.sleep(500);
                    String DateforTournamentStageFromUI = driver.findElement(By.xpath("(//*[normalize-space(text())=\"" + ListOfTournamentStagesNames.get(i) + "\"]//parent::div//parent::a//preceding-sibling::a[1])/h3")).getText();
                    CommonForAll.SimpleAssert(DateforTournamentStageFromUI, ListOfTournamentStagesDates.get(i));
                    String FullHrefForTournamentStagesFromUI = driver.findElement(By.xpath("//*[normalize-space(text())=\"" + ListOfTournamentStagesNames.get(i) + "\"]//parent::div//parent::a")).getAttribute("href");
                    CommonForAll.SimpleAssertTrue(FullHrefForTournamentStagesFromUI.contains(ListOfTournamentStagesIds.get(i)));
                    log.info("Tournament Name : " +ListOfTournamentStagesNames.get(i) + " with id : " + ListOfTournamentStagesIds.get(i) + " and date : " + ListOfTournamentStagesDates.get(i) + " is present on the screen...");
                    driver.navigate().back();
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(500);
                    CommonForAll.Click(Schedule);
                    //driver.navigate().back();
                    Thread.sleep(1000);
                    String DateforTournamentStageFromUI = driver.findElement(By.xpath("(//*[normalize-space(text())=\"" + ListOfTournamentStagesNames.get(i) + "\"]//parent::div//parent::a//preceding-sibling::a[1])/h3")).getText();
                    CommonForAll.SimpleAssert(DateforTournamentStageFromUI, ListOfTournamentStagesDates.get(i));
                    String FullHrefForTournamentStagesFromUI = driver.findElement(By.xpath("//*[normalize-space(text())=\"" + ListOfTournamentStagesNames.get(i) + "\"]//parent::div//parent::a")).getAttribute("href");
                    CommonForAll.SimpleAssertTrue(FullHrefForTournamentStagesFromUI.contains(ListOfTournamentStagesIds.get(i)));
                    log.info("Tournament Name : " + ListOfTournamentStagesNames.get(i) + " with id : " + ListOfTournamentStagesIds.get(i) + " and date : " + ListOfTournamentStagesDates.get(i) + " is present on the screen...");
                }
            }
            catch(AssertionError | NoSuchElementException e)
            {
                log.info(ListOfTournamentStagesNames.get(i) + " with id : " + ListOfTournamentStagesIds.get(i) + " and date : " + ListOfTournamentStagesDates + " are not on the screen ######################################Failed######################################");
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            }

        }
    }

    /**
     *Description: Verifying In UI : Name, ID, And Start Date As Captured from API For Tournament Stages.  *******************(Tennis)******************
     * Sports Used : Tennis
     * Name: Handles when Name Has Commas / Example : Upper Austria Ladies Linz, Qualification
     */
    public void VerifyingInUINameWithCommaIDAndDateAsCapturedFromAPI(String SecondaryURL) throws InterruptedException, ParseException {
        ArrayList<String> ListOfTournamentStagesNamesAPI = APISportsPages.ReturnAllTournamentStagesNamesWithComma(SecondaryURL);
        ArrayList<String> ListOfTournamentStagesIdsAPI = APISportsPages.ReturnAllTournamentStagesIds(SecondaryURL);
        ArrayList<String> ListOfTournamentStagesDatesAPI = APISportsPages.ReturnAllTournamentStagesStartDate(SecondaryURL, "dd MMM yyyy");
        ArrayList<String> ListOfTournamentStagesEndDatesAPI = APISportsPages.ReturnAllTournamentStagesEndDate(SecondaryURL, "dd MMM yyyy");

        System.out.println("Tournament Stage Names : " +ListOfTournamentStagesNamesAPI);
        System.out.println("Tournament Stage id's : " +ListOfTournamentStagesIdsAPI);
        System.out.println("Tournament Stage Start Dates : " +ListOfTournamentStagesDatesAPI);
        System.out.println("Tournament Stage End Dates : " +ListOfTournamentStagesEndDatesAPI);
        for (int i = 0; i < ListOfTournamentStagesIdsAPI.size(); i++)

        if(ListOfTournamentStagesNamesAPI.get(i).contains("Doubles")) { //Doubles should now be present in the UI
            List<WebElement> ListSize = driver.findElements(By.xpath("//*[normalize-space(text())=\"" + ListOfTournamentStagesNamesAPI.get(i).replace("''", ",") + "\"]"));
            if (ListSize.isEmpty()) {
                CommonForAll.Click(Results);
                Thread.sleep(500);
                driver.navigate().back();
            } else {
                List<WebElement> ListSize2 = driver.findElements(By.xpath("//*[normalize-space(text())=\"" + ListOfTournamentStagesNamesAPI.get(i).replace("''", ",") + "\"]"));
                CommonForAll.SimpleAssertTrue(ListSize2.isEmpty());
                log.info("Doubles Tournament is not present in the UI...");
                Thread.sleep(500);
                CommonForAll.Click(Calendar);
                Thread.sleep(1000);
            }
        }
        else
        {
            try {
                CommonForAll.turnOffImplicitWaits();
                List<WebElement> ListSize = driver.findElements(By.xpath("//*[normalize-space(text())=\"" + ListOfTournamentStagesNamesAPI.get(i).replace("''",",") + "\"]"));
                CommonForAll.turnOnImplicitWaits();
                if (ListSize.isEmpty()) {
                    CommonForAll.Click(Results);
                    Thread.sleep(700);
                    String StartDateforTournamentStageFromUI = driver.findElement(By.xpath("//*[contains (@href, \""+ ListOfTournamentStagesIdsAPI.get(i) +"\")]//div//span[1]")).getText();
                    CommonForAll.SimpleAssert(StartDateforTournamentStageFromUI, ListOfTournamentStagesDatesAPI.get(i));

                    String EndDateforTournamentStageFromUI = driver.findElement(By.xpath("//*[contains (@href, \""+ ListOfTournamentStagesIdsAPI.get(i) +"\")]//div//span[2]")).getText().replace("-","").trim();
                    CommonForAll.SimpleAssert(EndDateforTournamentStageFromUI, ListOfTournamentStagesEndDatesAPI.get(i));

                    String FullNameOfTheTournamentFromIDInUI = driver.findElement(By.xpath("//*[contains (@href, '"+ ListOfTournamentStagesIdsAPI.get(i) +"')]//div[2]//div[2]//h2")).getText().trim();
                    CommonForAll.SimpleAssert(FullNameOfTheTournamentFromIDInUI, ListOfTournamentStagesNamesAPI.get(i).replace("''",","));
                    log.info("Tournament Name : " +ListOfTournamentStagesNamesAPI.get(i).replace("''",",") + " with id : " + ListOfTournamentStagesIdsAPI.get(i) + " with start date : " + ListOfTournamentStagesDatesAPI.get(i) + " and end date : " + ListOfTournamentStagesEndDatesAPI.get(i) + " is present on the screen...");
                    driver.navigate().back();
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(500);
                    CommonForAll.Click(Calendar);
                    //driver.navigate().back();
                    Thread.sleep(1000);
                    String StartDateforTournamentStageFromUI = driver.findElement(By.xpath("//*[contains (@href, '"+ ListOfTournamentStagesIdsAPI.get(i) +"')]//div//span[1]")).getText();
                    CommonForAll.SimpleAssert(StartDateforTournamentStageFromUI, ListOfTournamentStagesDatesAPI.get(i));
                    String FullNameOfTheTournamentFromIDInUI = driver.findElement(By.xpath("//*[contains (@href, '"+ ListOfTournamentStagesIdsAPI.get(i) +"')]//div[2]//div[2]//h2")).getText().trim();
                    CommonForAll.SimpleAssert(FullNameOfTheTournamentFromIDInUI, ListOfTournamentStagesNamesAPI.get(i).replace("''",","));
                    log.info("Tournament Name : " +ListOfTournamentStagesNamesAPI.get(i).replace("''",",") + " with id : " + ListOfTournamentStagesIdsAPI.get(i) + " with start date : " + ListOfTournamentStagesDatesAPI.get(i) + " and end date : " + ListOfTournamentStagesEndDatesAPI.get(i) + " is present on the screen...");
                }
            }
            catch(AssertionError | NoSuchElementException e)
            {
                log.info(ListOfTournamentStagesNamesAPI.get(i).replace("''",",") + " with id : " + ListOfTournamentStagesIdsAPI.get(i) + " and date : " + ListOfTournamentStagesDatesAPI + " and end date : " + ListOfTournamentStagesEndDatesAPI.get(i) + " are not on the screen ######################################Failed######################################");
                Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
            }

        }
    }

    /**
     *Description: Open an event by contains in Href
     */
    public void ClickByContainsInHref(String HrefText) throws InterruptedException {
        driver.navigate().refresh();
        thread.sleep(2000);
        log.info("Opening the Event with ID " + HrefText);
        CommonForAll.Click(By.xpath("//*[contains(@href,'"+ HrefText +"')]"));
    }

    //endregion RTE Sport Pages Golf




}


