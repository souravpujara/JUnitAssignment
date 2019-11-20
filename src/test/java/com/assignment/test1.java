//package com.assignment;
//
//
//import org.junit.BeforeClass;
//import org.junit.Rule;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.junit.rules.ExpectedException;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matcher.*;
//import static org.hamcrest.CoreMatchers.*;
//
//public class test1 {
//     
//    @BeforeAll
//    static void setup(){
//        System.out.println("@BeforeAll executed");
//    }
//     
//    @BeforeEach
//    void setupThis(){
//        System.out.println("@BeforeEach executed");
//    }
//     
//    @Tag("DEV")
//    @Test
//    void testCalcOne() 
//    {
//        System.out.println("======TEST ONE EXECUTED=======");
//        Assertions.assertEquals( 4 , 4);
//    }
//    @BeforeClass  static void Method_Name() {	
//    	 System.out.println("======BEFORE CLASS=======");
//     }	
//    @Tag("PROD")
//    @Test
//    void testCalcTwo() 
//    {
//        System.out.println("======TEST TWO EXECUTED=======");
//        Assertions.assertNotEquals( 6 ,3,"Test Failed");
//    }
//     
//    @AfterEach
//    void tearThis(){
//        System.out.println("@AfterEach executed");
//    }
//     
//    @AfterAll
//    static void tear(){
//        System.out.println("@AfterAll executed");
//    }
//    
//    
//    @Rule
//    public ExpectedException exception = ExpectedException.none();
//
//	
//}