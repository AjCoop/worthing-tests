package uk.gov.hmrc.integration.cucumber.pages

import java.util

import gherkin.lexer.No
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Assert
import org.openqa.selenium.{WebDriver, WebElement, By}
import org.scalatest.Matchers
import scala.collection.JavaConverters._
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 * Created by stephenkward on 07/08/15.
 */
class SMSPageTwo (val driver: WebDriver) extends Matchers {


  val SMSPageTwo = "http://localhost:9090/tlfd-frontend/sms/page-two"
  def iAmInSMSPageTwo() = driver.getCurrentUrl shouldBe SMSPageTwo
  def login(){driver.navigate().to(SMSPageTwo)}

def smsPageTwoHeader () = driver.findElement (By.xpath ("//*[@id='page-title']") ).getText contains (getMessage ("page.sms.pagetwo.title") )
def smsFieldOne () = driver.findElement (By.xpath ("//*[@id='content']/form/div[1]/label") ).getText contains (getMessage ("page.sms.pagetwo.fieldOne") )
  def smsFieldTwo () = driver.findElement (By.xpath ("//*[@id='content']/form/div[1]/label") ).getText contains (getMessage ("page.sms.pagetwo.fieldTwo") )
  def smsFieldThree () = driver.findElement (By.xpath ("//*[@id='content']/form/div[1]/label") ).getText contains (getMessage ("page.sms.pagetwo.fieldThree") )

  val fieldOneEntry    = By.id("fieldTwoOne")
  val fieldTwoEntry    = By.id("fieldTwoTwo")
  val fieldThreeEntry  = By.id("fieldTwoThree")


  def enterPageTwoDetails(fieldOne: String, fieldTwo: String, fieldThree: String) {
   driver.findElement(fieldOneEntry).sendKeys(fieldOne)
    driver.findElement(fieldTwoEntry).sendKeys(fieldTwo)
    driver.findElement(fieldThreeEntry).sendKeys(fieldThree)
  }

  def clickSubmitButton() = driver.findElement(By.xpath("//*[@id='submit']")).click()
  def clickSaveMyStuff() = driver.findElement(By.xpath("//*[@id='saveMyStuffLink']")).click()


  def errorHeading()  = driver.findElement(By.xpath("//*[@id='error-heading']")).getText shouldBe getMessage ("page.sms.pageone.errorMessage")
  def mandatoryError() = driver.findElement(By.xpath("//*[@id='fieldTwoOne-error']/a")).getText shouldBe getMessage("page.sms.pageone.mandatoryErrorMessage")
}
