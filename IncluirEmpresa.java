package processo;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import abrirTelas.DSL;

import org.junit.Assert;
import org.junit.After;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IncluirEmpresa {
	
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
	public void a_incluirEmpresa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(11) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputNome", "Lourena Ohara");
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Empresa:", 
				dsl.obterTexto("formCenter:usuarioTabView:selPessoa:labelRadioTipoPessoa"));
		dsl.clicarBotao(By.id("btSel_selPessoa"));
		Thread.sleep(1000);
		
		dsl.escrever("frmSelPJ:inputRazaoSocial", "ROMAGNOLE PRODUTOS ELETRICOS S.A.");
		dsl.clicarBotao(By.id("frmSelPJ:btPesquisarPJ"));
		Thread.sleep(1000);
		dsl.clicarBotao(".ui-datatable-selectable > td:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(By.id("formCenter:usuarioTabView:incluir"));
		Thread.sleep(1000);
		dsl.contemTexto(By.id("formCenter:usuarioTabView:dtEmpresas_data"), "78.958.717/0016-14");
		
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		
		dsl.contemTexto(By.id("formCenter:msgs_formCenter"), "Registro alterado com sucesso.");
	}
	
	@Test
	public void b_excluirEmpresa() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(11) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		dsl.escrever("formCenter:inputNome", "Lourena Ohara");
		dsl.clicarBotao("button.pull-right:nth-child(3)");
		Thread.sleep(1000);
		
		dsl.clicarBotao("tr.ui-widget-content > td:nth-child(1)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Empresa:", 
				dsl.obterTexto("formCenter:usuarioTabView:selPessoa:labelRadioTipoPessoa"));
		
		dsl.contemTexto(By.id("formCenter:usuarioTabView:dtEmpresas_data"), "78.958.717/0016-14");
		Thread.sleep(2000);
		dsl.executarJS("formCenter:usuarioTabView:dtEmpresas");
			dsl.clicarBotao(By.id("formCenter:usuarioTabView:dtEmpresas:1:j_id_3j"));
		Thread.sleep(1000);
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		Assert.assertEquals("Registro alterado com sucesso.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
	}
}