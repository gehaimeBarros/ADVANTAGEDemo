package br.com.rsinet.hub_tdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjetoEmConjunto {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"menuUserSVGPath\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).click();
		driver.findElement(By.name("usernameRegisterPage")).sendKeys("Gehdaime");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("gehaime.silva@rsinet.com.br");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("StarTrek123");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("StarTrek123");
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Gehaime");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Barros");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("947858484");
		Select Oselect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Oselect.selectByVisibleText("Uzbekistan");
		driver.findElement(By.name("cityRegisterPage")).sendKeys("Brasil");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Osasco");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Brasil");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("08798-250");
		driver.findElement(By.name("i_agree")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("register_btnundefined")).click();

		// driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"laptopsImg\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("HP Pavilion 15z Laptop")).click();
		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();
		driver.findElement(By.id("checkOutPopUp")).click();
		// driver.findElement(By.id("/html/body/header")).click();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("mice");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a/div/div[2]/div/div[2]/a[3]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();
		driver.findElement(By.id("checkOutPopUp")).click();
		// driver.findElement(By.xpath("//*[@id=\"productProperties\"]/div[3]/button")).click();

	}
}
