package com.se.tests.smoke;

import com.se.TestDriver;
import com.se.rolesbase.StudentLoginBase;
import com.se.rolesbase.TeacherLoginBase;
import com.se.utils.NavigationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentAddInteractiveVideoTest extends StudentLoginBase {

    public StudentAddInteractiveVideoTest() {
        this(false);
    }

    public StudentAddInteractiveVideoTest(boolean tearDownBrowserAfterEachTest) {
        super(tearDownBrowserAfterEachTest);
    }

    @Test
    public void addVideoByStudent_NotAllowed() {
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

        // Click on the Add Video button
        WebElement addVideoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='invideadiv']/div/div[1]/div[2]/a")));
        addVideoButton.click();


        WebElement ErrorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modaldialog\"]/div/header/h3")));
        Assert.assertEquals(ErrorText.getText(), "Error");


        System.out.println("Video cant be added by a student.");
    }

}
