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
public class IncluirSeparador {
	
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
	public void a_RemoverSeparador() throws InterruptedException{
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
		
		Assert.assertEquals("Separador:", 
				dsl.obterTexto("formCenter:usuarioTabView:selSeparador:labelRadioTipoPessoa"));
		Thread.sleep(1000);
		
		dsl.executarJS("formCenter:usuarioTabView:pnlSeparador");
		dsl.clicarBotao(By.id("formCenter:usuarioTabView:btnRemoverSeparador"));
		Thread.sleep(1000);
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		Assert.assertEquals("Registro alterado com sucesso.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
	}
	
	@Test
	public void b_IncluirSeparador() throws InterruptedException{
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
		
		Assert.assertEquals("Separador:", 
				dsl.obterTexto("formCenter:usuarioTabView:selSeparador:labelRadioTipoPessoa"));
		Thread.sleep(1000);
		
		dsl.executarJS("formCenter:usuarioTabView:pnlSeparador");
		dsl.clicarBotao(By.id("btSel_selSeparador"));
		Thread.sleep(1000);
		
		dsl.escrever("frmSelPF:inputNome", "Cledson");
		dsl.clicarBotao(By.id("frmSelPF:btPesquisarPF"));
		Thread.sleep(1000);
		
		dsl.clicarBotao(".ui-datatable-selectable > td:nth-child(1)");
		Thread.sleep(1000);
		
		Assert.assertEquals("080.165.736-90 - Cledson Caetano Resende Pacheco", 
				dsl.obterTexto("formCenter:usuarioTabView:selSeparador:outputPessoaSelecionada"));
		Thread.sleep(1000);
		dsl.clicarBotao("button.btn:nth-child(2)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Registro alterado com sucesso.", 
				dsl.obterTexto("formCenter:msgs_formCenter"));
	}
}