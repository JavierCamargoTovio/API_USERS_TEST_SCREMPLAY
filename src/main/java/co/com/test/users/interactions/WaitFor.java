package co.com.test.users.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class WaitFor implements Interaction {
    private final int seconds;
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WaitFor.class);

    private WaitFor(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        waitForSomeTime(seconds);
    }

    public static void waitForSomeTime(int seconds) {
        try {
            sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            LOGGER.warn("Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }

    public static WaitFor waitFor(int seconds) {
        return new WaitFor(seconds);
    }
}
