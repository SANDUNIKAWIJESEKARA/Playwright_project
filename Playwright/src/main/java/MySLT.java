import com.microsoft.playwright.*;
public class MySLT {
    private static void log(String message) {
        System.out.println("[LOG] " + java.time.LocalTime.now() + " | " + message);
    }
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {

            // Launch browser (headed mode)
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            Page page = browser.newPage();

            // 1. LOGIN AUTOMATION
            log("Navigating to MySLT Portal...");
            page.navigate("https://myslt.slt.lk/");
            log("Entering credentials...");

            page.locator("input[placeholder*='Email or mobile number']")
                    .fill("######");

            page.locator("input[placeholder*='characters']")
                    .fill("######");

            page.locator("button:has-text('Sign In')").click();
            log("Sign In clicked. Waiting for dashboard to load...");
            log("Login successful...");

            // 2.PEOTV
            Locator peoTvButton = page.locator("//button[.//div[text()='PEOTV']]");
            peoTvButton.waitFor();   // Smart wait
            peoTvButton.click();
            log("PEOTV Page loaded.");

            // Wait until dashboard buttons appear again
            peoTvButton.waitFor();

            // 3.Digital Life
            Locator digitalLife = page.locator("//button[p[text()='Digital Life']]");
            digitalLife.click();
            digitalLife.waitFor();
            log("Digital Life Page loaded.");

            // 4.Bill
            Locator bill = page.locator("//button[p[text()='Bill']]");
            bill.click();
            bill.waitFor();
            log("Bill Page loaded.");

            // 5.Complaints
            Locator complaints = page.locator("//button[p[text()='Complaints']]");
            complaints.click();
            complaints.waitFor();
            log("Complaints Page loaded.");

            // 6.Broadband
            Locator broadband = page.locator("//button[.//div[text()='Broadband']]");
            broadband.click();
            broadband.waitFor();
            log("Broadband Page loaded.");

            // 7.New Services
            Locator NewServices = page.locator("//button[.//div[text()='New Services']]");
            broadband.click();
            broadband.waitFor();
            log("New Services Page loaded.");

            // 7.Digital Life
            Locator Digital_life = page.locator("//button[.//div[text()='Digital Life']]");
            broadband.click();
            broadband.waitFor();
            log("Digital Life Page loaded.");

            // 8.Voice
            Locator Voice = page.locator("//button[.//div[text()='Voice']]");
            broadband.click();
            broadband.waitFor();
            log("Voice Page loaded.");

            // 9.Mobile
            Locator Mobile = page.locator("//button[.//div[text()='Mobile']]");
            broadband.click();
            broadband.waitFor();
            log("Mobile Page loaded.");

            browser.close();



        } catch (Exception e) {
            log("Automation FAILED: " + e.getMessage());
            System.exit(1);  // return failure exit code
        }
    }
}