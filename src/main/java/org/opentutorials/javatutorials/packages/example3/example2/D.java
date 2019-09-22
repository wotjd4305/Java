package org.opentutorials.javatutorials.packages.example3.example2;

import org.opentutorials.javatutorials.packages.example1.*;
import org.opentutorials.javatutorials.packages.example2.*;
import org.opentutorials.javatutorials.packages.example2.B;


public class D {
    public static void main(String[] args)
    {
        //둘중 어떤 B를쓰나요?? 패키지의 중복때문.
        //B b = new B();

        org.opentutorials.javatutorials.packages.example1.B b = new org.opentutorials.javatutorials.packages.example1.B();
    }


}
