package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.pages.MainPage

/**
  * Created by adam on 15/03/17.
  */
class MainStepDef extends ScalaDsl with EN {

  Given("""^The user navigates to the main page$"""){ () =>
    MainPage.navigateToPage("http://localhost:3003")
}
   When ("""^The user logs in$"""){ () =>
    MainPage.clickByCss("[data-toggle~=modal]")
    MainPage.waitForPageToBeLoaded(MainPage.findById("username").isDisplayed == true, "No Pop up", 10)
    MainPage.findById("username").sendKeys("admin")
    MainPage.findById("password").sendKeys("password")
    MainPage.clickContinue()
  }

  Then ("""^The user enters in a single row of data$"""){ () =>
    MainPage.findById("hotelName").sendKeys("holiday inn")
    MainPage.findById("address").sendKeys("tree road")
    MainPage.findById("owner").sendKeys("Adam Cooper")
    MainPage.findById("phone").sendKeys("4534534534")
    MainPage.findById("email").sendKeys("adam@adam.COM")
    MainPage.clickCreate()


}


}