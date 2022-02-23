package v1.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import v1.stepImplementation.CommonStepImpl;

public class CommonStepDefinitions {

    CommonStepImpl commonStep= new CommonStepImpl();

    @Given("The demo application is up and running")
    public void verifyTheApplication() {
        commonStep.verifyAppIsUp();
    }

    @Then("the status code is {int}")
    public void checkStatus(int statusCode){
        commonStep.checkStatus(statusCode);
    }

    @And("the list is returned as {string} json schema")
    public void checkJsonWithJsonSchema(String schemaName) {
        commonStep.checkJsonSchema(schemaName);
    }

}
