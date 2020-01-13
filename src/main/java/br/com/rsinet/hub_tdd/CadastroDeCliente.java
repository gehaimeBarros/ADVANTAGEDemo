package br.com.rsinet.hub_tdd;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

import br.com.rsinet.hub_tdd.PageObject.CadastroClienteObject;


public class CadastroDeCliente {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CadastroClienteObject.novaconta(driver).click();
		CadastroClienteObject.CriarNovaConta(driver).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains (@class, 'create-new-account')]")));
		element.sendKeys(Keys.ENTER);
		CadastroClienteObject.UserName(driver).sendKeys("Geheaime");
		CadastroClienteObject.email(driver).sendKeys("gehaime.silva@rsinet.com.br");
		CadastroClienteObject.password(driver).sendKeys("StarTrek123");
		CadastroClienteObject.confirmPassword(driver).sendKeys("StarTrek123");
		CadastroClienteObject.firstname(driver).sendKeys("Gehaime");
		CadastroClienteObject.lastname(driver).sendKeys("Barros");
		CadastroClienteObject.phonenumber(driver).sendKeys("947858484");
		CadastroClienteObject.password(driver).sendKeys("");
		Select Oselect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Oselect.selectByVisibleText("Uzbekistan");
		CadastroClienteObject.City(driver).sendKeys("Sao Paulo");
		CadastroClienteObject.address(driver).sendKeys("Osasco");
		CadastroClienteObject.state(driver).sendKeys("Brasil");
		CadastroClienteObject.postalcode(driver).sendKeys("03454-230");
		CadastroClienteObject.Concordo(driver).click();
		CadastroClienteObject.register(driver).click();

		takeSnapShot("teste.png");
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\gehaime.silva\\Pictures\\Testes/";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));

	}

}
