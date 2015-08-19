package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages._

/**
 * Edited by Matt Turner on 19/08/15.
 */

class SearchListPageTest extends ScalaDsl with EN {

  Then( """^I click the view all searches link$""") { () =>
  CurrentSearchResultsPage.viewAllSearch()


  }

  And( """^I should see a page displayed with the results of the all the searches the user has made.$""") { () =>
    SearchListPage.SearchTime()
    SearchListPage.Type()
    SearchListPage.ID()
    SearchListPage.DateSent()
    SearchListPage.DateReceived()
    SearchListPage.Status()
    SearchListPage.GetAllCheckPostTitle()
    SearchListPage.SubTitle()
    SearchListPage.verifyTheInputRecord()

  }

  And( """^I click back button to go back to the Search Page.$""") { () =>
    BasePage.clickBackButton()
    CapturePage.iAmInCapturePage()
  }

}