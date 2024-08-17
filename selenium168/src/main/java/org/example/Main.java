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

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("hello");
        // use list suggestions if you want to automate it for "hello"
        //  List<WebElement> suggestions = driver.findElements(By.xpath("//span[contains(.,'ello')]"));

        //or Use this to make it general automation
        // Wait for the suggestions list to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement suggList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

//        WebElement suggList = driver.findElement(By.xpath("//ul[@role='listbox']"));
        List <WebElement> suggestions = suggList.findElements(By.tagName("li"));

        // Print each suggestion
//        System.out.println(suggestions.get(1).getText());
//
//        System.out.println(suggestions.size());
        for (int i=0;i< suggestions.size();i++) {
            System.out.println(i+suggestions.get(i).getText());
        }
        System.out.println(suggestions.size());
    }
}
