package com.testinium;

import Pages.Log4j;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest {

    public StepImplementation() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    @Step("<time> second wait")
    public void waitTime(int time) throws InterruptedException {
        Thread.sleep(1000 * time);
        Log4j.info("Waiting");
    }

    @Step("<Key> click with id's element")
    public void clickElementByid(String Key) {
        driver.findElement(By.id(Key)).click();
        Log4j.info("Element to clicked");;
    }

    @Step("<Key> with id element <keywordc> write value")
    public void SendkeyElementByid(String Key, String keywordc) {
        driver.findElement(By.id(Key)).sendKeys(keywordc);
        Log4j.info("Element to clicked and writing value");

    }

    @Step("<Key> click with xPath")
    public void clickElementByxpath(String Key) {

            driver.findElement(By.xpath(Key)).click();
        Log4j.info("Element to clicked");

    }

    @Step("<Key> click with id's elements")
    public void clickElementById(String Key) {
        driver.findElement(By.id(Key)).click();
        Log4j.info("Element to clicked");
    }

    @Step("With xPath <by> find element and <text> with check.")
    public void pageCurrentTexts(String by, String text) {
        WebElement control;
        control = findElement(By.xpath(by));
        Assert.assertEquals(text, control.getText());
        Log4j.info("Element finding and check is correct");
    }

    @Step("scroll down")
    public void ScrollRandomPos() {
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
        Log4j.info("Scrolling down");
    }

    @Step("<Key> choose random product")
    public void findAllProducts(String Key) {
        List<MobileElement> productList = driver.findElementsByXPath(Key);
        int size = productList.size();
        Random rnd = new Random();
        int randNum = rnd.nextInt(size);
        productList.get(randNum).click();
        Log4j.info("randomly selected product");

    }

    @Step("Add to basket")
    public void addToBasket() {
        clickElementByxpath("//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout[@index=0]");
        clickElementByid("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");

    }
}