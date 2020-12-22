package org.myexample;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestMail {

 @BeforeAll
 static void setup(){
     Configuration.timeout = 50000;
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
 }

}
