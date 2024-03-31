package com.demoqa.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AlfaDepositMax {

    SelenideElement titlePage =$("h1[data-test-id='text']"),
            calculator = $("#calculator"),
            percentDeposit= $("span[data-test-id='interestRate-all-value-rub']");
    private  SelenideElement periodBtn;

    public void periodBtnFind(String period) {
        periodBtn = $(By.cssSelector("[data-test-id='period-btn-" + period + "']"));
    }

    public void clickPeriodButton(String period) {
        periodBtnFind(period);
        periodBtn.click();

    }

    public void checkPercent(String percent) {
        percentDeposit.shouldHave(text(percent));
    }


    public void checkTitleAndCalculator() {
        titlePage.shouldHave(text("Альфа-Вклад Максимальный"));
        calculator.shouldHave(text("Ваш доход по Альфа-Вкладу Максимальному"));
    }

}
