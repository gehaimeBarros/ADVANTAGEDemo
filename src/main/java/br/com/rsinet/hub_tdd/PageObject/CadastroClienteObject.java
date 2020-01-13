package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroClienteObject {
	public static WebElement element = null;

	public static WebElement novaconta(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"menuUser\"]"));
		return element;
	}

	public static WebElement CriarNovaConta(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		return element;
	}

	public static WebElement UserName(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		return element;
	}

	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}

	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}

	public static WebElement confirmPassword(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}

	public static WebElement firstname(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		return element;
	}

	public static WebElement lastname(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}

	public static WebElement phonenumber(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}

	public static WebElement City(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;
	}

	public static WebElement address(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}

	public static WebElement state(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}

	public static WebElement postalcode(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}

	public static WebElement Concordo(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;
	}

	public static WebElement register(WebDriver driver) {
		element = driver.findElement(By.id("register_btnundefined"));
		return element;
	}
}

//	
//	
//
