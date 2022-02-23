package v1.stepImplementation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import v1.util.Endpoints;
import v1.util.World;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.rest;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonStepImpl {

    public void checkStatus(int statusCode) {
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(World.getResponse().statusCode()).isEqualTo(statusCode);
        softAssert.assertAll();
    }

    public void verifyAppIsUp() {
        Response response = rest()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .get();
        assertThat(response.statusCode()).isEqualTo(200);
    }

    public void checkJsonSchema(String schemaName) {
        File schema = new File("src/test/java/v1/util/JSONSchemas/"+schemaName+"ResponseSchema.json");
        World.getResponse().then().assertThat().body(matchesJsonSchema(schema));
    }

}
