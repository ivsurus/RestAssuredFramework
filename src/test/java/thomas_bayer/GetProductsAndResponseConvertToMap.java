package thomas_bayer;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.from;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by Ivan_Surus on 4/6/2017.
 */
public class GetProductsAndResponseConvertToMap extends BaseTest {

   //пока не работает

    /* @Test(dataProvider = "idProvider", description = "id should be valid")
    public void getProductWithValidIdAndValidateTags(String id) {
        Response response =
        given().when().get("PRODUCT/")
                .then()
                .statusCode(STATUS_CODE_OK).contentType(ContentType.XML).extract().response();

        String xmlAsString = response.asString();
        System.out.println(xmlAsString);
     //   HashMap<String,?> xmlAsHashMap = from(xmlAsString).get("");
    }*/

}
