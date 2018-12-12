package fluxo;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Transferencia {

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
	public void a_Receber() throws InterruptedException{
		//Impressão em Lote do Produto
		dsl.loginCabtec();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao(By.id("formCenter:tab:btPsqProdDg"));
		Thread.sleep(1000);
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "IMPRESSORA S4M");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".ui-datatable-selectable > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formCenter:tab:dtAtivo:0:inputQtd", "1");
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		dsl.clicarBotao("li.ui-state-default:nth-child(1) > a:nth-child(1)");
		
		//Preenche os seriais e patrimônios
		
		dsl.clicarBotao(By.id("formCenter:tab:dtAtivo:0:btAdicional"));
		Thread.sleep(1000);
		dsl.escrever("frmDgSerialPatrimonio:dtInfoAdicional:0:inputSerie", "3698715488");
		Thread.sleep(1000);
		dsl.escrever("frmDgSerialPatrimonio:dtInfoAdicional:0:inputPatrimonio", "CAT3698715488");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmDgSerialPatrimonio:j_id_5q"));
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("btnImprimir"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formConfirm:confirmImprimir"));
		
		//Baixar Realtório
		
		Thread.sleep(2000);
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(5000);
		dsl.clicarBotao(By.id("formCenter:tab:btAtualizarItensImpressos"));
		Thread.sleep(2000);
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		String aux = dsl.obterTexto(By.xpath("//span/span/span"));
		String relatorio = aux.substring(aux.length()-3);
		
		//Planejar recebimento
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(2000);
		dsl.clicarBotao("tr:nth-child(1) > td:nth-child(3) > div:nth-child(1)");
		dsl.clicarBotao(By.id("btSel_remetente"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmSelPJ:btPesquisarPJ"));
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formCenter:recebimentoTabView:combMeioTransporte_label"));
		dsl.clicarBotaoX("//div[5]/div/ul/li[3]");
		dsl.clicarBotaoX("//div[4]/div[2]/div/div[1]");
		Thread.sleep(1000);
				
		dsl.clicarBotao(By.id("formCenter:recebimentoTabView:comboQtdEtapas_label"));
		dsl.clicarBotaoX("//div[6]/div/ul/li[2]");
		Thread.sleep(1000);
		dsl.clicarBotaoX("//table/tbody/tr/td[3]/span/button");
		dsl.clicarBotaoX("//table/tbody/tr/td[3]/span/button");
		Thread.sleep(1000);
		dsl.executarJS("formCenter:recebimentoTabView:buttonAutorizado");
		dsl.clicarBotaoX("//div[4]/div[3]/div/div[1]");		
		Thread.sleep(1000);
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		dsl.executarJS("formCenter:recebimentoTabView:dtEtapas");
		dsl.clicarBotao(By.id("formCenter:recebimentoTabView:dtEtapas:0:btAdProdutos"));
				
		Thread.sleep(1000);
		dsl.clicarBotao("button.inputMargin4");
		Thread.sleep(1000);
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "IMPRESSORA S4M");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(2000);
		dsl.clicarBotao("tr.ui-datatable-selectable:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("frmAddProd:dtAtivo:0:qtdeInformada", "1");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAddProd:btSalvarListaProd"));
		Thread.sleep(2000);
		dsl.clicarBotao("button.btn:nth-child(2)");
		
		//Iniciar Recebimento
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		dsl.executarJS("formCenter:panelDtRecebimento");
		dsl.clicarBotao(".ui-datatable-even > td:nth-child(2)");
		Thread.sleep(2000);
		dsl.executarJS("formCenter:recebimentoPanel_content");
		dsl.clicarBotao(".botoesPortal > div:nth-child(1) > button:nth-child(1)");
		Thread.sleep(1000);
		dsl.executarJS("formEntradaManual:btUsarNumeroRelatorio");
		dsl.clicarBotaoX("//div[3]/div[2]/form/div[3]/div/div/div[1]/div[2]/div/div[1]");
		Thread.sleep(1000);
		dsl.escrever("formEntradaManual:inputNumeroRelatorio", relatorio);
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btPesquisar"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btEnviar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".botoesPortal > div:nth-child(3) > button:nth-child(1)");
	}
	
	@Test
	public void b_Transferir() throws InterruptedException{
		//Planejar Transferência
		dsl.loginCabtec();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(18) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao(By.id("formCenter:transferenciaTabView:combOrigem_label"));
		Thread.sleep(1000);
		dsl.escrever("formCenter:transferenciaTabView:combOrigem_filter", "BACKUP");
		Thread.sleep(1000);
		dsl.clicarBotao("li.ui-state-highlight:nth-child(2)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formCenter:transferenciaTabView:combDestino_label"));
		Thread.sleep(1000);
		dsl.escrever("formCenter:transferenciaTabView:combDestino_filter", "CIPALAM");
		Thread.sleep(1000);
		dsl.clicarBotao("li.ui-state-highlight:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formCenter:transferenciaTabView:combMeioTransporte_label"));
		dsl.clicarBotaoX("//div[6]/div/ul/li[2]");
		Thread.sleep(1000);
		
		dsl.clicarBotaoX("//div[3]/div[2]/div/div[1]");
		dsl.clicarBotao(By.id("formCenter:transferenciaTabView:comboQtdEtapas_label"));
		Thread.sleep(1000);
		dsl.clicarBotaoX("//div[12]/div/ul/li[2]");
		Thread.sleep(1000);
		
		dsl.clicarBotaoX("//td[2]/span/button/span[2]");
		dsl.clicarBotaoX("//td[3]/span/button/span[2]");
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formCenter:transferenciaTabView:dtEtapas:0:btAdProdutos"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAddProd:btPsqProdDg"));
		Thread.sleep(1000);
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "IMPRESSORA S4M");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".ui-datatable-selectable > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("frmAddProd:dtAtivo:0:j_id_8x", "1");
		dsl.clicarBotao(By.id("frmAddProd:dtAtivo:0:j_id_8z"));
		Thread.sleep(1000);
		dsl.escrever("frmDgSerialPatrimonio:dtInfoAdicional:0:inputSerie", "3698715488");
		dsl.clicarBotao(By.id("frmDgSerialPatrimonio:btFechar"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAddProd:btSalvarListaProd"));
		Thread.sleep(2000);
		String transferencia = dsl.obterTexto("formCenter:transferenciaTabView:inputNumTransferencia");
		
		//Iniciar Transferência
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(19) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputNumTransferencia", transferencia);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.executarJS("formCenter:panelDtTransferencia");
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(3000);
		dsl.clicarBotao(".botoesPortal > div:nth-child(1) > button:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btGerar"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btEnviar"));
		Thread.sleep(2000);
		dsl.clicarBotao(".botoesPortal > div:nth-child(3) > button:nth-child(1)");
		Thread.sleep(2000);
	}
}