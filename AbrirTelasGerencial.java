package abrirTelas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasGerencial {

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
	public void gerenciarArmazem() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Gerenciar Armazém/Depósito
		Assert.assertEquals("Gerenciar Armazém/Depósito", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
	}
	
	@Test
	public void novoGerenciarArmazem() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
	
		Thread.sleep(2000);
		
		//Localiza texto Quantidade de Trabalhadores
		Assert.assertEquals("Quantidade de Trabalhadores:*", 
				dsl.obterTexto("formCenter:armazemTabView:labelQtdTrabalhador"));
		
		//Abrir aba Docas
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		
		//localiza texto Tipo Doca
		Assert.assertEquals("Tipo Doca:*", dsl.obterTexto("formCenter:armazemTabView:labelTipoDoca"));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void configuracaoComissao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
	
		//localiza texto Gerenciar Configuração de Comissão
		Assert.assertEquals("Configuração de Comissão", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
	}
	
	@Test
	public void novoConfiguracaoComissao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
	
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
		
		Thread.sleep(2000);
		
		//Localiza texto Regra Comissão
		Assert.assertEquals("Regra Comissão:*", dsl.obterTexto("formCenter:labelRegraComissao"));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void estoque() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Gerenciar Estoque
		Assert.assertEquals("Estoque", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//Localiza texto Fabricante
		Assert.assertEquals("Fabricante:", dsl.obterTexto("formCenter:labelFabricante"));
		
		//Localiza texto Modelo
		Assert.assertEquals("Modelo:", dsl.obterTexto("formCenter:labelModelo"));
		
		//Localiza texto Status Cadastro
		Assert.assertEquals("Status Cadastro:", dsl.obterTexto("formCenter:labelStatusCadastro"));
	}
	@Test
	public void inventario() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Gerenciar Configuração de Comissão
		Assert.assertEquals("Inventário", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));	
	}
	
	@Test
	public void novoInventario() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//Localiza texto Modo Código de Barras
		Assert.assertEquals("Modo Código de Barras*:", dsl.obterTexto("formCenter:labelModoBarcode"));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void iniciarInventario() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");

		Thread.sleep(2000);
	
		//localiza texto Iniciar Inventário
		Assert.assertEquals("Iniciar Inventário", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
	}
	
	@Test
	public void distancias() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Distâncias
		Assert.assertEquals("Distâncias", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//Localiza texto Distância (km)
		Assert.assertEquals("Distância (km):", dsl.obterTexto("formCenter:labelDistanciaKm"));
		
		//Localiza texto Distância rodoviária (km)
		Assert.assertEquals("Distância retilínea (km):", dsl.obterTexto("formCenter:labelDistanciaRetilinea"));
	}
	
	@Test
	public void novoDistancias() throws InterruptedException{
		//só acontece um refresh na página
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//Localiza texto Origem
		Assert.assertEquals("Origem:", dsl.obterTexto("formCenter:lblOrigem"));
		
		//Localiza texto Destino
		Assert.assertEquals("Destino:", dsl.obterTexto("formCenter:lblDestino"));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void pesquisaProdSerial() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Consulta de Produtos
		Assert.assertEquals("Consulta de Produtos", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//Localiza texto Número Serial
		Assert.assertEquals("Número Serial", dsl.obterTexto("formCenter:dtResult:j_id_2n"));
		
		//Localiza texto Número Patrimonial
		Assert.assertEquals("Número Patrimonial", dsl.obterTexto("formCenter:dtResult:j_id_2p"));
	}
	
	@Test
	public void zonas() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		Thread.sleep(2000);
	
		//localiza texto Zonas
		Assert.assertEquals("Zonas", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//Localiza texto Nome
		Assert.assertEquals("Nome:", dsl.obterTexto("formCenter:labelNome"));
	}
	
	@Test
	public void novoZonas() throws InterruptedException{
		//só acontece um refresh na página
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
		
		Thread.sleep(2000);
		
		//Localiza texto Cidade
		Assert.assertEquals("Cidade*:", dsl.obterTexto("formCenter:lblMunicipio"));
		
		Thread.sleep(3000);	
	}
	
	@Test
	public void financeiro() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(10) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Financeiro
		Assert.assertEquals("Financeiro", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//Localiza texto Produtos identificados x Produtos recebidos
		Assert.assertEquals("Produtos identificados x Produtos recebidos", dsl.obterTexto(By.cssSelector
				("div.col-sm-12:nth-child(4) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)")));
	}
	
	@Test
	public void configOcorrencias() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Configuração de Ocorrências
		Assert.assertEquals("Configuração de Ocorrências", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//Localiza texto Obrigatório
		Assert.assertEquals("Obrigatório:", driver.findElement(By.id("formCenter:labelObrigatorio")).getText());
	}
	
	@Test
	public void novoConfigOcorrencias() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
	
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
		Thread.sleep(4000);
		
		//localiza texto Lista de Configurações
		dsl.contemTexto(By.id("formCenter:dtConfiguracao"), "Lista de Configurações");
	}
	
	@Test
	public void solicitacaoMaterial() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(12) > a:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Solicitação de Material
		Assert.assertEquals("Solicitação de Material",
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Solicitante
		Assert.assertEquals("Solicitante:", dsl.obterTexto("formCenter:labelSolicitante"));
	}
	
	@Test
	public void novoSolicitacaoMaterial() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(12) > a:nth-child(1)");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
		Thread.sleep(2000);
		
		//localiza texto Produto
		Assert.assertEquals("Produto*:", dsl.obterTexto("formCenter:labelProduto"));
		
		//localiza texto Quantidade
		Assert.assertEquals("Quantidade*:", dsl.obterTexto("formCenter:labelQtd"));
		
		//localiza texto Valor Estimado
		Assert.assertEquals("Valor estimado*:", dsl.obterTexto("formCenter:labelValor"));
	}
	
	@Test
	public void solicitacaoServico() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(13) > a:nth-child(1)");
	
		Thread.sleep(2000);
		
		//localiza texto Solicitação de Serviço
		Assert.assertEquals("Solicitação de Serviço",
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Lista de Solicitações
		dsl.contemTexto(By.id("formCenter:dtResult"), "Lista de Solicitações");
	}
	
	@Test
	public void novoSolicitacaoServico() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(13) > a:nth-child(1)");
	
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
		Thread.sleep(2000);
		
		//localiza texto Demanda
		Assert.assertEquals("Demanda:", dsl.obterTexto("formCenter:lblDemanda"));
		
		//localiza texto Escopo
		Assert.assertEquals("Escopo*:", dsl.obterTexto("formCenter:labelEscopo"));
		
		//localiza texto Sugestão de fornecedor
		Assert.assertEquals("Sugestao de fornecedor:", dsl.obterTexto("formCenter:labelSugestaoFornecedor"));
	}
	
	@Test
	public void planejamentoPagamento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(14) > a:nth-child(1)");
		
		Thread.sleep(2000);
		//localiza texto Planejamento de Pagamento
		Assert.assertEquals("Planejamento de Pagamento",
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Lista de Planejamento
		dsl.contemTexto(By.id("formCenter:dtResult"), "Lista de Planejamento");
	}
	
	@Test
	public void novoPlanejamentoPagamento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(14) > a:nth-child(1)");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
		Thread.sleep(2000);
		
		//localiza texto Periodicidade
		Assert.assertEquals("Periodicidade*:", dsl.obterTexto("formCenter:lblPeriodicidade"));
		
		//localiza texto Valor
		Assert.assertEquals("Valor*:", dsl.obterTexto("formCenter:labelValor"));
		
		//localiza texto Centro de Custo
		Assert.assertEquals("Centro de Custo*:", dsl.obterTexto("formCenter:labelCentroCusto"));
	}
	
	@Test
	public void confirmacaoPagamento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(15) > a:nth-child(1)");
		
		//localiza texto Confirmação de Pagamento
		Assert.assertEquals("Confirmação de Pagamento",
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Lista de Planejamento
		dsl.contemTexto(By.id("formCenter:dtResult"), "Lista de Planejamento");
	}
}