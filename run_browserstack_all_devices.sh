#!/bin/bash
echo "Start with $# Devices"

# Loop until all parameters are used up
while [ "$1" != "" ]; do
    echo "Device equals $1"
    sbt -Dbrowser=mobiledevices -DtestDevice="$1" -Denvironment=local 'test-only uk.gov.hmrc.integration.cucumber.utils.Runner'
    shift
done