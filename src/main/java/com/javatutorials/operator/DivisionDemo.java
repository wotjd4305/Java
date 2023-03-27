package com.javatutorials.operator;

public class DivisionDemo {
    public static void main(String[] args)
    {
        int a = 10;
        int b = 3;

        float c = 10.0F;
        float d = 3.0F;

        //3번째 경우, 형변환을 해주는데 a,d를 같은 형태로 변환시켜줌.
        //더 조밀한 숫자인 float를 사용
        System.out.println(a/b);//3
        System.out.println(c/d);//3.3333
        System.out.println(a/d);//3.3333
    }

}
