package uk.gov.hmrc.integration.cucumber.pages

import java.util

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Assert
import org.openqa.selenium.{WebDriver, WebElement, By}
import org.scalatest.Matchers
import scala.collection.JavaConverters._

/**
 * Created by haripriya on 29/07/15.
 */
class SearchListPage (val driver: WebDriver) extends Matchers {


  def timestamp = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").print(new DateTime())

//  //  def x = driver.findElement(By.xpath("//*[@id='content']/article/table/tbody/tr[1]/td[9]")).getText
//  //
//  //  var allrows = 0
//  def list: String = {
//    val rows: util.List[WebElement] = driver.findElements(By.xpath("//*[@id='content']/section/div/table/tbody/tr"))
//    //    if (rows.size() == 1) {
//    //      true
//    //    } else {
//    //      true
//    //    }
//    //  }
//
//    //val scalaRadios = rows.asScala
//    //  loop through all the rows
//    var row: WebElement = null
//    for (row <- rows) {
//      //if the radio button matches the value passed into this function...
//      if ((rows.getAttribute ("value").equals(timestamp)) {
//        // ... ensure that it is selected
//        println(timestamp)
//        Assert.assertTrue(row.getText.equals(timestamp))
//
//      } else {
//        // the radio doesn't match the passed in value
//        // ensure it is NOT selected
//        println("no data is found")
//        Assert.assertFalse(row.getText.equals(timestamp))
//      }
//    }

  def check()= {
    Assert.assertTrue(driver.getPageSource.contains(timestamp))
    println(timestamp)
  }
    //viewing all the fields

    //  def UTR = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[3]")).getText.contains("UTR"))
    //  def TaxRef = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("TaxRef"))
    //  def Date = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("Date"))
    //  def Status = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/article/form/fieldset/label[4]")).getText.contains("Status"))



}

