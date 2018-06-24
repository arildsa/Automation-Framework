package REST;

import base.RESTBase;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class twitter_home_timeline extends RESTBase {

    @Test
    @Ignore
    public void getHomeTimeLineResults(){
        given()
                .spec(requestSetup())
                    .auth().oauth(getTwitterConsumerKey(), getTwitterConsumerSecret(), getTwitterToken(),getTokenkey())
                .when()
                    .get("/statuses/home_timeline.json")
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("text[0]",equalTo("#test making a test"))
                    .body("id_str[0]",equalTo("945455974701195264"));
    }
}
