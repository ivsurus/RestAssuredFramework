package thomas_bayer;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.baseURI;

/**
 * Created by Ivan_Surus on 4/4/2017.
 */


/*      Given = This is where we would specify parameters when making the API call
        When = This is where we would call the API
        Then = This is where we check that the response is as we expect*/

public class BaseTest {

    final static int STATUS_CODE_CREATED = 201;
    final static int STATUS_CODE_BAD_REQUEST = 400;
    final static int STATUS_CODE_FORBIDDEN = 403;
    final static int STATUS_CODE_NOT_FOUND = 404;
    final static int STATUS_CODE_OK = 200;
    final static String PRODUCT_ID = "PRODUCT.ID";
    final static String PRODUCT_NAME = "PRODUCT.NAME";
    final static String PRODUCT_PRICE = "PRODUCT.PRICE";
    final static String BASE_URI = "http://www.thomas-bayer.com/sqlrest/";
    final static String PRODUCT = "PRODUCT/{ID}";


    @BeforeClass
    public void setUpRestAssured() {
        baseURI = BASE_URI;
    }

    @DataProvider(name = "idProvider")
    public Object[][] provider(){
        return new Object[][]{
                {new String("7")}
        };
    }
}
