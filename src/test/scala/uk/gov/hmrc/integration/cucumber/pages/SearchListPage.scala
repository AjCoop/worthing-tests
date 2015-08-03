package uk.gov.hmrc.integration.cucumber.pages

import java.util

import org.junit.Assert
import org.openqa.selenium.{WebDriver, WebElement, By}
import org.scalatest.Matchers

/**
 * Created by haripriya on 29/07/15.
 */
class SearchListPage (val driver: WebDriver) extends Matchers  {

  //clicking on the view all search link on the Search Results Page
  def ViewallSearch() {
    driver.findElement(By.id("viewAllSearchLink")).click()
  }

  def x = driver.findElement(By.xpath("//*[@id='content']/article/table/tbody/tr[1]/td[9]")).getText
  var allrows = 0
  def list1(): Boolean = {
    val rows: util.List[WebElement] = driver.findElements(By.xpath("//*[@id='content']/article/table/tbody/tr"))
    if (rows.size() == 1) {
      true
    } else {
      true
    }
  }

//viewing all the fields

  def UTR = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[3]")).getText.contains("UTR"))
  def TaxRef = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("TaxRef"))
  def Date = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("Date"))
  def Status = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("Status"))



}
