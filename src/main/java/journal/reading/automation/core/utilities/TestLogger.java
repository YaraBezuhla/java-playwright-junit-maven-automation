package journal.reading.automation.core.utilities;

import com.microsoft.playwright.Page;
import journal.reading.automation.core.config.PageTemp;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class TestLogger implements BeforeTestExecutionCallback, AfterTestExecutionCallback, TestWatcher {

    private static final Logger logger = Logger.getLogger(TestLogger.class.getName());

    private static final String START_TIME = "start time";

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        takeScreenshot(context);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;

        logger.info(() ->
                String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
    }

    private void takeScreenshot(ExtensionContext context) {
        try {
            Page page = PageTemp.getPage();

            if (page == null) {
                logger.warning("Page is null, cannot take screenshot.");
                return;
            }

            Path path = Paths.get("target", "screenshots",
                    context.getDisplayName().replaceAll("\\s+", "_") + ".png");

            Files.createDirectories(path.getParent());

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(path)
                    .setFullPage(true));

            logger.info(() -> "Screenshot saved to: " + path.toAbsolutePath());
        } catch (Exception e) {
            logger.warning(() -> "Could not take screenshot: " + e.getMessage());
        }
    }


    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }

}

