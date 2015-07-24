package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert

class Search extends ScalaDsl with EN {

  Given( """^I am on the Search Page$""") { () =>
  Search().iAmInCapturePage()
  }

  When( """^I search using my UTR$""") { () =>

  }

  Then ("""^I can capture all my details correctly$""") { () =>

  }








}