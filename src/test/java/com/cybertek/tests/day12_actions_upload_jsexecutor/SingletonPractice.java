package com.cybertek.tests.day12_actions_upload_jsexecutor;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singletonTestOne() {
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);
        System.out.println();

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);
        System.out.println();

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }
    
    @Test
    public void singletonTestTwo() {
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
    }
}
