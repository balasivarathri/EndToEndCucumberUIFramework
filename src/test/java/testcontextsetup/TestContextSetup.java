package testcontextsetup;

import com.qa.ui.base.TestBase;
import com.qa.pages.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public PageObjectManager pageObjectManager;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
    }
}
