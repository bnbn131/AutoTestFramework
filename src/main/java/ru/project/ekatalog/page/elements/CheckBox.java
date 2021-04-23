package ru.project.ekatalog.page.elements;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public interface CheckBox {
     ElementsCollection manufacturerFilterCheckBox = $$x("//*[@id=\"manufacturers_presets\"]//label");
     ElementsCollection otherFilterCheckBox = $$x("//*[@class=\"match-li-href\"]/label");
}
