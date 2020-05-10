package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/com/features",
                 glue="com/stepsDefinitions")
public class Runner {

}
