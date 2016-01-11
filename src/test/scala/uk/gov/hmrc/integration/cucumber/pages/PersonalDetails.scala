package uk.gov.hmrc.integration.cucumber.pages

import java.util
import org.junit.Assert
import scala.collection.JavaConverters._
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import org.scalatest.Matchers
import scala.collection.JavaConverters._
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._

/**
  * Created by thomas on 04/12/15.
  */
object PersonalDetails extends BasePage with Matchers {

  def checkPersonalDetailsPage() = driver.navigate().to("localhost:9090/tlfd-frontend/dds/personal-details")

  def pressContinueButton() = {
    driver.findElement(By.id("content")).click()
  }

  def getToDeclarationPage() = {
    driver.navigate().to("localhost:9090/tlfd-frontend/dds/declaration")
  }

  def pressBackButton() = {
    //driver.findElement((By.xpath("//*[@id="content"]/form/p/a")).click())
  }

}
