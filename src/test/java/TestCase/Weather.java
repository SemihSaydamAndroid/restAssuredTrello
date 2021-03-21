package TestCase;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Weather {

    // API CEVAP VERMİYOR FAKAT BURADAKİ LOGLAMALAR İŞİNE YARAYABİLİR.
    // response.jsonPath().getString ile response body'deki bilgileri alıyorsun. Bu bilgileri çekmen ÖNEMLİ.

    @Test
    public void testMGMApiWeather() {

        RestAssured.baseURI = "https://servis.mgm.gov.tr/";

        RequestSpecification request = RestAssured

                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));

        Response response = request

                .when()
                .get("api/tahminler/gunluk?istno=94101")

                .then()
                .statusCode(200)
                .extract().response();  ///************************

        int responseCode = response.getStatusCode();
        ResponseBody responseBody = response.getBody();

        String tarihGun1 = response.jsonPath().getString("tarihGun1");
        String enYuksekGun1 = response.jsonPath().getString("enYuksekGun1");
        String enDusukGun1 = response.jsonPath().getString("enDusukGun1");

        System.out.println(responseCode);
        System.out.println(responseBody.asString());

        System.out.println("---------------------");
        System.out.println(tarihGun1);
        System.out.println(enYuksekGun1);
        System.out.println(enDusukGun1);

        assert responseBody.asString() != null;

    }
}
