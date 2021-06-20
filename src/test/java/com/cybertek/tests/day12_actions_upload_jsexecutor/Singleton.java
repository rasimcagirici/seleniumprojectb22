package com.cybertek.tests.day12_actions_upload_jsexecutor;

public class Singleton {

    private Singleton() {}

    private static String word;

    public static String getWord() {

        if (word == null) {
            System.out.println("First time call. Word object is null." + " Assigning value to it now");
            word = "something";
        } else {
            System.out.println("Word already has a value.");
        }
        return word;
    }

    public static void setWord(String word) {
        Singleton.word = word;
    }
}
