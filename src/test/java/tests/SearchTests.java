package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {

        step("Открыть приложение Wikipedia", () -> {
            // приложение открывается в TestBase
        });

        step("Нажать на кнопку «Поиск»", () -> {
            $(accessibilityId("Search Wikipedia")).click();
        });

        step("Ввести в поиск запрос «Appium»", () -> {
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Appium");
        });

        step("Проверить наличие результатов поиска", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void openArticleTest() {
        step("Открыть приложение Wikipedia", () -> {
            // приложение открывается в TestBase
        });

        step("Нажать на кнопку «Поиск»", () -> {
            $(accessibilityId("Search Wikipedia")).click();
        });

        step("Ввести в поиск запрос «Appium»", () -> {
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Appium");
        });

        step("Проверить наличие результатов поиска", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });

        step("Открыть первую статью", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_container"))
                    .first()
                    .click();
        });

        step("Проверить, что открылась статья Appium", () -> {
            $x("//*[@resource-id='org.wikipedia.alpha:id/page_toolbar']//*[@text='Appium']")
                    .shouldBe(visible);
        });
    }
}
