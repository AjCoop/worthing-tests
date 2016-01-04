package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import uk.gov.hmrc.integration.cucumber.pages.{BasePage, _}


/**
  * Created by sam on 03/12/15.
  */
class BannerLinkTest extends ScalaDsl with EN {

  Given("""^I can see the Disclosure Service link$""") { () =>
    BannerLink.changePage()
  }

  When("""^I click the Disclosure Service link$"""){ () =>
    BannerLink.disclosureTopBannerLink()
  }

  Then("""^I should be taken to the start page$"""){ () =>
    BannerLink.checkCorrectPage()
  }


}