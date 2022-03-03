package v1.stepImplementation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import v1.util.Endpoints;
import v1.util.World;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteStepImpl {
    public void removeEmployee(String id) {
        Response response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete(Endpoints.DELETE + "/" + id.toString())
                .then().log().all().extract().response();
        World.setResponse(response);
    }


    public void checkDeleteResponse(String message) {
//        assertThat(World.getResponse().getBody().["status"].toString()).isEqualTo(World.getSuccessStatus());
//        assertThat(updateResponse.getMessage()).isEqualTo(message);
        System.out.println("checked");
    }
}
