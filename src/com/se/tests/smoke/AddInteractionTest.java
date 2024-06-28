package com.se.tests.smoke;

import com.se.TestDriver;
import com.se.rolesbase.TeacherLoginBase;
import com.se.utils.NavigationUtil;
import com.se.config.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class AddInteractionTest extends TeacherLoginBase {

    public AddInteractionTest() {
        this(false);
    }

    public AddInteractionTest(boolean tearDownBrowserAfterEachTest) {
        super(tearDownBrowserAfterEachTest);
    }

    @Test
    public void addInteraction() {
        // Navigate to the specified URL
        NavigationUtil.navigateToUrl("https://demo.subexpert.com/CourseLectures/OnTopic/OOSE-Labs/1-Environment-and-OOPs");

        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Click on the 3 dots menu
        WebElement threeDotsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div/div/div[2]/span")));
        threeDotsMenu.click();

        // Click on the InVideo text
        WebElement inVideoText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div/div/div[1]/span[2]/a[4]")));
        inVideoText.click();

        // Click on the menu button with the updated XPath
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inVideaTitleBar']/div[1]/span[1]")));
        menuButton.click();

        // Click on the Add Interactions button
        WebElement addInteractionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addintbtn']")));
        addInteractionsButton.click();

        // Fill in the interaction form fields
        Random random = new Random();
        int randomTime = random.nextInt(138) + 1;

        // Fill in the interaction form fields
        WebElement interactionTimeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OnSeconds']")));
        interactionTimeField.sendKeys(String.valueOf(randomTime));


        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Title']")));
        titleField.sendKeys("Introduction to Automation" + System.currentTimeMillis());

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='HTMLDescription']")));
        descriptionField.sendKeys("This is a brief introduction to automation testing using Selenium.");

        WebElement replaySecondsField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BackSeconds']")));
        replaySecondsField.sendKeys("5");

        WebElement displayForField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ForSeconds']")));
        displayForField.sendKeys("10");

        // Click the Information button for interaction type
        WebElement informationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addinfoform']/div/div[5]/div[1]/a[1]")));
        informationButton.click();

        // Click the Add button to add the interaction
        WebElement addInteractionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addinfoform']/div/div[6]/div/input")));
        addInteractionButton.click();

        // Verify success message for adding the interaction
        // There is no Success message displayed after adding an interaction but if there is an error it displays
        try {
            WebElement errorDialogue = wait.withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modaldialog']/div/header/h3")));
            // If error dialogue appears, fail the test
            Assert.fail("Error dialogue appeared: " + errorDialogue.getText());
        } catch (Exception e) {
            // If no error dialogue appears, pass the test
            System.out.println("Interaction added successfully and verified.");
        }
    }


    public void addInteractionUtil(){
        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Click on the 3 dots menu
        WebElement threeDotsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div/div/div[2]/span")));
        threeDotsMenu.click();

        // Click on the InVideo text
        WebElement inVideoText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div/div/div[1]/span[2]/a[4]")));
        inVideoText.click();

        // Click on the menu button with the updated XPath
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inVideaTitleBar']/div[1]/span[1]")));
        menuButton.click();

        // Click on the Add Interactions button
        WebElement addInteractionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addintbtn']")));
        addInteractionsButton.click();

        // Fill in the interaction form fields
        Random random = new Random();
        int randomTime = random.nextInt(138) + 1;

        // Fill in the interaction form fields
        WebElement interactionTimeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OnSeconds']")));
        interactionTimeField.sendKeys(String.valueOf(10));


        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Title']")));
        titleField.sendKeys("Introduction to Automation" + System.currentTimeMillis());

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='HTMLDescription']")));
        descriptionField.sendKeys("This is a brief introduction to automation testing using Selenium.");

        WebElement replaySecondsField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BackSeconds']")));
        replaySecondsField.sendKeys("5");

        WebElement displayForField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ForSeconds']")));
        displayForField.sendKeys("10");

        // Click the Information button for interaction type
        WebElement informationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addinfoform']/div/div[5]/div[1]/a[1]")));
        informationButton.click();

        // Click the Add button to add the interaction
        WebElement addInteractionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addinfoform']/div/div[6]/div/input")));
        addInteractionButton.click();
        try {
            WebElement errorDialogue = wait.withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modaldialog']/div/header/h3")));
            // If error dialogue appears, fail the test
            //If error dialogue Appears, pass the test
         Assert.assertTrue(errorDialogue.getText().contains("Warning"));

        } catch (Exception e) {
            // If no error dialogue appears, pass the test
            System.out.println("Interaction added successfully and verified.");
        }
    }
    @Test
    public void addDuplicateInteraction_NotAllowed(){
        // Navigate to the specified URL
        NavigationUtil.navigateToUrl("https://demo.subexpert.com/CourseLectures/OnTopic/OOSE-Labs/1-Environment-and-OOPs");

        WebDriver driver = TestDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        addInteractionUtil();
        addInteractionUtil();


        // Verify success message for adding the interaction
        // There is no Success message displayed after adding an interaction but if there is an error it displays


    }
}
