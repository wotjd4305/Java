package com.javatutorials.overloading.example1;

public class OverloadingDemo {
    void A (){System.out.println("void A()");}
    void A (int arg1){System.out.println("void A (int arg1)");}
    void A (String arg1){System.out.println("void A (String arg1)");}

    //알 수가 없음. 어떤것을 호출 할지.
    //int A (){System.out.println("void A()");}
    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();
        od.A();
        od.A(1);
        od.A("coding everybody");
    }
}