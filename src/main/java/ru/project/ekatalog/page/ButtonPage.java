package ru.project.ekatalog.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;


public interface ButtonPage {
    ElementsCollection menuItem = $$x("//*[contains(@class,\"mainmenu\")]");
}
