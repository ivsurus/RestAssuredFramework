package thomas_bayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

/**
 * Created by Ivan on 05.04.2017.
 */
public class CreateProductTest {

    private Map<String, String> product;

    @BeforeMethod
    public void createProduct(){
        product = new HashMap<String, String>();
        product.put("ID","1000");
        product.put("NAME","MY NAME");
        product.put("PRICE","555");
    }

    @Test
    public void addNewProduct(){
        given()
                .contentType("application/xml")
                .body(product)
                .when().post("/PRODUCT").then()
                .statusCode(200);
    }
}
