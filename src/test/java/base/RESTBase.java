package base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import util.CustomCommands;

public class RESTBase extends CustomCommands{

        private static String restUrl = "https://maps.googleapis.com";
        private static String key = System.getProperty("googlePlacesKey");

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = restUrl;
    }

    public static String getGoogleKey(){
        return key;
    }
}
