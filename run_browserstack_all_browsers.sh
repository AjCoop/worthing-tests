#!/bin/bash
echo "Start with $# browsers"

# Loop until all parameters are used up
while [ "$1" != "" ]; do
    echo "Browser equals $1"
    sbt -Dbrowser=browserstack -DtestDevice="$1" -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.utils.Runner'
    shift
done