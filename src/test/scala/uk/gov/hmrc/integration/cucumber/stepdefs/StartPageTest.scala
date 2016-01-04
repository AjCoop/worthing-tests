package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.{BasePage, _}


/**
 * Created by sam on 03/12/15.
 */
class StartPageTest extends ScalaDsl with EN {

  Given("""^I am on the start page$"""){ () =>
    StartPage.getToPage()
    StartPage.checkStartPage()
  }

  When("""^I click on the first drop text$"""){ () =>
    StartPage.clickFirstDrop()
  }

  Then("""^I should be able to see the first hidden text$"""){ () =>
    StartPage.checkFirstDropOpen()
  }

  When("""^I click on the second drop text$"""){ () =>
    StartPage.clickSecondDrop()
  }

  Then("""^I should be able to see the second hidden text$"""){ () =>
    StartPage.checkFirstDropOpen()
  }

  When("""^I click the start button$"""){ () =>
    StartPage.clickStart()
  }

  Then("""^I should be taken to the disclosure reference number page$"""){ () =>
    StartPage.checkPage()
  }

}