package processo;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import abrirTelas.DSL;
import org.junit.Assert;
import org.junit.After;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InserirSerialPatrimonial {
	
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
	public void insereSerialPatrimonial() throws InterruptedException{
		dsl.loginFiocruz();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);

		/*
		 * BUG
		driver.findElement(By.id("formCenter:inputQuantidade")).clear();
		driver.findElement(By.id("formCenter:inputQuantidade")).sendKeys("1");
		driver.findElement(By.id("formCenter:btConfigurar")).click();
		*/
		
		dsl.escrever("formCenter:dtAtivo:0:inputIdAtivoFisico", "248054");
		dsl.clicarBotao("tr.ui-widget-content:nth-child(1) > td:nth-child(3)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Ácido propiônico 500 ml", 
				dsl.obterTexto("formCenter:dtAtivo:0:txtProduto"));
		dsl.limparCampo("formCenter:dtAtivo:0:inputSerial");
		Thread.sleep(1000);
		dsl.escrever("formCenter:dtAtivo:0:inputSerial", "659832");
		Thread.sleep(1000);
		dsl.limparCampo("formCenter:dtAtivo:0:inputPatrimonio");
		Thread.sleep(1000);
		dsl.escrever("formCenter:dtAtivo:0:inputPatrimonio", "FC659832");
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
	}	
}