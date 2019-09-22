package org.opentutorials.javatutorials.scope;

public class ScopeDemo6 {
    static int i = 5;

    static void a() {
        int i = 10;
        b();
    }

    static void b() {

        System.out.println(i);
    }

    //최종적으로 ScopeDemo6의 클래스변수(전역변수)인 i사용, 5출력
    public static void main(String[] args) {
        a();//5
    }

}