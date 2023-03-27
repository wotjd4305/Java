package com.javatutorials.scope;

class C3 {
    int v = 10;

    void m() {
        int v = 20;
        //this.v는 인스턴스 변수, static이면 클래스변수!
        System.out.println(this.v);
    }
}

public class ScopeDemo9 {

    public static void main(String[] args) {
        C3 c1 = new C3();
        c1.m();

        //이건 오류임. static이 없으니까까
       //C3.v = 10;
    }

}