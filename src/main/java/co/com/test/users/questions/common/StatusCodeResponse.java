package co.com.test.users.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import net.serenitybdd.core.Serenity;


public class StatusCodeResponse implements Question<Boolean> {

    private final int statusCode;

    private StatusCodeResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public static StatusCodeResponse httpResponseStatusCodeIs(int statusCode) {
        return new StatusCodeResponse(statusCode);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Service API response status code",
                        response -> response.statusCode(statusCode)
                )
        );
        Serenity.recordReportData().withTitle("HTTP Status Code").andContents(String.valueOf(statusCode));
        return true;
    }
}
