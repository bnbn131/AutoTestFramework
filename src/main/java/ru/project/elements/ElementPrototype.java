package ru.project.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.getLifecycle;

public abstract class ElementPrototype {
    protected SelenideElement element;
    protected String elementXPath;
    protected String elementName;
    protected final int defaultTimeout = 5000;

    public ElementPrototype() {
    }

    public ElementPrototype(String name, String xpath) {
        this.elementName = name;
        this.elementXPath = xpath;
    }

    @Step("Проверка отсутствия элемента '%name%' на экране")
    public void elementAbsent() {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        $x(elementXPath).shouldBe(Condition.disappear, Duration.ofMillis(defaultTimeout));

    }

    @Step("Ожидание исчезновения элемента '%name%' с экрана в течении {seconds} секунд")
    public void elementAbsent(int seconds) {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        $x(elementXPath).shouldBe(Condition.disappear, Duration.ofMinutes(seconds));
    }

    @Step("Проверка наличия элемента '%name%' на экране")
    public void elementExist() {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        $x(elementXPath).shouldBe(Condition.exist, Duration.ofMillis(defaultTimeout));
    }

    @Step("Ожидание наличия элемента '%name%' на экране в течении {seconds} секунд")
    public void elementExist(int seconds) {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        $x(elementXPath).shouldBe(Condition.exist, Duration.ofMinutes(seconds));
        getLifecycle().updateStep(step -> step.getParameters().remove(0));
    }

    @Step("Проверка активности элемента '%name%'")
    public void elementEnabled() {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        $x(elementXPath).shouldBe(Condition.attribute("disabled"), Duration.ofMillis(defaultTimeout));
    }

    @Step("Проверка неактивности элемента '%name%'")
    public void elementDisabled() {
        getLifecycle().updateStep(step -> step.setName(step.getName().replace("%name%", elementName)));
        $x(elementXPath).shouldBe(Condition.attribute("disabled", "true"), Duration.ofMillis(defaultTimeout));
    }

    protected void findElement() {
        element = $x(elementXPath).shouldBe(Condition.exist, Duration.ofMillis(defaultTimeout));
    }

    protected void checkElementText(String expectedValue) {
        element.shouldBe(Condition.text(expectedValue), Duration.ofMillis(defaultTimeout));
    }

    protected void clickElement() {
        element.click();
    }
}
