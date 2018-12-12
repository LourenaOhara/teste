package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AbrirTelasConfiguracao {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void open(){
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
	public void fluxoOperacao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Fluxo de Operação
		Assert.assertEquals("Fluxo de Operação", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Nome
		Assert.assertEquals("Nome:", 
				dsl.obterTexto("formCenter:labelNome"));
		
		//localiza texto Status
		Assert.assertEquals("Status:", dsl.obterTexto("formCenter:labelStatus"));
	}
	@Test
	public void novoFluxoOperacao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Trânsito de Entrada
		
		Assert.assertEquals("Trânsito de Entrada:*", 
				dsl.obterTexto("formCenter:labelTransitoEntrada"));
		
		//localiza botão Recebido
		
		dsl.contemTexto(By.id("formCenter:checkTransitoEntrada"), "Recebido");
		
		//localiza botão Recusado para Armazenagem
		
		dsl.contemTexto(By.id("formCenter:checkTransitoEntrada"), "Recusado para Armazenagem");
	}
	@Test
	public void parametrizarEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Endereçamento
		
		Assert.assertEquals("Endereçamento", dsl.obterTexto(By.cssSelector(".ui-datatable-header")));
		
		//localiza texto Descrição
		
		Assert.assertEquals("Descrição:", dsl.obterTexto(By.id("formCenter:lblDescricao")));
	}
	@Test
	public void novoParametrizarEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Layout
		
		dsl.contemTexto(By.id("formCenter:pnlConfiguracao_header"), "Layout");
		
		//localiza botão Atualizar configuração
		
		Assert.assertEquals("Atualizar configuração", dsl.obterTexto("formCenter:btGerarFormato"));
	
	}
	@Test
	public void associarAtivoEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Associar Ativo-Endereço
		
		Assert.assertEquals("Associar Ativo-Endereço", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Armazém
		
		Assert.assertEquals("Armazém:*", dsl.obterTexto("formCenter:j_id_29:labelArmazem"));
		
		//localiza texto Endereçamento
		
		Assert.assertEquals("Endereçamento:*", dsl.obterTexto("formCenter:j_id_29:labelEnderecamento"));
	}
	@Test
	public void novoAssociarAtivoEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(3000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Associar
		dsl.contemTexto(By.id("formCenter:pnlLayout_header"), "Associar");
		
		//localiza texto Selecione os endereços a serem reservados
		Assert.assertEquals("Selecione os endereços a serem reservados:*", 
				dsl.obterTexto("formCenter:lblMarqueEnderecosDesativar"));
	}
	@Test
	public void desativarEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Desativar Endereço
		Assert.assertEquals("Desativar Endereço", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));		
	}
	@Test
	public void unidadeMedida() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Unidade de Medida
		Assert.assertEquals("Unidade de medida", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
	}
	@Test
	public void novoUnidadeMedida() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto nome
	
		Assert.assertEquals("Nome:*", dsl.obterTexto("formCenter:labelNome"));
	}
	@Test
	public void configurarTarefa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Configurar Tarefa
		Assert.assertEquals("Configurar Tarefa", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Tipo de Tarefa
		Assert.assertEquals("Tipo de Tarefa:", dsl.obterTexto("formCenter:labelTipoTarefa"));	
	}
	@Test
	public void novoConfigurarTarefa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Expedição
		dsl.contemTexto(By.id("formCenter:radioTipoRegra"), "Expedição");
		
		//localiza texto Rua
		dsl.contemTexto(By.id("formCenter:radioTipoRegra"), "Rua");
		
		//localiza texto Produto
		dsl.contemTexto(By.id("formCenter:radioTipoRegra"), "Produto");		
	}
	@Test
	public void configurarFluxo() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Configuração de Fluxo
		Assert.assertEquals("Configuração de Fluxo", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		//localiza texto Chave
		dsl.contemTexto(By.id("formCenter:dtResult"), "Chave");	
	}
	
	@Test
	public void separaçao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(10) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Separação
		Assert.assertEquals("Separação", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		Thread.sleep(1000);
		
		//Abre Tela de Configuração Cadastrada
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Priorizar Quantidade
		dsl.contemTexto(By.id("formCenter:comboRegraSeparacao"), "Priorizar Quantidade");
		
		//localiza texto Priorizar Endereço
		dsl.contemTexto(By.id("formCenter:comboRegraSeparacao"), "Priorizar Endereço");
	}
}