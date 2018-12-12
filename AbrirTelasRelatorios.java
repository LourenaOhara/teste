package abrirTelas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasRelatorios {

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
	public void comissao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Comissão
		Assert.assertEquals("Relatório de Comissão", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo Relatório
		Assert.assertEquals("Tipo de Relatório:", dsl.obterTexto("formCenter:labelTipoRelatorio"));
	}
	
	@Test
	public void clientes() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Clientes
		Assert.assertEquals("Relatório de Clientes", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo Relatório
		Assert.assertEquals("Tipo de Relatório:", dsl.obterTexto("formCenter:labelTipoRelatorio"));
	}
	
	@Test
	public void fornecedores() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Fornecedores
		Assert.assertEquals("Relatório de Fornecedores", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
				
		//localiza texto Tipo Relatório
		Assert.assertEquals("Tipo de Relatório:", dsl.obterTexto("formCenter:labelTipoRelatorio"));
	}
	
	@Test
	public void solicitacaoMateriais() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Solicitação de Materiais
		Assert.assertEquals("Relatório de Solicitação de Material", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
				
		//localiza texto Número Solicitação
		Assert.assertEquals("Número Solicitação:", dsl.obterTexto("formCenter:labelNumeroSolicitacao"));
	}
	
	@Test
	public void solicitacaoServicos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Solicitação de Serviço
		Assert.assertEquals("Relatório de Solicitação de Serviço", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
				
		//localiza texto Demanda
		Assert.assertEquals("Demanda:", dsl.obterTexto("formCenter:lblDemanda"));
	}
	
	@Test
	public void produtos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Produtos
		Assert.assertEquals("Relatório de Produtos", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Produto
		Assert.assertEquals("Produto:", dsl.obterTexto("formCenter:labelProduto"));
	}
	
	@Test
	public void recebimentos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Recebimentos
		Assert.assertEquals("Relatório de Recebimentos", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo Apenas Recebimentos Rápidos
		Assert.assertEquals("Apenas Recebimentos Rápidos:", dsl.obterTexto("formCenter:labelRpaidos"));
	}
	
	@Test
	public void recebimentosComProduto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Recebimentos por Produto
		Assert.assertEquals("Relatório de Recebimentos por Produto", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza botão Adicionar Produto
		Assert.assertEquals("Adicionar Produto", dsl.obterTexto("formCenter:btPsqProdDg"));
	}
	
	@Test
	public void expedicoes() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(10) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Expedições
		Assert.assertEquals("Relatório de Expedições", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Zona
		Assert.assertEquals("Zona:", dsl.obterTexto("formCenter:labelZona"));
	}
	
	@Test
	public void expedicoesComProduto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de expedições por Produto
		Assert.assertEquals("Relatório de Expedições por Produto", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza botão Adicionar Produto
		Assert.assertEquals("Adicionar Produto", dsl.obterTexto("formCenter:btPsqProdDg"));
	}
	
	@Test
	public void estoque() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(16) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Estoque
		Assert.assertEquals("Relatório de Estoque", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Regra
		Assert.assertEquals("Regra:", dsl.obterTexto("formCenter:labelRegra"));
	}
	
	@Test
	public void tabelaPreco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(17) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Tabela de Preços
		Assert.assertEquals("Relatório de Tabela de Preços", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
				
		//localiza texto Exibir apenas Tabela de Preço Vigente
		Assert.assertEquals("Exibir apenas Tabela de Preço Vigente:", dsl.obterTexto("formCenter:labelMaxima"));
	}
	
	@Test
	public void enderecosVazios() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(18) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Endereços Vazios
		Assert.assertEquals("Relatório de Endereços Vazios", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Exibir Endereços Parcialmente Ocupados
		Assert.assertEquals("Exibir Endereços Parcialmente Ocupados:", 
				dsl.obterTexto("formCenter:labelAutorizados"));
	}
	
	@Test
	public void enderecosOcupados() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(19) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Endereços Ocupados
		Assert.assertEquals("Relatório de Endereços Ocupados", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Endereçamento
		Assert.assertEquals("Endereçamento:*", 
				dsl.obterTexto("formCenter:j_id_26:labelEnderecamento"));
	}
	
	@Test
	public void enderecosPorProduto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(20) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Endereços por Produto
		Assert.assertEquals("Relatório de Endereços por Produto", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
			
		//localiza texto Tipo Produtos
		dsl.contemTexto(By.id("formCenter:dtAtivo"), "Produtos");
	}
	
	@Test
	public void produtosSemEnderecos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(21) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Produto sem Endereço Mapeado
		Assert.assertEquals("Relatório de Produto sem Endereço Mapeado", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Endereçamento
		Assert.assertEquals("Endereçamento:*", dsl.obterTexto("formCenter:lblEnderecamento"));
	}
	
	@Test
	public void produtosComEnderecos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(22) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Produto com Endereço Mapeado 
		Assert.assertEquals("Relatório de Produto com Endereço Mapeado", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Exibir apenas Endereços Vazios
		Assert.assertEquals("Exibir apenas Endereços Vazios:", 
				dsl.obterTexto("formCenter:labelVazios"));
	}
	
	@Test
	public void armazenagemTotal() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(23) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Armazenagem Total
		Assert.assertEquals("Relatório de Armazenagem Total", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
			
		//localiza texto Período
		Assert.assertEquals("Período:", 
				dsl.obterTexto("formCenter:labelAgendamentoEtapa"));
	}
	@Test
	public void faturamento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(24) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de GTA Faturamento
		Assert.assertEquals("Relatório de GTA Faturamento", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Ano
		Assert.assertEquals("Ano:", dsl.obterTexto("formCenter:j_id_2m"));
	}
	
	@Test
	public void multa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(25) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de GTA Multa
		Assert.assertEquals("Relatório de GTA Multa", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Mês
		Assert.assertEquals("Mês:", dsl.obterTexto("formCenter:j_id_26"));
	}
	
	@Test
	public void produtoSerie() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(26) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Produtos - Série/Patrimônio
		Assert.assertEquals("Relatório de Produtos - Série/Patrimônio", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Status
		Assert.assertEquals("Status:", dsl.obterTexto("formCenter:labelStatusPallet"));
	}
	
	@Test
	public void relatorioImpressao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(27) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Impressão
		Assert.assertEquals("Relatório de Impressão", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Gerado em
		dsl.contemTexto(By.id("formCenter:dtResult"), "Gerado em");
	}
	
	@Test
	public void inventario() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(28) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Inventário
		Assert.assertEquals("Relatório de Inventário", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo
		Assert.assertEquals("Tipo:", dsl.obterTexto("formCenter:labelTipo"));
	}
	
	@Test
	public void transferencia() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(29) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Transferência
		Assert.assertEquals("Relatório de Transferência", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Lista de Transferências
		dsl.contemTexto(By.id("formCenter:dtResult"), "Lista de Transferências");
	}
	
	@Test
	public void estoqueGeral() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(30) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Estoque Geral
		Assert.assertEquals("Relatório de Estoque Geral", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Regra
		Assert.assertEquals("Regra:", dsl.obterTexto("formCenter:labelRegra"));
	}
	
	@Test
	public void romaneios() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(31) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Romaneios
		Assert.assertEquals("Relatório de Romaneios", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Romaneios contendo
		Assert.assertEquals("Romaneios contendo:", dsl.obterTexto("formCenter:labelOperacao"));
	}
	
	@Test
	public void operacoesFinalizadas() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(32) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Operações Finalizadas
		Assert.assertEquals("Relatório de Operações Finalizadas", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
				
		//localiza texto Apenas Operações
		Assert.assertEquals("Apenas operações:", dsl.obterTexto("formCenter:lblConfirmadas"));
	}
	
	@Test
	public void pagamentosCentroCusto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(33) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Pagamentos por Centro de Custo
		Assert.assertEquals("Relatório de Pagamentos por Centro de Custo", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Centro de Custo
		Assert.assertEquals("Centro de Custo*:", dsl.obterTexto("formCenter:labelCentroCusto"));
	}
	
	@Test
	public void pagamentosPessoa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(34) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Pagamentos por Pessoa
		Assert.assertEquals("Relatório de Pagamentos por Pessoa", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Pessoa
		Assert.assertEquals("Pessoa*:", dsl.obterTexto("formCenter:pessoa:labelRadioTipoPessoa"));
	}
	
	@Test
	public void estoqueGeralArmazem() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(35) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Estoque Geral Por Armazém
		Assert.assertEquals("Relatório de Estoque Geral Por Armazém", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo Armazém
		Assert.assertEquals("Armazém:", dsl.obterTexto("formCenter:labelArmazem"));
	}
	
	@Test
	public void movimentacoesPeriodo() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(7) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(36) > a:nth-child(1)");
		Thread.sleep(2000);		
		
		//localiza texto Relatório de Movimentações por Período
		Assert.assertEquals("Relatório de Movimentações por Período", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Período
		Assert.assertEquals("Período:", dsl.obterTexto("formCenter:labelPeriodo"));
	}
}