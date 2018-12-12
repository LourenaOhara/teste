package abrirTelas;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrirTelasFerramentas {
	
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
	public void associar() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(2) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Associar S/N
		Assert.assertEquals("Associar S/N", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Quantidade de linhas (1-50)
		
		Assert.assertEquals("Quantidade de linhas (1-50):*", dsl.obterTexto("formCenter:lblQuantidade"));
	}
	
	@Test
	public void cargaAtivoEndereco() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(3) > a:nth-child(1)");
		Thread.sleep(2000);
	
		//localiza texto Carga produto/endereço
		Assert.assertEquals("Carga produto/endereço",dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Imprimir Etiqueta
		Assert.assertEquals("Imprimir Etiqueta:*", dsl.obterTexto("formCenter:lblImprimirEtiqueta"));
		
	}
	
	@Test
	public void importarProdutos() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(4) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Importar Produtos
		Assert.assertEquals("Importar Produtos", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));		
		
		//localiza texto Atenção	
		dsl.contemTexto(By.id("formCenter"), "ATENÇÃO: o arquivo deve conter, "
				+ "no máximo, 1000 registros; "
				+ "caso contrário, a importação não será realizada.");
		
		//localiza texto Contexto
		dsl.contemTexto(By.id("formCenter"), "No contexto de armazenamento do GTI-Plug/WMS, produtos "
				+ "similares são aqueles que podem compartilhar o mesmo espaço, ou seja, podem "
				+ "ser agrupados em um mesmo compartimento devido à similaridade de formato, etc.");
	}
	
	@Test
	public void reenderecamento() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(5) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Reendereçamento
		Assert.assertEquals("Reendereçamento", dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Endereçamento
		Assert.assertEquals("Endereçamento", dsl.obterTexto("formCenter:dtLote:j_id_2z"));
	}
	
	@Test
	public void reimprimirEtiquetas() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(6) > a:nth-child(1)");
		Thread.sleep(2000);
		
		//localiza texto Reimprimir Etiquetas
		Assert.assertEquals("Reimprimir Etiquetas", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Ação
		Assert.assertEquals("Ação", dsl.obterTexto("formCenter:dtLote:j_id_2t"));
	}
	
	@Test
	public void completarPallet() throws InterruptedException{
		dsl.loginEmtel();
		Thread.sleep(3000);
		dsl.clicarBotao("li.treeview:nth-child(9) > a:nth-child(1)");
		Thread.sleep(1000);
		dsl.clicarBotao(".menu-open > li:nth-child(7) > a:nth-child(1)");
		Thread.sleep(2000);
		

		//localiza texto Completar Pallet
		Assert.assertEquals("Completar Pallet", 
				dsl.obterTexto(By.cssSelector(".breadcrumb > li:nth-child(3)")));
		
		//localiza texto Quantidade Fracionada Total Pallet
		Assert.assertEquals("Quantidade Fracionada Total Pallet", 
				dsl.obterTexto("formCenter:dtCompletarPallet:j_id_2y"));
		
		//localiza texto Disponível
		Assert.assertEquals("Disponível", 
				dsl.obterTexto("formCenter:dtCompletarPallet:j_id_30"));
				
		//localiza texto Reservada
		Assert.assertEquals("Reservada", 
				dsl.obterTexto("formCenter:dtCompletarPallet:j_id_32"));
		
		//localiza texto Ação
		Assert.assertEquals("Ação", 
				dsl.obterTexto("formCenter:dtCompletarPallet:j_id_39"));
	}
}