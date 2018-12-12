package processo;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import abrirTelas.DSL;
import org.junit.Assert;
import org.junit.After;

public class DadosEndereco {
	
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
	public void pesquisaEnderecoInvalido() throws InterruptedException{
		dsl.loginCabtec();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Dados Endereço
		Assert.assertEquals("Dados Endereço", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		dsl.escrever("formCenter:inputEndereco", "47");
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		
		Thread.sleep(1000);
		
		Assert.assertEquals("Não há dados para a pesquisa executada.", dsl.obterTexto("formCenter:msgs_formCenter"));
	}
	
	@Test
	public void pesquisaEnderecoSemInformacao() throws InterruptedException{
		dsl.loginCabtec();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputEndereco", "01-01-090");
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		
		Thread.sleep(1000);
		
		Assert.assertEquals("Não há dados para a pesquisa executada.", dsl.obterTexto("formCenter:msgs_formCenter"));
	}	
	
	@Test
	public void pesquisaEndereco() throws InterruptedException{
		dsl.loginCabtec();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputEndereco", "01-01-001");
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		
		Thread.sleep(1000);
		
		dsl.contemTexto(By.cssSelector("tr.ui-widget-content:nth-child(4)"), "209167");
	}
}
