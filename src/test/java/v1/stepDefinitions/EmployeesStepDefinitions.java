package v1.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import v1.stepImplementation.EmployeeStepImpl;
import v1.stepImplementation.EmployeesStepImpl;
import v1.util.World;

public class EmployeesStepDefinitions {
    @Steps
    EmployeesStepImpl employeesImpl= new EmployeesStepImpl();
    EmployeeStepImpl employeeImpl= new EmployeeStepImpl();


    @When("the user requests all employees")
    public void theUserRequestsAllEmployees() {
        employeesImpl.getEmployees();
    }

    @And("a list of employees is returned")
    public void aListOfEmployeesIsReturned() {
        employeesImpl.aListOfEmployeesIsReturned();
    }

    @When("^the user requests employee with id (.*)$")
    public void theUserRequestsEmployeeWithId(String id) {
        employeeImpl.getEmployeeById(id);    }

    @And("The details about that employee is returned")
    public void theDetailsAboutThatEmployeeIsReturned() {
        employeeImpl.checkResponse();
    }

    @And("The response should be null")
    public void theResponseShouldBeNull() {
        employeeImpl.checkInvalidResponse();
    }
}
