package org.opentutorials.javatutorials.variables;

public class Practice {

    public static void main(String[] args)
    {
        //변수가 없다면? a를 100->1000으로 바꿀시 전부다 바꿔야함(당연)
        System.out.println(100 + 10);//110
        System.out.println((100 + 10) / 10);//11
        System.out.println(((100 + 10) / 10) - 10);//1
        System.out.println((((100 + 10) / 10) - 10) * 100);//100

        System.out.println();

        int a = 100;
        System.out.println(a + 10);//110
        System.out.println((a+ 10) / 10);//11
        System.out.println(((a + 10) / 10) - 10);//1
        System.out.println((((a + 10) / 10) - 10) * 10);//100

        //(+) 세미콜론
        //다음과 같이 끝을 제대로 구분할수있기 때문에 다음도 맞는 표현!
        String c; String d;


    }
}
