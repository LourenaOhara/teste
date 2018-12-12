package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasSuporte {

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
	public void parametrosSistema() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);

		//localiza texto Parâmetros do Sistema
		Assert.assertEquals("Parâmetros do Sistema", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Link Externa
		Assert.assertEquals("Link Externa:", dsl.obterTexto("formCenter:j_id_1w:lblURLExterna"));
		Thread.sleep(1000);
		
		//abrir aba middleware
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		Thread.sleep(1000);
		
		//abrir aba configuração de e-mail
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		Thread.sleep(3000);
	}
	
	@Test
	public void telaOperador() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
	}
	
	@Test
	public void detalhesRecebimento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Recebimentos
		Assert.assertEquals("Relatório de Recebimentos", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Data Agendamento Etapa
		Assert.assertEquals("Data Agendamento Etapa:", dsl.obterTexto("formCenter:labelAgendamentoEtapa"));
		Thread.sleep(1000);
	
		//localiza texto Status Etapa
		Assert.assertEquals("Status Etapa:", dsl.obterTexto("formCenter:labelStatusOperacao"));
		Thread.sleep(1000);
	}
	
	@Test
	public void detalhesExpedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Expedições
		Assert.assertEquals("Relatório de Expedições", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Número
		Assert.assertEquals("Número:", dsl.obterTexto("formCenter:labelNumOperacao"));
		Thread.sleep(1000);
		
		//localiza texto Observação
		Assert.assertEquals("Observação:", dsl.obterTexto("formCenter:labelObservacoes"));
		
	}
	
	@Test
	public void produtosAguardandoRecebimento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Produtos Aguardando Recebimento
		Assert.assertEquals("Produtos Aguardando Recebimento", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Endereçamento
		Assert.assertEquals("Endereçamento:", dsl.obterTexto("formCenter:lblEnderecamento"));
		
	}
	
	@Test
	public void dadosEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Dados Endereço
		Assert.assertEquals("Dados Endereço", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Armazém
		Assert.assertEquals("Armazém:*", dsl.obterTexto("formCenter:j_id_26:labelArmazem"));
		Thread.sleep(1000);
		
		//localiza texto Endereço
		Assert.assertEquals("Endereço:", dsl.obterTexto("formCenter:labelEndereco"));
		Thread.sleep(1000);
		
	}
	
	@Test
	public void produtosAguardandoExpedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Produtos Aguardando Expedição
		Assert.assertEquals("Produtos Aguardando Expedição", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Endereçamento
				Assert.assertEquals("Endereçamento:", dsl.obterTexto("formCenter:lblEnderecamento"));
				
	}
	
	@Test
	public void enderecosOcupados() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(12) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(8) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Relatório de Endereços Ocupados
		Assert.assertEquals("Relatório de Endereços Ocupados", 
				//localiza texto Link Externa
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Exibir Endereços Parcialmente Ocupados
		Assert.assertEquals("Exibir Endereços Parcialmente Ocupados:", 
				dsl.obterTexto("formCenter:labelParcialmenteOcupados"));
		
		//localiza texto Tipo Relatório
				Assert.assertEquals("Tipo de Relatório:", dsl.obterTexto("formCenter:labelTipoRelatorio"));
	}
}