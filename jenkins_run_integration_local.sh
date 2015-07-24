#!/bin/bash
export DISPLAY=":99"
sbt -Dbrowser=firefox 'test-only uk.gov.hmrc.integration.cucumber.RunTestSuite'

