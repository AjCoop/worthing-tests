package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages.BasePage._

class CapturePageFields extends ScalaDsl with EN {


  //Scenario: Error messages for the mandatory fields on the Capture Page

  Given( """^I am on the Search Page$""") { () =>
    CapturePage().iAmInCapturePage()
  }

  /*as the page is loaded all the selected options i.e taxRef gets unset*/
  When( """^I leave all the fields empty$""") { () =>
    CapturePage().emptyUtrField()
    CapturePage().emptyDayField()
    CapturePage().emptyMonthField()
    CapturePage().emptyYearField()

  }
  And ("""^I click the submit button$""") { () =>
    CapturePage().clickContinue_button()
  }


  And ("""^I will get the mandatory error messages displayed on the page$""") { () =>
    CapturePage().mandatoryUTRError()
    CapturePage().mandatoryTaxRefError()
    CapturePage().mandatoryDateError()
  }

  //Scenario: Error messages for the invalid format data entered on the Capture Page

  Given( """^I am on the Search Page$""") { () =>
    CapturePage() iAmInCapturePage()
   }

  When( """^I enter invalid UTR and invalid date format$""") { () =>
    CapturePage().selectTaxRef
    CapturePage().invalidData("123456","32","13","2018")

  }

  And ("""^I click the submit button$""") { () =>
    CapturePage().clickContinue_button()
  }
  And ("""^I will get the invalid format error messages displayed on the page$""") { () =>
    CapturePage().invalidUTRError()
    CapturePage().invalidDateError()
  }


  //for valid data

  Given( """^I am on the Search Page$""") { () =>
    CapturePage() iAmInCapturePage()
  }

  When( """^I enter valid UTR, valid TaxRefType and a valid date format$""") { () =>
    CapturePage().Utrdetails
    CapturePage().selectTaxRef
    CapturePage().enterDay()
    CapturePage().enterMonth()
    CapturePage().enterYear()

  }

  And ("""^I click the submit button$""") { () =>
    CapturePage().clickContinue_button()
  }

  Then ("""^I will progress to the search Results page$""") { () =>
CurrentSearchResultsPage().iAmInSearchResultPage()
  }
}