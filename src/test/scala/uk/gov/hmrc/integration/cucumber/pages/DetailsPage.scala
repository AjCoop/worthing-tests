package uk.gov.hmrc.integration.cucumber.pages

import java.util
import org.junit.Assert
import scala.collection.JavaConverters._
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._
import org.openqa.selenium.{Keys, WebDriver, WebElement, By}
import org.scalatest.Matchers
import scala.collection.JavaConverters._
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._

object DetailsPage extends BasePage with Matchers {

  def locateDetails() = driver.navigate().to("localhost:9090/tlfd-frontend/dds/details")


  /**
    * Tests to validate text with fields are correct
    */
  def QuestionOne() = Assert.assertTrue(driver.findElement(By.id("self")).getText.contains("Are you declaring on behalf of yourself?"))
  def QuestionTwo() = Assert.assertTrue(driver.findElement(By.id("refNo")).getText.contains("Do you have a disclosure reference number?"))
  def RadioButtonTextOne() = Assert.assertTrue(driver.findElement(By.id("self-yes")).getText.contains("I am completing this form for myself"))
  def RadioButtonTextTwo() = Assert.assertTrue(driver.findElement(By.id("self-no")).getText.contains("I am completing this form for someone else"))
  def RadioButtonTextThree() = Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='fieldOneTwo']/label[1]")).getText.contains("Yes"))
  def RadioButtonTextFour() = Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='fieldOneTwo']/label[2]")).getText.contains("No"))
  def HelpWithRefLabel() = Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='content']/form/details/summary/span")).getText.contains("Help with disclosure reference number"))
  def HiddenTextParaOne() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"details-content-0\"]/p[1]/text()")).getText.contains("If you have already contacted us about your disclosure you should have been given a disclosure reference number."))
  def HiddenTextParaTwo() = Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"details-content-0\"]/p[1]/text()")).getText.contains("Otherwise select No and Continue"))

  //*[@id="self"]/legend

  //Navigation test
  def getToPage() = {
    driver.navigate().to("localhost:9090/tlfd-frontend/dds/personal-details")
  }

  def goToStartPage() = {
    driver.navigate().to("localhost:9090/tlfd-frontend/dds/start")
  }

  //Click button test
  def clickContinue() = {
    driver.findElement(By.id("continue")).click()
  }

  def returnToPreviousPage() = {
    driver.findElement(By.id("back")).click()
  }

  def errorRefMessageCorrectLink() = {

  }


  //Error checking tests
  def mandatoryError()  = Assert.assertEquals(getMessage("testIdentifierValue.errorMessage"), driver.findElement(By.id("")).getText)
  def mandatoryTaxRefError() = Assert.assertEquals(getMessage("testTaxRefValue.errorMessage"), driver.findElement(By.xpath("//*[@id='idType-error']/a")).getText)
  def mandatoryDateError()  = Assert.assertEquals(getMessage("testDateValue.errorMessage"), driver.findElement(By.xpath("//*[@id='dateSent-error']/a")).getText)

}