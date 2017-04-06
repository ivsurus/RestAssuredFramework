package testdetective;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Ivan_Surus on 4/6/2017.
 */
public class GetUserAndValidateGroovyExpressionsTest extends BaseTestDetective {

   //пока не работает

    /* @Test(dataProvider = "idProvider")
    public void verifySlotsOfGarage(String id) {
       *//* given().when().get("/garage").then().
                body("info.slots",equalTo(150))
                .body("info.status",equalTo("open"));*//*

        System.out.println(get(USER, id).
                then().
                statusCode(STATUS_CODE_OK).
                contentType(ContentType.JSON).extract().body().asString());

    }*/
}
