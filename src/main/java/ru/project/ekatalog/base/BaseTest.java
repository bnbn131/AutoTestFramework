package ru.project.ekatalog.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.project.ekatalog.steps.FilterSteps;
import ru.project.ekatalog.steps.MenuSteps;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;


public class BaseTest {
    public MenuSteps menuSteps;
    public FilterSteps filterSteps;

    public static String baseUrl = "https://www.e-katalog.ru/";

    public static String getUrl() {
        if (System.getProperty("url") != null) {
            return System.getProperty("url");
        } else return baseUrl;
    }

    public boolean selenoidOrLocal() {
        try {
            given()
                    .when().get("http://localhost:4444/wd/hub")
                    .then().statusCode(200).assertThat().statusCode(200).equals("200");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() {
        menuSteps = new MenuSteps();
        filterSteps = new FilterSteps();
        if (selenoidOrLocal() == true) {
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
        } else {
            Configuration.browser = "chrome";
            //Размер окна браузера
            Configuration.browserSize = "1920x1080";
        }

        open(baseUrl);
    }


    @AfterMethod
    public void close() {
        Selenide.closeWebDriver();
    }
}
