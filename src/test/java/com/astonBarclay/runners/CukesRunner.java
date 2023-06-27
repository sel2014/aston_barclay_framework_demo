package com.astonBarclay.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html", //for  normal html report
                "rerun:target/rerun.txt",           //for running only failed scenarios (saves time)
                "json:target/cucumber.json",        //tells cucumber to generate test result in json format
                "me.jvt.cucumber.report.PrettyReports:target/cucumber", //for a detail report (better than html)
        },
        features = "src/test/resources/features", //location of my feature files for cucumber
        glue = "com/astonBarclay/step_definitions", //location of my step definitions for cucumber
        dryRun = false,
        tags = "",                 //I use tags to add tags to my scenarios such as @smoke @regression
        publish = true            //This is to share my report that has a link on the console when run tests

)

public class CukesRunner {



}
