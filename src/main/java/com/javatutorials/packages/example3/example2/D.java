package com.javatutorials.packages.example3.example2;


public class D {
    public static void main(String[] args)
    {
        //둘중 어떤 B를쓰나요?? 패키지의 중복때문.
        //B b = new B();

        com.javatutorials.packages.example1.B b = new com.javatutorials.packages.example1.B();
    }


}
