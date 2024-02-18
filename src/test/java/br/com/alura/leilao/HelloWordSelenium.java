package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWordSelenium {
    @Test
    public void Hello() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Herick\\eclipse-workspace\\selenium-java\\drivers\\chromedriver.exe");        
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/leiloes");
        driver.quit();
    }
}
