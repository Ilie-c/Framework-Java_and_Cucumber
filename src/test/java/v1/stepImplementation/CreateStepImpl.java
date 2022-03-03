package v1.stepImplementation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import v1.models.create.CreateRequest;
import v1.models.create.CreateResponse;
import v1.util.Endpoints;
import v1.util.World;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateStepImpl {

    public void createEmployee(String name, String salary, String age) {
        if (Objects.equals(name, "null")){
            name=null;
        }
        if (Objects.equals(salary, "null")){
            salary=null;
        }
        if (Objects.equals(age, "null")){
            age=null;
        }
        CreateRequest createRequest = new CreateRequest(name,salary,age);
        Response response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .body(createRequest)
                .when()
                .post(Endpoints.CREATE)
                .then().extract().response();
        World.setResponse(response);
        World.setCreateRequest(createRequest);
    }

    public void checkResponse(){
        CreateResponse  createResponse = World.getResponse().as(CreateResponse.class);
        assertThat(createResponse.getCreateRequest()).isEqualTo(World.getCreateRequest());
        assertThat(createResponse.getId()).isPositive().isNotNull();
    }

    public void checkNegativeResponse() {
        assertThat(World.getResponse().jsonPath().get("status").toString()).isEqualTo(World.getNegativeStatus());
        assertThat(World.getResponse().jsonPath().get("message").toString()).isEqualTo("Unaccepted values.");
    }
}
