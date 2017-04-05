package thomas_bayer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;


public class GetProductByIdAndValidateValuesTest extends BaseTest {


    @DataProvider(name = "checkProductIdProvider")
    public Object[][] checkProductIdProvider() {
        return new Object[][] {
                {new Integer(4)}
        };
    }

    @Test(dataProvider = "checkProductIdProvider")
    public void checkProductID(int id)
    {
        get(PRODUCT, id).
                then().statusCode(STATUS_CODE_OK).
                body(PRODUCT_ID, equalTo(String.valueOf(id)));
    }


    @DataProvider(name = "checkProductNameProvider")
    public Object[][] checkProductNameProvider() {
        return new Object[][] {
                {new Integer(4), new String("Ice Tea Shoe")}
        };
    }

    @Test(dataProvider = "checkProductNameProvider")
    public void checkProductName(int id, String name)
    {
        get(PRODUCT, id).
                then().statusCode(STATUS_CODE_OK).
                body(PRODUCT_NAME, equalTo(name));
    }

    @DataProvider(name = "checkProductPriceProvider")
    public Object[][] checkProductPriceProvider() {
        return new Object[][] {
                {new Integer(4), new String("12.8")}
        };
    }

    @Test(dataProvider = "checkProductPriceProvider")
    public void checkProductPrice(int id, String price)
    {
        get(PRODUCT, id).
                then().statusCode(STATUS_CODE_OK).
                body(PRODUCT_PRICE, equalTo(price));
    }

}
