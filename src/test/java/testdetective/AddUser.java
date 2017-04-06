package testdetective;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by Ivan_Surus on 4/6/2017.
 */
public class AddUser extends BaseTestDetective{

    //пока не работает
    /* @Test
    public void aCarGoesIntoTheGarage() {
        Map<String,String> user = new HashMap<String,String>();
        user.put(USER_ID, "2");
        user.put(USER_LOGIN, "audi");
        user.put(USER_WWW, "www.dsf.ru");
        int statusCode =
        given()
                .contentType("application/json")
                .body(user)
                .when().post(USER).then()
                .statusCode(200).extract().statusCode();

        System.out.println(statusCode);
    }*/
}
