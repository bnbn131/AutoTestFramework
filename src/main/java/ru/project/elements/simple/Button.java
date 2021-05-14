package ru.project.elements.simple;



import io.qameta.allure.Step;
import ru.project.elements.ElementPrototype;

import static io.qameta.allure.Allure.getLifecycle;

public class Button extends ElementPrototype {
    public Button(String name, String xpath) {
        super(name, xpath);
    }

    @Step("Клик по кнопке [%name%]")
    public void click() {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        findElement();
        clickElement();
    }
}
