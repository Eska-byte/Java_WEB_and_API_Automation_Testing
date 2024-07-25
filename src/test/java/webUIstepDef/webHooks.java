package webUIstepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static helpers.WEB.webUtility.getDriver;
import static helpers.WEB.webUtility.quitDriver;

public class webHooks {
    @Before
    public void beforeTest(){
        getDriver();
    }

    @After
    public static void afterTest(){
        quitDriver();
    }
}
