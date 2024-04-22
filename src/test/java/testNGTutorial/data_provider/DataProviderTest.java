package testNGTutorial.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderTest {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }

    @Test (dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
    public void myTestWithInheritedDataProvider (String val) {
        System.out.println("Current Status : " + val);
    }

    @Test (dataProvider = "data-provider")
    public void myTest (String val) {
        System.out.println("Passed Parameter Is : " + val);
        int[][] arr = new int[10][20];
        arr[0][0] = 1;
        arr[0][1] = 2;

        System.out.println("arr[0][0] = " + arr[0][0]);
        System.out.println("arr[0][1] = " + arr[0][1]);
    }
}
