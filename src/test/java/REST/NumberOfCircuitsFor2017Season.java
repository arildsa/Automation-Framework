package REST;

import base.RESTBase;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NumberOfCircuitsFor2017Season extends RESTBase {

    @Test
    public void NumberOfCircuitsFor2017SeasonTest(){
        given().
                when().
                get("/f1/2017/circuits.json").
            then().
                assertThat().
                statusCode(200).
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));

    }
}
