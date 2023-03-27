package com.javatutorials.io;

//Scanner라는 녀석을 읽어온다.
import java.util.Scanner;

public class ScannerDemo {

    //숫자주면 숫자*1000함
    public static void main(String[] args)
    {
        //System.in은 사용자가 입력한 값이라고 생각하면 됨.
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i*1000);
        sc.close();

    }
}
