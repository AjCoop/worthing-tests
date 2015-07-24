package uk.gov.hmrc.integration.cucumber.support.utils.driver

import org.openqa.selenium.WebDriver

trait StartUpTearDown {

  val webDriver: WebDriver = Driver.webDriver

}
