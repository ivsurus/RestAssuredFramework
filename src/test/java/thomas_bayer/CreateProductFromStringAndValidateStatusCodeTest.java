package thomas_bayer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;


public class CreateProductFromStringAndValidateStatusCodeTest extends BaseTest{


    private static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }


    //post записыает продукт. все ОК
    @Test
    public void postNewProductFromString(){
        String myRequest = null;
        try {
            myRequest = GenerateStringFromResource("D:\\Сурус\\JAVA\\RestAssuredFramework\\src\\test\\java\\resourses\\ProductBodyPost");
        } catch (IOException e) {
            e.printStackTrace();
        }
        given()
                .contentType("application/xml")
                .body(myRequest)
                .when()
                .post("PRODUCT/")
                .then().
        statusCode(STATUS_CODE_CREATED);
    }

    //put записыает продукт но статус код 403 вместо 201
    @Test
    public void putNewProductFromString(){
        String myRequest = null;
        try {
            myRequest = GenerateStringFromResource("D:\\Сурус\\JAVA\\RestAssuredFramework\\src\\test\\java\\resourses\\ProductBodyPost");
        } catch (IOException e) {
            e.printStackTrace();
        }
        given()
                .contentType("application/xml")
                .body(myRequest)
                .when()
                .put("PRODUCT/")
                .then().
                statusCode(STATUS_CODE_CREATED);
    }
}
