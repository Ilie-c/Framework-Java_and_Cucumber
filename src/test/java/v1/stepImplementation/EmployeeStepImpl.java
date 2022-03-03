package v1.stepImplementation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import v1.models.employee.EmployeeResponse;
import v1.util.Endpoints;
import v1.util.World;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeStepImpl {

    private Response response;

    public void getEmployeeById(String id) {
        if (id.toLowerCase(Locale.ROOT)=="null"){
            id=null;
        }
        response = RestAssured
                .given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.EMPLOYEE+"/"+id)
                .then().extract().response();
        World.setEmployeeId(id);
        World.setResponse(response);
    }

    public void checkResponse() {
        EmployeeResponse employeeResponse = World.getResponse().as(EmployeeResponse.class);
        assertThat(employeeResponse.getData().getId()).isEqualTo(Integer.valueOf(World.getEmployeeId()));
        assertThat(employeeResponse.getStatus()).isEqualTo(World.getSuccessStatus());
        assertThat(employeeResponse.getMessage()).isEqualTo(World.getSuccessMessage());
    }

    public void checkInvalidResponse() {
        EmployeeResponse employeeResponse = World.getResponse().as(EmployeeResponse.class);
        assertThat(employeeResponse.getData()).isNull();
        assertThat(employeeResponse.getStatus()).isEqualTo(World.getSuccessStatus());
        assertThat(employeeResponse.getMessage()).isEqualTo(World.getSuccessMessage());
    }
}
