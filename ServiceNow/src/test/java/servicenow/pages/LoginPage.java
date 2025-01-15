package servicenow.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;



public class LoginPage extends ProjectSpecificMethods {
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	public LoginPage enterUsername() {
		WebElement username = locateElement("user_name");
		clearAndType(username, "admin");
		reportStep("Username entered successfully", "pass");
		return this;
	}
	
	public LoginPage enterPassword() {
		WebElement password = locateElement("user_password");
		clearAndType(password, "x-HR9quE5sT=");
		reportStep("Password entered successfully", "pass");
		return this;
		
		
	}
	
	public LoginPage clickLogin() {
		click(Locators.ID, "sysverb_login");
		return this;
	}
	
	public  LoginPage verifyLogin(String pageTitle) throws InterruptedException {
		
		
		WebElement shadowHost1 = locateElement(Locators.CSS,"macroponent-f51912f4c700201072b211d4d8c26010");
		Object shadowRoot1 =  js.executeScript("return arguments[0].shadowRoot", shadowHost1);
		
		WebElement shadowHost2 = ((SeleniumBase) shadowRoot1).locateElement(Locators.CSS,"sn-canvas-appshell-root");
		Object shadowRoot2 = getShadowRoot(shadowHost2);
		
		WebElement shadowHost3 = ((SeleniumBase) shadowRoot2).locateElement(Locators.CSS,"sn-canvas-appshell-layout");
		Object shadowRoot3 = getShadowRoot(shadowHost3);
	
		
		WebElement shadowHost4 = (WebElement)((SeleniumBase) shadowRoot3).locateElement(Locators.CSS,"sn-polaris-layout");
		Object shadowRoot4 = getShadowRoot(shadowHost4);
		
		WebElement iframe =   ((SeleniumBase) shadowRoot4).locateElement(Locators.CSS,"iframe");
		
		getDriver().switchTo().frame(iframe);
		
		try {
		    WebElement iframeContent = locateElement(Locators.TAGNAME,"button");
		    if (iframeContent.isDisplayed()) {
		        System.out.println("Iframe loaded successfully.");
		    } else {
		        System.out.println("Iframe is not fully loaded.");
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("Iframe content not found.");
		}
		
		
		verifyTitle(pageTitle);	
		return this;
		
	}
	
	public Object getShadowRoot(WebElement shadowHost) {
		
		return  js.executeScript("return arguments[0].shadowRoot", shadowHost);
			
	}
	
	
	
	
	
	

}
