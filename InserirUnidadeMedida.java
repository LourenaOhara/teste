package processo;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

import org.junit.Assert;
import org.junit.After;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InserirUnidadeMedida {
	
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
	public void a_visualizarUnidadeMedida() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputNome", "PAA");
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-widget-content:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.contemTexto(By.id("formCenter:inputNome"), "PAA");
	}
	
	@Test
	public void b_InserirUnidadeMedida() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
			
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
			
		dsl.escrever("formCenter:inputNome", "oz");
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
			
		Assert.assertEquals("Registro incluído com sucesso.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
		
	}
	
	@Test
	public void c_RemoveUnidadeMedida() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-widget-content:nth-child(10) > td:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.btn:nth-child(4)");
		Thread.sleep(1000);
			
		dsl.clicarBotao(By.id("formConfirm:confirmExcluir1"));
		Thread.sleep(1000);
			
		Assert.assertEquals("Registro excluído com sucesso.", 
				dsl.obterTexto(By.id("formCenter:msgs_formCenter")));
	}
}