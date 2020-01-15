package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsinet.hub_tdd.PageObject.CampoDeBuscaTestObjectError;
import br.com.rsinet.hub_tdd.UtilExcel.takeSnapShot;

public class CampoDeBuscaTestError {
	public static WebDriver driver;

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
		
	}
		@AfterMethod
		public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		takeSnapShot.screenShot(driver);
		String resposta = driver.findElement(By.xpath("		//*[@id=\"searchPage\"]/div[3]/div/label/span\r\n")).getText();
		System.out.println(resposta);
		Assert.assertFalse(resposta.equals("No results for \"celular\""),"Produto nao encontrado");
	
	}
}
