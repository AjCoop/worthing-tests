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


  def CapturePage() = {
    if (Capturing == null) Capturing = new CapturePage(driver)
    Capturing
  }

  def CurrentSearchResultsPage() = {
    if (Result == null) Result = new CurrentSearchResultsPage(driver)
    Result
  }

 }