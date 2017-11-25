package base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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

    public static JsonPath convertRawToJson(Response response){
        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString);
        return jsonPath;
    }
}
