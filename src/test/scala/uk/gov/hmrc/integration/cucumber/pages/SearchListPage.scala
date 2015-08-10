package uk.gov.hmrc.integration.cucumber.pages

import java.util

import gherkin.lexer.No
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Assert
import org.openqa.selenium.{WebDriver, WebElement, By}
import org.scalatest.Matchers
import scala.collection.JavaConverters._
import uk.gov.hmrc.integration.cucumber.utils.BaseUtil._


/**
 * Created by haripriya on 29/07/15.
 */
object SearchListPage extends BasePage with Matchers {

  //viewing all the fields titles/labels
  def SearchTime = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[1]")).getText.contains("Search Time"))
  def Type = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[2]")).getText.contains("Type"))
  def ID = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[3]")).getText.contains("ID"))
  def DateSent = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[4]")).getText.contains("Date Sent"))
  def DateReceived = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[5]")).getText.contains("Date Received"))
  def Status = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/table/thead/tr/th[6]")).getText.contains("Status"))

  def GetAllCheckPostTitle = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='page-title']")).getText.contains("Get All Check Post"))
  def SubTitle = Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/section/div/p")).getText.contains("Get All Searches"))

  //Random UTR generator

   var utr: Int = 0
   def timestamp = DateTimeFormat.forPattern("yyyy-MM-dd").print(new DateTime())
   def genAndSetUTR={
     utr = GenRandInt(100000000, 999999999).next
     driver.findElement(By.xpath("//*[@id='id']")).sendKeys(""+utr)
  }
    case class GenRandInt(lb: Int, ub: Int) {
    private val rnd = new scala.util.Random

    def next(): Int = {
      lb + rnd.nextInt(ub)
    }
  }

// verifying the table to see whether the record (Input search) is present

  def verifyTheInputRecord: Unit = {
    //getting all the rows from the table
    val rows: util.List[WebElement] = driver.findElements(By.xpath("//*[@id='content']/section/div/table/tbody/tr"))
    val scalaRows = rows.asScala
    val lastRow = scalaRows.last
    val cells: util.List[WebElement] = lastRow.findElements(By.xpath("./td"))
    Assert.assertFalse(cells.isEmpty)
    val scalaCells = cells.asScala
    Assert.assertTrue(scalaCells(0).getText substring(0,10) equals timestamp)
    println(timestamp)
    Assert.assertTrue(scalaCells(1).getText.equals(getMessage("testValue.idType")))
    Assert.assertTrue(scalaCells(2).getText.equals(utr.toString()))
    Assert.assertTrue(scalaCells(4).getText.equals(getMessage("testValue.idDateReceived")))
    Assert.assertTrue(scalaCells(5).getText.equals(getMessage("testValue.idStatus")))
    }


}

