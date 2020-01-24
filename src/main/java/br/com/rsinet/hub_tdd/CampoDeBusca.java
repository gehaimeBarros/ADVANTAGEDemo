package br.com.rsinet.hub_tdd;

//import java.io.File;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.PageObject.CampoDeBuscaObject;
import br.com.rsinet.hub_tdd.UtilExcel.TakeSnapShotAcertos;

public class CampoDeBusca  {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
		CampoDeBuscaObject.Busca(driver).click();
		CampoDeBuscaObject.completa(driver).sendKeys("tablets" + Keys.ENTER);
	}

	@Test
	public void main() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		CampoDeBuscaObject.ELITEX21011G1TABLE(driver).click();
		CampoDeBuscaObject.AdicionaNoCarrinho(driver).click();

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		CampoDeBuscaObject.Checkk(driver).click();
		TakeSnapShotAcertos.tirarPrintsDeAcerto("Busca na lupa", driver);
		driver.quit();

	}
}
