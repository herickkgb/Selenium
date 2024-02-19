package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LoginPage {
	String url = "http://localhost:8080/";
	private WebDriver driver;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Herick\\eclipse-workspace\\selenium-java\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.navigate().to(url);
	}

	public void fechar() {
		this.driver.quit();
	}

	public void preencherFormularioLogin(String nome, String senha) {
		driver.navigate().to(this.url + "login");
		driver.findElement(By.id("username")).sendKeys(nome);
		driver.findElement(By.id("password")).sendKeys(senha);
		driver.findElement(By.id("login-form")).submit();
		Assert.assertTrue(driver.getCurrentUrl().equals(this.url + "leiloes"));
		// Assert.assertEquals("fulano",
		// driver.findElement(By.id("usuario-logado")).getText());

	}

	public void loginInvalido(String nome, String senha) {
		driver.navigate().to(this.url + "login");
		driver.findElement(By.id("username")).sendKeys(nome);
		driver.findElement(By.id("password")).sendKeys(senha);
		driver.findElement(By.id("login-form")).submit();
		Assert.assertTrue(driver.getPageSource().contains("Usuário e senha inválidos."));

	}

	@SuppressWarnings("deprecation")
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado(String url, String texto) {
		driver.navigate().to(this.url + "leiloes");
		Assert.assertTrue(driver.getCurrentUrl().equals(url));
		Assert.assertFalse(driver.getPageSource().contains(texto));

	}



}
