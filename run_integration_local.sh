#!/bin/bash
sbt -Dbrowser=phantomjs 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuite'

