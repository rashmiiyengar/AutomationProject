package com.rs.testcases;

import org.assertj.core.api.Assertions;

import org.testng.annotations.Test;
import com.rs.pages.LoginPage;


public final class LoginPageTests extends BaseTest {
	
	private LoginPageTests() {
		
	}
	 
	@Test  
	public void loginTest() {
		
		//LoginPage lp= new LoginPage();
		String lpt= new LoginPage().enterUserName("ananya111@gmail.com")
				.enterPassword("Ananya@123").clickLogin().logout()
				.getTitle();
		
		Assertions.assertThat(lpt)
		.isEqualTo("Let's Shop");
		System.out.println("test1");
		
	}
	


}
