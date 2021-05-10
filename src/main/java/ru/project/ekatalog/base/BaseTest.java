package ru.project.ekatalog.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.project.ekatalog.steps.FilterSteps;
import ru.project.ekatalog.steps.MenuSteps;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;


public class BaseTest {
    public MenuSteps menuSteps;
    public FilterSteps filterSteps;

    public static String baseUrl = "https://www.e-katalog.ru/";

    public static String getUrl() {
        if (System.getProperty("url") != null) {
            return System.getProperty("url");
        } else return baseUrl;
    }

    @BeforeMethod
    public void setUp() {
        menuSteps = new MenuSteps();
        filterSteps = new FilterSteps();

        Configuration.timeout = 10000;
        Configuration.remote = "http://localhost:4444/wd/hub";
        //Определяем какой браузер будем использовать
        Configuration.browser = "chrome";
        //Размер окна браузера
        Configuration.browserSize = "1920x1080";
        //Создаём объект класса DesiredCapabilities, используется как настройка  вашей конфигурации с помощью пары ключ-значение
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Включить поддержку отображения экрана браузера во время выполнения теста
        capabilities.setCapability("enableVNC", true);
        //Переопределяем Browser capabilities
        Configuration.browserCapabilities = capabilities;

        open(baseUrl);
    }


    @AfterMethod
    public void close() {
        Selenide.closeWebDriver();
    }
}
