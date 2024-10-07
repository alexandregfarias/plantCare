package br.com.plantcare.atuomation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormularioAutomacaoTest {

	@Test
	public void preencherFormulario() throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://localhost:8080/signup");

			WebElement nomeField = driver.findElement(By.name("nome"));
			nomeField.sendKeys("Alexandre Farias");

			WebElement emailField = driver.findElement(By.name("email"));
			emailField.sendKeys("alexandre@hotmail.com");

			WebElement senhaField = driver.findElement(By.name("senha"));
			senhaField.sendKeys("SenhaForte1!2#3");

			WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
			submitButton.click();

			System.out.println("Formulário preenchido e enviado com sucesso!");

		} finally {
			driver.quit();
		}
	}

}