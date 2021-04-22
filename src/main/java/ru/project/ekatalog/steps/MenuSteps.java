package ru.project.ekatalog.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.project.ekatalog.page.ButtonPage;



public class MenuSteps {

    @Step("Перейти в меню {0}")
    public MenuSteps clickMenuItem(String itemName){
        ButtonPage.menuItem.findBy(Condition.exactText(itemName)).scrollIntoView("{block: \"center\"}").click();
        return this;
    }
}
