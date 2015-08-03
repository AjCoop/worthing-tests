package uk.gov.hmrc.integration.cucumber.pages

/**
 * Created by stephenkward on 23/07/15.
 */


import java.sql.Driver
import java.util.Calendar

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import uk.gov.hmrc.integration.test.utils.BaseUtil._
import org.scalatest.Matchers
import org.junit.Assert

  class CapturePage(val driver: WebDriver) extends Matchers {
    //url and the current page
    val CapturePageURL = "http://localhost:9090/tlfd/search"
    def iAmInCapturePage() = driver.getCurrentUrl shouldBe CapturePageURL

    //page heading, titles, field names verified
    def verifyHeading()  =  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText.contains("Capture"))
    def UTR = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[3]")).getText.contains("UTR"))
    def TaxRef = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("TaxRef"))
    def Date=Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]")).getText.contains("Date"))

    def TaxRefRadio = driver.findElement(By.xpath("//*[@id='radio-inline-4']"))
    def DateDay = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]"))
    def DateMonth = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]"))
    def DateYear = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/ID[4]"))

    def clickContinue_button() = driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/div/button")).click()


    //def verifyUTRLabel() = Assert.assertTrue(UTR.getText.contains("UTR"))
    //def verifyRefLabel() = Assert.assertTrue(TaxRef.getText.contains("Tax Ref"))




    //valid and invalid data for the utr, utr type and date fileds

    def Utrdetails {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("utr")).sendKeys(getMessage("testValue.id"))
    }

    def selectTaxRef  = driver.findElement(By.xpath("//*[@id='radio-inline-1']-UTR")).click()

    //def selectTaxRef() {
    // TaxRefRadio.click()
    //  }

    // retrieving the values for date fields.
    val cal: Calendar = Calendar.getInstance()
    val currentDay = cal.get(Calendar.DAY_OF_MONTH)
    val currentMonth= cal.get(Calendar.MONTH)
    val currentYear = cal.get(Calendar.YEAR)

    def enterDay()                          = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id ("day")).clear()
      driver.findElement(By.id("day")).sendKeys(""+currentDay)
    }
    def enterMonth()                      = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("month")).clear()
      driver.findElement(By.id("month")).sendKeys(""+currentMonth)
    }
    def enterYear()                        = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("year")).clear()
      driver.findElement(By.id ("year")).sendKeys(""+currentYear)
    }

    //for empty fields

    def emptyUtrField() = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("utr")).clear()
    }

    //def unSelectTaxRef() {
     // driver.navigate().refresh()
   // }

    def emptyDayField()                          = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id ("day")).clear()

    }
    def emptyMonthField()                      = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("month")).clear()

    }
    def emptyYearField()                        = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("year")).clear()
       }

  // for invalid data
    def invalidUtr(utr: String)                   = {
    driver.findElement(By.id("utr")).clear()
    driver.findElement(By.id("utr")).sendKeys(utr)
    }

    def invalidDay(day: String)               = {
      driver.findElement(By.id("day")).clear()
      driver.findElement(By.id("day")).sendKeys(day)
    }

    def invalidMonth(month: String)                 = {
      driver.findElement(By.id("month")).clear()
      driver.findElement(By.id("month")).sendKeys(month)
    }

    def invalidYear(year: String) = {
      driver.findElement(By.id("year")).clear()
     driver.findElement(By.id("year")).sendKeys(year)
    }

    def invalidData(utr: String, day: String, month: String, year: String) = {
      invalidUtr(utr)
      invalidDay(day)
      invalidMonth(month)
      invalidYear(year)
    }

 // mandatory error messages verified for the fields
    def mandatoryUTRError()  = driver.findElement(By.id("UTR")).getText should include (getFrontendMessage("No ID value entered"))
    def mandatoryTaxRefError()  = driver.findElement(By.id("TaxRef")).getText should include (getFrontendMessage("No TaxReftype selected"))
    def mandatoryDateError()  = driver.findElement(By.id("Date")).getText should include (getFrontendMessage("Enter the Date"))

    //field formats verified
    def invalidUTRError()  = driver.findElement(By.id("UTR")).getText should include (getFrontendMessage("Invalid UTR entered"))
    def invalidDateError()  = driver.findElement(By.id("Date")).getText should include (getFrontendMessage("Incorrect Date format enetered"))



  }