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

    (data: DataTable) =>
      val row = data.asMaps(classOf[String], classOf[String]).iterator
      while (row.hasNext) {
        val map = row.next
        val required_field = map.get("required_field")
        val value = map.get("value")

        required_field match {
          case "field one" => BasePage.driver.findElement(SavePageOne.fieldOneId).sendKeys(value)
          case "field two" => BasePage.driver.findElement(SavePageOne.fieldTwoId).sendKeys(value)
          case "field three" => BasePage.driver.findElement(SavePageOne.fieldThreeId).sendKeys(value)
        }
      }
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
