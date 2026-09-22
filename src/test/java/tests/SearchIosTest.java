package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;

public class SearchIosTest extends TestBaseIos {

    @Test
    void alertTest() {

        step("Нажать кнопку Alert", () -> {
            $(accessibilityId("Alert"))
                    .click();
        });

        step("Проверить текст нативного Alert", () -> {
            $(accessibilityId("This is a native alert."))
                    .shouldBe(visible);
        });

        step("Закрыть Alert", () -> {
            $(accessibilityId("OK"))
                    .click();
        });
    }
}