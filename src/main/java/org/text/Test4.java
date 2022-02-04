package org.text;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Test4
{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.kinopoisk.ru/");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);


        driver.findElement(By.xpath(".//a[text()='Кассовые сборы']")).click();

        driver.findElement(By.xpath(".//select[@name='year']")).click();
        driver.findElement(By.xpath(".//option[@value='2021']")).click();
        driver.findElement(By.xpath(".//a[starts-with(@onclick, 'document.form_box_year.submit')]")).click();



    }
}