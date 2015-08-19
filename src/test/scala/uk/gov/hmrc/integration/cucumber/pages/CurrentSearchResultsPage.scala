package uk.gov.hmrc.integration.cucumber.pages

import java.util.Calendar

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Assert
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import org.scalatest.Matchers
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 *
 * Edited by Matt Turner on 19/08/15.
 */
object CurrentSearchResultsPage extends BasePage with Matchers {

  val searchResultPageURL = "http://localhost:9090/tlfd-frontend/wmp/get-all-check-post"
  def iAmInSearchResultPage() = driver.getCurrentUrl shouldBe searchResultPageURL
  def loginSearch(){driver.navigate().to(searchResultPageURL)}

  val cal: Calendar = Calendar.getInstance()


   var currentDay = cal.get(Calendar.DAY_OF_MONTH)
   var currentMonth = cal.get(Calendar.MONTH)
   var currentYear = cal.get(Calendar.YEAR).toString

   def timestamp = DateTimeFormat.forPattern("yyyy-MM-dd").print(new DateTime())
   println(timestamp)

  def verifyCheckPostHeading() = Assert.assertEquals(getMessage("page.result.title"), driver.findElement(By.xpath("//*[@id='page-title']")).getText)
  def verifyCheckPostSubHeading() = Assert.assertEquals(getMessage("page.result.subHeading"),driver.findElement(By.xpath("//*[@id='content']/section/div/p")).getText)
  def verifyTableKeyHeading() = Assert.assertEquals(getMessage("page.result.keyHeading"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[1]")).getText)
  def verifyTableValueHeading() = Assert.assertEquals(getMessage("page.result.valHeading"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[2]")).getText)
  def verifyRowType() = Assert.assertEquals(getMessage("page.result.row.type"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[1]/td[1]")).getText)
  def verifyRowID() = Assert.assertEquals(getMessage("page.result.row.id"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[2]/td[1]")).getText)
  def verifyRowDateSent() = Assert.assertEquals(getMessage("page.result.row.dateSent"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[3]/td[1]")).getText)
  def verifyRowDateReceived() = Assert.assertEquals(getMessage("page.result.row.dateReceived"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[4]/td[1]")).getText)
  def verifyRowStatus() = Assert.assertEquals(getMessage("page.result.row.status"), driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[5]/td[1]")).getText)

  def viewAllSearch() {
    driver.findElement(By.id("viewAllSearchesLink")).click()
  }
}

