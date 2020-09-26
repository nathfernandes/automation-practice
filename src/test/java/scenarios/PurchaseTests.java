package scenarios;

import configuration.DriverEnum;
import configuration.TestBase;
import org.testng.annotations.Test;
import utils.CRUD.User;
import utils.UserFactory;
import workflows.Workflow;

public class PurchaseTests extends TestBase {
    public PurchaseTests() { super(DriverEnum.CHROME, "PurchaseTests"); }

    @Test
    public void validateSuccessfulPurchase() {
        User user = UserFactory.createNewUser();
        Workflow
                .of(driver)
                .validateProductAdded()
                .validateSuccessfulPurchase(user);
    }
}
