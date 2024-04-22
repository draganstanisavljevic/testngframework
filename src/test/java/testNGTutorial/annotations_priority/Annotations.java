package testNGTutorial.annotations_priority;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Annotations {

    @Test
    public void testCase1() {
        System.out.println("--- Annotations1 This is the A Normal Test Case 1-------");
    }

    @Test
    public void testCase2() {
        System.out.println("--- Annotations1 This is the A Normal Test Case 2-------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before every Method in Annotations1 ");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before the Class in Annotations1");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("before the Test in Annotations1");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before the Test Suite in Annotations1");
    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("after the Test Suite");
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println("after the Test");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("after every Method");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("after the Class");
//    }
}
