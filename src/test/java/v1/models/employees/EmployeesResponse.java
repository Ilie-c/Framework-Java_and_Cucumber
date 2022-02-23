package v1.models.employees;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class EmployeesResponse {

    private String status;

    private Employees[]  data;

    private String message;

}
