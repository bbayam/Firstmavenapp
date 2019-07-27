package com.cybertek.tests.Day8_TestingIntro;

import org.testng.annotations.*;

public class MixedAnnotationTesting {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void setup() {
    System.out.println("Before method");
    }
    @Test
    public void test1(){
        System.out.println("I am test1");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @Test
    public void test2() {
        System.out.println("I am test 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
}
