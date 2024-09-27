package api_test;

import api.pojo.WishListPOJO;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.FileUtility;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class WishListTest extends BaseApiTest {
    @DataProvider(name = "wishlistDataProvider")
    public Object[][] wishlistDataProvider() {
        return new Object[][] {
                { 62, 2 },
                { 63, 1 },
                { 64, 3 }
        };
    }
    @Test(dataProvider="wishlistDataProvider")
    public void addWishList(int productId, int quantity) {
        WishListPOJO wishList = new WishListPOJO();
        wishList.setProductId(productId);
        wishList.setQuantity(quantity);


      //  File file =new File("src/test/resources/json_schema/addToWishList_schema.json");
        given()
                .contentType(ContentType.JSON).body(wishList)
                //.auth().oauth2(bearerToken)
                .header("Authorization","Bearer " + bearerToken)

        .when()
                .post("/shoppers/137696/wishlist")
        .then()
                .log().all()

                .statusCode(201) //validate status code
                .contentType(ContentType.JSON)
                .body("message", equalTo("Created"))  // Validate success message
                .body("data.productId", equalTo(productId))  // Validate productId in the response body
                .body("data.quantity", equalTo(quantity))  // Validate quantity in the response body
               // .body("data.status", notNullValue())  // Ensure status is present and not null
               // .time(lessThan(2000L))  // Check response time is less than 2000 milliseconds
                .header("Content-Type", "application/json")  // Validate the Content-Type header
                .body(matchesJsonSchema(FileUtility.getJsonSchema("addToWishList_schema.json")));//validate json schema
    }

    @Test
    public void getAllWishList()
    {
        given()
                .header("Authorization","Bearer " + bearerToken)
        .when().get("/shoppers/137696/wishlist")
        .then().log().all();

    }
}
