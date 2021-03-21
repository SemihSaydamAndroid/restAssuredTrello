package TestCase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo2_POST_Request {

    protected String boardId;

    // yeni bir kullanıcı ekleyeceğiz post ile

    public static HashMap map = new HashMap<>();
    @BeforeClass
    public void postdata() {
//        map.put("FirstName",RestUtils.getFirstName());
//        map.put("LastName",RestUtils.getLastName());
//        map.put("UserName",RestUtils.getUserName());
//        map.put("Password",RestUtils.getPassword());
//        map.put("Email", RestUtils.getEmail());
//
//        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
//        RestAssured.basePath = "/register";
        map.put("key","ba510fa50e0070fb70e629a6526e460b");
        map.put("token","3286f41172d51526afe89a2dab31be4ccc760618f4ec97618be70bddc2aebd93");
        map.put("name","ADADADAD");
        RestAssured.baseURI="https://api.trello.com/1";

    }
    @Test(priority = 1)
    public void testPost() {
        Response response =
                given()
                        .contentType("application/json")
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

    @Test(priority = 2)
    public void createList() {
        System.out.println("board id : " + boardId);
        Response response =
                given()
                        .contentType("application/json")
                        .body(map)
                        .log().all().
                        when()
                        .post("/boards/"+boardId);

        response.then()
                .statusCode(200);
    }
}
