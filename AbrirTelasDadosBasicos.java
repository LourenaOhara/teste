package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasDadosBasicos {
	
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
	public void contratos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Contratos
		Assert.assertEquals("Contratos", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
	
		// localiza texto nome
		dsl.contemTexto(By.id("formCenter:labelNome"), "Nome");
		
		// localiza texto Status Cadastro
		dsl.contemTexto(By.id("formCenter:labelStatusCadastro"), "Status Cadastro");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoContratos()throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		dsl.contemTexto(By.id("formCenter:labelFluxoOperacao"), "Fluxo de Operação");
		Thread.sleep(3000);
	}
	
	@Test
	public void pessoaFisica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Pessoa Física
		Assert.assertEquals("Pessoa Física", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
	}
	
	@Test
	public void novoPessoaFisica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(2000);
		dsl.contemTexto(By.id("formCenter:pessoaFisicaTab:labelNoomeCompl"), "Nome Completo");
		
		Thread.sleep(3000);
		
		//Abre aba Endereço
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Telefone
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Contatos
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
	}
	
	@Test
	public void pessoaJuridica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Pessoa Juridica
		Assert.assertEquals("Pessoa Jurídica", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		Thread.sleep(3000);
	}
	
	@Test
	public void novoPessoaJuridica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		dsl.contemTexto(By.id("formCenter:pessoaJuridicaTab:labelRazaoSocial"), "Razão Social");
		
		Thread.sleep(3000);
		
		//Abre aba Endereço
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Telefone
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//Abre aba Contatos
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		Thread.sleep(1000);
	}
	
	@Test
	public void fabricantes() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Fabricantes
		Assert.assertEquals("Fabricantes", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoFabricantes() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
	
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(2000);
		dsl.contemTexto(By.id("formCenter:labelNome"), "Nome");
	
		Thread.sleep(3000);
	}
	
	@Test
	public void produtos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//localiza texto Produto
		Assert.assertEquals("Produtos", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Fabricante
		dsl.contemTexto(By.id("formCenter:labelFabricante"), "Fabricante");
		
		//localiza texto Modelo
		dsl.contemTexto(By.id("formCenter:labelModelo"), "Modelo");
		Thread.sleep(3000);
	}
	
	@Test
	public void novoProdutos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("button.pull-right:nth-child(1)")).click();
	
		Thread.sleep(2000);
		
		//localiza texto Descrição
		dsl.contemTexto(By.id("formCenter:produtosTab:labelDescricao"), "Descrição");
		
		//localiza texto Durabilidade
		dsl.contemTexto(By.id("formCenter:produtosTab:labelDurabilidade"), "Durabilidade");
		
		//localiza texto Embalagem
		dsl.contemTexto(By.id("formCenter:produtosTab:labelEmbalagem"), "Embalagem");
		Thread.sleep(1000);
		
		//Abre aba Restrições
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		//Abre aba Informações Adicionais
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		//Abre aba Configuração da Grade
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void responsavel() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//localiza texto Responsável
		Assert.assertEquals("Responsável", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoResponsavel() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		
		Thread.sleep(1000);

		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		dsl.contemTexto(By.id("formCenter:labelNome"), "Nome");
		Thread.sleep(3000);
	}
	
	@Test
	public void centroCusto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		
		Thread.sleep(1000);
	
		//localiza texto Centro de Custo
		Assert.assertEquals("Centro de Custo", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Nome
		dsl.contemTexto(By.id("formCenter:labelNome"), "Nome");
		Thread.sleep(3000);
	}
	
	@Test
	public void novoCentroCusto() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Nome
		dsl.contemTexto(By.id("formCenter:labelNome"), "Nome");
		
		// localiza texto Descrição
		dsl.contemTexto(By.id("formCenter:labelDescricao"), "Descrição");
		Thread.sleep(3000);
	}
	
	@Test
	public void veiculos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		
		Thread.sleep(1000);

		//localiza texto Veículos
		Assert.assertEquals("Veículos", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Placa 1
		dsl.contemTexto(By.id("formCenter:labelPlaca1"), "Placa 1");
		
		//localiza texto Placa 2
		dsl.contemTexto(By.id("formCenter:labelPlaca2"), "Placa 2");
		
		//localiza texto Meio de Transporte
		dsl.contemTexto(By.id("formCenter:labelMeioTransporte"), "Meio de Transporte");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoVeiculos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Cubagem
		dsl.contemTexto(By.id("formCenter:labelCubagem"), "Cubagem");
		
		//localiza texto Eixos
		dsl.contemTexto(By.id("formCenter:labelEixos"), "Eixos");
		
		//localiza texto Motorista Principal
		dsl.contemTexto(By.id("formCenter:motorista:labelRadioTipoPessoa"), "Motorista Principal");
		Thread.sleep(3000);
	}
	@Test
	public void AssociarEPC() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		
		Thread.sleep(1000);

		//localiza texto Associar EPC
		Assert.assertEquals("Associar EPC", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Produto
		dsl.contemTexto(By.id("formCenter:labelAtivoProduto"), "Produto");
		
		//localiza texto Schema
		dsl.contemTexto(By.id("formCenter:labelSchema"), "Schema");
		
		Thread.sleep(3000);
	}
	
	@Test
	public void novoAssociarEPC() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(9) > a:nth-child(1)");
		
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		
		Thread.sleep(2000);
		
		//localiza texto Prefixo
		dsl.contemTexto(By.id("formCenter:associarTab:labelPrefixo"), "Prefixo");
		
		//localiza texto Usa EPC
		dsl.contemTexto(By.id("formCenter:associarTab:lblUsaEpc"), "Usa EPC");
		Thread.sleep(3000);
	}
	
	@Test
	public void imprimirEtiqueta() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(10) > a:nth-child(1)");
		
		Thread.sleep(1000);
		
		//localiza texto Imprimir Etiqueta
		Assert.assertEquals("Imprimir Etiqueta", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Armazém
		dsl.contemTexto(By.id("formCenter:j_id_2h"), "Armazém");
		
		//localiza texto Identificação Externa
		dsl.contemTexto(By.id("formCenter:labelIdentExterna"), "Identificação Externa");
		Thread.sleep(3000);
	}
	
	@Test
	public void imprimirLote() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(11) > a:nth-child(1)");
		
		Thread.sleep(1000);
	
		//localiza texto Impressão em Lote
		Assert.assertEquals("Impressão em Lote", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		Thread.sleep(1000);
		
		//Abre aba Visualizar Impressãoes Agendadas
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(3000);
	}
}