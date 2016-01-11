package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.{BasePage, _}


/**
  * Created by sam on 04/12/15.
  */
class SummaryPageTest extends ScalaDsl with EN {

  Given("""^I am on the summary page$"""){ () =>
    Summary.getSummaryPage()
    Summary.checkSummaryPage()
  }

  When("""^I click the back button on the summary page$"""){ () =>
    //Summary.clickSummaryBackButton()
  }

  Then("""^I will be taken back to the summary page$"""){ () =>
    //Summary.checkForDeclarationPage()
    //Summary.getSummaryPage()
  }

  When("""^I click on the submit button$"""){ () =>
    //Summary.clickSummarySubmitButton()
  }

  Then("""^Currently I will remain on the summary page$"""){ () =>
   // Summary.checkSummaryPage()
  }

}
