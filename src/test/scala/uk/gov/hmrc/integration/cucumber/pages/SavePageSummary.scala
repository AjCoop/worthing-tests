package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.Matchers
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 * Edited by Matt Turner on 19/08/15.
 */
object SavePageSummary extends BasePage {

//  def searchMyStuffLink()     = {
//    driver.findElement (By.id("saveMyStuffLink")).click()
//    waitForPageToBeLoaded(driver.getTitle contains "Page Two", "Page did not load in time")
//  }
  def summaryTitle()          = Assert.assertEquals("Page Summary", driver.findElement(By.xpath("//*[@id='page-title']")).getText)
  def columnOneHeading()      = Assert.assertEquals("Page", driver.findElement(By.xpath("//*[@id='content']/div[2]/table/thead/tr/th[1]")).getText)
  def columnOneValueOne()     = Assert.assertEquals("Page One", driver.findElement(By.xpath("//*[@id='content']/div[2]/table/tbody/tr[1]/td[1]")).getText)
  def columnOneValueTwo()     = Assert.assertEquals("Page Two", driver.findElement(By.xpath("//*[@id='content']/div[2]/table/tbody/tr[2]/td[1]")).getText)
  def columnTwoHeading()      = Assert.assertEquals("Field", driver.findElement(By.xpath("//*[@id='content']/div[2]/table/thead/tr/th[2]")).getText)



//  val pageOneFieldOneValue             = "page_one_field_one"
//  val pageOneFieldTwoValue             = "page_one_field_two"
//  val pageOneFieldThreeValue           = "page_one_field_three"
//
//  val pageTwoFieldOneValue             = "page_two_field_one"
//  val pageTwoFieldTwoValue             = "page_two_field_two"
//  val pageTwoFieldThreeValue         = "page_two_field_three"

}
