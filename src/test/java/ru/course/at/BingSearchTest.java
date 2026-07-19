package ru.course.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BingSearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openBingAndSearchTest() throws InterruptedException {
        driver.get("https://www.bing.com");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium Java");
        searchField.submit();

        assertTrue(driver.getTitle().contains("Selenium Java"));

        Thread.sleep(10000); // пауза 10 секунд
    }
}