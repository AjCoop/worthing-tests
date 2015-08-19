package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}

import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import uk.gov.hmrc.integration.cucumber.pages.CurrentSearchResultsPage._
import uk.gov.hmrc.integration.cucumber.pages._

/**
 * Edited by Matt Turner on 19/08/15.
 */
class SaveSummaryPageTest extends ScalaDsl with EN {

  Given( """^I am in SMS page$""") { () =>
    CapturePage.login()
    SavePageOne.searchMyStuffLink()
    SavePageOne.savePageOneTitle()

  }
  When( """^I have entered details on Page One$""") {
    (data: DataTable) => BasePage.inputDataFromFeature(data)

  }

  Then( """^I click Continue$""") { () =>
    BasePage.clickContinue_button()
    SavePageTwo.savePageTwoTitle()
  }

  When( """^I have entered details on Page Two$""") {
    (data: DataTable) => BasePage.inputDataFromFeature(data)

  }
  Then( """^I click Submit$""") { () =>
    BasePage.clickSubmit_button()

  }

  When ("""^I am on the SMS Summary Page$""") { () =>
    SavePageSummary.summaryTitle()

  }


  Then ("""^I will see the details I have entered$""") { () =>
    (data: DataTable) => BasePage.checkDataFromFeature(data)
      }

}
