package co.com.test.users.util.token;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.core.Serenity.getDriver;

public class ExtractDataBrowser {
    private static final String UTOKEN_BROWSER = "return window.localStorage.getItem('Utoken')";

    public static WebDriver obtenerDriver() {
        return getDriver();
    }

    public static String extractUtoken(){
        return extractDataBrowser(UTOKEN_BROWSER);
    }

    public static String extractDataBrowser(String dataExtract){
        JavascriptExecutor js = (JavascriptExecutor) obtenerDriver();
        return (String) js.executeScript(dataExtract);
    }
}
