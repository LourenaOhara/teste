package processo;
import java.util.List;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import abrirTelas.DSL;
import org.junit.After;

public class ConfereEstoque {
	
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

	/*@Test
	public void pesquisaEstoqueSemDados() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Informe um Armazém.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
	}*/
	@Test
	public void pesquisaEstoqueTotal() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//dsl.clicarBotao(By.id("formCenter:comboArmazem_label"));
		//dsl.clicarBotaoX("/html/body/div[4]/div/ul/li[2]");
		
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		WebElement listaProdutos = driver.findElement(By.id("formCenter:dtResult_data"));
		 List<WebElement> tr = listaProdutos.findElements(By.cssSelector("tr"));
		 for (WebElement linha : tr)
			 System.out.println(linha.getText());
	}
	
	@Test
	public void pesquisaEstoquePorProduto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputProduto", "ANILHA IDENTIF LETRA R");
		//dsl.clicarBotao(By.id("formCenter:comboArmazem_label"));
		//dsl.clicarBotaoX("//div[4]/div/ul/li[2]");
		
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(".ui-datatable-even > td:nth-child(1)");
		Thread.sleep(1000);
		
		Assert.assertEquals("ANILHA IDENTIF LETRA R", dsl.obterValorCampo("formCenter:inputProduto"));
		Assert.assertEquals("Produto acabado", dsl.obterValorCampo("formCenter:inputTipoStatus"));
		Assert.assertEquals("13", dsl.obterValorCampo("formCenter:textQtdDisponivel"));
		Assert.assertEquals("7", dsl.obterValorCampo("formCenter:textQtdReservada"));
		
	}
}