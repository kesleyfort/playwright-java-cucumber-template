package br.com.playwright;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/br/com/playwright/features",
        glue = {"br.com.playwright.steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "br.com.playwright.tools.StepInfoPlugin"})
public class TestCaseRunner {

}