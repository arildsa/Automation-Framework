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
    private static String consumerKey;
    private static String consumerSecret;
    private static String token;
    private static String tokenSecret;

    @BeforeClass
    public static void setup()
    {
        restUrl = "https://api.twitter.com/1.1";
        consumerKey = System.getProperty("consumerKey");
        consumerSecret = System.getProperty("consumerSecret");
        token = System.getProperty("token");
        tokenSecret = System.getProperty("tokenSecret");
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

    public static String getConsumerKey()
    {
        return consumerKey;
    }

    public static String getConsumerSecret()
    {
        return consumerSecret;
    }

    public static String getToken()
    {
        return token;
    }

    public static String getTokenkey()
    {
        return tokenSecret;
    }
}
