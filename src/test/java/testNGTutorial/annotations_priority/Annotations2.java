package testNGTutorial.annotations_priority;

import org.testng.annotations.*;


public class Annotations2 {

    @Test
    public void testCase1() {
        System.out.println("---Annotations2 This is the A Normal Test Case 1-------");
    }

    @Test
    public void testCase2() {
        System.out.println("---Annotations2 This is the A Normal Test Case 2-------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before every Method in Annotations2");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before the Class  in Annotations2");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before the Test  in Annotations2");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before the Test Suite in Annotations2");
    }

    @BeforeSuite
    public void beforeSuite2() {
        System.out.println("before the Test Suite Annotations2 duplicated");
    }

//    @AfterTest
//    public void afterTest() {
//        System.out.println("after the Test  in Annotations2");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("after the Test Suite  in Annotations2");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("after the Class  in Annotations2");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("after every Method  in Annotations2");
//    }
}
