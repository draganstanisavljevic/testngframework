package testNGTutorial.parametrization;

import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params
{
    @Test
    @Parameters ({"val1", "val2"})
    public void Sum(int v1, int v2) {
        int finalsum = v1 + v2;
        Reporter.log("This is logged by Reporter");
        System.out.println("The final sum of the given values is " + finalsum);
    }

    @Test(groups = { "viewacc" })
    public void ViewAcc() {
        Reporter.log("This is logged by Reporter");
        System.out.println("View Your Dashboardd");
    }

    @Test
    @Parameters ("message")
    public void OP( @Optional("Optional Parameter Selected") String message) {
        System.out.println(message);
    }
}
