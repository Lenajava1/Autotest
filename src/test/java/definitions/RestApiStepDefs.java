package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDataFromFile;
import static support.TestContext.getPositionFromFile;


public class RestApiStepDefs {

    private RestClient restClient = new RestClient();

    @Given("I make rest api request for position")
    public void iMakeRestApiRequest() {


        Map<String, Object> position = restClient.getPositionById(5);
        // String title = (String) position.get("title");
        //System.out.println(title);
        //assertThat(title).isEqualTo("Automation Engineer");
        assertThat(position).isEqualTo("Automation Engineer");

        Map<String, String> positionToCreate = getPositionFromFile("automation");
        Map<String, String> fildsToUpdate = getPositionFromFile("automation");

        int createdPositionId = restClient.postPosition(positionToCreate);
        System.out.println(createdPositionId);
        restClient.updatePosition(fildsToUpdate, createdPositionId);
        restClient.deletePosition(createdPositionId);

        List<Map<String, Object>> updatedList = restClient. getPositions();
        boolean deletedPostNotFound = false;
        for (Map<String, Object> item : updatedList){
            if (item.get("id").equals(createdPositionId)){
                deletedPostNotFound = true;
            }
        }
        assertThat(deletedPostNotFound).isFalse();

        assertThat(positionToCreate).isEqualTo(positionToCreate);

    }





    @Then("I read position by id {int} and verify the {string} is as expected {string}")
    public void iVerifyTheTitleIsAsExpected(int id, String str1, String str2) {
        System.out.println("\nRequest:\n------------------------");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute the request

        Response response = request
                .when()
                .get("/positions/"+ id + "");

        System.out.println("\nResponse:\n--------------------");

        // verify specific data

        Map<String, Object> position = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");


            if (position.containsValue(str2)) {
                System.out.println("\nThe " + str1 + " is " + position.get(str1));
        }


    }

    @When("I read a list of candidates")
    public void iReadAListOfCandidates() {

        //Prepare request

        System.out.println("\nRequest:\n----------------------------");

        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute a request

        Response response = request
                .when()
                .get("/candidates");

        System.out.println("\nResponse:\n--------------------");

        //get response

        List<Map<String, String>> candidates = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

       // System.out.println(candidates);


    }

    @And("I read candidates details by id {int}")
    public void iReadCandidatesDetails(int id) {

        System.out.println("\nRequest:\n------------------------------");

        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = requestSpecification
                .when()
                .get("/candidates/" + id + "");

        System.out.println("\nResponse:\n----------------------------");

        Map<String, Object> map = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");


    }


    @Given("I go to careers page oop")
    public void iGoToCareersPageOop() {
    }
}
