package servicenow.positive_testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;

import servicenow.pages.LoginPage;


public class TC_001_VerifyLogin extends ProjectSpecificMethods {
	
	@Test
	public void runLogin() throws InterruptedException {
		
		new LoginPage()
				.enterUsername()
				.enterPassword()
				.clickLogin()
				.verifyLogin("ServiceNow");
				
	}
	
	@BeforeTest
	public void setValues() {
		testcaseName = "VerifyLogin";
		testDescription ="Verify Login functionality with positive data";
		authors="Karthi";
		category ="Smoke";
//		excelFileName="Login";
	}
	

}
