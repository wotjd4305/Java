package com.daou.test;

public class split {
    public static void main(String args[]){
        String test = "a.";
        String test2[] = test.split("[.]");
        System.out.println(test2[1]);
    }
}
