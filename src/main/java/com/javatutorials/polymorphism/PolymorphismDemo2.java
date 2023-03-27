package com.javatutorials.polymorphism;

class A_1{
    public String x(){return "A.x";}
}
class B_1 extends A_1{
    public String x(){return "B.x";}
    public String y(){return "y";}
}
class B2_1 extends A_1{
    public String x(){return "B2.x";}
}
public class PolymorphismDemo2 {
    public static void main(String[] args) {
        A_1 obj = new B_1();
        A_1 obj2 = new B2_1();
        System.out.println(obj.x());//B.x
        System.out.println(obj2.x());//B2.x
    }
}