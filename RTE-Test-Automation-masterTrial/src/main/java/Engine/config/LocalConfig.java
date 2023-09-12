package Engine.config;

import lombok.Getter;

@Getter
public enum LocalConfig {
    INSTANCE;

    //Browser
    public final String browser = System.getProperty("BROWSER") == null ? "chrome" : System.getProperty("BROWSER");

    //APIENDPointsURL
    private final String APIEndPointURL = System.getProperty("URL") == null ? "https://preview.rte.ie/api/v2" : System.getProperty("URL");
    //private final String APIEndPointV1URLBeta = System.getProperty("URL") == null ? "https://beta.rte.ie/api/v1" : System.getProperty("URL");

    //API Sports URLS
    private final String APISportsURL = System.getProperty("URL") == null ? "https://eapi.enetpulse.com" : System.getProperty("URL");

    //RTE URL's
    private final String RTEURL = System.getProperty("URL") == null ? "https://www.rte.ie" : System.getProperty("URL");
    private final String RTEURLProd = System.getProperty("URL") == null ? "https://www.rte.ie/" : System.getProperty("URL");
    //private final String RTEBeta = System.getProperty("URL") == null ? "https://beta.rte.ie " : System.getProperty("URL");
    
    //EPIC URLs
    private final String EPICURL = System.getProperty("URL") == null ? "https://epic.rtegroup.ie/epic/i/?indexDefinitionId=-1&" : System.getProperty("URL");

    //Sapmle URLs
    private final String APIURL1Headlines = System.getProperty("URL") == null ? "https://www.rte.ie" : System.getProperty("URL");
    private final String APIURL2Headlines = System.getProperty("URL") == null ? "newsapi/list/?rows=39&category=news" : System.getProperty("URL");
    private final String RTESample = System.getProperty("URL") == null ? "https://www.rte.ie/news/headlines/ " : System.getProperty("URL");
    private final String ANZUrl = System.getProperty("URL") == null ? "https://core.collate.apps.os4tstemp.rockallos4internal.com/" : System.getProperty("URL");

    //APIS Return
    public String APIEndPointURL() {
        return APIEndPointURL ;
    }
    public String APISportsURL() {
        return APISportsURL ;
    }

    //Generic Return
    public String RTEURL() { return RTEURL;}
    public String RTEURLProd() {return RTEURLProd;}

    public String EPICURL() {
        return EPICURL ;
    }
    public String getBrowser() { return browser;}
    public String ANZUrl() {
        return ANZUrl;
    }
    public String[] APIUrlHeadlines() { String[] APIUrl = {APIURL1Headlines,APIURL2Headlines }; return APIUrl ;}
    public String RTESampleUrl() {
        return RTESample ;
    }


}
