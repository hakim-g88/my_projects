package com.webVillage.app.webControllers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class IndexControllerTest {
    @LocalServerPort
    private Integer port;

    private String basePath;

    private static WebDriver driver;

    @BeforeEach
    public void getReady() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        basePath = "http://localhost:" + port;
    }

    @Test
    void greeting() throws InterruptedException {

        driver.get("http://localhost:" + port);
        driver.findElement(By.cssSelector(
                "a[href='/person/new']")).click();
        driver.findElement(By.cssSelector(
                "input#firstName")).sendKeys("JOHNN" + Keys.BACK_SPACE);
        driver.findElement(By.cssSelector(
                "input#secondName")).sendKeys("Two");
        driver.findElement(By.cssSelector(
                "input#age")).sendKeys("77");
        driver.findElement(By.cssSelector(
                "select#occupation")).click();
        driver.findElement(By.cssSelector(
                "select#occupation")).findElement(
                By.cssSelector("option[value='DOCTOR']")).click();
        driver.findElement(By.cssSelector(
                "select#gender")).click();
        driver.findElement(By.cssSelector(
                "select#gender")).findElement(
                By.cssSelector("option[value='OTHER']")).click();
        driver.findElement(By.cssSelector(
                "button#doIt")).click();
        Thread.sleep(1000);
        System.out.println(driver.getPageSource());
        driver.get(driver.getCurrentUrl());
        String name = driver.findElement(By.cssSelector(
                "h2#name")).getText();
        assertEquals(name, "NAME: JOHN Two");
        String work = driver.findElement(By.cssSelector(
                "h3#occupation")).getText();
        assertEquals(work, "OCCUPATION: doctor");
        String age = driver.findElement(By.cssSelector(
                "h3#age")).getText();
        assertEquals(age, "AGE: 77");
        System.out.println(driver.getPageSource());
    }

    @AfterEach
    public void endTest() {
        driver.quit();
    }
}
