package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.Matchers
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 * Created by haripriya on 07/08/15.
 */
object SavePageTwo extends BasePage {

  def searchMyStuffLink()     = {
    driver.findElement (By.id("saveMyStuffLink")).click()
    waitForPageToBeLoaded(driver.getTitle contains "Page Two", "Page did not load in time")
  }

  def savePageTwoTitle()      = Assert.assertEquals(getMessage("page.two.title"), driver.findElement(By.xpath("//*[@id='page-title']")).getText)
  def fieldOneLabel()     = Assert.assertEquals(getMessage("page.two.field.one"), driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText)
  def fieldTwoLabel()     = Assert.assertEquals(getMessage("page.two.field.two"), driver.findElement(By.xpath("//*[@id='content']/form/div[2]/label")).getText)
  def fieldThreeLabel()     = Assert.assertEquals(getMessage("page.two.field.three"), driver.findElement(By.xpath("//*[@id='content']/form/div[3]/label")).getText)
  def mandatoryFieldPageTwoError() = Assert.assertEquals("This field is mandatory", driver.findElement(By.xpath(".//*[@id='fieldTwoOne-error']/a")).getText)
}
