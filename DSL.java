package abrirTelas;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class DSL {

	private WebDriver driver;
	
	public DSL(WebDriver driver){
		this.driver = driver;
	}
	
	public void loginFiocruz() throws InterruptedException {
		//insere usuário
		driver.findElement(By.id("j_username")).sendKeys("lourena@eliminatedengue");		
		//insere senha
		driver.findElement(By.id("j_password")).sendKeys("150152");
		//botão entrar
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(2000);
	}
	
	public void loginEmtel() throws InterruptedException {
		//insere usuário
		driver.findElement(By.id("j_username")).sendKeys("lourena@emteltrans");		
		//insere senha
		driver.findElement(By.id("j_password")).sendKeys("150152");
		//botão entrar
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(2000);
	}
	
	public void loginCabtec() throws InterruptedException {
		//insere usuário
		driver.findElement(By.id("j_username")).sendKeys("lourena@cabtec");		
		//insere senha
		driver.findElement(By.id("j_password")).sendKeys("150152");
		//botão entrar
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(2000);
	}
	
	public void contemTexto(By by, String texto){
		assertTrue(driver.findElement(by).getText().contains(texto));
	}
	
	public String obterTexto(By by){
		return driver.findElement(by).getText();
	}
	
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public void escrever(String id, String texto){
		driver.findElement(By.id(id)).sendKeys(texto);
	}
	
	public void clicarBotao(String cssSelector){
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	public void clicarBotaoX(String xpath){
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarBotao(By by){
		driver.findElement(by).click();
	}
	
	public void executarJS(String id){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
				driver.findElement(By.id(id)));
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void limparCampo(String id){
		driver.findElement(By.id(id)).clear();
	}
}
