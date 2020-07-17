package autoapp.automation.pages;

import autoapp.automation.utility.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BasePage{

    private WebDriver driver;
    public String signIn_xpath = "//a[@title='Log in to your customer account']";
    public String email_id = "email_create";
    public String createAccount_xpath = "//form[@id='create-account_form']//span[1]";

    public RegisterPage(BaseUtil baseUtil) {
        super(baseUtil);
        this.driver = baseUtil.driver;
    }

    public void openApplicaiton() {
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    public void clickSignIn() {
        driver.findElement(By.xpath(signIn_xpath)).click();
    }

    public void createAccount(String emailid) {
        emailid= emailid.replaceAll("Random", Integer.toString(generateRandomIntIntRange(00000, 99999)));
        //emailid = "abc@gmail.com";
        driver.findElement(By.id(email_id)).sendKeys(emailid);
        driver.findElement(By.xpath(createAccount_xpath)).click();
    }
}
