package base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import util.CustomCommands;

public class RESTBase extends CustomCommands{

        public static String restUrl = "https://maps.googleapis.com";
        public static String key = System.getProperty("googlePlacesKey");

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = restUrl;
        System.out.println("key is " + key);
    }

    public static String getGoogleKey(){
        return key;
    }
}
