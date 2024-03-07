package com.rs.testcases;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rs.pages.LoginPage;

public final class LoginPageTests extends BaseTest {
	
	private LoginPageTests() {
		
	}
	
	@Test(dataProvider = "LoginTestdataProvider")
	public void loginlogouttest(String username, String password) throws Exception {
		//LoginPage lp= new LoginPage();
		//"ananya111@gmail.com" "Ananya@123"
		
		
		String lpt= new LoginPage().enterUserName(username)
				.enterPassword(password).clickLogin().logout()
				.getTitle();
		
		Assertions.assertThat(lpt)
		.isEqualTo("Let's Shop");
		System.out.println("test1");	
	}
	
	@Test(dataProvider = "LoginTestdataProvider")
	public void newtest(String username, String password) throws Exception {
		//LoginPage lp= new LoginPage();
		//"ananya111@gmail.com" "Ananya@123"
		
		
		String lpt= new LoginPage().enterUserName(username)
				.enterPassword(password).clickLogin().logout()
				.getTitle();
		
		Assertions.assertThat(lpt)
		.isEqualTo("Let's Shop");
		System.out.println("test1");	
	}
	
	
	@DataProvider(name="LoginTestdataProvider",parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			
			{"ananya111@gmail.com","Ananya@123"},
			//{"trisha@gmail.com","Test@1234"}
		};
	}
}
