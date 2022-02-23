package v1.stepImplementation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import v1.models.employees.EmployeesResponse;
import v1.util.Endpoints;
import v1.util.World;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.assertj.core.api.Assertions.assertThat;


public class EmployeesStepImpl {

    private Response response;

    public void getEmployees() {
        response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.EMPLOYEES);
        World.setResponse(response);

    }

    public void aListOfEmployeesIsReturned() {
        EmployeesResponse employeesResponse = World.getResponse().body().as(EmployeesResponse.class);

    }


}
