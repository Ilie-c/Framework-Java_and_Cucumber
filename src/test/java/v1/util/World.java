package v1.util;


import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import v1.models.create.CreateRequest;
import v1.models.employees.EmployeesResponse;
import v1.models.update.UpdateRequest;


public final class World {

  @Getter
  @Setter
  private static Response response;

  @Getter
  @Setter
  private static EmployeesResponse employeeResponse;

  @Getter
  @Setter
  private static CreateRequest createRequest;

  @Getter
  @Setter
  private static UpdateRequest updateRequest;

  @Getter
  @Setter
  private static String employeeId;

  @Getter
  private static final String  successStatus = "success" ;

  @Getter
  private static final String  negativeStatus = "fail" ;

  @Getter
  private static final String  successMessage = "Successfully! Record has been fetched." ;

}
