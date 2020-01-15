package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import br.com.rsinet.hub_tdd.PageObject.CadastroClienteObject;
import br.com.rsinet.hub_tdd.Util.Constant;
import br.com.rsinet.hub_tdd.Util.ProjetoExcel;
import br.com.rsinet.hub_tdd.UtilExcel.takeSnapShot;

public class CadastroDeCliente  {
	public static WebDriver driver;

	@BeforeTest
	public void beforeMethod() throws Exception {
		driver = new ChromeDriver();

		ProjetoExcel.setExcelFile(Constant.caminho + Constant.arquivo, "Planilha1");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
		CadastroClienteObject.novaconta(driver).click();
		CadastroClienteObject.CriarNovaConta(driver).sendKeys(Keys.ENTER);
	}

	@Test
	public void main() throws Exception {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		CadastroClienteObject.UserName(driver).sendKeys(ProjetoExcel.getCellData(0, 1));
		CadastroClienteObject.password(driver).sendKeys(ProjetoExcel.getCellData(2, 1));
		CadastroClienteObject.email(driver).sendKeys(ProjetoExcel.getCellData(1, 1));
		CadastroClienteObject.confirmPassword(driver).sendKeys(ProjetoExcel.getCellData(3, 1));
		CadastroClienteObject.firstname(driver).sendKeys(ProjetoExcel.getCellData(4, 1));
		CadastroClienteObject.lastname(driver).sendKeys(ProjetoExcel.getCellData(5, 1));
		CadastroClienteObject.phonenumber(driver).sendKeys(ProjetoExcel.getCellData(6, 1));
		CadastroClienteObject.selecionaPais(driver).selectByVisibleText(ProjetoExcel.getCellData(7, 1));
		CadastroClienteObject.City(driver).sendKeys(ProjetoExcel.getCellData(8, 1));
		CadastroClienteObject.address(driver).sendKeys(ProjetoExcel.getCellData(9, 1));
		CadastroClienteObject.state(driver).sendKeys(ProjetoExcel.getCellData(10, 1));
		CadastroClienteObject.postalcode(driver).sendKeys(ProjetoExcel.getCellData(11, 1));

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		CadastroClienteObject.Concordo(driver).click();
		CadastroClienteObject.register(driver).click();
		takeSnapShot.screenShot(driver);

	}

}
