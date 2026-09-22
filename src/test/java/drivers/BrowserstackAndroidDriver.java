package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserstackAndroidDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Android
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", Config.browserStack.androidDeviceName());
        caps.setCapability("platformVersion", Config.browserStack.androidOsVersion());
        caps.setCapability("app", Config.browserStack.androidApp());
        caps.setCapability("automationName", "UIAutomator2");

        // BrowserStack
        Map<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put(
                "userName",
                Config.browserStack.user()
        );

        bstackOptions.put(
                "accessKey",
                Config.browserStack.key()
        );

        bstackOptions.put(
                "projectName",
                Config.browserStack.projectName()
        );

        bstackOptions.put(
                "buildName",
                Config.browserStack.buildName()
        );

        bstackOptions.put(
                "sessionName",
                "android_search_test"
        );

        bstackOptions.put(
                "appiumVersion",
                Config.browserStack.appiumVersion()
        );

        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(
                    new URL(Config.browserStack.hubUrl()),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}