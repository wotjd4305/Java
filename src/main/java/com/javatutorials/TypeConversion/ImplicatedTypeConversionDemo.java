package com.javatutorials.TypeConversion;

public class ImplicatedTypeConversionDemo {

    //암시적 형변환(자동)
    public static void main(String[] args)
    {
        //형변환 가능 double > float
        //double a = 3.0f;

        //형변환 불가능 double > float!
        //float b = 3.0;//(!)오류

        //byte<short,char<int<long<float<double
        int a = 3;
        float b = 1.0F;
        double c = a + b;

        System.out.println(c);
    }

}
