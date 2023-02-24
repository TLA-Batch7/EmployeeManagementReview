package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    private LoginPage page;
    private HomePage homePage;

    @BeforeMethod
    public void setUp(){
        page = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(testName = "Verify user can login as a user")
    public void test01(){
        page.signInAsDefaultUser();
        Assert.assertTrue(homePage.pageWelcomeTxt.getText().toLowerCase().contains("user"));
    }

    @Test(testName = "Verify user can login as an admin")
    public void test02(){
        page.signInAsAdmin();
        Assert.assertTrue(homePage.pageWelcomeTxt.getText().toLowerCase().contains("admin"));
    }
}
