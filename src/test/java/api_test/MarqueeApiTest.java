package api_test;


import static io.restassured.RestAssured.*;


import utils.ApiUtility;
import api.pojo.MarqueePojoClass;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class MarqueeApiTest {
    @Test
    public void addMarquee()
    {
        MarqueePojoClass pojo =new MarqueePojoClass("Engineer","16/07/1996","ganesh@gmail.com","ganesh",10,"7760789765","Shutterfly","SDET","Gani"+ApiUtility.generateRandomNumber());

        //System.out.println(jsonBody);
        baseURI="http://localhost:8084/";
        RequestSpecification resp = given()
                .contentType(ContentType.JSON).body(ApiUtility.convertJavaToJson(pojo));
        


                resp.then().statusCode(201).log().all();
//
//        String type = resp.jsonPath().getString("statusCode");
//        System.out.println(type);
//
//        // Validate that elements[1].type is "marquee"
//

    }
}
