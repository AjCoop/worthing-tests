package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
  * Created by sam on 04/12/15.
  */
object Declaration extends BasePage {

  def getToDeclarationPage() ={
    driver.navigate().to("localhost:9090/tlfd-frontend/dds/declaration")
  }

  def clickContinue() ={
    driver.findElement(By.id("continue")).click()
  }

  def checkForSumaryPage() ={
    Assert.assertTrue(driver.findElement(By.id("page-title")).getText.contains("Summary"))
  }

  def clickBack() ={
    driver.findElement(By.id("back")).click()
  }

  def checkForPersonalDetailsPage() ={
    Assert.assertTrue(driver.findElement(By.id("page-title")).getText.contains("Personal Details"))
  }

}
