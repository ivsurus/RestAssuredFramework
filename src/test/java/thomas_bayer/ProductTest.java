package thomas_bayer;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by Ivan_Surus on 4/3/2017.
 */

public class ProductTest {


    //HTTP codes:
    private final int OK = 200;
    private final int CREATED = 201;
    private final int BADREQUEST = 400;
    private final int FORBIDDEN = 403;
    private final int NOTFOUND = 404;


    private final static String BASE_URI = "http://www.thomas-bayer.com/sqlrest/";
    private final static String PRODUCT = "/PRODUCT/";


    private final File PRODUCT_BODY_POST = new File("C:\\Users\\Ivan_Surus\\IdeaProjects\\RestTesting\\src\\test\\java\\resourses\\ProductBodyPost");
    private final File PRODUCT_BODY_PUT = new File("C:\\Users\\Ivan_Surus\\IdeaProjects\\RestTesting\\src\\test\\java\\resourses\\ProductBodyPut");

    @BeforeClass
    public void setUpRestAssured() {
        RestAssured.baseURI = BASE_URI;
    }


   /* @Test
    public void OneCanGetProduct() {
        System.out.println(get(PRODUCT).asString());

        get(PRODUCT).then().assertThat().statusCode(200);
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


    @DataProvider(name = "idProvider")
        public Object[][] idProvider() {
            return new Object[][] {
                    {new Integer(4463)}
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
