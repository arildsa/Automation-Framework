package REST;

import base.RESTBase;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getGoogleMapsSearch extends RESTBase {

    @Test
    public void getGoogleMapsSearch()
    {
        given().
            param("key",getGoogleKey()).
            param("location","-33.8670522,151.1957362").
            param("radius","500").
        when().
            get("/maps/api/place/nearbysearch/json").
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("results[0].name",equalTo("Sydney")).
                body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).
                header("server",equalTo("pablo"));
    }
}
