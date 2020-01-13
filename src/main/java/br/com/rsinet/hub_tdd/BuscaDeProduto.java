package br.com.rsinet.hub_tdd;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.PageObject.BuscaDeProdutoObject;

public class BuscaDeProduto {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BuscaDeProdutoObject.laptop(driver).click();
		BuscaDeProdutoObject.ENVY17TTOUCH(driver).click();
		BuscaDeProdutoObject.AdicioneNoCarrinho(driver).click();
        BuscaDeProdutoObject.Check(driver).click();
        
		takeSnapShot("teste.png");
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\gehaime.silva\\Pictures\\Testes";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));

	}

}
