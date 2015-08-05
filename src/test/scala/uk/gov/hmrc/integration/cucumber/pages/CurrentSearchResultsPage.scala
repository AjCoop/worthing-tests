package uk.gov.hmrc.integration.cucumber.pages

import java.util.Calendar

import org.junit.Assert
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import org.scalatest.Matchers
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 *
 * Created by haripriya on 29/07/15.
 */
class CurrentSearchResultsPage (val driver: WebDriver) extends Matchers {

  val searchResultPageURL = "http://localhost:9090/tlfd/searchResults"
  def iAmInSearchResultPage() = driver.getCurrentUrl shouldBe searchResultPageURL

  val cal: Calendar = Calendar.getInstance()
  val currentDay = cal.get(Calendar.DAY_OF_MONTH)
  val currentMonth= cal.get(Calendar.MONTH)
  val currentYear = cal.get(Calendar.YEAR)


  def UTR = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[3]")).getText.contains("UTR"))
  def TaxRef = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("TaxRef"))
  def Date = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("Date"))
  def Status = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("Status"))

  def assertId =  driver.findElement(By.xpath("//*[@id='content']/article/form/table/tbody/tr[1]/td[2]")).getText shouldBe getMessage("testValue.id")
  def assertTaxRef = driver.findElement(By.xpath("//*[@id='content']/article/form/table/tbody/tr[1]/td[2]")).getText shouldBe getMessage("testValue.idType")
  def assertDay = driver.findElement(By.xpath("//*[@id=")).getText shouldBe getMessage("currentDay")
  def assertMonth= driver.findElement(By.xpath("//*[@id=")).getText shouldBe getMessage("currentMonth")
  def assertYear= driver.findElement(By.xpath("//*[@id=")).getText shouldBe getMessage("currentYear")
  def assertStatus = driver.findElement(By.xpath("//*[@id='content']/article/form/table/tbody/tr[1]/td[2]")).getText shouldBe getMessage("testValue.idStatus")



}

