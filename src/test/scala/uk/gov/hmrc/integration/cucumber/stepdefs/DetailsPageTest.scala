package uk.gov.hmrc.integration.cucumber.stepdefs


import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.BasePage
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.pages._

/**
  * Created by thomas on 03/12/15.
  */
class DetailsPageTest extends ScalaDsl with EN {

  Given( """^I am on the Details Page$""") { () =>
    DetailsPage locateDetails()

  }

  When("""^I click the on continue button$""") { () =>

    DetailsPage.clickContinue()

  }

  Then("""^I will be directed to the personal details page$"""){ () =>

    DetailsPage getToPage()
  }

  When("""^I click the back button$""") { () =>

    DetailsPage returnToPreviousPage()

  }

  Then("""^I will be directed to the start page$"""){ () =>
    DetailsPage goToStartPage()
  }

  Then("""^The information within the fields should be correct$""") { () =>
    DetailsPage QuestionOne()
    DetailsPage QuestionTwo()
  }





}
