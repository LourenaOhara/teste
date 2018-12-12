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
public class PessoaJuridica {

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
	public void checkPessoaJuridica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");

		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-widget-content:nth-child(1) > td:nth-child(2)");
		Thread.sleep(2000);
		
		Assert.assertEquals("EMPRESA DE TRANSPORTES APOTEOSE LTDA", 
				dsl.obterValorCampo("formCenter:pessoaJuridicaTab:inputRazaoSocial"));
	}
	
	@Test
	public void inputPessoaJuridica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");

		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		
		//Informações aba Dados Básicos
		
		/*Razão Social*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputRazaoSocial", "Distribuidora de Testes LTDA");
		
		/*CNPJ*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputCnpj", "86307762000150");
		
		/*Nome Fantasia*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputFantasia", "Selenium Distribuidora");
		
		/*Forma Jurídica*/
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:comboFormaJuridica_label"));
		dsl.clicarBotao(By.xpath("//div[5]/div/ul/li[8]"));
		Thread.sleep(1000);
		
		/*Porte da Empresa*/
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:comboPorteEmpresa_label"));
		dsl.clicarBotao(By.xpath("//div[6]/div/ul/li[4]"));
		
		/*Calssificação*/
		dsl.executarJS("formCenter:pessoaJuridicaTab:inputIdentExterna");
		dsl.clicarBotao("div.ui-button:nth-child(3) > span:nth-child(2)");
		
		/*E-mail*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputEmail", "seleniumteste@gmail.com");
		Thread.sleep(2000);
		
		//Informações aba Endereço
		dsl.executarJS("formCenter:pessoaJuridicaTab:inputRazaoSocial");
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		
		/*Tipo*/
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:comboTipo_label"));
		dsl.clicarBotao(By.xpath("//div[8]/div/ul/li[3]"));
		
		/*CEP*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputCep", "30320170");
		Thread.sleep(2000);
		
		/*Modalidade Ocupação*/
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:comboModalidadeOcupacao_label"));
		Thread.sleep(2000);
		dsl.clicarBotao(By.xpath("//div[9]/div/ul/li[2]"));
		
		/*Número*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputNumero", "8");
		
		/*Referência*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputReferencia", "Próximo ao Bh Shopping");
		
		/*Tempo ocupação*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputTempoOcupacao", "15");
		
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:incluirEndereco"));
		Thread.sleep(1000);
		
		//Informações aba Telefone
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		
		/*Tipo*/
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:comboTipoTelefone_label"));
		dsl.clicarBotao(By.xpath("//div[8]/div/ul/li[3]"));
		
		/*DDD*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputDDD", "31");
		
		/*Telefone*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputTelefone", "33992547");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:incluirTelefone"));
		Thread.sleep(1000);
		
		//Informações aba Contatos
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		
		/*NomeContato*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputNomeContato", "José Geraldo");
		
		/*Cargo*/
		dsl.escrever("formCenter:pessoaJuridicaTab:inputCargo", "Analista Java");
		
		dsl.clicarBotao(By.id("formCenter:pessoaJuridicaTab:incluirContato"));
		Thread.sleep(1000);
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(2)");
		}
	
	@Test
	public void removePessoaJuridica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputRazaoSocial", "Distribuidora de Testes LTDA");
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
					
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(2)");
		Thread.sleep(2000);
		
		Assert.assertEquals("Distribuidora de Testes LTDA", 
				dsl.obterValorCampo("formCenter:pessoaJuridicaTab:inputRazaoSocial"));
		
		dsl.executarJS("botoesAcao");
		dsl.clicarBotao("button.btn:nth-child(4)");
		Thread.sleep(1000);
		
		dsl.clicarBotao(By.id("formConfirm:confirmExcluir"));
		dsl.contemTexto(By.tagName("body"), "Registro excluído com sucesso.");		
		
	}
}