package uk.gov.hmrc.integration.cucumber.pages

import org.joda.time.Seconds
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers
import org.junit.Assert
import org.scalatest.time.Span
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._

import org.openqa.selenium.support.ui.WebDriverWait



/**
 * Created by haripriya on 07/08/15.
 */
object SavePageOne extends BasePage with Matchers {

  def searchMyStuffLink()     = {
    driver.findElement (By.id("saveMyStuffLink")).click()
    waitForPageToBeLoaded(driver.getTitle contains "Page One", "Page did not load in time")
  }

  def savePageOneTitle()      = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText contains ("Page One"))
  def savePageOneLabel1()     = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText contains("Field One"))
  def savePageOneLable2()     = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[2]/label")).getText contains("Field Two"))
  def savePageOneLable3()     = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[3]/label")).getText contains("Field Three"))

  def clickContinue_button() = driver.findElement(By.xpath("//*[@id='continue']")).click()

  def mandatoryFieldOneError()  = driver.findElement(By.xpath("//*[@id='fieldOneOne-error']/a")).getText contains ("This field is mandatory ")
  def errorHeading() = driver.findElement(By.xpath("//*[@id='error-heading']")).getText contains("Your form contains one or more errors")



}
