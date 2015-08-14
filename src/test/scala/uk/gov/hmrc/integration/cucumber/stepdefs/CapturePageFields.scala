package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.junit.Assert
import uk.gov.hmrc.integration.cucumber.pages._


class CapturePageFields extends ScalaDsl with EN {


  //SCENARIO: ERROR MESSAGES FOR THE MANDATORY FIELDS ON THE CAPTURE PAGE

  Given( """^I am on the Search Page$""") { () =>
    CapturePage.login()
    CapturePage.iAmInCapturePage()
    CapturePage.verifyHeading()
    CapturePage.verifySearchSubHeading()
    CapturePage.UTRRadioLabel()
    CapturePage.VRNRadioLabel()
    CapturePage.Identifier()
    CapturePage.Date()
  }

  /*as the page is loaded all the selected options i.e taxRef gets unset*/
  When( """^I leave all the fields empty$""") { () =>
    CapturePage.emptyIdentifierField()
    CapturePage.emptyDayField()
    CapturePage.emptyMonthField()
    CapturePage.emptyYearField()

  }
  And( """^I click the submit button$""") { () =>
    CapturePage.clickFindPost_button()
  }


  Then( """^I will get the mandatory error messages displayed on the page$""") { () =>
    CapturePage.verifyErrorHeading()
    CapturePage.mandatoryIdentifierError()
    CapturePage.mandatoryTaxRefError()
    CapturePage.mandatoryDateError()
  }

  //SCENARIO: ERROR MESSAGES FOR THE INVALID FORMAT DATA ENTERED ON THE CAPTURE PAGE

  Given( """^I am on the Search Page,I enter invalid UTR and invalid date format and I click the submit button$""") { () =>
    CapturePage iAmInCapturePage()
    CapturePage.selectTaxRef()
    CapturePage.invalidDay()
    CapturePage.invalidMonth()
    CapturePage.invalidYear()
    CapturePage.clickFindPost_button()
  }

  And( """^I will get the invalid format error messages displayed on the page$""") { () =>
    CapturePage.invalidDateError()

  }

  //SCENARIO: SEARCH USING VALID UTR,TAXREF AND DATE ENTERED

  Given( """^I am on the Search Page,I enter valid UTR, valid TaxRefType and a valid date and click the submit button$""") { () =>
    CapturePage iAmInCapturePage()
    CapturePage.selectTaxRef()
    CapturePage.identifierDetails()
    CapturePage.enterDay()
    CapturePage.enterMonth()
    CapturePage.enterYear()
    CapturePage.clickFindPost_button()
  }

  Then( """^I will progress to the search Results page$""") { () =>
    CurrentSearchResultsPage.verifyCheckPostHeading()
  }

  //SCENARIO:SEARCH USING VALID UTR,TAX REF TYPE AND DATE ENTERED WHERE THE STATUS IS RECEIVED

  Given( """^I am on the Search Page,I enter valid UTR, valid TaxRefType and a valid date and click the submit button where the status is Received$""") { () =>
    CapturePage.login()
    CapturePage iAmInCapturePage()
    //    CapturePage().selectTaxRef()
    CapturePage.fillData("option3")
    //    CapturePage().enterDay()
    //    CapturePage().enterMonth()
    //    CapturePage().enterYear()
    CapturePage.clickFindPost_button()
  }

  Then( """^I will progress to the search Results page and the Received status is displayed$""") { () =>
    CapturePage.receivedStatus()
  }

  Then("""^I click the back button to go back to the search page$""") { () =>
    BasePage.clickBackbutton()
    CapturePage.iAmInCapturePage()
  }


}