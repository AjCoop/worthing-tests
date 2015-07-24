package uk.gov.hmrc.integration.cucumber.support.utils

import java.io.FileInputStream
import java.util.PropertyResourceBundle

object MessagesReader {
  val message = new FileInputStream("./src/test/resources/messages.properties");
  val messageResource = {
    try {
      new PropertyResourceBundle(message)
    } finally {
      message.close()
    }
  }
  def getMessage(key: String) = messageResource.getString(key).replaceFirst("'", "")
}
