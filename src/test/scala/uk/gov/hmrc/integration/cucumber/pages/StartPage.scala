package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 * Created by haripriya on 07/08/15.
 */
object StartPage extends BasePage {

  def getToPage() ={
    driver.navigate().to("localhost:9090/tlfd-frontend/dds/start")
  }

  def checkStartPage() ={
    Assert.assertTrue(driver.findElement(By.id("page-title")).getText.contains("Digital Disclosure Service"))
  }

  def clickStart() ={
    driver.findElement(By.id("continue")).click()
  }

  def checkPage() ={
    Assert.assertTrue(driver.findElement(By.id("page-title")).getText.contains("About your disclosure"))
  }

  def clickFirstDrop() ={
    driver.findElement(By.xpath(".//*[@id='content']/details[1]/summary/span")).click()
  }

  def clickSecondDrop() ={
    driver.findElement(By.xpath(".//*[@id='content']/details[2]/summary/span")).click()
  }

  def checkFirstDropOpen() ={
    driver.findElement(By.xpath("//*[@id='details-content-0']/div[1]/div[1]/p")).getText.contains("Telephone:")
  }

  def checkSecondDropOpen() ={
    driver.findElement(By.xpath(".//*[@id='details-content-1']/p[1]")).getText.contains("You can complete this disclosure form on behalf")
  }

}
