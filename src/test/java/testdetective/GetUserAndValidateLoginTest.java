package testdetective;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;


public class GetUserAndValidateLoginTest extends BaseTestDetective {



    @DataProvider(name = "checkUserLoginProvider")
    public Object[][] checkUserLoginProvider() {
        return new Object[][] {
                {new Integer(1), new String("testdetective")}
        };
    }

    @Test(dataProvider = "checkUserLoginProvider")
    public void checkUserLogin(int id, String login)
    {
        System.out.println(get(USER, id).
                then().
                     statusCode(STATUS_CODE_OK).
                     contentType(ContentType.JSON)
                     .body(USER_LOGIN , equalTo(login)));

    }

    @Test(dataProvider = "checkUserLoginProvider")
    public void checkUserLoginAsPathAndHashMap(int id, String login)
    {
        Response response =
        get(USER, id).
                then().
                statusCode(STATUS_CODE_OK).
                contentType(ContentType.JSON).
                extract().response();
        //конкретный путь из response можно закинуть в String
        String loginFromResponse = response.path(USER_LOGIN);
        System.out.println(loginFromResponse);

        //response можно закинуть в map и делать разные проверки
        String jsonAsString = response.asString();
        HashMap<String,?> jsonAsHashMap = from(jsonAsString).get("");
        System.out.println(jsonAsHashMap.size());
        System.out.println(jsonAsHashMap.get(USER_ID));
        System.out.println(jsonAsHashMap.get(USER_LOGIN));
        System.out.println(jsonAsHashMap.get(USER_WWW));
    }




}
