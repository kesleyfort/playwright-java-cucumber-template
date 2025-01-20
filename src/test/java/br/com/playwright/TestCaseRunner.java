package br.com.playwright;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/br/com/playwright/features",
        glue = {"br.com.playwright.steps"},
        plugin = {"pretty"})
public class TestCaseRunner {

}