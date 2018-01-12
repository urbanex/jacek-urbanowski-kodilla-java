package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_SELECT_DAY = "//span[contains(@class, \"_5k_4\")]/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//span[contains(@class, \"_5k_4\")]/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//span[contains(@class, \"_5k_4\")]/span/select[3]";
    public static final String XPATH_SELECT_DATE_OF_BIRTH = "//span[contains(@class, \"_5k_4\")]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        while (!driver.findElement(By.xpath(XPATH_SELECT_DATE_OF_BIRTH)).isDisplayed());

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));

        Select selectDay = new Select(selectComboDay);
        Select selectMonth = new Select(selectComboMonth);
        Select selectYear = new Select(selectComboYear);

        selectDay.selectByValue("9");
        selectMonth.selectByValue("3");
        selectYear.selectByValue("1989");
    }
}
