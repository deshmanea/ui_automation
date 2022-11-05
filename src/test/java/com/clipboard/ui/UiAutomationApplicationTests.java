package com.clipboard.ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
class UiAutomationApplicationTests {

	@Autowired
	WebDriver driver;

	@Autowired
	WebDriverWait wait;

	@Test
	public void testWebdriver(){
		Assert.assertNotNull(driver);
	}

}
