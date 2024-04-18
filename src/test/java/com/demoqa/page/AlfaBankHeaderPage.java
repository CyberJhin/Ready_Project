package com.demoqa.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankHeaderPage {

    private final SelenideElement
            menuDeposit = $("[data-test-id='Main-Header-Main-Desktop-container']").find(byText("Вклады")),
            tabSearch =  $(".aexHS > svg"),
            inputSearch =$("[data-test-id='yandexSearchInput']"),
            maxDepositFromMenu =$("[href='/make-money/deposits/alfa-vklad/max/']"),
    //$("[href='https://alfabank.ru/make-money/deposits/alfa-vklad/max/']")
            maxDepositFromSearch =$("[href='https://AlfaBank.ru/make-money/deposits/alfa-vklad/max/']");

    public AlfaBankHeaderPage openMenuDeposit(){
        menuDeposit.hover();
        return this;
    }

    public AlfaBankHeaderPage setInputValue(String value) {
        tabSearch.click();
        inputSearch.setValue(value).pressEnter();

        return this;
    }

    public AlfaDepositMax openMaxDepositFromMenu(){
        maxDepositFromMenu.click();
        return new AlfaDepositMax();
    }

    public AlfaDepositMax openMaxDepositFromSearch(){
        maxDepositFromSearch.click();
        return new AlfaDepositMax();
    }


    public void openPage() {
        open("https://alfabank.ru/");
    }
}