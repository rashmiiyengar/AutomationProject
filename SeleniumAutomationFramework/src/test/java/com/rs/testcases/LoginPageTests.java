package com.rs.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.rs.pages.LoginPage;
import com.rs.utils.DataProviderUtils;

public final class LoginPageTests extends BaseTest {
	
	private LoginPageTests() {
		
	}
	
	@Test(dataProvider = "LoginTestdataProvider",dataProviderClass = DataProviderUtils.class)
	public void loginlogouttest(Map<String,String> data) throws Exception {
		//LoginPage lp= new LoginPage();
		//"ananya111@gmail.com" "Ananya@123"
		
		
		String lpt= new LoginPage().enterUserName(data.get("username"))
				.enterPassword(data.get("password")).clickLogin().logout()
				.getTitle();
		
		Assertions.assertThat(lpt)
		.isEqualTo("Let's Shop");
		System.out.println("test1");	
	}
	
	@Test(dataProvider = "LoginTestdataProvider",dataProviderClass = DataProviderUtils.class)
	public void newtest(Map<String,String> data) throws Exception {
		//LoginPage lp= new LoginPage();
		//"ananya111@gmail.com" "Ananya@123"
		
		
		String lpt= new LoginPage().enterUserName(data.get("username"))
				.enterPassword(data.get("password")).clickLogin().logout()
				.getTitle();
		
		Assertions.assertThat(lpt)
		.isEqualTo("Let's Shop");
		System.out.println("test1");	
	}
	
	
	//@DataProvider(name="LoginTestdataProvider",parallel=true)
	//public Object[][] getData(){
		
		//return new Object[][] {
			
		//	{"ananya111@gmail.com","Ananya@123"},
			//{"trisha@gmail.com","Test@123"}
		//};
	//}
}
