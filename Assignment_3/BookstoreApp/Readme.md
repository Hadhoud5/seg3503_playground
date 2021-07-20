# SEG3103 Laboratory 6

| Information | Value |
| --- | --- |
| Course | SEG 3503 |
| Semester | Summer 2021 |
| Professor | Andrew Forward |
| TA | Aymen Mhamdi |
| Student 1 | Hedi (300123192) |
| Student 2 | Pierre Akladios (300114467) |


## Automated User Acceptance Testing with Selenium WebDriver

Before beginning the lab we installed Maven. Here is a screenshot after running `mvn --version` to show that it installed correctly:
<img width="807" alt="Capture d’écran 2021-07-21 à 00 16 01" src="https://user-images.githubusercontent.com/55165009/126407384-12448d87-3399-4bb6-a854-f7892bc4e064.png">


After extracting BookstoreApp.zip, we ran `mvn compile`.

Here is a screenshot of the terminal after compiling:
<img width="807" alt="Capture d’écran 2021-07-21 à 00 16 33" src="https://user-images.githubusercontent.com/55165009/126407410-db8047a4-d59e-42eb-8de9-1768a075d669.png">
<img width="807" alt="Capture d’écran 2021-07-21 à 00 16 47" src="https://user-images.githubusercontent.com/55165009/126407499-b30ff638-e753-4b3b-a888-6e546eba2e1c.png">


Then we ran `mvn package -DskipTests` which will compile all of the tests without actually running them.
<img width="807" alt="Capture d’écran 2021-07-21 à 00 17 43" src="https://user-images.githubusercontent.com/55165009/126407921-6d2b06c1-edd5-4c20-8ca9-acc5ab8aa87f.png">

<img width="799" alt="Capture d’écran 2021-07-21 à 00 21 34" src="https://user-images.githubusercontent.com/55165009/126407533-8b66b18d-b7f3-4df7-8267-bc6509a5c1b6.png">



Then we ran `java -jar ./target/BookstoreApp-0.1.0.jar`. 

Here is a screenshot of the application running:
<img width="799" alt="Capture d’écran 2021-07-21 à 00 21 47" src="https://user-images.githubusercontent.com/55165009/126407544-ac7fd3b0-37c7-49af-aff0-8cc9d8e42a2d.png">


To run the tests, we ran `mvn test`.

Here is a screenshot of the three tests passing:
<img width="799" alt="Capture d’écran 2021-07-21 à 00 22 11" src="https://user-images.githubusercontent.com/55165009/126407558-a6fcf263-2aea-4893-bd40-063c2fa18a70.png">


Next, we added an additional Selenium web driver test to test the login process.

Here is the code for the added test where we check that the username "admin" and the password "password" will successfully bring the user to the admin page of the application when they click "Sign in":
```java
  @Test
  public void test3() {
    driver.get("http://localhost:8080/admin");
    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");
    WebElement password = driver.findElement(By.id("loginPasswd"));
    password.sendKeys("password");
    WebElement signIn = driver.findElement(By.id("loginBtn"));
    signIn.click();
    String actualUrl="http://localhost:8080/admin";
    String expectedUrl= driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
  }
```

Here is a screenshot of the four tests passing:
<img width="799" alt="Capture d’écran 2021-07-21 à 00 22 27" src="https://user-images.githubusercontent.com/55165009/126407656-64ebf526-9b92-45e7-a7b0-48120381ecf2.png">

