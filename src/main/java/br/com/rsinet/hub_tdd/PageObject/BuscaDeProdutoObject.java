package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaDeProdutoObject {
	public static WebElement element = null;

	public static WebElement laptop(WebDriver driver) {
		element = driver.findElement(By.id("laptopsImg"));
		return element;
		
}
	public static WebElement ENVY17TTOUCH(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[2]/ul/li[3]/p[1]/a"));
		return element;
}
	public static WebElement AdicioneNoCarrinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
}
	public static WebElement Check(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		return element;
	}
}