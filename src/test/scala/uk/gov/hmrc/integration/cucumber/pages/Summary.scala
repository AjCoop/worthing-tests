package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
  * Created by sam on 04/12/15.
  */
object Summary extends BasePage {

  def getSummaryPage() ={
    driver.navigate().to("localhost:9090/tlfd-frontend/dds/summary")
  }

  def checkSummaryPage() ={
    Assert.assertFalse(driver.findElement(By.id("page-title")).getText.contains("Summary"))
  }

  def clickSummaryBackButton() ={
    driver.findElement(By.id("back")).click()
  }

  def checkForDeclarationPage() ={
    Assert.assertTrue(driver.findElement(By.id("page-title")).getText.contains("Declaration"))
  }

  def clickSummarySubmitButton() ={
    driver.findElement(By.id("continue")).click()
  }

}
