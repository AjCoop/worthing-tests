package uk.gov.hmrc.integration.cucumber.pages

/**
 * Created by stephenkward on 23/07/15.
 */


import java.sql.Driver
import java.util.Calendar

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._
import org.scalatest.Matchers
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


class CapturePage (val driver: WebDriver) extends Matchers {
    //url and the current page
    val CapturePageURL = "http://localhost:4001/tlfd-frontend/wmp/search"
    def iAmInCapturePage() = driver.getCurrentUrl shouldBe CapturePageURL
    def login(){driver.navigate().to(CapturePageURL)}

    //page heading, titles, field names verified
    def verifyHeading()  =  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText.contains("Search"))
    def verifySearchSubHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='searchType']/legend")).getText.contains("Select how you wish to search"))
    def UTRRadioLabel() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='searchType']/label[1]")).getText.contains("UTR"))
    def TaxRefRadioLabel()= Assert.assertTrue(driver.findElement(By.xpath("//*[@id='searchType']/label[2]")).getText.contains("Tax Reference"))
    def Identifier() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText.contains("Identifier"))
    def Date()=Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dateSent']/legend")).getText.contains("Date Sent"))
    def verifyErrorHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='error-heading']")).getText.contains("You search criteria contains one or more errors"))

    //def TaxRefRadio = driver.findElement(By.xpath("//*[@id='radio-inline-4']"))
    def DateDay = driver.findElement(By.xpath("//*[@id='dateSent.day']"))
    def DateMonth = driver.findElement(By.xpath("//*[@id='dateSent.month']"))
    def DateYear = driver.findElement(By.xpath("//*[@id='dateSent.year']"))

    def clickFindPost_button() = driver.findElement(By.xpath("//*[@id='content']/form/button")).click()

    //valid data for the utr,type and date fields

    def identifierDetails {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("utr")).sendKeys(getMessage("testValue.id"))
    }
    // selecting the type
    def selectTaxRef() = driver.findElement(By.xpath("//*[@id='searchType-utr']")).click()

    // retrieving the values for date fields.
    val cal: Calendar = Calendar.getInstance()
    val currentDay = cal.get(Calendar.DAY_OF_MONTH)
    val currentMonth= cal.get(Calendar.MONTH)
    val currentYear = cal.get(Calendar.YEAR)

    def enterDay()                          = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id ("dateSent.day")).clear()
      driver.findElement(By.id("dateSent.day")).sendKeys(""+currentDay)
    }
    def enterMonth()                      = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("dateSent.month")).clear()
      driver.findElement(By.id("dateSent.month")).sendKeys(""+currentMonth)
    }
    def enterYear()                        = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("dateSent.year")).clear()
      driver.findElement(By.id ("dateSent.year")).sendKeys(""+currentYear)
    }

    //for empty fields

    def emptyIdentifierField() = {
     driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("id")).clear()
    }

    //def unSelectTaxRef() {
     // driver.navigate().refresh()
   // }

    def emptyDayField()                          = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id ("dateSent.day")).clear()

    }
    def emptyMonthField()                      = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("dateSent.month")).clear()

    }
    def emptyYearField()                        = {
      driver.navigate().to(CapturePageURL)
      driver.findElement(By.id("dateSent.year")).clear()
       }

   //for invalid data
    def invalidIdentifier()                   = {
    driver.findElement(By.id("id")).clear()
    driver.findElement(By.id("id")).sendKeys(getMessage("testIdentifier.invalid"))
    }

    def invalidDay()               = {
      driver.findElement(By.id("dateSent.day")).clear()
      driver.findElement(By.id("dateSent.day")).sendKeys(getMessage("testDay.invalid"))
    }

    def invalidMonth()                 = {
      driver.findElement(By.id("dateSent.month")).clear()
      driver.findElement(By.id("dateSent.month")).sendKeys(getMessage("testMonth.invalid"))
    }

    def invalidYear() = {
      driver.findElement(By.id("dateSent.year")).clear()
     driver.findElement(By.id("dateSent.year")).sendKeys(getMessage("testYear.invalid"))
    }

     // mandatory error messages verified for the fields
    def mandatoryIdentifierError()  = driver.findElement(By.xpath("//*[@id='id-error']/a")).getText shouldBe getMessage ("testIdentifierValue.errormessage")
    def mandatoryTaxRefError() = driver.findElement(By.xpath("//*[@id='searchType-error']/a")).getText shouldBe getMessage("testTaxRefValue.errormessage")
    def mandatoryDateError()  = driver.findElement(By.xpath("//*[@id='dateSent-error']/a")).getText shouldBe getMessage ("testDateValue.errormessage")

    //field formats verified
    //not used currently:def invalidUTRError()  = driver.findElement(By.id("UTR")).getText should include (getFrontendMessage("Invalid UTR entered"))
    def invalidDateError()  = driver.findElement(By.xpath("//*[@id='dateSent-error']/a")).getText shouldBe getMessage ("testInvalidDate.erroemessage")



  }