package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "banner-container")
    public WebElement pageBanner;

    @FindBy(id = "searchval")
    public WebElement searchBox;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@name=\"addToCartButton\"]")
    public List<WebElement> addToCartButtonElementList;

    @FindBy(xpath = "//div[@id=\"details\"]")
    public List<WebElement> productList;

    @FindBy(xpath = "//div[@id=\"details\"]")
    public List<WebElement> pageNumberList;

    @FindBy(xpath = "//div[@id=\"paging\"]//nav//ul//li[@class=\"rc-pagination-next\"]")
    public WebElement paginationNext;

    @FindBy(xpath = "//a[@class=\"group flex self-center leading-3 mt-0 no-underline hover:no-underline\"]//span")
    public WebElement viewCartIcon;

    @FindBy(xpath = "//button[@class=\"close\"]")
    public WebElement viewCartCloseButton;

    @FindBy(xpath = "(//a[@class=\"deleteCartItemButton itemDelete__link itemDelete--positioning\"])[1]")
    public WebElement deleteProductIcon;

    @FindBy(xpath = "//p[@class=\"header-1\"]")
    public WebElement cartEmptyText;



}