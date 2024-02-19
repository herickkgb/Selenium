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

	private LoginPage pg;

	@BeforeEach
	public void beforeAll() {
		this.pg = new LoginPage();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void fazerLoginComDadosValidos() {
		pg.preencherFormularioLogin("fulano", "pass");

	}

	@Test
	public void loginInvalido() {
		pg.loginInvalido("invalido", "sdf");

	}

	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		pg.naoDeveriaAcessarPaginaRestritaSemEstarLogado("http://localhost:8080/leiloes", "Dados do Leilão");
	}

//	@AfterEach
//	public void after() {
//		this.pg.fechar();
//	}
}
