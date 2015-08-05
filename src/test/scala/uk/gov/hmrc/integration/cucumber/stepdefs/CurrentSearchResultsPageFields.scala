package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages.BasePage._

class CurrentSearchResultsPageFields extends ScalaDsl with EN {


  Given( """^I am on the Search Results Page$""") { () =>
    CapturePage().iAmInCapturePage()
    CapturePage().identifierDetails
    CapturePage().selectTaxRef
    CapturePage().enterDay()
    CapturePage().enterMonth()
    CapturePage().enterYear()
    CapturePage().clickFindPost_button()

  }
  And( """^I should see a page displayed with the results of the current search$""") { () =>
    //CurrentSearchResultsPage().iAmInSearchResultPage()
    CurrentSearchResultsPage().UTR
    CurrentSearchResultsPage().TaxRef
    CurrentSearchResultsPage().Date
    CurrentSearchResultsPage().Status
    CurrentSearchResultsPage().assertId
    CurrentSearchResultsPage().assertTaxRef
    CurrentSearchResultsPage().assertDay
    CurrentSearchResultsPage().assertMonth
    CurrentSearchResultsPage().assertYear

  }
}
