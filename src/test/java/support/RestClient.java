package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getPositionFromFile;

public class RestClient {

    public static final String BASE_URI = "https://skryabin.com/recruit/api/v1";
    public final String CONTENT_TYPE = "Content-Type";
    public final String JSON = "application/json";
    public final String ACCEPT = "Accept";



    public int postPosition(Map<String, String> position1){
        List<Map<String, Object>> list = getPositions();
        boolean found = false;
        for (Map<String, Object> item : list){
            if (item.get("id").equals(5)){
                found = true;
            }
        }
        assertThat(found).isTrue();




        System.out.println("\nRequest:\n------------------------");

        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(CONTENT_TYPE, JSON)
                .auth().preemptive().basic("student@example.com", "welcome")
                .body(position1)
                .log().all();

        // execute the request
        Response response = request
                .when()
                .get("/positions");

        // Parse

        int positionId = response
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("id");

       // TestContext.savePositionId(Integer) createdPosition.get("id");
      //  TestContext.savePositionTitle();

        System.out.println("\nResponse:\n-------------------------");


        return positionId;
    }


    public void updatePosition(Map<String, String> position, int id){
        System.out.println("\nRequest:\n------------------------");

        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(CONTENT_TYPE, JSON)
                .auth().preemptive().basic("student@example.com", "welcome")
                .body(position)
                .log().all();

        // execute the request
        Response response = request
                .when()
                .patch("/positions/"+ id);

        // Parse

        int positionId = response
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("id");

        System.out.println("\nResponse:\n-------------------------");



    }


    public void deletePosition(int id){

        System.out.println("\nRequest:\n------------------------");

        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(CONTENT_TYPE, JSON)
                .auth().preemptive().basic("student@example.com", "welcome")
                .log().all();


    }

    public List<Map<String, Object>>  getPositions(){

        System.out.println("\nRequest:\n------------------------");

        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .log().all();

        // execute the request
        Response response = request
                .when()
                .get("/positions");

        System.out.println("\nResponse:\n-------------------------");

        // parse and verify

        List<Map<String, Object>> positions = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        System.out.println(positions);
        return positions;

    }

    public Map <String, Object> getPositionById (int id){

        System.out.println("\nRequest:\n------------------------");

        RequestSpecification request = RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(ACCEPT, "application/xml")
                .log().all();


        Response response = request
                .when()
                .get("/positions/"+ id + "");

        System.out.println("\nResponse:\n--------------------");

        Map<String, Object> position = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("item");

        System.out.println(position);


        return position;
    }

}
