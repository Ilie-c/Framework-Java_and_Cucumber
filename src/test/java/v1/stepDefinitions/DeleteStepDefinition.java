package v1.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import v1.stepImplementation.DeleteStepImpl;
import v1.util.World;

public class DeleteStepDefinition {
    @Steps
    DeleteStepImpl deleteStepImpl = new DeleteStepImpl();

    @When("^the admin removes employee (.*)$")
    public void removeEmployee(String id) {
        deleteStepImpl.removeEmployee(id);

    }

    @And("^the delete response contains (.*)$")
    public void checkDeleteResponse(String message) {
        deleteStepImpl.checkDeleteResponse(World.getSuccessStatus(),message);
    }

    @And("^the negative response contains (.*)$")
    public void checkNegativeDeleteReponse(String message) {
        deleteStepImpl.checkDeleteResponse(World.getNegativeStatus(),message);
    }
}
