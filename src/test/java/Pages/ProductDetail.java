package Pages;

import com.thoughtworks.gauge.Step;
import com.testinium.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductDetail extends StepImplementation {
    @Step("Is product page detail true")
    public void isProductDetail() {
        boolean isProductDetail = findElement(By.id("com.ozdilek.ozdilekteyim:id/imgCart")).isDisplayed();
        Assertions.assertTrue(isProductDetail, "product detail pages wrong");
        Log4j.info("Product detail page is Checking");

    }
}
