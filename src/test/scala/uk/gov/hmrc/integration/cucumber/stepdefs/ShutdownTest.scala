package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.BasePage._

/**
 * Created by haripriya on 04/08/15.
 */
class ShutdownTest extends ScalaDsl with EN{
  Then ( """^shutdown browser$""") { () =>
    ShutdownTest()
  }

}
