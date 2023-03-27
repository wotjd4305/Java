package com.javatutorials.method;

public class MethodDemo4 {

    //limit는 매개변수
    public static void numbering(int limit) {
        int i = 0;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }

    //5는 인자(argument)
    public static void main(String[] args) {
        numbering(5);
    }
}
