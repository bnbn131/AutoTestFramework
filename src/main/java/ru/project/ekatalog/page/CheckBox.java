package ru.project.ekatalog.page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public interface CheckBox {
     ElementsCollection manufacturerFilterCheckBox = $$x("//*[@id=\"manufacturers_presets\"]//a");
     ElementsCollection otherFilterCheckBox = $$x("//*[@class=\"match-li-href\"]//a");
}
