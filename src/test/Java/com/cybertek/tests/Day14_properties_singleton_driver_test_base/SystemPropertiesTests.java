package com.cybertek.tests.Day14_properties_singleton_driver_test_base;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTests {

    @Test
    public void systemPropertiesTest1(){
        String os = System.getProperty("os.name");
        String username = System.getProperty("user.name");
        String javaVersion = System.getProperty("java.version");
        String JavaVersion =System.getProperty("java.specification.version") ;
        String homeDirectory = System.getProperty("user.home");
        System.out.println(os);
        System.out.println(username);
        System.out.println(javaVersion);
        System.out.println(JavaVersion);
        System.out.println(homeDirectory);

        Properties properties = System.getProperties();
        //this is an entry set of all properties
        //since it is ke -value pair, we use Map to store this information

        for(Map.Entry<Object, Object> property: properties.entrySet()){
            //get key fo everry item (os.name)     value of every property  (Mac OS X)
            System.out.println("Key: "+property.getKey()+", Value: "+property.getValue());

        }
    }
}
