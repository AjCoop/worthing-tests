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
object SavePageOne extends BasePage {

  def searchMyStuffLink()     = {
    driver.findElement (By.id("saveMyStuffLink")).click()
    waitForPageToBeLoaded(driver.getTitle contains "Page One", "Page did not load in time")
  }

  def savePageOneTitle()      = Assert.assertEquals(getMessage("page.one.title"), driver.findElement(By.xpath("//*[@id='page-title']")).getText)
  def fieldOneLabel()          = Assert.assertEquals(getMessage("page.one.field.one"), driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText)
  def fieldTwoLabel()     = Assert.assertEquals(getMessage("page.one.field.two"), driver.findElement(By.xpath("//*[@id='content']/form/div[2]/label")).getText)
  def fieldThreeLabel()     = Assert.assertEquals(getMessage("page.one.field.three"), driver.findElement(By.xpath("//*[@id='content']/form/div[3]/label")).getText)
  def mandatoryFieldPageOneError() = Assert.assertEquals("This field is mandatory", driver.findElement(By.xpath(".//*[@id='fieldOneOne-error']/a")).getText)

}
