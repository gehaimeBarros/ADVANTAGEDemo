package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.PageObject.CampoDeBuscaTestObjectError;
import br.com.rsinet.hub_tdd.UtilExcel.takeSnapShot;

public class CampoDeBuscaTestError {
	public static WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void main() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CampoDeBuscaTestObjectError.Busca(driver).click();
		CampoDeBuscaTestObjectError.completa(driver).sendKeys("celular" + Keys.ENTER);
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("C:\\Users\\gehaime.silva\\Pictures\\ReportTDD.Erros\\BuscaDeProdutoFalhou.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("Busca de celular nao realizada");

		
	}
		@AfterMethod
		public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		takeSnapShot.tirarPrintsDeFalhas("Busca na lupa falhou ", driver);
		String resposta = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span\r\n")).getText();
		System.out.println(resposta);
		Assert.assertTrue(resposta.equals("No results for \"celular\""),"Produto nao encontrado");
		extensao.flush();
		driver.quit();

	
	}
}
