package co.com.test.users.tasks;


import static co.com.test.users.questions.common.GetValueFromResponseBodyQuestion.theAttributeValue;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ValidateInCraeteAndUpdateUser {

    private ValidateInCraeteAndUpdateUser() {
        //Nothing
    }


    public static void thatUserIdWasGenerated() {
        theActorInTheSpotlight().should(
                seeThat("the user Id", theAttributeValue("id"), notNullValue())
        );
    }

    public static void thatUserNameIs(String name) {
        theActorInTheSpotlight().should(
                seeThat("the name user", theAttributeValue("name"), is(equalTo(name)))
        );
    }

    public static void thatUserJobIs(String job) {
        theActorInTheSpotlight().should(
                seeThat("the job user", theAttributeValue("job"), is(equalTo(job)))
        );
    }
    public static void thatUserDateWasGenerated() {
        theActorInTheSpotlight().should(
                seeThat("the user date", theAttributeValue("createdAt"), notNullValue())
        );
    }

    public static void thatUserDateWasUpdate() {
        theActorInTheSpotlight().should(
                seeThat("the user update date", theAttributeValue("updatedAt"), notNullValue())
        );
    }

}
