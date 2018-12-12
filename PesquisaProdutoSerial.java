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

public class PesquisaProdutoSerial {
	
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
	public void pesquisaVazia() throws InterruptedException{
		dsl.loginFiocruz();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button.pull-right:nth-child(3)")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals("Informe ao menos um número serial ou patrimonial.", 
				driver.findElement(By.id("formCenter:msgs_formCenter")).getText());	
	}
	@Test
	public void pesquisaSemDados() throws InterruptedException{
		dsl.loginFiocruz();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:tagsSerie_tag", "1234567");
		dsl.clicarBotao(By.id("formCenter:tagsPatrimonio_tagsinput"));
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Não há dados para a pesquisa executada.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
	}
	@Test
	public void pesquisaSerialValido() throws InterruptedException{
		dsl.loginFiocruz();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:tagsSerie_tag", "478963");
		dsl.clicarBotao(By.id("formCenter:tagsPatrimonio_tagsinput"));
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.executarJS("formCenter:dtResult");
		Thread.sleep(1000);
		dsl.contemTexto(By.cssSelector("tr.ui-widget-content > td:nth-child(1)"), "Desumidificador");
		Thread.sleep(1000);
		
		dsl.contemTexto(By.cssSelector("tr.ui-widget-content > td:nth-child(2)"), "478963");
		Thread.sleep(1000);
	
		dsl.contemTexto(By.cssSelector("tr.ui-widget-content > td:nth-child(5)"), "248425");
		Thread.sleep(1000);
	}
}