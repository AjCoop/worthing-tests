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
 * Created by haripriya on 29/07/15.
 */
object CurrentSearchResultsPage extends BasePage with Matchers {

  //val searchResultPageURL = "http://localhost:9090/tlfd/searchResults"
  //def iAmInSearchResultPage() = driver.getCurrentUrl shouldBe searchResultPageURL

  val cal: Calendar = Calendar.getInstance()


   var currentDay = cal.get(Calendar.DAY_OF_MONTH)
   var currentMonth = cal.get(Calendar.MONTH)
   var currentYear = cal.get(Calendar.YEAR).toString

   def timestamp = DateTimeFormat.forPattern("yyyy-MM-dd").print(new DateTime())
   println(timestamp)

  def verifyCheckPostHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText.contains("Check Post"))
  def verifyCheckPostSubHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/p")).getText.contains("Check Post"))
  def verifyTableKeyHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[1]")).getText.contains("Key"))
  def verifyTableValueHeading() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[2]")).getText.contains("Value"))
  def verifyRowType() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[1]/td[1]")).getText.contains("Type"))
  def verifyRowID() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[2]/td[1]")).getText.contains("ID"))
  def verifyRowDateSent() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[3]/td[1]")).getText.contains("Date Sent"))
  def verifyRowDateReceived() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[4]/td[1]")).getText.contains("Date Received"))
  def verifyRowStatus() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[5]/td[1]")).getText.contains("Status"))

  def verifyTypeValue() = driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[1]/td[2]")).getText shouldBe (getMessage("testValue.idType"))
  def verifyIDValue() = driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[2]/td[2]")).getText shouldBe (getMessage("testValue.id"))
  def verifyDateSent() = driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[3]/td[2]")).getText shouldBe (timestamp)
  def verifyDateReceived() = driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[4]/td[2]")).getText shouldBe (getMessage("testValue.idDateReceived"))
  def verifyStatusValue() = driver.findElement(By.xpath("//*[@id='content']/section/div/table/tbody/tr[5]/td[2]")).getText shouldBe(getMessage("testValue.idStatus"))

  def ViewallSearch() {
    driver.findElement(By.id("viewAllSearchesLink")).click()





  }



}

