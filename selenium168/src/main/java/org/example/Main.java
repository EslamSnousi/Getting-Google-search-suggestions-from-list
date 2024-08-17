package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        WebElement searchBar = driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("hello");

        // Wait for the suggestions to load
        try {
            Thread.sleep(2000); // You can replace this with explicit wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> suggestions = driver.findElements(By.xpath("//span[contains(.,'ello')]"));

        // Print each suggestion
        System.out.println(suggestions.size());
        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }
    }
}