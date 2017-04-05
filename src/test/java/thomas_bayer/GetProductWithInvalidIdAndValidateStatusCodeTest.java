package thomas_bayer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Ivan on 05.04.2017.
 */

public class GetProductWithInvalidIdAndValidateStatusCodeTest extends BaseTest{

    @Test (dataProvider = "idProvider", description = "id should be invalid")
    public void getProductWithInvalidIdTest(String id) {
        given().when().get(PRODUCT, id)
                .then().statusCode(STATUS_CODE_NOT_FOUND);
    }

}
