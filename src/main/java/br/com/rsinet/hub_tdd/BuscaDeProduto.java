package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsinet.hub_tdd.PageObject.BuscaDeProdutoObject;
import br.com.rsinet.hub_tdd.UtilExcel.TakeSnapShotAcertos;

public class BuscaDeProduto {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");

	}

	@Test
	public void main() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BuscaDeProdutoObject.headphones(driver).click();
		BuscaDeProdutoObject.LOGITECHUSBHEADSETH390(driver).click();
		BuscaDeProdutoObject.color(driver).click();
		BuscaDeProdutoObject.AdicioneNoCarrinho(driver).click();

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BuscaDeProdutoObject.Check(driver).click();
		TakeSnapShotAcertos.tirarPrintsDeAcerto("Compra de produto", driver);

	}

}
