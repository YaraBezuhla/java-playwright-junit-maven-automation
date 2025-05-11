package journal.reading.automation.core.utilities;

import com.microsoft.playwright.options.ViewportSize;
import java.awt.*;

public class GetScreenSize {
    public static ViewportSize getViewportSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        return new ViewportSize(width, height);
    }
}
