package cadastro;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

import org.junit.After;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Responsavel {

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
	public void checkPessoaResponsavel() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);

		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		
		dsl.contemTexto(By.tagName("body"), "Não há dados para a pesquisa executada.");
	}
	
	@Test
	public void inputPessoaResponsavel() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		
		/*Nome Fantasia*/
		dsl.escrever("formCenter:inputNome", "Lourena Ohara");
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(2)");
	}
	
	@Test
	public void removeResponsavel() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputResponsavel", "Lourena Ohara");
	
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
					
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(2000);
		
		Assert.assertEquals("Lourena Ohara", 
				dsl.obterValorCampo("formCenter:inputNome"));
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(4)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formConfirm:confirmExcluir1"));
		Thread.sleep(1000);
		
		dsl.contemTexto(By.tagName("body"), "Registro excluído com sucesso.");
	}
}