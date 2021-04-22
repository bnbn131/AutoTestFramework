package ru.project;

import org.openqa.selenium.By;


public enum Selector {

    XPATH {
        @Override
        public By buildBy(final String value) {
            return By.xpath(value);
        }
    };

    public abstract By buildBy(String value);

}
