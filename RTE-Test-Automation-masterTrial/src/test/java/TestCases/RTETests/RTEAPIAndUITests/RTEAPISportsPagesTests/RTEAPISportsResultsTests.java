package TestCases.RTETests.RTEAPIAndUITests.RTEAPISportsPagesTests;

import Engine.CommonForAll.CommonForAll;
import Engine.ObjectRepository.RTEIE.API.APIEndpoints;
import Engine.ObjectRepository.RTEIE.API.APISportsPages;
import Engine.ObjectRepository.RTEIE.RTEPages.*;
import Engine.ObjectRepository.TrialAPI.RTEPage;
import Engine.ObjectRepository.TrialAPI.TrialAPI;
import Engine.common.BaseTest;
import Engine.common.LoginPage;
import Engine.config.APIURLs;
import Engine.config.LocalConfig;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Raj.
 */
public class RTEAPISportsResultsTests extends BaseTest {

    private LoginPage loginPage;
    Thread thread = null;
    public TrialAPI TrialAPI;
    public APIEndpoints APIEndpoints;
    public RTEHomePage RTEHomePage;
    public RTEArchivesArticlePage RTEArchivesArticlePage;
    public RTERadioArticlePage RTERadioArticlePage;
    //public CommonForAll CommonForAll;
    public RTENewsArticlePage RTENewsArticlePage;
    private RTEPage RTEPage;
    private static final String[] APIUrlHeadlines = LocalConfig.INSTANCE.APIUrlHeadlines();
    private static final String APISportsURL = LocalConfig.INSTANCE.APISportsURL();
    private static final String RTEURL = LocalConfig.INSTANCE.RTEURL();
    private static final String RTEURLProd = LocalConfig.INSTANCE.RTEURLProd();
    private static final String RTESampleUrl = LocalConfig.INSTANCE.RTESampleUrl();
    private static final String EPICURL = LocalConfig.INSTANCE.EPICURL();
    private static final Logger log = Logger.getLogger(BaseTest.class);

    //region API Sports Results Tests

    /**
     * Description: Need to Pass Sports Name: XXXX, Year: XXXX, And tournament name : SomethingXXXXXX
     * Verify Sports Results for Tennis
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPISportsPages","OAT-4","trial"}, description = "RTE API MotorSport/Formula1 Sports Results")
    public void RTEAPIFormula1SportsResults() throws InterruptedException, AWTException, ParseException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTESportsPages RTESportsPages = new RTESportsPages(driver);
        APISportsPages APISportsPages = new APISportsPages(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APISportsURL;

        //API Section
        log.info("\n********************************************API Section : Verifying for Sports List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.SportsList(),"200");
        String SportsListID = APISportsPages.ReturnIdForASportCategory(APIURLs.INSTANCE.SportsList(),"Motorsports");
        System.out.println("SportsListID is : " + SportsListID + "...");

        log.info("\n********************************************API Section : Verifying for Tournament Templates List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentTemplatesList(SportsListID),"200");
        String TournamentTemplateListID = APISportsPages.ReturnIdForATournamentTemplate(APIURLs.INSTANCE.TournamentTemplatesList(SportsListID),"Formula 1");
        System.out.println("TournamentTemplateListID is : " + TournamentTemplateListID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament Templates Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentTemplatesParticipants(TournamentTemplateListID),"200");
        String TournamentTemplateParticipantsID = APISportsPages.ReturnIdForATournamentTemplate(APIURLs.INSTANCE.TournamentTemplatesParticipants(TournamentTemplateListID),"Formula 1");
        CommonForAll.SimpleAssert(TournamentTemplateListID,TournamentTemplateParticipantsID);
        System.out.println("TournamentTemplateParticipantsID is : " + TournamentTemplateParticipantsID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"200");
        String TournamentListID = APISportsPages.ReturnIdForATournamentName(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"2023");
        System.out.println("TournamentListID is : " + TournamentListID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentsParticipants(TournamentListID),"200");
        String TournamentParticipantsID = APISportsPages.ReturnIdForATournamentName(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"2023");
        CommonForAll.SimpleAssert(TournamentParticipantsID,TournamentListID);

        log.info("\n********************************************API Section : Verifying for Tournament Stage List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentStageList(TournamentListID),"200");

        //UI Section
        log.info("\n********************************************UI Section: Opening the Tennis Section in the UI & Verifying Schedule, ID and Date****************************************************************************");
        RTEHomePage.TopMenu("SPORT","Fixtures/Results","Formula 1","","","","","","");
        RTESportsPages.VerifyingInUINameWithCommaIDAndDateAsCapturedFromAPI(APIURLs.INSTANCE.TournamentStageList(TournamentListID));

        RTESportsPages.ClickOnResults();
        String ResultEventIDOrTournamentStagesID = RTESportsPages.CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition4(5);
        System.out.println("ResultEventIDOrTournamentStagesID is : " + ResultEventIDOrTournamentStagesID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament Stages Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),"200");
        String TourTypeValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Venue");
        System.out.println(TourTypeValueInResultEventIDOrTournamentStagesIDInAPI);

        log.info("\n********************************************UI Section: Verifying for Tournament Stage Participants(Event Details) Meta Data****************************************************************************");
        RTESportsPages.ClickByContainsInHref(ResultEventIDOrTournamentStagesID);
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(TourTypeValueInResultEventIDOrTournamentStagesIDInAPI));

        //RTESportsPages.ClickOnSchedule();
        driver.navigate().back();
        driver.navigate().back();
        String ScheduleEventIDOrTournamentStagesID = RTESportsPages.CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition4(5);
        System.out.println("ScheduleEventIDOrTournamentStagesID in Schedule Section is : " + ScheduleEventIDOrTournamentStagesID+ "...");

        //API Section
        log.info("\n********************************************API Section : Verifying for Event Fixtures****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),"200");
        String EventFixturesID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID));
        System.out.println("EventFixturesID is : " + EventFixturesID+ "...");
        String StatusValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "status_type");
        String SportsIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "sportFK");
        String TournamentNameIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_name");
        String TournamentStageNameIDValueInEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_stage_name");
        String TournamentTempelateNameIDValueInEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_template_name");
        String TournamentSportNameIDValueInEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "sport_name");

        //UI Section
        log.info("\n********************************************UI Section: Verifying the Event Fixtures Meta Data****************************************************************************");
        RTESportsPages.ClickByContainsInHref(ScheduleEventIDOrTournamentStagesID);
        CommonForAll.SimpleAssert(SportsListID,SportsIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert("2023",TournamentNameIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(TournamentStageNameIDValueInEventFixturesAPI));
        CommonForAll.SimpleAssert("Formula 1", TournamentTempelateNameIDValueInEventFixturesAPI);
        CommonForAll.SimpleAssert("Motorsports",TournamentSportNameIDValueInEventFixturesAPI);

        //API Section
        log.info("\n********************************************API Section : Verifying for Events List API for Schedule Events****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),"200");
        ArrayList<String> EventListIdsList = APISportsPages.ReturnIdListForEventFixturesAndList(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID));
        log.info("EventListIdsList is : " + EventListIdsList+ "...");
        CommonForAll.SimpleAssertTrue(EventListIdsList.contains(EventFixturesID));
        String EventListIdsListValue = EventListIdsList.get(0);
        log.info("EventListIdsListValue is : " + EventListIdsListValue+ "...Similar to EventFixturesID as it is present in EventListIdsList");
        String StatusValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "status_type");
        String SportsIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "sportFK");
        String TournamentNameIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "tournament_name");
        String TournamentStageNameIDValueInEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "tournament_stage_name");
        String TournamentTempelateNameIDValueInEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "tournament_template_name");
        String TournamentSportNameIDValueInEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "sport_name");
        String KilometersValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForEventList(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "Kilometers");
        String LapsValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForEventList(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "Laps");

        log.info("\nAsserting between API responses of Event Fixtures and Event Lists as data in both are same for Schedule Events............");
        CommonForAll.SimpleAssert(TournamentNameIDValueInScheduleEventListAPI,TournamentNameIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(StatusValueInScheduleEventListAPI,StatusValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(SportsIDValueInScheduleEventListAPI,SportsIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentStageNameIDValueInEventListAPI,TournamentStageNameIDValueInEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentTempelateNameIDValueInEventListAPI,TournamentTempelateNameIDValueInEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentSportNameIDValueInEventListAPI,TournamentSportNameIDValueInEventFixturesAPI);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Distance").replace("km",""), KilometersValueInResultEventIDOrTournamentStagesIDInAPI);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Laps"), LapsValueInResultEventIDOrTournamentStagesIDInAPI);

        log.info("\nAPI Section : Check Events List API - Capture Status for Results Events section...............");
        String ResultListID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID));
        System.out.println("ResultListID is : " + ResultListID+ "...");
        String TournamentTempelateNameValueInResultEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "tournament_template_name");
        String TournamentStageNameValueInResultEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "tournament_stage_name");
        String KilometersValueInResultEventIDOrTournamentStagesIDInAPI2 = APISportsPages.ReturnMetadataValueforNameForEventList(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "Kilometers");
        String LapsValueInResultEventIDOrTournamentStagesIDInAPI2 = APISportsPages.ReturnMetadataValueforNameForEventList(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "Laps");

        //UI Section
        log.info("\nUI Section : Check Events List API -Capture and Compare Status for Results Section in UI...............");
        RTESportsPages.ClickOnBackToAllTournaments();
        RTESportsPages.ClickOnResults();
        RTESportsPages.ClickByContainsInHref(ResultEventIDOrTournamentStagesID);
        String StatusInResultSection = RTESportsPages.CaptureTextForTournamentHeader();
        CommonForAll.SimpleAssert("Formula 1",TournamentTempelateNameValueInResultEventListAPI);
        CommonForAll.SimpleAssertTrue(StatusInResultSection.contains(TournamentStageNameValueInResultEventListAPI));
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Distance").replace("km",""), KilometersValueInResultEventIDOrTournamentStagesIDInAPI2);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Laps"), LapsValueInResultEventIDOrTournamentStagesIDInAPI2);

        //API Section
        log.info("\n********************************************API Section : Verifying for Events Results API for Results Events****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),"200");

        //UI Section
        log.info("\n********************************************UI Section : Verifying Names of all the participants in Results Section in UI from API****************************************************************************");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID);
        log.info("\n********************************************UI Section : Verifying Names and scores and tie break of all players in Result Section in UI from API****************************************************************************");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "pitstops");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "Laps");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "duration");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "points");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndRankAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "rank","Formula 1");
        //API Section
        log.info("\n********************************************API Section : Capturing Values from Event Results and comparing it with Event List API****************************************************************************");
        CommonForAll.SimpleAssert(ResultEventIDOrTournamentStagesID,APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"tournament_stageFK"));
        CommonForAll.SimpleAssert(SportsListID,APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"sportFK"));
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"tournament_stage_name")));
        CommonForAll.SimpleAssert("Formula 1",APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"tournament_template_name"));

    }

    /**
     * Description: Need to Pass Sports Name: XXXX, Year: XXXX, And tournament name : SomethingXXXXXX
     * Verify Sports Results for Tennis
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPISportsPages","OAT-3","trial"}, description = "RTE API Tennis Sports Results")
    public void RTEAPITennisSportsResults() throws InterruptedException, AWTException, ParseException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTESportsPages RTESportsPages = new RTESportsPages(driver);
        APISportsPages APISportsPages = new APISportsPages(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APISportsURL;

        //API Section
        log.info("\n********************************************API Section : Verifying for Sports List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.SportsList(),"200");
        String SportsListID = APISportsPages.ReturnIdForASportCategory(APIURLs.INSTANCE.SportsList(),"Tennis");
        System.out.println("SportsListID is : " + SportsListID + "...");

        log.info("\n********************************************API Section : Verifying for Tournament Templates List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentTemplatesList(SportsListID),"200");
        String TournamentTemplateListID = APISportsPages.ReturnIdForATournamentTemplate(APIURLs.INSTANCE.TournamentTemplatesList(SportsListID),"ATP");
        System.out.println("TournamentTemplateListID is : " + TournamentTemplateListID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament Templates Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentTemplatesParticipants(TournamentTemplateListID),"200");
        String TournamentTemplateParticipantsID = APISportsPages.ReturnIdForATournamentTemplate(APIURLs.INSTANCE.TournamentTemplatesParticipants(TournamentTemplateListID),"ATP");
        CommonForAll.SimpleAssert(TournamentTemplateListID,TournamentTemplateParticipantsID);
        System.out.println("TournamentTemplateParticipantsID is : " + TournamentTemplateParticipantsID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"200");
        String TournamentListID = APISportsPages.ReturnIdForATournamentName(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"2023");
        System.out.println("TournamentListID is : " + TournamentListID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentsParticipants(TournamentListID),"200");
        String TournamentParticipantsID = APISportsPages.ReturnIdForATournamentName(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"2023");
        CommonForAll.SimpleAssert(TournamentParticipantsID,TournamentListID);

        log.info("\n********************************************API Section : Verifying for Tournament Stage List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentStageList(TournamentListID),"200");

        //UI Section
        log.info("\n********************************************UI Section: Opening the Tennis Section in the UI & Verifying Schedule, ID and Date****************************************************************************");
        RTEHomePage.TopMenu("SPORT","Fixtures/Results","Tennis","","","","","","");
        RTESportsPages.VerifyingInUINameWithCommaIDAndDateAsCapturedFromAPI(APIURLs.INSTANCE.TournamentStageList(TournamentListID));

        RTESportsPages.ClickOnResults();
        String ResultEventIDOrTournamentStagesID = RTESportsPages.CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition2(11);
        System.out.println("ResultEventIDOrTournamentStagesID is : " + ResultEventIDOrTournamentStagesID+ "...");

        log.info("\n********************************************API Section : Verifying for Tournament Stages Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),"200");
        String TourTypeValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Tourtype");
        String TournameValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Tourname");
        String CategoryValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Category");

        log.info("\n********************************************UI Section: Verifying for Tournament Stage Participants(Event Details) Meta Data****************************************************************************");
        RTESportsPages.ClickByContainsInHref(ResultEventIDOrTournamentStagesID);
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(TourTypeValueInResultEventIDOrTournamentStagesIDInAPI.split(" ")[1]));
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(TournameValueInResultEventIDOrTournamentStagesIDInAPI));
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(CategoryValueInResultEventIDOrTournamentStagesIDInAPI.split(" ")[0]));

        //RTESportsPages.ClickOnSchedule();
        driver.navigate().back();
        driver.navigate().back();
        String ScheduleEventIDOrTournamentStagesID = RTESportsPages.CaptureTournamentStageIDOrEventIDFromDataMatchIDByPosition3(1);
        System.out.println("ScheduleEventIDOrTournamentStagesID in Schedule Section is : " + ScheduleEventIDOrTournamentStagesID+ "...");

        //API Section
        log.info("\n********************************************API Section : Verifying for Event Fixtures****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),"200");
        String EventFixturesID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID));
        System.out.println("EventFixturesID is : " + EventFixturesID+ "...");
        String StatusValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "status_type");
        String SportsIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "sportFK");
        String TournamentNameIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_name");
        String TournamentStageNameIDValueInEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_stage_name");
        String TournamentTempelateNameIDValueInEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_template_name");
        String TournamentSportNameIDValueInEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "sport_name");


        //UI Section
        log.info("\n********************************************UI Section: Verifying the Event Fixtures Meta Data****************************************************************************");
        RTESportsPages.ClickByContainsInHref(ScheduleEventIDOrTournamentStagesID);
        //CommonForAll.SimpleAssert("notstarted",StatusValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(SportsListID,SportsIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert("2023",TournamentNameIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(TournamentStageNameIDValueInEventFixturesAPI));
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(TournamentTempelateNameIDValueInEventFixturesAPI));
        CommonForAll.SimpleAssert("Tennis",TournamentSportNameIDValueInEventFixturesAPI);

        //API Section
        log.info("\n********************************************API Section : Verifying for Events List API for Schedule Events****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),"200");
        ArrayList<String> EventListIdsList = APISportsPages.ReturnIdListForEventFixturesAndList(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID));
        log.info("EventListIdsList is : " + EventListIdsList+ "...");
        CommonForAll.SimpleAssertTrue(EventListIdsList.contains(EventFixturesID));
        String EventListIdsListValue = EventListIdsList.get(1);
        log.info("EventListIdsListValue is : " + EventListIdsListValue+ "...Similar to EventFixturesID as it is present in EventListIdsList");
        String StatusValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "status_type");
        String SportsIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "sportFK");
        String TournamentNameIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "tournament_name");
        String TournamentStageNameIDValueInEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "tournament_stage_name");
        String TournamentTempelateNameIDValueInEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "tournament_template_name");
        String TournamentSportNameIDValueInEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListIdsListValue, "sport_name");

        log.info("\nAsserting between API responses of Event Fixtures and Event Lists as data in both are same for Schedule Events............");
        CommonForAll.SimpleAssert(TournamentNameIDValueInScheduleEventListAPI,TournamentNameIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(StatusValueInScheduleEventListAPI,StatusValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(SportsIDValueInScheduleEventListAPI,SportsIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentStageNameIDValueInEventListAPI,TournamentStageNameIDValueInEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentTempelateNameIDValueInEventListAPI,TournamentTempelateNameIDValueInEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentSportNameIDValueInEventListAPI,TournamentSportNameIDValueInEventFixturesAPI);

        log.info("\nAPI Section : Check Events List API - Capture Status for Results Events section...............");
        String ResultListID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID));
        System.out.println("ResultListID is : " + ResultListID+ "...");
        String TournamentTempelateNameValueInResultEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "tournament_template_name");
        String TournamentStageNameValueInResultEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "tournament_stage_name");

        //UI Section
        log.info("\nUI Section : Check Events List API -Capture and Compare Status for Results Section in UI...............");
        RTESportsPages.ClickOnBackToAllTournaments();
        RTESportsPages.ClickOnResults();
        RTESportsPages.ClickByContainsInHref(ResultEventIDOrTournamentStagesID);
        String StatusInResultSection = RTESportsPages.CaptureTextForTournamentHeader();
        CommonForAll.SimpleAssertTrue(StatusInResultSection.contains(TournamentTempelateNameValueInResultEventListAPI));
        CommonForAll.SimpleAssertTrue(StatusInResultSection.contains(TournamentStageNameValueInResultEventListAPI));

        //API Section
        log.info("\n********************************************API Section : Verifying for Events Results API for Results Events****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),"200");

        //UI Section
        log.info("\n********************************************UI Section : Verifying Names of all the participants in Results Section in UI from API****************************************************************************");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID);
        log.info("\n********************************************UI Section : Verifying Names and scores and tie break of all players in Result Section in UI from API****************************************************************************");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "runningscore");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "set1");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "set2");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "set3");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "set4");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "set5");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "setswon");
        RTESportsPages.VerifyingResultsCodeForASport(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "finalresult");

        //API Section
        log.info("\n********************************************API Section : Capturing Values from Event Results and comparing it with Event List API****************************************************************************");
        CommonForAll.SimpleAssert(ResultEventIDOrTournamentStagesID,APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"tournament_stageFK"));
        CommonForAll.SimpleAssert(SportsListID,APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"sportFK"));
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"tournament_stage_name")));
        CommonForAll.SimpleAssertTrue(RTESportsPages.CaptureTextForTournamentHeader().contains(APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID,"tournament_template_name")));

    }


    /**
     * Description: Need to Pass Sports Name: Golf, Year: 2023, And tournament name : European Tour 1
     * Verify Sports Results for Golf
     */
    @Test(groups = {"RTEAPI","RTEAll", "Smoke", "Regression", "RTEAPISportsResults","OAT-2","trial"}, description = "RTE API Golf Sports Results")
    public void RTEAPIGolfSportsResults() throws InterruptedException, AWTException, ParseException {
        APIEndpoints APIEndpoints = new APIEndpoints(driver);
        RTEArchivesArticlePage RTEArchivesArticlePage = new RTEArchivesArticlePage(driver);
        CommonForAll CommonForAll = new CommonForAll(driver);
        RTEHomePage RTEHomePage = new RTEHomePage(driver);
        RTESportsPages RTESportsPages = new RTESportsPages(driver);
        APISportsPages APISportsPages = new APISportsPages(driver);
        RTENewsArticlePage RTENewsArticlePage = new RTENewsArticlePage(driver);
        RTERadioArticlePage RTERadioArticlePage = new RTERadioArticlePage(driver);
        driver.get(RTEURLProd);
        RestAssured.baseURI = APISportsURL;
        //API Section
        log.info("********************************************API Section : Verifying for Sports List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.SportsList(),"200");
        String SportsListID = APISportsPages.ReturnIdForASportCategory(APIURLs.INSTANCE.SportsList(),"Golf");
        System.out.println("SportsListID is : " + SportsListID + "...");

        log.info("********************************************API Section : Verifying for Tournament Templates List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentTemplatesList(SportsListID),"200");
        String TournamentTemplateListID = APISportsPages.ReturnIdForATournamentTemplate(APIURLs.INSTANCE.TournamentTemplatesList(SportsListID),"European Tour 1");
        System.out.println("TournamentTemplateListID is : " + TournamentTemplateListID+ "...");

        log.info("********************************************API Section : Verifying for Tournament Templates Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentTemplatesParticipants(TournamentTemplateListID),"200");
        String TournamentTemplateParticipantsID = APISportsPages.ReturnIdForATournamentTemplate(APIURLs.INSTANCE.TournamentTemplatesParticipants(TournamentTemplateListID),"European Tour 1");
        CommonForAll.SimpleAssert(TournamentTemplateListID,TournamentTemplateParticipantsID);
        System.out.println("TournamentTemplateParticipantsID is : " + TournamentTemplateParticipantsID+ "...");

        log.info("********************************************API Section : Verifying for Tournament List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"200");
        String TournamentListID = APISportsPages.ReturnIdForATournamentName(APIURLs.INSTANCE.TournamentsList(TournamentTemplateListID),"2023");
        System.out.println("TournamentListID is : " + TournamentListID+ "...");

        log.info("********************************************API Section : Verifying for Tournament Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentsParticipants(TournamentListID),"200");

        log.info("********************************************API Section : Verifying for Tournament Stage List****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentStageList(TournamentListID),"200");

        //UI Section
        log.info("********************************************UI Section: Opening the Golf Section in the UI & Verifying Schedule, ID and Date****************************************************************************");
        RTEHomePage.TopMenu("SPORT","Fixtures/Results","Golf","","","","","","");
        RTESportsPages.ClickByContainsInHref(TournamentListID); //opening the tournament
        RTESportsPages.VerifyingInUINameWithoutCommaIDAndStartDateAsCapturedFromAPI(APIURLs.INSTANCE.TournamentStageList(TournamentListID));
        RTESportsPages.ClickOnResults();
        String ResultEventIDOrTournamentStagesID = RTESportsPages.CaptureEventIDFromHrefByPosition(4);
        System.out.println("ResultEventIDOrTournamentStagesID is : " + ResultEventIDOrTournamentStagesID+ "...");

        log.info("********************************************API Section : Verifying for Tournament Stages Participants****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),"200");
        String TypeValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Type");
        String ParValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Par");
        String VenueValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Venue");
        String PrizeValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Prize");
        String RoundsValueInResultEventIDOrTournamentStagesIDInAPI = APISportsPages.ReturnMetadataValueforNameForTournamentStagesParticipants(APIURLs.INSTANCE.TournamentStagesParticipants(ResultEventIDOrTournamentStagesID),ResultEventIDOrTournamentStagesID, "Rounds");

        log.info("********************************************UI Section: Verifying for Tournament Stage Participants(Event Details) Meta Data****************************************************************************");
        RTESportsPages.ClickByContainsInHref(ResultEventIDOrTournamentStagesID);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Game Type"),TypeValueInResultEventIDOrTournamentStagesIDInAPI);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Par"),ParValueInResultEventIDOrTournamentStagesIDInAPI);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Venue"),VenueValueInResultEventIDOrTournamentStagesIDInAPI);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Prize").replace(",","").replace("$",""),PrizeValueInResultEventIDOrTournamentStagesIDInAPI);
        CommonForAll.SimpleAssert(RTESportsPages.VerifyTotalNumberOfRoundsInGolf(RoundsValueInResultEventIDOrTournamentStagesIDInAPI),RoundsValueInResultEventIDOrTournamentStagesIDInAPI);
        //RTESportsPages.ClickOnSchedule();
        driver.navigate().back();
        driver.navigate().back();
        String ScheduleEventIDOrTournamentStagesID = RTESportsPages.CaptureEventIDFromHrefByPosition(2);
        System.out.println("ScheduleEventIDOrTournamentStagesID is : " + ScheduleEventIDOrTournamentStagesID+ "...");

        //API Section
        log.info("********************************************API Section : Verifying for Event Fixtures****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),"200");
        String EventFixturesID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID));
        System.out.println("EventFixturesID is : " + EventFixturesID+ "...");
        String TypeValueInScheduleEventFixturesAPI = APISportsPages.ReturnMetadataValueforNameForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "Type");
        String StatusValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "status_type");
        String SportsIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "sportFK");
        String TournamentTemplateIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournament_templateFK");
        String TournamentIDValueInScheduleEventFixturesAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventFixtures(ScheduleEventIDOrTournamentStagesID),EventFixturesID, "tournamentFK");

        //UI Section
        log.info("********************************************UI Section: Verifying the Event Fixtures Meta Data****************************************************************************");
        RTESportsPages.ClickByContainsInHref(ScheduleEventIDOrTournamentStagesID);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Game Type"),TypeValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(RTESportsPages.CaptureTextForMetadata("Status").replace(" ", "").toLowerCase(),StatusValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(SportsListID,SportsIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentTemplateListID,TournamentTemplateIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentListID,TournamentIDValueInScheduleEventFixturesAPI);

        //API Section
        log.info("********************************************API Section : Verifying for Events List API for Schedule Events****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),"200");
        String EventListID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID));
        System.out.println("EventListID is : " + EventListID+ "...");
        CommonForAll.SimpleAssert(EventListID,EventFixturesID);
        String TypeValueInScheduleEventListAPI = APISportsPages.ReturnMetadataValueforNameForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListID, "Type");
        String StatusValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListID, "status_type");
        String SportsIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListID, "sportFK");
        String TournamentTemplateIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListID, "tournament_templateFK");
        String TournamentIDValueInScheduleEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ScheduleEventIDOrTournamentStagesID),EventListID, "tournamentFK");

        log.info("Asserting between API responses of Event Fixtures and Event Lists as data in both are same for Schedule Events............");
        CommonForAll.SimpleAssert(EventFixturesID,EventListID);
        CommonForAll.SimpleAssert(TypeValueInScheduleEventListAPI,TypeValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(StatusValueInScheduleEventListAPI,StatusValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(SportsIDValueInScheduleEventListAPI,SportsIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentTemplateIDValueInScheduleEventListAPI,TournamentTemplateIDValueInScheduleEventFixturesAPI);
        CommonForAll.SimpleAssert(TournamentIDValueInScheduleEventListAPI,TournamentIDValueInScheduleEventFixturesAPI);

        log.info("API Section : Check Events List API - Capture Status for Results Events section...............");
        String ResultListID = APISportsPages.ReturnIdForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID));
        System.out.println("ResultListID is : " + ResultListID+ "...");
        String StatusValueInResultEventListAPI = APISportsPages.ReturnKeyValueForEventFixtures(APIURLs.INSTANCE.EventList(ResultEventIDOrTournamentStagesID),ResultListID, "status_type");
        //UI Section
        log.info("UI Section : Check Events List API -Capture and Compare Status for Results Section in UI...............");
        RTESportsPages.ClickOnBackToAllTournaments();
        RTESportsPages.ClickOnResults();
        RTESportsPages.ClickByContainsInHref(ResultEventIDOrTournamentStagesID);
        String StatusInResultSection = RTESportsPages.CaptureTextForMetadata("Status").toLowerCase();
        CommonForAll.SimpleAssertTrue(StatusInResultSection.contains(StatusValueInResultEventListAPI));

        log.info("********************************************API Section : Verifying for Events Results API for Results Events****************************************************************************");
        CommonForAll.APIURLStatusCodeCheck(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),"200");

        log.info("********************************************UI Section : Verifying Names of all the participants in Results Section in UI from API****************************************************************************");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID);
        log.info("********************************************UI Section : Verifying Names and scores of all players in Result Section in UI from API****************************************************************************");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "par");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "strokes_r1");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "strokes_r2");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "strokes_r3");
        RTESportsPages.VerifyingInResultsUISportsPersonsNamesAndScoresAsCapturedFromAPI(APIURLs.INSTANCE.EventResults(ResultEventIDOrTournamentStagesID),ResultListID, "strokes_r4");
    }

    //endregion API Endpoints

}







