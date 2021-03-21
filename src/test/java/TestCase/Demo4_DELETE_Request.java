package TestCase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Demo4_DELETE_Request {

    //Burası da api'den dolayı çalışmayacktır fakat mantığını anlaman yeterli,

    @Test
    public void deleteEmployeeRecord () {
        //Burada Respnse sınıfından response değişkeni içine alma işini yapacağız.
        // .extract().response(); basmazsan en son hata verecektir *****************************************************************************

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        //RestAssured.basePath = "/delete/EMPID"; EMPID kısmına bir id girmen gerekiyor
        RestAssured.basePath = "/delete/11493"; //eklinde girebilirsin yada parametrik çalışırsın farketmez.

        // bunu sildiğinde o id'li eleman DATABASE'den silinecektir.


        Response response =

        given()
         //EĞER GIVEN İÇİNDE BİR ŞEY YAZMIYORSA SİLEBİLİRSİN. FAKAT WHEN BAŞINDAKİ NOKTAYI DA SİLMEN LAZIM
        .when()
            .delete()
        .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK")
            .log().all()
            .extract().response();     // ************************** BURADA RESPONSE'U AYIKLAMAZSAN Tüm blok hatalı gözükecektir.

        //response.asString() ///Burada JSON FORMATI STRING'E çevirirsin. bunu bir değişkene atayalım tabi.
        String jsonAsstring = response.asString();
        Assert.assertEquals(jsonAsstring.contains("successfully! deleted records"),true);
        /// API den dolayı çalışmayacak ama, gelen cevabı json'dan stringe çevirdim.
        // ardından cevap stringi içinde "..." ifade içeriyor mu diye kontrol ettim. Bu da çok iyi :D



    }
}
