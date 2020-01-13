package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CampoDeBuscaTestObjectError {
	public static WebElement element = null;

	public static WebElement Busca(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
}
	public static WebElement completa(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}
}
//	public static WebElement ELITEX21011G1TABLE(WebDriver driver) {
//		element = driver.findElement(By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[2]/p[1]/a"));
//		return element;
//	}
//	public static WebElement AdicionaNoCarrinho(WebDriver driver) {
//		element = driver.findElement(By.name("save_to_cart"));
//		return element;
//	}
//	public static WebElement Checkk(WebDriver driver) {
//		element = driver.findElement(By.id("checkOutPopUp"));
//		return element;
//	}
//}

