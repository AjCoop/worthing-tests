package uk.gov.hmrc.integration.cucumber.utils

import java.net.URL

import org.openqa.selenium.Proxy.ProxyType
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxProfile}
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities, RemoteWebDriver}
import org.openqa.selenium.{Proxy, WebDriver}
import org.openqa.selenium.chrome.{ChromeOptions, ChromeDriver}
import play.api.libs.json.Json
import scala.collection.JavaConversions._
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.Proxy.ProxyType
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxProfile}
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.{Platform, Proxy, Dimension, WebDriver}
import java.util.concurrent.TimeUnit
import org.openqa.selenium.remote.{CapabilityType, RemoteWebDriver, DesiredCapabilities}
import org.scalatest.selenium._
import scala.io.Source

import play.api.libs.json.Json

object SingletonDriver extends Driver

class Driver {
  private val SAUCY = "saucy"
  private val ZAP = "zap"

  var instance: WebDriver = null
  private var baseWindowHandle: String = null
  var javascriptEnabled: Boolean = true

  def setJavascript(enabled: Boolean) {
    javascriptEnabled = enabled
    if (instance != null) closeInstance()
  }

  def getInstance(): WebDriver = {
    if (instance == null) {
      initialiseBrowser()

     /* Runtime.getRuntime.addShutdownHook(new Thread() {
        @Override
        override def run() {
          instance.close()
        }
      })*/
    }
    instance
  }

  def initialiseBrowser() {
    instance = createBrowser()
    instance.manage().window().maximize()
    baseWindowHandle = instance.getWindowHandle
  }

  def closeInstance() = {
    if (instance != null) {

      closeNewlyOpenedWindows()

      instance.close()
      instance = null
      baseWindowHandle = null
    }
  }

  def closeNewlyOpenedWindows() {
    instance.getWindowHandles.toList.foreach(w =>
      if (w != baseWindowHandle) instance.switchTo().window(w).close()
    )

    instance.switchTo().window(baseWindowHandle)
  }

  private def createBrowser(): WebDriver = {
    def createFirefoxDriver: WebDriver = {
      val profile: FirefoxProfile = new FirefoxProfile
      profile.setPreference("javascript.enabled", javascriptEnabled)
      profile.setAcceptUntrustedCertificates(true)
      new FirefoxDriver(profile)
    }

    def createChromeDriver(): WebDriver = {
      val capabilities = DesiredCapabilities.chrome()
      capabilities.setJavascriptEnabled(javascriptEnabled)
      val options = new ChromeOptions()
      capabilities.setCapability(ChromeOptions.CAPABILITY, options)
      val driver = new ChromeDriver(capabilities)
      driver.manage().window().maximize()
      driver
    }


    def createPhantomJsDriver: WebDriver = {
      val cap = new DesiredCapabilities()
      cap.setJavascriptEnabled(javascriptEnabled)
      new PhantomJSDriver(cap)
    }

    def createHMTLUnitDriver: WebDriver = {
      new HtmlUnitDriver()
    }

    def createSaucyDriver: WebDriver = {
      val capabilities = DesiredCapabilities.firefox()
      capabilities.setCapability("version", "22")
      capabilities.setCapability("platform", "OS X 10.9")
      capabilities.setCapability("name", "Frontend Integration") // TODO: should we add a timestamp here?

      new RemoteWebDriver(
        new java.net.URL("http://Optimus:3e4f3978-2b40-4965-a6b3-4fb7243bc1f2@ondemand.saucelabs.com:80/wd/hub"), //
        capabilities)
    }

//    def createBrowserDriver: WebDriver = {
//      val USERNAME = "nayak2"
//      val AUTOMATE_KEY = "S7JsBA5eDPATh923N8pV"
//      val URL = s"http://$USERNAME:$AUTOMATE_KEY@hub.browserstack.com/wd/hub"
//
//
//      val caps = new DesiredCapabilities
//      caps.setCapability("browser", "IE")
//      caps.setCapability("browser_version", "7.0")
//      caps.setCapability("os", "Windows")
//      caps.setCapability("os_version", "XP")
//      caps.setCapability("browserstack.debug", "true")
//      caps.setCapability("browserstack.local", "true")
//
//
//     new RemoteWebDriver(new URL(URL), caps)
//
//
//    }

    def createBrowserDriver: WebDriver = {
      val USERNAME = "alexwalker2"
      val AUTOMATE_KEY ="4JzhcMbsHtzjhS44vWLw"
      val URL = s"http://$USERNAME:$AUTOMATE_KEY@hub.browserstack.com/wd/hub"

      val testDevice = System.getProperty("testDevice", "BS_Win8_Chrome_38")

      val url= "/browserstackdata/" + testDevice + ".json"
      val source = Source.fromURL(getClass.getResource(url)).mkString
      val browserDetails = Json.parse(source)
      val browserName = (browserDetails \ "browser").as[String]
      val browserVersion = (browserDetails \ "browserVersion").as[String]
      val os = (browserDetails \ "os").as[String]
      val osVersion = (browserDetails \ "osversion" ).as[String]


      val caps = new DesiredCapabilities
      caps.setCapability("browser", browserName)
      caps.setCapability("browser_version", browserVersion)
      caps.setCapability("os", os)
      caps.setCapability("os_version", osVersion)
      caps.setCapability("browserstack.debug", "true")
      caps.setCapability("browserstack.local", "true")
      caps.setCapability("project", "Telford App")
      caps.setCapability("build", "Local Complete TestBuild_1.0")
      new RemoteWebDriver(new URL(URL), caps)
    }

    def createZap: WebDriver = {
      val proxy: Proxy = new Proxy()
      proxy.setAutodetect(false)
      proxy.setProxyType(ProxyType.MANUAL)
      proxy.setHttpProxy("localhost:8080")

      val capabilities = DesiredCapabilities.firefox()

      capabilities.setCapability(CapabilityType.PROXY, proxy)

      new FirefoxDriver(capabilities)
    }

    val environmentProperty = System.getProperty("browser","firefox")
    environmentProperty match {
      case "firefox" => createFirefoxDriver
      case "browserstack" => createBrowserDriver
      case "htmlunit" => createHMTLUnitDriver
      case "chrome" => createChromeDriver
      case SAUCY => createSaucyDriver
      case ZAP => createZap
      case _ => throw new IllegalArgumentException(s"Browser type not recognised")
    }
  }
}


