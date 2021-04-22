package ru.project.ekatalog.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.project.ekatalog.page.CheckBox;
import ru.project.ekatalog.page.TextFieldPage;

public class FilterSteps {

    @Step("Нажать на CheckBox {0}")
    public FilterSteps chooseManufacturerCheckBox(String filter){
        CheckBox.manufacturerFilterCheckBox.findBy(Condition.exactText(filter)).scrollIntoView("{block: \"center\"}").click();
        return this;
    }
    @Step("Нажать на CheckBox {0}")
    public FilterSteps chooseCheckBox(String filter){
        CheckBox.otherFilterCheckBox.findBy(Condition.exactText(filter)).scrollIntoView("{block: \"center\"}").click();
        return this;
    }

    /**
     * @param nameField название поля
     * @param num его номер в коллекции, если несколько одинаковых элементов на странице
     */

    @Step("Ввести текст в поле {0}")
    public FilterSteps inputText(String nameField, int num, String value){
        TextFieldPage.field(nameField).get(num).val(value);
        return this;
    }
}
