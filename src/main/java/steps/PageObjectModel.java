package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectModel {

	private static WebElement element = null;

	public static WebElement login(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href = '#!login']"));
		return element;
	}

	public static WebElement emailField(WebDriver driver) {
		element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@class = 'ng-pristine ng-untouched ng-invalid ng-invalid-required']")));
		element = driver
				.findElement(By.xpath("//input[@class = 'ng-pristine ng-untouched ng-invalid ng-invalid-required']"));
		return element;
	}

	public static WebElement passwordField(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@ng-model = 'user.password']"));
		return element;
	}

	public static WebElement loginButton(WebDriver driver) {
		element = driver.findElement(By.className("btn  btn-default"));
		return element;
	}

	public static WebElement addItem(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class = 'btn btn-primary btn-sm']"));
		return element;
	}

	public static WebElement addNewTitle(WebDriver driver) {
		element = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[ng-model='new.title_en']")));
		element = driver.findElement(By.cssSelector("input[ng-model='new.title_en']"));
		return element;
	}

	public static WebElement closeSuccesLoginMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class = 'close']"));
		return element;
	}

	public static WebElement searchBox(WebDriver driver) {
		element = driver.findElement(By.cssSelector("input[ng-model='searchInput']"));
		return element;
	}

	public static WebElement submitButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='searchInput']"));
		return element;
	}

	public static WebElement parentId(WebDriver driver) {
		element = driver.findElement(By.cssSelector("input[ng-model='new.parent_id']"));
		return element;
	}

	public static WebElement textLink(WebDriver driver, String textLocator) {
		element = driver.findElement(By.linkText(textLocator));
		return element;
	}

	public static WebElement deleteItem(WebDriver driver) {
		element = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@ng-really-click='deleteItem(item.id)']")));
		element = driver.findElement(By.xpath("//a[@ng-really-click='deleteItem(item.id)']"));
		return element;
	}
	
	public static WebElement editItem(WebDriver driver) {
		element = (new WebDriverWait(driver, 10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='glyphicon glyphicon-pencil']")));
		element = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-pencil']"));
		return element;
	}
	public static WebElement backToMainPage(WebDriver driver){
		element = driver.findElement(By.cssSelector(".navbar-brand.topnav.ng-binding"));
		return element;
	}
	
	public static WebElement languageDropdown(WebDriver driver){
		element = driver.findElement(By.cssSelector(".dropdown-toggle.ng-binding"));
		return element;
	}
	public static WebElement selectFrench(WebDriver driver){
		element = driver.findElement(By.partialLinkText("french"));
		return element;
	}
	

}
