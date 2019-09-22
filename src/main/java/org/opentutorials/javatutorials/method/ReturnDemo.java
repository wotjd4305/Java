package org.opentutorials.javatutorials.method;

public class ReturnDemo {

    public static int one() {
        return 1;
        //return 2;
        //return 3;
    }

    //return 1을 만나는 순간 뒤에 까지안가고 끝냄
    public static void main(String[] args) {
        System.out.println(one());//1
    }

}
