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
public class AssociarEPC {

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
	public void checkEPC() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);

		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
		Thread.sleep(2000);
	
		Assert.assertEquals("ABAFADOR RUIDOS AMARELO 18DB", 
				dsl.obterValorCampo("formCenter:associarTab:inputAtivoProduto"));
		
		Assert.assertEquals("10020", dsl.obterValorCampo("formCenter:associarTab:inputPrefixo"));
	}
	
	@Test
	public void inputEPC() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		
		//Selecionar Produto
		dsl.clicarBotao(By.id("formCenter:associarTab:btSelecionar"));
		Thread.sleep(1000);
		
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "TESTADOR PORTÁTIL");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.escrever("formCenter:associarTab:inputClasseInicial", "11");
		
		Assert.assertEquals("Classe Final:*", dsl.obterTexto("formCenter:associarTab:labelClasseFinal"));
		
		dsl.clicarBotao("button.btn:nth-child(2)");
	}
	
	@Test
	public void removeProduto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		driver.findElement(By.id("formCenter:inputProduto")).sendKeys("TESTADOR PORTÁTIL");
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);

		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(4)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formConfirm:confirmExcluir"));
		Thread.sleep(1000);
		
		dsl.contemTexto(By.tagName("body"), "Registro excluído com sucesso.");
	}
}