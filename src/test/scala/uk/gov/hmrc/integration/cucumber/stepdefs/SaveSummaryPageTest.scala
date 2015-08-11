package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}

import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import uk.gov.hmrc.integration.cucumber.pages.CurrentSearchResultsPage._
import uk.gov.hmrc.integration.cucumber.pages._

/**
 * Created by haripriya on 07/08/15.
 */
class SaveSummaryPageTest extends ScalaDsl with EN {

  Given( """^I am in SMS page$""") { () =>
    CapturePage.login()
    SavePageOne.searchMyStuffLink
    SavePageOne.savePageOneTitle()

  }
  When( """^I have entered details on Page One$""") {
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

  Then( """^I click Continue$""") { () =>
    SavePageOne.clickContinue_button()
    SavePageTwo.savePageTwoTitle()
  }

  When( """^I have entered details on Page Two$""") {
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
  Then( """^I click Submit$""") { () =>
    SavePageTwo.clickContinue_button()

  }





  When ("""^I am on the SMS Summary Page$""") { () =>
    SavePageSummary.summaryTitle()

  }


  Then ("""^I will see the details I have entered$""") { () =>
    (data: DataTable) =>
      val row = data.asMaps(classOf[String], classOf[String]).iterator
      while (row.hasNext) {
        val map = row.next
        val required_field = map.get("required_field")
        val value = map.get("value")

        required_field match {
          case "field one" => BasePage.verifyValueUsingElementId(SavePageSummary.pageOneFieldOneValue, value)
          case "field two" => BasePage.verifyValueUsingElementId(SavePageSummary.pageOneFieldTwoValue, value)
          case "field three" => BasePage.verifyValueUsingElementId(SavePageSummary.pageOneFieldThreeValue, value)

        }

        required_field match {
          case "field one" => BasePage.verifyValueUsingElementId(SavePageSummary.pageTwoFieldOneValue, value)
          case "field two" => BasePage.verifyValueUsingElementId(SavePageSummary.pageTwoFieldTwoValue, value)
          case "field three" => BasePage.verifyValueUsingElementId(SavePageSummary.pageTwoFieldThreeValue, value)

        }

      }

  }
}
