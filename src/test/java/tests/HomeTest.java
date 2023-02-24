package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BrowserUtils;

public class HomeTest extends BaseTest{
    HomePage page;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        page = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(testName = "As a user I should be able to add a new employee")
    public void test01(){
        //login as a user
        loginPage.signInAsDefaultUser();

        //fill out the employee form on homepage
        String expectedID = page.addNewEmployee();

        BrowserUtils.sleep(2000L);

        //verify new employee was added to the table
        for(WebElement each: page.allEmployeeIds){
            if (each.getText().equalsIgnoreCase(expectedID)) {
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail();
    }
}
