package scenarios;

import configuration.DriverEnum;
import configuration.TestBase;
import org.testng.annotations.Test;
import workflows.Workflow;

public class PurchaseTests extends TestBase {
    public PurchaseTests() { super(DriverEnum.CHROME, "PurchaseTests"); }

    @Test
    public void validateSuccessfulPurchase() throws Exception {
        Workflow
                .of(driver)
                .validateSuccessfulPurchase();
    }
}
