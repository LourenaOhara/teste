package cadastro;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import abrirTelas.DSL;
import org.junit.After;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImprimirEtiqueta {

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
	public void checkEtiqueta() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(10) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
		Thread.sleep(2000);
		
		Assert.assertEquals("ABAFADOR RUIDOS AMARELO 18DB", 
				dsl.obterValorCampo("formCenter:inputProduto"));
		
		Assert.assertEquals("SGTIN", dsl.obterValorCampo("formCenter:inputTipoSchema"));
		
		/*Armazém*/
		//dsl.clicarBotao(By.id("formCenter:comboArmazem_label"));
		//dsl.clicarBotao(By.xpath("//div[4]/div/ul/li[2]"));
		//Thread.sleep(1000);
		
		/*Quantidade de Etiquetas*/
		dsl.escrever("formCenter:imprimirCodificar:qtdeEtiquetas", "100");
		
		Assert.assertEquals("Imprimir Etiqueta", 
				dsl.obterTexto("formCenter:imprimirCodificar:btIMprimirEtiquetas"));
	}
}