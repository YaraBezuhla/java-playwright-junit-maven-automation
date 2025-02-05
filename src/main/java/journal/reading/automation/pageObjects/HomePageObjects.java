package journal.reading.automation.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageObjects {
    private Page page;

    public HomePageObjects(Page page){
        this.page = page;
    }

    Locator blocksTitles = page.getByTestId("popular-block-title");

    public void assertBlocksName(){
        assertThat(blocksTitles).hasText(new String[] { "apple", "banana"});
    }

}
