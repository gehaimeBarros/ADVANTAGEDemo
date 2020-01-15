package br.com.rsinet.hub_tdd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.PageObject.CadastroClienteObject;
import br.com.rsinet.hub_tdd.PageObject.CadastroDeClienteTestObjectError;
import br.com.rsinet.hub_tdd.UtilExcel.takeSnapShot;

public class CadastroDeClienteErrorTest{
	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
		CadastroDeClienteTestObjectError.novaconta(driver).click();
		CadastroClienteObject.CriarNovaConta(driver).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains (@class, 'create-new-account')]")));
		element.sendKeys(Keys.ENTER);
	}

	@Test
	public void main() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CadastroDeClienteTestObjectError.UserName(driver).sendKeys("Gehseeaime");
		CadastroDeClienteTestObjectError.email(driver).sendKeys("gehaime.silva@rsinet.com.br");
		CadastroDeClienteTestObjectError.password(driver).sendKeys("StarTrek12345678");
		CadastroDeClienteTestObjectError.confirmPassword(driver).sendKeys("StarTrek12345678");
		CadastroDeClienteTestObjectError.firstname(driver).sendKeys("Gehaime");
		CadastroDeClienteTestObjectError.lastname(driver).sendKeys("Barros");
		CadastroDeClienteTestObjectError.phonenumber(driver).sendKeys("947858484");
		CadastroDeClienteTestObjectError.password(driver).sendKeys("");
		CadastroClienteObject.selecionaPais(driver).selectByVisibleText("Denmark");
		CadastroDeClienteTestObjectError.City(driver).sendKeys("Sao Paulo");
		CadastroDeClienteTestObjectError.address(driver).sendKeys("Osasco");
		CadastroDeClienteTestObjectError.state(driver).sendKeys("Brasil");
		CadastroDeClienteTestObjectError.postalcode(driver).sendKeys("03454-230");

	}

	@AfterMethod
	public void afterMethod() throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CadastroDeClienteTestObjectError.Concordo(driver).click();
		CadastroDeClienteTestObjectError.register(driver).click();
		takeSnapShot.screenShot(driver);
		String resposta = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/label")).getText();
		System.out.println(resposta);
		Assert.assertFalse(resposta.equals("Use maximum 12 character"),"Senha incorreta");

	}
}
