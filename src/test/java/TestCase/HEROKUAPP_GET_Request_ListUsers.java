package TestCase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HEROKUAPP_GET_Request_ListUsers {

        @Test
        public void getWeatherDetails() {

                     given()

                    .when()
                             .get("http://usersdemo.herokuapp.com/api/users?page=2")
                    .then()
                             .statusCode(200)
                             .statusLine("HTTP/1.1 200 OK")
                             .assertThat().body("total",equalTo(12))
                             .assertThat().body("per_page",equalTo(3))
                             .log().all();
        }
    }
