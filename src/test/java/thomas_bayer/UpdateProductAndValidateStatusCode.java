package thomas_bayer;



import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class UpdateProductAndValidateStatusCode extends BaseTest {

    // не работает
    @Test
    public void reserveARide()
    {
        given().contentType(ContentType.XML).
                param("NAME", "name changed").
        when().
                post("PRODUCT/44634").
        then().
                statusCode(200);
    }
}
