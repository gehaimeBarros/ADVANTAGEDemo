package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaDeProdutoObject {
	public static WebElement element = null;

	public static WebElement headphones(WebDriver driver) {
		element = driver.findElement(By.id("headphonesImg"));
		return element;
		
}
	public static WebElement LOGITECHUSBHEADSETH390(WebDriver driver) {
		element = driver.findElement(By.linkText("Logitech USB Headset H390"));
		return element;
}
	public static WebElement color(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[1]/div[1]/span[2]"));
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