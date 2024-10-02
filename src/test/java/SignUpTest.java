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
        driver.get("https://automationexercise.com/");


        /****/
     }
    @Test
    public void test() throws InterruptedException {
        /*declare mail as var to change in one var*/
        String mail = "jibox11202@sigmazon.com";
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
        emailAddressTxt.sendKeys(mail);
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

        Thread.sleep(1000);
    }
    @AfterTest
    public void finish ()
    {
        driver.quit();
        System.out.println("finish task");
        /*test ahmed abdelnasser*/
    }

}
