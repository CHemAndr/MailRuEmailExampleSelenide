package org.myexample;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class TestMail {

 @BeforeAll
 static void setup(){
     Configuration.timeout = 60000;
     open(ConfProperties.getProperty("loginpage"));
 }

 @Test
 public void loginTest() {
    LoginPage.loginField.shouldBe(Condition.visible);
    LoginPage.inputLogin(ConfProperties.getProperty("login"));
    LoginPage.pswField.shouldBe(Condition.visible);
    LoginPage.inputPsw(ConfProperties.getProperty("psw"));
    LoginPage.btnX.shouldBe(Condition.visible);
    LoginPage.downWinFoto();
    MailPage.loginText.shouldBe(Condition.exactText(ConfProperties.getProperty("login") + "@mail.ru"));
 }

 @Test
 public void  sendMail(){
    MailPage.writeBtnClk();
    MailPage.inputAddressAndTheme(ConfProperties.getProperty("login") + "@mail.ru", "Автоматическая отправка письма");
    Selenide.switchTo().frame(0);
    MailPage.bodyLetter.shouldBe(Condition.exist);
    MailPage.clTextBody();
    MailPage.inTextBody("Привет от автотеста"+System.getProperty("line.separator"));
    MailPage.inTextBody("--"+System.getProperty("line.separator"));
    MailPage.inTextBody("Selenide");
    Selenide.switchTo().defaultContent();
    MailPage.sendBtnClk();
    MailPage.outMail();
 }

}
