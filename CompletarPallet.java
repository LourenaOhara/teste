package processo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

public class CompletarPallet {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void open() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://hml.plug.cabtecgti.com.br/wms");
		dsl = new DSL(driver);
	}

	@After
	public void exit(){
		driver.quit();
	}
	
	@Test
	public void produtoSemCompletar() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.limparCampo("formCenter:inputTamanhoCompletarPallet");
		dsl.escrever("formCenter:inputTamanhoCompletarPallet", "1");
		dsl.clicarBotao(By.id("formCenter:btReconfigurar"));
		Thread.sleep(1000);
		
		dsl.escrever("formCenter:dtCompletarPallet:0:inputEndereco", "01-01-021");
		dsl.clicarBotao(By.id("formCenter:dtCompletarPallet:0:inputQuantidade"));
		Thread.sleep(1000);
		Assert.assertEquals("", dsl.obterTexto(By.cssSelector("td.semBordas:nth-child(3)")));	
	}
	
	@Test
	public void completaPallet() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.limparCampo("formCenter:inputTamanhoCompletarPallet");
		dsl.escrever("formCenter:inputTamanhoCompletarPallet", "1");
		dsl.clicarBotao(By.id("formCenter:btReconfigurar"));
		Thread.sleep(1000);
		
		dsl.escrever("formCenter:dtCompletarPallet:0:inputEndereco", "02-02-090");
		dsl.clicarBotao(By.id("formCenter:dtCompletarPallet:0:inputQuantidade"));
		Thread.sleep(1000);
		
		Assert.assertEquals("PRODUTO CABTEC MESCLADO", 
				dsl.obterTexto("formCenter:dtCompletarPallet:0:txtProduto"));
		Thread.sleep(1000);
		dsl.limparCampo("formCenter:dtCompletarPallet:0:inputQuantidade");
		Thread.sleep(1000);
		dsl.escrever("formCenter:dtCompletarPallet:0:inputQuantidade", "10");
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		Assert.assertEquals("Registros salvos com sucesso", dsl.obterTexto("formCenter:msgs_formCenter"));
	}
}