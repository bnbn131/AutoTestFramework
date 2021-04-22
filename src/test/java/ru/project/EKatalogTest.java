package ru.project;


import org.testng.annotations.Test;
import ru.project.ekatalog.base.BaseTest;

public class EKatalogTest extends BaseTest {
    @Test
    public void eKatalogTest() {
        menuSteps.clickMenuItem("Компьютеры")
                .clickMenuItem("Мониторы");
        filterSteps.inputText("от", 2, "43000")
                .inputText("до", 3, "100000")
                .chooseManufacturerCheckBox("Acer")
                .chooseManufacturerCheckBox("Asus")
                .chooseManufacturerCheckBox("MSI")
                .chooseManufacturerCheckBox("Xiaomi")
                .chooseCheckBox("игровой монитор");    }
}
