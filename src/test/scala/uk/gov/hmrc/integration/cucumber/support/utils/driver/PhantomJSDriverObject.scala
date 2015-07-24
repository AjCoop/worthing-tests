package uk.gov.hmrc.integration.cucumber.support.utils.driver

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.phantomjs.PhantomJSDriver

object PhantomJSDriverObject {
  def apply(capabilities: DesiredCapabilities) = new PhantomJSDriver(capabilities)
}
