package Engine.ObjectRepository.RTEIE.API;

import Engine.CommonForAll.CommonForAll;
import Engine.common.BaseTest;
import Engine.common.Page;
import Engine.config.APIURLs;
import Engine.config.LocalConfig;
import io.restassured.path.json.JsonPath;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.time.Duration;
import java.util.*;

import static io.restassured.RestAssured.given;


/**
 * Created by Raj
 */
public class APISportsPages extends Page {
    public APISportsPages(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriverWait wait;
    Thread thread;
    public static CommonForAll CommonForAll = new CommonForAll(driver);
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

    //region API Sports

    /**
     * Description: Iterate through the JSon in Event Results and return Sports Persons Name and its score(as mentioned in method input) /// IDForEventResults is from method ReturnIdForEventFixtures() in RTE Sports Page
     * //ResultsneededforFromAPI : par, rank, strokes_r1, strokes_r2, strokes_r3, strokes_r4, set, running score, tiebreak1, setwon
     * Sports : Tennis & Golf
     * Example: Method returns All Player Names and their score
     * "participant": {
     * "id": "169010",
     * "name": "Dale Whitnell"}
     * result: {"result_typeFK": "36",
     * "result_code": "par",
     * "value": "3",
     */

    public ArrayList<String> ListOfAllSportsPersonsAndScoresInEventResultsAPI(String SecondaryURL, String IDForEventResults, String ResultCodeNameNeededFromAPIEventsResults) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentParticipants = js.getInt("events." + IDForEventResults + ".event_participants.size()");
        String[] SplittedJson = js.getString("events." + IDForEventResults + ".event_participants").split("\\[");
        String AllJson = js.getString("events." + IDForEventResults + ".event_participants");
        String EditedJson = AllJson.replaceAll(":\\[result_.*?\\]", ",");
        String EditedJson1 = EditedJson.replaceAll("number.*?\\]", "");
        String EditedJson2 = EditedJson1.replaceAll(", ut.*?\\]", "");
        String EditedJson3 = EditedJson2.replace("[", "");
        String EditedJson4 = EditedJson3.replace(":result:", " ");
        String EditedJson5 = EditedJson4.replace(",", "").trim().replace("] ]", "");
        String EditedJson6 = EditedJson5.trim();
        String[] FinalIDSets = EditedJson6.trim().split("]\\s\\s");

        ArrayList<String> PropertyIds = new ArrayList<String>();
        ArrayList<String> SortedIdSets = new ArrayList<String>();
        String[] SplittedId = null;
        ArrayList<String> ListOfAllPlayerNames = new ArrayList<String>();
        ArrayList<String> PlayerNameAndScore = new ArrayList<String>();

        for (int i = 0; i < FinalIDSets.length; i++) {
            PropertyIds.add(Arrays.toString(FinalIDSets[i].split(" "))); //[15675504, 65617408, 65668629, 65680429, 65712178, 65617774, 65635909, 65572579], [15700590, 65628292, 65628293, 65628291, 65662857, 65641894],
        }
        log.info("Fetching Player name and score for "+ ResultCodeNameNeededFromAPIEventsResults +" from API.......");
        for (int i = 0; i < FinalIDSets.length; i++) {
            String PropIds = Arrays.toString((new String[]{PropertyIds.get(i).replace("]","").replace(" ","").replace("[","")})); // [[15675504, 65617408, 65668629, 65680429, 65712178, 65617774, 65635909, 65572579]
            String[] test = PropIds.split(","); //15675504,65617408,65668629,65680429,65712178,65617774,65635909,65572579
            for(int j = 1; j < test.length; j++) {
                String EventParticipantForThisInstance = test[0].replace("[","").replace("]","");
                String ResultIdsForThisInstance = test[j].replace("]","").replace("[","");
                String ResultOutput = js.getJsonObject("events." + IDForEventResults + ".event_participants." + EventParticipantForThisInstance + ".result." + ResultIdsForThisInstance + ".result_code");
                if(ResultOutput.equalsIgnoreCase(ResultCodeNameNeededFromAPIEventsResults))
                {
                    String PropertyIDForTheInstance = (test[0].replace("[[","").replace("]]","").replace("]","")); //15675504
                    String ParIDForTheInstance = (test[j].replace("[[","").replace("]]","").replace("]",""));
                    PlayerNameAndScore.add(js.getString("events." + IDForEventResults + ".event_participants."+ EventParticipantForThisInstance + ".participant.name"));
                    PlayerNameAndScore.add(js.getString("events." + IDForEventResults + ".event_participants."+ EventParticipantForThisInstance + ".result."+ ResultIdsForThisInstance +".value"));
                }
            }
        }
        log.info("Player Name and Score for "+ ResultCodeNameNeededFromAPIEventsResults +" is : "+PlayerNameAndScore);
        return PlayerNameAndScore;

    }

    /**
     * Description: Iterate through the JSon in Event Results and return Sports Persons Name /// IDForEventResults is from method ReturnIdForEventFixtures()
     * Example: Method returns All Player Names
     * "participant": {
     * "id": "169010",
     * "name": "Dale Whitnell",
     */

    public ArrayList<String> ListOfAllSportsPersonsNamesInEventResults(String SecondaryURL, String IDForEventResults) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentParticipants = js.getInt("events." + IDForEventResults + ".event_participants.size()");
        String[] SplittedJson = js.getString("events." + IDForEventResults + ".event_participants").split("\\[");
        String AllJson = js.getString("events." + IDForEventResults + ".event_participants");
        String EditedJson = AllJson.replaceAll(":\\[result_.*?\\]", ",");
        String EditedJson1 = EditedJson.replaceAll("number.*?\\]", "");
        String EditedJson2 = EditedJson1.replaceAll(", ut.*?\\]", "");
        String EditedJson3 = EditedJson2.replace("[", "");
        String EditedJson4 = EditedJson3.replace(":result:", " ");
        String EditedJson5 = EditedJson4.replace(",", "").trim();
        String EditedJson6 = EditedJson5.trim();
        String[] FinalIDSets = EditedJson6.trim().split("]\\s\\s");

       System.out.println("No Of Tournament Participants are : " + FinalIDSets.length);

        ArrayList<String> PropertyIds = new ArrayList<String>();
        ArrayList<String> FinalPropertyIds2 = new ArrayList<String>();
        String[] SplittedId = null;

        for (int i = 0; i < FinalIDSets.length; i++) {
            PropertyIds.add(Arrays.toString(FinalIDSets[i].split(" ")));
        }
        for (int i = 0; i < FinalIDSets.length; i++) {
            String PropIds = Arrays.toString((new String[]{PropertyIds.get(i)})); // [[15675504, 65617408, 65668629, 65680429, 65712178, 65617774, 65635909, 65572579]
            String[] test = PropIds.split(", "); //15675504, 65617408, 65668629, 65680429, 65712178, 65617774, 65635909, 65572579
            FinalPropertyIds2.add(test[0].replace("[[","")); //15675504
        }
        log.info("List of all EventParticipants ID in API : " + FinalPropertyIds2);
        ArrayList<String> ListOfAllPlayerNames = new ArrayList<String>();
        for (int i = 0; i < FinalPropertyIds2.size(); i++) {
            ListOfAllPlayerNames.add(js.getString("events." + IDForEventResults + ".event_participants."+ FinalPropertyIds2.get(i) + ".participant.name"));
        }
        log.info("List of all Players Present in API : " + ListOfAllPlayerNames);
        return ListOfAllPlayerNames;
    }

    /**
     * Description: Iterate through the JSon in Event Fixtures to get key : value
     * Here "IDForEventFixtures" is coming from method ReturnIdForEventFixtures And/or Event Results
     */

    public String ReturnKeyValueForEventFixtures(String SecondaryURL, String IDForEventFixtures, String KeyName) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        String KeyValue = js.getString("events." + IDForEventFixtures + "." + KeyName);
        log.info("Value for the metadata " + KeyName + " in API in Event Fixtures is : " + KeyValue + "...");
        return KeyValue;
    }

    /**
     * Description: Iterate through the JSon in Event Fixtures to get value for a name
     * Example: Method returns 70 if Par is given as an input
     * "tournament_stages": {
     * "881937":  { "property": { "59342476": {
     * "id": "59342476",
     * "type": "metadata",
     * "name": "Par",
     * "value": "70"
     * }
     */

    public String ReturnMetadataValueforNameForEventFixtures(String SecondaryURL, String IDForEventFixtures, String metadatanameNeeded) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfEventDetails = js.getInt("events." + IDForEventFixtures + ".property.size()");;
        String[] SplittedJson = js.getString("events." + IDForEventFixtures + ".property").split("\\[");
        //log.info("No of Event Metadata found : "+ NoOfEventDetails);
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();
        for (int i = 1; i <= NoOfEventDetails; i++) {
            String test = SplittedJson[i];
            if (test.length() < 10) {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 9).replace(":", "").replace(" ", ""));
            } else {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 9).replace(":", "").replace(" ", ""));
            }
        }
        ArrayList<String> AllTournamentStagesNames = new ArrayList<String>();
        String ValueForMetadataName = null;
        for (int i = 0; i < NoOfEventDetails; i++) {
            String MetaDataNameinAPI = js.get("events." + IDForEventFixtures + ".property." + ListOfTournamentStagesIds.get(i) + ".name");
            if (MetaDataNameinAPI.equalsIgnoreCase(metadatanameNeeded)) {
                ValueForMetadataName = js.get("events." + IDForEventFixtures + ".property." + ListOfTournamentStagesIds.get(i) + ".value");
                log.info("Value for the metadata " + metadatanameNeeded + " in API in Event Fixtures is : " + ValueForMetadataName + "...");
                break;
            }
        }
        return ValueForMetadataName;
    }

    /**
     * Description: Return ID for Event Fixtures, Event List & Event Results
     * Example: Method returns 4059139 for Event Fixtures
     * "events": {
     *         "4059139": {
     *             "id": "4059139",
     *            }
     */

    public String ReturnIdForEventFixtures(String SecondaryURL) throws InterruptedException, ParseException {
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        String SplittedJson = js.getString("events");
        String[] abc = SplittedJson.split("\\[");
        String IDforEventsFixtures = abc[1].replace(":","").replace(" ","");
        log.info("Id for events fixtures is : " + IDforEventsFixtures );
        return IDforEventsFixtures;
    }

    public ArrayList<String> ReturnIdListForEventFixturesAndList(String SecondaryURL) throws InterruptedException, ParseException {
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        String SplittedJson = js.getString("events");
        //System.out.println("Split Json : " + SplittedJson );
        String abc = SplittedJson.replaceAll(":\\[.*?\\]", ",,,,");
        String abc2 = abc.replaceAll(",,,,,.*?\\],", ",,,,");
        String abc3 = abc2.replaceAll(",,,,.*?\\]", ",,,,");
        String abc4 = abc3.replaceAll(",,,,,", "");
        String abc5 = abc4.replaceAll(",,,,", "");
        String abc6 = abc5.replaceAll("\\[", "");
        String abc7 = abc6.replaceAll("\\]", "");
        String[] abc8 = abc7.split(" ");

        ArrayList<String> EventFixtureIdsList = new ArrayList<String>();
        for (int i = 0; i < abc8.length; i++) {
            EventFixtureIdsList.add(abc8[i]);
        }
        log.info("List of Id's Events Fixtures or Event List is : " + EventFixtureIdsList );
        return EventFixtureIdsList;
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages Participant or Event Details to get value for a name
     * Example: Method returns 70 if Par is given as an input
     * "events": {
     * "881937":  { "property": { "59342476": {
     * "id": "59342476",
     * "type": "metadata",
     * "name": "Par",
     * "value": "70"
     * }
     */

    public String ReturnMetadataValueforNameForEventList(String SecondaryURL, String EventDetailsOrTournamentStagesParticipantID, String metadatanameNeeded) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfEventDetails = js.getInt("events." + EventDetailsOrTournamentStagesParticipantID + ".property.size()");;
        String[] SplittedJson = js.getString("events." + EventDetailsOrTournamentStagesParticipantID + ".property").split("\\[");
        //log.info("No of Event Metadata found : "+ NoOfEventDetails);
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();
        for (int i = 1; i <= NoOfEventDetails; i++) {
            String test = SplittedJson[i];
            if (test.length() < 10) {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 9).replace(":", "").replace(" ", ""));
            } else {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 9).replace(":", "").replace(" ", ""));
            }
        }
        ArrayList<String> AllTournamentStagesNames = new ArrayList<String>();
        String ValueForMetadataName = null;
        for (int i = 0; i < NoOfEventDetails; i++) {
            String MetaDataNameinAPI = js.get("events." + EventDetailsOrTournamentStagesParticipantID + ".property." + ListOfTournamentStagesIds.get(i) + ".name");
            if (MetaDataNameinAPI.equalsIgnoreCase(metadatanameNeeded)) {
                ValueForMetadataName = js.get("events." + EventDetailsOrTournamentStagesParticipantID + ".property." + ListOfTournamentStagesIds.get(i) + ".value");
                log.info("Value for the metadata " + metadatanameNeeded + " in API in Tournament Stage participants is : " + ValueForMetadataName + "...");
                break;
            }
        }
        return ValueForMetadataName;
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages Participant or Event Details to get value for a name
     * Example: Method returns 70 if Par is given as an input
     * "tournament_stages": {
     * "881937":  { "property": { "59342476": {
     * "id": "59342476",
     * "type": "metadata",
     * "name": "Par",
     * "value": "70"
     * }
     */

    public String ReturnMetadataValueforNameForTournamentStagesParticipants(String SecondaryURL, String EventDetailsOrTournamentStagesParticipantID, String metadatanameNeeded) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfEventDetails = js.getInt("tournament_stages." + EventDetailsOrTournamentStagesParticipantID + ".property.size()");;
        String[] SplittedJson = js.getString("tournament_stages." + EventDetailsOrTournamentStagesParticipantID + ".property").split("\\[");
        //log.info("No of Event Metadata found : "+ NoOfEventDetails);
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();
        for (int i = 1; i <= NoOfEventDetails; i++) {
            String test = SplittedJson[i];
            if (test.length() < 10) {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 9).replace(":", "").replace(" ", ""));
            } else {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 9).replace(":", "").replace(" ", ""));
            }
        }
        ArrayList<String> AllTournamentStagesNames = new ArrayList<String>();
        String ValueForMetadataName = null;
        for (int i = 0; i < NoOfEventDetails; i++) {
            String MetaDataNameinAPI = js.get("tournament_stages." + EventDetailsOrTournamentStagesParticipantID + ".property." + ListOfTournamentStagesIds.get(i) + ".name");
            if (MetaDataNameinAPI.equalsIgnoreCase(metadatanameNeeded)) {
                ValueForMetadataName = js.get("tournament_stages." + EventDetailsOrTournamentStagesParticipantID + ".property." + ListOfTournamentStagesIds.get(i) + ".value");
                log.info("Value for the metadata " + metadatanameNeeded + " in API in Tournament Stage participants is : " + ValueForMetadataName + "...");
                break;
            }
        }
        return ValueForMetadataName;
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages to get all Tournament Name """"""""""""""GOLF"""""""""""""""""""
     * Name is retrived if it doesnt have commas.
     * Example: Method returns tournament Name
     * "tournament_stages": {
     * "881359": {
     * "id": "881359",
     * "name": "Joburg Open",
     * "tournamentFK": "18283",
     * "startdate": "2022-11-24T04:20:00+00:00",
     * },
     */

    public ArrayList<String> ReturnAllTournamentStagesNamesWithoutComma(String SecondaryURL) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentsStages = js.getInt("tournament_stages.size()");
        String[] SplittedJson = js.getString("tournament_stages").split("\\[");
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournamentsStages; i++)
        {
            String test = SplittedJson[i];
            if(test.length()<10)
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
        }
        ArrayList<String> AllTournamentStagesNames = new ArrayList<String>();
        for (int i = 0; i < NoOfTournamentsStages; i++)
        {
            AllTournamentStagesNames.add(js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".name"));
        }
        return AllTournamentStagesNames;
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages to get all Tournament Name """"""""""""""Tennis"""""""""""""""""""
     * Name is retrived if it has commas.
     * // Returns "," in the name with '' // So Cordoba Open, Qualification is returned as Cordoba Open'' Qualification
     * Example: Method returns tournament Name : Adelaide International 1' Qualification
     * "tournament_stages": {
     *      "882353": {
     *             "id": "882353",
     *             "name": "Adelaide International 1, Qualification",
     *          },
     */

    public ArrayList<String> ReturnAllTournamentStagesNamesWithComma(String SecondaryURL) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentsStages = js.getInt("tournament_stages.size()");
        String[] SplittedJson = js.getString("tournament_stages").split("\\[");
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournamentsStages; i++)
        {

            String test = SplittedJson[i];
            if(test.length()<10)
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
        }

        ArrayList<String> AllTournamentStagesNames = new ArrayList<String>();
        for (int i = 0; i < NoOfTournamentsStages; i++)
        {
            AllTournamentStagesNames.add(js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".name").replace(",","''"));
        }
        return AllTournamentStagesNames; // Returns "," in the name with '' // So Cordoba Open, Qualification is returned as Cordoba Open' Qualification
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages to get Tournament ID's
     ** Example: Method returns tournament id For a given URL
     * "tournament_stages": {
     * "881359": {
     * "id": "881359",
     * "name": "Joburg Open",
     * "tournamentFK": "18283",
     * "startdate": "2022-11-24T04:20:00+00:00",
     * },
     */

    public ArrayList<String> ReturnAllTournamentStagesIds(String SecondaryURL) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentsStages = js.getInt("tournament_stages.size()");
        String[] SplittedJson = js.getString("tournament_stages").split("\\[");
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournamentsStages; i++)
        {
            String test = SplittedJson[i];
            if(test.length()<10)
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
        }
        return ListOfTournamentStagesIds;
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages to get start Date from Tournament Stages
     * Example: Method returns StartDate
     * "tournament_stages": {
     * "881359": {
     * "id": "881359",
     * "name": "Joburg Open",
     * "tournamentFK": "18283",
     * "startdate": "2022-11-24T04:20:00+00:00",
     * },
     */

    public ArrayList<String> ReturnAllTournamentStagesStartDate(String SecondaryURL, String DateFormatNeededFromAPI) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentsStages = js.getInt("tournament_stages.size()");
        String[] SplittedJson = js.getString("tournament_stages").split("\\[");
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournamentsStages; i++)
        {
            String test = SplittedJson[i];
            if(test.length()<10)
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
        }
        ArrayList<String> AllTournamentStagesStartDates = new ArrayList<String>();
        for (int i = 0; i < NoOfTournamentsStages; i++)
        {
            //AllTournamentStagesStartDates.add((js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate").substring(0,10)));
            AllTournamentStagesStartDates.add(CommonForAll.DateFormatConverter(js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate").substring(0,10),DateFormatNeededFromAPI));
            //System.out.println("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate : - " + js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate"));
        }
        return AllTournamentStagesStartDates;
    }

    /**
     * Description: Iterate through the JSon in Tournament Stages to get END Date from Tournament Stages (Tennis)
     * Example: Method returns EndDate
     * "tournament_stages": {
     * "881359": {
     * "id": "881359",
     * "name": "Joburg Open",
     * "tournamentFK": "18283",
     * "enddate": "2023-01-01T22:59:59+00:00",
     * },
     */

    public ArrayList<String> ReturnAllTournamentStagesEndDate(String SecondaryURL, String DateFormatNeededFromAPI) throws InterruptedException, ParseException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentsStages = js.getInt("tournament_stages.size()");
        String[] SplittedJson = js.getString("tournament_stages").split("\\[");
        ArrayList<String> ListOfTournamentStagesIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournamentsStages; i++)
        {
            String test = SplittedJson[i];
            if(test.length()<10)
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentStagesIds.add(test.substring(test.length() - 7).replace(":", "").replace(" ", ""));
            }
        }
        ArrayList<String> AllTournamentStagesEndDates = new ArrayList<String>();
        for (int i = 0; i < NoOfTournamentsStages; i++)
        {
            //AllTournamentStagesStartDates.add((js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate").substring(0,10)));
            AllTournamentStagesEndDates.add(CommonForAll.DateFormatConverter(js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".enddate").substring(0,10),DateFormatNeededFromAPI));
            //System.out.println("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate : - " + js.getString("tournament_stages." + ListOfTournamentStagesIds.get(i) + ".startdate"));
        }
        return AllTournamentStagesEndDates;
    }


    /**
     * Description: Iterate through the JSon in Tournament to find Id for a tournament name
     * Example: Method returns tournament Id For a given tournament name. (First it will take count of total tournaments and parse through Json and then get the tournament id)
     * If name is given as 2023 it will return 18283
     *   "tournaments":{
     *  "18283": {"id": "18283",
     *          "name": "2023",
     *         }}
     */

    public String ReturnIdForATournamentName(String SecondaryURL, String TournamentNameInJson) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournaments = js.getInt("tournaments.size()");
        String[] SplittedJson = js.getString("tournaments").split("\\[");
        ArrayList<String> ListOfTournamentIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournaments; i++)
        {
            String test = SplittedJson[i];
            if(test.length()<7)
            {
                ListOfTournamentIds.add(test.substring(test.length() - 5).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentIds.add(test.substring(test.length() - 6).replace(":", "").replace(" ", ""));
            }
        }
        String IdForTheTournamentName = null;
        for (int i = 0; i < NoOfTournaments; i++)
        {
            String AllTournamentName = js.get("tournaments." + ListOfTournamentIds.get(i) + ".name");
            if (AllTournamentName.equalsIgnoreCase(TournamentNameInJson))
            {
                IdForTheTournamentName = js.get("tournaments." + ListOfTournamentIds.get(i) + ".id");
                log.info("Id For The " + TournamentNameInJson + " is : " + IdForTheTournamentName + "...");
                break;
            }
        }
        return IdForTheTournamentName;
    }

    /**
     * Description: Iterate through the JSon to find Id for a tournament
     * Example: Method returns tournament Id For a given tournament template. (First it will take count of total tournament template and parse through Json and then get the tournament id)
     * If name is given as PGA tour 1 it will return 431
     *  tournament_templates : {"431": {"id": "431",
     *          "name": "PGA Tour 1",
     *         }}
     */
    public String ReturnIdForATournamentTemplate(String SecondaryURL, String TournamentTemplateNameInJson) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfTournamentsTemplates = js.getInt("tournament_templates.size()");
        String[] SplittedJson = js.getString("tournament_templates").split("\\[");
        ArrayList<String> ListOfTournamentTemplateIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfTournamentsTemplates; i++)
        {
            String test = SplittedJson[i];
            if(test.length()>6)
            {
                ListOfTournamentTemplateIds.add(test.substring(test.length() - 5).replace(":", "").replace(" ", ""));
            }
            else
            {
                ListOfTournamentTemplateIds.add(test.substring(test.length() - 4).replace(":", "").replace(" ", ""));
            }
        }
        String IdForTheTournamentTemplate = null;
        for (int i = 0; i < NoOfTournamentsTemplates; i++)
        {
            String AllTournamentTemplatesName = js.get("tournament_templates." + ListOfTournamentTemplateIds.get(i) + ".name");
            if (AllTournamentTemplatesName.equalsIgnoreCase(TournamentTemplateNameInJson))
            {
                IdForTheTournamentTemplate = js.get("tournament_templates." + ListOfTournamentTemplateIds.get(i) + ".id");
                log.info("Id For The Tournament Tempelate " + TournamentTemplateNameInJson + " is : " + IdForTheTournamentTemplate + "...");
                break;
            }
        }
        return IdForTheTournamentTemplate;
    }

    /**
     * Description: Iterate through the JSon to find Id for a sports
     * Example: Method returns Sports Id For a given sports name. (First it will take count of total sports and parse through Json and then get the sports id)
     * If name is given as Tennis it will return 2
     * sports : {"2": { "id": "2",
     * "name": "Tennis",
     * }}
     */
    public String ReturnIdForASportCategory(String SecondaryURL, String SportsName) throws InterruptedException {
        //API Section
        JsonPath js = CommonForAll.ParsingJSON(SecondaryURL);
        int NoOfSports = js.getInt("sports.size()");
        String[] SplittedJson = js.getString("sports").split("\\[");
        ArrayList<String> ListOfSportsIds = new ArrayList<String>();

        for (int i = 1; i <= NoOfSports; i++)
        {
            String test = SplittedJson[i];
            ListOfSportsIds.add(test.substring(test.length() - 3).replace(":", "").replace(" ", ""));
        }
        String IdForTheSport = null;

        for (int i = 0; i < NoOfSports; i++)
        {
            String AllSportName = js.get("sports." + ListOfSportsIds.get(i) + ".name");
            if (AllSportName.equalsIgnoreCase(SportsName))
            {
                IdForTheSport = js.get("sports." + ListOfSportsIds.get(i) + ".id");
                log.info("Id For The " + SportsName + " is : " + IdForTheSport + "...");
                break;
            }
        }
        return IdForTheSport;
    }

    //endregion API Sports
}





