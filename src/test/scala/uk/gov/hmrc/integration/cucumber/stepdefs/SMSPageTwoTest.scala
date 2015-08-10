package uk.gov.hmrc.integration.cucumber.stepdefs

import uk.gov.hmrc.integration.cucumber.pages.BasePage
import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages.BasePage._
import cucumber.api.DataTable


/**
 * Created by stephenkward on 07/08/15.
 */
class SMSPageTwoTest extends ScalaDsl with EN {

  Given( """^I am on the SMS page two$""") { () =>
    SMSPageTwo().login()
    SMSPageTwo().iAmInSMSPageTwo()
  }
  And( """^The tile will be Page two$""") { () =>
    SMSPageTwo().smsPageTwoHeader()
  }
  And( """^I will be asked for Field One$""") { () =>
    SMSPageTwo().smsFieldOne()
  }
  And( """^I will be asked for Field Two$""") { () =>
    SMSPageTwo().smsFieldTwo()
  }
  And( """^I will be asked for Field Three$""") { () =>
    SMSPageTwo().smsFieldThree()
  }
  When( """^I enter just mandatory data$""") { (data: DataTable) =>
      val row = data.asMaps(classOf[String], classOf[String]).iterator
      while (row.hasNext) {
        val map = row.next
        val required_field = map.get("required_field")
        val value = map.get("value")
        required_field match {
          case "field one"               => BasePage.driver.findElement(SMSPageTwo.fieldOneEntry).sendKeys(value)
          case _                         => throw new IllegalArgumentException(s"$required_field not found in step definition")

        }
      }

  }
  And( """^I click the "submit" button$""") { () =>
    SMSPageTwo().clickSubmitButton()
  }

  When( """^I enter data in all fields$""") { (data: DataTable) =>
      val row = data.asMaps(classOf[String], classOf[String]).iterator
      while (row.hasNext) {
        val map = row.next
        val required_field = map.get("required_field")
        val value = map.get("value")
        required_field match {
          case "field one"               => BasePage.driver.findElement(SMSPageTwo.fieldOneEntry).sendKeys(value)
          case "field two"               => BasePage.driver.findElement(SMSPageTwo.fieldTwoEntry).sendKeys(value)
          case "field three"             => BasePage.driver.findElement(SMSPageTwo.fieldThreeEntry).sendKeys(value)
          case _                         => throw new IllegalArgumentException(s"$required_field not found in step definition")

        }
      }

  }


  When( """^I do not enter mandatory data$""") { (data: DataTable) =>
      val row = data.asMaps(classOf[String], classOf[String]).iterator
      while (row.hasNext) {
        val map = row.next
        val required_field = map.get("required_field")
        val value = map.get("value")
        required_field match {
          case "field one"               => BasePage.driver.findElement(SMSPageTwo.fieldOneEntry).sendKeys(value)
          case "field two"               => BasePage.driver.findElement(SMSPageTwo.fieldTwoEntry).sendKeys(value)
          case "field three"             => BasePage.driver.findElement(SMSPageTwo.fieldThreeEntry).sendKeys(value)
          case _                         => throw new IllegalArgumentException(s"$required_field not found in step definition")

        }
      }

  }


  When( """^I enter no data in all fields$""") { (data: DataTable) =>
    val row = data.asMaps(classOf[String], classOf[String]).iterator
    while (row.hasNext) {
      val map = row.next
      val required_field = map.get("required_field")
      val value = map.get("value")
      required_field match {
        case "field one"               => BasePage.driver.findElement(SMSPageTwo.fieldOneEntry).sendKeys(value)
        case "field two"               => BasePage.driver.findElement(SMSPageTwo.fieldTwoEntry).sendKeys(value)
        case "field three"             => BasePage.driver.findElement(SMSPageTwo.fieldThreeEntry).sendKeys(value)
        case _                         => throw new IllegalArgumentException(s"$required_field not found in step definition")

      }
    }

  }

  And( """^I will be displayed the correct error message$""") { () =>
    SMSPageTwo().errorHeading()
    SMSPageTwo().mandatoryError()
  }

}