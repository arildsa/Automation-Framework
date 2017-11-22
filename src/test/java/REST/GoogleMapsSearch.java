package REST;

import base.RESTBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.Matchers.equalTo;

public class GoogleMapsSearch extends RESTBase {

    @Test
    public void firstTest()
    {
        System.out.println("key is " + getGoogleKey());
        given().
            config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
            param("key",getGoogleKey()).
            param("location","-33.8670522,151.1957362").
            param("radius","500").
        when().
            get("/maps/api/place/nearbysearch/json").
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
//                body("results[0].geometry.location.lat",closeTo(BigDecimal.valueOf(-33.8688197),new BigDecimal(1e-20))).
//                body("results[0].geometry.location.lng",closeTo(BigDecimal.valueOf(151.2092955),new BigDecimal(1e-20))).
                body("results[0].name",equalTo("Sydney"));
    }
}
