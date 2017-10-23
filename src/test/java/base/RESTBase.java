package base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import util.CustomCommands;

public class RESTBase extends CustomCommands{

    private static String restUrl = "http://ergast.com";

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(80);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }
        
        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/api";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = restUrl;
        }
        RestAssured.baseURI = baseHost;
    }
}
