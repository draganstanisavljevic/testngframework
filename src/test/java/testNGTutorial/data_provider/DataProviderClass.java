package testNGTutorial.data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Inherited 1"}, {"Inherited 2"}};
    }
}
