package thomas_bayer;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by Ivan_Surus on 4/4/2017.
 */
public class SetParametrizedIdTest extends BaseTest{

    @Test
    public void setParametrizedIdFirstWay(){
        given()
                .pathParam("ID", "4")
                .when()
                .get(PRODUCT+"{ID}")
                .then()
                .body(PRODUCT_NAME, containsString("Tea"));
    }

    @Test
    public void setParametrizedIdSecondWay(){
        String ID = "4";
        given()
        .when()
                .get(PRODUCT+"{ID}", ID)
        .then()
                .body(PRODUCT_NAME, containsString("Tea"));
    }



}
