package Pages;

import com.thoughtworks.gauge.Step;
import com.testinium.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends StepImplementation {
    @Step("is login page correct")
    public void checkLogin() {
        boolean loginButtonVisible = findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")).isDisplayed();
        Assertions.assertTrue(loginButtonVisible, "login pages not correct");
        Log4j.info("Login page control ");

    }
}
