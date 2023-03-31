package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RentalPropertyFinancePage extends HomePage{

    public RentalPropertyFinancePage(ChromeDriver driver) {
        super(driver);
    }


    By cookies_button = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/button/span[1]");
    By property_value_textbox = By.id("mui-1");
    By monthly_rental_income_textbox = By.id("mui-2");
    By down_payment_textbox = By.id("mui-3");
    By drop_down_menu = By.xpath("/html/body/div/div/main/div/main/section[1]/div[4]/div[2]");
    By select_frist_one = By.tagName("li");
    By finance_amount_field = By.xpath("/html/body/div/div/main/div/main/section[2]/section/h2");
    By monthly_costs_field = By.xpath("/html/body/div/div/main/div/main/section[2]/section/h3");
    By validation_msg_down_payment = By.className("mc-form_ValidationMsgError__JNryE");


    public String getUrl() {
        return Url+"rental-property-finance";
    }


    public void acceptCookies(){
        this.driver.findElement(cookies_button).click();
    }

    public void clearPropertyValueTextbox(){
        this.driver.findElement(property_value_textbox).sendKeys(Keys.CONTROL + "a");
        this.driver.findElement(property_value_textbox).sendKeys(Keys.DELETE);
    }

    public void enterPropertyValueTextbox(String value){
        this.driver.findElement(property_value_textbox).sendKeys(value);
    }

    public void enterMonthlyRentalIncomeTextbox(String value){
        this.driver.findElement(monthly_rental_income_textbox).sendKeys(value);
    }

    public void enterDownPaymentTextbox(String value){
        this.driver.findElement(down_payment_textbox).sendKeys(value);
    }

    public void clickDropDownMenu(){
        this.driver.findElement(drop_down_menu).click();
    }

    public void selectfirstone() throws InterruptedException {
        List<WebElement> ListItems = driver.findElements(select_frist_one);
        Thread.sleep(1000);
        ListItems.get(0).click();
        System.out.println(ListItems.get(0));

    }

    public String getFinanceAmount(){
        String finance_amount = this.driver.findElement(finance_amount_field).getText();
        return finance_amount;
    }

    public String getValidationMsgForDownPayment(){
        String validation_msg = this.driver.findElement(validation_msg_down_payment).getText();
        return validation_msg;
    }

    public String getMonthlyCost(){
        String monthly_cost = this.driver.findElement(monthly_costs_field).getText();
        return monthly_cost;
    }


}
