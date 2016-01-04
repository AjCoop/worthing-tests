package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.BasePage
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.pages._

/**
  * Created by thomas on 04/12/15.
  */
class PersonalDetailsPageTest extends ScalaDsl with EN{

  Given("""^I am on the Personal Details Page$""") { () =>
    PersonalDetails checkPersonalDetailsPage()
  }

  When("""^I press the continue button$""") { () =>

    PersonalDetails pressContinueButton()

  }

  Then("""^I will be directed to the declaration page$""") { () =>
    PersonalDetails getToDeclarationPage()
  }

}
