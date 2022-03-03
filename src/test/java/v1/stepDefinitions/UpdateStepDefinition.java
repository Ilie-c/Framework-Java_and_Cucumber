package v1.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import v1.stepImplementation.UpdateStepImpl;

public class UpdateStepDefinition {
    @Steps
    UpdateStepImpl updateStepImpl = new UpdateStepImpl();

    @When("^the admin changes data for employee (.*) with (.*), (.*) and (.*)$")
    public void updateEmployee(Integer id, String name, String salary, String age) {
        updateStepImpl.updateEmployee(id, name, salary, age);
    }

    @When("^the admin adds data for employee (.*) with (.*), (.*), (.*) and (.*)$")
    public void updateEmployee(Integer id, String name, String salary, String age, String unique) {
        updateStepImpl.updateEmployeeExtend(id, name, salary, age, unique);
    }

    @When("^the admin adds partial data for employee (.*) with (.*) and (.*)$")
    public void updateEmployee(Integer id, String name, String age) {
        updateStepImpl.updateEmployeePartialy(id, name, age);
    }

    @And("the response contains the new data")
    public void theResponseContainsTheNewData() {
        updateStepImpl.checkResponse();
    }

    @And("the response returns an error about too many items")
    public void checkTooManyItemsResponse() {
        updateStepImpl.checkTooManyItemsResponse();
    }

}
