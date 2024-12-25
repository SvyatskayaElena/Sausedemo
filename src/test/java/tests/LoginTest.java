package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isPageOpened());
    }

    @Test
    public void checkLoginWithEmptyUsername() {
        loginPage.open();
        loginPage.loginWithNegativeValue("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.loginWithNegativeValue("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

    }
}
