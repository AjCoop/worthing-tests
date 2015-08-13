tlfd-acceptance-tests
=========================

This is the common project that will be used within DDCT when creating automated acceptance test frameworks using cucumber. Built using:

cucumber 1.1.8

java 1.8

Scala 2.11.7

SBT to build 0.13.8
    
### Getting started

Ensure that you have a working linux environment. If not follow the instructions [here](https://confluence.tools.tax.service.gov.uk/display/TAXS/Linux+environment+setup)

###  Test Automation environment setup

    1. Ensure that you have installed InteliJ Idea
    2. Once you have installed IDEA install Cucumber for scala
    3. Clone this repo.
    4. Import the project in InteliJ
    
###  Project structure
Each part of the application's functionality is described by feature files. The feature files are arranged into folders under src/test/features and grouped into the main areas of the application.
Each step of the feature files is defined by executable test steps in the scala code under the src/test/scala/uk/gov/hmrc/integration/test/stepdefs area and those utilise Page object models under src/test/scala/uk/gov/hmrc/integration/cucumber/pages which are the single place where page specific properties and variables are configured.

###  Execution
In /src/test/scala/uk/gov/hmrc/integration/cucumber there are scala classes which control what is run according to the tests tagged with the below tags. The main class is Runner which selects and runs tests marked @TLF3.
        

        
    
    
    
    
 

