#!/bin/bash
export DISPLAY=":99"
sbt -Dbrowser=firefox Denvironment=dev 'test-only uk.gov.hmrc.integration.cucumber.Runner'

