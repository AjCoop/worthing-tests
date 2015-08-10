package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages._


/**
 * Created by haripriya on 07/08/15.
 */
class SavePageTwoTest extends ScalaDsl with EN {


  Given( """^I am on the SMS Page Two$""") { () =>

    SavePageTwo.savePageTwoTitle()

  }
  When( """^I enter the following data in to the Page Two$""") {

    (data: DataTable) =>
      val row = data.asMaps(classOf[String], classOf[String]).iterator
      while (row.hasNext) {
        val map = row.next
        val required_field = map.get("required_field")
        val value = map.get("value")

        required_field match {
          case "field one" => BasePage.driver.findElement(SavePageTwo.fieldOneId).sendKeys(value)
          case "field two" => BasePage.driver.findElement(SavePageTwo.fieldTwoId).sendKeys(value)
          case "field three" => BasePage.driver.findElement(SavePageTwo.fieldThreeId).sendKeys(value)
        }
      }
  }
  When ("""^I have clicked the "Continue" button on the "Page Two" page$""") { () =>
    SavePageTwo.clickContinue_button()
      }

  Then("""^I will be informed that "This field is mandatory"$""") { () =>
    SavePageTwo.mandatoryFieldOneError()
    SavePageTwo.errorHeading()


  }

//  When ("""^I click Back button$""") { () =>
//    SavePageTwo.appBack_button()
//
//  }
//
//  Then ("""^I will be navigated to Page One$""") { () =>
//    SavePageOne.savePageOneTitle()
//
//
//  }


  Then ("""^I will progress to the "summary" page$""") { () =>

  }

  Then ("""^I go back to the Page Two$""") { () =>
    SavePageTwo.navigateBack

  }
}
