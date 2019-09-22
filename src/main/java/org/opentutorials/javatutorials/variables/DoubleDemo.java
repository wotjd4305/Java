package org.opentutorials.javatutorials.variables;

public class DoubleDemo {

    public static void main(String[] args)
    {
        //double은 실수형을 저장하는 컨테이너
        double a;
        a= 1.1;//실수의 데이터 타입

        System.out.println(a+ 1.1);

        //이 경우 타입 미스매치(정수형에 실수형은 넣으려고 했기 때문) (!)에러
        //이것의 장점은 타입이 미리 정해져있으면 나중에 타입판별할필요가없음!
        //'Strong 데이타 타입'이라고도 함

        /*
        int b;
        b = 1.1;

        System.out.println(a+1.1);*/

    }
}
