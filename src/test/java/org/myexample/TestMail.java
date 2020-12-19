package org.myexample;


import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestMail {

 @BeforeAll
 static void setup(){

  open(ConfProperties.getProperty("loginpage"));
 }

}
