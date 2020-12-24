package org.myexample;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;



// Static Page Objects pattern (Page Modules)
public class LoginPage {

     public static SelenideElement
             //Поле ввода логина
             loginField = $(By.name("username")),
             // Галочка "Запомнить"
             checkBox   = $(By.xpath("//span[text()='запомнить']")),
             // Кнопка "Ввести пароль"
             buttonLg = $(By.xpath("//span[text()='Ввести пароль']")),
             // Поле ввода пароля
             pswField = $(By.name("password")),
             // Кнопка вход
             buttonPsw = $(By.xpath("//span[text()='Войти']")),
             // Кнопка Х на "Загрузка фотографии и создание подписи"
             btnX = $(By.xpath("//div[contains(@class,'icon icon_popup-close')]"));

     //Ввод логина, не запоминем его, нажать кнопку "логин"
     public static void inputLogin(String login){
         loginField.click();
         loginField.setValue(login);
         checkBox.click();
         buttonLg.click();

     }
     //Ввод пароля, нажать кнопку "пароль"
     public static void inputPsw(String psw) {
         pswField.click();
         pswField.setValue(psw);
         buttonPsw.click();

     }
     // Закрыть окно с фото
     public  static  void downWinFoto() {
         btnX.click();
     }

}
