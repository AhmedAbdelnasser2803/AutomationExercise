import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//-------- change the email when i run the first test case
public class SignUpTest {
    private static WebDriver driver ;
    /*define alocator*/
    private WebElement loginSignUpPage;
    private WebElement emailAddressTxt ;
    private WebElement signUpButton;
    private WebElement nameTxt;
    @BeforeTest
    public void openChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // maximize the screen
        driver.get("https://automationexercise.com/");
     }
    @Test
    public void signUp() throws InterruptedException {
        /*declare mail as var to change in one var*/
        String email = "toucan5698@mailnuo.com";
        /*alocate the login button using css selector */
        loginSignUpPage =  driver.findElement(By.cssSelector("a[href='/login']"));
        loginSignUpPage.click(); // action to click to the button
        /*verify the page using assert function*/
        String expectedloginSignUpPageTitle = "Automation Exercise - Signup / Login";
        String actualloginSignUpPageTitle = driver.getTitle();
        Assert.assertEquals(actualloginSignUpPageTitle,expectedloginSignUpPageTitle);
        /*alocate the name field*/
        nameTxt = driver.findElement(By.name("name"));
        /*alocate email address*/
        emailAddressTxt=driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        /*alocate signUp button*/
        signUpButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
        /*set data in email and name field*/
        nameTxt.sendKeys("ahmed");
        emailAddressTxt.sendKeys(email);
        signUpButton.click();
        /*verfiy the page of signup data*/
        String expectedTitleSignUp = "Automation Exercise - Signup";
        String actualTitleSignUp = driver.getTitle();
        Assert.assertEquals(actualTitleSignUp,expectedTitleSignUp);
        /********************************************************************************/
        /*select gender of the person*/
            /*male*/
        WebElement maleGender = driver.findElement(By.id("id_gender1"));
        maleGender.click();
            /*female*/
        WebElement femaleGender = driver.findElement(By.id("id_gender2"));
        femaleGender.click();        /*delay the thread by using the exception*/
        Thread.sleep(500);
        /*define the drop down list for date of birth*/
        WebElement daysDropDownList=driver.findElement(By.cssSelector("[data-qa='days']"));
        WebElement monthDropDownList=driver.findElement(By.cssSelector("[data-qa='months']"));
        WebElement yearsDropDownList=driver.findElement(By.cssSelector("[data-qa='years']"));
        /*setPassword*/
        WebElement passwordField = driver.findElement(By.cssSelector("[data-qa='password']"));
        passwordField.sendKeys("123456");
        /*select the date of birth to login*/
        /*day*/
        Select selectD = new Select(daysDropDownList);
        selectD.selectByValue("1");
        /*month*/
        Select selectM = new Select(monthDropDownList);
        selectM.selectByValue("1");
        /*year*/
        Select selectY = new Select(yearsDropDownList);
        selectY.selectByValue("1900");
        /* Select checkbox 'Sign up for our newsletter!'*/
        WebElement checkboxNewsletter = driver.findElement(By.name("newsletter"));
        checkboxNewsletter.click();
        /*Select checkbox 'Receive special offers from our partners!'*/
        WebElement checkboxReceiveSpecial = driver.findElement(By.name("optin"));
        checkboxReceiveSpecial.click();
        /*Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number*/
        /*firstName*/
        WebElement Firstname = driver.findElement(By.cssSelector("[data-qa='first_name']"));
        Firstname.sendKeys("ahmed");
        /*lastname*/
        WebElement Lastname = driver.findElement(By.cssSelector("[data-qa='last_name']"));
        Lastname.sendKeys("abdelnasser");
        /*company*/
        WebElement company = driver.findElement(By.cssSelector("[data-qa='company']"));
        company.sendKeys("NTG");
        /*address*/
        WebElement address = driver.findElement(By.cssSelector("[data-qa='address']"));
        address.sendKeys("portsaid");
        /*address2*/
        WebElement address2 = driver.findElement(By.cssSelector("[data-qa='address2']"));
        address.sendKeys("Giza");
        /*country     drop down list*/
        WebElement countryDropDownList = driver.findElement(By.cssSelector("[data-qa='country']"));
        Select selectCountry = new Select(countryDropDownList);
        selectCountry.selectByValue("United States");
        /*State*/
        WebElement stateField = driver.findElement(By.cssSelector("[data-qa='state']"));
        stateField.sendKeys("single");
        /*City*/
        WebElement cityField = driver.findElement(By.cssSelector("[data-qa='city']"));
        cityField.sendKeys("posrtsaid");
        /*Zipcode*/
        WebElement zipcode = driver.findElement(By.cssSelector("[data-qa='zipcode']"));
        zipcode.sendKeys("123456");
        /*MobileNumber*/
        WebElement mobileNumber = driver.findElement(By.cssSelector("[data-qa='mobile_number']"));
        mobileNumber.sendKeys("01025475087");
        /*Click 'Create Account button'*/
        WebElement createAccountBtn = driver.findElement(By.cssSelector("[data-qa='create-account']"));
        createAccountBtn.click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void finish ()
    {

        driver.quit();
        System.out.println("finish task");
    }

}
