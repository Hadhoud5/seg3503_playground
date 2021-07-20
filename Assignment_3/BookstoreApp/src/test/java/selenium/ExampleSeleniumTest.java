import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
@@ -16,11 +15,16 @@
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.lang.Math;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;
  private WebDriver driverAdmin;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
@@ -90,12 +94,526 @@ public void test3() {
    WebElement signIn = driver.findElement(By.id("loginBtn"));
    signIn.click();

    String actualUrl="http://localhost:8080/admin";
    String expectedUrl= driver.getCurrentUrl();
    String actualUrl = "http://localhost:8080/admin";
    String expectedUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);

  }

  // Positive test case for F1
  @Test
  public void addBookPositive() {
    loginAsAdmin();

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("Fiction");

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test1234");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Hamlet");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Shakespeare");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement feedback = driver.findElement(By.id("feedback"));

    String actualMessage = feedback.getText();
    String expectedMessage = "Successfully added book";

    assertEquals(expectedMessage, actualMessage);

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement deleteBtn = driver.findElement(By.id("del-test1234"));
    deleteBtn.click();

  }

  // Negative test case for F1
  @Test
  public void addBookNegative() {
    loginAsAdmin();

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Hamlet");

    WebElement description = driver.findElement(By.id("longDescription"));
    description.sendKeys("Very cool!");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement feedback = driver.findElement(By.cssSelector("h2"));

    String actualMessage = feedback.getText();
    String expectedMessage = "Validation errors";

    assertEquals(expectedMessage, actualMessage);

  }

  // Positive test case for F2.1
  @Test
  public void searchCategoryPositive() {

    loginAsAdmin();

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("Fiction");

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test1234");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Hamlet");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Shakespeare");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement feedback = driver.findElement(By.cssSelector("h1"));

    String actualMessage = feedback.getText();
    String expectedMessage = "We currently have the following items in category 'Fiction'";

    assertEquals(expectedMessage, actualMessage);

    WebElement deleteBtn = driver.findElement(By.id("del-test1234"));
    deleteBtn.click();

  }

  // Negative test case for F2.1
  @Test
  public void searchCategoryNegative() {
    loginAsAdmin();

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement feedback = driver.findElement(By.cssSelector("h1"));

    String actualMessage = feedback.getText();
    String expectedMessage = "Sorry we do not have any item matching category 'Fiction' at this moment";

    assertEquals(expectedMessage, actualMessage);
  }

  // Positive test case for F2.2
  @Test
  public void searchEmptyCategoryPositive() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='content']/table/tbody/tr"));

    int actualNmbOfBooks = rows.size();

    int expectedNmbOfBooks = 5;

    assertEquals(expectedNmbOfBooks, actualNmbOfBooks);

  }

  // Negative test case for F2.2
  @Test
  public void searchEmptyCategoryNegative() {

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='content']/table/tbody/tr"));

    int actualNmbOfBooks = rows.size();

    int expectedNmbOfBooks = 5;

    assertTrue(actualNmbOfBooks < expectedNmbOfBooks);

  }

  // Positive test case for F3
  @Test
  public void addToBookOrderPositive() {

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    WebElement bookAdded = driver.findElement(By.id("hall001"));

    String actualNmbOfBooksAdded = bookAdded.getAttribute("value");

    String expectedNmbOfBooksAdded = "1";

    assertEquals(expectedNmbOfBooksAdded, actualNmbOfBooksAdded);

    bookAdded.sendKeys("0");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();

  }

  // Positive test case for F4/F4,1
  @Test
  public void checkBookOrderPositive() {

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='content']/table/tbody/tr/td"));

    String actualBookId = elements.get(0).getText();
    String expectedBookId = "hall001";

    String actualDescription = elements.get(1).getText();
    String expectedDescription = "Core Servlets and JavaServer Pages 2nd Edition (Volume 1)";

    String actualCost = elements.get(2).getText();
    String expecteCost = "$39.95";

    WebElement bookAdded = driver.findElement(By.id("hall001"));

    String actualNmbOfBooksAdded = bookAdded.getAttribute("value");

    String expectedNmbOfBooksAdded = "1";

    String actualTotalCost = elements.get(4).getText();
    String expectedTotalCost = "$39.95";

    assertEquals(expectedBookId, actualBookId);
    assertEquals(expectedDescription, actualDescription);
    assertEquals(expecteCost, actualCost);
    assertEquals(expectedNmbOfBooksAdded, actualNmbOfBooksAdded);
    assertEquals(expectedTotalCost, actualTotalCost);

    bookAdded.clear();
    bookAdded.sendKeys("0");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();
  }

  // Negative test case for F4/F4.1
  @Test
  public void checkBookOrderNegative() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='content']/table/tbody/tr"));

    int actualNmbOfBooks = rows.size();

    int expectedNmbOfBooks = 0;

    assertEquals(expectedNmbOfBooks, actualNmbOfBooks);
  }

  // Positive test case for F5/F5.1
  @Test
  public void updateBookNumberPositive() {

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    WebElement bookAdded = driver.findElement(By.id("hall001"));

    bookAdded.clear();
    bookAdded.sendKeys("0");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();

    WebElement newTotalCost = driver.findElement(By.id("tothall001"));

    String actualNewTotalCost = newTotalCost.getText();
    String expectedNewTotalCost = "$0.00";

    assertEquals(expectedNewTotalCost, actualNewTotalCost);

  }

  // Negative test case for F5/F5.1
  @Test
  public void updateBookNumberNegative() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    WebElement bookAdded = driver.findElement(By.id("hall001"));

    bookAdded.clear();
    bookAdded.sendKeys("1.5");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();

    WebElement newTotalCost = driver.findElement(By.id("tothall001"));

    String actualNewTotalCost = newTotalCost.getText();
    String expectedNewTotalCost = "$39.95";

    assertEquals(expectedNewTotalCost, actualNewTotalCost);
  }

  // Positive test case for F6/F6.1/F6.2
  @Test
  public void checkoutFeesTestPositive(){

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    WebElement bookAdded = driver.findElement(By.id("hall001"));

    bookAdded.clear();
    bookAdded.sendKeys("2");

    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();

    WebElement checkoutBtn = driver.findElement(By.name("checkout"));
    checkoutBtn.click();

    WebElement dateOfOrder = driver.findElement(By.id("order_date"));
    WebElement totalPrice = driver.findElement(By.id("order_total"));
    WebElement taxes = driver.findElement(By.id("order_taxes"));
    WebElement shippingFees = driver.findElement(By.id("order_shipping"));

    String actualDateOfOrder =  dateOfOrder.getText();
    String actualTaxes = taxes.getText();
    String actualShippingFees = shippingFees.getText();
    String actualTotalPrice = totalPrice.getText();

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    String expectedDateOfOrder = formatter.format(date);

    assertEquals(expectedDateOfOrder, actualDateOfOrder);

    Double calculateTaxes = Math.round((0.13 * (39.95 * 2)) * 100.0) / 100.0;
    String expectedTaxes = "$" + calculateTaxes;

    assertEquals(expectedTaxes, actualTaxes);

    String expectedShippingFees = "$14.00";

    assertEquals(expectedShippingFees, actualShippingFees);

    Double calculateTotalPrice = Math.round((39.95 * 2 + calculateTaxes + 14.00) * 100.0) / 100.0;
    String expectedTotalPrice = "$" + calculateTotalPrice;

    assertEquals(expectedTotalPrice, actualTotalPrice);

  }
  // Negative test case for F6/F6.1/F6.2
  @Test
  public void checkoutFeesTestNegative() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();

    WebElement checkoutBtn = driver.findElement(By.name("checkout"));
    checkoutBtn.click();

    WebElement dateOfOrder = driver.findElement(By.id("order_date"));
    WebElement totalPrice = driver.findElement(By.id("order_total"));
    WebElement taxes = driver.findElement(By.id("order_taxes"));
    WebElement shippingFees = driver.findElement(By.id("order_shipping"));

    String actualDateOfOrder =  dateOfOrder.getText();
    String actualTaxes = taxes.getText();
    String actualShippingFees = shippingFees.getText();
    String actualTotalPrice = totalPrice.getText();

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    String expectedDateOfOrder = formatter.format(date);

    assertEquals(expectedDateOfOrder, actualDateOfOrder);
    String expectedTaxes = "$0.00";

    assertEquals(expectedTaxes, actualTaxes);

    String expectedShippingFees = "$0.00";

    assertEquals(expectedShippingFees, actualShippingFees);

    String expectedTotalPrice = "$0.00";

    assertEquals(expectedTotalPrice, actualTotalPrice);
  }

  // Positive test case for F7
  @Test
  public void removeBookPositive(){
    loginAsAdmin();

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("Fiction");

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test1234");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Hamlet");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Shakespeare");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement deleteBtn = driver.findElement(By.id("del-test1234"));
    deleteBtn.click();

    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='content']/table/tbody/tr"));

    int nmbOfBooks = rows.size();

    boolean bookAsBeenDeleted = true;
    for (int i = 1; i <= nmbOfBooks; i++) {
      WebElement bookTitle =  driver.findElement(By.xpath("//div[@class='content']/table/tbody/tr[" + i + "]/td[1]"));
      String temp = bookTitle.getText();
      if(temp.equals("Hamlet")){
        bookAsBeenDeleted = false;
          break;
      }
    } 
    assertTrue(bookAsBeenDeleted);;
  }

  // Positive test case for F8
  @Test
  public void loginAsAdminAndAddingBookPositive(){
    loginAsAdmin();

    String actualUrl = "http://localhost:8080/admin";
    String expectedUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);

    WebElement category = driver.findElement(By.id("addBook-category"));
    category.sendKeys("Fiction");

    WebElement bookId = driver.findElement(By.id("addBook-id"));
    bookId.sendKeys("test1234");

    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Hamlet");

    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Shakespeare");

    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("10.0");

    WebElement addBtn = driver.findElement(By.name("addBook"));
    addBtn.click();

    WebElement feedback = driver.findElement(By.id("feedback"));

    String actualMessage = feedback.getText();
    String expectedMessage = "Successfully added book";

    assertEquals(expectedMessage, actualMessage);

    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");

    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();

    WebElement deleteBtn = driver.findElement(By.id("del-test1234"));
    deleteBtn.click();
  }



  private void loginAsAdmin() {

    driver.get("http://localhost:8080/admin");

    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");

    WebElement password = driver.findElement(By.id("loginPasswd"));
    password.sendKeys("password");

    WebElement signIn = driver.findElement(By.id("loginBtn"));
    signIn.click();
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
