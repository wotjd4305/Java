package com.javatutorials.operator;

public class PrePostDemo {
    public static void main(String[] args)
    {
        //1+2의 +는 infix(이항), 지금 파트는 pre,post(단항)
        int i = 3;
        i++;
        System.out.println(i); // 4 출력
        ++i;
        System.out.println(i); // 5 출력
        System.out.println(++i); // 6 출력
        System.out.println(i++); // 6 출력
        System.out.println(i); // 7 출력
    }

}
