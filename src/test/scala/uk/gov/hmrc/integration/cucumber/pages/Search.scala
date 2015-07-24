package uk.gov.hmrc.integration.cucumber.pages

/**
 * Created by stephenkward on 23/07/15.
 */

import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import org.scalatest.Matchers
import org.junit.Assert

  class Search (val driver: WebDriver) extends Matchers {
    val SearchPageURL = "http://localhost:9090/tlfd/search"
    def iAmInCapturePage() = driver.getCurrentUrl shouldBe SearchPageURL
    def verifyHeading()  =  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText.contains("Capture"))

    def UTR = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[3]"))
    def TaxRef = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]"))

    def UTRRadio = driver.findElement(By.xpath("//*[@id='radio-inline-3']"))
    def TaxRefRadio = driver.findElement(By.xpath("//*[@id='radio-inline-4']"))

    def verifyUTRLabel() = Assert.assertTrue(UTR.getText.contains("UTR"))
    def verifyRefLabel() = Assert.assertTrue(TaxRef.getText.contains("Tax Ref"))

    def DateDay = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]"))
    def DateMonth = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]"))
    def DateYear = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]"))


    def clickContinue_button() = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/div/button")).click()
















}