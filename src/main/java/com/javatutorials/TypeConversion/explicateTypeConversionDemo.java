package com.javatutorials.TypeConversion;

public class explicateTypeConversionDemo {

    //명시적 형변환(수동)
    public static void main(String[] args)
    {
        //다음은 정보 손실로 자동형변환 불가!
      //float a = 100.0;
      //int b = 100.0f;

        //다음은 정보 손실x
        float a = (float)100.0;
        int b = (int)100.0F;

        //다음 처럼하면 소수점이하 손실
        int c = (int)100.1f;//100

    }

}
