package TestCase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.ws.Response;
import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class myFirstRestAssuredClass {
    public static HashMap map = new HashMap<>();

    @BeforeClass
    public static void testData(){
        map.put("key","ba510fa50e0070fb70e629a6526e460b");
        map.put("token","3286f41172d51526afe89a2dab31be4ccc760618f4ec97618be70bddc2aebd93");
        map.put("name","ADADADAD");
        RestAssured.baseURI="https://api.trello.com/1";
    }

    @Test
    public void getResponseBody(){

        Response response = (Response) given()
                .contentType(ContentType.JSON)
                .body(map)
                .log().all().
                        when()
                .post("/boards")
                .then().statusCode(200);

    }
}