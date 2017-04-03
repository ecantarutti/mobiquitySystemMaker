package steps;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class UiSteps extends Steps{
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
	
	@Then("I click on the 'Add New' button")
	public void addNewW(){
		PageObjectModel.addItem(driver).click();
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

	@When("I search for the entry with the title of: '$title'")
	public void searchItem(String title){
		PageObjectModel.searchBox(driver).click();
		PageObjectModel.searchBox(driver).sendKeys(title);
	}
	
	@Then("I click for the entry with the title of: '$title'")
	public void clickOnItem(String title){
		PageObjectModel.textLink(driver, title).click();
	}
	
	@Then("I delete this entry")
	public void deleteItem(){
		PageObjectModel.deleteItem(driver).click();
	}
	@Then("I choose to edit this entry")
	public void clickOnEditItem(){
		PageObjectModel.editItem(driver).click();
	}
	@When("I go back to the main screen")
	public void backToMain(){
		PageObjectModel.backToMainPage(driver).click();
	}
	
	@Then("I confirm the deletion")
	public void okDeletion(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@Then("I don't confirm the deletion")
	public void voidDeletion(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@When("I enter the date $date in the Introduced Date field")
	public void introducedDate(String date) {
		WebElement intrDate = driver.findElement(By.id("introduced"));
		intrDate.clear();
		intrDate.sendKeys(date);
	}

	@When("I enter the date $date in the Discontinued Date field")
	public void discontinuedDate(String date) {
		WebElement discDate = driver.findElement(By.id("discontinued"));
		discDate.clear();
		discDate.sendKeys(date);
	}
	
	@Then("I click on the 'next page' button")
	@When("I click on the 'next page' button")
	public void clickOnNextPage(){
		WebElement buttonNext = driver.findElement(By.xpath("//a[contains(., 'Next →')]"));
		buttonNext.click();
	}
	
	@Then("I click on the 'previous page' button")
	public void clickOnPreviousPage(){
		WebElement buttonNext = driver.findElement(By.xpath("//a[contains(., '← Previous')]"));
		buttonNext.click();
	}
	
	@When("I choose $company from the Company dropdown")
	@Then("I choose $company from the Company dropdown")
	public void selectingCompany(String company) {
		WebElement dropdown = driver.findElement(By.id("company"));
		dropdown.click();
		Select item = new Select(dropdown);
		item.selectByVisibleText(company);
	}

	
	@Then("I search for the computer with the name of $pcname")
	public void searchingForAComputer(String pcname){
		WebElement searchField = driver.findElement(By.cssSelector("#searchbox"));
		searchField.click();
		searchField.sendKeys(pcname);
		searchField.sendKeys(Keys.ENTER);
	}
	
	@Then("I open the previously created computer whose name is $name")
	public void openingAComputer(String name){
		WebElement computer = driver.findElement(By.partialLinkText(name));
		computer.click();
		currentUrl = driver.getCurrentUrl();
		
	}
	
	@Then("I update the Introduced and Discontinued dates with $intDate and $discDate respectively")
	public void updatingDates(String intDate, String discDate){
		discontinuedDate(discDate);
		introducedDate(intDate);
	}
	
	@Then("I click on the 'Delete this computer' button")
	public void deleteComputer(){
		driver.findElement(By.cssSelector(".btn.danger")).click();
	}
	
	@Then("I click on the 'Cancel' button")
	public void cancelComputer(){
		driver.findElement(By.xpath("//a[contains(., 'Cancel')]")).click();
	}
	
	@Then("I verify that the message '$message' is displayed on screen")
	public void verifyText(String message){
		assertText(message);
	}
	
	@Then("I verify that the format of the date isn't correct")
	public void errorOnDateFormat(){
		driver.findElement(By.cssSelector(".clearfix.error"));
	}
	
	@Then("I verify that no new computer can be created with an empty name")
	public void emptyComputerName(){
		errorOnDateFormat();
	}
	
	@Then("I verify that I'm on page number $pageNumber")
	public void pageNumber(String pageNumber){
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith(pageNumber));
	}
	
	@Then("I verify that I'm on the main page")
	public void mainPage(){
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(!currentUrl.contains("?p="));
	}
	
	private void assertText(String message){
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains(message));
	}
	
	
}
