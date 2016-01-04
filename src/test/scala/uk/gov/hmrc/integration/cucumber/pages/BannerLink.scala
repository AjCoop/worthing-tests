package uk.gov.hmrc.integration.cucumber.pages

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._

/**
  * Created by sam on 03/12/15.
  */
object BannerLink extends BasePage {

  def disclosureTopBannerLink()     = {
    driver.findElement (By.id("ddsLink")).click()
    waitForPageToBeLoaded(driver.getTitle contains "Digital Disclosure Service", "Page did not load in time")
  }

  def changePage() ={
    driver.navigate().to("localhost:9090/tlfd-frontend/sms/page-one")
  }

  def checkCorrectPage() ={
    Assert.assertTrue(driver.findElement(By.id("page-title")).getText.contains("Digital Disclosure Service"))
  }

  //def savePageOneTitle()      = Assert.assertEquals(getMessage("page.one.title"), driver.findElement(By.xpath("//*[@id='page-title']")).getText)
  //def fieldOneLabel()          = Assert.assertEquals(getMessage("page.one.field.one"), driver.findElement(By.xpath("//*[@id='content']/form/div[1]/label")).getText)
  //def fieldTwoLabel()     = Assert.assertEquals(getMessage("page.one.field.two"), driver.findElement(By.xpath("//*[@id='content']/form/div[2]/label")).getText)
  //def fieldThreeLabel()     = Assert.assertEquals(getMessage("page.one.field.three"), driver.findElement(By.xpath("//*[@id='content']/form/div[3]/label")).getText)
  //def mandatoryFieldPageOneError() = Assert.assertEquals("This field is mandatory", driver.findElement(By.xpath(".//*[@id='fieldOneOne-error']/a")).getText)

}
