package br.com.rsinet.hub_tdd.UtilExcel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class takeSnapShot {
	//public static WebDriver driver;

	public static void takeScreenshot(String nomeDoArquivoImagem, WebDriver driver){

		File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\gehaime.silva\\Pictures\\Testes\\" + nomeDoArquivoImagem + ".png";
		try {
			FileUtils.copyFile(scrShot, new File(imageFileDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
