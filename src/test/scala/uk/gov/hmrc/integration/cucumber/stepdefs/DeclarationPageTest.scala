package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.{BasePage, _}


/**
  * Created by sam on 04/12/15.
  */
class DeclarationPageTest extends ScalaDsl with EN {

  Given("""^That I am on the declaration page$"""){ () =>
    Declaration.getToDeclarationPage()
  }

  When("""^I click on the continue button$"""){ () =>
    Declaration.clickContinue()
  }

  Then("""^I will be taken to the summary page$"""){ () =>
    Declaration.checkForSumaryPage()
    Declaration.getToDeclarationPage()
  }

  When("""^I click on the back button$"""){ () =>
    Declaration.clickBack()
  }

  Then("""^I will be taken to the personal-details page$"""){ () =>
    Declaration.checkForPersonalDetailsPage()
  }

}
