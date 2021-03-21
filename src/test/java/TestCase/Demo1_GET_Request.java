package TestCase;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Demo1_GET_Request {

    @Test
    public void getWeatherDetails() {
        given()
        .when()
            .get("http://restapi.demoqa.com/utilities/weather/city/Istanbul")
        .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .assertThat().body("City",equalTo("Istanbul"))
            .header("Content-type","application/json")
            .log().all();

    }
}
