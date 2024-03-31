package com.demoqa.test;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;

import com.codeborne.pdftest.PDF;

import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.helpers.ChangeExtension.changeExtension;
import static io.qameta.allure.Allure.step;

@Tags({@Tag("main")})
public class AlfaBankMaxDepositTest extends TestBase {


    @DisplayName("Display results when searching for max deposit from menu")
    @Test
    @Owner("SDF")
    @Link(value = "Репозиторий тестов", url = "https://github.com/CyberJhin/Project_For_Test_Task")
    void shouldSwitchingToMaxDepositFromMenu() {
        step("Open form alfabank", () -> {
            alfaBankHeaderPage.openPage();
        });

        step("Click on the menu button and click om max deposit", () -> {
            alfaBankHeaderPage.openMenuDeposit()
                    .openMaxDepositFromMenu();

        });

        step("Verify results text", () -> {
            alfaDepositMaxMax.checkTitleAndCalculator();
        });
    }


    @DisplayName("Display results when searching for max deposit from search")
    @Test
    @Owner("SDF")
    @Link(value = "Репозиторий тестов", url = "https://github.com/CyberJhin/Project_For_Test_Task")
    void shouldSwitchingToMaxDepositFromString() {
        step("Open form alfabank", () -> {
            alfaBankHeaderPage.openPage();
        });

        step("Click on the search button and enter a value", () -> {
            alfaBankHeaderPage.setInputValue("Максимальный вклад")
                    .openMaxDepositFromSearch();
            switchTo().window(1);
        });

        step("Verify results text", () -> {
            alfaDepositMaxMax.checkTitleAndCalculator();
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3| 15,00 %",
            "4| 15,50 %",
            "6| 15,20 %",
            "9| 14,40 %",
            "12| 13,90 %",
            "18| 13,71 %",
            "24| 13,70 %",
            "36| 16,00 %",
    }, delimiter = '|')
    @DisplayName("Checking rates depending on the deposit term")
    @Owner("SDF")
    @Link(value = "Репозиторий тестов", url = "https://github.com/CyberJhin/Project_For_Test_Task")
    void checkingRatesDependingTest(String period, String percent) {
        step("Open form alfabank", () -> {
            alfaBankHeaderPage.openPage();
        });

        step("Click on the menu button and click om max deposit", () -> {
            alfaBankHeaderPage.openMenuDeposit()
                    .openMaxDepositFromMenu()
                    .clickPeriodButton(period);
        });

        step("Verify results rate", () -> {
            alfaDepositMaxMax.checkPercent(percent);
        });
    }



    @Test
    @Owner("SDF")
    @Link(value = "Репозиторий тестов", url = "https://github.com/CyberJhin/Project_For_Test_Task")
    void downloadFileFromMaxDepositPageTest() throws Exception {
        open("https://alfabank.ru/make-money/deposits/alfa-vklad/max/");
        File downloadedFile = $("a[data-test-id='detailedConditionsBtn-rub']").download();

        File newFile = changeExtension(downloadedFile, ".pdf");

        PDF pdf = new PDF(newFile);
        Assertions.assertNotNull(pdf.text);
    }
}

