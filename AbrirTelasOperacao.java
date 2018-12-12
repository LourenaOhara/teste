package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasOperacao {

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
	public void recebimento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Recebimento
		Assert.assertEquals("Recebimento", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		// localiza texto número recebimento
		dsl.contemTexto(By.id("formCenter:labelNumRecebimento"), "Número Recebimento");
		
		// localiza texto número conhecimento
		dsl.contemTexto(By.id("formCenter:labelNumConhecimento"), "Número de Conhecimento");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoRecebimento()throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		
		Thread.sleep(2000);
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Recebimento rápido
		dsl.contemTexto(By.id("formCenter:recebimentoTabView:labelRecebRapido"), "Recebimento rápido");
		
		//localiza texto Quantidade de etapas
		dsl.contemTexto(By.id("formCenter:recebimentoTabView:labelQtdEtapas"), "Quantidade de etapas");
		
		//Abrir aba Documentos
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//Abrir aba Ressalvas
		driver.findElement(By.cssSelector("li.ui-state-default:nth-child(3) > a:nth-child(1)")).click();
		Thread.sleep(2000);
		
		//Abrir aba Parecer
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
	}
	
	@Test
	public void notaFiscal() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Nota Fiscal
		Assert.assertEquals("Nota Fiscal", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto periodo
		dsl.contemTexto(By.id("formCenter:j_id_2c"), "Período");
		
		//localiza texto remetente
		dsl.contemTexto(By.id("formCenter:remetente:labelRadioTipoPessoa"), "Remetente");
		Thread.sleep(2000);
	}
	
	@Test
	public void iniciarRecebimento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Iniciar Recebimento
		Assert.assertEquals("Iniciar Recebimento", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Todos
		dsl.contemTexto(By.id("formCenter:j_id_2v"), "Todos");
		
		//localiza texto Status
		dsl.contemTexto(By.id("formCenter:labelAutorizados"), "Apenas Autorizados");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void iniciarAuditoria() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Auditoria
		Assert.assertEquals("Auditoria", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Período
		dsl.contemTexto(By.id("formCenter:labelData"), "Período");

		Thread.sleep(3000);
	}
	
	@Test
	public void armazenar() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Armazenar
		Assert.assertEquals("Armazenar", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Período
		dsl.contemTexto(By.id("formCenter:labelData"), "Período");

		Thread.sleep(2000);
	}
	
	@Test
	public void expedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Expedição
		Assert.assertEquals("Expedição", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Observação
		dsl.contemTexto(By.id("formCenter:labelObservacoes"), "Observação");
		
		//localiza texto Data Agendamento
		dsl.contemTexto(By.id("formCenter:labelData"), "Data Agendamento");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoExpedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		
		Thread.sleep(2000);		
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto CEP
		Assert.assertEquals("Expedição", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		Thread.sleep(1000);
		//localiza texto Logradouro
		dsl.contemTexto(By.id("formCenter:expedicaoTabView:labelTipoLogradouto"), "Logradouro");
		
		Thread.sleep(1000);
		//Abre aba Taxas 
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Orientações
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Parecer
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
	}
	
	@Test
	public void separar() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Separar
		Assert.assertEquals("Separar", 
				driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(3)")).getText());
		
		//aciona botão Expedição
		dsl.clicarBotao("div.ui-button:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		
		//aciona botão Mapa
		dsl.clicarBotao("div.ui-button:nth-child(2) > span:nth-child(2)");
		Thread.sleep(3000);
	}
	
	@Test
	public void iniciarExpedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Iniciar Expedição
		Assert.assertEquals("Iniciar Expedição", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//aciona botão Aguardando
		dsl.clicarBotao("div.ui-state-active:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		
		//aciona botão Suspenso
		dsl.clicarBotao("div.ui-state-active:nth-child(2) > span:nth-child(2)");
		Thread.sleep(1000);
		
		//aciona botão Executando
		dsl.clicarBotao("div.ui-button:nth-child(3) > span:nth-child(2)");
		Thread.sleep(3000);
	}
	
	@Test
	public void agrupadorFracionado() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Iniciar Agrupador de Fracionados 
		Assert.assertEquals("Agrupador de Fracionados", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		
	}
	
	@Test
	public void importacaoExpedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(10) > a:nth-child(1)");

		Thread.sleep(2000);
		
		//localiza texto Iniciar Expedição
		Assert.assertEquals("Importação de Expedições", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		Thread.sleep(1000);
		
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//localiza botão Relatório de Importações
		Assert.assertEquals("Relatório de Importações", dsl.obterTexto("formCenter:tab:dtResult:j_id_2i"));	
	}
	
	@Test
	public void novoAgrupadorFracionado() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//acionar botão Adicionar Linhas
		dsl.clicarBotao(By.id("formCenter:btAddLinhas"));
		Thread.sleep(1000);
		
		//localiza texto Usar Mapa de Separação
		dsl.contemTexto(By.id("formCenter:lblUsarMapaSeparacao"), "Usar Mapa de Separação");
	
		Thread.sleep(2000);
	}
	
	@Test
	public void gerarMapa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Separação-Gerar mapa
		Assert.assertEquals("Separação - Gerar mapa", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
	}
	
	@Test
	public void verMapa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(12) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Separação-Ver mapa
		Assert.assertEquals("Separação - Consultar mapa", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
	}
	
	@Test
	public void romaneio() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(16) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Romaneio
		Assert.assertEquals("Romaneio", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));

	}
	
	@Test
	public void novoRomaneio() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(16) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Doca
		dsl.contemTexto(By.id("formCenter:labelDoca"), "Doca");
		Thread.sleep(2000);
		
		//acionar botão Selecionar Expedição
		dsl.executarJS("formCenter:j_id_43");	
		dsl.clicarBotao(By.id("formCenter:panelOperacoes:btselExpedicao"));
	}
	
	@Test
	public void iniciarRomaneio() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(17) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Iniciar Romaneio
		Assert.assertEquals("Iniciar Romaneio", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Etapa
		dsl.contemTexto(By.id("formCenter:panelOperacoes:labelExpedicao"), "Etapa");
		
		//localiza texto Destinatário
		dsl.contemTexto(By.id("formCenter:panelOperacoes:destinatario:labelRadioTipoPessoa"), "Destinatário");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void transferencia() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(18) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Transferência
		Assert.assertEquals("Transferência", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Origem
		dsl.contemTexto(By.id("formCenter:labelOrigem"), "Origem");
		
		//localiza texto Destino
		dsl.contemTexto(By.id("formCenter:labelDestino"), "Destino");	
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoTransferencia() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(18) > a:nth-child(1)");
		
		Thread.sleep(2000);
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//Abre aba Orientações - Saída
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Ressalvas - Entrada
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Parecer
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
	}
	
	@Test
	public void iniciarTransferencia() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(19) > a:nth-child(1)");
		
		Thread.sleep(2000);
	
		//localiza texto Iniciar Transferência
		Assert.assertEquals("Iniciar Transferência", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		Thread.sleep(3000);
	}
	
	@Test
	public void ocorrencia() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(20) > a:nth-child(1)");
		
		Thread.sleep(2000);
		//localiza texto Ocorrência
		Assert.assertEquals("Ocorrência", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo Operação
		dsl.contemTexto(By.id("formCenter:labelTipoOperacao"), "Tipo Operação");
		
		//localiza texto Configuração de Ocorrências
		dsl.contemTexto(By.id("formCenter:labelConfiguracao"), "Configuração de Ocorrências:");

	}
	
	@Test
	public void novoOcorrencia() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(20) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(1000);
		
		//localiza texto Número Operação
		dsl.contemTexto(By.id("formCenter:ocorrenciaTab:labelNumero"), "Número Operação");
		
		//Abre aba Informações adicionais
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(3000);
	}
}