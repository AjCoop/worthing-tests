package uk.gov.hmrc.integration.cucumber

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk/gov/hmrc/integration/cucumber/stepdefs"),
  format = Array("pretty"),
  tags = Array("@wip")
)
class RunWipTests {
}

