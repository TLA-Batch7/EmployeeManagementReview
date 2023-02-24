package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage extends BasePage{
    private WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='navbar-brand']/h5")
    public WebElement pageWelcomeTxt;

    @FindBy(name = "id")
    public WebElement idField;

    @FindBy(name = "firstName")
    public WebElement firstNameField;

    @FindBy(name = "lastName")
    public WebElement lastNameField;

    @FindBy(name = "role")
    public WebElement roleSelection;

    @FindBy(name = "department")
    public WebElement departmentSelection;

    @FindBy(xpath = "//button[text()='Enter Employee']")
    public WebElement enterEmployeeBtn;

    @FindBy(xpath = "//tbody//th")
    public List<WebElement> allEmployeeIds;


    public String addNewEmployee(){
        Faker faker = new Faker();
        String id = faker.idNumber()+"";

        idField.sendKeys(id);
        firstNameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
        BrowserUtils.selectByIndex(roleSelection, 1);
        BrowserUtils.selectByIndex(departmentSelection, 1);
        enterEmployeeBtn.click();

        return id;
    }

}
