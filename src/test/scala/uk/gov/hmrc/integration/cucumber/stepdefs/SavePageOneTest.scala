package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.pages._


/**
 * Created by haripriya on 07/08/15.
 */
class SavePageOneTest extends ScalaDsl with EN {


  Given( """^I am on the Save My Stuff page$""") { () =>
    CapturePage.login()
    SavePageOne.searchMyStuffLink
    SavePageOne.savePageOneTitle()
    SavePageOne.savePageOneLabel1()
    SavePageOne.savePageOneLable2()
    SavePageOne.savePageOneLable3()
  }
  When( """^I enter the following data in to the Page one$""") {
    (data: DataTable) => BasePage.inputDataFromFeature(data)
  }
  When ("""^I have clicked the "Continue" button on the "Page One" page$""") { () =>
    SavePageOne.clickContinue_button()
  }

  Then("""^I will be informed "This field is mandatory"$""") { () =>
    SavePageOne.mandatoryFieldOneError()
    SavePageOne.errorHeading()
  }


  Then ("""^I will progress to the "Page Two" page$""") { () =>
    SavePageTwo.savePageTwoTitle()
    SavePageTwo.savePageTwoLabel1()
    SavePageTwo.savePageTwoLable2()
    SavePageTwo.savePageTwoLable3()

  }
}
