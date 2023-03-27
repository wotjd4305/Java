package com.javatutorials.scope;

public class ScopeDemo2 {

    static int i = 0;

    //선언된 부분에서만 효력이 발휘
    static void a() {
        i = 0;
    }

    //a()의 i는 여기에 작용하지 않음.
    //for문의 i랑 연관안됨. 이것이 Scope
    public static void main(String[] args) {
        for (i = 0; i < 5; i++) {
            a();
            System.out.println(i);//0이 반복
        }
    }

}