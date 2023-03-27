package com.javatutorials.condition;

public class LoginDemo {

    public static void main(String[] args)
    {
        //1)명령 프롬프트에서 java org~.LoginDemo 인자값(=args[0])을 준뒤,
        //right냐 wrong이냐 출력하는 간단한 프로그램.
        //2)rung configuration에서 Argument로 주면됨.
        String id = args[0];
        if(id.equals("egoing")){
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }

    }

}
