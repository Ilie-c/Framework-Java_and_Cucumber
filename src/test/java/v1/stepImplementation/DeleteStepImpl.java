package v1.stepImplementation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import v1.util.Endpoints;
import v1.util.World;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteStepImpl {
    public void removeEmployee(String id) {
        if (Objects.equals(id, "null")){
            id=null;
        }
        Response response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete(Endpoints.DELETE + "/" + id)
                .then().extract().response();
        World.setResponse(response);
    }


    public void checkDeleteResponse(String status,String message) {
        assertThat(World.getResponse().jsonPath().get("status").toString()).isEqualTo(status);
        assertThat(World.getResponse().jsonPath().get("message").toString()).isEqualTo(message);
    }
}
