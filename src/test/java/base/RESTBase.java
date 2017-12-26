package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import util.CustomCommands;

public class RESTBase extends CustomCommands{

    private static RequestSpecification spec;

    private static String restUrl;
    private static String twitterConsumerKey;
    private static String twitterConsumerSecret;
    private static String twitterToken;
    private static String twitterTokenSecret;

    @BeforeClass
    public static void setup()
    {
        restUrl = "https://api.twitter.com/1.1";
        twitterConsumerKey = System.getProperty("twitterConsumerKey");
        twitterConsumerSecret = System.getProperty("twitterConsumerSecret");
        twitterToken = System.getProperty("twitterToken");
        twitterTokenSecret = System.getProperty("twitterTokenSecret");
    }

    public static RequestSpecification requestSetup() {
        spec = new RequestSpecBuilder()
                .setBaseUri(restUrl)
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();

        return spec;
    }


    public static JsonPath convertRawToJson(Response response){
        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString);
        return jsonPath;
    }

    public static String getTwitterConsumerKey()
    {
        return twitterConsumerKey;
    }

    public static String getTwitterConsumerSecret()
    {
        return twitterConsumerSecret;
    }

    public static String getTwitterToken()
    {
        return twitterToken;
    }

    public static String getTokenkey()
    {
        return twitterTokenSecret;
    }
}
