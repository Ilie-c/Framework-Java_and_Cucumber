package v1.models.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    private Integer id;

    private String employee_name;

    private Integer employee_salary;

    private Integer employee_age;

    private String profile_image;

}
