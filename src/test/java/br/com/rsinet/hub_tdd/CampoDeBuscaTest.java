package br.com.rsinet.hub_tdd;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.PageObject.CampoDeBuscaTestObjectError;

public class CampoDeBuscaTest {
	public static WebDriver driver;

	@Test
	public void test() throws Exception {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CampoDeBuscaTestObjectError.Busca(driver).click();
		CampoDeBuscaTestObjectError.completa(driver).sendKeys("caneca" + Keys.ENTER);

		String resposta = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")).getText();
		System.out.println(resposta);
		Assert.assertFalse("Produto nao encontrado", resposta.equals("No results for \"caneca\""));

		takeSnapShot("teste.png");
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {

		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String imageFileDir = "C:\\Users\\gehaime.silva\\Pictures\\Testes";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));

	}

}
