package ru.project.ekatalog.page.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public interface TextFieldPage {


     static ElementsCollection field(String nameField){
         return  $$x("//*[text() = '"+nameField+"']/parent::*//input[@type = 'text']");
     }


}
