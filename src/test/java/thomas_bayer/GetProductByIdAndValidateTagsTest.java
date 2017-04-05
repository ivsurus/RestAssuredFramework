package thomas_bayer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


public class GetProductByIdAndValidateTagsTest extends BaseTest {
    @Test(dataProvider = "idProvider", description = "id should be valid")
    public void getProductWithValidIdAndValidateTags(String id) {
        given().when().get(PRODUCT, id)
                .then()
                .statusCode(STATUS_CODE_OK).
                body(containsString("ID")).
                body(containsString("NAME")).
                body(containsString("PRICE")).
                body(containsString("PRODUCT"));
    }

    @DataProvider(name = "idProvider")
    public Object[][] provider(){
        return new Object[][]{
                {new String("4")}
        };
    }
}
