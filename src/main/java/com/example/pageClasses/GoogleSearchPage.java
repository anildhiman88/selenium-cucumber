package com.example.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    private final WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchQuery(String query) {
        searchBox.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isResultsDisplayed() {
        return driver.findElement(By.id("result-stats")).isDisplayed();
    }
}


