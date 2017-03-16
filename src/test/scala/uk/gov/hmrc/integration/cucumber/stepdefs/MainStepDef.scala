package uk.gov.hmrc.integration.cucumber.stepdefs

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.pages.MainPage

/**
  * Created by adam on 15/03/17.
  */
class MainStepDef extends ScalaDsl with EN {

  Given("""^The user navigates to the main page$""") { () =>
    MainPage.navigateToPage("http://localhost:3003")
  }
  When("""^The user logs in$""") { () =>
    MainPage.clickByCss("[data-toggle~=modal]")
    MainPage.waitForPageToBeLoaded(MainPage.findById("username").isDisplayed == true, "No Pop up", 10)
    MainPage.findById("username").sendKeys("admin")
    MainPage.findById("password").sendKeys("password")
    MainPage.clickContinue()
  }

  Then("""^The user enters (.*), (.*), (.*), (.*) and (.*) as their data$""") {
    (hotel: String, address: String, owner: String, phone: String, email: String) =>
      MainPage.waitForPageToBeLoaded(MainPage.findById("hotelName").isDisplayed == true, "No Pop up", 10)
      MainPage.findById("hotelName").sendKeys(hotel)
      MainPage.findById("address").sendKeys(address)
      MainPage.findById("owner").sendKeys(owner)
      MainPage.findById("phone").sendKeys(phone)
      MainPage.findById("email").sendKeys(email)
      MainPage.clickCreate()
  }

  When("""^the user clicks delete$""") {
    MainPage.clickByCss("[class~=glyphicon glyphicon-remove hotelDelete]")

  }

  Then("""^the row is deleted$""") {


  }
}