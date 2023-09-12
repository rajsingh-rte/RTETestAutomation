package Engine.config;

import lombok.Getter;

@Getter
public enum APIURLs {
    INSTANCE;
    //region API End Points Secondary URLs
    private final String Author_BinderId_Binders = System.getProperty("URL") == null ? "author/1386587/binders" : System.getProperty("URL");
    private final String Author_BinderIds = System.getProperty("URL") == null ? "author/1386583/1383632" : System.getProperty("URL");
    private final String Source_BinderId_Binders = System.getProperty("URL") == null ? "source/909342/binders" : System.getProperty("URL");
    private final String Source_BinderIds = System.getProperty("URL") == null ? "source/1386613/1388050" : System.getProperty("URL");
    private final String Wire_BinderId_Binders = System.getProperty("URL") == null ? "wire/1222173/binders" : System.getProperty("URL");
    private final String Wire_BinderIds = System.getProperty("URL") == null ? "wire/1386613/1388050/1383789/1383626/" : System.getProperty("URL");
    private final String Binder_Filename_Filename_Date = System.getProperty("URL") == null ? "binder/filename/love-island-society-dating-language-gender-relationships/" : System.getProperty("URL");
    private final String Binder_Filename_Filename = System.getProperty("URL") == null ? "binder/filename/love-island-society-dating-language-gender-relationships/" : System.getProperty("URL");
    private final String Binder_BinderIds = System.getProperty("URL") == null ? "binder/1383626/1383789/" : System.getProperty("URL");
    private final String Binder_Related_Document_RDId = System.getProperty("URL") == null ? "binder/relateddocument/1351770/" : System.getProperty("URL");
    private final String Binder_Pia_PiaId = System.getProperty("URL") == null ? "binder/pia/32758" : System.getProperty("URL");
    private final String Related_Asset_RaId = System.getProperty("URL") == null ? "relatedasset/104135124/" : System.getProperty("URL");
    private final String Index_IndexIds_Binders = System.getProperty("URL") == null ? "index/3438/3866/binders/?sort=binder_id" : System.getProperty("URL");
    private final String Index_IndexIds_Binders2 = System.getProperty("URL") == null ? "index/3438/3866/binders/?sort=date_created" : System.getProperty("URL");
    private final String Index_IndexId_Extras = System.getProperty("URL") == null ? "index/3438/extras" : System.getProperty("URL");
    private final String Index_IndexId = System.getProperty("URL") == null ? "index/3438/" : System.getProperty("URL");
    private final String Index_Name_IndexName_Pillar_Pillar = System.getProperty("URL") == null ? "index/name/Brainstorm/pillar/Brainstorm/" : System.getProperty("URL");
    private final String Index_Name_IndexName_Binders = System.getProperty("URL") == null ? "index/name/Brainstorm/binders/" : System.getProperty("URL");
    private final String Index_Name_IndexName_Extras = System.getProperty("URL") == null ? "index/name/Brainstorm/extras/" : System.getProperty("URL");
    private final String Index_Name_IndexName = System.getProperty("URL") == null ? "index/name/Brainstorm/" : System.getProperty("URL");
    private final String Index_Url_IndexUrl_Binders = System.getProperty("URL") == null ? "index/url/brainstorm/binders/" : System.getProperty("URL");
    private final String Index_Url_IndexUrl_Extras = System.getProperty("URL") == null ? "index/url/brainstorm/extras/" : System.getProperty("URL");
    private final String Index_Url_IndexUrl = System.getProperty("URL") == null ? "index/url/brainstorm/" : System.getProperty("URL");
    private final String Category_Categories = System.getProperty("URL") == null ? "category/Archives" : System.getProperty("URL");
    private final String Pillar_Pillar_Category_Categories = System.getProperty("URL") == null ? "pillar/Archives/category/Archives/" : System.getProperty("URL");
    private final String Topic_Slug = System.getProperty("URL") == null ? "topic/mental-health/" : System.getProperty("URL");
    private final String Sport_Tournament_TournamentId_Name_TournamentName = System.getProperty("URL") == null ? "sport/soccer/tournament/18551/name/premier-division/" : System.getProperty("URL");
    private final String Search_Binder_Title_TitleKeywords = System.getProperty("URL") == null ? "search/binder/title/m50" : System.getProperty("URL");
    private final String Av_Clip_Clip = System.getProperty("URL") == null ? "av/clip/22271313" : System.getProperty("URL");

    //Return Values for API End Points Secondary URLs
    public String Author_BinderId_Binders(){return Author_BinderId_Binders;}
    public String Author_BinderIds(){return Author_BinderIds ;}
    public String Source_BinderId_Binders(){return Source_BinderId_Binders ;}
    public String Source_BinderIds(){return Source_BinderIds;}
    public String Wire_BinderId_Binders(){return Wire_BinderId_Binders;}
    public String Wire_BinderIds(){return Wire_BinderIds ;}
    public String Binder_Filename_Filename_Date(){return Binder_Filename_Filename_Date ;}
    public String Binder_Filename_Filename(){return Binder_Filename_Filename ;}
    public String Binder_BinderIds(){return Binder_BinderIds ;}
    public String Binder_Related_Document_RDId(){return Binder_Related_Document_RDId ;}
    public String Binder_Pia_PiaId(){return Binder_Pia_PiaId ;}
    public String Related_Asset_RaId(){return Related_Asset_RaId ;}
    public String Index_IndexIds_Binders(){return Index_IndexIds_Binders ;}
    public String Index_IndexIds_Binders2(){return  Index_IndexIds_Binders2 ;}
    public String Index_IndexId_Extras(){return Index_IndexId_Extras ;}
    public String Index_IndexId(){return Index_IndexId ;}
    public String Index_Name_IndexName_Pillar_Pillar(){return Index_Name_IndexName_Pillar_Pillar ;}
    public String Index_Name_IndexName_Binders(){return Index_Name_IndexName_Binders ;}
    public String Index_Name_IndexName_Extras(){return Index_Name_IndexName_Extras ;}
    public String Index_Name_IndexName(){return Index_Name_IndexName ;}
    public String Index_Url_IndexUrl_Binders(){return Index_Url_IndexUrl_Binders ;}
    public String Index_Url_IndexUrl_Extras(){return Index_Url_IndexUrl_Extras ;}
    public String Index_Url_IndexUrl(){return Index_Url_IndexUrl ;}
    public String Category_Categories(){return Category_Categories;}
    public String Pillar_Pillar_Category_Categories(){return Pillar_Pillar_Category_Categories ;}
    public String Topic_Slug(){return Topic_Slug ;}
    public String Sport_Tournament_TournamentId_Name_TournamentName(){return Sport_Tournament_TournamentId_Name_TournamentName ;}
    public String Search_Binder_Title_TitleKeywords(){return Search_Binder_Title_TitleKeywords ;}
    public String Av_Clip_Clip(){return Av_Clip_Clip ;}

    //endregion API End Points Secondary URLs

    //region Sports API END Points Secondary URLs
    private final String SportsList = System.getProperty("URL") == null ? "sport/list/?username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tz=Europe/Dublin" : System.getProperty("URL");
    public String SportsList(){return SportsList ;}

    public String TournamentTemplatesList(String SportFKOrID)
    {
        final String TournamentTemplatesList = System.getProperty("URL") == null ? "tournament_template/list/?sportFK="+ SportFKOrID +"&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tz=Europe/Dublin" : System.getProperty("URL");
        return TournamentTemplatesList ;
    }
    public String TournamentTemplatesParticipants(String TournamentTemplateId)
    {
        final String TournamentTemplatesParticipants = System.getProperty("URL") == null ? "tournament_template/participants/?id="+ TournamentTemplateId +"&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tz=Europe/Dublin" : System.getProperty("URL");
        return TournamentTemplatesParticipants ;
    }
    public String TournamentsList(String Tournament_TemplateFKorID)
    {
        final String TournamentsList = System.getProperty("URL") == null ? "tournament/list/?tournament_templateFK="+ Tournament_TemplateFKorID +"&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tz=Europe/Dublin" : System.getProperty("URL");
        return TournamentsList ;
    }
    public String TournamentsParticipants(String TournamentListId )
    {
        final String Tournaments = System.getProperty("URL") == null ? "tournament/participants/?id=" + TournamentListId  + "&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tz=Europe/Dublin" : System.getProperty("URL");
        return Tournaments ;
    }

    public String TournamentStageList(String TournamentFKOrId)
    {
        final String TournamentStageList = System.getProperty("URL") == null ? "tournament_stage/list/?tournamentFK="+TournamentFKOrId+"&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tz=Europe/Dublin" : System.getProperty("URL");
        return TournamentStageList ;
    }
    public String TournamentStagesParticipants(String TournamentStagesID)
    {
        final String TournamentStagesParticipants = System.getProperty("URL") == null ? "tournament_stage/participants/?id="+ TournamentStagesID +"&includeProperties=yes&includeParticipantProperties=yes&includeCountries=yes&includeCountryCodes=yes&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf" : System.getProperty("URL");
        return TournamentStagesParticipants ;
    }
    public String EventFixtures(String TournamentStagesID)
    {
        final String EventFixtures = System.getProperty("URL") == null ? "event/fixtures/?tournament_stageFK="+ TournamentStagesID +"&includeCountryCodes=yes&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf" : System.getProperty("URL");
        return EventFixtures ;
    }
    public String EventList(String TournamentStagesID)
    {
        final String EventList = System.getProperty("URL") == null ? "http://eapi.enetpulse.com/event/list/?tournament_stageFK="+ TournamentStagesID +"&username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf" : System.getProperty("URL");
        return EventList ;
    }
    public String EventResults(String TournamentStagesID)
    {
        final String EventResults = System.getProperty("URL") == null ? "event/results/?username=rteapiusr&token=d9ec729afd78472a8746c7beca202cbf&tournament_stageFK=" + TournamentStagesID : System.getProperty("URL");
        return EventResults ;
    }
    //endregion Sports API END Points Secondary URLs



}
