package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages.BasePage._

class CurrentSearchResultsPageFields extends ScalaDsl with EN {


  Given( """^I am on the Search Results Page$""") { () =>
    CapturePage().login()
    CapturePage().iAmInCapturePage()
    CapturePage().identifierDetails()
    CapturePage().selectTaxRef()
    CapturePage().enterDay()
    CapturePage().enterMonth()
    CapturePage().enterYear()
    CapturePage().clickFindPost_button()

  }
  And( """^I should see a page displayed with the results of the current search$""") { () =>
    CurrentSearchResultsPage().verifyCheckPostHeading()
    CurrentSearchResultsPage().verifyCheckPostSubHeading()
    CurrentSearchResultsPage().verifyTableKeyHeading()
    CurrentSearchResultsPage().verifyTableValueHeading()
    CurrentSearchResultsPage().verifyRowType()
    CurrentSearchResultsPage().verifyRowID()
    CurrentSearchResultsPage().verifyRowDateSent()
    CurrentSearchResultsPage().verifyRowDateReceived()
    CurrentSearchResultsPage().verifyRowStatus()
    CurrentSearchResultsPage().verifyTypeValue()
    CurrentSearchResultsPage().verifyIDValue()
    CurrentSearchResultsPage().verifyDateSent()
    CurrentSearchResultsPage().verifyDateReceived()
    CurrentSearchResultsPage().verifyStatusValue()
  }
}
