package TestCase;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Demo5_BasicValidation_JSON {

    // 1) test status code

    @Test(priority = 1)
    public void testStatusCode() {

        given()

        .when()
              .get("http://jsonplaceholder.typicode.com/posts/3")
        .then()        //verify, validation // doğrulama ve onaylamalar
              .statusCode(200)
              .statusLine("HTTP/1.1 200 OK")
              .contentType("application/json")
              .log().all();

    }

    // 2) Log Response
    @Test(priority = 2)
    public void testLogging() {

        given()

        .when()
            .get("https://jsonplaceholder.typicode.com/users/1")
        .then()
             .statusCode(200)
             .log().all();
    }

    // 3) Verifying single content in response body
    @Test(priority = 3)
    public void testSingleContent() {

        given()

                .when()
                    .get("https://jsonplaceholder.typicode.com/users/1")  //sadece 1nci user
                .then()
                    .statusCode(200)
                    .body("address.geo.lat",equalTo("-37.3159")); //***********************
                    //http://jsonpathfinder.com/?source=post_page--------------------------- sitesinden yararlanarak yaptım.
                    // adress altında 5 eleman var. Geo yu aldım içinde 2 eleman var biri lat. lat'ı alıp doğru mu diye kontrol ettim.
    }

    // 4) Verifying Multiple content in response body
    @Test(priority = 4)
    public void testMultipleContents() {

        given()

                .when()
                .get("https://jsonplaceholder.typicode.com/users")  //all users getiriyoruz multiple control yapcaz
                .then()
                .statusCode(200)
                .body("address.geo.lat",hasItems("-37.3159","-43.9509","-68.6102")); //***********************
                //all users'a çektiğinde adress->geo-->lat için her bir user'in ayrı lat'ı var. Bunlardan birkaçını bu şekilde seçiyorsun.
                //Api'ı iyi incele ve neyi seçtğine dikkat et.
                // 3) de bir kişi için bakmıştık burada çok kişi için bakmış olduk. Ve yanına daha lat ekleyebilirsin mesela
                // burada 3 content'i verify ettik doğruladık.
    }


    // 5) Setting parameters & Headers

    @Test(priority = 5)
    public void testParamsAndHeaders() {
        // given ===  prerequites(ön koşul)
                 given()
                     .param("myName","Semih")  //key and value
                     .header("myHeader","Turkish")
                         //böylelikle parametre gönderebilirsin.
                .when()
                    .get("https://jsonplaceholder.typicode.com/users/1")  //sadece 1nci user
                .then()
                    .statusCode(200)
                    .log().all();

    }




}
