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

public class BrowserstackIosDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // BrowserStack credentials
        caps.setCapability(
                "browserstack.user",
                Config.browserStack.user()
        );

        caps.setCapability(
                "browserstack.key",
                Config.browserStack.key()
        );

        // iOS device
        caps.setCapability(
                "device",
                Config.browserStack.iosDeviceName()
        );

        caps.setCapability(
                "os_version",
                Config.browserStack.iosOsVersion()
        );

        // Application
        caps.setCapability(
                "app",
                Config.browserStack.iosApp()
        );

        // BrowserStack project
        caps.setCapability(
                "project",
                Config.browserStack.projectName()
        );

        caps.setCapability(
                "build",
                Config.browserStack.buildName()
        );

        caps.setCapability(
                "name",
                "ios_search_test"
        );

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