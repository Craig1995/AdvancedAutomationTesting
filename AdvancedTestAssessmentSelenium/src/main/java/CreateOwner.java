import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOwner {

    @FindBy(xpath="//*[@id=\"firstName\"]")
    private WebElement name;

    @FindBy(xpath="//*[@id=\"lastName\"]")
    private WebElement lastName;

    @FindBy(xpath="//*[@id=\"address\"]")
    private WebElement address;

    @FindBy(xpath="//*[@id=\"city\"]")
    private WebElement city;

    @FindBy(xpath ="//*[@id=\"telephone\"]")
    private WebElement telephone;


    public WebElement getName() {
        return name;
    }
    public WebElement getLastName() {
        return lastName;
    }
    public WebElement getAddress() {
        return address;
    }
    public WebElement getCity() {
        return city;
    }
    public WebElement getTelephone() {
        return telephone;
    }
}






