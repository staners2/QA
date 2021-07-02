package info.esoft.pizza.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MyAccountPage {
    SelenideElement linkCloseModalWindow = $x("//a[@class='modal-dialog-close']");
    public MyAccountPage(){

    }

    public MainPage closeModalWindow(){
        linkCloseModalWindow.click();
        return new MainPage();
    }
}
