package uk.gov.hmrc.integration.cucumber.pages

import cucumber.api.DataTable
import org.openqa.selenium.By
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities, RemoteWebDriver}
import uk.gov.hmrc.integration.cucumber.utils.SingletonDriver
import org.scalatest.Matchers
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._

/**
 * Created by haripriya on 27/07/15.
 */
object BasePage extends BasePage

trait BasePage extends Matchers {
  val driver = SingletonDriver.getInstance()


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

  def sendKeysUsingElementId(elementId: String, value : String) = driver.findElement(By.id(elementId)).sendKeys(value)

  def verifyValueUsingElementId(elementId: String, expectedValue : String) = driver.findElement(By.id(elementId)).getText() shouldBe expectedValue

  def inputDataFromFeature(data: DataTable) = {
    val row = data.asMaps(classOf[String], classOf[String]).iterator
    while (row.hasNext) {
      val map = row.next
      val field_id = map.get("field_id")
      val value = map.get("value")

      sendKeysUsingElementId(getId(field_id), value)
    }
  }

  def checkDataFromFeature(data: DataTable) = {
    val row = data.asMaps(classOf[String], classOf[String]).iterator
    while (row.hasNext) {
      val map = row.next
      val field_id = map.get("field_id")
      val value = map.get("value")

     verifyValueUsingElementId(getId(field_id), value)
    }
  }

  def ShutdownTest() = driver.quit()
 }