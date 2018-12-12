package cadastro;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

import org.junit.After;
import org.junit.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//ordena execução dos testes pelo nome
public class PessoaFisica {

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
	public void checkPessoaFisica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");

		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(2000);
		
		Assert.assertEquals("Matheus Gomes dos Santos Ferreira", 
				dsl.obterValorCampo("formCenter:pessoaFisicaTab:inputNomeCompl"));
	}
	
	@Test
	public void inputPessoaFisica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");

		Thread.sleep(2000);
		
		dsl.clicarBotao("button.pull-right:nth-child(1)");
		Thread.sleep(1000);
		
		//Informações aba Dados Básicos
		
		/*Nome Completo*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputNomeCompl", "Lourena Ohara Alves Andrade");
		
		/*Data de Nascimento*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputDataNasc_input", "06/10/1989");
		
		/*CPF*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputCpf", "08016573690");
		
		/*Estado Civil*/
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:comboEstadoCivil_label"));
		dsl.clicarBotaoX("//div[7]/div/ul/li[2]");
		
		/*Grau de Instrução*/
		driver.findElement(By.id("formCenter:pessoaFisicaTab:comboGrauInstrucao_label")).click();
		dsl.clicarBotaoX("//div[8]/div/ul/li[4]");
		
		/*Classificação*/
		dsl.clicarBotaoX("//div/div/div[2]/span");
		Thread.sleep(1000);
		
		//Informações aba Endereço
		dsl.clicarBotao("li.ui-state-default:nth-child(2) > a:nth-child(1)");
		
		/*Tipo*/
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:comboTipo_label"));
		dsl.clicarBotaoX("//div[9]/div/ul/li[2]");
		
		/*CEP*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputCep", "30110021");
		Thread.sleep(2000);
		
		/*Logradouro*/
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:comboLogradouro_label"));
		dsl.clicarBotaoX("//div[10]/div/ul/li[35]");
		
		/*Endereço*/
		Thread.sleep(1000);
		dsl.limparCampo("formCenter:pessoaFisicaTab:inputEndereco");
		dsl.escrever("formCenter:pessoaFisicaTab:inputEndereco", "Oito de Setembro");
		Thread.sleep(1000);
		
		/*Número*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputNumero", "71");
		
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:incluirEndereco"));
		Thread.sleep(1000);
		
		//Informações aba Telefone
		dsl.clicarBotao("li.ui-state-default:nth-child(3) > a:nth-child(1)");
		
		/*Tipo*/
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:comboTipoTelefone_label"));
		dsl.clicarBotaoX("//div[9]/div/ul/li[4]");
		Thread.sleep(1000);
		
		/*DDD*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputDDD", "31");
		
		/*Telefone*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputTelefone", "99999999");
		
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:incluirTelefone"));
		Thread.sleep(1000);
		
		//Informações aba Contatos
		dsl.clicarBotao("li.ui-state-default:nth-child(4) > a:nth-child(1)");
		
		/*Nome*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputNomeContato", "Gutemberg Medianeiro");
		
		/*Grau de relacionamento*/
		dsl.escrever("formCenter:pessoaFisicaTab:inputCargo", "Irmão");
		
		dsl.clicarBotao(By.id("formCenter:pessoaFisicaTab:incluirContato"));
		Thread.sleep(1000);
		
		dsl.clicarBotao("button.btn:nth-child(2)");	
		
	}
	
	@Test
	public void removePessoaFisica() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(3) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");

		Thread.sleep(2000);
			
		dsl.clicarBotao("button.pull-right:nth-child(5)");
		Thread.sleep(1000);
			
		WebElement table = driver.findElement(By.tagName("table"));
		List <WebElement> rows = table.findElements(By.tagName("tr"));
				
		dsl.clicarBotaoX("//tr["+(rows.size() - 1)+"]");
		Thread.sleep(2000);

		dsl.clicarBotao("button.btn:nth-child(4)");
		Thread.sleep(1000);
			
		dsl.clicarBotao(By.id("formConfirm:confirmExcluir"));
		
		dsl.contemTexto(By.tagName("body"), "Registro excluído com sucesso.");
	}
}