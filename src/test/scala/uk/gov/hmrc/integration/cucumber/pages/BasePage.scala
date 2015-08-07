package uk.gov.hmrc.integration.cucumber.pages

import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities, RemoteWebDriver}
import uk.gov.hmrc.integration.cucumber.utils.SingletonDriver


/**
 * Created by haripriya on 27/07/15.
 */
object BasePage {
  val driver = SingletonDriver.getInstance()

    private var Capturing: CapturePage = _
    private var Result: CurrentSearchResultsPage = _
  private var List: SearchListPage = _
  private var SMS2: SMSPageTwo = _

  def CapturePage() = {
    if (Capturing == null) Capturing = new CapturePage(driver)
    Capturing
  }

  def CurrentSearchResultsPage() = {
    if (Result == null) Result = new CurrentSearchResultsPage(driver)
    Result
  }

  def SearchListPage() = {
    if (List == null) List= new SearchListPage(driver)
    List
  }

  def SMSPageTwo() = {
    if (SMS2 == null) SMS2= new SMSPageTwo(driver)
    SMS2
  }

  def ShutdownTest() = driver.quit()
 }