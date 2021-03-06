package cadastro;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import abrirTelas.DSL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Contratos {

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
	public void checkContrato() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		
		//clica no primeiro contrato listado
		dsl.clicarBotao("tr.ui-widget-content");
		Thread.sleep(2000);
		
		Assert.assertEquals("Light", dsl.obterValorCampo("formCenter:inputNome"));
	}
	
	@Test
	public void inputContrato() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		
		/*Nome*/
		dsl.escrever("formCenter:inputNome", "Contrato de Teste");
		
		/*Fluxo de Operação*/
		dsl.clicarBotao(By.id("formCenter:comboFluxo_label"));
		dsl.clicarBotaoX("//div[4]/div/ul/li[2]");
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		
		dsl.contemTexto(By.tagName("body"), "Registro incluído com sucesso.");
	
	}
	
	@Test
	public void removeContrato() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.escrever("formCenter:inputNome", "Contrato de Teste");
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-widget-content");
		Thread.sleep(2000);
		
		Assert.assertEquals("Contrato de Teste", dsl.obterValorCampo("formCenter:inputNome"));
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(4)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formConfirm:confirmExcluir"));
		Thread.sleep(1000);
		
		dsl.contemTexto(By.tagName("body"), "Registro excluído com sucesso.");
	}
}