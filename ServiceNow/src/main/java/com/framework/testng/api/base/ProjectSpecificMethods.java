package com.framework.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}

	@BeforeMethod
	public void preCondition() {
		//public void startApp(String browser, boolean headless, String url);
		startApp("chrome", false, "https://dev240718.service-now.com");
		setNode();
	}

	
	public void postCondition() {
		close();

	}

	
}
