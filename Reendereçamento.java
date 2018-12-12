package processo;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

import org.junit.After;

public class Reendereçamento {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void open() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://hml.plug.cabtecgti.com.br/wms/login.jsp");
		dsl = new DSL(driver);
	}
	
	@After
	public void exit(){
		driver.quit();
	}
	
	@Test
	public void reenderecamento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		Assert.assertEquals("Reendereçamento", 
				driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(3)")).getText());
		
		dsl.clicarBotao("div.ui-button:nth-child(2) > span:nth-child(2)");
		dsl.escrever("formCenter:dtLote:0:inputIdAtivoFisico", "248426");
		dsl.limparCampo("formCenter:inputTamanhoLote");
		Thread.sleep(1000);
		dsl.escrever("formCenter:inputTamanhoLote", "1");
		
		dsl.clicarBotao(By.id("formCenter:btReconfigurar"));	
		Thread.sleep(1000);
		Assert.assertEquals("ANILHA IDENTIF NUMERO 8", 
				dsl.obterTexto("formCenter:dtLote:0:txtProduto"));
		Thread.sleep(1000);
		dsl.escrever("formCenter:dtLote:0:inputNovoEndereco", "01-01-133");
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		Assert.assertEquals("Produtos reendereçados com sucesso.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
	
		Thread.sleep(1000);
		dsl.clicarBotao("button.pull-right");
		Thread.sleep(1000);
		dsl.clicarBotao("div.ui-button:nth-child(2) > span:nth-child(2)");
		dsl.escrever("formCenter:dtLote:0:inputIdAtivoFisico", "248426");
		dsl.limparCampo("formCenter:inputTamanhoLote");
		Thread.sleep(1000);
		dsl.escrever("formCenter:inputTamanhoLote", "1");
		
		dsl.clicarBotao(By.id("formCenter:btReconfigurar"));	
		Thread.sleep(1000);
		Assert.assertEquals("ANILHA IDENTIF NUMERO 8", 
				dsl.obterTexto("formCenter:dtLote:0:txtProduto"));
		Thread.sleep(1000);
		dsl.escrever("formCenter:dtLote:0:inputNovoEndereco", "01-01-090");
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(2)");
	}
}