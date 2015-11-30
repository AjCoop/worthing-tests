package uk.gov.hmrc.integration.cucumber.pages

/**
 * Edited by Matt Turner on 19/08/15.
 */


import java.sql.Driver
import java.util.Calendar
import uk.gov.hmrc.integration.cucumber.pages.CurrentSearchResultsPage._

import scala.collection.JavaConverters._
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._
import org.scalatest.Matchers
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


object CapturePage extends BasePage{
  //url and the current page
    val CapturePageURL =basePageUrl+ "/wmp/search"
    def iAmInCapturePage() = driver.getCurrentUrl shouldBe CapturePageURL
    def login(){driver.navigate().to(CapturePageURL)}


  //page heading, titles, field names verified
    def verifyHeading()  =  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText.contains("Search"))
    def verifySearchSubHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='idType']/legend")).getText.contains("Select how you wish to search"))
    def UTRRadioLabel() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='idType']/label[1]")).getText.contains("UTR"))
    def VRNRadioLabel()= Assert.assertTrue(driver.findElement(By.xpath("//*[@id='idType']/label[2]")).getText.contains("VRN"))
    def Identifier() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText.contains("Identifier"))
    def Date()=Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dateSent']/legend")).getText.contains("Date Sent"))
    def verifyErrorHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='error-heading']")).getText.contains("Your search criteria contains one or more errors"))

  //Links

    def DateDay = driver.findElement(By.xpath("//*[@id='dateSent.day']"))
    def DateMonth = driver.findElement(By.xpath("//*[@id='dateSent.month']"))
    def DateYear = driver.findElement(By.xpath("//*[@id='dateSent.year']"))

    def clickFindPost_button() = driver.findElement(By.xpath("//*[@id='content']/form/button")).click()


  //valid data for the utr,type and date fields

  // selecting the type
    def selectTaxRefUTR() = driver.findElement(By.xpath("//*[@id='idType-utr']")).click()
    def selectTaxRefVRN() = driver.findElement(By.xpath("//*[@id='idType-vrn']")).click()


  // identifier where the status is not found
    def identifierDetails() {
      driver.findElement(By.xpath("//*[@id='id']")).sendKeys(getMessage("testValue.id"))

    }


    def idElement = driver.findElement(By.id("id"))
    def dayElement= driver.findElement (By.id("dateSent.day"))
    def monthElement= driver.findElement(By.id("dateSent.month"))
    def yearElement = driver.findElement(By.id("dateSent.year"))

    def radioInList(groupName: String, text: String) = {
      val selector = "#" + groupName +  " > label" // if id was bob selector = "#id > label" meaning all label elements directly under an element with the id of bob

      // go find me the elements convert the list of elements to a slist of scala list of elements (.asScala.toList)
      val labelsContainingRadioButtons = driver.findElements(By.cssSelector(selector)).asScala.toList

      // filter the list based on the text (.filter(blah blah)) and return me the first element [label element] in the list (.head)
      val labelWithMatchingText = labelsContainingRadioButtons.filter(l => l.getText == text).head

      //return the radio button within the label
      labelWithMatchingText.findElement(By.tagName("input"))
    }

    def inputSearchPostData(idType: String, id: String, day: String, month: String, year: String) {
        radioInList("idType", idType).click()
        idElement.sendKeys(id)
        dayElement.sendKeys(day)
        monthElement.sendKeys(month)
        yearElement.sendKeys(year)

    }

  // retrieving the values for date fields.
    val cal: Calendar = Calendar.getInstance()
    val currentDay = cal.get(Calendar.DAY_OF_MONTH)
    val currentMonth= cal.get(Calendar.MONTH)+1
    val currentYear = cal.get(Calendar.YEAR)

    def enterDay()                          = {
      driver.findElement(By.id ("dateSent.day")).clear()
      driver.findElement(By.id("dateSent.day")).sendKeys(""+currentDay)
    }
    def enterMonth()                      = {
      driver.findElement(By.id("dateSent.month")).clear()
      driver.findElement(By.id("dateSent.month")).sendKeys(""+currentMonth)
    }
    def enterYear()                        = {
      driver.findElement(By.id("dateSent.year")).clear()
      driver.findElement(By.id ("dateSent.year")).sendKeys(""+currentYear)
    }

  //for empty fields

    def emptyIdentifierField() = {
      driver.findElement(By.id("id")).clear()
    }

    def emptyDayField()                          = {
      driver.findElement(By.id ("dateSent.day")).clear()

    }
    def emptyMonthField()                      = {
      driver.findElement(By.id("dateSent.month")).clear()

    }
    def emptyYearField()                        = {
      driver.findElement(By.id("dateSent.year")).clear()
       }

  //for invalid data
    def invalidIdentifier()                   = {
    driver.findElement(By.id("id")).clear()
    driver.findElement(By.id("id")).sendKeys(getMessage("testIdentifier.invalid"))
    }

    def invalidDate()               = {
      driver.findElement(By.id("dateSent.day")).clear()
      driver.findElement(By.id("dateSent.day")).sendKeys(getMessage("testDay.invalid"))
      driver.findElement(By.id("dateSent.month")).clear()
      driver.findElement(By.id("dateSent.month")).sendKeys(getMessage("testMonth.invalid"))
      driver.findElement(By.id("dateSent.year")).clear()
      driver.findElement(By.id("dateSent.year")).sendKeys(getMessage("testYear.invalid"))
    }


  // mandatory error messages verified for the fields
    def mandatoryIdentifierError()  = Assert.assertEquals(getMessage("testIdentifierValue.errorMessage"), driver.findElement(By.xpath("//*[@id='id-error']/a")).getText)
    def mandatoryTaxRefError() = Assert.assertEquals(getMessage("testTaxRefValue.errorMessage"), driver.findElement(By.xpath("//*[@id='idType-error']/a")).getText)
    def mandatoryDateError()  = Assert.assertEquals(getMessage("testDateValue.errorMessage"), driver.findElement(By.xpath("//*[@id='dateSent-error']/a")).getText)

  //field formats verified
  //not used currently:def invalidUTRError()  = driver.findElement(By.id("UTR")).getText should include (getFrontendMessage("Invalid UTR entered"))
    def invalidDateError()  = Assert.assertEquals(getMessage("testInvalidDate.errorMessage"), driver.findElement(By.xpath("//*[@id='dateSent-error']/a")).getText)
    def invalidUTRError() = Assert.assertEquals(getMessage("testInvalidUTR.errorMessage"), driver.findElement(By.xpath("//*[@id='id-error']/a")).getText)
    def receivedStatus () = Assert.assertEquals(getMessage("testValue.idReceivedStatus"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[5]/td[2]")).getText)
    def notFoundStatus () = Assert.assertEquals(getMessage("testValue.idNotFoundStatus"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[5]/td[2]")).getText)
    def inProgressStatus () = Assert.assertEquals(getMessage("testValue.idInProgressStatus"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[5]/td[2]")).getText)

  }