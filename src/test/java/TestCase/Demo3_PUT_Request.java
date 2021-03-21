package TestCase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Demo3_PUT_Request {   ///API SIKINTILI ÇALIŞMAYACAKTIR.

    public static HashMap map = new HashMap();


    String empName = RestUtils.empName();
    String empSalary = RestUtils.empSal();
    String empAge = RestUtils.empAge();
    int emp_id = 11254;

    @BeforeClass
    public void putData() {

        map.put("name",empName);
        map.put("salary",empSalary);
        map.put("age",empAge);

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/update"+emp_id;
    }

    @Test
    public void testPUT(){
        given()
                .contentType("application/json")
                .body(map)
         .when()
                .put()
          .then()
                .statusCode(200)
                .log().all();


    }
}
