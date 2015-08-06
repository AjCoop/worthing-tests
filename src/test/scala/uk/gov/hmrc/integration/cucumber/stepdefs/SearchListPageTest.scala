package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages.BasePage._

/**
 * Created by haripriya on 05/08/15.
 */
class SearchListPageTest extends ScalaDsl with EN {

  Given( """^I am on the Search List Page$""") { () =>
    CapturePage().login()
    CapturePage().selectTaxRef()
    CapturePage().identifierDetails()
    CapturePage().enterDay()
    CapturePage().enterMonth()
    CapturePage().enterYear()
    CapturePage().clickFindPost_button()
    CurrentSearchResultsPage().ViewallSearch()


  }

  And( """^I should see a page displayed with the results of the all the searches the user has made.$""") { () =>
    SearchListPage().check()


  }

}
