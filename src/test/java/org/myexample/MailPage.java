package org.myexample;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MailPage {

    public static SelenideElement

            //Поле логина
            loginText = $(byId("PH_user-email")),
            // Кнопка написать письмо
            writeBtn = $(byXpath("//span[text()='Написать письмо']")),
            //Поле ввода "Кому"
            fieldTo = $(byXpath("//textarea[contains(@class,'js-input compose__labels__input')]")),
            //Поле ввода "Тема"
            fieldTheme =$(byXpath("//input[contains(@class,'b-input')]")),
            // Кнопка "Отправить"
            sendBtn = $(byXpath("//span[text()='Отправить']")),
            // Тело письма
            bodyLetter =$(byId("tinymce")),
            //Кнопка "Выход"
            outBtn = $(byId("PH_logoutLink"));


    //Нажать кнопку "Написать письмо"
    public static void writeBtnClk() { writeBtn.click(); }

    //Ввод адреса получателя и темы письма
    public  static  void inputAddressAndTheme(String Address, String Theme){
            fieldTo.setValue(Address);
            fieldTheme.setValue(Theme);
    }

    //Стереть поле тела письма
    public static void clTextBody() { bodyLetter.clear(); }

    //Ввод тела письма
    public static void  inTextBody(String Text) {
            bodyLetter.click();
            bodyLetter.sendKeys(Text);
    }

    // Нажать кнопку "Отправить"
    public static void sendBtnClk() {
                sendBtn.click();
        }

    // Нажатие кнопки "Выход"
    public static void outMail() { outBtn.click(); }
}
