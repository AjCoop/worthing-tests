package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages.BasePage._

class CapturePageFields extends ScalaDsl with EN {


  //Scenario: Error messages for the mandatory fields on the Capture Page

  Given( """^I am on the Search Page$""") { () =>
    CapturePage().login()
    CapturePage().iAmInCapturePage()
    CapturePage().verifyHeading()
    CapturePage().verifySearchSubHeading()
    CapturePage().UTRRadioLabel()
    CapturePage().TaxRefRadioLabel()
    CapturePage().Identifier()
    CapturePage().Date()
  }

  /*as the page is loaded all the selected options i.e taxRef gets unset*/
  When( """^I leave all the fields empty$""") { () =>
    CapturePage().emptyIdentifierField()
    CapturePage().emptyDayField()
    CapturePage().emptyMonthField()
    CapturePage().emptyYearField()

  }
  And( """^I click the submit button$""") { () =>
    CapturePage().clickFindPost_button()
  }


 Then( """^I will get the mandatory error messages displayed on the page$""") { () =>
    CapturePage().verifyErrorHeading()
    CapturePage().mandatoryIdentifierError()
    CapturePage().mandatoryTaxRefError()
    CapturePage().mandatoryDateError()
  }

  //Scenario: Error messages for the invalid format data entered on the Capture Page

  Given( """^I am on the Search Page,I enter invalid UTR and invalid date format and I click the submit button$""") { () =>
    CapturePage() iAmInCapturePage()
    CapturePage().selectTaxRef()
    CapturePage().invalidDay()
    CapturePage().invalidMonth()
    CapturePage().invalidYear()

  }

  And( """^I will get the invalid format error messages displayed on the page$""") { () =>
    CapturePage().clickFindPost_button()
    CapturePage().invalidDateError()
    //
    //  }
    //
    //  And ("""^I click the submit button$""") { () =>
    //
    //  }
    //  And ("""^I will get the invalid format error messages displayed on the page$""") { () =>
    //    //CapturePage().invalidIdentifier()
    //    CapturePage().invalidDateError()
    //  }
    //
    //
    //  //for valid data
    //
    //  Given("""^I am on the Search Page$""") { () =>
    //    CapturePage() iAmInCapturePage()
    //  }
    //
    //  When("""^I enter valid UTR, valid TaxRefType and a valid date format$""") { () =>
    //    CapturePage().identifierDetails
    //    CapturePage().selectTaxRef
    //    CapturePage().enterDay()
    //    CapturePage().enterMonth()
    //    CapturePage().enterYear()
    //
    //  }
    //
    //  And ("""^I click the submit button$""") { () =>
    //    CapturePage().clickFindPost_button()
    //  }
    //
    //  Then ("""^I will progress to the search Results page$""") { () =>
    //CurrentSearchResultsPage().iAmInSearchResultPage()
    //  }
  }
}