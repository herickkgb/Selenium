package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LoginTest {
	String url = "http://localhost:8080/login";
	private WebDriver driver;
	
	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Herick\\eclipse-workspace\\selenium-java\\drivers\\chromedriver.exe");
	}
	
	
	@BeforeEach
	public void before() {
		this.driver  = new ChromeDriver();
		
	}
	

	
	@SuppressWarnings("deprecation")
	@Test
	public void fazerLoginComDadosValidos() {
		driver.get(this.url);
		driver.findElement(By.id("username")).sendKeys("fulano");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.id("login-form")).submit();
		Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/leiloes"));
	//	Assert.assertEquals("fulano", driver.findElement(By.id("usuario-logado")).getText());
		
	}
	
	@Test
	public void loginInvalido() {
		driver.get(this.url);
		driver.findElement(By.id("username")).sendKeys("invalido");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.id("login-form")).submit();

		Assert.assertTrue(driver.getPageSource().contains("Usuário e senha inválidos."));
		//assertEquals("", driver.findElement(By.id("nameLogado")).getText());
		
	}
	@AfterEach
	public void after() {
		this.driver.quit();
	}
}
