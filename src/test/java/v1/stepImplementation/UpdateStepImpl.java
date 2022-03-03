package v1.stepImplementation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import v1.models.update.UpdateRequest;
import v1.models.update.UpdateRequestExtend;
import v1.models.update.UpdateRequestShort;
import v1.models.update.UpdateResponse;
import v1.util.Endpoints;
import v1.util.World;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateStepImpl {
    public void updateEmployee(Integer id, String name, String salary, String age) {
        UpdateRequest updateRequest = generateData(name, salary, age);
        Response response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .body(updateRequest)
                .when()
                .put(Endpoints.UPDATE + "/" + id.toString())
                .then().extract().response();
        World.setResponse(response);
        World.setUpdateRequest(updateRequest);
    }

    public void updateEmployeeExtend(Integer id, String name, String salary, String age, String unique) {
        UpdateRequestExtend updateRequestExtend = new UpdateRequestExtend(new UpdateRequest(name, salary, age), unique);
        Response response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .body(updateRequestExtend)
                .when()
                .put(Endpoints.UPDATE + "/" + id.toString())
                .then().extract().response();
        World.setResponse(response);
    }

    public void updateEmployeePartialy(Integer id, String name, String age) {
        UpdateRequestShort updateRequestShort = new UpdateRequestShort(name,age);
        Response response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .body(updateRequestShort)
                .when()
                .put(Endpoints.UPDATE + "/" + id.toString())
                .then().extract().response();
        World.setResponse(response);
    }

    private UpdateRequest generateData(String name, String salary, String age) {
        if (Objects.equals(name, "null")) {
            name = null;
        }
        if (Objects.equals(salary, "null")) {
            salary = null;
        }
        if (Objects.equals(age, "null")) {
            age = null;
        }
        return new UpdateRequest(name, salary, age);

    }

    public void checkResponse() {
        UpdateResponse updateResponse = World.getResponse().as(UpdateResponse.class);
        assertThat(updateResponse.getData()).isEqualTo(World.getUpdateRequest());
        assertThat(updateResponse.getStatus()).isEqualTo(World.getSuccessStatus());
    }


    public void checkTooManyItemsResponse() {
//        assertThat(World.getResponse().body()).isEqualTo("");
    }
}
