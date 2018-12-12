package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasConfirmacao {
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
	public void expedicao() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(5) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(1) > a:nth-child(1)");
		Thread.sleep(2000);
		
		Assert.assertEquals("Expedições:", dsl.obterTexto("formCenter:lblExpedicoes"));
		Assert.assertEquals("Agendamento entre:",dsl.obterTexto("formCenter:j_id_2y"));
		Assert.assertEquals("Expedições entre:", dsl.obterTexto("formCenter:j_id_34"));
	}
	
	@Test
	public void recebimento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(5) > a:nth-child(1) > span:nth-child(2)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		Assert.assertEquals("Recebimentos entre:", dsl.obterTexto("formCenter:j_id_34"));
		Assert.assertEquals("Recebimentos:", dsl.obterTexto("formCenter:lblRecebimentos"));
	}
}