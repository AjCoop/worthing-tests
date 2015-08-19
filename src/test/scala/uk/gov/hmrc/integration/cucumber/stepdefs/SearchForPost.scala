package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages._

/**
 * Edited by Matt Turner on 19/08/15.
 */

class SearchForPost extends ScalaDsl with EN {

  //Common Steps
  Given( """^I am on the Search Page$""") { () =>
    CapturePage.login()
    CapturePage.iAmInCapturePage()
    CapturePage.verifyHeading()
    CapturePage.verifySearchSubHeading()
    CapturePage.UTRRadioLabel()
    CapturePage.VRNRadioLabel()
    CapturePage.Identifier()
    CapturePage.Date()
  }

  And( """^I click the find post button$""") { () =>
    CapturePage.clickFindPost_button()
  }

  When( """^I enter the following data$""") {
    (data: DataTable) => BasePage.inputDataFromFeature(data)

  }
  When( """^I enter the following type$""") {
    (data: DataTable) => BasePage.inputTypeFromFeature(data)
  }

  And( """^I have selected UTR$""") { () =>
    CapturePage.selectTaxRefUTR()

  }

  And( """^I have selected VRN$""") { () =>
    CapturePage.selectTaxRefVRN()

  }

  Then( """^I will progress to the search Results page$""") { () =>
    CurrentSearchResultsPage.verifyCheckPostHeading()
    CurrentSearchResultsPage.verifyCheckPostSubHeading()
    CurrentSearchResultsPage.verifyTableKeyHeading()
    CurrentSearchResultsPage.verifyTableValueHeading()
    CurrentSearchResultsPage.verifyRowType()
    CurrentSearchResultsPage.verifyRowID()
    CurrentSearchResultsPage.verifyRowDateSent()
    CurrentSearchResultsPage.verifyRowDateReceived()
    CurrentSearchResultsPage.verifyRowStatus()

  }


  Then("""^I click the back button to go back to the search page$""") { () =>
    BasePage.clickBackButton()
    CapturePage.iAmInCapturePage()
  }

  //Check Outcomes

  Then( """^I will get the mandatory error messages displayed on the page$""") { () =>
    CapturePage.verifyErrorHeading()
    CapturePage.mandatoryIdentifierError()
    CapturePage.mandatoryTaxRefError()
    CapturePage.mandatoryDateError()
  }

  Then ( """^I will get the invalid date format error messages displayed on the page$""") { () =>
    CapturePage.invalidDateError()

  }

  Then ( """^I will get the invalid UTR format error messages displayed on the page$""") { () =>
   CapturePage.invalidUTRError()

  }

  Then( """^The Received status is displayed$""") { () =>
    CapturePage.receivedStatus()
  }

  Then( """^The Not Found status is displayed$""") { () =>
    CapturePage.notFoundStatus()
  }

  Then( """^The In Progress status is displayed$""") { () =>
    CapturePage.inProgressStatus()
  }
}