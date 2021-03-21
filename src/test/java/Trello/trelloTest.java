package Trello;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class trelloTest extends BaseTest{

    protected String idList;
    protected String idCard1;
    protected String idCard2;



    @Test(priority = 1)
    public void createList() {

        Response response =
            given()
                    .body(map)
                    .queryParam("name","adeList")
                    .queryParam("idBoard",boardId)
                    .contentType(ContentType.JSON)
                    .log().all().
                    when()
                    .post(Constants.getLists);
        response.then()
                .statusCode(200)
                .body("name",equalTo("adeList"));

        idList = (String) response.then()
                .extract().jsonPath().getMap("$").get("id");
        System.out.println(idList);

    }


    @Test(priority = 2)
    public void addCard() {
        Response response1 =
        given()
                .body(map)
                .queryParam("name","adeCard_1")
                .queryParam("idList",idList)
                .contentType(ContentType.JSON)
                .log().all().
                when()
                .post(Constants.createCard);

                response1.then()
                .statusCode(200);

        idCard1 = (String) response1.then()
                .extract().jsonPath().getMap("$").get("id");

        Response response2 =
        given()
                .body(map)
                .queryParam("name","adeCard_2")
                .queryParam("idList",idList)
                .contentType(ContentType.JSON)
                .log().all().
                when()
                .post(Constants.createCard);

                response2.then()
                .statusCode(200);

        idCard2 = (String) response2.then()
                .extract().jsonPath().getMap("$").get("id");


    }


    @Test(priority = 3)
    public void updateCard() {

        given()
                .pathParam("cardId",idCard1)
                .queryParam("key","ba510fa50e0070fb70e629a6526e460b")
                .queryParam("token","3286f41172d51526afe89a2dab31be4ccc760618f4ec97618be70bddc2aebd93")
                .body(Constants.changeColor)
                .contentType(ContentType.JSON)
                .log().all().
                when()
                .put(Constants.updateCard).
                then()
                .statusCode(200);
        }

    @Test(priority = 4)
    public void deleteCard() {

        given()
                .pathParam("cardId",idCard1)
                .body(map)
                .contentType(ContentType.JSON)
                .log().all().
                when()
                .delete(Constants.updateCard).
                then()
                .statusCode(200);

        given()
                .pathParam("cardId",idCard2)
                .body(map)
                .contentType(ContentType.JSON)
                .log().all().
                when()
                .delete(Constants.updateCard).
                then()
                .statusCode(200);
    }
}
