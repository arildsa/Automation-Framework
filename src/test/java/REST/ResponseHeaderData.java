package REST;

import base.RESTBase;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseHeaderData extends RESTBase {

    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {

        given().
                when().
//                get(getRestUrl() + "/api/f1/2017/circuits.json").
                get("/f1/2017/circuits.json").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("Content-Length",equalTo("4551"));
    }
}
