package br.com.alura.leilao.linkedin;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginLinkedin {
	@Test
	public void login() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Herick\\eclipse-workspace\\selenium-java\\drivers\\chromedriver.exe");        
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.linkedin.com/");
	        driver.findElement(By.id("session_key")).sendKeys("jucefino9890@gmail.com"); 
	        driver.findElement(By.id("session_password")).sendKeys("Isisqueen@98908002"); 
	        driver.findElement(By.id("sign-in-form__submit-btn")).submit();
	      
	      //  driver.quit();
	}
}
