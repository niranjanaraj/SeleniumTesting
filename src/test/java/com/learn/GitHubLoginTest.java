package com.learn;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import com.learn.GitHubLogin;


public class GitHubLoginTest
{
	@Test
	public void testLogin1(){
		String userName = System.getProperty("validUserName");
		
		String password = System.getProperty("validPassword");
		System.out.println(userName+" - "+password);
		assertTrue("Login Success",new GitHubLogin().login(userName,password));
	}
	
	@Test
	public void testLogin2(){
		String userName = System.getProperty("validUserName");
		String password = System.getProperty("inValidPassword");
		System.out.println(userName+" - "+password);
		assertTrue("Login Failure",new GitHubLogin().login(userName,password));
	}
}

