package thomas_bayer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DelProductAndValidateStatusCodeTest extends BaseTest {

    @Test(dataProvider = "idProvider", description = "id should be valid")
    public void delProductWithValidIdAndValidateStatusCode(String id) {
        given().when().delete(PRODUCT, id)
                .then()
                .statusCode(STATUS_CODE_OK);
        given().when().get(PRODUCT, id)
                .then()
                .statusCode(STATUS_CODE_NOT_FOUND);
    }

    @DataProvider(name = "idProvider")
    public Object[][] provider(){
        return new Object[][]{
                {new String("4")}
        };
    }
}
