package v1.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import v1.stepImplementation.DeleteStepImpl;
import v1.stepImplementation.UpdateStepImpl;

public class DeleteStepDefinition {
    @Steps
    DeleteStepImpl deleteStepImpl = new DeleteStepImpl();

    @When("^The admin removes employee (.*)$")
    public void removeEmployee(String id) {
        deleteStepImpl.removeEmployee(id);

    }

    @And("^the response contains message (.*)$")
    public void checkDeleteResponse(String message) {
        deleteStepImpl.checkDeleteResponse(message);
    }
}
