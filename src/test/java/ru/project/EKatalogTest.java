package ru.project;


import org.testng.annotations.Test;
import ru.project.ekatalog.base.BaseTest;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class EKatalogTest extends BaseTest {
    @Test(groups = "ekatalog")
    public void eKatalogTest() {
        menuSteps.clickMenuItem("Компьютеры")
                .clickMenuItem("Мониторы");
        filterSteps.inputText("от", 2, "43000")
                .inputText("до", 3, "100000")
                .chooseManufacturerCheckBox("Acer")
                .chooseManufacturerCheckBox("Asus");

    }
}
