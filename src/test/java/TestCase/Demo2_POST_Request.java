package TestCase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo2_POST_Request {


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
    @Test
    public void testPost() {
        //given ile content-type ve map'i verip içeriğini vermiş olduk. When için sadece post yazdık çünkü zaten yukarıda base bilgilerini verdim.
        //then kısmında yine kontrollerimizi yaptık. Dönüş olarak 201 gelmeli "created olduğuna dair.
        //ve gelen response body loglarını kontrol ettik, doğru gelmiş mi diye.
        //hepsinin sağlanması gerektiğini belirtmek için and() annotation'unu kullanıyoruz.

        //Mehmet abinin dediği : X servisi a,b,c parametreleriyle çağırılır. Y sonucu geldiği görülür dedi. yani post gibi ama netleştir kafanda

        given()
                .contentType("application/json")
                .body(map)
        .when()
                .post("/boards")
        .then()
                .statusCode(200)
                .and()
//                .body("SuccessCode",equalTo("OPERATION_SUCCESS"))
//                .and()
//                .body("Message",equalTo("Operation completed successfully"))
                .log().all();  // test sonrası response'u basıyor :D

    }
}
