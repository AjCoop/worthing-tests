package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages._


/**
 * Created by haripriya on 07/08/15.
 */
class SavePageTwoTest extends ScalaDsl with EN {


  Given( """^I am on the SMS Page 1$""") { () =>
    CapturePage.login()
    SavePageOne.searchMyStuffLink
    SavePageOne.savePageOneTitle()

  }

  When( """^I enter the following data in to the Page 1$""") {
      (data: DataTable) => BasePage.inputDataFromFeature(data)
      }

  Then( """^I have clicked the "Continue" button on the "Page 1" page$""") { () =>
    SavePageOne.clickContinue_button()
  }


    Then( """^I am on the SMS Page Two$""") { () =>
       SavePageTwo.savePageTwoTitle()
      }

      When( """^I enter the following data in to the Page Two$""") {
        (data: DataTable) => BasePage.inputDataFromFeature(data)
      }

      When( """^I have clicked the "Continue" button on the "Page Two" page$""") { () =>
        SavePageTwo.clickContinue_button()
      }

      Then( """^I will be informed that "This field is mandatory"$""") { () =>
        SavePageTwo.mandatoryFieldOneError()
        SavePageTwo.errorHeading()

      }

      Then( """^I click back button to go back to Page One$""") { () =>
        BasePage.clickBackbutton()
        SavePageOne.savePageOneTitle()

      }

      Then( """^I will progress to the "summary" page$""") { () =>
        SavePageSummary.summaryTitle()
      }

      Then( """^I go back to the Page Two$""") { () =>
        SavePageTwo.navigateBack

      }
  }

