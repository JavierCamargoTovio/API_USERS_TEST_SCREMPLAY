package co.com.test.users.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class Schema implements Question<Boolean> {
    private final String expectedSchema;

    private Schema(String expectedSchema) {
        this.expectedSchema = expectedSchema;
    }

    public static Schema theJsonSchemaExpectIs(String expectedSchema) {
        return new Schema(expectedSchema);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Scheme validation response",
                        response -> response
                                .assertThat()
                                .body(matchesJsonSchemaInClasspath("shemas/" + expectedSchema + ".json")))

        );
        return true;
    }
}
