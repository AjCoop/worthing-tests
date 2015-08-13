package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.Matchers



/**
 * Created by haripriya on 07/08/15.
 */
object SavePageTwo extends BasePage with Matchers {

//  def searchMyStuffLink()     = {
//    driver.findElement (By.id("saveMyStuffLink")).click()
//    waitForPageToBeLoaded(driver.getTitle contains "Page Two", "Page did not load in time")
//  }
  def savePageTwoTitle()      = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText contains ("Page Two"))
  def savePageTwoLabel1()     = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText contains("Field One"))
  def savePageTwoLable2()     = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[2]/label")).getText contains("Field Two"))
  def savePageTwoLable3()     = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/form/div[3]/label")).getText contains("Field Three"))

  def clickContinue_button() = driver.findElement(By.xpath("//*[@id='submit']")).click()

  def mandatoryFieldOneError()  = driver.findElement(By.xpath("//*[@id='fieldTwoOne-error']/a")).getText contains ("This field is mandatory ")
  def errorHeading() = driver.findElement(By.xpath("//*[@id='error-heading']")).getText contains("Your form contains one or more errors")

  def navigateBack =driver.navigate().back()
  def appBack_button()= driver.findElement(By.xpath("//*[@id='back']")).click()



}
