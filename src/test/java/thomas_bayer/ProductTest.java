package thomas_bayer;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by Ivan_Surus on 4/3/2017.
 */

/*Given = This is where we would specify parameters when making the API call
        When = This is where we would call the API
        Then = This is where we check that the response is as we expect*/

public class ProductTest {


    //HTTP codes:
    private final int OK = 200;
    private final int CREATED = 201;
    private final int BADREQUEST = 400;
    private final int FORBIDDEN = 403;
    private final int NOTFOUND = 404;

    private final static String PRODUCT_ID = "PRODUCT.ID";
    private final static String PRODUCT_NAME = "PRODUCT.NAME";
    private final static String PRODUCT_PRICE = "PRODUCT.PRICE";
    private final static String BASE_URI = "http://www.thomas-bayer.com/sqlrest/";
    private final static String PRODUCT = "PRODUCT/{ID}";
    private Response response;


    private final File PRODUCT_BODY_POST = new File("C:\\Users\\Ivan_Surus\\IdeaProjects\\RestTesting\\src\\test\\java\\resourses\\ProductBodyPost");
    private final File PRODUCT_BODY_PUT = new File("C:\\Users\\Ivan_Surus\\IdeaProjects\\RestTesting\\src\\test\\java\\resourses\\ProductBodyPut");

    @BeforeClass
    public void setUpRestAssured() {
        RestAssured.baseURI = BASE_URI;
    }


    @Test
    public void checkNumberOfParameters(){
        given()
                .pathParam("ID", "4")
        .when()
                .get(PRODUCT)
        .then()
                .body(PRODUCT_NAME, containsString("Tea"));
    }

    @DataProvider(name = "checkNumberOfParametersProvider")
    public Object[][] checkProductIdProvider() {
        return new Object[][] {
                {new Integer(4)}
        };
    }


    /*@BeforeMethod
    public void getResponse(){
        response = get(PRODUCT + "4").then().contentType(ContentType.XML).extract().response();
        System.out.println(response.asString());
    }*/


   /* @Test
    public void getAllProductsAndCount(){
        String productList = response.path("PRODUCT.NAME");
        response.
    }
*/

  /*  @Test
    public void OneCanGetProduct() {
        Response response;
        String xmlAsString;

        *//*System.out.println(get(PRODUCT + "2").asString());
        //извлекает value из body
        System.out.println(get(PRODUCT + "2").path("PRODUCT.NAME"));
         when().
                get(PRODUCT + 2).then().assertThat().
                .path("PRODUCT.NAME").equals("Telephone Clock");*//*

        response =
                when().
                        get(PRODUCT + "3").
                        then().
                        contentType(ContentType.XML).  // check that the content type return from the API is JSON
                        extract().response(); // extract the response

        xmlAsString = response.asString();
        System.out.println(xmlAsString);
        String name = response.path("PRODUCT.NAME");
        System.out.println(name);
        assertThat(name, equalTo("Telephone Clock"));
        List<String> rideStates = response.path("state");

    }*/





   /* @Test
    public void OneCanPutProducts() {
        System.out.println(given().body(PRODUCT_BODY_PUT)
                .when()
                .post(PRODUCT).getStatusCode());
    }*/


   //теги в xml регистрочувствительные
    //на сервере паттерн на содержимое тегов
    //post  создание нового или изменение
    // при создании указывем id в xml code=201
    // при изменении указываеи id в пути code=200
   @Test
    public void OneCanCreateProductWithPost() {
      given().body(PRODUCT_BODY_POST)
                .when()
                .post(PRODUCT)
              .then().assertThat().statusCode(201);

    }





    @Test
    public void checkBodyParameters(){

        System.out.println(given().queryParam("id", 2).
                when().
                get("/PRODUCT").
                then().
                statusCode(200).
                body("PRICE", equalTo(24.8)));
    }




    @DataProvider(name = "idProvider")
        public Object[][] idProvider() {
            return new Object[][] {
                    {new Integer(4)}
            };
        }

    //если принимать параметр у метода и не использовать его то тест будет проигнорирован
    //изменять можно только по одному параметру ???
    //id в xml optional
    @Test(dataProvider = "idProvider")
    public void OneCanUpdateProductWithPost(Integer id) {
        given().body(PRODUCT_BODY_POST)
                .when()
                .post(PRODUCT + id).then().assertThat().statusCode(200);
//        System.out.println(when().get(PRODUCT + id).asString());
//        System.out.println(when().get(PRODUCT + id));



    }

    //удаление
    @Test(dataProvider = "idProvider")
    public void OneCanDeleteProduct(Integer id) {
        System.out.println(
                 when()
                .delete(PRODUCT + id).getStatusCode());
    }


    }
