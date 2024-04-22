package testNGTutorial.parametrization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamsMultiply
{

    @Test
    @Parameters ({"val1", "val2"})
    public void mul(int v1, int v2) {
        int prod = v1*v2;
        System.out.println("The Product Of Value 1 and 2 is " + prod);
    }

}