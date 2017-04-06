package testdetective;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.baseURI;



/*      Given = This is where we would specify parameters when making the API call
        When = This is where we would call the API
        Then = This is where we check that the response is as we expect*/

public class BaseTestDetective {

    final static int STATUS_CODE_CREATED = 201;
    final static int STATUS_CODE_BAD_REQUEST = 400;
    final static int STATUS_CODE_FORBIDDEN = 403;
    final static int STATUS_CODE_NOT_FOUND = 404;
    final static int STATUS_CODE_OK = 200;
    final static String USER_ID = "id";
    final static String USER_LOGIN = "login";
    final static String USER_WWW = "www";
    final static String BASE_URI = "http://localhost:8080/"; //testdetective works with JSON
    final static String USER = "user/{id}";


    @BeforeClass
    public void setUpRestAssured() {
        baseURI = BASE_URI;
    }

    @DataProvider(name = "idProvider")
    public Object[][] provider(){
        return new Object[][]{
                {new String("1")}
        };
    }
}
