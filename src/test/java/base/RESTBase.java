package base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import util.CustomCommands;

public class RESTBase extends CustomCommands{

        protected static String restUrl = "https://maps.googleapis.com";
        protected static String key = System.getProperty("googlePlacesKey");

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = restUrl;
    }

    public static String getGoogleKey(){
        return key;
    }
}
