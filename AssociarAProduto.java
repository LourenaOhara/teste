package cadastro;
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
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssociarAProduto {

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
		public void checkProdutos() throws InterruptedException{
			dsl.loginEmtel();
			Thread.sleep(3000);
			dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
			Thread.sleep(1000);
			dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
			Thread.sleep(2000);
		
			dsl.clicarBotao("button.pull-right:nth-child(5)");
			Thread.sleep(1000);
			
			dsl.clicarBotao("tr.ui-datatable-even:nth-child(1) > td:nth-child(1)");
			Thread.sleep(2000);
			
			Assert.assertEquals("ABAFADOR RUIDOS AMARELO 18DB",
					dsl.obterValorCampo("formCenter:produtosTab:inputNome"));
		}
		
		@Test
		public void inputProdutos() throws InterruptedException{
			dsl.loginEmtel();
			Thread.sleep(3000);
			dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
			Thread.sleep(1000);
			dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
			Thread.sleep(2000);
			
			dsl.clicarBotao("button.pull-right:nth-child(1)");
			
			Thread.sleep(1000);
			
			//Informações aba Dados Básicos
			/*Nome*/
			dsl.escrever("formCenter:produtosTab:inputNome", "TESTADOR PORTÁTIL");
			
			/*Descrição*/
			dsl.escrever("formCenter:produtosTab:inputDescricao", "testador que testa os testes automatizados");
			
			/*Identificação Externa*/
			dsl.escrever("formCenter:produtosTab:inputIdentExterna", "123456");
		
			/*Fornecedor*/
			dsl.clicarBotao("td:nth-child(3) > div:nth-child(1)");
			dsl.clicarBotao(By.id("btSel_fornecedor"));
			Thread.sleep(1000);
			dsl.clicarBotao(By.id("frmSelPJ:btPesquisarPJ"));
			Thread.sleep(1000);
			
			dsl.clicarBotao("tr.ui-datatable-selectable:nth-child(1) > td:nth-child(1)"); 
			Thread.sleep(1000);
			
			/*Tipo*/
			dsl.clicarBotao(By.id("formCenter:produtosTab:comboTipo_label"));
			Thread.sleep(1000);
			
			dsl.clicarBotaoX("//div[9]/div/ul/li[4]");
			
			//Informações aba Informações adicionais
			dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
			Thread.sleep(1000);
			
			/*Recebimento mesclado*/
			dsl.clicarBotaoX("//div[3]/div/div[1]/div/div/div/div[1]/div/div[2]");
			Thread.sleep(1000);
			
			/*Quantidade limite por pallet*/
			dsl.escrever("formCenter:produtosTab:inputLimitePalletVirtual", "10");
			
			dsl.executarJS("botoesAcao");
			dsl.clicarBotao("button.btn:nth-child(2)");
			
			Thread.sleep(1000);
			dsl.contemTexto(By.tagName("body"), "Registro incluído com sucesso.");
		}
		//NÃO EXISTE O TESTE DE REMOÇÃO PARA COMPOR O CENÁRIO DE ASSOCIAR EPC E ASSOCIAR ATIVO-ENDEREÇO 
}