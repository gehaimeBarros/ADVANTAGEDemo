package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.PageObject.ErroDeBuscaDeProdutoObject;
import br.com.rsinet.hub_tdd.UtilExcel.takeSnapShot;

public class ErroDeBuscaDeProdutoTest {
	public static WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void main() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ErroDeBuscaDeProdutoObject.CaixaDeSom(driver).click();
		ErroDeBuscaDeProdutoObject.HPS9500BLUETOOTHWIRELESSSPEAKER(driver).click();
		ErroDeBuscaDeProdutoObject.Quantidade(driver).sendKeys("100");
		ErroDeBuscaDeProdutoObject.SalvarNoCarinho(driver).click();
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("C:\\Users\\gehaime.silva\\Pictures\\ReportTDD.Erros\\CompraNaoRealizada.html");
        extensao = new ExtentReports();
        extensao.attachReporter(reporte);
        logger = extensao.createTest("Excedeu o estoque");


	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String resposta = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/label")).getText();
		takeSnapShot.tirarPrintsDeFalhas("comprar produto falha ", driver);
		System.out.println(resposta);
		Assert.assertFalse(resposta.equals("HP ENVY X360 - 15T LAPTOP"), "Excedeu o estoque");
		driver.quit();


	}
}
