package thomas_bayer;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class GetTimeoutExample extends BaseTest{

    @Test(dataProvider = "idProvider")
    public void
    response_time_can_be_extracted(String id) {
        long time =
                given().
                        when().
                        get(PRODUCT, id).
                        then().
                        extract().response().time();
        System.out.println(time);
        assertThat(time, greaterThan(1000L));
    }
}
