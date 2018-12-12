package fluxo;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import abrirTelas.DSL;
import org.junit.After;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmtelMesclado {

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
		//Impressão em Lote
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		Thread.sleep(2000);
				
		dsl.clicarBotao(By.id("formCenter:tab:btPsqProdDg"));
		Thread.sleep(1000);
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "MESCLADO CHEIO");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".ui-datatable-selectable > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formCenter:tab:dtAtivo:0:inputQtd", "50");
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		dsl.clicarBotao("li.ui-state-default:nth-child(1) > a:nth-child(1)");
				
		dsl.clicarBotao(By.id("btnImprimir"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formConfirm:confirmImprimir"));
				
		//Baixar Realtório
				
		Thread.sleep(2000);
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
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
		Thread.sleep(1000);
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
		dsl.executarJS("formCenter:recebimentoTabView:dtEtapas");
		/*Etapa de seleção de Armazém: quando existir só um, comentar linhas 92 à 95*/
		dsl.clicarBotao(By.id("formCenter:recebimentoTabView:dtEtapas:0:comboArmazem_label"));
		Thread.sleep(1000);
		dsl.clicarBotaoX("//div[12]/div/ul/li[2]");
		dsl.clicarBotaoX("//tbody/tr/td[3]/span/button");
		dsl.clicarBotaoX("//tbody/tr/td[3]/span/button");
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
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "MESCLADO CHEIO");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(2000);
		dsl.clicarBotao("tr.ui-datatable-selectable:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("frmAddProd:dtAtivo:0:qtdeInformada", "50");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAddProd:btSalvarListaProd"));
		Thread.sleep(2000);
		dsl.clicarBotao("button.btn:nth-child(2)");
		String recebimento =
				dsl.obterValorCampo("formCenter:recebimentoTabView:inputNumRecebimento");
		
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
		dsl.clicarBotao(By.id("frmInfoArmazem:comboDoca_label"));
		dsl.clicarBotaoX("//div[6]/div/ul/li[2]");
		dsl.clicarBotao(By.id("frmInfoArmazem:btSalvar"));
		Thread.sleep(2000);
		dsl.executarJS("formCenter:recebimentoPanel_content");
		dsl.clicarBotao("div.col-sm-1:nth-child(7) > div:nth-child(1) > button:nth-child(1)");
		dsl.executarJS("formEntradaManual:btUsarNumeroRelatorio");
		dsl.clicarBotaoX("//form/div[3]/div/div/div[1]/div[2]/div/div[1]/span");
		Thread.sleep(1000);
		dsl.escrever("formEntradaManual:inputNumeroRelatorio", relatorio);
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btPesquisar"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btEnviar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".botoesPortal > div:nth-child(3) > button:nth-child(1)");
				
		//Armazenar
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(1000);
				
		dsl.escrever("formCenter:inputNumRecebimento", recebimento);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
				
		dsl.clicarBotao(".ui-datatable-selectable > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.executarJS("formCenter:recebimentoTabView:dtAtivosEtapa_data");
		dsl.clicarBotao(".ui-datatable-even > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAtivoFisicoPorEndereco:btArmazenarTodos"));
		Thread.sleep(1000);
	}
	
	@Test
	public void b_Expedicao() throws InterruptedException{	
		//Planejar Expedição
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotaoX("//td[3]/div/div[2]");
		dsl.clicarBotao(By.id("btSel_remetente"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmSelPJ:btPesquisarPJ"));
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
		Thread.sleep(2000);
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:combMeioTransporte_label"));
		dsl.clicarBotaoX("//div[5]/div/ul/li[3]");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
				driver.findElement(By.id("formCenter:expedicaoTabView:labelExpedRapida")));
		Thread.sleep(2000);
		dsl.clicarBotaoX("//div[6]/div[1]/div/div[1]");
		dsl.clicarBotaoX("//div[6]/div[2]/div/div[1]");
		
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:comboQtdEtapas_label"));
		dsl.clicarBotaoX("//div[6]/div/ul/li[2]");
		Thread.sleep(1000);
		/*Etapa de seleção de Armazém: quando existir só um, comentar linhas 202 à 203*/
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:dtEtapas:0:comboArmazem_label"));
		dsl.clicarBotaoX("//div[17]/div/ul/li[2]");
		
		dsl.clicarBotaoX("//td[3]/span/button");
		dsl.clicarBotaoX("//td[3]/span/button");
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
	
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:dtEtapas:0:btAdProdutos"));
		Thread.sleep(1000);
		dsl.clicarBotao("button.inputMargin4");
		Thread.sleep(1000);
		driver.findElement(By.id("frmSelProd:inputPsqAtivoNome")).sendKeys("MESCLADO CHEIO");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-datatable-selectable:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("frmAddProd:dtAtivo:0:qtdeInformada", "20");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAddProd:btSalvarListaProd"));
		Thread.sleep(2000);
		dsl.executarJS("botoesAcao");
		String expedicao = dsl.obterValorCampo("formCenter:expedicaoTabView:inputNumExpedicao"); 
		dsl.clicarBotao("button.btn:nth-child(2)");
		
		//Separar
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("div.ui-button:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formCenter:idExpedicao", expedicao);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(1000);
		String aux = dsl.obterTexto("formCenter:GTI");
		String codigo = aux.substring(aux.length()-6);
		
		dsl.escrever("formCenter:inputGTI", codigo);
		dsl.escrever("formCenter:inputQuantidadeFracionada", "20");
		dsl.clicarBotao(By.id("formCenter:btConfirmarGTI"));
		Thread.sleep(1000);
		
		//Ver Mapa
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.escrever("formCenter:inputExpdNumero", expedicao);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		String mapa = dsl.obterTexto(By.cssSelector("tr.ui-widget-content > td:nth-child(1)"));
		System.out.println(mapa);
		Thread.sleep(1000);
		
		//Agrupador de Fracionados
		
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		
		Thread.sleep(1000);
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formCenter:inputNome", "AUTOMATIZADO");
		dsl.escrever("formCenter:inputIdMapaSeparacao", mapa);
		dsl.clicarBotao(By.id("formCenter:btCopiarMapaSeparacao"));
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		
		String agrupador = dsl.obterTexto("formCenter:inputCodigo");
		Thread.sleep(1000);
		
		//Iniciar Expedição
		
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formCenter:opt3"));
		dsl.escrever("formCenter:inputExpdNumero", expedicao);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		dsl.executarJS("formCenter:panelDtExpedicao");
		dsl.clicarBotao(".ui-datatable-even > td:nth-child(1)");
		Thread.sleep(2000);
		dsl.executarJS("formCenter:buttonsPanel_content");
		dsl.clicarBotao(".botoesPortal > div:nth-child(1) > button:nth-child(1)");
		Thread.sleep(2000);
		dsl.clicarBotao(By.id("frmInfoArmazem:comboDoca_label"));
		dsl.clicarBotaoX("//div[5]/div/ul/li[2]");
		dsl.clicarBotao(By.id("frmInfoArmazem:btSalvar"));
		Thread.sleep(2000);
		dsl.clicarBotao("div.col-sm-1:nth-child(7) > div:nth-child(1) > button:nth-child(1)");
		Thread.sleep(1000);
		driver.findElement(By.id("formEntradaManual:tagsEntradaManual_tag")).sendKeys(agrupador);
		dsl.executarJS("formEntradaManual:btUsarNumeroRelatorio");
		dsl.clicarBotaoX("//form/div[3]/div/div/div[1]/div[2]/div/div[2]/span");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btEnviar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".botoesPortal > div:nth-child(3) > button:nth-child(1)");
		Thread.sleep(1000);
		//
		// Realizar nova expedição com o restante dos produtos
		//
		
		//Planejar Expedição
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotaoX("//td[3]/div/div[2]");
		dsl.clicarBotao(By.id("btSel_remetente"));
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmSelPJ:btPesquisarPJ"));
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
		Thread.sleep(2000);
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:combMeioTransporte_label"));
		dsl.clicarBotaoX("//div[5]/div/ul/li[3]");
		dsl.executarJS("formCenter:expedicaoTabView:labelExpedRapida");
		Thread.sleep(2000);
		dsl.clicarBotaoX("//div[6]/div[1]/div/div[1]");
		dsl.clicarBotaoX("//div[6]/div[2]/div/div[1]");
				
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:comboQtdEtapas_label"));
		dsl.clicarBotaoX("//div[6]/div/ul/li[2]");
		Thread.sleep(1000);
		/*Etapa de seleção de Armazém: quando existir só um, comentar linhas 342 à 344*/
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:dtEtapas:0:comboArmazem_label"));
		dsl.clicarBotaoX("//div[17]/div/ul/li[2]");
		dsl.clicarBotaoX("//td[3]/span/button");
		dsl.clicarBotaoX("//td[3]/span/button");
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
			
		dsl.clicarBotao(By.id("formCenter:expedicaoTabView:dtEtapas:0:btAdProdutos"));
		Thread.sleep(1000);
		dsl.clicarBotao("button.inputMargin4");
		Thread.sleep(1000);
		dsl.escrever("frmSelProd:inputPsqAtivoNome", "MESCLADO CHEIO");
		dsl.clicarBotao(By.id("frmSelProd:btPsqBuscar"));
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-datatable-selectable:nth-child(1) > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("frmAddProd:dtAtivo:0:qtdeInformada", "30");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("frmAddProd:btSalvarListaProd"));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", 
		driver.findElement(By.id("botoesAcao")));
		String expedicao2 = 
				dsl.obterValorCampo("formCenter:expedicaoTabView:inputNumExpedicao");
		dsl.clicarBotao("button.btn:nth-child(2)");
				
		//Separar
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
				
		dsl.clicarBotao("div.ui-button:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formCenter:idExpedicao", expedicao2);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(1000);
		String aux2 = dsl.obterTexto("formCenter:GTI");
				String codigo2 = aux2.substring(aux2.length()-6);
				
		dsl.escrever("formCenter:inputGTI", codigo2);
		dsl.escrever("formCenter:inputQuantidadeFracionada", "30");
		dsl.clicarBotao(By.id("formCenter:btConfirmarGTI"));
		Thread.sleep(1000);
		
		//Ver Mapa
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		
		dsl.escrever("formCenter:inputExpdNumero", expedicao2);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
				
		String mapa2 = dsl.obterTexto(By.cssSelector("tr.ui-widget-content > td:nth-child(1)"));
		Thread.sleep(1000);
				
		//Agrupador de Fracionados
				
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
				
		Thread.sleep(1000);
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formCenter:inputNome", "AUTOMATIZADO");
		dsl.escrever("formCenter:inputIdMapaSeparacao", mapa2);
		dsl.clicarBotao(By.id("formCenter:btCopiarMapaSeparacao"));
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
				
		String agrupador2 = dsl.obterTexto("formCenter:inputCodigo")	;
		Thread.sleep(1000);
				
		//Iniciar Expedição
				
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(1000);
				
		dsl.clicarBotao(By.id("formCenter:opt3"));
		dsl.escrever("formCenter:inputExpdNumero", expedicao2);
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		dsl.executarJS("formCenter:panelDtExpedicao");
		dsl.clicarBotao(".ui-datatable-even > td:nth-child(1)");
		Thread.sleep(2000);
		dsl.executarJS("formCenter:buttonsPanel_content");
		dsl.clicarBotao(".botoesPortal > div:nth-child(1) > button:nth-child(1)");
		Thread.sleep(2000);
		dsl.clicarBotao(By.id("frmInfoArmazem:comboDoca_label"));
		dsl.clicarBotaoX("//div[5]/div/ul/li[2]");
		dsl.clicarBotao(By.id("frmInfoArmazem:btSalvar"));
		Thread.sleep(2000);
		dsl.clicarBotao("div.col-sm-1:nth-child(7) > div:nth-child(1) > button:nth-child(1)");
		Thread.sleep(1000);
		dsl.escrever("formEntradaManual:tagsEntradaManual_tag", agrupador2);
		dsl.executarJS("formEntradaManual:btUsarNumeroRelatorio");
		dsl.clicarBotaoX("//form/div[3]/div/div/div[1]/div[2]/div/div[2]/span");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formEntradaManual:btEnviar"));
		Thread.sleep(1000);
		dsl.clicarBotao(".botoesPortal > div:nth-child(3) > button:nth-child(1)");
		Thread.sleep(1000);
	}
}