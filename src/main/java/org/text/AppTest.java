package org.text;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class AppTest
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

        WebElement webElement = driver.findElement(By.xpath(".//div[starts-with(@class, 'styles_root')]/a[@href='/lists/films/1/']"));
        webElement.click();

        driver.findElement(By.xpath(".//span[contains(text(), '250 лучших фильмов')]")).click();
        driver.findElement(By.xpath(".//span[contains(text(), 'Все годы')]")).click();
        driver.findElement(By.xpath(".//a[@href='/lists/top250/2021/?tab=all']")).click();



    }
}

