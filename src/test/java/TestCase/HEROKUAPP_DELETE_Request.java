package TestCase;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HEROKUAPP_DELETE_Request {

    @Test
    public void deleteEmployeeRecord () {

        RestAssured.baseURI = "http://usersdemo.herokuapp.com";
        RestAssured.basePath = "/api/users/2"; // id=2 yi sildiriyor bu.

        // bunu sildiğinde o id'li eleman *******DATABASE********'den silinecektir.

        given()
                //EĞER GIVEN İÇİNDE BİR ŞEY YAZMIYORSA SİLEBİLİRSİN. FAKAT WHEN BAŞINDAKİ NOKTAYI DA SİLMEN LAZIM
                .when()
                .delete()
                .then()
                .statusCode(204)   //DEMO API'DA BUNU 204 VERMİŞ
                .statusLine("HTTP/1.1 204 No Content") //silmede bunu basıyor http
                .log().all();

    }
}
