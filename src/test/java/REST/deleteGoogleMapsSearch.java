package REST;

import base.RESTBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static util.resources.*;

public class deleteGoogleMapsSearch extends RESTBase {

    private String place_id =  null;
    private String payload = "{\n" +
            "  \"location\": {\n" +
            "    \"lat\": -33.8669710,\n" +
            "    \"lng\": 151.1958750\n" +
            "  },\n" +
            "  \"accuracy\": 50,\n" +
            "  \"name\": \"Google Shoes!\",\n" +
            "  \"phone_number\": \"(02) 9374 4000\",\n" +
            "  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\n" +
            "  \"types\": [\"shoe_store\"],\n" +
            "  \"website\": \"http://www.google.com.au/\",\n" +
            "  \"language\": \"en-AU\"\n" +
            "}";

    @Before
    public void before()
    {
        Response response = given().
            queryParam("key",getGoogleKey()).
            body(payload).
        when().
            post(postPlacesData()).
        then().
            assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("status",equalTo("OK")).
        extract().response();
        JsonPath result = convertRawToJson(response);
        place_id = result.get("place_id");
    }

    @Test
    public void deleteGoogleMapsSearchTest()
    {
        String body = "{\n" +
                "  \"place_id\": \""+ place_id + "\"\n" +
                "}";
        given().
            queryParam("key",getGoogleKey()).
            body(body).
        when().
            post(deletePlacesData()).
        then().
            assertThat().
                statusCode(200).
                body("status",equalTo("OK"));
    }
}