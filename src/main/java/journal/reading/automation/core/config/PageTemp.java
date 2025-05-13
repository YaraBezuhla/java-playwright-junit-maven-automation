package journal.reading.automation.core.config;

import com.microsoft.playwright.Page;

public class PageTemp {
    private static Page page;

    public static void setPage(Page p) {
        page = p;
    }

    public static Page getPage() {
        return page;
    }
}
