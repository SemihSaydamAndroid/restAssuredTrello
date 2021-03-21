package Trello;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BaseTest {

    public final String token = "3286f41172d51526afe89a2dab31be4ccc760618f4ec97618be70bddc2aebd93";
    public final String key = "ba510fa50e0070fb70e629a6526e460b";

    protected String boardId;
    public String boardName = "Board RestAssured";
    public JSONObject queryParam = new JSONObject();
    public static HashMap map = new HashMap<>();
    @BeforeSuite
    public void setup() {

        map.put("key","ba510fa50e0070fb70e629a6526e460b");
        map.put("token","3286f41172d51526afe89a2dab31be4ccc760618f4ec97618be70bddc2aebd93");


        RestAssured.baseURI="https://api.trello.com/1";
    }

    @BeforeClass
    public void createBoard() {
        Response response =
                given()
                        .contentType("application/json")
                        .queryParam("name","boardNameSth")
                        .body(map)
                        .log().all().
                        when()
                        .post("/boards");

        response.then()
                .statusCode(200)
                .extract().body().jsonPath().get("name").equals("ADADADAD");

        boardId = (String) response.then()
                .extract().jsonPath().getMap("$").get("id");
        System.out.println(boardId);
     }

    @AfterClass
    public void tearDown()
    {

        given()
                .body(map)
                .pathParam("id",boardId)
                .contentType(ContentType.JSON).log().all().

                when()
                .delete(Constants.deleteBoard).

                then()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }

}