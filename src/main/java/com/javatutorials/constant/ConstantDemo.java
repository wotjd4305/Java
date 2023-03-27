package com.javatutorials.constant;

public class ConstantDemo {

    public static void main(String[] args)
    {
        //실수인 float=4, double=8
        //float a = 2.2;//(1)오류, 2.2는 double형을 기본형으로 이건 2.2F로 명시해야함.

        long a = 2147483648L;//넘어서니까 표시
        byte b = 100;//오류안남 100은 int형인데도-> 허용됨.

    }

}
