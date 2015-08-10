package uk.gov.hmrc.integration.cucumber.pages

import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities, RemoteWebDriver}
import uk.gov.hmrc.integration.cucumber.utils.SingletonDriver


/**
 * Created by haripriya on 27/07/15.
 */
object BasePage extends BasePage
trait BasePage {
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


  def ShutdownTest() = driver.quit()
 }