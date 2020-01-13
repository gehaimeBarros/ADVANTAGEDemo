package br.com.rsinet.hub_tdd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();

	//	driver.manage().window().maximize();

		driver.get("https://www.advantageonlineshopping.com/#/");
	}
}
