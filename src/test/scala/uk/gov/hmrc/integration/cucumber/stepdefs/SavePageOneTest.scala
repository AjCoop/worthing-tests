package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.BasePage
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.pages._


/**
 * Created by haripriya on 07/08/15.
 */
class SavePageOneTest extends ScalaDsl with EN {


  Given( """^I am on the Save My Stuff page$""") { () =>
    CapturePage.login()
    SavePageOne.searchMyStuffLink()
    SavePageOne.savePageOneTitle()
    SavePageOne.fieldOneLabel()
    SavePageOne.fieldTwoLabel()
    SavePageOne.fieldThreeLabel()
  }
  When( """^I enter the following data in to the Page one$""") {
    (data: DataTable) => BasePage.inputDataFromFeature(data)
  }
  When ("""^I have clicked the "Continue" button on the "Page One" page$""") { () =>
    BasePage.clickContinue_button()
  }

  Then("""^I will be informed "This field is mandatory"$""") { () =>
    SavePageOne.mandatoryFieldPageOneError()
    BasePage.errorHeading()
  }


  Then ("""^I will progress to the "Page Two" page$""") { () =>
    SavePageTwo.savePageTwoTitle()
    SavePageTwo.fieldOneLabel()
    SavePageTwo.fieldTwoLabel()
    SavePageTwo.fieldThreeLabel()

  }
}
