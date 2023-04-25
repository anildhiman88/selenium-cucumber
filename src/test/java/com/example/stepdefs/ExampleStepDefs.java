package com.example.stepdefs;

import com.example.pageClasses.GoogleSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ExampleStepDefs {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @Given("I am on the Google search page")
    public void i_am_on_the_Google_search_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        googleSearchPage = new GoogleSearchPage(driver);
        driver.get("https://www.google.com/");
        driver.findElement(new By.ByName("Accept all")).click();
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        googleSearchPage.enterSearchQuery(query);
        googleSearchPage.clickSearchButton();
    }

    @Then("I should see search results")
    public void i_should_see_search_results() {
        assertTrue(googleSearchPage.isResultsDisplayed());
        driver.quit();
    }
}
