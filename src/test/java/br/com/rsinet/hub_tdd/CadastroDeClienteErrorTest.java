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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.PageObject.CadastroDeClienteTestObjectError;


public class CadastroDeClienteErrorTest {
	public static WebDriver driver;

	@Test
	public void test() throws Exception {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CadastroDeClienteTestObjectError.novaconta(driver).click();
		CadastroDeClienteTestObjectError.CriarNovaConta(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains (@class, 'create-new-account')]")));
		element.sendKeys(Keys.ENTER);
		CadastroDeClienteTestObjectError.UserName(driver).sendKeys("Gehseeaime");
		CadastroDeClienteTestObjectError.email(driver).sendKeys("gehaime.silva@rsinet.com.br");
		CadastroDeClienteTestObjectError.password(driver).sendKeys("StarTrek12345678");
		CadastroDeClienteTestObjectError.confirmPassword(driver).sendKeys("StarTrek12345678");
		CadastroDeClienteTestObjectError.firstname(driver).sendKeys("Gehaime");
		CadastroDeClienteTestObjectError.lastname(driver).sendKeys("Barros");
		CadastroDeClienteTestObjectError.phonenumber(driver).sendKeys("947858484");
		CadastroDeClienteTestObjectError.password(driver).sendKeys("");
		Select Oselect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Oselect.selectByVisibleText("Uzbekistan");
		CadastroDeClienteTestObjectError.City(driver).sendKeys("Sao Paulo");
		CadastroDeClienteTestObjectError.address(driver).sendKeys("Osasco");
		CadastroDeClienteTestObjectError.state(driver).sendKeys("Brasil");
		CadastroDeClienteTestObjectError.postalcode(driver).sendKeys("03454-230");
		CadastroDeClienteTestObjectError.Concordo(driver).click();
		CadastroDeClienteTestObjectError.register(driver).click();

		String resposta = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/label"))
				.getText();
		System.out.println(resposta);
		Assert.assertFalse("Senha incorreta", resposta.equals("Use maximum 12 character"));

		takeSnapShot("teste.png");
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {

		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String imageFileDir = "C:\\Users\\gehaime.silva\\Pictures\\Testes";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));

	}

}
