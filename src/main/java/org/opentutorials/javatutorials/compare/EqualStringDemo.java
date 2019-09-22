package org.opentutorials.javatutorials.compare;

public class EqualStringDemo {

    public static void main(String[] args)
    {
        //String비교시, .equals를 써야함.
        //눈에 보이는것만으로 설명안되는 것.ㄴ
        String a = "Hello world";
        String b = new String("Hello world");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

}
