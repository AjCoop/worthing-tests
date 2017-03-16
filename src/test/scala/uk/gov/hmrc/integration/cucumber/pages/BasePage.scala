package uk.gov.hmrc.integration.cucumber.pages

import cucumber.api.DataTable
import org.junit.Assert
import org.openqa.selenium.{Keys, By, WebDriver}
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities, RemoteWebDriver}
import uk.gov.hmrc.integration.cucumber.utils.SingletonDriver
import org.scalatest.Matchers
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._
import scala.collection.JavaConversions._

/**
 * Edited by Matt Turner on 19/08/15.
 */
object BasePage extends BasePage



trait BasePage extends Matchers {
  val driver = SingletonDriver.getInstance()

  lazy val basePageUrl: String = {
    val environmentProperty = System.getProperty("environment", "local").toLowerCase
    environmentProperty match {
      case "local" => "http://localhost:9090/tlfd-frontend"
      case "preview" => "https://preview.tax.service.gov.uk/tlfd-frontend"
      case "qa" => "https://web-qa.tax.service.gov.uk/tlfd-frontend"
      case "staging" => "https://www-staging.tax.service.gov.uk/tlfd-frontend"
      case "dev" => "https://www-dev.tax.service.gov.uk/tlfd-frontend"
      case _ => throw new IllegalArgumentException(s"Environment '$environmentProperty' not known")
    }
  }

  def waitForPageToBeLoaded(condition: => Boolean, exceptionMessage: String, timeoutInSeconds: Int = 2) {
    val endTime = System.currentTimeMillis + timeoutInSeconds * 1000
    while (System.currentTimeMillis < endTime) {
      try {
        if (condition) {
          return
        }
      } catch {
        case _: RuntimeException =>
        // ignore exceptions during the timeout period because the condition
        // is throwing exceptions and we DO want to try the condition again until the timeout expires
      }
    }
    throw new HmrcPageWaitException(exceptionMessage + "\n@@@@@@@@@ The current page was: " + driver.getCurrentUrl + " with title " + driver.getTitle)
  }

  class HmrcPageWaitException(exceptionMessage: String) extends Exception(exceptionMessage)

  def sendKeysUsingElementId(elementId: String, value: String) = driver.findElement(By.id(elementId)).sendKeys(Keys.chord(Keys.CONTROL, "a"), value)

  def verifyValueUsingElementId(elementId: String, expectedValue: String) = driver.findElement(By.id(elementId)).getText shouldBe expectedValue

  def inputDataFromFeature(data: DataTable) = {
    data.asMaps(classOf[String], classOf[String]).foreach(x =>
      sendKeysUsingElementId(getId(x.get("field_id")), x.get("value"))
    )
  }

  def inputTypeFromFeature(data: DataTable) = {
    data.asMaps(classOf[String], classOf[String]).foreach(x =>
      driver.findElement(By.xpath("//*[@id='idType-" + x.get("type") + "']")).click()
    )
  }

  def checkDataFromFeature(data: DataTable) = {
    data.asMaps(classOf[String], classOf[String]).foreach(x =>
      verifyValueUsingElementId(getId(x.get("field_id")), x.get("value"))
    )
  }

  def clickBackButton() = driver.findElement(By.xpath("//*[@id='back']")).click()

  def ShutdownTest() = driver.quit()

  def clickContinue_button() = driver.findElement(By.xpath("//*[@id='continue']")).click()

  def clickSubmit_button() = driver.findElement(By.xpath("//*[@id='submit']")).click()

  def navigateBack() = driver.navigate().back()

  def errorHeading() = Assert.assertEquals("Your form contains one or more errors", driver.findElement(By.xpath("//*[@id='error-heading']")).getText)

  def navigateTo(url: String) = driver.navigate().to(url)

  def findById(id: String) = driver.findElement(By.id(id))

  def navigateToPage(url: String) {
    printf(s"##################### Navigating to $url #########################" + "\n")
    driver.navigate().to(url)
    Thread.sleep(2000)
  }

  def clickById(id: String) = driver.findElement(By.id(id)).click()

  def clickByCss(selector: String) = driver.findElement(By.cssSelector(selector)).click()

  def clickContinue() = findById("doLogin").click()

  def clickCreate() = findById("createHotel").click()

  def enterData(data: DataTable) = {
    val row = data.asMaps(classOf[String], classOf[String]).iterator
    while (row.hasNext) {
      val map = row.next
      val key = map.get("id")
      val value = map.get("entry")
      findById(key).sendKeys(value)
    }
  }

}