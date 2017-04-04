package steps;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiSteps extends Steps {
	private static WebDriver driver = null;
	public static String currentUrl;

	@BeforeStories
	public static void initialize() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void close(){
		driver.close();
	}

	@Given("I open the url $url")
	public void openUrl(String url) {
		driver.get("http://" + url);
	}

	@When("I click on the 'Login' button")
	public void loginPage() {
		PageObjectModel.login(driver).click();
	}

	@When("I enter '$email' as login email")
	public void inputLoginMail(String email) {
		PageObjectModel.emailField(driver).click();
		PageObjectModel.emailField(driver).sendKeys(email);
	}

	@When("I enter '$password' as password")
	public void inputPassword(String password) {
		PageObjectModel.passwordField(driver).click();
		PageObjectModel.passwordField(driver).sendKeys(password);
		PageObjectModel.passwordField(driver).submit();

	}

	@When("I click on the 'Add New' button")
	@Then("I click on the 'Add New' button")
	public void addNew() {
		PageObjectModel.addItem(driver).click();
	}
	@When("I check the 'Active' checkbox")
	public void checkActiveCheckbox() {
		PageObjectModel.checkActiveCheckBox(driver).click();
	}

	@When("I enter '$title' as title of the new item")
	public void inputTitle(String title) {
		PageObjectModel.addNewTitle(driver).click();
		PageObjectModel.addNewTitle(driver).clear();
		PageObjectModel.addNewTitle(driver).sendKeys(title);
	}

	@When("I enter $parentId as parent id")
	public void parentIdField(String parentId) {
		PageObjectModel.parentId(driver).click();
		PageObjectModel.parentId(driver).clear();
		PageObjectModel.parentId(driver).sendKeys(parentId);
		PageObjectModel.parentId(driver).submit();
	}

	@Then("I search for the entry with the title of: '$title'")
	@When("I search for the entry with the title of: '$title'")
	public void searchItem(String title) {
		PageObjectModel.searchBox(driver).click();
		PageObjectModel.searchBox(driver).sendKeys(title);
	}

	@Then("I click for the entry with the title of: '$title'")
	public void clickOnItem(String title) {
		PageObjectModel.textLink(driver, title).click();
	}

	@Then("I delete this entry")
	public void deleteItem() {
		PageObjectModel.deleteItem(driver).click();
	}

	@Then("I choose to edit this entry")
	public void clickOnEditItem() {
		PageObjectModel.editItem(driver).click();
	}

	@When("I go back to the main screen")
	public void backToMain() {
		PageObjectModel.backToMainPage(driver).click();
	}

	@Then("I confirm the deletion")
	public void okDeletion() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Then("I don't confirm the deletion")
	public void voidDeletion() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	@When("I click on the language dropdown")
	public void langDropdownclick() {
		PageObjectModel.languageDropdown(driver).click();
	}

	@When("I choose 'French' as main language")
	public void selectingFrench() {
		PageObjectModel.selectFrench(driver).click();
	}


	@Then("I verify that the message '$message' is displayed on screen")
	public void verifyText(String message) {
		assertText(message);
	}

	private void assertText(String message) {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains(message));
	}

}
