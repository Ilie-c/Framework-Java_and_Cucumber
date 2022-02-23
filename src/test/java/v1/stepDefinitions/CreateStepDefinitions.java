package v1.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import v1.stepImplementation.CreateStepImpl;

public class CreateStepDefinitions {
    @Steps
    CreateStepImpl createStepImpl = new CreateStepImpl();
    @When("^the admin employs new employee: (.*), (.*) and (.*)$")
    public void  createEmployee(String name, String salary, String age){
        createStepImpl.createEmployee(name,salary,age);
    };

    @And("the response contains the given data and an id")
    public void theResponseContainsTheGivenDataAndAnId() {
        createStepImpl.checkResponse();
    }

}
