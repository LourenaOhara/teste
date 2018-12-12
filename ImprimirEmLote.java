package cadastro;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImprimirEmLote {

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
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao(By.id("formCenter:tab:btPsqProdDg"));
		Thread.sleep(2000);
		
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-datatable-selectable:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
			
		/*Armazém*/
		//dsl.clicarBotao(By.id("formCenter:tab:dtAtivo:0:comboArmazem_label"));
		//dsl.clicarBotao(By.xpath("//div[7]/div/ul/li[2]"));
		//Thread.sleep(1000);
		
		/*Quantidade de Etiquetas*/
		dsl.limparCampo("formCenter:tab:dtAtivo:0:inputQtd");
		dsl.escrever("formCenter:tab:dtAtivo:0:inputQtd", "100");
		Thread.sleep(1000);
		
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		dsl.clicarBotao("li.ui-state-default:nth-child(1) > a:nth-child(1)");
		dsl.clicarBotao(By.id("btnImprimir"));
		Thread.sleep(1000);
		
		
		dsl.clicarBotao(By.id("formConfirm:declineImprimir"));
		Thread.sleep(1000);
		
		//Informações aba Visualizar Impressões Agendadas
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		
		String conteudo = dsl.obterTexto("formCenter:tab:idListaImpressaoEmLote_head");
		assertTrue(conteudo.contains("ID"));
		assertTrue(conteudo.contains("Data da Solicitação"));
		assertTrue(conteudo.contains("Solicitante"));
		assertTrue(conteudo.contains("Status"));
		assertTrue(conteudo.contains("Mensagem"));
		assertTrue(conteudo.contains("Relatório de Impressão"));
	}
}