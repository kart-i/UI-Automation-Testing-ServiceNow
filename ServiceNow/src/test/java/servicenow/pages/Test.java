package servicenow.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	
	    public static void main(String[] args) {
	        // Let WebDriverManager handle the driver setup
	        WebDriverManager.chromedriver().setup();

	        // Initialize the browser driver
	        WebDriver driver = new ChromeDriver();

	        // Perform browser actions
	        driver.get("https://www.facebook.com");
	        System.out.println(driver.getTitle());

	        // Quit the browser
	        driver.quit();
	    }
}


