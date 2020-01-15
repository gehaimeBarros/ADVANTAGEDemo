package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.PageObject.ErroDeBuscaDeProdutoObject;
import br.com.rsinet.hub_tdd.UtilExcel.takeSnapShot;

public class ErroDeBuscaDeProdutoTest {
	public static WebDriver driver;

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

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String resposta = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/label")).getText();
		takeSnapShot.screenShot(driver);
		System.out.println(resposta);
		Assert.assertFalse(resposta.equals("HP ENVY X360 - 15T LAPTOP"), "Excedeu o estoque");

	}
}
