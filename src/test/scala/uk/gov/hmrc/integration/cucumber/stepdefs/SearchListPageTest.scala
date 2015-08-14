package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages._

/**
 * Created by haripriya on 05/08/15.
 */
class SearchListPageTest extends ScalaDsl with EN {

  Given( """^I am on the Search List Page$""") { () =>
    CapturePage.login()
    CapturePage.selectTaxRef()
    SearchListPage.genAndSetUTR
    CapturePage.enterDay()
    CapturePage.enterMonth()
    CapturePage.enterYear()
    CapturePage.clickFindPost_button()
    CurrentSearchResultsPage.ViewallSearch()

  }

  And( """^I should see a page displayed with the results of the all the searches the user has made.$""") { () =>
    SearchListPage.SearchTime
    SearchListPage.Type
    SearchListPage.ID
    SearchListPage.DateSent
    SearchListPage.DateReceived
    SearchListPage.Status
    SearchListPage.GetAllCheckPostTitle
    SearchListPage.SubTitle
    SearchListPage.verifyTheInputRecord

  }

  And( """^I click back button to go back to the Search Page.$""") { () =>
    BasePage.clickBackbutton()
    CapturePage.iAmInCapturePage()
  }

}
