package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasDashboard {

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
	public void dashboard() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		
		Assert.assertEquals("Dashboard", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(2)")));
		Thread.sleep(3000);
	}
}
