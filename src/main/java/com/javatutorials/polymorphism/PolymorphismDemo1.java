package com.javatutorials.polymorphism;

class A{
    public String x(){return "A.x";}
}
class B extends A{
    public String x(){return "B.X";}
    public String y(){return "y";}
}
public class PolymorphismDemo1 {
    public static void main(String[] args) {
        //B로 인스턴스화 하여 obj라는 변수를 만든것은 A형태를 띄고있다.
        A obj = new B();
        obj.x();
        System.out.println(obj.x());//B.x
        //따라서 이것은 못씀. 결국엔 A형태니까.
        //obj.y();
    }
}