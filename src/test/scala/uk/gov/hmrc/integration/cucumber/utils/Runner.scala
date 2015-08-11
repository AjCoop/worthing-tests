package uk.gov.hmrc.integration.cucumber


import cucumber.api.java.Before
import cucumber.api.junit.Cucumber
import cucumber.api.junit.Cucumber.Options
import org.junit.runner.RunWith

import scala.sys.process.Process


@RunWith(classOf[Cucumber])
@Options(
  features = Array("../../src/test/resources/features"),
  glue = Array("uk.gov.hmrc.integration.cucumber.stepdefs"),
  format = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = Array("@TLF3")
  //tags = Array("@Suite,@BAPP5,@Pending,@shutdown","~@Wip,~@Zap,~@BAPP-REGISTER")
)
class Runner {
}
