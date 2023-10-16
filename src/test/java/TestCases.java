import io.restassured.RestAssured;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.IOException;


public class TestCases {

    public static long id;
    public static String url = "https://petstore.swagger.io/v2";
    public static JSONObject fileContent;

    @Test(priority=1)
    public void readAllPets() {

        given()
                .when()
                .get(url+"/pet/findByStatus?status=available")
                .then()
                .assertThat()
                .statusCode(200);

    }

    @Test(priority=2)
    public void addNewPet() throws IOException, ParseException {

        RestAssured.baseURI = url;

        JSONParser jsonParser = new JSONParser();
        fileContent = (JSONObject) jsonParser.parse(new FileReader("petToUpload.json"));

        id = given().contentType("application/json")
                .accept("application/json")
                .body(fileContent)
                .when().post(url+"/pet").then()
                .assertThat()
                .statusCode(200).extract().path("id");

        System.out.println("id : "+id);
    }

    @Test(priority=3)
    public void sellNewPet() {

        fileContent.put("id",id);
        fileContent.put("status","sold");

        System.out.println(fileContent);

        given().contentType("application/json")
                .accept("application/json")
                .body(fileContent)
                .when().put(url+"/pet").then()
                .assertThat()
                .statusCode(200);

    }

    @Test(priority=4)
    public void deleteSoldPet() {

        given()
                .when()
                .delete(url+"/pet/"+id)
                .then()
                .assertThat()
                .statusCode(200);

    }
}








