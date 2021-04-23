package ru.project.ekatalog.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.project.ekatalog.steps.FilterSteps;
import ru.project.ekatalog.steps.MenuSteps;

import static com.codeborne.selenide.Selenide.open;



public class BaseTest {
    public MenuSteps menuSteps;
    public FilterSteps filterSteps;

    public static String baseUrl = "https://www.e-katalog.ru/";

    public static String getUrl(){
        if (System.getProperty("url") != null) {
            return System.getProperty("url");
        }else return baseUrl;
    }

    @BeforeMethod
    public void setUp(){
        menuSteps = new MenuSteps();
        filterSteps = new FilterSteps();
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open(baseUrl);
    }


    @AfterMethod
    public void close(){
        WebDriverRunner.getWebDriver().close();
        Selenide.close();
    }
}
