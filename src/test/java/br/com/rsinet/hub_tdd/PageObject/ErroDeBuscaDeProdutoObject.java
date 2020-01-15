package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErroDeBuscaDeProdutoObject {
	public static WebElement element = null;

	public static WebElement CaixaDeSom(WebDriver driver) {
		element = driver.findElement(By.id("speakersImg"));
		return element;
}
	public static WebElement HPS9500BLUETOOTHWIRELESSSPEAKER(WebDriver driver) {
		element = driver.findElement(By.id("19"));
		return element;
}
	public static WebElement Quantidade(WebDriver driver) {
		element = driver.findElement(By.name("quantity"));
		return element;
}
	public static WebElement SalvarNoCarinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}
}

