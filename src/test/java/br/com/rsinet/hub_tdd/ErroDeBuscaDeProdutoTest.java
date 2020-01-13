package br.com.rsinet.hub_tdd;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.PageObject.ErroDeBuscaDeProdutoObject;

public class ErroDeBuscaDeProdutoTest {
	public static WebDriver driver;

	@Test
	public void test() throws Exception {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ErroDeBuscaDeProdutoObject.CaixaDeSom(driver).click();
		ErroDeBuscaDeProdutoObject.SOUNDLINKWIRELESSSPEAKER(driver).click();
		ErroDeBuscaDeProdutoObject.Quantidade(driver).sendKeys("100");
		ErroDeBuscaDeProdutoObject.SalvarNoCarinho(driver).click();
		ErroDeBuscaDeProdutoObject.SalvarNoCarinho(driver).click();
		
		String resposta = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/label"))
		.getText();
		System.out.println(resposta);
		Assert.assertFalse("Excedeu o estoque", resposta.equals("HP ENVY X360 - 15T LAPTOP"));
	    
		takeSnapShot("teste.png");
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {

		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String imageFileDir = "C:\\Users\\gehaime.silva\\Pictures\\Testes";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));

	}

}
