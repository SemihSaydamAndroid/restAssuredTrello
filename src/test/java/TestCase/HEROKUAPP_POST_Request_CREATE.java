package TestCase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;



public class HEROKUAPP_POST_Request_CREATE {

    public static HashMap map = new HashMap<>();
    @BeforeClass
    public void postdata() {
        map.put("name", RestUtils.getFirstName());
        map.put("job", RestUtils.getJob());

        RestAssured.baseURI = "http://usersdemo.herokuapp.com";
        RestAssured.basePath = "/api/users";
    }
    @Test
    public void testPost() {

                given()
                     .contentType("application/json")
                     .body(map)
                .when()
                    .post()
                .then()
                     .statusCode(201)
                     .log().all();
    }

}

