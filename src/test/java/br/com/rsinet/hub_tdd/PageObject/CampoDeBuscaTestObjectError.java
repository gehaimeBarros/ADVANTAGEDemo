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

